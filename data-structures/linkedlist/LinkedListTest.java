package linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

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
		assertEquals(myList.getFirst().getName(), "João");
		assertEquals(myList.getLast().getName(), "João");
		assertFalse(myList.isEmpty());
		
		myList.addLast(new Person("Maria", 23));		
		myList.addLast(new Person("Junior", 19));
		myList.addLast(new Person("Paulo", 54));
		myList.addLast(new Person("Marcelo", 62));
		assertEquals(myList.getFirst().getName(), "João");
		assertEquals(myList.getLast().getName(), "Marcelo");
		assertFalse(myList.isEmpty());
	}
	
	@Test
	void testAddFirst() {
		LinkedList myList = new LinkedList();
		myList.addFirst(new Person("Maria", 23));
		assertEquals(myList.getFirst().getName(), "Maria");
		assertEquals(myList.getLast().getName(), "Maria");
		
		myList.addFirst(new Person("Pedro", 17));
		myList.addFirst(new Person("Lucas", 42));
		myList.addFirst(new Person("Mario", 62));
		myList.addFirst(new Person("Fernando", 58));
		assertEquals(myList.getFirst().getName(), "Fernando");
		assertEquals(myList.getLast().getName(), "Maria");
		assertFalse(myList.isEmpty());
	}
	
	@Test
	void testGet() {
		LinkedList myList = new LinkedList();
		myList.addLast(new Person("Marina", 19));
		myList.addLast(new Person("Aroldo", 24));
		myList.addLast(new Person("Godofredo", 32));
		
		assertEquals(myList.get(0).getName(), "Marina");
		assertEquals(myList.get(1).getName(), "Aroldo");
		assertEquals(myList.get(2).getName(), "Godofredo");
	}
	
	@Test
	void testAdd() {
		LinkedList myList = new LinkedList();
		// maria -> lucas
		myList.addFirst(new Person("Maria", 23));
		myList.addLast(new Person("Lucas", 42));
		
		// add last maria <-> lucas <-> mario
		myList.add(1, new Person("Mario", 62));
		assertEquals(myList.getLast().getName(), "Mario");
		
		//add first pedro <-> maria <-> lucas <-> mario
		myList.add(0, new Person("Pedro", 63));
		assertEquals(myList.getFirst().getName(), "Pedro");
				
		// add in middle pedro <-> breno <-> maria <-> lucas <-> mario
		myList.add(1, new Person("Breno", 35));
		assertEquals(myList.get(1).getName(), "Breno");
		
		// pedro <-> raquel <-> breno <-> maria <-> lucas <-> mario
		myList.add(1, new Person("Raquel", 21));
		assertEquals(myList.get(1).getName(), "Raquel");;
		assertEquals(myList.getFirst().getName(), "Pedro");
		assertEquals(myList.get(2).getName(), "Breno");;
	}
	
	@Test
	void testIndexOf() {
		LinkedList myList = new LinkedList();
		myList.addLast(new Person("Maria", 23));		
		myList.addLast(new Person("Junior", 19));
		myList.addLast(new Person("Paulo", 54));
		
		// indexOf by name(ignoreCase) and age
		assertEquals(myList.indexOf(new Person("Maria", 23)), 0);
		assertEquals(myList.indexOf(new Person("MARIA", 23)), 0);
		assertEquals(myList.indexOf(new Person("Junior", 19)), 1);
		assertEquals(myList.indexOf(new Person("juNioR", 19)), 1);
		assertEquals(myList.indexOf(new Person("Paulo", 54)), 2);
		
		// wrongs ages
		assertEquals(myList.indexOf(new Person("Junior", 72)), -1);
		assertEquals(myList.indexOf(new Person("Paulo", 99)), -1);
		// wrongs name and ages
		assertEquals(myList.indexOf(new Person("Roberto", 62)), -1);
		assertEquals(myList.indexOf(new Person("Jailson", 42)), -1);
	}
	
	@Test
	void testContains() {
		LinkedList myList = new LinkedList();
		myList.addLast(new Person("Maria", 23));		
		myList.addLast(new Person("Junior", 19));
		myList.addLast(new Person("Paulo", 54));
		
		// contains by name(ignoreCase) and age
		assertTrue(myList.contains(new Person("Maria", 23)));
		assertTrue(myList.contains(new Person("junior", 19)));
		assertTrue(myList.contains(new Person("pauLo", 54)));
		// wrong age
		assertFalse(myList.contains(new Person("Maria", 42)));
		// wrong name
		assertFalse(myList.contains(new Person("Mariaaa", 23)));
		// wrong name and age
		assertFalse(myList.contains(new Person("Roberto", 62)));
	}
	
	@Test
	void testRemoveFirst() {
		LinkedList myList = new LinkedList();
		myList.addLast(new Person("Maria", 23));		
		myList.addLast(new Person("Junior", 19));
		myList.addLast(new Person("Paulo", 54));
		
		assertEquals(myList.removeFirst().getName(), "Maria");
		assertEquals(myList.removeFirst().getName(), "Junior");
		assertEquals(myList.removeFirst().getName(), "Paulo");
		assertTrue(myList.isEmpty());
		
		assertThrows(NoSuchElementException.class, () -> myList.removeFirst());
	}
	
	@Test
	void testRemoveLast() {
		LinkedList myList = new LinkedList();
		myList.addLast(new Person("Maria", 23));		
		myList.addLast(new Person("Junior", 19));
		myList.addLast(new Person("Paulo", 54));
		
		assertEquals(myList.removeLast().getName(), "Paulo");
		assertEquals(myList.removeLast().getName(), "Junior");
		assertEquals(myList.removeLast().getName(), "Maria");
		assertTrue(myList.isEmpty());
		
		assertThrows(NoSuchElementException.class, () -> myList.removeLast());
	}
	
	@Test
	void testRemove() {
		LinkedList myList = new LinkedList();
		myList.addLast(new Person("Maria", 23));		
		myList.addLast(new Person("Junior", 19));
		myList.addLast(new Person("Paulo", 54));
		
		assertEquals(myList.remove(2).getName(), "Paulo");
		assertEquals(myList.remove(1).getName(), "Junior");
		assertEquals(myList.remove(0).getName(), "Maria");
		assertTrue(myList.isEmpty());
		
		assertThrows(IndexOutOfBoundsException.class, () -> myList.remove(3));
	}
	
	@Test
	void testRemoveBool() {
		LinkedList myList = new LinkedList();
		myList.addLast(new Person("Maria", 23));		
		myList.addLast(new Person("Junior", 19));
		myList.addLast(new Person("Paulo", 54));
		
		// wrong memory
		assertFalse(myList.remove(new Person("Maria", 23)));
		assertFalse(myList.remove(new Person("Junior", 19)));
		assertFalse(myList.remove(new Person("Paulo", 54)));
		assertFalse(myList.isEmpty());
		
		// sucess removes
		assertTrue(myList.remove(myList.get(1))); // junior removed
		assertTrue(myList.remove(myList.get(1))); // paulo removed
		assertTrue(myList.remove(myList.get(0))); // maria removed
		assertTrue(myList.isEmpty());	
	}
}
