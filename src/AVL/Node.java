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
	
	public int balance() {
		int left = this.left == null ? -1 : this.left.height();
		int right = this.right == null ? -1 : this.right.height();
		return left - right;
	}
	
	public boolean isLeftPending() {
		int left = this.left == null ? -1 : this.left.height();
		int right = this.right == null ? -1 : this.right.height();
		return left - right >= 1;
	}
	
	public boolean isRightPending() {
		int left = this.left == null ? -1 : this.left.height();
		int right = this.right == null ? -1 : this.right.height();
		return left - right <= -1;
	}
	
	public boolean isBalanced() {
		int left = this.left == null ? -1 : this.left.height();
		int right = this.right == null ? -1 : this.right.height();
		return left - right >= -1 && left - right <= 1;
	}
	
}
