package org.example.entity.nameEntity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "record_labels")
public class RecordLabelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_label_id")
    private Integer recordLabelId;

    @Column(name = "record_label_name")
    private String recordLabelName;
}
