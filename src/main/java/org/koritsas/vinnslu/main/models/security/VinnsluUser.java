package org.koritsas.vinnslu.main.models.security;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Parameter;
import org.koritsas.vinnslu.main.utils.validators.UserRole;
import org.koritsas.vinnslu.main.utils.validators.ValidEmail;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class VinnsluUser implements Serializable {

    @Id
    @GenericGenerator(
            name = "user_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "user_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "user_generator")
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
    @Column(length = 60)
    private String password;

    @NotNull
    @NotEmpty
    @Enumerated(EnumType.STRING)
    UserRole userRole;

    public VinnsluUser() {
    }


    public VinnsluUser(@NotEmpty @NotNull String username, @NotNull @NotEmpty String name, @NotNull @NotEmpty String surname, @NotEmpty @NotNull String email, @NotNull @NotEmpty String password, @NotNull @NotEmpty UserRole userRole) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

    public Long getId() {
        return id;
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

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "VinnsluUser{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userRole=" + userRole +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VinnsluUser)) return false;

        VinnsluUser user = (VinnsluUser) o;

        if (!username.equals(user.username)) return false;
        if (!name.equals(user.name)) return false;
        if (!surname.equals(user.surname)) return false;
        if (!email.equals(user.email)) return false;
        if (!password.equals(user.password)) return false;
        return userRole == user.userRole;
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + userRole.hashCode();
        return result;
    }
}
