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

    public enum suit{
        SPADES, HEARTS, DIAMONDS, CLUBS
    }


    @Override
    public int compareTo(Card other) {
//        return 0;
        // todo: Exercise 1: implement Comparable<Card>
//        int suits = this.suit.compareTo(other.suit);
//        if (suits != 0) {
//            return suits;
//        } else {
//            return Integer.compare(this.getPointValue(), other.getPointValue());
//
//        }
        if(this.getPointValue() > other.getPointValue()){return 1;}
        else if (this.getPointValue() == other.getPointValue()) {return 0;

        }

    }
}
