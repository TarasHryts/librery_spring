package mate.academy.spring.controller;

import java.util.List;
import java.util.Optional;
import mate.academy.spring.entity.Book;
import mate.academy.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public String getAllBooks(ModelMap model) {
        model.put("allBooks", bookService.listBooks());
        return "book/allBooks";
    }

    @GetMapping("/find")
    public String findByTitle(@RequestParam("title") String title, Model model) {
        List<Book> books = bookService.findByTitle(title);
        model.addAttribute("allBooks", books);
        return "book/allBooks";
    }

    @GetMapping("/{bookId}")
    public String find(@PathVariable("bookId") Long id, Model model) {
        Optional<Book> book = bookService.get(id);
        if (book.isEmpty()) {
            model.addAttribute("message", String.format("Can't find book by id=%d", id));
        } else {
            model.addAttribute("book", book.get());
        }
        return "book/bookInfo";
    }

    @GetMapping("/add")
    public String addBookPage() {
        return "book/create";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book, ModelMap model) {
        bookService.add(book);
        return getAllBooks(model);
    }
}
