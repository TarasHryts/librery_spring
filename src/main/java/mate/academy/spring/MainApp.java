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
        User userSunilBora = new User("Sunil", "Bora", "suni.bora@example.com");
        User userDavidMiller = new User("David", "Miller", "david.miller@example.com");
        User userSameerSingh = new User("Sameer", "Singh", "sameer.singh@example.com");
        User userPaulSmith = new User("Paul", "Smith", "paul.smith@example.com");
        UserService userService = context.getBean(UserService.class);
        userService.add(userSunilBora);
        userService.add(userDavidMiller);
        userService.add(userSameerSingh);
        userService.add(userPaulSmith);

        Book bookDaisyJones = new Book("Daisy Jones", 2019, 41.6);
        Book bookInlandNovel = new Book("Inland: A Novel", 2019, 25.6);
        Book bookDaisy = new Book("Daisy & The Six", 2019, 35.16);
        Book bookWaterCure = new Book("The Water Cure: A Novel", 2019, 52.26);
        Book bookLovelyWife = new Book("My Lovely Wife", 2019, 32.56);
        BookService bookService = context.getBean(BookService.class);
        bookService.add(bookDaisyJones);
        bookService.add(bookInlandNovel);
        bookService.add(bookDaisy);
        bookService.add(bookLovelyWife);

        Author authorTarasShevchenko = new Author("Taras", "Shevchenko");
        Author authorIvanFranko = new Author("Ivan", "Franko");
        Author authorLesPodrevlyanskiy = new Author("Les", "Podrevlyanskiy");
        AuthorService authorService = context.getBean(AuthorService.class);
        authorService.add(authorTarasShevchenko);
        authorService.add(authorLesPodrevlyanskiy);

        List<Author> authorList = new ArrayList<>();
        authorList.add(authorIvanFranko);
        authorList.add(authorLesPodrevlyanskiy);

        List<Book> bookList = new ArrayList<>();
        bookList.add(bookLovelyWife);
        bookList.add(bookWaterCure);
        bookList.add(bookInlandNovel);

        System.out.println("---authorWithBooks---");
        authorIvanFranko.setBooks(bookList);
        System.out.println(authorIvanFranko);
        for (Book book:authorIvanFranko.getBooks() ) {
            System.out.println(book);
        }

        System.out.println("---bookWithAuthors---");
        bookWaterCure.setAuthors(authorList);
        System.out.println(bookWaterCure);
        for (Author author:bookWaterCure.getAuthors() ) {
            System.out.println(author);
        }

        bookService.add(bookWaterCure);
        authorService.add(authorIvanFranko);

        System.out.println("---Rent---");
        RentService rentService = context.getBean(RentService.class);
        Rent rentSunilDaisy = rentService.rentBook(userSunilBora, bookDaisy);
        System.out.println(rentSunilDaisy);

        System.out.println("---rentWhenBookReturned----");
        Rent rent = rentService.returnBook(userSunilBora, bookDaisyJones);
        System.out.println(rent);

        System.out.println("---Book---");
        List<Book> books = bookService.listBooks();
        for (Book book : books) {
            System.out.println(book);
            for (Author author: book.getAuthors()){
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
            for (Book book :author.getBooks() ) {
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
