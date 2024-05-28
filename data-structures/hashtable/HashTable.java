package hashtable;

import java.util.ArrayList;
import java.util.Iterator;

public class HashTable {
	private ArrayList<Person>[] table;
	private static final int DEFAULT_SIZE = 9;

	public HashTable() {
		this.table = new ArrayList[DEFAULT_SIZE];
	}
	
	public HashTable(int capacity) {
		this.table = new ArrayList[capacity];
	}
	
	public int hash(String key) {
		return Math.abs(key.hashCode() % this.table.length);
	}
	
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
	
	public void put(String key, Person value) {
		int hash = hash(key);
		ArrayList<Person> people = this.table[hash];
		
		if (people == null) {
			people = new ArrayList<Person>();
			people.add(value);
			this.table[hash] = people;
		} else {
			for (int i = 0; i < people.size(); i++) {
				if (people.get(i).getCpf().equals(key)) {
					people.set(i, value);
					return;
				}
			}
			people.add(value);
		}
	} 
	
	public Person remove(String key) {
		int hash = hash(key);
		ArrayList<Person> people = this.table[hash];
		
		if (people == null)
			return null;
		
		Iterator<Person> iteratorPerson = people.iterator();
		Person current = null;
		
		while (iteratorPerson.hasNext()) {
			current = iteratorPerson.next();
			if (current.getCpf().equals(key)) {
				iteratorPerson.remove();
				return current;
			}
		}

		return current;
	}	

}
