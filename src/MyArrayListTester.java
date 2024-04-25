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
 * Contains the JUnit Tests: Unit & Integration Tests. get(idx), size(), &
 * getCapacity() are tested within the tests for other methods.
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
     * Unit test of the Default constructor. Works for other types.
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
     * Unit test of the insert() method. Insert when full.
     */
    @Test
    public void testInsert2() {
        MyArrayList<String> ls = new MyArrayList<String>(1);

        assertEquals(0, ls.size());

        assertEquals(1, ls.getCapacity());

        assertEquals(true, ls.insert("Cat",0));

        assertEquals("Cat", ls.get(0));

        assertEquals(1, ls.size());

        assertEquals(0, ls.getCapacity());

        assertEquals(true, ls.insert("Dog",1));

        assertEquals("Cat", ls.get(0));

        assertEquals("Dog", ls.get(1));

        assertEquals(2, ls.size());

        assertEquals(0, ls.getCapacity());

        assertEquals(true, ls.insert("Snake",0));

        assertEquals("Cat", ls.get(1));

        assertEquals("Dog", ls.get(2));

        assertEquals("Snake", ls.get(0));

        assertEquals(3, ls.size());

        assertEquals(1, ls.getCapacity());
    }

    /**
     * Unit test of the insert() method. Insert duplicates.
     */
    @Test
    public void testInsert3() {
        MyArrayList<String> ls = new MyArrayList<String>(1);

        assertEquals(true, ls.insert("Cat",0));

        assertEquals("Cat", ls.get(0));

        assertEquals(true, ls.insert("Cat",1));

        assertEquals("Cat", ls.get(0));

        assertEquals("Cat", ls.get(1));
    }

    /**
     * Unit test of the insert() method. Insert into list of inital
     * capacity of 0.
     */
    @Test
    public void testInsert4() {
        MyArrayList<Integer> ls = new MyArrayList<Integer>(0);

        assertEquals(false, ls.insert(5,1));

        assertEquals(true, ls.insert(2,0));

        assertEquals(true, ls.insert(5,1));
    }

    /**
     * Unit test of the insert() method. Insert at front.
     */
    @Test
    public void testInsert5() {
        MyArrayList<Integer> ls = new MyArrayList<Integer>();

        assertEquals(true, ls.insert(0,0));

        assertEquals(true, ls.insert(1,0));

        assertEquals(true, ls.insert(2,0));

        assertEquals(3, ls.size());

        assertEquals(7, ls.getCapacity());

        assertEquals((Integer) 2, ls.get(0));

        assertEquals((Integer) 1, ls.get(1));

        assertEquals((Integer) 0, ls.get(2));
    }

    /**
     * Unit test of the insert() method. Insert at back.
     */
    @Test
    public void testInsert6() {
        MyArrayList<Integer> ls = new MyArrayList<Integer>();

        assertEquals(true, ls.insert(2,0));

        assertEquals(true, ls.insert(1,1));

        assertEquals(true, ls.insert(0,2));

        assertEquals(3, ls.size());

        assertEquals(7, ls.getCapacity());

        assertEquals((Integer) 2, ls.get(0));

        assertEquals((Integer) 1, ls.get(1));

        assertEquals((Integer) 0, ls.get(2));
    }

    /**
     * Unit test of the insert() method. Insert in middle.
     */
    @Test
    public void testInsert7() {
        MyArrayList<Integer> ls = new MyArrayList<Integer>();

        assertEquals(true, ls.insert(0,0));

        assertEquals(true, ls.insert(1,1));

        assertEquals(true, ls.insert(2,2));

        assertEquals(true, ls.insert(10,1));

        assertEquals(4, ls.size());

        assertEquals(6, ls.getCapacity());

        assertEquals((Integer) 2, ls.get(3));

        assertEquals((Integer) 1, ls.get(2));

        assertEquals((Integer) 10, ls.get(1));

        assertEquals((Integer) 0, ls.get(0));
    }

    /**
     * Sanity test of the contains() method.
     */
    @Test
    public void testContains1() {
        MyArrayList<String> ls = new MyArrayList<String>();

        assertEquals(false, ls.contains("Dog"));

        ls.insert("Dog",0);

        assertEquals(true, ls.contains("Dog"));
    }

    /**
     * Unit test of the contains() method.
     */
    @Test
    public void testContains2() {
        MyArrayList<Integer> ls = new MyArrayList<Integer>();

        assertEquals(true, ls.insert(10,0));

        assertEquals(true, ls.contains(10));

        assertEquals(false, ls.insert(3,10));

        assertEquals(false, ls.contains(3));
    }

    /**
     * Unit test of the contains() method. Duplicates.
     */
    @Test
    public void testContains3() {
        MyArrayList<String> ls = new MyArrayList<String>();

        ls.insert("Bob", 0);

        ls.insert("Bob", 0);

        ls.delete(0);

        assertEquals(true, ls.contains("Bob"));

        ls.delete(0);

        assertEquals(false, ls.contains("Bob"));
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