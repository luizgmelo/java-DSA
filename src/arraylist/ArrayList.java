package arraylist;

public class ArrayList {
	private Integer[] list;
	private static final int DEFAULT_SIZE = 20;
	private int size;
	
	public ArrayList() {
		this(DEFAULT_SIZE);
	}
	
	public ArrayList(int capacidade) {
		this.list = new Integer[capacidade];
		this.size = 0;
	}
	
}
