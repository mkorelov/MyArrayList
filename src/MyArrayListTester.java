///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    (name of main application class)
// File:               (name of this class's file)
// Quarter:            (course) Spring 2020
//
// Author:             (your name and email address)
// Instructor's Name:  (name of your instructor)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
// Pair Partner:       (name of your pair programming partner)
// Email:              (email address of your programming partner)
// Instructor's Name:  (name of your partner's instructor)
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   fully acknowledge and credit all sources of help,
//                   other than Instructors and TAs.
//
// Persons:          Identify persons by name, relationship to you, and email.
//                   Describe in detail the the ideas and help they provided.
//
// Online sources:   Avoid web searches to solve your problems, but if you do
//                   search, be sure to include Web URLs and description of
//                   of any information you find.
//////////////////////////// 80 columns wide //////////////////////////////////

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * (Write a succinct description of this class here. You should avoid
 * wordiness and redundancy.)
 *
 * Bugs: (a list of bugs and other problems)
 *
 * @author (your name)
 */
public class MyArrayListTester {
    /**
     * (Write a succinct description of this method here.)
     * 
     * @param (parameter name) (Describe the first parameter here)
     * @return (description of the return value)
     */
    @Test
    public void testDefaultConstructor() {
        MyArrayList ls = new MyArrayList();
        assertEquals(ls.size(), 0);
        assertEquals(ls.getCapacity(), 10);
    }

    /**
     * (Write a succinct description of this method here.)
     * 
     * @param (parameter name) (Describe the first parameter here)
     * @return (description of the return value)
     */
    @Test
    public void testConstructor() {
        MyArrayList ls = new MyArrayList(20);
        assertEquals(ls.size(), 0);
        assertEquals(ls.getCapacity(), 20);
    }

    /**
     * (Write a succinct description of this method here.)
     * 
     * @param (parameter name) (Describe the first parameter here)
     * @return (description of the return value)
     */
    @Test
    public void testInsert() {
        MyArrayList ls = new MyArrayList();

        assertEquals(ls.insert("Cat",0), true);
        assertEquals(ls.get(0), "Cat");

        assertEquals(ls.insert("Dog", 1), true);
        assertEquals(ls.get(1), "Dog");

        assertEquals(ls.insert("Snake", 0), true);
        assertEquals(ls.get(0), "Snake");
        assertEquals(ls.get(1), "Cat");
        assertEquals(ls.get(2), "Dog");

        assertEquals(ls.insert("Fish", 5), false);

        assertEquals(ls.insert("Pig", 100), false);

        assertEquals(ls.insert("Hamster", -1), false);
    }

    /**
     * (Write a succinct description of this method here.)
     * 
     * @param (parameter name) (Describe the first parameter here)
     * @return (description of the return value)
     */
    @Test
    public void testContains() {
        MyArrayList ls = new MyArrayList();
        ls.insert("Cat",0);
        ls.insert("Dog", 1);
        ls.insert("Snake", 0);
        ls.insert("Fish", 5);
        ls.insert("Pig", 100);
        ls.insert("Hamster", -1);

        assertEquals(ls.contains("Cat"), true);
        assertEquals(ls.contains("Dog"), true);
        assertEquals(ls.contains("Snake"), true);
        assertEquals(ls.contains("Fish"), false);
        assertEquals(ls.contains("Pig"), false);
        assertEquals(ls.contains("Hamster"), false);
    }

    /**
     * (Write a succinct description of this method here.)
     * 
     * @param (parameter name) (Describe the first parameter here)
     * @return (description of the return value)
     */
    @Test
    public void testDelete() {
        MyArrayList ls = new MyArrayList();
        ls.insert("Cat",0);
        ls.insert("Dog", 1);
        ls.insert("Snake", 0);
        ls.insert("Fish", 5);
        ls.insert("Pig", 100);
        ls.insert("Hamster", -1);

        assertEquals(ls.delete(5), null);
        assertEquals(ls.delete(0), "Snake");
        assertEquals(ls.delete(0), "Cat");
        assertEquals(ls.delete(2), null);
        assertEquals(ls.delete(100), null);
        assertEquals(ls.delete(0), "Dog");

        assertEquals(ls.contains("Snake"), false);
        assertEquals(ls.contains("Cat"), false);
        assertEquals(ls.contains("Dog"), false);
    }
}
