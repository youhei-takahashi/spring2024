package jp.ac.morijyobi.mapper;

import jp.ac.morijyobi.bean.dto.LoanedBookDTO;
import jp.ac.morijyobi.bean.entity.BookLoan;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookLoansMapper {

    @Insert("INSERT INTO book_loans VALUES (default, #{bookId}, #{userId}, CURRENT_TIMESTAMP, NULL)")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertBookLoans(BookLoan bookLoan);

    @Select("SELECT COUNT(*) = 0 FROM book_loans WHERE book_id = #{bookId} AND return_date IS NULL")
    boolean isBookAvailable(int bookId);

    @Select("SELECT bl.id AS loan_id, b.id AS book_id, b.title, b.author, b.publisher, " +
            "b.publication_date, bl.checkout_date, bl.return_date " +
            "FROM book_loans AS bl " +
            "INNER JOIN books AS b ON bl.book_id = b.id " +
            "WHERE bl.user_id = #{userId} " +
            "ORDER BY bl.checkout_date DESC")
    List<LoanedBookDTO> selectLoanedBooksByUserId(int userId);

    @Update("UPDATE book_loans SET return_date = CURRENT_TIMESTAMP " +
            "WHERE user_id = #{userId} AND book_id = #{bookId} AND return_date IS NULL")
    int returnBookLoans(int bookId, int userId);
}
