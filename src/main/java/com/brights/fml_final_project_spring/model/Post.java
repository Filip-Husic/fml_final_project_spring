package com.brights.fml_final_project_spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(name = "title")
    @Getter
    @Setter
    private String title;
    @Lob
    @Column(name = "content")
    @Getter
    @Setter
    private String content;

    @ManyToOne
    @JoinColumn(name = "posted_by")
    @Getter
    @Setter
    private User postedBy;

    @Column(name = "posted_date")
    @Getter
    @Setter
    private Date postedDate;

    public Post() {
    }

    public Post(String title, String content, User postedBy) {
        this.title = title;
        this.content = content;
        this.postedBy = postedBy;
    }
}
