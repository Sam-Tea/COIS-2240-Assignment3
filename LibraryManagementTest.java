import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.reflect.Constructor;

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
	
	@Test
	public void testBorrowReturn() {
		try {
			Book book1 = new Book(100, "book 1");
			Member member1 = new Member(100, "Member 1");
			
			// Testing to see if book is available
			assertTrue(book1.isAvailable());
			
			// Testing to see if borrow was successful
			assertTrue(Transaction.getTransaction().borrowBook(book1, member1));
			
			// Testing to see if book is now unavailable
			assertFalse(book1.isAvailable());
			
			// Testing to see if borrow was successful
			assertFalse(Transaction.getTransaction().borrowBook(book1, member1));
			
			// Testing to see if return was successful
			assertTrue(Transaction.getTransaction().returnBook(book1, member1));
			
			// Testing to see if return was unsuccessful
			assertFalse(Transaction.getTransaction().returnBook(book1, member1));
		}
		catch (Exception e) {
		}
	}
	
	@Test
	public void testSingletonTransaction() {
		try {
			Constructor<Transaction> constructor = Transaction.class.getDeclaredConstructor();
			assertEquals(constructor.getModifiers(), 2);
		}
		catch (Exception e) {

		}

	}

}
