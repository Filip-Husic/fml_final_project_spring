package com.brights.fml_final_project_spring.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "picture")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @Lob
    private byte[] pictureData;

    @Getter
    @Setter
    private String filename;
    @Getter
    @Setter
    private String mimeType;

}
