package com.brights.fml_final_project_spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="posts")
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

//    @Column
//    private Blob picture;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @Getter
    @Setter
    @JsonIgnore
    private User user;

    @Column(name = "posted_date")
    @Getter
    @Setter
    @DateTimeFormat
    private Date postedDate;

    @OneToMany (mappedBy = "post")
    @Getter
    @Setter
    private List<Comment> commentList;

    public Post() {
    }

    @SuppressWarnings("unused")
    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
