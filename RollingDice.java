/*
*  Project :  A07b - Rolling Dice
*  File    :  RollingDice.java
*  Name    :  Chris Langdale
*  Date    :  21/11/2017 (21/11/2017)
*  Description :  
      Write an application to simulate the rolling of two dice.

      Your application should roll the dice 36,000,000 times.
      
      Use a multi-dimensional array to store the sum (value),
      the frequency of each value in your simulation,
      the statistical probability of each value,
      and the simulated probability of each value.
      
      Include in the results displayed the value rolled,
      the frequency of the value, the statistical probability of the value,
      and the simulation probability.

*/

import java.util.Random;

public class RollingDice
{
   //class variables and arrays
   private Random randomNumber = new Random();
   private double resultsArray[][] = new double[11][4];
   
   //method to roll the dice
   public int rollTheDice()
   {
     int diceOne, diceTwo, rollResult;
     diceOne = 1 + randomNumber.nextInt(6);
     diceTwo = 1 + randomNumber.nextInt(6);
     return rollResult = diceOne + diceTwo;
      
   }//end of method rollTheDice
   
   //method for array logic
   public void logic(int rolls)
   {
      //print start message
      System.out.printf("Rolling the dice [%d] times...%n", rolls);
      
      //freq column
      for(int i = 1; i <= rolls; i++)
      {
         //frequency = how many times the roll equaled the value
         int index = rollTheDice() - 2;
         ++resultsArray[index][1];
         
      }//end of for frequency
      
      //value column
      for(int i = 0; i < resultsArray.length; i++)
      {
         //list of possible values of the roll starting with 2
         resultsArray[i][0] = i + 2;
         
         /*simulated probability =
         frequency / total rolls
         */
         resultsArray[i][3] = resultsArray[i][1] / rolls;
         
         /*statistical probability =
           how many combinations will equal the value /
           how many total combinations there are
         */
         switch(i)
         {
            case 0 : resultsArray[i][2] = (double) 1 / 36; break;
            case 1 : resultsArray[i][2] = (double) 2 / 36; break;
            case 2 : resultsArray[i][2] = (double) 3 / 36; break;
            case 3 : resultsArray[i][2] = (double) 4 / 36; break;
            case 4 : resultsArray[i][2] = (double) 5 / 36; break;
            case 5 : resultsArray[i][2] = (double) 6 / 36; break;
            case 6 : resultsArray[i][2] = (double) 5 / 36; break;
            case 7 : resultsArray[i][2] = (double) 4 / 36; break;
            case 8 : resultsArray[i][2] = (double) 3 / 36; break;
            case 9 : resultsArray[i][2] = (double) 2 / 36; break;
            case 10 : resultsArray[i][2] = (double) 1 / 36; break;
         }//end of switch
           
      }//end of for value
      
   }//end of logic
   
   //print resultsArray
   public void display()
   {
      System.out.printf("%s%10s%10s%10s%n", "value", "freq", "stat_prob", "sim_prob");
      
      for(int row = 0; row < resultsArray.length; row++)
      {
         System.out.printf("%5.0f%10.0f%10f%10f%n",
         resultsArray[row][0], resultsArray[row][1], resultsArray[row][2], resultsArray[row][3]);
         
      }//end of for rows
      
   }//end of display
   
   //start of main
   public static void main(String[] args)
   {
      RollingDice craps = new RollingDice();
      
      craps.logic(36000000);
      craps.display();
      
   }//end of main
   
}//end of class RollingDice