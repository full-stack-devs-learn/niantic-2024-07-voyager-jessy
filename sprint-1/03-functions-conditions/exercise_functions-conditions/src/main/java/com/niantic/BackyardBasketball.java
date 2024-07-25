package com.niantic;

import java.util.Scanner;

public class BackyardBasketball {
    /*
     * Teams that play in the backyard league want to be able
     * to calculate their winning percentage.
     *
     * Each team knows how many games they have won and how many
     * games they have lost. When they call this function they
     * will provide their wins and losses.
     *
     * You need to perform the calculation and return their
     * winning percentage as a whole number.
     *
     * Example:
     * If a team has won 7 games and lost 3 games their winning
     * percentage is 70%.
     *
     * calculateWinningPercentage(7, 3) -> 70
     * calculateWinningPercentage(5, 5) -> 50
     * calculateWinningPercentage(5, 10) -> 33
     *
     */


    public int calculateWinningPercentage(int gamesWon, int gamesLost) {
        int totalGames = gamesWon + gamesLost;
        double percentageGamesWon = ((double) gamesWon / totalGames) * 100;
        int data = (int) percentageGamesWon;


        return data;
    }

    /*
     * The calculatePointsScored function should calculate
     * the number of points a player scored in a game.
     *
     * shotPercentage = the percent of shots made
     * shotsTaken = the number of shots the player took
     * isThree = if true, the player shot a 3 pointer otherwise a 2
     *
     * calculatePointsScored(70, 10, false) -> 14
     * calculatePointsScored(70, 10, true) -> 21
     * calculatePointsScored(67, 15, false) -> 20
     *
     */
    public int calculatePointsScored(int shotPercentage, int shotsTaken, boolean isThree) {
        int pointsPerShot;
            if (isThree) {
            pointsPerShot = 3;}
            else {
            pointsPerShot = 2;
        }
        double shotRealPercentage = (double)shotPercentage / 100;
        double playerShots = shotsTaken * (double)shotRealPercentage;
        double playerPoints = (playerShots * pointsPerShot) ;
        int wholePlayerPoints = (int)playerPoints;



        return wholePlayerPoints;
    }


    /*
     * Calculate the minimum number of shots that are required
     * to score the desired number of points.
     *
     * shotPercentage = the estimated % of shots that will go in (whole number)
     * desiredScore = the number of points you want to score
     * isThree = if true, the player will shoot a 3 pointer otherwise a 2
     *
     * Example:
     * If a player has a 50% scoring average, and he wants to score 10 points,
     * how many shots will he have to take (if he is NOT shooting 3 pointers)
     *
     * calculateShotsRequired(50, 10, false) -> 10
     *
     * calculateShotsRequired(50, 10, true) -> 8
     * calculateShotsRequired(75, 15, true) -> 7
     * calculateShotsRequired(80, 18, true) -> 8
     * calculateShotsRequired(67, 24, false) -> 18     *
     *
     */
    public int calculateShotsRequired(int shotPercentage, int desiredScore, boolean isThree) {
        // the variable that I want to find in order to achieve each player's desired point value


        //if statement that will help determine if boolean is true/ what value shots will be made
        double basketsNeeded;
        int requiredShots;

        if (isThree){
            basketsNeeded = desiredScore / 3.0;
        }
        else {
            basketsNeeded  = desiredScore / 2.0;
            }

        basketsNeeded =  Math.ceil(basketsNeeded);
        // find baskets needed / percentage but kept as a whole number
        double actualPercent = ((basketsNeeded * 100) / shotPercentage);
        //convert these values to a integer AND make sure that it is rounding up here as well to get correct value
        requiredShots = (int)Math.ceil(actualPercent);


        return requiredShots;
    }
}