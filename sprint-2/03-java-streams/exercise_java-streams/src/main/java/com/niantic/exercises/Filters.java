package com.niantic.exercises;

import com.niantic.models.LineItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Filters
{

    /*
    1) using Java Stream functions, filter the *lineItems* list to include only line items for the given company name

    hint: the company name should not be required to be the full name, but could be a partial name
     */
    public List<LineItem> filterByCompanyName(List<LineItem> lineItems, String companyName)
    {

        String lowerCaseCompanyName = companyName.toLowerCase();


        var companyItems = lineItems.stream()
                .filter(lineItem -> lineItem.getCompanyName()
                        .toLowerCase().contains(lowerCaseCompanyName))
                .toList();

        return companyItems;
    }

    /*
    2) using Java Stream functions, filter the *lineItems* list to include only line items for the given category name

    hint: the user may search by only a partial category name
     */
    public List<LineItem> filterByCategory(List<LineItem> lineItems, String categoryName)
    {
        String upperCaseCategoryName = categoryName.toUpperCase();
        // i just want to see if it will work the same way as long as the contains statement has the same case

        var categoryItems = lineItems.stream()
                .filter(lineItem -> lineItem.getCategoryName()
                        .toUpperCase().contains(upperCaseCategoryName))
                        .toList();

        return categoryItems;
//        return new ArrayList<>();

    }

    /*
    3) using Java Stream functions, filter the *lineItems* list to include only line items for the given product name

    hint: the user may search by only a partial product name
     */
    public List<LineItem> filterByProduct(List<LineItem> lineItems, String productName)
    {
        String lowerCaseProductNames = productName.toLowerCase();

        var lineItemByProductName = lineItems.stream()
                .filter(lineItem -> lineItem.getProductName()
                        .toLowerCase().contains(lowerCaseProductNames))
                .toList();

        return lineItemByProductName;

    }

    /*
    4) using Java Stream functions, filter the *lineItems* list to include only line items for the given order year

     */
    public List<LineItem> filterByYear(List<LineItem> lineItems, int year)
    {

        var itemsByYear = lineItems.stream()
                .filter(lineItem -> lineItem.getOrderDate().getYear() == year)
                .toList();

//        return new ArrayList<>();
        return itemsByYear;
    }


    /*
    5) using Java Stream functions, filter the *lineItems* list to include only line items for the given order id

     */
    public List<LineItem> filterByOrderId(List<LineItem> lineItems, int orderId)
    {
        var itemsByOrderId = lineItems.stream()
                .filter(lineItem -> lineItem.getOrderId() == orderId)
                .toList();

        return itemsByOrderId;
    }
}
