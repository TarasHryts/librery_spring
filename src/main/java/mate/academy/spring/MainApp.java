package mate.academy.spring;

import java.sql.SQLException;
import java.util.ArrayList;
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
        UserService userService = context.getBean(UserService.class);
        User userSunilBora = new User("Sunil", "Bora", "suni.bora@example.com");
        userService.add(userSunilBora);
        User userDavidMiller = new User("David", "Miller", "david.miller@example.com");
        userService.add(userDavidMiller);
        User userSameerSingh = new User("Sameer", "Singh", "sameer.singh@example.com");
        userService.add(userSameerSingh);
        User userPaulSmith = new User("Paul", "Smith", "paul.smith@example.com");
        userService.add(userPaulSmith);

        BookService bookService = context.getBean(BookService.class);
        Book bookDaisyJones = new Book("Daisy Jones", 2019, 41.6);
        bookService.add(bookDaisyJones);
        Book bookInlandNovel = new Book("Inland: A Novel", 2019, 25.6);
        bookService.add(bookInlandNovel);
        Book bookDaisy = new Book("Daisy & The Six", 2019, 35.16);
        bookService.add(bookDaisy);
        Book bookLovelyWife = new Book("My Lovely Wife", 2019, 32.56);
        bookService.add(bookLovelyWife);
        Book bookWaterCure = new Book("The Water Cure: A Novel", 2019, 52.26);
        List<Book> bookList = new ArrayList<>();
        bookList.add(bookWaterCure);
        bookList.add(bookLovelyWife);
        bookList.add(bookInlandNovel);

        AuthorService authorService = context.getBean(AuthorService.class);
        Author authorTarasShevchenko = new Author("Taras", "Shevchenko");
        authorService.add(authorTarasShevchenko);
        Author authorLesPodrevlyanskiy = new Author("Les", "Podrevlyanskiy");
        authorService.add(authorLesPodrevlyanskiy);
        Author authorIvanFranko = new Author("Ivan", "Franko");
        List<Author> authorList = new ArrayList<>();
        authorList.add(authorIvanFranko);
        authorList.add(authorLesPodrevlyanskiy);

        System.out.println("---authorWithBooks---");
        authorIvanFranko.setBooks(bookList);
        authorService.add(authorIvanFranko);
        System.out.println(authorIvanFranko);
        for (Book book : authorIvanFranko.getBooks()) {
            System.out.println(book);
        }

        System.out.println("---bookWithAuthors---");
        bookWaterCure.setAuthors(authorList);
        bookService.add(bookWaterCure);
        System.out.println(bookWaterCure);
        for (Author author : bookWaterCure.getAuthors()) {
            System.out.println(author);
        }

        System.out.println("---Rent---");
        RentService rentService = context.getBean(RentService.class);
        Rent rentSunilDaisy = rentService.rentBook(userSunilBora, bookDaisyJones);
        System.out.println(rentSunilDaisy);

        System.out.println("---rentWhenBookReturned----");
        Rent rent = rentService.returnBook(userSunilBora, bookDaisyJones);
        System.out.println(rent);
        System.out.println("---Book---");
        List<Book> books = bookService.listBooks();
        for (Book book : books) {
            System.out.println(book);
            for (Author author : book.getAuthors()) {
                System.out.println(author);
            }
        }
        System.out.println("---User---");
        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println(user);
        }

        System.out.println("---authorFindByName---");
        List<Author> foundedAuthors = authorService.findByName("ras");
        for (Author author : foundedAuthors) {
            System.out.println(author);
            for (Book book : author.getBooks()) {
                System.out.println(book);
            }
        }

        System.out.println("---authorFindByNameAndSurname---");
        authorService.findByNameAndSurname("Tar", "chenko");
        bookService.findByTitle(bookDaisyJones.getTitle());
        rentService.rentBook(userSunilBora, bookDaisyJones);
        List<Book> rentedBooks = rentService.getBooksRentByUser(userSunilBora);
        for (Book book : rentedBooks) {
            System.out.println(book);
        }
    }
}
