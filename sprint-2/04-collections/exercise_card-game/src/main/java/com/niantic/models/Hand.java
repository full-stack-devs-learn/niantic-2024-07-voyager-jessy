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





//}
//
//    public int getPointValue() {
//        // i just want to see what the value of the played card is
//
//        for (Card card : cards) {
//            int playValue =  card.getValue();
//        }
//        return  pl







//    private final ArrayList<Card> cards = new ArrayList<>();
//
//    public ArrayList<Card> getCards()
//    {
//        return cards;
//    }
//
//    public int getPointValue()
//    {
//        // return sum of all card points
//
//        for(Card card : cards)
//        {
//            sum += card.getValue();
//        }
//        return sum;
//    }
//
//    public int getCardCount()
//    {
//        return cards.size();
//    }
//
//    public void dealTo(Card card)
//    {
//        cards.add(card);
//    }



