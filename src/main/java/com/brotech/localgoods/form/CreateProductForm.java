package com.brotech.localgoods.form;

import com.brotech.localgoods.enums.UnitType;
import com.brotech.localgoods.model.PriceInterval;

import java.util.List;

public class CreateProductForm {
    private String title;
    private String description;
    private Long categoryId;
    private Long stock;
    private UnitType unitType;
    private List<PriceInterval> priceIntervals;

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public List<PriceInterval> getPriceIntervals() {
        return priceIntervals;
    }

    public void setPriceIntervals(List<PriceInterval> priceIntervals) {
        this.priceIntervals = priceIntervals;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }
}
