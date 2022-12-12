package com.brights.fml_final_project_spring.model;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
public class DTORegistration {
    @Pattern(regexp = "^[a-zA-Z0-9_]+$",
            message = "Password can only contain letters, numbers and underscores!")
    private String username;
    @Size(min = 5)
    private String password1;

    private String password2;
    @Getter
    @Setter
    private String roles;

    @Getter
    @Setter
    private boolean isEnabled;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    @Getter @Setter
    private User user;

    public DTORegistration(String username, String password1, String password2) {
        this.username = username;
        this.password1 = password1;
        this.password2 = password2;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}


