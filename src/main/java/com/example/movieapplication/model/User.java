package com.example.movieapplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "korisnik")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    @OneToMany
    private List<Ticket>tickets;
    @OneToOne
    @JoinColumn(name = "shoppingCart_id", referencedColumnName = "id")
    private ShoppingCart shoppingCart;
}
