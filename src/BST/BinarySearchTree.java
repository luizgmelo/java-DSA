package BST;

import java.util.Deque;
import java.util.LinkedList;

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
	
	public Node successor(Node node) {
		if (node == null) return null;
		
		if (node.right != null)
			return this.min(node.right);
		else {
			Node aux = node.parent;
			
			while (aux != null && aux.value < node.value) {
				aux = aux.parent;
			}
			
			return aux;
		}
	}
	
	public Node predecessor(Node node) {
		if (node == null) return null;
		
		if (node.left != null) {
			return max(node.left);
		} else {
			Node aux = node.parent;
			
			while (aux != null && aux.value > node.value) {
				aux = aux.parent;
			}
			
			return aux;
		}
	}
	
	public int height() {
		return this.height(this.root);
	}
	
	private int height(Node node) {
		if (node == null) return -1;
		return 1 + Math.max(height(node.left), height(node.right));
	}
	
	public void remove(Node toRemove) {
		// Case 1: Is Leaf
		if (toRemove.isLeaf()) {
			if (toRemove == this.root) {
				this.root = null;
			} else {
				if (toRemove.parent.value > toRemove.value) {
					toRemove.parent.left = null;
				} else {
					toRemove.parent.right = null;
				}
			}
		}
		// Case 2: Has Only Child
		if (toRemove.hasOnlyLeftChild()) {
			if (toRemove == this.root) {
				this.root = toRemove.left;
				this.root.parent = null;
			} else {
				toRemove.left.parent = toRemove.parent;
				if (toRemove.parent.value > toRemove.value) {
					toRemove.parent.left = toRemove.left;
				} else {
					toRemove.parent.right = toRemove.left;
				}
			}
		}
		
		if (toRemove.hasOnlyRightChild()) {
			if (toRemove == this.root) {
				this.root = this.root.right;
				this.root.parent = null;
			} else {
				toRemove.right.parent = toRemove.parent;
				if (toRemove.parent.value > toRemove.value) {
					toRemove.parent.left = toRemove.right;
				} else {
					toRemove.parent.right = toRemove.right;
				}
			}
		}
		
		// Case 3: Has Two Child
		if (toRemove.hasTwoChild()) {
			Node sucessor = this.successor(toRemove);
			toRemove.value = sucessor.value;
			remove(sucessor);
		}
		
	}
	
	public void preOrder() {
		preOrder(this.root);
	}
	
	private void preOrder(Node node) {
		if (node != null) {
			System.out.println(node.value);
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	public void inOrder() {
		inOrder(this.root);
	}
	
	private void inOrder(Node node) {
		if (node != null) {
			inOrder(node.left);
			System.out.println(node.value);
			inOrder(node.right);
		}
	}
	
	public void postOrder() {
		postOrder(this.root);
	}
	
	private void postOrder(Node node) {
		if (node != null) {
			postOrder(node.left);
			System.out.println(node.value);
			postOrder(node.right);
		}
	}

	public void printBFS() {
		Deque<Node> queue = new LinkedList<Node>();
		
		if (!isEmpty()) {
			queue.addLast(this.root);
			while (!queue.isEmpty()) {
				Node current = queue.removeFirst();
				
				System.out.println(current);
				
				if (current.left != null)
					queue.addLast(current.left);;
				if (current.right != null)
					queue.addLast(current.right);
			}
		}
	}
	
}
