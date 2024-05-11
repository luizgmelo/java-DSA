package stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackTest {
	
	@Test
	void testIsEmpty() {
		Stack stack = new Stack();
		assertTrue(stack.isEmpty());
	}

	@Test
	void testStack() {
		Stack stack = new Stack();
		assertTrue(stack.isEmpty());
		stack.push("a");
		assertFalse(stack.isEmpty());
		assertEquals("a", stack.peek());
		stack.pop();
		assertTrue(stack.isEmpty());
		stack.push("b");
		stack.push("c");
		stack.push("d");
		assertFalse(stack.isEmpty());
		assertEquals("d", stack.peek());
		stack.pop();
		stack.pop();
		stack.pop();
		assertTrue(stack.isEmpty());
		stack.push("e");
		stack.push("f");
		assertFalse(stack.isEmpty());
		assertEquals("f", stack.peek());
			
	}

}
