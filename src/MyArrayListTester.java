///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:    Main.java
// File:               MyArrayListTester.java
// Author:             Michael Korelov | korelovmichael@gmail.com
//
///////////////////////////////////////////////////////////////////////////////

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Contains the JUnit Tests: Unit & Integration Tests.
 *
 * Bugs: N/A
 *
 * @author Michael Korelov
 */
public class MyArrayListTester {

    // Unit Tests
    /**
     * Sanity test of the Default constructor.
     */
    @Test
    public void testDefaultConstructor1() {
        MyArrayList<String> ls = new MyArrayList<String>();

        assertEquals(0, ls.size());

        assertEquals(10, ls.getCapacity());
    }

    /**
     * Unit test of the Default constructor. Works for other object types.
     */
    @Test
    public void testDefaultConstructor2() {
        MyArrayList<Integer> ls = new MyArrayList<Integer>();

        assertEquals(0, ls.size());

        assertEquals(10, ls.getCapacity());
    }

    /**
     * Santiy test of the constructor w/ a specified capcity.
     */
    @Test
    public void testConstructor1() {
        MyArrayList<Integer> ls = new MyArrayList<Integer>(20);

        assertEquals(0, ls.size());

        assertEquals(20, ls.getCapacity());
    }

    /**
     * Unit test of the Default constructor. Works for other object types.
     */
    @Test
    public void testConstructor2() {
        MyArrayList<Character> ls = new MyArrayList<Character>(15);

        assertEquals(0, ls.size());

        assertEquals(15, ls.getCapacity());
    }

    /**
     * Sanity test of the insert() method.
     */
    @Test
    public void testInsert1() {
        MyArrayList<String> ls = new MyArrayList<String>();

        assertEquals(true, ls.insert("Cat",0));

        assertEquals("Cat", ls.get(0));
    }

    /**
     * Unit test of the insert() method.
     */
    @Test
    public void testInsert2() {
        MyArrayList<String> ls = new MyArrayList<String>();

        assertEquals(true, ls.insert("Cat",0));
    }

    /**
     * Sanity test of the contains() method.
     */
    @Test
    public void testContains() {
        MyArrayList<String> ls = new MyArrayList<String>();

        assertEquals(false, ls.contains("Dog"));

        ls.insert("Dog",0);

        assertEquals(true, ls.contains("Dog"));
    }

    /**
     * Sanity test of the delete() method.
     */
    @Test
    public void testDelete() {
        MyArrayList<String> ls = new MyArrayList<String>();

        ls.insert("Fish", 0);

        assertEquals(true, ls.contains("Fish"));

        ls.delete(0);

        assertEquals(false, ls.contains("Fish"));
    }

    // Integration Tests
}