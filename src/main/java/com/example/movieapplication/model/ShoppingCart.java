package com.example.movieapplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToMany
    @JoinTable(name = "shopping_cart_tickets")
    private List<Ticket> ticketList;
    @OneToOne(mappedBy = "shoppingCart")
    private User user;
}
