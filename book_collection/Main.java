package book_collection;

import java.util.*;

public class Main {
	public static void main(String[] args) {
// TODO Auto-generated method stub
		Books o1 = new Books("ORACLE", "Balguru", "SSS publisher", 750);
		Books o2 = new Books("OOPS", "P.Reddy", "SRV publisher", 900);
		Books o3 = new Books("WEB 3", "Gavin Wood", "KSR publisher", 600);
		Books o4 = new Books("Python", "Guido Rosum", "SSS publisher", 300);
		Books o5 = new Books("C#", "Balaguruswamy", "kSS publisher", 100);

		ArrayList<Books> ar = new ArrayList<Books>();
		ar.add(o1);
		ar.add(o2);
		ar.add(o3);
		ar.add(o4);
		ar.add(o5);
		
		System.out.println("---------------------BOOK LIST---------------------------");
		for (Books ob : ar) {
			System.out.println(ob);
		}
		
		
		Collections.sort(ar, new BookCompare());
		System.out.println("----------BOOK AFTER SORTING------------");
		for (Books ob : ar) {
			System.out.println(ob);
		}
		
		
		System.out.println("----------create a Hashmap with unique book id------");
		HashMap<Integer, Books> hm = new HashMap<Integer, Books>();
		Integer i = 101;
		 	for (Books ob : ar) {
		 	hm.put(i, ob);
			i++;
		     	}
		 	for (Integer keyid : hm.keySet()) {
			System.out.println("keyId:" + keyid);
			System.out.println("" + hm.get(keyid));
		     	}
		 	
		 	
		System.out.println("--------------------SEARCH GIVEN AUTHOR NAME AND DISPLAY ---------------------");
		Scanner read = new Scanner(System.in);
		System.out.println("Enter author name: ");
		String name = read.nextLine();
		for (Books ob : ar) {
			if (name.equals(ob.Author)) {
				System.out.println(ob);
			}
		}
		
		System.out.println("--------------create new list <price more then user specified price>-------");
		LinkedList<Books> temp = new LinkedList<Books>();
		System.out.println("Enter book price: ");
		double rate = read.nextDouble();
		for (Books ob : ar) {
			if (ob.price > rate) {
				temp.add(ob);
				System.out.println(ob);
			}
		}
		
		
	
		
		
		System.out.println("--------all the books that match either the whole or a part of the book title--------");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter intested area");
		String y = sc.nextLine();
		int flag = 0;
		for (Books ob : ar) {
			if (ob.title.contains(y)) {
				flag = 1;
				System.out.println(ob);
			}
		}
		if (flag == 0) {
			System.out.println("title not matches ");
		}
		
		System.out.println("--------------search publisher -------");
		System.out.println("Enter book publisher name: ");
		Scanner rd = new Scanner(System.in);
		String pname = rd.nextLine();
		for (Books ob : ar) {
			if (pname.equals(ob.publisher)) {
				System.out.println(ob);
			}
		}
		
		System.out.println("--------------search title and update publisher name-------");
		System.out.println("Enter book title name: ");
		Scanner rd1 = new Scanner(System.in);
		String tname = rd1.nextLine();
		for (Books ob : ar) {
			if (tname.equals(ob.title)) {
				System.out.println(ob);
				System.out.println("enter new publisher name");
				String pname1 = rd1.nextLine();
				ob.publisher = pname1;
				System.out.println(ob);
			}
		}
	}
}