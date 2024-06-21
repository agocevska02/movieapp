package com.example.movieapplication.service;

import com.example.movieapplication.model.Movie;
import com.example.movieapplication.model.Ticket;
import com.example.movieapplication.model.User;
import jakarta.persistence.ManyToOne;

import java.util.List;

public interface TicketService {
    public Ticket findById(Long id);

    public List<Ticket> getAllTickets();
    public Ticket createTicket(Movie movie,User user,float price,int quantity);
    public Ticket editTicket(Long id,Movie movie,User user,float price,int quantity);
    public Ticket deleteTicket(Long id);

}
