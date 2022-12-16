package com.brights.fml_final_project_spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @Column(nullable = false)
    private String content;

    @Getter
    @Setter
    @Column(name = "posted_date", nullable = false)
    private LocalDateTime postedDate;


    @ManyToOne
    @Getter
    @Setter
    @JsonIgnore
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "recipient_id", nullable = false)
    private User recipient;

    public Message() {

    }

    public Message(String content, LocalDateTime postedDate, User user, User recipient) {
        this.content = content;
        this.postedDate = postedDate;
        this.user = user;
        this.recipient = recipient;
    }
}


