package com.niantic.models;

public class Subcategory {
    private int subcategoryId;
    private int categoryId;
    private String subcategoryName;
    private String description;


    public Subcategory() {
    }

    public Subcategory(int subcategoryId, int categoryId, String subcategoryName, String description) {
        this.subcategoryId = subcategoryId;
        this.categoryId = categoryId;
        this.subcategoryName = subcategoryName;
        this.description = description;
    }

    public int getSubcategoryId() {
        return subcategoryId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getSubcategoryName() {
        return subcategoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
