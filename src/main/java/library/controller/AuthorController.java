package library.controller;

import library.service.BookService;
import library.validator.LibraryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import library.service.AuthorService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.Calendar;

/**
 * Created by Любовь on 11.12.2014.
 */
@Controller
@Configuration
//@ComponentScan
public class AuthorController {
    @Autowired
   private AuthorService authorService ;
    @Autowired
    private BookService bookService ;

    LibraryValidator libraryValidator = new LibraryValidator();

    @RequestMapping(value = "/author", method = RequestMethod.GET)
    public String authorList(Model authorList) {
        authorList.addAttribute("listAuthor", authorService.getAllAuthor());
        return "Author";
    }

    @RequestMapping(value = "/AuthorParameters", method = RequestMethod.GET)
    public String getCreateAuthorForm(Model createAuthor) {
        return "AuthorParameters";
    }

    @RequestMapping(value = "/AuthorParameters", method = RequestMethod.POST)
    public String createAuthor(HttpServletRequest request, RedirectAttributes redirectAttrs) {
        Calendar calendar = Calendar.getInstance();
        String name = request.getParameter("fullname");
        Date birthday = Date.valueOf(request.getParameter("birthday"));
        String biography = request.getParameter("biography");
        if (libraryValidator.validateText(name, 60)) {
            redirectAttrs.addFlashAttribute("exeption", "Ошибка!Не ввели Имя Автора или длина имени превышает 60 символов");
            return "redirect:/AuthorParameters";
        }if(libraryValidator.validateDate(birthday, calendar.getTime())) {
            redirectAttrs.addFlashAttribute("exeption", "Ошибка!Вы ввели неправильную дату");
            return "redirect:/AuthorParameters";

        }  if(libraryValidator.validateText(biography, 3000)) {
            redirectAttrs.addFlashAttribute("exeption", "Ошибка!Не ввели Биографию Автора или длина текста превышает 3000 символов");
            return "redirect:/AuthorParameters";
        }

        try {
            authorService.createAuthor(name, birthday, biography);
            redirectAttrs.addFlashAttribute("success", "Success Add Author");
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttrs.addFlashAttribute("exeption", "Bad Bad Author");
        }

        return "redirect:/author";
    }

    @RequestMapping(value = "/AuthorParameters/{id}", method = RequestMethod.GET)
    public String authorParameterGet(Model authorParameterGet, @PathVariable Integer id) {
        authorParameterGet.addAttribute("author", authorService.getAuthorParameters(id));
        authorParameterGet.addAttribute("notBooks", authorService.getNotAuthorBooks(id));
        authorParameterGet.addAttribute("authorBook",authorService.getAuthorParameters(id).getBooksAuthorList());

        return "AuthorParameters";
    }

    @RequestMapping(value = "/AuthorParameters/{id}", method = RequestMethod.POST)
    public String authorParameterPost(Model authorParameterGet, @PathVariable Integer id, HttpServletRequest request,RedirectAttributes redirectAttrs) {
        String name = request.getParameter("fullname");
        Date birthday = Date.valueOf(request.getParameter("birthday"));
        String biography = request.getParameter("biography");
        if (libraryValidator.validateText(name, 60)) {
            redirectAttrs.addFlashAttribute("exeption", "Ошибка!Не ввели Имя Автора или длина имени превышает 60 символов");
            return "redirect:/AuthorParameters/"+ id;
        }
        Calendar calendar = Calendar.getInstance();
        if(libraryValidator.validateDate(birthday, calendar.getTime())) {
            redirectAttrs.addFlashAttribute("exeption", "Ошибка!Вы ввели неправильную дату");
            return "redirect:/AuthorParameters/"+ id;

        }  if(libraryValidator.validateText(biography, 3000)) {
            redirectAttrs.addFlashAttribute("exeption", "Ошибка!Не ввели Биографию Автора или длина текста превышает 3000 символов");
            return "redirect:/AuthorParameters/"+ id;
        }

        try {
            authorService.updateAuthor(id, name, birthday, biography);
            redirectAttrs.addFlashAttribute("success", "Success Update Author");
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttrs.addFlashAttribute("exeption", "Bad Bad Author");
        }
        authorParameterGet.addAttribute("author", authorService.getAuthorParameters(id));

        return "redirect:/AuthorParameters/" + id;
    }

    @RequestMapping(value = "/AuthorParameters/{id}/book/delete", method = RequestMethod.POST)
    public String deleteAuthorBook(Model authorParameterGet, @PathVariable Integer id, HttpServletRequest request,RedirectAttributes redirectAttrs) {
        Integer idBook = Integer.parseInt(request.getParameter("idBook"));
         try {
            bookService.deleteAuthorBook(id, idBook);
            redirectAttrs.addFlashAttribute("success", "Success Delete Book");
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttrs.addFlashAttribute("exeption", "Bad Bad Author");
        }
//        authorParameterGet.addAttribute("author", authorService.getAuthorParameters(id));
        return "redirect:/AuthorParameters/" + id;
    }
    @RequestMapping(value = "/AuthorParameters/{id}/book/add", method = RequestMethod.POST)
    public String addAuthorBook(Model authorParameterGet, @PathVariable Integer id, HttpServletRequest request,RedirectAttributes redirectAttrs) {
        Integer idBook = Integer.parseInt(request.getParameter("idNotBook"));

        try {
            bookService.addAuthorBook(id, idBook);
            redirectAttrs.addFlashAttribute("success", "Success Add Book");
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttrs.addFlashAttribute("exeption", "Bad Bad Author");
        }
//        authorParameterGet.addAttribute("author", authorService.getAuthorParameters(id));
        return "redirect:/AuthorParameters/" + id;
    }

}
