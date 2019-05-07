/**
 * <p>
 * Card Sorter - Problem 1 of the Arrays Assignments 
 * Reads from a file with studentdent names and studentMarks. Sorts by highest to lowest studentMarks as well as alphabetically.
 * </p>
 *
 * @author Maia Mandel, Maya Weir, Megan Holmes
 * @version 1.0, April 1, 2019
 */

import java.io.*;
import java.util.*;

public class CountingCards
{ 
  /**
   * sortCards() will reads from the original file, store the data location of each card in a hand in an array, then calculate points and display cards based on that array.
   * Credit: Meghan Hendrickson for array to indicate cards idetifiers
   *
   *  Variable Name         Type           Purpose
   * <b>line</b>           String         stores the line that is being processed and saved from file.
   * <b>type</b>           String         stores the value of a card in the deck.
   * <b>suit</b>           String         stores the suit of a card in the deck.
   * <b>rpos</b>           int            stores the row position of a card in the deck.
   * <b>cpos</b>           int            stores the column position of a card in the deck.
   * <b>score</b>          int            stores the score of the hand.
   * <b>handCount</b>        int      keeps track of the game number 
   * <b>counts</b>        int       keeps track of the number of hands
   * <b>input</b>          BufferedReader used to read from file.
   * <b>cardData</b>        int [][]      used to sort each card in a hand, column represents value and row represent suit.
   */
  public void sortCards ()
  {
    String line = " ", type = " ", suit = " ";
    int score = 0, handCount = 1, count = 0;
    int [] cardNum =new int [4];
    int rpos = 0, cpos = 0;
    BufferedReader input;
    
    try
    {
      int [] [] cardData = new int [13] [4]; //declare array to hold card data;    
      input = new BufferedReader (new FileReader ("cards.txt")); //reset BufferedReader
      line = input.readLine();
      while (line!=null)
      {
        score = 0;
        for (int i = 0; i<26;i+=2)
        {
          if (line.charAt (i) == '2'||line.charAt (i) == '3'||line.charAt (i) == '4'||line.charAt (i) == '5'||line.charAt (i) == '6'||line.charAt (i) == '7'||line.charAt (i) == '8'||line.charAt (i) == '9')//(line.charAt (i) >= (int)'2'-50 && line.charAt (i) <= (int)'9'-50)
            cpos = (int)line.charAt (i)-50;
          else if (line.charAt (i) == 'T')
            cpos = 8;
          else if (line.charAt (i) == 'J')
            cpos = 9;
          else if (line.charAt (i) == 'Q')
            cpos = 10;
          else if (line.charAt (i) == 'K')
            cpos = 11;
          else if (line.charAt (i) == 'A')
            cpos = 12;
          if (line.charAt (i+1) == 'S')
            rpos = 0;
          else if (line.charAt (i+1)=='H')
            rpos = 1;
          else if (line.charAt (i+1) == 'D')
            rpos = 2;
          else if (line.charAt (i+1) =='C')
            rpos = 3;
          cardData [cpos] [rpos] = 1;
        }
        //sort and print
        for (int g = 0; g<4; g++)
        {
          for (int k = 12; k>= 0; k--)
          {
            if (cardData [k][g] == 1)
            {                
              if (k >= 0 &&k <=7)
                type = k+2+"";
              else if (k==8)
                type = 10+"";
              else if (k==9)
              {
                type = "Jack"; 
                score = score +1;
              }
              else if (k==10)
              {
                type = "Queen"; 
                score = score+2;
              }
              else if (k==11)
              {
                type = "King";
                score = score+3;
              }
              else if (k==12)
              {
                type = "Ace";
                score = score+4;
              }
              if (g == 0)
              {
                suit = "Spades";
                cardNum [0] = cardNum [0] +1;
              }
              else if (g == 1)
              {
                suit = "Hearts";
                cardNum [1] = cardNum [1] +1;
              }
              else if (g == 2)
              {
                suit = "Diamonds";
                cardNum [2] = cardNum [2] +1;
              }
              else if (g == 3)
              {
                suit = "Clubs";
                cardNum [2] = cardNum [2] +1;
              }
              
              System.out.println (type +" of "+ suit);
            }
          }
        }
        for (int q = 0; q<4; q++)
        {
          if (cardNum [q] == 0)
            score = score +3;
          if (cardNum [q] == 1)
            score = score +2;
          if (cardNum [q] == 2)
            score = score +1;
        }
        System.out.println ("Score: "+score);
        System.out.println (" ");
        count++;
        if (count ==4)
        {
          handCount++;
          System.out.println ("Hand "+ handCount);
          count =0;
        }
        line= input.readLine();
      }
    }
    catch (java.io.IOException e)
    {
      System.out.println ("Oh No! An error occured");
    }
  }    
  
    /**
   * Main method actually runs the program and creates an instance for CountingCards.
   */
  public static void main (String []args)
  {
    CountingCards c = new CountingCards();
    c.sortCards();
  }
}