package jp.ac.morijyobi.mapper;

import jp.ac.morijyobi.bean.entity.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface BooksMapper {

    @Insert("INSERT INTO books VALUES(default, #{title}, #{author}, #{publisher}, #{publicationDate})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertBook(Book book);
}
