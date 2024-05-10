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
	
	public boolean add(Integer data) {
		makeSureCapacity(this.size + 1);
		this.list[this.size++] = data;
		return true;
	}
	
	public void add(int index, Integer data) {
		if (index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException();	
		}
	
		makeSureCapacity(this.size + 1);
		
		shiftToRight(index);
		
		this.list[index] = data;
		this.size++;
	}
	
	public void set(int index, Integer data) {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		this.list[index] = data;
	}
	
	private void makeSureCapacity(int newCapacity) {
		if (newCapacity > this.list.length) {
			resize(this.list.length * 2);
		}
	}

	private void resize(int newCapacity) {
		Integer[] newList = new Integer[newCapacity];
		for (int i = 0; i < this.list.length; i++) {
			newList[i] = this.list[i];
		}
		this.list = newList;
	}
		
	private void shiftToRight(int index) {
		for (int i = this.size; i > index; i--) {
			this.list[i] = this.list[i-1];
		}
	}
	
	public Integer remove(int index) {
		if (index < 0 || index >= this.size) {
			return null;
		}
		
		Integer integer = this.get(index);
		
		shiftToLeft(index);
		this.size--;
		
		return integer;
	}
	
	public boolean remove(Integer data) {
		if (data == null) return false;
		
		for (int i = 0; i < this.size; i++) {
			if (this.list[i].equals(data)) {
				shiftToLeft(i);
				this.size--;
				return true;
			}
		}
		
		return false;
	}
	
	private void shiftToLeft(int index) {
		for (int i = index; i < this.size; i++) {
			this.list[i] = this.list[i+1];
		}
	}
	
	public Integer get(int index) {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		return list[index];
	}
	
	public int indexOf(Integer data) {
		for (int i = 0; i < this.size; i++) {
			if (this.list[i] == data) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean contains(Integer data) {
		return indexOf(data) != -1;
	}

	public int getSize() {
		return size;
	}
}
