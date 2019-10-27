package mate.academy.spring.controller;

import java.util.List;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.BookService;
import mate.academy.spring.service.RentService;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/rent")
public class RentController {
    private static final Long USER_ID = 1L;
    @Autowired
    private RentService rentService;
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    @GetMapping
    public String userRentedBooks(Model model) {
        User user = userService.getUserById(USER_ID).get();
        List<Book> books = rentService.getBooksRentByUser(user);
        model.addAttribute("user", user);
        model.addAttribute("allBooks", books);
        return "rent/rentedUsersBook";
    }

    @GetMapping("/rentBook")
    public String rentBook(@RequestParam("bookId") Long bookId, Model model) {
        User user = userService.getUserById(USER_ID).get();
        List<Book> books = rentService.getBooksRentByUser(user);
        rentService
                .rentBook(user, bookService.get(bookId).get());
        model.addAttribute("user", user);
        model.addAttribute("allBooks", books);
        return "forward:/rent";
    }

    @GetMapping("/return")
    public String returnBook(@RequestParam("bookId") Long bookId, Model model) {
        User user = userService.getUserById(USER_ID).get();
        List<Book> books = rentService.getBooksRentByUser(user);
        rentService
                .returnBook(userService.getUserById(USER_ID).get(), bookService.get(bookId).get());
        model.addAttribute("user", user);
        model.addAttribute("allBooks", books);
        return "forward:/rent";
    }
}
