package com.example.movieapplication.service;

import com.example.movieapplication.model.ShoppingCart;
import com.example.movieapplication.model.Ticket;

import java.util.List;

public interface ShoppingCartService {

    public List<Ticket> findAllTicketsInShoppingCart(Long id);

    ShoppingCart addProductToShoppingCart(String username, Long ticketId);



}
