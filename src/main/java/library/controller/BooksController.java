package library.controller;

import library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

/**
 * Created by Любовь on 11.12.2014.
 */
@Controller
public class BooksController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public String bookList(Model bookList) {
        bookList.addAttribute("listBook", bookService.getAllBook());
        return "Book";
    }

    @RequestMapping(value = "/BookParameters", method = RequestMethod.GET)
    public String createBook(Model createBook) {
        return "BookParameters";
    }

    @RequestMapping(value = "/BookParameters/{id}", method = RequestMethod.GET)
    public String bookParametersGet(Model bookParameterGet, @PathVariable Integer id) {
        bookParameterGet.addAttribute("book", bookService.getBookParameters(id));
        return "BookParameters";
    }

    @RequestMapping(value = "/BookParameters/{id}", method = RequestMethod.POST)
    public String bookParameterSet(Model bookParameterSet, @PathVariable Integer id, HttpServletRequest request) {
        String name = request.getParameter("name");
        Integer publishDay = Integer.parseInt(request.getParameter("publishDate"));
        String style = request.getParameter("style");
        try {
            bookService.updateBook(id, name,style, publishDay);
        } catch (Exception e) {
            e.printStackTrace();
        }
        bookParameterSet.addAttribute("book", bookService.getBookParameters(id));
        return "BookParameters";
    }
}