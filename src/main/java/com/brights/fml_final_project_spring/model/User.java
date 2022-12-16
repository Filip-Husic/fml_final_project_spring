package com.brights.fml_final_project_spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
@JsonIgnoreProperties("hibernateLazyInitializer")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(name = "first_name",length = 30,nullable = false)
    @Getter
    @Setter
    private String firstName;

    @Column(name = "last_name",length = 30,nullable = false)
    @Getter
    @Setter
    private String lastName;

    @Column(name = "email",length = 50,nullable = false,unique = true)
    @Getter
    @Setter
    private String email;

    @Column(name = "username",length = 30, nullable = false,unique = true)
    @Getter
    @Setter
    private String username;
    @Size(min = 6)
    @Pattern(regexp = "^[a-zA-Z0-9_]+$",
            message = "Password can only contain letters, numbers and underscores!")
    @Column
    @Getter
    @Setter
    private String password;

    @Column
    @Getter
    @Setter
    private boolean isEnabled;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "user_posts",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "post_id") }
    )
    @Getter
    @Setter
    @JsonIgnore
    private List<Post> postList = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "user_comments",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "comment_id") }
    )
    @Getter
    @Setter
    @JsonIgnore
    private List<Comment> comments = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Getter
    @Setter
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @JsonIgnore
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(String firstName, String lastName, String email, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.isEnabled = true;
    }
    public void addPost(Post post){
        this.postList.add(post);
    }
    public void addComment(Comment comment){
        this.comments.add(comment);
    }


}

