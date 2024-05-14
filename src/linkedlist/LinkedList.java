package linkedlist;

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
