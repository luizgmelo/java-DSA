package stack;

import java.util.NoSuchElementException;

public class Stack {
	private String[] stack;
	private int top;
	private final static int DEFAULT_SIZE = 5;
		
	public Stack() {
		this(DEFAULT_SIZE);
	}

	public Stack(int size) {
		stack = new String[size];
		top = -1;
	}
	
	public boolean isEmpty() {
		return this.top == -1;
	}
	
	public boolean isFull() {
		return this.top == stack.length - 1;
	}
	
	public void push(String data) {
		if (isFull())
			throw new RuntimeException("Pilha Cheia");
		stack[++top] = data;
	}
	
	public String pop() {
		if (this.isEmpty()) {
			throw new RuntimeException("Pilha Vazia");
		}
		String removed = stack[top--];
		return removed;
	}
	
	public String peek() {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		return this.stack[this.top];
	}
	
}
