package jp.ac.morijyobi.mapper;

import java.util.List;
import jp.ac.morijyobi.bean.entity.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BooksMapper {

    @Insert("INSERT INTO books VALUES(default, #{title}, #{author}, #{publisher}, #{publicationDate})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertBook(Book book);

    @Select("SELECT id, title, author, publisher, publication_date FROM books "
            + "WHERE title LIKE CONCAT('%', #{keyword}, '%') ORDER BY publication_date DESC")
    List<Book> selectBooksByKeyword(String keyword);
}
