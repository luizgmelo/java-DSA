package hashtable;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HashTableTest {

	@Test
	void testPut() {
		HashTable hashTable = new HashTable();
		// add
		hashTable.put(1203, new Person(1203, "Guilherme", 23));
		assertEquals(hashTable.get(1203).getName(), "Guilherme");
		// update
		hashTable.put(1203, new Person(1203, "Guilherme Melo", 25));
		assertEquals(hashTable.get(1203).getName(), "Guilherme Melo");
		// not null arraylist and add a new value
		hashTable.put(1999, new Person(1999, "Francisco", 45));
		assertEquals(hashTable.get(1999).getName(), "Francisco");
	}

	
}
