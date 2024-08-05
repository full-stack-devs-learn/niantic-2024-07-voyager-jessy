package com.niantic.northwind_models;

public class Product
{
    private int id;
    private String name;
    private int supplierId;
    private int categoryId;
    private String description; //quantity per unit
    private double price;
    private int stockLevel;
    private int unitsOnOrder;
    private int reorderlevel;
    private boolean discontinued;


    public Product()
    {

    }
// i used command n, create new constructor and selected the variables i wanted passed as parameters
    // but it is better to get to know how to do this by hand
    public Product(int id, String name, int supplierId, int categoryId, String description, double price, int stockLevel, int unitsOnOrder, int reorderlevel, boolean discontinued) {
        this.id = id;
        this.name = name;
        this.supplierId = supplierId;
        this.categoryId = categoryId;
        this.description = description;
        this.price = price;
        this.stockLevel = stockLevel;
        this.unitsOnOrder = unitsOnOrder;
        this.reorderlevel = reorderlevel;
        this.discontinued = discontinued;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public String setName(String name){
        this.name = name;
    }

}
