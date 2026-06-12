package org.lessons.java.spring_la_mia_pizzeria_crud.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "pizzas")
public class Pizza {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String name;

    @Lob
    private String description;

    @NotBlank
    private String imageUrl;

    @NotNull
    private Float price;

    @OneToMany(mappedBy = "pizza", cascade = CascadeType.REMOVE)
    private List<Discount> discounts;

    //-------------------------------getter-&-setter-------------------------------------------------------------

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Float getPrice() {
        return price;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }
    @Override
    public String toString() {
        
        return String.format("- %s, pizza %s: %s, il prezzo è %.2f € -", this.id, this.name, this.description, this.price);
    }
}
