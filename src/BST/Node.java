package BST;

public class Node {
	public int value;
	public Node left;
	public Node right;
	public Node parent;
	
	public Node(int v) {
		value = v;
	}
	
	public boolean isLeaf() {
		return this.left == null && this.right == null;
	}
	
	public boolean hasOnlyLeftChild() {
		return this.left != null && this.right == null;
	}
	
	public boolean hasOnlyRightChild() {
		return this.left == null && this.right != null;
	}
	
	public boolean hasTwoChild() {
		return this.left != null && this.right != null;
	}
}
