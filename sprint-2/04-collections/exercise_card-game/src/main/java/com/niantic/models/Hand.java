package com.niantic.models;

import java.util.LinkedList;
import java.util.Queue;

public class Hand {
    public int getCardFaceValue;
    private Queue<Card> hand = new LinkedList<>();

    public boolean hasCards() {
        return !hand.isEmpty();
        //check if the hand is empty/ player loses
    }

    public void gainCard(Card card) {
        hand.offer(card);
        //either when originally dealt card or if war is won
    }

    public Card playCard() {
        return hand.poll();
        //remove card on top of face down hand - FIFO

    }


    public int getCardFaceValue(Card hand)
    {
        return hand.getCardFaceValue();


    }

    public void dealTo(Card card) {
        hand.add(card);
    }

    public int getHandSize(){
        return hand.size();
    }

}











