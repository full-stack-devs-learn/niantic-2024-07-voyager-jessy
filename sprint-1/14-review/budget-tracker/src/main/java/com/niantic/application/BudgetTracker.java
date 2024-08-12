package com.niantic.application;

import com.niantic.models.*;
import com.niantic.services.*;

import java.time.LocalDate;


import java.util.Scanner;
import static java.util.FormatProcessor.FMT;

public class BudgetTracker
{
    Scanner userInput = new Scanner(System.in);
    TransactionsDao transactionsDao = new TransactionsDao();
    UsersDao usersDao = new UsersDao();
    CategoryDao categoryDao = new CategoryDao();
    SubcategoryDao subcategoryDao = new SubcategoryDao();
    VendorDao vendorDao = new VendorDao();


    public void run()
    {

        while(true)
        {
            int choice = homeScreenSelection();
            switch(choice)
            {
                case 1:
                    System.out.println("add transaction");
                    break;
                case 2:
                    System.out.println("reports");
                    break;
                case 3:
                    System.out.println("add user");
                    break;
                case 4:
                    System.out.println("add category");
                    break;
                case 5:
                    System.out.println("add sub category");
                    break;
                case 6:
                    System.out.println("add vendor");
                    break;
                case 0:
                    System.out.println();
                    System.out.println("Thank you for using Northwind!");
                    System.out.println("Goodbye");
                    System.out.println();
                    System.exit(0);
                default:
                    System.out.println("invalid selection");
                    break;
            }
        }

    }

    private int homeScreenSelection()
    {
        System.out.println();
        System.out.println("Budget Tracker");
        System.out.println("--------------------------------------");
        System.out.println("Select from the following options:");
        System.out.println();
        System.out.println("  1) Add Transaction");
        System.out.println("  2) Reports");
        System.out.println("  3) Add User");
        System.out.println("  4) Add Category");
        System.out.println("  5) Add Sub Category");
        System.out.println("  6) Add Vendor");
        System.out.println("  0) Quit");
        System.out.println();

        System.out.print("Enter an option: ");
        return Integer.parseInt(userInput.nextLine());
    }

    public void addTransaction()
    {
        System.out.println();
        System.out.println("Add Transaction");
        System.out.println("-".repeat(100));

        int userId = getUserInt("Enter User Id: ");
        int subcategoryId = getUserInt("Enter Subcategory Id: ");
        int vendorId = getUserInt("Enter Vendor Id: ");
        LocalDate transactionDate = getUserLocalDate("Enter transaction date (ie. yyyy-mm-dd): ");
        double amount = getUserDouble("Enter amount: ");

        System.out.println();


        var transaction = new Transactions()
        {{
            setUserId(userId);
            setSubCategoryId(subcategoryId);
            setVendorId(vendorId);
            setTransactionDate(transactionDate);
            setAmount(amount);
        }};

        try {

            transactionsDao.addTransaction(transaction);

            System.out.println(FMT."\{transaction} has been added.");

            var transactions = transactionsDao.getTransactionById(transaction.getTransactionId());

        }
        catch(Exception no)
        {
            System.out.println(STR."\{transaction} could not be added to the database.");
        }
        waitForUser();

    }

    public void addUser()
    {
        System.out.println();
        System.out.println("Add User");
        System.out.println("-".repeat(100));

        String userName = getUserString("Enter Username: ");
        String firstName = getUserString("Enter First Name: ");
        String lastName = getUserString("Enter Last Name: ");
        String phone = getUserString("Enter phone number (ie. 123-456-7890): ");
        String email = getUserString("Enter email: ");

        var user = new Users()
        {{
            setUserName(userName);
            setFirstName(firstName);
            setLastName(lastName);
            setPhone(phone);
            setEmail(email);
        }};

        try
        {
            usersDao.addUser(user);

            System.out.println((FMT."\{userName} has been added."));

        }
        catch(Exception no){

            System.out.println(STR."\{userName} could not be added to the database. Please try again. ");
        }

        waitForUser();

    }

    public void addCategory()
    {
        System.out.println();
        System.out.println("Add Category");
        System.out.println("-".repeat(100));

        String categoryName = getUserString("Enter category name: ");
        String description = getUserString("Enter description: ");

        System.out.println();

        var category = new Category()
        {{
            setCategoryName(categoryName);
            setDescription(description);
        }};

        try
        {
            categoryDao.addCategory(category);

            System.out.println(STR."\{categoryName} has been added.");

        }
        catch (Exception e)
        {
            System.out.println(STR."There was a problem adding \{categoryName}.");
        }

        waitForUser();

    }

    public void addSubcategory()
    {
        System.out.println();
        System.out.println("Add Sub Category");
        System.out.println("-".repeat(100));

        String subcategoryName = getUserString("Enter subcategory name: ");
        String description = getUserString("Enter description: ");

        System.out.println();

        Subcategory subcategory = new Subcategory()
        {{
            setSubcategoryName(subcategoryName);
            setDescription(description);
        }};

        try
        {
            subcategoryDao.addSubcategory(subcategory);
            System.out.println(STR."\{subcategoryName} has been added.");

        }
        catch (Exception no)
        {
            System.out.println(STR."There was a problem adding \{subcategoryName}.");
        }

        waitForUser();

        }

    public void addVendor()
    {
        System.out.println();
        System.out.println("Add Vendor");
        System.out.println("-".repeat(100));

        String vendorName = getUserString("Enter vendor name: ");
        String website = getUserString("Enter website (ie www.greatwebsite.com): ");

        System.out.println();

        Vendor vendor = new Vendor()
        {{
            setVendorName(vendorName);
            setWebsite(website);
        }};

        try {
            vendorDao.addVendor(vendor);

            System.out.println(STR."\{vendorName} has been added.");
        }
        catch(Exception no)
        {
            System.out.println(STR."\{vendorName} could not be added to the database, please try again.");
        }
        waitForUser();


    }








    //added all of these with gregor
    private void waitForUser()
    {
        System.out.println();
        System.out.println("Press ENTER to continue...");
        userInput.nextLine();
    }

    private String getUserString(String message)
    {
        System.out.print(message);
        return userInput.nextLine();
    }

    private LocalDate getUserLocalDate(String message)
    {
        return  LocalDate.parse(getUserString(message));
    }

    private int getUserInt(String message)
    {
        return Integer.parseInt(getUserString(message));
    }

    private double getUserDouble(String message)
    {
        return Double.parseDouble(getUserString(message));
    }

}
