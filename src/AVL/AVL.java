package AVL;

public class AVL {
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
					Node newNode = new Node(element);
					aux.left = newNode;
					aux.left.parent = aux;
					
					Node unbalanced = checkUnbalanced(newNode);
					if (unbalanced != null) callBestRotation(unbalanced);
					
					return;
				}
				aux = aux.left;
			} else {
				if (aux.right == null) {
					Node newNode = new Node(element);
					aux.right = newNode;
					aux.right.parent = aux;
					
					Node unbalanced = checkUnbalanced(newNode);
					if (unbalanced != null) callBestRotation(unbalanced);
					
					return;
				}
				aux = aux.right;
			}
		}
		
		
	}
}
