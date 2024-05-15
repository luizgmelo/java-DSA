package hashtable;

import java.util.ArrayList;

public class HashTable {
	private ArrayList<Person>[] table;
	private static final int DEFAULT_SIZE = 9;

	public HashTable() {
		this.table = new ArrayList[DEFAULT_SIZE];
	}
	
	public HashTable(int capacity) {
		this.table = new ArrayList[capacity];
	}

	private int hash(String key) {
		key = key.replace("-", "").replace(".", "");
		return Integer.parseInt(key) % this.table.length;
	}
	
	// <TO-DO> Test to get
	public Person get(String key) {
		int hash = hash(key);
		ArrayList<Person> people = this.table[hash];
		
		if (people == null)
			return null;
		
		for (Person personCurrent : people) {
			if (personCurrent.getCpf().equals(key)) {
				return personCurrent;
			}
		}
		
		return null;
	}
	
	public void put(int key, Person value) {
		int hash = hash(key);
		ArrayList<Person> people = this.table[hash];
		
		if (people == null) {
			// <TO-DO> add new value
		}
		
		for (Person personCurrent : people) {
			if (personCurrent.getCpf().equals(key)) {
				// <TO-DO> update value already exist
			}
		}
		
		return null;
	} 
	
	public Person remove(int key) {
		int hash = hash(key);
		Person removed = this.get(key);
		this.table[key] = null;
		return removed;
	}	

}
