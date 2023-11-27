package org.JavaHW;
import java.util.*;

public class Book {
    private String title;
    private String author;
    private String genre;
    private int year;

    public Book(String title, String author, String genre, int year) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int genre) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author=" + author +
                ", genre=" + genre +
                ", year=" + year +
                '}';
    }
}
class BookDemo {

    public static void main(String[] args) {

        List<Book> books = new ArrayList<>();

        // Adding books to the collection
        books.add(new Book("Dandelion Wine", "Ray Bradbury", "Realistic fiction", 1957));
        books.add(new Book("Rocket Boys", "Homer Hickam", "Memoir", 1998));
        books.add(new Book("The Catcher in the Rye", "J. D. Salinger", "Realistic fiction", 1951));
        books.add(new Book("On the Road", "Jack Kerouac", "Beat", 1957));
        books.add(new Book("Atlas Shrugged", "Ayn Rand", "Philosophical fiction", 1957));

        //1)
        listAuthors(books);

        //2)
        listAuthorsByGenre(books, "Realistic fiction");

        //3)
        listAuthorsByYear(books, 1957);

        //4)
        findBookByAuthor(books, "Ayn Rand");

        //5)
        findBooksByYear(books, 1957);

        //6)
        findBooksByGenre(books, "Memoir");

        //7)
        removeBooksByAuthor(books, "J. D. Salinger");

        //8)

        //9)
        combineCollections(books, books);

        //10)

    }

//Method to Print List of Authors:
    public static void listAuthors(List<Book> books) {
        System.out.println("List of authors:");
        for (Book book : books) {
            System.out.println(book.getAuthor());
        }
    }

//Method to List Authors by Genre:
    public static void listAuthorsByGenre(List<Book> books, String genre) {
        Set<String> authorsSet = new HashSet<>();
        for (Book book : books) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                authorsSet.add(book.getAuthor());
            }
        }
        if (authorsSet.isEmpty()) {
            System.out.println("No authors found for the genre: " + genre);
        } else {
            System.out.println("\nAuthors who have written books in the genre '" + genre + "':");
            for (String author : authorsSet) {
                System.out.println(author);
            }
        }
    }

//Method to List Authors by Publication Year:
    public static void listAuthorsByYear(List<Book> books, int year) {
        Set<String> authorsSet1 = new HashSet<>();
        for (Book book : books) {
            if (book.getYear() == year) {
                authorsSet1.add(book.getAuthor());
            }
        }
        if (authorsSet1.isEmpty()) {
            System.out.println("No authors found for the year: " + year);
        } else {
            System.out.println("\nAuthors who have written books in the year '" + year + "':");
            for (String author : authorsSet1) {
                System.out.println(author);
            }
        }
    }

//Method to Find Book by Author:
    public static void findBookByAuthor(List<Book> books, String author) {
        Set<String> bookSet = new HashSet<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                bookSet.add(book.getTitle());
            }
        }
        if (bookSet.isEmpty()) {
            System.out.println("No books found for this author: " + author);
        } else {
            System.out.println("\nBooks written by '" + author + "':");
            for (String title : bookSet) {
                System.out.println(title);
            }
        }
    }

//Method to Find Books by Publication Year:
    public static void findBooksByYear(List<Book> books, int year) {
        Set<String> bookSet1 = new HashSet<>();
        for (Book book : books) {
            if (book.getYear() == year) {
                bookSet1.add(book.getTitle());
            }
        }
        if (bookSet1.isEmpty()) {
            System.out.println("No books found for this year: " + year);
        } else {
            System.out.println("\nBooks written in '" + year + "':");
            for (String title : bookSet1) {
                System.out.println(title);
            }
        }
    }

//Method to Find Books by Genre:
    public static void findBooksByGenre(List<Book> books, String genre) {
        Set<String> bookSet2 = new HashSet<>();
        for (Book book : books) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                bookSet2.add(book.getTitle());
            }
        }
        if (bookSet2.isEmpty()) {
            System.out.println("No books found for this genre: " + genre);
        } else {
            System.out.println("\nBooks written in '" + genre + "' genre:");
            for (String title : bookSet2) {
                System.out.println(title);
            }
        }
    }

//Method Remove Books by Author:
    public static void removeBooksByAuthor(List<Book> books, String author) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getAuthor().equalsIgnoreCase(author)) {
                iterator.remove();
            }
        }
        System.out.println("The collection of books with '" + author + "' removed");
        System.out.println(books);
    }

//Method to Merge Book Collections:
    public static List<Book> combineCollections(List<Book> collection1, List<Book> collection2) {
        List<Book> combinedCollection = new ArrayList<>(collection1);
        combinedCollection.addAll(collection2);
        return combinedCollection;

    }


}









