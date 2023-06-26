package student_swings;

public class Student {
	String name, usn, address, category;
	int age;
	float cgpa;

	public Student(String name, String usn, String address, String cat, int age, float cgpa) {
		this.name = name;
		this.usn = usn;
		this.address = address;
		this.category = cat;
		this.age = age;
		this.cgpa = cgpa;
	}

	public String toString() {
		String stud = name + " " + usn + " residing in " + address + " belonging to category " + category + " of age "+ age;
		stud += "has cgpa " + cgpa;
		return stud;
	}
}
