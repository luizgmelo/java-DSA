package hashtable;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HashTableTest {

	@Test
	void testPut() {
		HashTable hashTable = new HashTable();
		// add
		hashTable.put("312.123.123-11", new Person("312.123.123-11", "Guilherme", 23));
		assertEquals(hashTable.get("312.123.123-11").getName(), "Guilherme");
		// update
		hashTable.put("312.123.123-11", new Person("312.123.123-11", "Guilherme Melo", 25));
		assertEquals(hashTable.get("312.123.123-11").getName(), "Guilherme Melo");
		// not null arraylist and add a new value
		hashTable.put("312.123.123-11", new Person("312.123.123-11", "Francisco", 45));
		assertEquals(hashTable.get("312.123.123-11").getName(), "Francisco");
	}

	
}
