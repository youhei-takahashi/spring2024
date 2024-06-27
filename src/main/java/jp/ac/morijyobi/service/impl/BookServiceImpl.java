package jp.ac.morijyobi.service.impl;

import jp.ac.morijyobi.bean.dto.LoanedBookDTO;
import jp.ac.morijyobi.bean.entity.Book;
import jp.ac.morijyobi.bean.entity.BookLoan;
import jp.ac.morijyobi.bean.entity.BookTag;
import jp.ac.morijyobi.bean.form.BookForm;
import jp.ac.morijyobi.mapper.BookLoansMapper;
import jp.ac.morijyobi.mapper.BookTagsMapper;
import jp.ac.morijyobi.mapper.BooksMapper;
import jp.ac.morijyobi.mapper.UsersMapper;
import jp.ac.morijyobi.service.BookService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BooksMapper booksMapper;
    private final BookTagsMapper bookTagsMapper;
    private final BookLoansMapper bookLoansMapper;
    private final UsersMapper usersMapper;

    public BookServiceImpl(BooksMapper booksMapper, BookTagsMapper bookTagsMapper, BookLoansMapper bookLoansMapper, UsersMapper usersMapper) {
        this.booksMapper = booksMapper;
        this.bookTagsMapper = bookTagsMapper;
        this.bookLoansMapper = bookLoansMapper;
        this.usersMapper = usersMapper;
    }

    @Override
    @Transactional
    public void registerBook(BookForm bookForm) {
        Book book = new Book(
                -1,
                bookForm.getTitle(),
                bookForm.getAuthor(),
                bookForm.getPublisher(),
                bookForm.getPublicationDate()
        );

        booksMapper.insertBook(book);

        for (int tagId : bookForm.getTagIdList()) {
            BookTag bookTag = new BookTag(book.getId(), tagId);
            bookTagsMapper.insertBookTag(bookTag);
        }
    }

    @Override
    public List<Book> getBooksByTitle(String keyword) {
        return booksMapper.selectBooksByKeyword(keyword);
    }

    @Override
    public Book getBookById(int id) {
        return booksMapper.selectBookById(id);
    }

    @Override
    @Transactional
    public boolean registerBookLoans(int bookId, String username) {

        int userId = usersMapper.selectUserByUsername(username).getId();

        if (bookLoansMapper.isBookAvailable(bookId)) {
            BookLoan bookLoan = new BookLoan();
            bookLoan.setBookId(bookId);
            bookLoan.setUserId(userId);
            bookLoansMapper.insertBookLoans(bookLoan);
            return true;
        }

        return false;
    }

    @Override
    public List<LoanedBookDTO> getLoanedBoosListByUserId(UserDetails userDetails) {
        int userId = usersMapper.selectUserByUsername(userDetails.getUsername()).getId();
        return bookLoansMapper.selectLoanedBooksByUserId(userId);
    }
}
