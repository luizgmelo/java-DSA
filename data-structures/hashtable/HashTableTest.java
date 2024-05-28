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
	
	@Test
	void testRemove() {
		HashTable hashTable = new HashTable();
		hashTable.put("111.111.111-11", new Person("111.111.111-11", "Marina Fernandez", 27));
		hashTable.put("312.123.123-11", new Person("312.123.123-11", "Francisco Almeida", 45));
		hashTable.put("912.123.845-23", new Person("912.123.845-23", "Roberto Silva", 68));
		hashTable.put("222.222.222-22", new Person("222.222.222-22", "Marivandro Alves", 29));
		hashTable.put("333.333.333-33", new Person("333.333.333-33", "Lucas Oliveira", 26));
		
		// remove person exist in table
		assertEquals(hashTable.remove("312.123.123-11").getName(), "Francisco Almeida");
		assertEquals(hashTable.remove("912.123.845-23").getName(), "Roberto Silva");
		assertEquals(hashTable.remove("333.333.333-33").getName(), "Lucas Oliveira");
		assertEquals(hashTable.get("312.123.123-11"), null);
		assertEquals(hashTable.get("912.123.845-23"), null);
		assertEquals(hashTable.get("333.333.333-33"), null);
		
		// remove person not exist in table
		assertEquals(hashTable.remove("999.999.999-99"), null);
	}

	
}
