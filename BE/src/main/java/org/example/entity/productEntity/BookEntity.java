package org.example.entity.productEntity;

import jakarta.persistence.*;
import lombok.*;
import org.example.entity.CategoryEntity;
import org.example.entity.ProductEntity;
import org.example.entity.nameEntity.AuthorEntity;
import org.example.entity.nameEntity.PublisherEntity;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "books")
public class BookEntity {
    @Id
    private Integer productId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "author_id")
    private AuthorEntity author;

    @Column(name = "covertype")
    private String coverType;

    @ManyToOne
    @JoinColumn(name = "publisher_id", referencedColumnName = "publisher_id")
    private PublisherEntity publisher;

    @Column(name = "publication_date")
    private Date publicationDate;

    @Column(name = "number_of_pages")
    private Integer numberOfPages;

    @Column(name = "lang")
    private String lang;

    @Column(name = "genre")
    private String genre;

}
