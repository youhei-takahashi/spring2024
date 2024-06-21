package jp.ac.morijyobi.service;

import jp.ac.morijyobi.bean.entity.Book;
import jp.ac.morijyobi.bean.form.BookForm;

import java.util.List;

public interface BookService {

    void registerBook(BookForm bookForm);

    List<Book> getBooksByTitle(String keyword);
}
