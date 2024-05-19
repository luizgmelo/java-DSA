package heap;

public class Heap {
	private int[] heap;
	private int tail;
	
	public Heap(int capacity) {
		this.heap = new int[capacity];
		this.tail = -1;
	}
	
	public boolean isEmpty() {
		return this.tail == -1;
	}
	
	public int left(int index) {
		return 2 * index + 1;
	}
	
	public int right(int index) {
		return 2 * (index + 1);
	}
	
	public int parent(int index) {
		return (index-1)/2;
	}
	
	private void resize() {
		int[] newHeap = new int[this.heap.length * 2];
		for (int i = 0; i < this.heap.length; i++) {
			newHeap[i] = this.heap[i];
		}
		this.heap = newHeap;
	}
	
	public void add(int n) {
		if (tail >= (heap.length - 1))
			resize();
		
		tail++;
		this.heap[tail] = n;
		
		int i = tail;
		while (i > 0 && this.heap[i] > this.heap[parent(i)]) {
			int temp = this.heap[i];
			this.heap[i] = this.heap[parent(i)];
			this.heap[parent(i)] = temp;
			i = parent(i);
		}
	}

	
	
	
}
