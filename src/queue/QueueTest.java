package queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QueueTest {
	@Test
	void testIsEmpty() {
		Queue queue = new Queue();
		assertTrue(queue.isEmpty());
	}
	
	@Test
	void testIsFull() {
		Queue queue = new Queue();
		assertFalse(queue.isFull());
	}

	@Test
	void testEnqueue() {
		Queue queue = new Queue();
		assertTrue(queue.isEmpty());
		
		queue.enqueue(new Person("João", 18));
		queue.enqueue(new Person("Mario", 23));
		
		assertFalse(queue.isEmpty());
		assertFalse(queue.isFull());
		
		queue.enqueue(new Person("Romaro", 18));
		queue.enqueue(new Person("Bruno", 23));
		queue.enqueue(new Person("Cinderela", 18));
		
		assertTrue(queue.isFull());
		
		queue.enqueue(new Person("Rosangela", 18));
		
		assertTrue(queue.isFull());
		
	}
	
	@Test
	void testDequeue() {
		Queue queue = new Queue();
		assertTrue(queue.isEmpty());
		
		queue.enqueue(new Person("Romaro", 18));
		queue.enqueue(new Person("Bruno", 23));
		queue.enqueue(new Person("Cinderela", 18));
		
		assertFalse(queue.isEmpty());
		
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		
		assertTrue(queue.isEmpty());
	}
	
	
	@Test
	void testFIFO() {
		Queue queue = new Queue();
		assertTrue(queue.isEmpty());
		queue.enqueue(new Person("João", 18));
		assertFalse(queue.isEmpty());
		queue.dequeue();
		assertTrue(queue.isEmpty());
		queue.enqueue(new Person("Mario", 23));
		assertFalse(queue.isEmpty());
		queue.enqueue(new Person("Romaro", 17));
		queue.enqueue(new Person("Patricia", 43));
		queue.enqueue(new Person("Jucelino", 55));
		queue.enqueue(new Person("Mariano", 72));
		assertFalse(queue.isEmpty());
		assertTrue(queue.isFull());
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		assertTrue(queue.isEmpty());
	}
}
