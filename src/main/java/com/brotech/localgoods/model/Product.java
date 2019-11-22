package com.brotech.localgoods.model;

import com.brotech.localgoods.enums.UnitType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private String name;

    @NotNull
    @Column
    private String description;

    @NotNull
    @Column
    private Long price;

    @NotNull
    @Column
    private Long stock;

    @NotNull
    @Column
    @Enumerated(EnumType.STRING)
    private UnitType unitType;

    @ManyToOne
    @JoinColumn
    private Category category;

    @OneToMany(mappedBy = "product")
    private Set<PriceInterval> priceIntervals;

    @OneToMany(mappedBy = "product")
    private Set<OrderEntry> orderEntries;

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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<PriceInterval> getPriceIntervals() {
        return priceIntervals;
    }

    public void setPriceIntervals(Set<PriceInterval> priceIntervals) {
        this.priceIntervals = priceIntervals;
    }

    public Set<OrderEntry> getOrderEntries() {
        return orderEntries;
    }

    public void setOrderEntries(Set<OrderEntry> orderEntries) {
        this.orderEntries = orderEntries;
    }

}
