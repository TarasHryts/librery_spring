package mate.academy.spring;

import java.sql.SQLException;
import java.util.List;
import mate.academy.spring.config.AppConfig;
import mate.academy.spring.entity.Author;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.AuthorService;
import mate.academy.spring.service.BookService;
import mate.academy.spring.service.RentService;
import mate.academy.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        AuthorService authorService = context.getBean(AuthorService.class);
        Author tarasShevchenko = new Author("Taras", "Shevchenko");
        authorService.add(tarasShevchenko);
        RentService rentService = context.getBean(RentService.class);
        rentService.rentBook(new User("Sunil", "Bora", "suni.bora@example.com"),
                new Book("Inland: A Novel", 2019, 25.6));
        BookService bookService = context.getBean(BookService.class);
        Book daisyJonesBook = new Book("Daisy Jones & The Six", 2019, 41.6);
        bookService.add(daisyJonesBook);
        bookService.add(new Book("Daisy Jones & The Six", 2019, 35.16));
        bookService.add(new Book("The Water Cure: A Novel", 2019, 52.26));
        bookService.add(new Book("My Lovely Wife", 2019, 32.56));
        User userTemp = new User("Sunil", "Bora", "suni.bora@example.com");
        UserService userService = context.getBean(UserService.class);
        userService.add(userTemp);
        userService.add(new User("David", "Miller", "david.miller@example.com"));
        userService.add(new User("Sameer", "Singh", "sameer.singh@example.com"));
        userService.add(new User("Paul", "Smith", "paul.smith@example.com"));
        List<Book> books = bookService.listBooks();
        for (Book book : books) {
            System.out.println("Id=" + book.getBookId());
            System.out.println("Name=" + book.getTitle());
            System.out.println("Year=" + book.getYear());
            System.out.println("Price=" + book.getPrice());
            System.out.println();
        }
        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getUserId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }
        List<Author> foundedAuthors = authorService.findByName("Taras");
        for (Author author: foundedAuthors) {
            System.out.println("Id = " + author.getAuthorId());
            System.out.println("First Name = " + author.getName());
            System.out.println("Last Name = " + author.getSurname());
            System.out.println();
        }

        authorService.findByNameAndSurname("Taras", "Shevchenko");
        bookService.findByTitle(daisyJonesBook.getTitle());
        rentService.rentBook(userTemp, daisyJonesBook);
        List<Book> rentedBooks = rentService.getBooksRentByUser(userTemp);
        for (Book book : rentedBooks) {
            System.out.println("Id=" + book.getBookId());
            System.out.println("Name=" + book.getTitle());
            System.out.println("Year=" + book.getYear());
            System.out.println("Price=" + book.getPrice());
            System.out.println();
        }
        rentService.returnBook(userTemp, daisyJonesBook);
        System.out.println("Book was returned:");
        System.out.println("Id=" + daisyJonesBook.getBookId());
        System.out.println("Name=" + daisyJonesBook.getTitle());
        System.out.println("Year=" + daisyJonesBook.getYear());
        System.out.println("Price=" + daisyJonesBook.getPrice());
        System.out.println();
        context.close();
    }
}
