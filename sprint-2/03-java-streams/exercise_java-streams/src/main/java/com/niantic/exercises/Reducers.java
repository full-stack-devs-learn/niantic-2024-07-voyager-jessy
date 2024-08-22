package com.niantic.exercises;

import com.niantic.models.LineItem;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Reducers
{

    /*
    1) using one or more Java Stream functions calculate the total sales amount
       for all line items in the given list.

       hint: use the getLineTotal() method to calculate the sales total

     */
    public double totalSales(List<LineItem> lineItems)
    {
        var totalAmount = lineItems.stream()
                .map(LineItem::getLineTotal)
                .reduce(0.0, Double::sum);
        //this is the SAME code as below, but written with lambda expressions (java did it :] just to get familiar)

//        var totalAmount = lineItems.stream()
//                .map(lineItem -> lineItem.getLineTotal())
//                .reduce(0.0,(temp, number) -> temp + number);

        return totalAmount;
    }

    /*
    2) using one or more Java Stream functions calculate the average sales amount
       per line items in the given list.

     */
    public double averageSalesPerLineItem(List<LineItem> lineItems)
    {
        var lineAmount = lineItems.stream()
                .mapToDouble(LineItem::getLineTotal)
                .reduce(0, (numb1, numb2) -> numb1+numb2);

        var lineQuantity = lineItems.stream()
                .map(lineItem -> lineItem.getQuantity())
                .toList();

        var avgSale = lineAmount/ lineQuantity.size();


        return avgSale;
    }

    /*
    3) using one or more Java Stream functions calculate the average sales amount
       per items in the given list.

       hint: unlike problem number 2, we are not looking for the average of line totals
       we are looking for the average of each item (line items can have multiple quantities
       of a single item)

     */
    public double averageSalesPerItem(List<LineItem> lineItems)
    {
        var totalAmount = lineItems.stream()
                .map(LineItem::getLineTotal)
                .reduce(0.0, Double::sum);

        var itemTotal = lineItems.stream()
                .map(lineItem -> lineItem.getQuantity())
                .reduce(0, Integer::sum);;

        var avgSalePerItem = totalAmount/itemTotal;



        return avgSalePerItem;
    }

    /*
    4) using one or more Java Stream functions calculate the total number
       of items that were purchased.

       hint: line items can have multiple quantities of an item

     */
    public int totalItemCount(List<LineItem> lineItems)
    {
        var totalQuantity = lineItems.stream()
                .map(lineItem -> lineItem.getQuantity())
                .reduce(0, (num1, num2) -> num1+num2);


        return totalQuantity;
    }

    /*
    5) using one or more Java Stream functions calculate the average number
       of items that were purchased per line item.

     */
    public double averageItemCount(List<LineItem> lineItems)
    {
        var totalQuantityPerLineItem = lineItems.stream()
                .map(lineItem -> lineItem.getQuantity())
                .reduce(0, (num1, num2) -> num1+num2);

         var avgPerLineItem = (totalQuantityPerLineItem.doubleValue()/lineItems.size());

        return avgPerLineItem;
    }

    /*
    6) using one or more Java Stream functions find the most expensive line item.

     */
    public double maxLineItem(List<LineItem> lineItems)
    {
        double mostExpensiveLineItem = lineItems.stream()
                .mapToDouble(lineItem ->lineItem.getLineTotal())
                .reduce(0, (numb1, numb2) -> numb1 > numb2 ? numb1:numb2);

        return mostExpensiveLineItem;
    }

    /*
    7) using one or more Java Stream functions find the least expensive line item.

        hint: the least expensive line item is not $0.00

     */
    public double minLineItem(List<LineItem> lineItems)
    {

        double mostExpensiveLineItem = lineItems.stream()
                .mapToDouble(lineItem ->lineItem.getLineTotal())
                .reduce(0, (numb1, numb2) -> numb1 > numb2 ? numb1:numb2);
        //im calling this because I know that this is the HIGHEST value in line totals
        // && I don't want my lowest to be 0, because with the identity, that's where it starts
        // and rather than guessing a number that may or may not be the lowest in the long list,
        // I'd rather start at a known high point and work my way down to find the lowest value of the list


        double leastExpensiveLineItem = lineItems.stream()
                .mapToDouble(lineItem -> lineItem.getLineTotal())
                .reduce(mostExpensiveLineItem, (numb1, numb2) -> numb1 < numb2 ? numb1: numb2);



        return leastExpensiveLineItem;
    }

}
