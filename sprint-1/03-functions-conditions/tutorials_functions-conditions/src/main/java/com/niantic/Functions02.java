package com.niantic;

public class Functions02
{
    public static void main(String[] args)
    {
        // add your code here
        displayTeamScores( rank: 1, teamName: "Georgia", q1:15, q2:12, q3:7:, q4:14);
        displayTeamScores(rank);

        //function signature
        // displayTeamScores - name of the function
        // void - return type
    }
    
    public static void displayTeamScores(int rank, String teamName, int q1, int q2, int q3, int q4)
    {
        int finalScore = q1 + q2 + q3 + q4;

        System.out.printf("(%d) %s \n", rank, teamName);
        System.out.println("-------------------------------");
        System.out.println(" Q1  Q2  Q3  Q4  Final");
        System.out.println(" --- --- --- --- -----");
        System.out.printf(" %-2d  %-2d  %-2d  %-2d  %d \n",q1, q2,q3,q4,finalScore);
        System.out.println();
    }
}
