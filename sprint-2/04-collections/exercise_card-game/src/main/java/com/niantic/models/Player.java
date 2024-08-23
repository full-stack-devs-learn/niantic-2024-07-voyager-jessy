package com.niantic.models;

public class Player
{
    private String name;
    private Hand hand;

    public Player(String name)
    {
        this.name = name;
        hand = new Hand();
    }

    public String getName()
    {
        return name;
    }

    public void dealTo(Card card)
    {
        hand.dealTo(card);
    }

    public void recieveCardFromWin(Card card) {hand.gainCard(card); }


    public Hand getHand()
    {
        return hand;
    }

    public Card playCard()
    {
        return hand.playCard();
    }

    public boolean hasCards()
    {
        return hand.hasCards();
    }

    public int getHandValue()
    {
        return hand.getCardFaceValue;
    }

    public int getHandsize(){ return hand.getHandSize();}

}
