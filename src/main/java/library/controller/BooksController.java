package library.controller;

import library.service.BookService;
import library.validator.LibraryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @RequestMapping(value = "/BookParameters", method = RequestMethod.POST)
    public String createBook(HttpServletRequest request, RedirectAttributes redirectAttrs) {
        String name = request.getParameter("name");
        Integer publishDate = Integer.parseInt(request.getParameter("publishDate"));
        String style = request.getParameter("style");
        LibraryValidator libraryValidator = new LibraryValidator();
        if (libraryValidator.validateText(name, 60)){
           redirectAttrs.addFlashAttribute("exeption", "Ошибка!Не ввели Название Книги или длина названия превышает 60 символов");
            return "redirect:/BookParameters";
        }if(libraryValidator.validateNumber(publishDate,2014, 0)){
            redirectAttrs.addFlashAttribute("exeption", "Ошибка!Вы ввели неправильную дату");
            return "redirect:/BookParameters";
        }  if(libraryValidator.validateText(style, 60)) {
            redirectAttrs.addFlashAttribute("exeption", "Ошибка!Не ввели Стиль книги  или длина текста превышает 60 символов");
            return "redirect:/BookParameters";
        }
        try {
            bookService.createBook(name, style, publishDate);
            redirectAttrs.addFlashAttribute("success", "Success Add Book");
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttrs.addFlashAttribute("exeption", "Bad Bad Book!!!");
        }

        return "redirect:/book";
    }

    @RequestMapping(value = "/BookParameters/{id}", method = RequestMethod.GET)
    public String bookParametersGet(Model bookParameterGet, @PathVariable Integer id) {
        bookParameterGet.addAttribute("book", bookService.getBookParameters(id));
        return "BookParameters";
    }

    @RequestMapping(value = "/BookParameters/{id}", method = RequestMethod.POST)
    public String bookParameterSet(Model bookParameterSet, @PathVariable Integer id, HttpServletRequest request,RedirectAttributes redirectAttrs) {
        String name = request.getParameter("name");
        Integer publishDay = Integer.parseInt(request.getParameter("publishDate"));
        String style = request.getParameter("style");
        LibraryValidator libraryValidator = new LibraryValidator();
        if (libraryValidator.validateText(name, 60)){
            redirectAttrs.addFlashAttribute("exeption", "Ошибка!Не ввели Название Книги или длина названия превышает 60 символов");
            return "redirect:/BookParameters/" + id;
        }if(libraryValidator.validateNumber(publishDay,2014, 0)){
            redirectAttrs.addFlashAttribute("exeption", "Ошибка!Вы ввели неправильную дату");
            return "redirect:/BookParameters/" + id;
        }  if(libraryValidator.validateText(style, 60)) {
            redirectAttrs.addFlashAttribute("exeption", "Ошибка!Не ввели Стиль книги  или длина текста превышает 60 символов");
            return "redirect:/BookParameters/" + id;
        }
        try {
            bookService.updateBook(id, name, style, publishDay);
            redirectAttrs.addFlashAttribute("success", "Success Update Book");
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttrs.addFlashAttribute("exeption", "Bad Bad Book!!!");
        }
        bookParameterSet.addAttribute("book", bookService.getBookParameters(id));
        return "redirect:/BookParameters/" + id;
    }
}