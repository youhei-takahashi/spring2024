package jp.ac.morijyobi.bean.form;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public class BookForm {
    @NotBlank
    @Size(min=1, max=255)
    private String title;

    @Size(max=255)
    private String author;

    @Size(max=255)
    private String publisher;

    @Past
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate publicationDate;

    @NotEmpty(message="1つ以上選択してください")
    private List<@NotNull Integer> tagIdList;

    public @NotBlank @Size(min = 1, max = 255) String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank @Size(min = 1, max = 255) String title) {
        this.title = title;
    }

    public @Size(max = 255) String getAuthor() {
        return author;
    }

    public void setAuthor(@Size(max = 255) String author) {
        this.author = author;
    }

    public @Size(max = 255) String getPublisher() {
        return publisher;
    }

    public void setPublisher(@Size(max = 255) String publisher) {
        this.publisher = publisher;
    }

    public @Past LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(@Past LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public @NotEmpty(message = "1つ以上選択してください") List<@NotNull Integer> getTagIdList() {
        return tagIdList;
    }

    public void setTagIdList(@NotEmpty(message = "1つ以上選択してください") List<@NotNull Integer> tagIdList) {
        this.tagIdList = tagIdList;
    }
}
