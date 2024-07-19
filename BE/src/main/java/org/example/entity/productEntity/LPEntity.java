package org.example.entity.productEntity;

import jakarta.persistence.*;
import lombok.*;
import org.example.entity.ProductEntity;
import org.example.entity.nameEntity.ArtistEntity;
import org.example.entity.nameEntity.RecordLabelEntity;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "LPs")
public class LPEntity {
    @Id
    private Integer productId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "artist_id", referencedColumnName = "artist_id")
    private ArtistEntity artist;

    @ManyToOne
    @JoinColumn(name = "record_label_id", referencedColumnName = "record_label_id")
    private RecordLabelEntity recordLabel;

    @Column(name = "tracklist")
    private String tracklist;

    @Column(name = "release_date")
    private Date releaseDate;

}
