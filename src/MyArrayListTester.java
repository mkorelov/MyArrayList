///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:    Main.java
// File:               MyArrayListTester.java
//
// Author:             Michael Korelov | korelovmichael@gmail.com
//
///////////////////////////////////////////////////////////////////////////////

import static org.junit.Assert.assertEquals;
import org.junit.Test;

// TODO: Things to test
// - each myarraylist only holds one type
// - myarraylist works for multiple object types

/**
 * Contains the JUnit Tests.
 *
 * Bugs: N/A
 *
 * @author Michael Korelov
 */
public class MyArrayListTester {

    /**
     * Sanity test of the Default constructor.
     */
    @Test
    public void testDefaultConstructor() {
        MyArrayList ls = new MyArrayList("String");

        assertEquals(0, ls.size());

        assertEquals(10, ls.getCapacity());
    }

    /**
     * Santiy test of the constructor w/ a specified capcity.
     */
    @Test
    public void testConstructor() {
        MyArrayList ls = new MyArrayList("Integer", 20);

        assertEquals(0, ls.size());

        assertEquals(20, ls.getCapacity());
    }

    /**
     * Sanity test of the insert() method.
     */
    @Test
    public void testInsert() {
        MyArrayList ls = new MyArrayList("String");

        assertEquals(true, ls.insert("Cat",0));

        assertEquals("Cat", ls.get(0));
    }

    /**
     * Sanity test of the contains() method.
     */
    @Test
    public void testContains() {
        MyArrayList ls = new MyArrayList("String");

        assertEquals(false, ls.contains("Dog"));

        ls.insert("Dog",0);

        assertEquals(true, ls.contains("Dog"));
    }

    /**
     * Sanity test of the delete() method.
     */
    @Test
    public void testDelete() {
        MyArrayList ls = new MyArrayList("String");

        ls.insert("Fish", 0);

        assertEquals(true, ls.contains("Fish"));

        ls.delete(0);

        assertEquals(false, ls.contains("Fish"));
    }
}