package com.niantic.models;

import java.util.HashMap;
import java.util.Map;

public class Card {
    private String faceValue;
    private String suits;
    private static HashMap <String, Integer> cardValue;


//    public Card(String faceValue, String suits, int value) {
//        this.faceValue = faceValue;
//        this.suits = suits;
//        this.value = value;
//    }

    public Card(String faceValue, String suits) {
        this.faceValue = faceValue;
        this.suits = suits;

    }



    public String getSuit() {
        return suits;
    }

    public String getFaceValue() {
        return faceValue;
    }

    public int getValue()
    {
        return cardValues.get(faceValue);
    }


//lookup map
    private static final Map<String, Integer> cardValues = new HashMap<>() {{
        put("A", 14);
        put("K", 13);
        put("Q", 12);
        put("J", 11);
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

    public int getCardFaceValue() {
        return cardValues.get(faceValue);
    }
}