package com.niantic.exercises;

import ch.qos.logback.core.read.ListAppender;
import com.niantic.models.LineItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Maps
{

    /*
    1) using a chain of Java Stream functions, convert the list of line items to
       a list of company names.

       The list should not have any duplicate values
       and the list should be sorted alphabetically (A-Z) by company name

     */
    public List<String> mapCompanyNames(List<LineItem> lineItems)
    {
        var listOfCompanyNames = lineItems.stream()
                .map(lineItem -> lineItem.getCompanyName())
                .sorted()
                .distinct()
                .toList();

        return listOfCompanyNames;
    }

    /*
    2) using a chain of Java Stream functions, convert the list of line items to
       a list of category names.

       The list should not have any duplicate values
       and the list should be sorted alphabetically (A-Z) by category name

     */
    public List<String> mapCategories(List<LineItem> lineItems)
    {
        var listOfCategoryNames = lineItems.stream()
                .map(LineItem::getCategoryName)
                .distinct()
                .sorted()
                .toList();

        return listOfCategoryNames;
    }

    /*
    3) using a chain of Java Stream functions, convert the list of line items to
       a list of product names.

       The list should not have any duplicate values
       and the list should be sorted alphabetically (A-Z) by product name

     */
    public List<String> mapProducts(List<LineItem> lineItems)
    {
        var listOfProductNames = lineItems.stream()
                .map(lineItem -> lineItem.getProductName())
                .distinct()
                .sorted()
                .toList();

        return listOfProductNames;
    }

    /*
    4) using a chain of Java Stream functions, convert the list of line items to
       a list of order year.

       The list should not have any duplicate values
       and the list should be sorted numerically (0-9) by year

     */
    public List<String> mapYears(List<LineItem> lineItems)
    {
        var listOfYears = lineItems.stream()
                .map(lineItem -> lineItem.getOrderDate().getYear())
                .distinct()
                .sorted()
                .toList();

        List<String> yearList = new ArrayList<>();
        for (Integer year : listOfYears) {
            yearList.add(year.toString());
            // I needed to convert the new List<Integer> into a String list becuase thats what this class classified as the return type
        }


        return yearList;
    }

    /*
    5) using a chain of Java Stream functions, convert the list of line items to
       a list of order id.

       The list should not have any duplicate values
       and the list should be sorted numerically (0-9) by order id

     */
    public List<String> mapOrderIds(List<LineItem> lineItems)
    {
        var listOfOrderId = lineItems.stream()
                .map(LineItem::getOrderId)
                .distinct()
                .sorted()
                .toList();

        List<String> orderIdList = new ArrayList<>();
        for(Integer orderId : listOfOrderId)
        {
            orderIdList.add(orderId.toString());
        }

        return orderIdList;
    }
}
