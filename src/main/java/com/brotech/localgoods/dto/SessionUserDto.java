package com.brotech.localgoods.dto;

public class SessionUserDto {

    private Long id;

    private String name;

    private Boolean isSeller;

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

    public Boolean getIsSeller() {
        return isSeller;
    }

    public void setIsSeller(Boolean seller) {
        this.isSeller = seller;
    }
}