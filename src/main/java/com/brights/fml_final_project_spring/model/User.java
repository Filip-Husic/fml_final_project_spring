package com.brights.fml_final_project_spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "user")
    @Getter
    @Setter
    private List<Post> post = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    @Getter
    @Setter
    private List<Comment> comments = new ArrayList<>();

    public User() {
    }

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
