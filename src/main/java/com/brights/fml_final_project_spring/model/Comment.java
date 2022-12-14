package com.brights.fml_final_project_spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    public Comment(Post post, String commentContent) {
        this.post = post;
        this.commentContent = commentContent;
    }
}
