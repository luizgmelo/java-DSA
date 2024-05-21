package AVL;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class AVLTest {

	@Test
	void testAdd() {
		AVL avl = new AVL();
		avl.add(10);
		avl.add(8);
		avl.add(5);
		//right rotate
		ArrayList<Integer> expectedBFS = new ArrayList<>(Arrays.asList(8, 5, 10));
		assertEquals(expectedBFS, avl.bfs());
		
		avl.add(15);
		avl.add(20);
		//left rotate
		expectedBFS = new ArrayList<>(Arrays.asList(8, 5, 15, 10, 20));
		assertEquals(expectedBFS, avl.bfs());
		
		//right left
		avl = new AVL();
		avl.add(10);
		avl.add(8);
		avl.add(9);
		expectedBFS = new ArrayList<>(Arrays.asList(9, 8, 10));
		assertEquals(expectedBFS, avl.bfs());
		
		//left right
		avl = new AVL();
		avl.add(10);
		avl.add(20);
		avl.add(15);
		expectedBFS = new ArrayList<>(Arrays.asList(15, 10, 20));
		assertEquals(expectedBFS, avl.bfs());
	}

}
