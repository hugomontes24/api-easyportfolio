package com.simplon.easyportfolio.api.repositories.users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user")
public class UserRepositoryModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="firstname")
    private String firstname;
    @Column(name="email")
    private String email;

    public UserRepositoryModel(String name, String email) {
        this.name = name;
        this.email = email;
    }

}
