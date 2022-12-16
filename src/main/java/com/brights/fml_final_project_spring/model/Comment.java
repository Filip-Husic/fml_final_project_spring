package com.brights.fml_final_project_spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @ManyToOne
    @Getter
    @Setter
    private User user;

    @ManyToOne
    @Getter
    @Setter
    private Post post;

    @Getter
    @Setter
    @Column
    private String commentContent;

    @Column(name = "posted_date")
    @Getter
    @Setter
    private Date postedDate;

    public Comment(String commentContent) {
        this.commentContent = commentContent;
        this.postedDate = new Date();
    }

    public Comment() {
    }
}
