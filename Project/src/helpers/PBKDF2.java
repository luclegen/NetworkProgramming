package helpers;

import java.security.*;
import java.security.spec.*;
import java.util.*;
import java.util.regex.*;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public abstract class PBKDF2 {
  public static final String ID = "$31$";
  public static final int DEFAULT_COST = 16;
  private static final int SIZE = 128;
  private static final String ALGORITHM = "PBKDF2WithHmacSHA1";

  private static int iterations(int cost) {
    if ((cost < 0) || (cost > 30))
      throw new IllegalArgumentException("cost: " + cost);
    return 1 << cost;
  }

  private static byte[] getBytes(char[] password, byte[] salt, int iterations) {
    KeySpec spec = new PBEKeySpec(password, salt, iterations, SIZE);
    try {
      SecretKeyFactory f = SecretKeyFactory.getInstance(ALGORITHM);
      return f.generateSecret(spec).getEncoded();
    } catch (NoSuchAlgorithmException e) {
      throw new IllegalStateException("Missing algorithm: " + ALGORITHM, e);
    } catch (InvalidKeySpecException e) {
      throw new IllegalStateException("Invalid SecretKeyFactory", e);
    }
  }

  public static String hash(String password) {
    return hash(password, DEFAULT_COST);
  }

  public static String hash(String password, int cost) {
    iterations(cost);
    byte[] salt = new byte[SIZE / 8];
    new SecureRandom().nextBytes(salt);
    byte[] bytes = getBytes(password.toCharArray(), salt, 1 << cost);
    byte[] hash = new byte[salt.length + bytes.length];
    System.arraycopy(salt, 0, hash, 0, salt.length);
    System.arraycopy(bytes, 0, hash, salt.length, bytes.length);
    Base64.Encoder enc = Base64.getUrlEncoder().withoutPadding();
    return ID + cost + '$' + enc.encodeToString(hash);
  }

  public static boolean compareSync(String password, String token) {
    Matcher matcher = Pattern.compile("\\$31\\$(\\d\\d?)\\$(.{43})").matcher(token);
    if (!matcher.matches())
      if (!token.matches("\\$31\\$(\\d\\d?)\\$(.{43})"))
        throw new IllegalArgumentException("Invalid token format");
    int iterations = iterations(Integer.parseInt(matcher.group(1)));
    byte[] hash = Base64.getUrlDecoder().decode(matcher.group(2));
    byte[] salt = Arrays.copyOfRange(hash, 0, SIZE / 8);
    byte[] check = getBytes(password.toCharArray(), salt, iterations);
    int zero = 0;
    for (int idx = 0; idx < check.length; ++idx)
      zero |= hash[salt.length + idx] ^ check[idx];
    return zero == 0;
  }
}
