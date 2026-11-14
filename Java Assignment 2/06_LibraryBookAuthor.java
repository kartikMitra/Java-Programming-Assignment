import java.util.*;

class Author {
    private String name, email, gender;

    public Author(String name, String email, String gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String toString() {
        return name + " (" + gender + "), Email: " + email;
    }
}

class Book {
    private String title;
    private double price;
    private Author author;

    public Book(String title, double price, Author author) {
        this.title = title;
        this.price = price;
        this.author = author;
    }

    public String toString() {
        return "Book: " + title + "\nPrice: " + price + "\nAuthor: " + author;
    }
}

public class LibraryBookAuthor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] d = sc.nextLine().split(",");
        Author author = new Author(d[2], d[3], d[4]);
        Book book = new Book(d[0], Double.parseDouble(d[1]), author);
        System.out.println(book);
        sc.close();
    }
}
