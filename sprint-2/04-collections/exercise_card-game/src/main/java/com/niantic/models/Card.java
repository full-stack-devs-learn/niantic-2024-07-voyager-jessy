//package com.niantic.models;
//
//public class Card
//{
//    private String color;
//    private int number;
//
//    public Card(String color, int number)
//    {
//        this.color = color;
//        this.number = number;
//    }
//
//    public String getColor()
//    {
//        return color;
//    }
//
//    public int getValue()
//    {
//        return number;
//    }
//}
package com.niantic.models;

import java.util.HashMap;
import java.util.Map;

public class Card {
    private String faceValue;
    private String suit;
    private int value;

    public Card(String faceValue, String suit, int value) {
        this.faceValue = faceValue;
        this.suit = suit;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public String getFaceValue() {
        return faceValue;
    }

    public int getValue()
    {
        return value;
    }

    public int getCardFaceValue() {
        return cardValues.get(faceValue);
    }
//lookup map
    private static final Map<String, Integer> cardValues = new HashMap<>() {{
        cardValues.put("A", 14);
        cardValues.put("K", 13);
        cardValues.put("Q", 12);
        cardValues.put("J", 11);
        cardValues.put("10", 10);
        cardValues.put("9", 9);
        cardValues.put("8", 8);
        cardValues.put("7", 7);
        cardValues.put("6", 6);
        cardValues.put("5", 5);
        cardValues.put("4", 4);
        cardValues.put("3", 3);
        cardValues.put("2", 2);

    }};
}