package mate.academy.spring.controller;

import mate.academy.spring.entity.Book;
import mate.academy.spring.service.BookService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping
    public String getAllBooks(ModelMap model) {
        model.put("allBooks", bookService.listBooks());
        return "allBooks";
    }

    @GetMapping("/info")
    public String bookInfo(@RequestParam("bookId") Long id, ModelMap model){
        model.put("book", bookService.get(id));
        return "bookInfo";
    }
}
