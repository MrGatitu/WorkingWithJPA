package com.example.WorkingWithJPA;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    Long id;
    String firstName;
    String lastName;

    public Customer(
        Long id,
        String firstName,
        String lastName  
    ){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;

    }
}