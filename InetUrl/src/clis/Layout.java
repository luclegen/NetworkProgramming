package clis;

public class Layout {

	private int width;
	private String title = "No title";

	public Layout() {
	}

	public Layout(int width, String title) {
		this.width = width;
		this.title = title;
	}

	public void header(int level) {
		switch (level) {
			case 1:
				border('t', 2);
				title();
				break;

			case 2:
				border('t', 1);
				title();
				break;

			default:
				break;
		}
	}

	public void footer(int level) {
		switch (level) {
			case 1:
				border('b', 2);
				break;

			case 2:
				border('b', 1);
				break;

			default:
				break;
		}
	}

	public void border(char position, int type) {
		System.out.println();
		for (int i = 0; i < width; i++) {
			switch (type) {
				case 1:
					System.out.print("-");
					break;

				case 2:
					System.out.print("=");
					break;

				default:
					System.err.println("Sai loại viền");
					break;
			}
		}
		System.out.println();
		if (position == 'b')
			System.out.println();
	}

	public void title() {
		int space = (width - title.length()) / 2;
		for (int i = 0; i < space; i++)
			System.out.print(" ");
		System.out.println(title + "\n");
	}
}