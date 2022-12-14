package com.brights.fml_final_project_spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

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

    @Column(name = "price")
    @Getter
    @Setter
    private int price;

//    @Column(name = "url")
//    @Getter
//    @Setter
//    private String url;
//
//    @Column(name = "thumbnail_url")
//    @Getter
//    @Setter
//    private String thumbnailUrl;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @Getter
    @Setter
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

    @OneToOne
    @Getter
    @Setter
    @Nullable
    private Picture picture;
}
