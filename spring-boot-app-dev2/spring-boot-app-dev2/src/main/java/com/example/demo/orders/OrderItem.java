package com.example.demo.orders;

import com.example.demo.entity.MerchItem;
import com.example.demo.entity.Order;
import com.example.demo.enums.Colour;
import jakarta.persistence.*;

import java.awt.*;

@Entity
@Table(name = "order_item")
public class OrderItem
{
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "merch_item_id", referencedColumnName = "id")
    private MerchItem orderItem;

    int quantity;

    @Enumerated(EnumType.STRING)
    Colour colour;

    Double total_price;

}
