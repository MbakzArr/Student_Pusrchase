package com.example.demo.entity;

import com.example.demo.enums.Colour;
import com.example.demo.enums.MerchCategory;
import com.example.demo.enums.Size;
import jakarta.persistence.*;

@Entity //JPA
@Table(name = "merch_item")
public class MerchItem
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    int quantity;
    double price;

    String name;

    @Enumerated(EnumType.STRING)
    MerchCategory category;
    @Enumerated(EnumType.STRING)
    Size size;
    @Enumerated(EnumType.STRING)
    Colour colour;

    public MerchItem() {
    }

    public MerchItem(int quantity, Long id, double price, String name, MerchCategory category, Size size, Colour colour) {
        this.quantity = quantity;
        this.id = id;
        this.price = price;
        this.name = name;
        this.category = category;
        this.size = size;
        this.colour = colour;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MerchCategory getCategory() {
        return category;
    }

    public void setCategory(MerchCategory category) {
        this.category = category;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }
}