package book_collection;

public class Books {
	String title, Author, publisher;
	double price;

	Books(String x, String y, String z, double p) {
		title = x;
		Author = y;
		publisher = z;
		price = p;
	}

	public String toString() {
		String str = "Book has " + title + "title " + "whose author is " + Author;
		str += "\n Book is published by " + publisher;
		str += "\n Price is= " + price;
		return str;
	}
}