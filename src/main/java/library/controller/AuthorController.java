package library.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

/**
 * Created by Любовь on 11.12.2014.
 */
@Controller
public class AuthorController {
    @Autowired
   private AuthorService authorService ;

    @RequestMapping(value = "/author", method = RequestMethod.GET)
    public String authorList(Model authorList) {
        authorList.addAttribute("listAuthor", authorService.getAllAuthor());
        return "Author";
    }

    @RequestMapping(value = "/AuthorParameters", method = RequestMethod.GET)
    public String getCreateAuthorForm(Model createAuthor) {
        return "AuthorParameters";
    }
//
//    @RequestMapping(value = "/authorParameters", method = RequestMethod.POST)
//    public String createAuthor(HttpServletRequest request, RedirectAttributes redirectAttrs) {
//        String name = request.getParameter("fullname");
//        Date birthday = Date.valueOf(request.getParameter("birthday"));
//        String biography = request.getParameter("biography");
//
//        try {
//            authorService.createAuthor(name, birthday, biography);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        redirectAttrs.addFlashAttribute("success", "Success Add Book");
//        return "redirect:/author";
//    }

    @RequestMapping(value = "/AuthorParameters/{id}", method = RequestMethod.GET)
    public String authorParameterGet(Model authorParameterGet, @PathVariable Integer id) {
        authorParameterGet.addAttribute("author", authorService.getAuthorParameters(id));
        return "AuthorParameters";
    }

    @RequestMapping(value = "/AuthorParameters/{id}", method = RequestMethod.POST)
    public String authorParameterGet(Model authorParameterGet, @PathVariable Integer id, HttpServletRequest request) {
        String name = request.getParameter("fullname");
        Date birthday = Date.valueOf(request.getParameter("birthday"));
        String biography = request.getParameter("biography");
        try {
            authorService.updateAuthor(id, name, birthday, biography);
        } catch (Exception e) {
            e.printStackTrace();
        }
        authorParameterGet.addAttribute("author", authorService.getAuthorParameters(id));
        return "AuthorParameters";
    }


}
