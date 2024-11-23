import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
	// Private static instance
	private static Transaction transaction;
	
	private Transaction() {}
	
	// Public accessor method
	public static Transaction getTransaction() {
		if (transaction == null) {
			transaction = new Transaction();
		}
		return transaction;
	}

    // Perform the borrowing of a book
    public boolean borrowBook(Book book, Member member) {
        if (book.isAvailable()) {
            book.borrowBook();
            member.borrowBook(book); 
            String transactionDetails = getCurrentDateTime() + " - Borrowing: " + member.getName() + " borrowed " + book.getTitle();
            System.out.println(transactionDetails);
            saveTransaction(member.getName() + " borrowed the book titled: " + book.getTitle() + "\n");
            return true;
        } else {
            System.out.println("The book is not available.");
            return false;
        }
    }

    // Perform the returning of a book
    public void returnBook(Book book, Member member) {
        if (member.getBorrowedBooks().contains(book)) {
            member.returnBook(book);
            book.returnBook();
            String transactionDetails = getCurrentDateTime() + " - Returning: " + member.getName() + " returned " + book.getTitle();
            System.out.println(transactionDetails);
            saveTransaction(member.getName() + " returned the book titled: " + book.getTitle() + "\n");
        } else {
            System.out.println("This book was not borrowed by the member.");
        }
    }
    public void displayTransactionHistory() {
    	
    }

    // Get the current date and time in a readable format
    private static String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
    public void saveTransaction(String transactionDetails) {
    	try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.txt"));
			writer.write(transactionDetails);
			writer.close();
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}