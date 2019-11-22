package com.brotech.localgoods.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity(name = "price_intervals")
public class PriceInterval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private Long price;

    @NotNull
    @Column
    @Min(1)
    private Long intervalMin;

    @Column
    private Long intervalMax;

    @NotNull
    @ManyToOne
    @JoinColumn
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getIntervalMin() {
        return intervalMin;
    }

    public void setIntervalMin(Long intervalMin) {
        this.intervalMin = intervalMin;
    }

    public Long getIntervalMax() {
        return intervalMax;
    }

    public void setIntervalMax(Long intervalMax) {
        this.intervalMax = intervalMax;
    }


    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
