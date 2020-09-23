package com.example.servingwebcontent.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Please fill the message")
    @Length(max = 255, message = "Name too long(more than 255B)")
    private String name;
    private double price;
    @Length(max = 2048, message = "Description too long(more than 2kB)")
    private String description;

    public Product() {
    }

    @Length(max = 255, message = "Description too long(more than 255B)")
    private String category;
    private String filename;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Product(Long id, String name, double price, String description, String category, String filename) {
        this.id=id;
        this.name=name;
        this.price=price;
        this.description=description;
        this.category=category;
        this.filename=filename;
    }
}
