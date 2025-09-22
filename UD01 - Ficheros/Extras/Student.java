package ficheros;

import java.util.Objects;

public class Student {

	private int id;
	private String name;
	private String surname;
	private String asignature;

	public Student(int id, String name, String surname, String asignature) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.asignature = asignature;
	}

	@Override
	public int hashCode() {
		return Objects.hash(asignature, id, name, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(asignature, other.asignature) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(surname, other.surname);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", surname=" + surname + ", asignature=" + asignature + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAsignature() {
		return asignature;
	}

	public void setAsignature(String asignature) {
		this.asignature = asignature;
	}

}
