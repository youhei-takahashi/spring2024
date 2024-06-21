package jp.ac.morijyobi.controller;

import jp.ac.morijyobi.bean.entity.Book;
import jp.ac.morijyobi.bean.entity.Tag;
import jp.ac.morijyobi.bean.form.BookForm;
import jp.ac.morijyobi.service.BookService;
import jp.ac.morijyobi.service.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;
    private final TagService tagService;

    public BookController(BookService bookService, TagService tagService) {
        this.bookService = bookService;
        this.tagService = tagService;
    }

    @GetMapping("/register")
    public String register(Model model) {
        BookForm bookForm = new BookForm();
        model.addAttribute("bookForm", bookForm);

        List<Tag> tagList = tagService.getAllTags();
        model.addAttribute("tagList", tagList);

        return "book/register";
    }

    @PostMapping("/register")
    public String registerExe(@Validated BookForm bookForm,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,
                              Model model) {
        if (bindingResult.hasErrors()) {
            List<Tag> tagList = tagService.getAllTags();
            model.addAttribute("tagList", tagList);
            return "book/register";
        }

        bookService.registerBook(bookForm);
        redirectAttributes.addFlashAttribute("message", "登録が完了しました。");
        return "redirect:/book/register";
    }

    @GetMapping("/list")
    public String bookList(@RequestParam(defaultValue = "") String keyword,
                           Model model) {
        List<Book> bookList = bookService.getBooksByTitle(keyword);
        model.addAttribute("bookList", bookList);

        return "book/list";
    }
}
