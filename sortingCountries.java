/**
 * 
 * The sortingCountries class will read from a file called Countries-Populations.txt
 * and sort the data by countries and population.
 *
 * Variable Name         Type          Purpose
 * <b>countryName</b>   ArrayList<String> stores the name of each country
* <b>capital</b>        ArrayList<String> stores the name of each captial of each country
* <b>area</b>           ArrayList<String> stores the area of each country
* <b>population</b>     ArrayList<String> stores the poopulation of each country
* 
 * @author Maya Weir, Maia Mandel, Megan Holmes
 * @version 1 2019.02.02
 */

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class sortingCountries
{
  ArrayList <String> countryName = new ArrayList <String>();
  ArrayList <String> capital = new ArrayList <String>();
  ArrayList <String> area = new ArrayList <String>();
  ArrayList <String> population = new ArrayList <String>();
  
/**
 *  readInput () will reads from the original file, store the data from the file into an arry, and then put it into a new file.
     *
     *  Variables
     * <b>spaceCount</b> int to track spaces per line
     * <b>temp</b> int used to temporlalirly hold the values being switched
     * <b>line</b> String used to read and hold values of each line
     * <b>input</b> BufferedReader reads files
     *  readInput () will reads from the original file, store the data from the file into an arry, and then put it into a new file.
     * <b>multiWordCountries</b> hard coded array used to hold all countries with multiple word names
 * */
  
  public void readInput () throws IOException
  {
    int spaceCount=0;
    int temp = 0;
    String line;
    BufferedReader input;
    input = new BufferedReader(new FileReader("Countries-Population.txt"));
    String[] multiWordCountries = {"Antigua and Barbuda", "Bosnia and Herzegovina", "Brunei Darussalam", "Burkina Faso", "Cabo Verde", "Cape Verde", "Central African Republic", "Congo, Democratic Republic of the", "Congo, Republic of", "Costa Rica", "Czech Republic", "Côte D'Ivoire", "Côte d'Ivoire", "Dominican Republic", "East Timor", "El Salvador", "Equatorial Guinea", "Guinea Bissau", "Korea, North", "Korea, South", "Marshall Islands", "Myanmar (Burma)", "New Zealand", "Papua New Guinea", "Saint Lucia", "San Marino", "Saudi Arabia", "Sierra Leone", "Solomon Islands", "South Africa", "South Sudan", "Sri Lanka", "St. Kitts and Nevis", "St. Lucia", "St. Vincent and the Grenadines", "São Tomé and Príncipe", "Trinidad and Tobago", "United Arab Emirates", "United Kingdom", "United States", "Vatican City", "Western Sahara"};
    line = input.readLine ();
    while (line != null)
    {
      String countryAndCap = "";
      String[] lineArray = line.split(" ");
      population.add(lineArray[lineArray.length-1]);
      area.add(lineArray[lineArray.length-2]);
      for (int i = 0; i < lineArray.length-2; i++)
      {
        if (i != 0)
          countryAndCap += " ";
        countryAndCap += lineArray[i];
      }
      for (String c : multiWordCountries)
      {
        if (countryAndCap.contains (c))
        {
          countryName.add(c);
          capital.add(countryAndCap.substring (countryAndCap.indexOf (countryName.get(countryName.size()-1))+countryName.get(countryName.size()-1).length()));
          break;
        }
        else 
        {
          countryName.add(countryAndCap.split (" ")[0]);
          capital.add(countryAndCap.substring(countryAndCap.indexOf (countryName.get(countryName.size()-1))+countryName.get(countryName.size()-1).length()));
          break;
        }
      }
      line = input.readLine ();
    }
    input.close();
  }
  /**
 *  sortByCountry ()sorts and outputs each country and population by country name.
     *
     *  Variables
     * <b>n</b> int that holds the size of each country name
     * <b>maxPos</b> int used to hold the position of the highest index value
 * */
  
  public void sortByCountry ()
  {
    int n = countryName.size();
    while (n > 1)
    {
      int maxPos = 0;
      for (int k = 1; k < n; k++)
        if (countryName.get(k).compareTo(countryName.get(maxPos)) > 0)
        maxPos = k;
      String temp = countryName.get(maxPos);
      String temp2 = population.get(maxPos);
      countryName.set(maxPos, countryName.get(n-1));
      population.set(maxPos, population.get(n-1));
      countryName.set(n-1, temp);
      population.set(n-1, temp2);
      n--;
    }
    
    PrintWriter output;
    String fileName = "sortedByCountry.txt";
    try 
    {
      output = new PrintWriter (new FileWriter (fileName));
      int i = 0;
      for ( i = 0; i<149; i++)
      {
        output.println (countryName.get(i) + "\t\t\t" + population.get(i));
        i++;
      }
      output.close ();
    }
    catch (IOException e) {}
  }
  /**
 *  sortByPopulation ()sorts and outputs each country and name by country population.
     *
     *  Variables
     * <b>n</b> int that holds the size of each country name
     * <b>maxPos</b> int used to hold the position of the highest index value
 * */
  
  public void sortByPopulation ()
  {
    int n = countryName.size();
    while (n > 1)
    {
      int maxPos = 0;
      for (int k = 1; k < n; k++) {
        if (Integer.parseInt(String.join("",population.get(k).split(","))) < Integer.parseInt(String.join("",population.get(maxPos).split(","))))
          maxPos = k;
      }
      String temp = countryName.get(maxPos);
      String temp2 = population.get(maxPos);
      countryName.set(maxPos, countryName.get(n-1));
      population.set(maxPos, population.get(n-1));
      countryName.set(n-1, temp);
      population.set(n-1, temp2);
      n--;
    }
    
    PrintWriter output;
    String fileName = "sortedByPopulation.txt";
    try 
    {
      output = new PrintWriter (new FileWriter (fileName));
      int i = 0;
      for ( i = 0; i<149; i++)
      {
        output.println (countryName.get(i) + "\t\t\t" + population.get(i));
        i++;
      }
      output.close ();
    }
    catch (IOException e) {}
  }
    /**
 *  Main method actually runs the program and creates an instance of sortingCountires.
 * */
  public static void main (String[]args) throws IOException {
    sortingCountries s = new sortingCountries();
    s.readInput();
    s.sortByCountry ();
    s.sortByPopulation();
  }
}

