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
	
	public int hash(Integer key) {
		return key % this.table.length;
	}
	
	public Person get(Integer key) {
		int hash = hash(key);
		ArrayList<Person> people = this.table[hash];
		
		if (people == null)
			return null;
		
		for (Person personCurrent : people) {
			if (personCurrent.getMatricula().equals(key)) {
				return personCurrent;
			}
		}
		
		return null;
	}
	
	public void put(Integer key, Person value) {
		int hash = hash(key);
		ArrayList<Person> people = this.table[hash];
		
		if (people == null) {
			people = new ArrayList<Person>();
			people.add(value);
			this.table[hash] = people;
		} else {
			for (int i = 0; i < people.size(); i++) {
				if (people.get(i).getMatricula().equals(key)) {
					people.set(i, value);
					return;
				}
			}
			people.add(value);
		}
	} 
	
	public Person remove(Integer key) {
		int hash = hash(key);
		Person removed = this.get(key);
		this.table[hash] = null;
		return removed;
	}	

}
