package com.niantic.models;

import java.util.ArrayList;
import java.util.Collections;


public class Deck
{
    private ArrayList<Card> cards;

    public Deck()
    {
        // build the deck of cards
        cards = new ArrayList<>();

        String[] faceValues = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        String[] suits = {"Clubs","Diamonds","Hearts","Spades"};
        int[] value = {2,3,4,5,6,7,8,9,10,11,12,13,14};



        for(String suit : suits)
        {
            for (int i = 0; i < faceValues.length; i++) {

                Card card = new Card(faceValues[i], suit, value[i]);
                cards.add(card);

            }
        }

        shuffle();
    }

    public int getCardCount()
    {
        return cards.size();
    }


    public Card dealCard()
    {
        Card card = cards.removeFirst();
        return card;
    }

    //b/c we want to deal all the cards we need to know when cards are empty, that's when we are done dealing
    public boolean isEmpty()
    {
        return cards.isEmpty();
    }

    //not sure yet but I might want to move this to win pile, because you want to shuffle your personal hand when you win more cards
    public void shuffle()
    {
        Collections.shuffle(cards);
    }
}
