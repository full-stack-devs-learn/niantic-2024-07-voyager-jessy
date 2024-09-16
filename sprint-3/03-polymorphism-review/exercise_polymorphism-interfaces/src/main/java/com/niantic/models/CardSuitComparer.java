package com.niantic.models;

import java.util.Comparator;

public class CardSuitComparer implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        if(!o1.getSuit().equals(o2.getSuit()))
        {
            return o1.getSuit().compareTo(o2.getSuit());
        }
        else{
            return o1.getFaceValue().compareTo(o2.getFaceValue());
        }
//
    }
}
