///////////////////////////////////////////////////////////////////////////////
//
// Title:              MyArrayList
// Files:              MyArrayList.java | MyArrayListTester.java
// Author:             Michael Korelov
// Email:              korelovmichael@gmail.com
//
///////////////////////////////////////////////////////////////////////////////

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

/**
 * Class that contains the main method. Used to debug MyArrayList and compare 
 * functionality with java's ArrayList.
 *
 * Bugs: N/A
 *
 * @author Michael Korelov
 */
public class Main {
    
    /**
     * Main method.
     *
     * @param (String[] args) An array of Strings passed from the command line.
     */
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> ls = new ArrayList<Integer>(0);
        ls.add(0,2);
        System.out.println(ls.get(0));
    }
}