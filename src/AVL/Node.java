package AVL;

public class Node {
	public int value;
	public int height;
	
	public Node left;
	public Node right;
	public Node parent;

	
	public Node(int value) {
		this.value = value;
	}
	
	public int height() {
		if (this.left == null && this.right == null)	return 0;
		
		if (this.left != null && this.right == null) {
			return 1 + this.left.height();
		} else if (this.left == null && this.right != null) {
			return 1 + this.right.height();
		} else {
			return 1 + Math.max(this.left.height(), this.right.height());
		}
	}
	
	private int balance() {
		int left = this.left == null ? 0 : this.left.height();
		int right = this.right == null ? 0 : this.right.height();
		return left - right;
	}
	
	public boolean isLeftPending() {
		return this.balance() == 1;
	}
	
	public boolean isRightPending() {
		return this.balance() == -1;
	}
	
	public boolean isBalanced() {
		return this.balance() == 0;
	}
	
	public boolean isUnbalanced() {
		return this.balance() <= -2 || this.balance() >= 2;
	}
	
}
