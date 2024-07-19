package org.example.entity.productEntity;

import jakarta.persistence.*;
import lombok.*;
import org.example.entity.ProductEntity;
import org.example.entity.nameEntity.DirectorEntity;
import org.example.entity.nameEntity.StudioEntity;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "DVDs")
public class DVDEntity {
    @Id
    private Integer productId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private ProductEntity product;

    @Column(name = "disc_type")
    private String discType;

    @ManyToOne
    @JoinColumn(name = "director_id", referencedColumnName = "director_id")
    private DirectorEntity director;

    @Column(name = "runtime")
    private String runtime;

    @ManyToOne
    @JoinColumn(name = "studio_id", referencedColumnName = "studio_id")
    private StudioEntity studio;

    @Column(name = "lang")
    private String lang;

    @Column(name = "subtitles")
    private String subtitles;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "genre")
    private String genre;

}
