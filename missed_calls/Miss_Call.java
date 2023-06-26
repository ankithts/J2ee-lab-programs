package missed_calls;

class Miss_Call {
	long number;
	String name;

	Miss_Call(long number, String name) {
		this.number = number;
		this.name = name;
	}

	void display() {
		System.out.println("Number: " + number + " Name: " + name);
	}
}
