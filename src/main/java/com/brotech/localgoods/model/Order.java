package com.brotech.localgoods.model;

import com.brotech.localgoods.enums.DeliveryStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn
    private User customer;

    @ManyToOne
    @JoinColumn
    private User seller;

    @NotNull
    @Column
    private Long totalPrice;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Address deliveryAddress;

    @NotNull
    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    @NotNull
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderEntry> orderEntries;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Set<OrderEntry> getOrderEntries() {
        return orderEntries;
    }

    public void setOrderEntries(Set<OrderEntry> orderEntries) {
        this.orderEntries = orderEntries;
    }
}
