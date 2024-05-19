package heap;

import java.util.NoSuchElementException;

public class Heap {
	private int[] heap;
	private int tail;
	
	public Heap(int capacity) {
		this.heap = new int[capacity];
		this.tail = -1;
		buildHeap();
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
	
	// also called extractMax()
	public int remove() {
		if (isEmpty()) throw new NoSuchElementException("Empty");
		
		int element = this.heap[0];
		this.heap[0] = this.heap[this.tail];
		this.tail--;
		
		this.heapify(0);
		
		return element;
	}
	
	private void heapify(int index) {
		if (isLeaf(index) || !isValidIndex(index))
			return;
		
		// compare current, left, right and find the max
		int indexMax = indexMax(index, left(index), right(index));
		
		// swap current with max
		if (indexMax != index) {
			swap(indexMax, index);
			heapify(indexMax);
		}
	}
	
	private boolean isLeaf(int index) {
		return index > parent(tail) && index <= tail;
	}
	
	private boolean isValidIndex(int index) {
		return index >= 0 && index <= tail;
	}

	private int indexMax(int index, int left, int right) {
		if (this.heap[index] > this.heap[left]) {
			if (isValidIndex(right))
				if (this.heap[index] < this.heap[right])
					return right;
			return index;
		} else {
			if (isValidIndex(right))
				if (this.heap[left] < this.heap[right])
					return right;
			return left;
		}
	}
	
	private void swap(int i, int j) {
		int aux = this.heap[i];
		this.heap[i] = this.heap[j];
		this.heap[j] = aux;	
	}
	
	private void buildHeap() {
		for (int i = parent(this.tail); i >= 0; i--)
			heapify(i);
	}
	
	
}
