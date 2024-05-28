package BST;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

	@Test
	void testRemove() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(23);
		bst.add(15);
		bst.add(27);
		bst.add(4);
		bst.add(25);
		bst.add(39);
		bst.add(1);
		bst.add(8);
		bst.add(24);
		bst.add(26);
		bst.add(44);
		
		ArrayList<Integer> expectedBFS = new ArrayList<Integer>();
		expectedBFS.add(23);
		expectedBFS.add(15);
		expectedBFS.add(27);
		expectedBFS.add(4);
		expectedBFS.add(25);
		expectedBFS.add(39);
		expectedBFS.add(1);
		expectedBFS.add(8);
		expectedBFS.add(24);
		expectedBFS.add(26);
		expectedBFS.add(44);
		
		assertEquals(expectedBFS, bst.bfs());
		
		// Remove a Leaf
		bst.remove(26);
		
		expectedBFS = new ArrayList<Integer>();
		expectedBFS.add(23);
		expectedBFS.add(15);
		expectedBFS.add(27);
		expectedBFS.add(4);
		expectedBFS.add(25);
		expectedBFS.add(39);
		expectedBFS.add(1);
		expectedBFS.add(8);
		expectedBFS.add(24);
		expectedBFS.add(44);
		
		assertEquals(expectedBFS, bst.bfs());
		
		// Remove OnlyOneChildLeft
		bst.remove(25);
		
		expectedBFS = new ArrayList<Integer>();
		expectedBFS.add(23);
		expectedBFS.add(15);
		expectedBFS.add(27);
		expectedBFS.add(4);
		expectedBFS.add(24);
		expectedBFS.add(39);
		expectedBFS.add(1);
		expectedBFS.add(8);
		expectedBFS.add(44);
		
		assertEquals(expectedBFS, bst.bfs());
		
		// Remove OnlyOneChildRight
		bst.remove(39);
		
		expectedBFS = new ArrayList<Integer>();
		expectedBFS.add(23);
		expectedBFS.add(15);
		expectedBFS.add(27);
		expectedBFS.add(4);
		expectedBFS.add(24);
		expectedBFS.add(44);
		expectedBFS.add(1);
		expectedBFS.add(8);
		
		
		assertEquals(expectedBFS, bst.bfs());
		
		// Remove TwoChild
		bst.remove(23);
		
		expectedBFS = new ArrayList<Integer>();
		expectedBFS.add(24);
		expectedBFS.add(15);
		expectedBFS.add(27);
		expectedBFS.add(4);
		expectedBFS.add(44);
		expectedBFS.add(1);
		expectedBFS.add(8);
		
		
		assertEquals(expectedBFS, bst.bfs());
		
		bst.remove(4);
		
		expectedBFS = new ArrayList<Integer>();
		expectedBFS.add(24);
		expectedBFS.add(15);
		expectedBFS.add(27);
		expectedBFS.add(8);
		expectedBFS.add(44);
		expectedBFS.add(1);
		
		
		assertEquals(expectedBFS, bst.bfs());
		
		
		
	}

}
