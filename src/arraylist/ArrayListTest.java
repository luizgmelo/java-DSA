package arraylist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayListTest {
	@Test
	void testBooleanAdd() {
		ArrayList array = new ArrayList();
		array.add(2);
		array.add(4);
		array.add(8);
		assertEquals(array.getSize(), 3);
	}
	
	@Test
	void testGet() {
		ArrayList array = new ArrayList();
		array.add(2);
		array.add(4);
		array.add(8);
		assertEquals(array.get(0), 2);
		assertEquals(array.get(1), 4);
		assertEquals(array.get(2), 8);
	}
	
	@Test
	void testVoidAdd() {
		ArrayList array = new ArrayList(5);
		array.add(0, 3);
		array.add(1, 5);
		array.add(2, 8);
		
		array.add(0, 10);
		
		assertEquals(array.getSize(), 4);
		
		assertEquals(array.get(0), 10);
		assertEquals(array.get(1), 3);
		assertEquals(array.get(3), 8);
	}
	
	@Test
	void testSet() {
		ArrayList array = new ArrayList(5);
		array.add(2);
		array.add(4);
		array.add(8);
		
		array.set(0, 3);
		array.set(1, 5);
		array.set(2, 23);
		
		assertEquals(array.getSize(), 3);
		
		assertEquals(array.get(0), 3);
		assertEquals(array.get(1), 5);
		assertEquals(array.get(2), 23);
	}

}
