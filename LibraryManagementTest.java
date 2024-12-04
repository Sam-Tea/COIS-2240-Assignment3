import static org.junit.Assert.*;
import org.junit.Test;
//import java.lang.reflect.Constructor;

public class LibraryManagementTest {
	@Test
	public void testBookId() {
		try {
			Book book1 = new Book(100, "book 1");
			Book book2 = new Book(999, "book 2");
			Book book3 = new Book(1000, "book 3");
			Book book4 = new Book(10, "book 4");
			Book book5 = new Book(1997812, "book 5");
			assertTrue(book1.isValidId(book1.getId()));
			assertTrue(book2.isValidId(book2.getId()));
			assertTrue(book3.isValidId(book3.getId()));
			assertTrue(book4.isValidId(book4.getId()));
			assertTrue(book5.isValidId(book5.getId()));
		}
		catch (Exception e) {
			System.out.println("Invalid ID");
		}
	}
}
