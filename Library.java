import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Member> members = new ArrayList<Member>();
    private List<Book> books = new ArrayList<Book>();

    // Add a new member to the library
    public void addMember(Member member) 
    {
    	boolean found = false; // If member ID has been found (duplicate)
    
    	// If array is not empty, check that there 
    	// is not a duplicate member ID.
        if (members.isEmpty() == false) {
        	for (int i = 0; i <= (members.size() - 1); i++){
        		if ( members.get(i).getId() == member.getId() ){
        			System.out.println("Sorry, this member ID already exists.");
        			found = true;
        		}
    		}
        	// No duplicate and array is not empty
        	if (found == false && members.isEmpty() == false) {
            	members.add(member);
            	System.out.println("Member added to library successfully");
            }
        }
        else { // array is empty
			members.add(member);
			System.out.println("Member added to library successfully");
    	}
    }
    
    // Add a new book to the library
    public void addBook(Book book) 
    {
    	boolean found = false; // ID has been found (duplicate)
    	
    	// Checks that list of books is not empty, then that there 
    	// is not a duplicate book ID.
    	if ( books.isEmpty() == false ) {
    		for (int i = 0; i <= (books.size() - 1); i++){
        		if ( books.get(i).getId() == book.getId() ){
        			System.out.println("Sorry, this book ID already exists.");
        			found = true;
        		}
    		}
    		if (found == false && books.isEmpty() == false) {
            	books.add(book);
            	System.out.println("Book added to library successfully");
    		}
    	}
    	else // if array is empty
		{
			books.add(book);
			System.out.println("Book added to library successfully");
    	}
    }

    // Find a member by ID
    public Member findMemberById(int id) {
        for (Member member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    // Find a book by ID
    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    // Get the list of members
    public List<Member> getMembers() {
        return members;
    }
    
    // Get the list of books
    public List<Book> getBooks() {
        return books;
    }
}
