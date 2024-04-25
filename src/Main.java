///////////////////////////////////////////////////////////////////////////////
//
// Title:              MyArrayList
// Files:              MyArrayList.java | MyArrayListTester.java
// Author:             Michael Korelov
// Email:              korelovmichael@gmail.com
//
///////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;

/**
 * Class that contains the main method. Used to compare functionality of
 * java's ArrayList and MyArrayList;
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
        ArrayList<Integer> ls = new ArrayList<Integer>();
        ls.add(0,2);
        System.out.println(ls.get(0));
    }
}