package missed_calls;

import java.util.*;

public class Pgm_1 {
	public static void main(String[] args) {
		HashMap<Long, String> contacts = new HashMap<Long, String>();
		ArrayList<Miss_Call> missed_calls = new ArrayList<Miss_Call>();

		Scanner sc = new Scanner(System.in);
		
		System.out.println("List first 3 contacts");
		for (int i = 0; i < 3; i++) {
			System.out.print("Enter name: ");
			String name = sc.next();
			System.out.print("Enter number: ");
			long number = sc.nextLong();
			contacts.put(number, name);
		}
		
		
		System.out.println("Inital Contact List: ");
		System.out.println(contacts);
		
		
		for (int i = 0; i < 3; i++) {
			System.out.print("Type a number for miss call: ");
			long number = sc.nextLong();
			
			if (contacts.containsKey(number)) {
				Miss_Call ms = new Miss_Call(number, contacts.get(number));
				missed_calls.add(ms);
			} else {
				Miss_Call ms = new Miss_Call(number, "Private Number");
				missed_calls.add(ms);
			}
		}
		
		System.out.println("Missed calls in order");
		for (int i = 0; i < 3; i++) {
			missed_calls.get(i).display();
		}
		
		System.out.println("Enter a number for deletion: ");
		long number = sc.nextLong();
		
		if (contacts.containsKey(number)) {
			System.out.println("Before deletion: ");
			System.out.println(contacts);
			contacts.remove(number);
			System.out.println("After deletion");
			System.out.println(contacts);
		} 
		else	
		{
			System.out.println("Number is not there");
			System.out.println(contacts);
		}
	}
}