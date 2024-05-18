package BST;

public class BinarySearchTree {
	private Node root;
	private int size;
	
	public boolean isEmpty() {
		return this.root == null;
	}
	
	public void add(int element) {
		
		this.size++;
		
		if (isEmpty()) {
			this.root = new Node(element);
			return;
		}

		Node aux = this.root;
		
		while (aux != null) {
			if (aux.value > element) {
				if (aux.left == null) {
					aux.left = new Node(element);
					aux.parent = aux;
					return;
				}
				aux = aux.left;
			} else {
				if (aux.right == null) {
					aux.right = new Node(element);
					aux.parent = aux;
					return;
				}
				aux = aux.right;
			}
		}		
	}
	
	public Node search(int element) {
		Node aux = this.root;
		
		while (aux != null) {
			if (aux.value == element)	return aux;
			if (aux.value > element)	aux = aux.left;
			if (aux.value < element)	aux = aux.right;		
		}
		
		return null;
	}
	
	// min for root
	public Node min() {
		if (isEmpty()) return null;
		return min(this.root);	
	}
	
	public Node min(Node node) {
		Node aux = node;
		
		while (aux.left != null)
			aux = aux.left;
			
		return aux;	
	}
	
	// max for root
	public Node max() {
		if (isEmpty()) return null;
		return max(this.root);
	}
	
	public Node max(Node node) {
		Node aux = node;
		
		while (aux.right != null)
			aux = aux.right;

		return aux;
	}
	
}
