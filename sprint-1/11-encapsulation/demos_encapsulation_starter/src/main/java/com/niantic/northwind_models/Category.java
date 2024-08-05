package com.niantic.northwind_models;

public class Category
{

    private int id;
    // private means that it can only be accessed within this class
    private String name;
    private String description;
    // these three vaariables are 'hidden' and encapsulated so that they cannot be changes


    public Category(int id, String name, String description){
        //must match the name of the class exactly. these help initialize default values for variables
        this.id = id;
        this.name = name;
        this.description = description;
        // this action will decrease the amount of code needed later when we define
        /*the variables
         */

    }

    public int getID()
    {
        return id;

    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
