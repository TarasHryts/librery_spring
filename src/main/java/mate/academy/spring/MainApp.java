package mate.academy.spring;

import java.sql.SQLException;
import java.util.List;
import mate.academy.spring.config.AppConfig;
import mate.academy.spring.entity.Author;
import mate.academy.spring.entity.Book;
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
        Author authorTemp = new Author("Some", "One");
        authorService.add(authorTemp);
        RentService rentService = context.getBean(RentService.class);
        rentService.rentBook(new User("Sunil", "Bora", "suni.bora@example.com"),
                new Book("Some book1", 2018, 2.6));
        BookService bookService = context.getBean(BookService.class);
        Book bookTemp = new Book("Some book1", 2018, 2.6);
        bookService.add(bookTemp);
        bookService.add(new Book("Some book2", 2017, 12.16));
        bookService.add(new Book("Some book10", 2019, 22.26));
        bookService.add(new Book("Some book4", 2020, 32.56));
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
        authorService.findByName(authorTemp.getName());
        authorService.findByNameAndSurname(authorTemp.getName(), authorTemp.getSurname());
        bookService.findByTitle(bookTemp.getTitle());
        rentService.rentBook(userTemp, bookTemp);
        rentService.getBooksRentByUser(userTemp);
        rentService.returnBook(userTemp, bookTemp);
        context.close();
    }
}
