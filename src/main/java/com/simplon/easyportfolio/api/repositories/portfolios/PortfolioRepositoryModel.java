package com.simplon.easyportfolio.api.repositories.portfolios;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="portfolio")
public class PortfolioRepositoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "name")
    private String name;
    @Column(name="firstname")
    private String firstname;
    @Column(name="email")
    private String email;

    public PortfolioRepositoryModel(String title, String name, String firstname, String email){
        this.title = title;
        this.name = name;
        this.firstname = firstname;
        this.email = email;
    }


}
