package linkedlist;

import java.util.NoSuchElementException;

public class LinkedList {
	private Node head;
	private Node tail;
	private int size;
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public void addFirst(Person person) {
		Node newNode = new Node(person);
		
		if (isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.head.setPrev(newNode);
			newNode.setNext(this.head);
			this.head = newNode;
		}
		
		this.size++;
	}
	
	public void addLast(Person person) {
		Node newNode = new Node(person);
		
		if (isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.tail.setNext(newNode);
			newNode.setPrev(this.tail);
			this.tail = newNode;
		}
		
		this.size++;
	}
	
	public void add(int index, Person person) {
		if (index < 0 || index > this.size - 1) {
			throw new IndexOutOfBoundsException();
		}
		
		Node newNode = new Node(person);
		
		if (index == 0) {
			addFirst(person);
		} else if (index == this.size - 1) {
			addLast(person);
		} else {
			Node aux = this.head;
			for (int i = 0; i < index - 1; i++) {
				aux = this.head.getNext();
			}
			newNode.setNext(aux.getNext());
			newNode.setPrev(aux);
			aux.getNext().setPrev(newNode);
			aux.setNext(newNode);
			this.size++;
		}
	}
	
	public Person removeFirst() {
		if (isEmpty()) throw new NoSuchElementException();
		
		Person removed = this.head.getData();
		this.size--;
	
		if (this.head == this.tail) {
			this.head = null;
			this.tail = null;
			return removed;
		}
		
		this.head = this.head.getNext();
		this.head.setPrev(null);
		return removed;
	}
	
	public Person removeLast() {
		if (isEmpty()) throw new NoSuchElementException();
		
		Person removed = this.tail.getData();
		this.size--;
		
		if (this.head == this.tail) {
			this.head = null;
			this.tail = null;
			return removed;
		}
		
		this.tail = this.tail.getPrev();
		this.tail.setNext(null);
		return removed;
	}
	
	public Person remove(int index) {
		if (index < 0 || index >= this.size) throw new IndexOutOfBoundsException();
		
		if (index == 0) return removeFirst();
		if (index == this.size - 1) return removeLast();
		
		Node aux = this.head;
		// remove (take previous Removed)
		for (int i = 0; i < index - 1; i++) {
			aux = aux.getNext();
		}
		Person removed = aux.getNext().getData();
		aux.setNext(aux.getNext().getNext());
		// aux.next.prev = aux
		aux.getNext().setPrev(aux.getNext().getPrev());
		this.size--;
		return removed;
	}
	
	public boolean remove(Person person) {
		if (isEmpty()) return false;
		
		Node aux = this.head;
		for (int i = 0; i < this.size; i++) {
			if (aux.getData().equals(person)) {
				if (i == 0) removeFirst();
				else if (i == this.size - 1) removeLast();
				else {
					// remove per index different way (take removed)
					aux.getPrev().setNext(aux.getNext());
					aux.getNext().setPrev(aux.getPrev());
					this.size--;
				}
				return true;
			}
			aux = aux.getNext();
		}
		return false;
	}
	
	public Person get(int index) {
		if (index < 0 || index >= this.size) throw new IndexOutOfBoundsException();
		
		Node aux = this.head;
		for (int i = 0; i < index; i++) {
			aux = aux.getNext();
		}
		return aux.getData();
	}
	
	public int indexOf(Person person) {
		Node aux = this.head;
		int i = 0;
		
		while (aux != null) {
			if (aux.getData().getName().equalsIgnoreCase(person.getName())
					&& aux.getData().getAge() == person.getAge()) {
				return i;
			}
			
			aux = aux.getNext();
			i++;
		}
		
		return -1;
	}
	
	public boolean contains(Person person) {
		return indexOf(person) != -1;
	}
	
	public Person getFirst() {
		if (isEmpty()) return null;
		return this.head.getData();
	}
	
	public Person getLast() {
		if (isEmpty()) return null;
		return this.tail.getData();
	}
}
