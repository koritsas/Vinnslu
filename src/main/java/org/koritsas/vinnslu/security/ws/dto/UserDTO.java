package org.koritsas.vinnslu.security.ws.dto;

import org.hibernate.annotations.NaturalId;
import org.koritsas.vinnslu.security.models.VinnsluUser;
import org.koritsas.vinnslu.main.ws.dto.AbstractDto;
import org.koritsas.vinnslu.security.utils.validators.PasswordMatches;
import org.koritsas.vinnslu.security.utils.validators.UserRole;
import org.koritsas.vinnslu.security.utils.validators.ValidEmail;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@PasswordMatches
public class UserDTO implements AbstractDto<Long> {

    private Long id;

    @NotEmpty
    @NotNull
    @Column(unique=true)
    private String username;

    @NotNull
    @NotEmpty
    private String name;


    @NotNull
    @NotEmpty
    private String surname;


    @ValidEmail
    @NotEmpty
    @NotNull
    @Column(unique = true)
    @NaturalId
    private String email;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    private String matchingPassword;

    @NotNull
    @NotEmpty
    @Enumerated(EnumType.STRING)
    UserRole userRole;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Class getClaZZ() {
        return VinnsluUser.class;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
