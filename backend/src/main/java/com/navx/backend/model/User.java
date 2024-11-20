package com.navx.backend.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Document(collection = "users")
public class User {
    @Id
    private String id;

    @NotBlank
    @Size(max = 50)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;


    @NotBlank
    @Size(max = 50)
    private String password;

    @NotBlank
    @Size(max = 50)
    private String phoneno;

    @NotBlank
    @Size(max = 50)
    private String address;

    @NotBlank
    private String gender;

    private Set<RoleTypes> roles = new HashSet<>();

    public User() {
    }

    public User(String username, String email, String password, String phoneno, String address, String gender, Set<RoleTypes>roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneno = phoneno;
        this.address = address;
        this.gender = gender;
        this.roles = roles;
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Set<RoleTypes> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleTypes> roles) {
        this.roles = roles;
    }

}