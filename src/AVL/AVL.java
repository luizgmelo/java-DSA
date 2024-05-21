package AVL;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

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
	
	
	public Node checkUnbalanced(Node node) {
		Node aux = node;
		
		while (aux != null) {
			if (!aux.isBalanced()) {
				return aux;
			} else if (aux.parent != null) {
				aux = aux.parent;
			} else {
				break;
			}
		}
		
		return null;
	}
	
	public void callBestRotation(Node unbalanced) {
		Node x = unbalanced;
		
		if (x.isLeftPending()) {
			Node y = x.left;
			if (y.left != null) rotateRight(x);
			else {
				rotateLeft(y); rotateRight(x);
			}
		}
		
		if (x.isRightPending()) {
			Node y = x.right;
			if (y.right != null) rotateLeft(x);
			else {
				rotateRight(y); rotateLeft(x);
			}
		}
	}
	
	public void rotateRight(Node node) {
		Node newRoot = node.left;
		newRoot.parent = node.parent;
		
		node.left = newRoot.right;
		newRoot.right = node;
		
		node.parent = newRoot;
		
		if (newRoot.parent != null) {
			if (newRoot.parent.left == node) {
				newRoot.parent.left = newRoot;
			} else {
				newRoot.parent.right = newRoot;
			}
		} else {
			this.root = newRoot;
		}
	}
	
	public void rotateLeft(Node node) {
		Node newRoot = node.right;
		newRoot.parent = node.parent;
		
		node.right = newRoot.left;
		newRoot.left = node;
		
		node.parent = newRoot;
		
		if (newRoot.parent != null) {
			if (newRoot.parent.left == node) {
				newRoot.parent.left = newRoot;
			} else {
				newRoot.parent.right = newRoot;
			}
		} else {
			this.root = newRoot;
		}
	}
	
	public ArrayList<Integer> bfs() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Deque<Node> queue = new LinkedList<Node>();
		
		if (!isEmpty()) {
			queue.addLast(this.root);
			while (!queue.isEmpty()) {
				Node current = queue.removeFirst();
				
				list.add(current.value);
				
				if (current.left != null)
					queue.addLast(current.left);
				if (current.right != null)
					queue.addLast(current.right);
			}
		}
		
		return list;
	}
}
