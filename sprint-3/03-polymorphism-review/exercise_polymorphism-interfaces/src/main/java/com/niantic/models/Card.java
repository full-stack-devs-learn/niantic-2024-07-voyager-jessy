package com.niantic.models;

import java.util.HashMap;
import java.util.Map;

public class Card implements Comparable<Card>
{
    private String suit;
    private String faceValue;

    public Card(String suit, String faceValue)
    {
        this.suit = suit;
        this.faceValue = faceValue;
    }

    public String getSuit()
    {
        return suit;
    }

    public String getFaceValue()
    {
        return faceValue;
    }

    public int getPointValue()
    {
        return cardValues.get(faceValue);
    }

    public String getColor()
    {
        switch (suit.toLowerCase())
        {
            case "hearts":
            case "diamonds":
                return "Red";
            default:
                return "Black";
        }
    }

    // lookup map
    private static final Map<String, Integer> cardValues = new HashMap<>()
    {{
        put("A", 11);
        put("K", 10);
        put("Q", 10);
        put("J", 10);
        put("10", 10);
        put("9", 9);
        put("8", 8);
        put("7", 7);
        put("6", 6);
        put("5", 5);
        put("4", 4);
        put("3", 3);
        put("2", 2);
    }};

   private static final Map<String, Integer> suitsValues = new HashMap<>()
   {{
       put("spades", 1);
       put("hearts", 2);
       put("diamonds",3);
       put("clubs",4);
   }};

   private static final Map<String , Integer> allCardOrder = new HashMap<>()
   {{

       put("2", 1);
       put("3", 2);
       put("4", 3);
       put("5", 4);
       put("6", 5);
       put("7", 6);
       put("8", 7);
       put("9", 8);
       put("10", 9);
       put("J", 10);
       put("Q", 11);
       put("K", 12);
       put("A", 13);

   }};

    //this needs to be outside compareTo inorder to properly sort by facevalue
   public int faceOrderComparison(String card1, String otherCard){
       var card1Value = allCardOrder.get(card1);
       var otherCardValue = allCardOrder.get(otherCard);

       return Integer.compare(card1Value, otherCardValue);
   }

    @Override
    public int compareTo(Card other) {

        // todo: Exercise 1: implement Comparable<Card>
        var card1 = this.suit.toLowerCase();
        var otherCard = other.suit.toLowerCase();

        //compare the suits of new variables
        var suitComparison = Integer.compare(
                suitsValues.get(card1),
                suitsValues.get(otherCard));

        if(suitComparison == 0){
            return faceOrderComparison(this.getFaceValue(), other.getFaceValue());
        }
        else{
            return suitComparison;
        }
    }
}
