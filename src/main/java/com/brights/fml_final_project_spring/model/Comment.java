package com.brights.fml_final_project_spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "comments")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    @Getter
    @Setter
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "posts_id", referencedColumnName = "id", nullable = false)
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

    @SuppressWarnings("unused")
    public Comment(String commentContent) {
        this.commentContent = commentContent;
        this.postedDate = new Date();
    }

    public Comment() {
    }
}
