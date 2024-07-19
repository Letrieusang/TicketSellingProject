package org.example.dto.LPDto;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.productEntity.CDEntity;
import org.example.entity.productEntity.LPEntity;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LPResDto {
    private String artist;
    private String  recordLabel;
    private String tracklist;
    private Date releaseDate;

    public LPResDto(LPEntity lp){
        this.artist = lp.getArtist().getArtistName();
        this.recordLabel = lp.getRecordLabel().getRecordLabelName();
        this.tracklist = lp.getTracklist();
        this.releaseDate = lp.getReleaseDate();
    }
}
