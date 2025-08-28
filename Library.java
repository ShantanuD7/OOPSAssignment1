class Member {
    private String name;
    private int memberId;
    private String[] borrowedBooks;
    private int count;

    // Constructor
    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new String[10];
        this.count = 0;
    }

    public void borrowBook(String bookTitle) {
        if (count == borrowedBooks.length) {
            System.out.println("Cannot borrow more books. Limit reached.");
            return;
        }
        for (int i = 0; i < count; i++) {
            if (borrowedBooks[i].equalsIgnoreCase(bookTitle)) {
                System.out.println("Book already borrowed: " + bookTitle);
                return;
            }
        }
        borrowedBooks[count] = bookTitle;
        count++;
        System.out.println(name + " borrowed: " + bookTitle);
    }

    public void returnBook(String bookTitle) {
        for (int i = 0; i < count; i++) {
            if (borrowedBooks[i].equalsIgnoreCase(bookTitle)) {
                borrowedBooks[i] = borrowedBooks[count - 1];
                borrowedBooks[count - 1] = null;
                count--;
                System.out.println(name + " returned: " + bookTitle);
                return;
            }
        }
        System.out.println("This book was not borrowed: " + bookTitle);
    }


    public void showBorrowedBooks() {
        if (count == 0) {
            System.out.println(name + " has not borrowed any books.");
            return;
        }
        System.out.print(name + " has borrowed: ");
        for (int i = 0; i < count; i++) {
            System.out.print(borrowedBooks[i]);
            if (i < count - 1) System.out.print(", ");
        }
        System.out.println();
    }
}

public class Library {
    public static void main(String[] args) {
        Member m1 = new Member("John", 101);
        m1.borrowBook("Java Basics");
        m1.borrowBook("Data Structures");
        m1.borrowBook("Java Basics");
        m1.returnBook("Java Basics");
        m1.showBorrowedBooks();
        m1.returnBook("Python Basics");
    }
}
