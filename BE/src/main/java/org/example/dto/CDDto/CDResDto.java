package org.example.dto.CDDto;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.productEntity.CDEntity;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CDResDto {
    private String artist;
    private String recordLabel;
    private String tracklist;
    private Date releaseDate;

    public CDResDto(CDEntity cd){
        this.artist = cd.getArtist().getArtistName();
        this.recordLabel = cd.getRecordLabel().getRecordLabelName();
        this.tracklist = cd.getTracklist();
        this.releaseDate = cd.getReleaseDate();
    }
}
