package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "orders")
public class Order
{
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    Date date;
    private Long student_id;
    Double total_price;
}
