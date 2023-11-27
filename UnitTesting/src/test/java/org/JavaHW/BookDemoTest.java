package org.JavaHW;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


class BookDemoTest {

    @Test
    void testListAuthors() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Dandelion Wine", "Ray Bradbury", "Realistic fiction", 1957));
        books.add(new Book("Rocket Boys", "Homer Hickam", "Memoir", 1998));
        books.add(new Book("The Catcher in the Rye", "J. D. Salinger", "Realistic fiction", 1951));
        books.add(new Book("On the Road", "Jack Kerouac", "Beat", 1957));
        books.add(new Book("Atlas Shrugged", "Ayn Rand", "Philosophical fiction", 1957));

        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        BookDemo.listAuthors(books);

        String expectedOutput = "List of authors:\nRay Bradbury\nHomer Hickam\nJ. D. Salinger\nJack Kerouac\nAyn Rand\n";

        String actualOutput = outputStreamCaptor.toString().trim();

        expectedOutput = expectedOutput.replaceAll("\\R", "\n");
        actualOutput = actualOutput.replaceAll("\\R", "\n");

        assertEquals(expectedOutput.trim(), actualOutput);
    }


    @Test
    void testListAuthorsByGenre() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Dandelion Wine", "Ray Bradbury", "Realistic fiction", 1957));
        books.add(new Book("Rocket Boys", "Homer Hickam", "Memoir", 1998));
        books.add(new Book("The Catcher in the Rye", "J. D. Salinger", "Realistic fiction", 1951));
        books.add(new Book("On the Road", "Jack Kerouac", "Beat", 1957));
        books.add(new Book("Atlas Shrugged", "Ayn Rand", "Philosophical fiction", 1957));

        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        BookDemo.listAuthorsByGenre(books, "Realistic fiction");

        String expectedOutput = "\nAuthors who have written books in the genre 'Realistic fiction':\nJ. D. Salinger\nRay Bradbury\n";

        String actualOutput = outputStreamCaptor.toString().trim();

        expectedOutput = expectedOutput.replaceAll("\\R", "\n");
        actualOutput = actualOutput.replaceAll("\\R", "\n");

        assertEquals(expectedOutput.trim(), actualOutput);
    }


    @Test
    void testListAuthorsByYear() {
    List<Book> books = new ArrayList<>();
        books.add(new Book("Dandelion Wine", "Ray Bradbury", "Realistic fiction", 1957));
        books.add(new Book("Rocket Boys", "Homer Hickam", "Memoir", 1998));
        books.add(new Book("The Catcher in the Rye", "J. D. Salinger", "Realistic fiction", 1951));
        books.add(new Book("On the Road", "Jack Kerouac", "Beat", 1957));
        books.add(new Book("Atlas Shrugged", "Ayn Rand", "Philosophical fiction", 1957));

    ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        BookDemo.listAuthorsByYear(books, 1957);

    String expectedOutput = "\nAuthors who have written books in the year '1957':\nJack Kerouac\nAyn Rand\nRay Bradbury\n";

    String actualOutput = outputStreamCaptor.toString().trim();

    expectedOutput = expectedOutput.replaceAll("\\R", "\n");
    actualOutput = actualOutput.replaceAll("\\R", "\n");

    assertEquals(expectedOutput.trim(), actualOutput);
}

    @Test
    void testFindBookByAuthor() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Dandelion Wine", "Ray Bradbury", "Realistic fiction", 1957));
        books.add(new Book("Rocket Boys", "Homer Hickam", "Memoir", 1998));
        books.add(new Book("The Catcher in the Rye", "J. D. Salinger", "Realistic fiction", 1951));
        books.add(new Book("On the Road", "Jack Kerouac", "Beat", 1957));
        books.add(new Book("Atlas Shrugged", "Ayn Rand", "Philosophical fiction", 1957));

        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        BookDemo.findBookByAuthor(books, "Ayn Rand");

        String expectedOutput = "\nBooks written by 'Ayn Rand':\nAtlas Shrugged\n";

        String actualOutput = outputStreamCaptor.toString().trim();

        expectedOutput = expectedOutput.replaceAll("\\R", "\n");
        actualOutput = actualOutput.replaceAll("\\R", "\n");

        assertEquals(expectedOutput.trim(), actualOutput);
    }

    @Test
    void testFindBooksByYear() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Dandelion Wine", "Ray Bradbury", "Realistic fiction", 1957));
        books.add(new Book("Rocket Boys", "Homer Hickam", "Memoir", 1998));
        books.add(new Book("The Catcher in the Rye", "J. D. Salinger", "Realistic fiction", 1951));
        books.add(new Book("On the Road", "Jack Kerouac", "Beat", 1957));
        books.add(new Book("Atlas Shrugged", "Ayn Rand", "Philosophical fiction", 1957));

        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        BookDemo.findBooksByYear(books, 1957);

        String expectedOutput = "\nBooks written in '1957':\nOn the Road\nDandelion Wine\nAtlas Shrugged\n";

        String actualOutput = outputStreamCaptor.toString().trim();

        expectedOutput = expectedOutput.replaceAll("\\R", "\n");
        actualOutput = actualOutput.replaceAll("\\R", "\n");

        assertEquals(expectedOutput.trim(), actualOutput);
    }
    @Test
    void testFindBooksByGenre() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Dandelion Wine", "Ray Bradbury", "Realistic fiction", 1957));
        books.add(new Book("Rocket Boys", "Homer Hickam", "Memoir", 1998));
        books.add(new Book("The Catcher in the Rye", "J. D. Salinger", "Realistic fiction", 1951));
        books.add(new Book("On the Road", "Jack Kerouac", "Beat", 1957));
        books.add(new Book("Atlas Shrugged", "Ayn Rand", "Philosophical fiction", 1957));

        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        BookDemo.findBooksByGenre(books, "Memoir");

        String expectedOutput = "\nBooks written in 'Memoir' genre:\nRocket Boys\n";

        String actualOutput = outputStreamCaptor.toString().trim();

        expectedOutput = expectedOutput.replaceAll("\\R", "\n");
        actualOutput = actualOutput.replaceAll("\\R", "\n");

        assertEquals(expectedOutput.trim(), actualOutput);
    }

    @Test
    void testRemoveBooksByAuthor() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Dandelion Wine", "Ray Bradbury", "Realistic fiction", 1957));
        books.add(new Book("Rocket Boys", "Homer Hickam", "Memoir", 1998));
        books.add(new Book("The Catcher in the Rye", "J. D. Salinger", "Realistic fiction", 1951));
        books.add(new Book("On the Road", "Jack Kerouac", "Beat", 1957));
        books.add(new Book("Atlas Shrugged", "Ayn Rand", "Philosophical fiction", 1957));

        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        BookDemo.removeBooksByAuthor(books, "J. D. Salinger");

        String expectedOutput = "The collection of books with 'J. D. Salinger' removed\n[Book{title='Dandelion Wine', author=Ray Bradbury, genre=Realistic fiction, year=1957}, Book{title='Rocket Boys', author=Homer Hickam, genre=Memoir, year=1998}, Book{title='On the Road', author=Jack Kerouac, genre=Beat, year=1957}, Book{title='Atlas Shrugged', author=Ayn Rand, genre=Philosophical fiction, year=1957}]";

        String actualOutput = outputStreamCaptor.toString().trim();

        expectedOutput = expectedOutput.replaceAll("\\R", "\n");
        actualOutput = actualOutput.replaceAll("\\R", "\n");

        assertEquals(expectedOutput, actualOutput);
    }


    @Test
    void testCombineCollections() {
        List<Book> books1 = new ArrayList<>();
        books1.add(new Book("Dandelion Wine", "Ray Bradbury", "Realistic fiction", 1957));
        books1.add(new Book("Rocket Boys", "Homer Hickam", "Memoir", 1998));

        List<Book> books2 = new ArrayList<>();
        books2.add(new Book("The Catcher in the Rye", "J. D. Salinger", "Realistic fiction", 1951));
        books2.add(new Book("On the Road", "Jack Kerouac", "Beat", 1957));

        List<Book> combined = BookDemo.combineCollections(books1, books2);

        assertEquals(4, combined.size());
        assertTrue(combined.containsAll(books1));
        assertTrue(combined.containsAll(books2));
    }

}