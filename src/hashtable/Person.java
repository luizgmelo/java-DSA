package hashtable;

public class Person {
	private String cpf;
	private String name;
	private int age;
	
	public Person(String cpf, String name, int age) {
		this.cpf = cpf;
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getCpf() {
		return cpf;
	}
}
