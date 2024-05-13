package linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListTest {

	@Test
	void testIsEmpty() {
		LinkedList myList = new LinkedList();
		assertTrue(myList.isEmpty());
	}
	
	@Test
	void testAddLast() {
		LinkedList myList = new LinkedList();
		assertTrue(myList.isEmpty());
		myList.addLast(new Person("João", 18));
		assertEquals(myList.getFirst().getData().getName(), "João");
		assertEquals(myList.getLast().getData().getName(), "João");
		assertFalse(myList.isEmpty());
		
		myList.addLast(new Person("Maria", 23));		
		myList.addLast(new Person("Junior", 19));
		myList.addLast(new Person("Paulo", 54));
		myList.addLast(new Person("Marcelo", 62));
		assertEquals(myList.getFirst().getData().getName(), "João");
		assertEquals(myList.getLast().getData().getName(), "Marcelo");
		assertFalse(myList.isEmpty());
	}
	
	@Test
	void testAddFirst() {
		LinkedList myList = new LinkedList();
		myList.addFirst(new Person("Maria", 23));
		assertEquals(myList.getFirst().getData().getName(), "Maria");
		assertEquals(myList.getLast().getData().getName(), "Maria");
		
		myList.addFirst(new Person("Pedro", 17));
		myList.addFirst(new Person("Lucas", 42));
		myList.addFirst(new Person("Mario", 62));
		myList.addFirst(new Person("Fernando", 58));
		assertEquals(myList.getFirst().getData().getName(), "Fernando");
		assertEquals(myList.getLast().getData().getName(), "Maria");
		assertFalse(myList.isEmpty());
	}
	
	@Test
	void testAdd() {
		LinkedList myList = new LinkedList();
		// maria -> lucas
		myList.addFirst(new Person("Maria", 23));
		myList.addLast(new Person("Lucas", 42));
		
		// add last maria <-> lucas <-> mario
		myList.add(1, new Person("Mario", 62));
		assertEquals(myList.getLast().getData().getName(), "Mario");
		assertEquals(myList.getLast().getNext(), null);
		assertEquals(myList.getLast().getPrev().getData().getName(), "Lucas");
		
		//add first pedro <-> maria <-> lucas <-> mario
		myList.add(0, new Person("Pedro", 63));
		assertEquals(myList.getFirst().getData().getName(), "Pedro");
		assertEquals(myList.getFirst().getNext().getData().getName(), "Maria");
				
		// add in middle pedro <-> breno <-> maria <-> lucas <-> mario
		myList.add(1, new Person("Breno", 35));
		assertEquals(myList.getFirst().getNext().getData().getName(), "Breno");
		// pedro <-> raquel <-> breno <-> maria <-> lucas <-> mario
		myList.add(1, new Person("Raquel", 21));
		assertEquals(myList.getFirst().getNext().getData().getName(), "Raquel");
		assertEquals(myList.getFirst().getNext().getPrev().getData().getName(), "Pedro");
		assertEquals(myList.getFirst().getNext().getNext().getData().getName(), "Breno");
	}
}
