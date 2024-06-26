package linkedlist;

public class Node {
	private Person data;
	private Node next;
	private Node prev;
	
	public Node(Person data) {
		this.data = data;
	}

	public Person getData() {
		return data;
	}

	public void setData(Person data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}
	
}
