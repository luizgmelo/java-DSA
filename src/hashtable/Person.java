package hashtable;

public class Person {
	private Integer matricula;
	private String name;
	private int age;
	
	public Person(Integer matricula, String name, int age) {
		this.matricula = matricula;
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Integer getMatricula() {
		return matricula;
	}
}
