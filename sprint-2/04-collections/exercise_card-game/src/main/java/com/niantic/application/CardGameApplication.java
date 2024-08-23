package com.niantic.application;

import com.niantic.models.Card;
import com.niantic.models.Deck;
import com.niantic.models.Player;
import com.niantic.ui.ColorCodes;
import com.niantic.ui.UserInterface;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CardGameApplication {
    Scanner input = new Scanner(System.in);

    //players
    private Player player1 = new Player("Jessy");
    private Player player2 = new Player("Gregor");
    Player winner = new Player("no winner");


    // new game pieces per game
    Deck deck = new Deck();
    ArrayList<Player> players = new ArrayList<>();

    //this is what will run on the Main
    public void run()
    {
        System.out.println("-------------------------------------");
        System.out.println("    Hello ... ");
        System.out.println();
        System.out.println("   ...do you want to play a game? \uD83D\uDE08");
        System.out.println("        Yes or No? (y/n)");
        System.out.println("-------------------------------------");
        String response = input.nextLine()
                .strip()
                .toLowerCase();

        if (response.equalsIgnoreCase("y")) {

            startGame();

            welcomePlayers();

            playHand();

            declareWinner();
        }
        if (response.equalsIgnoreCase("n")) {
            System.out.println("-------------------------------------");
            System.out.println("You lose every shot you never take.");
            System.out.println();
            System.out.println(ColorCodes.RED + "        \uD83D\uDC80 Goodbye \uD83D\uDC80"+ ColorCodes.RESET);
            System.out.println("-------------------------------------");

        }

    }

    public void startGame()
    {
        addPlayers();
        dealCards();
    }

    private void dealCards()
    {
        deck.shuffle();
        //this should give each player equal playing cards of 26
        while (!deck.isEmpty()) {
            for (Player player : players) {
                Card card = deck.dealCard();
                player.dealTo(card);
            }
        }

    }

    private void addPlayers()
    {
        players.add(player1);
        players.add(player2);
    }

    public void playHand()
    {

        System.out.println("Welcome " + player1.getName() + " and " + player2.getName());
        System.out.println("You both have been dealt " + player1.getHandsize() + " cards");
        System.out.println();
        System.out.println("-------------------------------------");
        System.out.println("Press Enter to continue...");
        input.nextLine();

        while (player1.hasCards() && player2.hasCards()) {
            playGame();
        }


    }

    public void welcomePlayers(){

        System.out.println("-------------------------------------");
        System.out.println();
        System.out.println("   Welcome to War, the Card Game!");
        System.out.println();
        System.out.println("-------------------------------------");
        System.out.println("Press Enter to start the game...");
        input.nextLine();

        //I double checked to make sure both players were dealt the same amount initially by printing both
        //player1 and player2.getHandSize; they were the same at 26!
    }

    public void declareWinner() {
        for (Player player : players) {
            if (!player1.hasCards()) {
                System.out.println();
                System.out.println(ColorCodes.YELLOW + "************************************************" + ColorCodes.RESET);
                System.out.println("   WINNER:" + player2.getName() + "wins the game!");
                System.out.println(ColorCodes.YELLOW + "************************************************" + ColorCodes.RESET);

            }
            if (!player2.hasCards()) {
                System.out.println();
                System.out.println(ColorCodes.YELLOW + "************************************************" + ColorCodes.RESET);
                System.out.println("   WINNER:" + player1.getName() + "wins the game!");
                System.out.println(ColorCodes.YELLOW + "************************************************" + ColorCodes.RESET);
            }
        }

    }

    public void playGame() {

        Card card1 = player1.playCard();
        Card card2 = player2.playCard();

        System.out.println(player1.getName() + " plays: " + card1.getCardFaceValue());
        System.out.println(player2.getName() + " plays: " + card2.getCardFaceValue());
        System.out.println();
        System.out.println("-------------------------------------");
        System.out.println("Press Enter to continue...");
        input.nextLine();


        if (card1.getCardFaceValue() > card2.getCardFaceValue()) {
            System.out.println("-------------------------------------");
            System.out.println();
            System.out.println(card1.getCardFaceValue() + " has the higher card value.");
            System.out.println(player1.getName() + " wins this round and takes both cards!");
            player1.recieveCardFromWin(card1);
            player1.recieveCardFromWin(card2);
            System.out.println();
            System.out.println("   " + player1.getName() + " now has: " + player1.getHandsize() + " cards!");
            System.out.println();
            System.out.println("-------------------------------------");
            System.out.println("Press Enter to continue...");
            input.nextLine();

        }
        else if (card2.getCardFaceValue() > card1.getCardFaceValue()) {
            System.out.println("-------------------------------------");
            System.out.println();
            System.out.println(card2.getCardFaceValue() + " has the higher card value.");
            System.out.println(player2.getName() + " wins this round and takes both cards.");
            player2.recieveCardFromWin(card1);
            player2.recieveCardFromWin(card2);
            System.out.println();
            System.out.println("   " + player2.getName() + " now has: " + player2.getHandsize() + " cards!");
            System.out.println();
            System.out.println("-------------------------------------");
            System.out.println("Press Enter to continue...");
            input.nextLine();
        }
        //first war match
        else if (card1.getCardFaceValue() == card2.getCardFaceValue()) {
            System.out.println("-------------------------------------");
            System.out.println();
            System.out.println("   The cards match...");
            System.out.println("     " + ColorCodes.BLACK_BACKGROUND + ColorCodes.RED + "\uD83D\uDDE1 A war has begun! \uD83D\uDDE1" + ColorCodes.RESET);
            System.out.println();
            System.out.println("-------------------------------------");
            System.out.println("Press Enter to start the war...");
            input.nextLine();

            Card card3 = player1.playCard();
            Card card4 = player2.playCard();
            System.out.println(player1.getName() + " plays: " + card3.getCardFaceValue());
            System.out.println(player2.getName() + " plays: " + card4.getCardFaceValue());

            if (card3.getCardFaceValue() > card4.getCardFaceValue()) {
                System.out.println(player1.getName() + " wins this round and takes all cards.");
                player1.recieveCardFromWin(card1);
                player1.recieveCardFromWin(card2);
                player1.recieveCardFromWin(card3);
                player1.recieveCardFromWin(card4);
                System.out.println(player1.getName() + " now has: " + player1.getHandsize() + " cards!");
                System.out.println("-------------------------------------");
                System.out.println("Press Enter to continue...");
                input.nextLine();

            } else if (card4.getCardFaceValue() > card3.getCardFaceValue()) {
                System.out.println(player2.getName() + " wins this round and takes all cards.");
                player2.recieveCardFromWin(card1);
                player2.recieveCardFromWin(card2);
                player2.recieveCardFromWin(card3);
                player2.recieveCardFromWin(card4);
                System.out.println(player2.getName() + " now has: " + player2.getHandsize() + " cards!");
                System.out.println("-------------------------------------");
                System.out.println("Press Enter to continue...");
                input.nextLine();

            }
            //second war match
            else if (card3.getCardFaceValue() == card4.getCardFaceValue()) {
                System.out.println(ColorCodes.BLACK_BACKGROUND + ColorCodes.RED + "The cards match AGAIN..." + ColorCodes.RESET);
                System.out.println( "A war has thickened!");
                System.out.println("-------------------------------------");
                System.out.println("Press Enter to continue the war...");

                Card card5 = player1.playCard();
                Card card6 = player2.playCard();
                System.out.println(player1.getName() + " plays: " + card5.getCardFaceValue());
                System.out.println(player2.getName() + " plays: " + card6.getCardFaceValue());

                if (card5.getCardFaceValue() > card6.getCardFaceValue()) {
                    System.out.println(player1.getName() + " wins this round and takes all cards.");
                    player1.recieveCardFromWin(card1);
                    player1.recieveCardFromWin(card2);
                    player1.recieveCardFromWin(card3);
                    player1.recieveCardFromWin(card4);
                    player1.recieveCardFromWin(card5);
                    player1.recieveCardFromWin(card6);
                    System.out.println(player1.getName() + " now has: " + player1.getHandsize() + " cards!");
                    System.out.println("-------------------------------------");
                    System.out.println("Press Enter to continue...");
                    input.nextLine();
                }

                else if (card6.getCardFaceValue() > card5.getCardFaceValue()) {
                    System.out.println(player2.getName() + " wins this round and takes all cards.");
                    player2.recieveCardFromWin(card1);
                    player2.recieveCardFromWin(card2);
                    player2.recieveCardFromWin(card3);
                    player2.recieveCardFromWin(card4);
                    player2.recieveCardFromWin(card5);
                    player2.recieveCardFromWin(card6);
                    System.out.println(player2.getName() + " now has: " + player2.getHandsize() + " cards!");
                    System.out.println("-------------------------------------");
                    System.out.println("Press Enter to continue...");
                    input.nextLine();
                }

                //end of war matches if tied
                else if (card3.getCardFaceValue() == card4.getCardFaceValue()) {
                    System.out.println(ColorCodes.BOLD + ColorCodes.RED_BACKGROUND + "Unbelievable! The cards match AGAIN!" + ColorCodes.RESET);
                    System.out.println();
                    System.out.println(player1.getName() + ", " + player2.getName() + " you fought valiantly");
                    System.out.println();
                    System.out.println("As with all things in life, this war must too come to an end...");
                    System.out.println("-------------------------------------");
                    System.out.println("Press Enter to continue");
                    input.nextLine();
//
                    System.out.println("and it ends with a TIE");
                    System.out.println(player1.getName() + " gets all their cards back: " + card1.getCardFaceValue() + card3.getCardFaceValue() + card5.getCardFaceValue());
                    player1.recieveCardFromWin(card1);
                    player1.recieveCardFromWin(card3);
                    player1.recieveCardFromWin(card5);
                    System.out.println(player2.getName() + " gets all their cards back: " + card2.getCardFaceValue() + card4.getCardFaceValue() + card6.getCardFaceValue());
                    player2.recieveCardFromWin(card2);
                    player2.recieveCardFromWin(card4);
                    player2.recieveCardFromWin(card6);
                    System.out.println(player1.getName() + " now has " + player1.getHandsize() + " cards");
                    System.out.println();
                    System.out.println(player2.getName() + " now has "+ player2.getHandsize() + " cards");
                    System.out.println();
                    System.out.println("-------------------------------------");
                    System.out.println("Press Enter to continue playing the game.");
                    input.nextLine();

                }


            }
        }


    }

}
