package jp.ac.morijyobi.service.impl;

import jp.ac.morijyobi.bean.entity.Book;
import jp.ac.morijyobi.bean.entity.BookTag;
import jp.ac.morijyobi.bean.form.BookForm;
import jp.ac.morijyobi.mapper.BookTagsMapper;
import jp.ac.morijyobi.mapper.BooksMapper;
import jp.ac.morijyobi.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BooksMapper booksMapper;
    private final BookTagsMapper bookTagsMapper;

    public BookServiceImpl(BooksMapper booksMapper, BookTagsMapper bookTagsMapper) {
        this.booksMapper = booksMapper;
        this.bookTagsMapper = bookTagsMapper;
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
}
