package com.niantic;

import java.math.RoundingMode;

public class ClairesCookies
{
    @SuppressWarnings("unused") 
    private final double TAX_RATE = .0575;
    private final double CLAIRES_COOKIE_DOZEN = 12.95;;
    /*
     * Claire's cookies cost $12.95 a dozen.
     *
     * A customer places an order with a quantity
     * of how many dozen cookies they want to order.
     *
     * This calculateSubtotal function should calculate
     * the price of an order before the cost of tax
     * is added.
     *
     * calculateSubtotal(1) -> 12.95
     * calculateSubtotal(2) -> 25.90
     * calculateSubtotal(5) -> 64.75
     */
    public double calculateSubtotal(int quantity)
    {
      double subtotal = (CLAIRES_COOKIE_DOZEN * quantity);


        return subtotal;
    }


    /*
     * Claire is required to charge her customers
     * a 5.75% tax rate on all orders.
     *
     * Her cookies cost $12.95 a dozen.
     *
     * A customer places an order with a quantity
     * of how many dozen cookies they want to order.
     *
     * The calculateTotal function should calculate
     * the price of an order AFTER the cost of tax
     * is added.
     *
     * calculateTotal(1) -> 13.69
     * calculateTotal(2) -> 27.39
     * calculateTotal(5) -> 68.47
     */
    public double calculateTotal(int quantity)
    {
        double cookieOrderBT = CLAIRES_COOKIE_DOZEN * quantity;
        double cookieTax = cookieOrderBT * TAX_RATE;
        double cookieOrderTotal = cookieTax + cookieOrderBT;



        return cookieOrderTotal;
    }

    /*
     * Snicker Doodles, Chocolate Chip and Frosted Chocolate Chip
     * cookies are the most popular cookies that Claire sells.
     *
     * Following is the cost of the cookies:
     * -------------------------------------
     * Snicker Doodles:        $12.95 / dz
     * Chocolate Chip:         $13.95 / dz
     * Frosted Chocolate Chip: $15.95 / dz
     *
     * For these popular orders, customers
     * can just choose how many dozen of each popular
     * cookie they would like to have.
     *
     * Parameters:
     * snickerDozen = quantity of Snicker Doodles Dozens
     * chocolateDozen = quantity of Chocolate Chip Dozens
     * frostedDozen = quantity of Frosted Chocolate Chip Dozens
     *
     * Calculate the total price of an order.
     * (Don't forget to add the tax)
     *
     * calculateQuickOrder(1,1,1) -> 45.31
     * calculateQuickOrder(0,3,2) -> 77.99
     * calculateQuickOrder(3,1,0) -> 55.84
     * calculateQuickOrder(2,0,2) -> 61.12
     */
    public double calculateQuickOrder(int snickerDozen, int chocolateDozen, int frostedDozen)
    {   double costOfSnickerDozen = 12.95 * snickerDozen;
        double costOfChocolateDozen = 13.95 * chocolateDozen;
        double costOfFrostedDozen = 15.95 * frostedDozen;
        double orderTotal = costOfSnickerDozen + costOfFrostedDozen + costOfChocolateDozen;
        double taxTotal = orderTotal * TAX_RATE;
        double orderTotalTaxed = orderTotal + taxTotal;


        return orderTotalTaxed;
    }

    /*
     * Claire also allows customers to customize their
     * cookies. They can choose to add chocolate chips
     * or add frosting to any of her cookies for an
     * additional cost.
     *
     * Extra ingredient cost
     * ---------------------
     * base cookie price: $12.95 / dz
     * chocolate chips:   $ 1.00 / dz
     * frosting:          $ 2.00 / dz
     *
     * Parameters:
     * quantity = the number of dozens of cookies ordered
     * hasChocolateChips = if true, add $1.00 to the cost of each dozen
     * hasFrosting = if true, add $2.00 to the cost of each dozen
     *
     * calculateCustomOrder (1, true, true) -> 16.87
     * calculateCustomOrder (2, true, false) -> 29.50
     * calculateCustomOrder (3, false, true) -> 47.43
     * calculateCustomOrder (5, true, false) -> 73.76
     */
    public double calculateCustomOrder (int quantity, boolean hasChocolateChips, boolean hasFrosting)
    {
        // create a double if condition statement to check hasChocolateChips
        double  addedChocCharge;
        if (hasChocolateChips){
            addedChocCharge = 1.00 * quantity;}
        else { addedChocCharge = 0;}

        // create double if condition statement for hasFrosting
        double addedFrostCharge;
        if (hasFrosting){
            addedFrostCharge = 2.00 * quantity;}
        else { addedFrostCharge = 0;}


        // start with identifying cookie order total (- customizations)
        double costOfCookies = CLAIRES_COOKIE_DOZEN * quantity;
       // account for customizations
        double costOfCustomCookies = costOfCookies + (addedFrostCharge) + (addedChocCharge);

        //calculate tax
        double orderTotalTaxed = (costOfCustomCookies * TAX_RATE) + costOfCustomCookies;

        return orderTotalTaxed;
    }

}