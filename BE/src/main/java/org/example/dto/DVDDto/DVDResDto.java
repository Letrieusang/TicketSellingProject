package org.example.dto.DVDDto;


import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.productEntity.CDEntity;
import org.example.entity.productEntity.DVDEntity;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DVDResDto {
    private String discType;
    private String director;
    private String runtime;
    private String studio;
    private String lang;
    private String subtitles;
    private Date releaseDate;
    private String genre;

    public DVDResDto(DVDEntity dvd){
        this.discType = dvd.getDiscType();
        this.director = dvd.getDirector().getDirectorName();
        this.runtime = dvd.getRuntime();
        this.studio = dvd.getStudio().getStudioName();
        this.lang = dvd.getLang();
        this.releaseDate = dvd.getReleaseDate();
        this.genre = dvd.getGenre();
    }
}
