package book_collection;

import java.util.Comparator;

public class BookCompare implements Comparator<Books> {
	@Override
	public int compare(Books b1, Books b2) {
		if (b1.price > b2.price)
			return 1;
		else if (b1.price == b2.price)
			return 0;
		else
			return -1;
	}
}
