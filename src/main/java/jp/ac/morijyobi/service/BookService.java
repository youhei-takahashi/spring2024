package jp.ac.morijyobi.service;

import jp.ac.morijyobi.bean.dto.LoanedBookDTO;
import jp.ac.morijyobi.bean.entity.Book;
import jp.ac.morijyobi.bean.form.BookForm;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface BookService {

    void registerBook(BookForm bookForm);

    List<Book> getBooksByTitle(String keyword);

    Book getBookById(int id);

    boolean registerBookLoans(int bookId, String username);

    List<LoanedBookDTO> getLoanedBoosListByUserId(UserDetails userDetails);

    boolean returnBookLoans(int bookId, UserDetails userDetails);
}
