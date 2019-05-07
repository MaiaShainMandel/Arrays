/**
* <p>
* Student Marks - Problem 2 of the Arrays Assignments
* Reads from a file with studentdent names and studentMarks. Sorts by highest to lowest studentMarks as well as alphabetically.
* </p>
*
* Variable Name         Type          Purpose
* <b>student</b>            String []     stores the names of the student in an array of 35
* <b>studentMark</b>           int []     stores the studentMarks of the student in an array of 35
* @author Maia Mandel, Maya Weir, Megan Holmes
* @version 1.0, April 1, 2019
*/
import java.util.*;
import java.io.*;

public class StudentMarkSorting
{
    String[] student = new String [35];
    int[] studentMark = new int [35];

    /**
     * readInput () will reads from the original file, store the data from the file into an arry, and then put it into a new file.
     *
     *  Variables
     * <b>input</b> Scanner for reading input
     * <b>file</b> gets the orginal file
     * <b>x</b> goes to next index of array for each increment of the loop
     * <b>output</b> PrintWriter writes to a file
     */
    public void readInput () throws IOException
    {
	Scanner input = new Scanner (System.in);
	File file = new File ("A7-1.txt");
	int x = 0;

	input = new Scanner (file);

	while (input.hasNextLine ())
	{
	    student [x] = input.nextLine ();
	    studentMark [x] = Integer.parseInt (input.nextLine ());
	    x++;
	}
	input.close ();
	PrintWriter output = new PrintWriter (new BufferedWriter (new FileWriter ("Student Marks A")));
	for (int y = 0 ; y < 35 ; y++)
	{
	    output.println (student [y]);
	    output.println (studentMark [y]);
	}
	output.close ();
    }


    /**
     * sortName () arranges the data in an array in order of the alphabet
     *
     * Local Variables
     * <b>n</b> array length for the while loop
     * <b>maxPositiontition</b> stores position that needs to be switched
     * <b>temp</b> stores element of array temporarily to be switched with other element
     * <b>output</b> PrintWriter writes to a file
     */
    public void sortName () throws IOException
    {
	int n = 35;
	int maxPosition = 0;
	while (n > 1)
	{
	    maxPosition = 0;
	    for (int x = 1 ; x < n ; x++)
		if (student [x].charAt (0) != student [maxPosition].charAt (0))
		{
		    if (student [x].charAt (0) > student [maxPosition].charAt (0))
			maxPosition = x;
		}
		else
		{
		    if (student [x].substring (1).compareTo (student [maxPosition].substring (1)) > 0)
		    {
			maxPosition = x;
		    }
		}

	    String temp = student [maxPosition];
	    student [maxPosition] = student [n - 1];
	    student [n - 1] = temp;
	    int tempM = studentMark [maxPosition];
	    studentMark [maxPosition] = studentMark [n - 1];
	    studentMark [n - 1] = tempM;
	    n--;
	}

	PrintWriter output = new PrintWriter (new BufferedWriter (new FileWriter ("Student Marks B")));
	for (int x = 0 ; x < 35 ; x++)
	{
	    output.println (student [x]);
	    output.println (studentMark [x]);
	}
	output.close ();
    }


    /**
     * sortStudentMarks () original data by studentMarks in order from greatest to least, then puts them into a new file.
     *
     *
     *  Variables
     * <b>n</b> array length for the while loop
     * <b>maxPositiontition</b> stores position that needs to be switched
     * <b>temp</b> stores element of array temporarily to be switched with other element
     * <b>output</b> PrintWriter writes to new file
     */
    public void sortStudentsMarks () throws IOException
    {
	int n = 35;
	int maxPosition = 0;
	while (n > 1)
	{
	    maxPosition = 0;
	    for (int x = 1 ; x < n ; x++)
	    {
		if (studentMark [x] <= studentMark [maxPosition])
		{
		    maxPosition = x;
		}
	    }
	    String temp = student [maxPosition];
	    student [maxPosition] = student [n - 1];
	    student [n - 1] = temp;
	    int tempM = studentMark [maxPosition];
	    studentMark [maxPosition] = studentMark [n - 1];
	    studentMark [n - 1] = tempM;
	    n--;
	}

	PrintWriter output = new PrintWriter (new BufferedWriter (new FileWriter ("Student Marks C")));
	for (int x = 0 ; x < 35 ; x++)
	{
	    output.println (student [x]);
	    output.println (studentMark [x]);
	}
	output.close ();
    }

      /**
     * display ()  will displays data to user's screen
     */
    public void display ()
    {
	for (int i = 0 ; i < 35 ; i++)
	{
	    System.out.print (student [i] + "     ");
	    System.out.println (studentMark [i]);
	}
    }

    /**
     * Main method actually runs the program
     */
    public static void main (String[] args) throws IOException
    {
	StudentMarkSorting m = new StudentMarkSorting ();
	m.readInput ();
	m.display ();
	m.sortName ();
	m.display ();
	m.sortStudentsMarks ();
	m.display ();
    }
}

