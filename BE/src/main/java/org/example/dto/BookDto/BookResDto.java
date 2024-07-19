package org.example.dto.BookDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.productEntity.BookEntity;

import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResDto {

    private String authorName;
    private String coverType;
    private String publisherName;
    private Date publicationDate;
    private Integer numberOfPages;
    private String lang;
    private String genre;

    public BookResDto(BookEntity book){
        this.authorName = book.getAuthor().getAuthorName();
        this.coverType = book.getCoverType();
        this.publisherName = book.getPublisher().getPublisherName();
        this.publicationDate = book.getPublicationDate();
        this.numberOfPages = book.getNumberOfPages();
        this.lang = book.getLang();
        this.genre = book.getGenre();
    }
}
