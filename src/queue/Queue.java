package queue;

import java.util.NoSuchElementException;

public class Queue {
	private Person[] queue;
	private final static int DEFAULT_SIZE = 5;
	private int head;
	private int tail;
	private int size;
	
	public Queue() {
		this(DEFAULT_SIZE);
	}
	
	public Queue(int size) {
		queue = new Person[size];
		this.head = -1;
		this.tail = -1;
	}
	
	public boolean isEmpty() {
		return this.head == -1 && this.tail == -1;
	}
	
	public boolean isFull() {
		return ((this.tail + 1) % this.queue.length) == this.head;
	}
	
	public void enqueue(Person person) {
		if (isFull()) {
			shiftLeft(0);
			this.queue[this.tail] = person;
		} else if (isEmpty()) {
			this.head++;
			this.tail++;
			this.size++;
			this.queue[this.tail] = person;
		} else {
			this.tail++;
			this.size++;
			this.queue[this.tail] = person;
		}
	}
	
	public Person dequeue() {
		if (isEmpty()) throw new NoSuchElementException();
		
		Person person = this.queue[head];
		shiftLeft(0);
		
		if (this.head == this.tail) {
			this.head = -1;
			this.tail = -1;
			this.size--;
		} else {
			this.tail--;
			this.size--;
			
		}
		
		return person;	
	}
	
	private void shiftLeft(int index) {
		for (int i = index; i < this.tail - 1; i++) {
			this.queue[i] = queue[i+1];
		}
	}
}
