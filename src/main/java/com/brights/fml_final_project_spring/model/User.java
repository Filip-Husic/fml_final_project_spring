package com.brights.fml_final_project_spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
@JsonIgnoreProperties("hibernateLazyInitializer")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(name = "email",length = 50,nullable = false,unique = true)
    @Getter
    @Setter
    private String email;

    @Column(name = "username",length = 30, nullable = false,unique = true)
    @Getter
    @Setter
    private String username;
    @Size(min = 6)
    @Column
    @Getter
    @Setter
    private String password;

    @Column
    @Getter
    @Setter
    private boolean isEnabled;


    @OneToMany (fetch = FetchType.LAZY,mappedBy = "id")
    @Getter
    @Setter
    @JsonIgnore
    private List<Post> postList;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE},mappedBy = "id")
    @Getter
    @Setter
    @JsonIgnore
    private List<Comment> comments = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @Getter
    @Setter
    @JsonIgnore
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.isEnabled = true;
        this.roles.add(new Role(ERole.ROLE_USER));
    }
    public void addPost(Post post){
        this.postList.add(post);
    }
    public void addComment(Comment comment){
        this.comments.add(comment);
    }


}

