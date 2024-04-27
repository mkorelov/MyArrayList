///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:    Main.java
// File:               MyArrayListTester.java
// Author:             Michael Korelov | korelovmichael@gmail.com
//
///////////////////////////////////////////////////////////////////////////////

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.ArrayList;

/**
 * Contains the JUnit Tests for MyArrayList: Unit Tests, Integration Tests, and 
 * Comparison Tests to java's ArrayList. get(idx), size(), & getCapacity() are 
 * tested within the tests for other methods.
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
     * Unit test of the Default constructor. Works for other types.
     */
    @Test
    public void testConstructor2() {
        MyArrayList<Character> ls = new MyArrayList<Character>(15);

        assertEquals(0, ls.size());

        assertEquals(15, ls.getCapacity());
    }

    /**
     * Sanity test of the constructor given array.
     */
    @Test
    public void testOtherConstructor1() {
        String[] list = {"no", "yes"};

        MyArrayList<String> ls = new MyArrayList<String>(list);

        assertEquals(2, ls.size());

        assertEquals(0, ls.getCapacity());

        assertEquals("no", ls.get(0));

        assertEquals("yes", ls.get(1));

        assertEquals(true, ls.contains("yes"));

        assertEquals(true, ls.contains("no"));
    }

    /**
     * Unit test of the constructor given array. Works for other types.
     */
    @Test
    public void testOtherConstructor2() { 
        Integer[] list = {2, 1, 5};

        MyArrayList<Integer> ls = new MyArrayList<Integer>(list);

        assertEquals(3, ls.size());

        assertEquals(0, ls.getCapacity());

        assertEquals((Integer) 2, ls.get(0));

        assertEquals((Integer) 1, ls.get(1));

        assertEquals((Integer) 5, ls.get(2));

        assertEquals(true, ls.contains(2));

        assertEquals(true, ls.contains(1));

        assertEquals(true, ls.contains(5));
    }

    /**
     * Unit test of the constructor given array. Empty list.
     */
    @Test
    public void testOtherConstructor3() { 
        String[] list = {};

        MyArrayList<String> ls = new MyArrayList<String>(list);

        assertEquals(0, ls.size());

        assertEquals(0, ls.getCapacity());
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

        assertEquals((Integer) 0, ls.get(0));

        assertEquals(true, ls.insert(1,0));

        assertEquals((Integer) 1, ls.get(0));

        assertEquals((Integer) 0, ls.get(1));

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

        assertEquals((Integer) 2, ls.get(0));

        assertEquals(true, ls.insert(1,1));

        assertEquals((Integer) 2, ls.get(0));

        assertEquals((Integer) 1, ls.get(1));

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

        assertEquals((Integer) 0, ls.get(0));

        assertEquals(true, ls.insert(1,1));

        assertEquals((Integer) 0, ls.get(0));

        assertEquals((Integer) 1, ls.get(1));

        assertEquals(true, ls.insert(2,2));

        assertEquals((Integer) 0, ls.get(0));

        assertEquals((Integer) 1, ls.get(1));

        assertEquals((Integer) 2, ls.get(2));

        assertEquals(true, ls.insert(10,1));

        assertEquals(4, ls.size());

        assertEquals(6, ls.getCapacity());

        assertEquals((Integer) 2, ls.get(3));

        assertEquals((Integer) 1, ls.get(2));

        assertEquals((Integer) 10, ls.get(1));

        assertEquals((Integer) 0, ls.get(0));
    }

    /**
     * Unit test of the insert() method. Invalid index.
     */
    @Test
    public void testInsert8() {
        MyArrayList<Integer> ls = new MyArrayList<Integer>();

        assertEquals(false, ls.insert(8, 11));
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
     * Unit test of the contains() method. Element never existed.
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
    public void testDelete1() {
        MyArrayList<String> ls = new MyArrayList<String>();

        ls.insert("Fish", 0);

        assertEquals(true, ls.contains("Fish"));

        ls.delete(0);

        assertEquals(false, ls.contains("Fish"));
    }

    /**
     * Unit test of the delete() method. Delete when full.
     */
    @Test
    public void testDelete2() {
        MyArrayList<String> ls = new MyArrayList<String>(2);

        ls.insert("Mango", 0);

        ls.insert("Kiwi", 1);

        assertEquals(2, ls.size());

        assertEquals(0, ls.getCapacity());

        assertEquals("Mango", ls.delete(0));

        assertEquals(1, ls.size());

        assertEquals(1, ls.getCapacity());
    }

    /**
     * Unit test of the delete() method. Delete when empty.
     */
    @Test
    public void testDelete3() {
        MyArrayList<String> ls = new MyArrayList<String>();

        assertEquals(null, ls.delete(0));
    }

    /**
     * Unit test of the delete() method. Delete from front.
     */
    @Test
    public void testDelete4() {
        MyArrayList<Character> ls = new MyArrayList<Character>();

        ls.insert('f', 0);
        ls.insert('2', 1);
        ls.insert('$', 2);
        ls.insert('L', 3);
        ls.insert('1', 4);

        assertEquals(5, ls.size());

        assertEquals(5, ls.getCapacity());

        assertEquals((Character) 'f', ls.delete(0));

        assertEquals(4, ls.size());

        assertEquals(6, ls.getCapacity());

        assertEquals((Character)'2', ls.get(0));

        assertEquals((Character)'$', ls.get(1));

        assertEquals((Character)'L', ls.get(2));

        assertEquals((Character)'1', ls.get(3));
    }

    /**
     * Unit test of the delete() method. Delete from back..
     */
    @Test
    public void testDelete5() {
        MyArrayList<Character> ls = new MyArrayList<Character>();

        ls.insert('f', 0);
        ls.insert('2', 1);
        ls.insert('$', 2);
        ls.insert('L', 3);
        ls.insert('1', 4);

        assertEquals(5, ls.size());

        assertEquals(5, ls.getCapacity());

        assertEquals((Character) '1', ls.delete(4));

        assertEquals(4, ls.size());

        assertEquals(6, ls.getCapacity());

        assertEquals((Character)'f', ls.get(0));

        assertEquals((Character)'2', ls.get(1));

        assertEquals((Character)'$', ls.get(2));

        assertEquals((Character)'L', ls.get(3));
    }

    /**
     * Unit test of the delete() method. Delete duplicates.
     */
    @Test
    public void testDelete6() {
        MyArrayList<String> ls = new MyArrayList<String>();

        ls.insert("Fish", 0);

        ls.insert("Fish", 0);

        assertEquals(true, ls.contains("Fish"));

        assertEquals("Fish", ls.delete(0));

        assertEquals(true, ls.contains("Fish"));

        assertEquals("Fish", ls.delete(0));

        assertEquals(false, ls.contains("Fish"));
    }

    /**
     * Unit test of the delete() method. Delete from middle.
     */
    @Test
    public void testDelete7() {
        MyArrayList<Character> ls = new MyArrayList<Character>();

        ls.insert('f', 0);
        ls.insert('2', 1);
        ls.insert('$', 2);
        ls.insert('L', 3);
        ls.insert('1', 4);

        assertEquals(5, ls.size());

        assertEquals(5, ls.getCapacity());

        assertEquals((Character) '$', ls.delete(2));

        assertEquals(4, ls.size());

        assertEquals(6, ls.getCapacity());

        assertEquals((Character)'f', ls.get(0));

        assertEquals((Character)'2', ls.get(1));

        assertEquals((Character)'L', ls.get(2));

        assertEquals((Character)'1', ls.get(3));
    }

    /**
     * Unit test of the delete() method. Invalid index.
     */
    @Test
    public void testDelete8() {
        MyArrayList<Character> ls = new MyArrayList<Character>(2);

        assertEquals(null, ls.delete(4));
    }

    /**
     * Sanity test of the add() method.
     */
    @Test
    public void testAdd1() {
        MyArrayList<String> ls = new MyArrayList<String>();

        assertEquals(true, ls.add("pineapple"));

        assertEquals(true, ls.contains("pineapple"));

        assertEquals(1, ls.size());

        assertEquals(9, ls.getCapacity());
    }

    /**
     * Unit test of the add() method. Add and Insert combinations.
     */
    @Test
    public void testAdd2() {
    }

    /**
     * Unit test of the add() method. Add to full list.
     */
    @Test
    public void testAdd3() {
    }

    /**
     * Unit test of the add() method. Add after removing/deleting.
     */
    @Test
    public void testAdd4() {
    }

    /**
     * Sanity test of the addAll() method.
     */
    @Test
    public void testAddAll1() {
        MyArrayList<String> ls = new MyArrayList<String>();
        String[] list = {"1", "2", "3"};

        assertEquals(true, ls.addAll(list));

        assertEquals(true, ls.contains("1"));

        assertEquals(true, ls.contains("2"));

        assertEquals(true, ls.contains("3"));

        assertEquals("1", ls.get(0));

        assertEquals("2", ls.get(1));

        assertEquals("3", ls.get(2));

        assertEquals(3, ls.size());

        assertEquals(7, ls.getCapacity());
    }

    /**
     * Unit test of the addAll() method. AddAll after removing/deleting.
     */
    @Test
    public void testAddAll2() {
    }

    /**
     * Unit test of the addAll() method. AddAll, Insert, and Add combinations.
     */
    @Test
    public void testAddAll3() {
    }

    /**
     * Unit test of the addAll() method. AddAll when full.
     */
    @Test
    public void testAddAll4() {
    }

    /**
     * Unit test of the addAll() method. AddAll when almost full.
     */
    @Test
    public void testAddAll5() {
    }

    /**
     * Sanity test of the clear() method.
     */
    @Test
    public void testClear1() {
        MyArrayList<Integer> ls = new MyArrayList<Integer>();

        ls.add(3);

        assertEquals(true, ls.contains(3));

        assertEquals((Integer) 3, ls.get(0));

        assertEquals(1, ls.size());

        assertEquals(9, ls.getCapacity());

        ls.clear();

        assertEquals(false, ls.contains(3));

        assertEquals(0, ls.size());

        assertEquals(10, ls.getCapacity());
    }

    /**
     * Unit test of the clear() method. Clear when full.
     */
    @Test
    public void testClear2() {
    }

    /**
     * Unit test of the clear() method. Clear when empty.
     */
    @Test
    public void testClear3() {
    }

    /**
     * Unit test of the clone() method.
     */
    @Test
    public void testClone() {
        MyArrayList<String> ls1 = new MyArrayList<String>();

        MyArrayList<String> ls2 = ls1.clone();

        assertEquals(false, ls1 == ls2);

        assertEquals(true, ls1.equals(ls2));
    }

    /**
     * Sanity test of the ensureCapacity() method.
     */
    @Test
    public void testEnsureCapacity1() {
        MyArrayList<String> ls = new MyArrayList<String>(3);

        assertEquals(3, ls.getCapacity());

        ls.ensureCapacity(5);

        assertEquals(5, ls.getCapacity());
    }

    /**
     * Unit test of the ensureCapacity() method. When full.
     */
    @Test
    public void testEnsureCapacity2() {
    }

    /**
     * Unit test of the ensureCapacity() method. When partially full.
     */
    @Test
    public void testEnsureCapacity3() {
    }

    /**
     * Sanity test of the indexOf() method.
     */
    @Test
    public void testIndexOf1() {
        MyArrayList<String> ls = new MyArrayList<String>();
        
        ls.add("me");

        assertEquals(0, ls.indexOf("me"));
    }

    /**
     * Unit test of the indexOf() method. Duplicate elements.
     */
    @Test
    public void testIndexOf2() {
    }

    /**
     * Unit test of the indexOf() method. Non-duplicate elements.
     */
    @Test
    public void testIndexOf3() {
    }

    /**
     * Unit test of the indexOf() method. Empty list or element doesn't
     * exist.
     */
    @Test
    public void testIndexOf4() {
    }

    /**
     * Sanity test of the isEmpty() method.
     */
    @Test
    public void testIsEmpty1() {
        MyArrayList<String> ls = new MyArrayList<String>();

        assertEquals(true, ls.isEmpty());

        ls.add("anything");

        assertEquals(false, ls.isEmpty());
    }

    /**
     * Unit test of the isEmpty() method. Full list.
     */
    @Test
    public void testIsEmpty2() {
        
    }

    /**
     * Unit test of the isEmpty() method. After removing/deleting.
     */
    @Test
    public void testIsEmpty3() {
    }

    /**
     * Sanity test of the lastIndexOf() method.
     */
    @Test
    public void testLastIndexOf1() {
        MyArrayList<String> ls = new MyArrayList<String>();

        ls.add("me");

        assertEquals(0, ls.indexOf("me"));
    }

    /**
     * Unit test of the lastIndexOf() method. Empty or element
     * doesn't exist.
     */
    @Test
    public void testLastIndexOf2() {
    }

    /**
     * Unit test of the lastIndexOf() method. Duplicate elements.
     */
    @Test
    public void testLastIndexOf3() {
    }

    /**
     * Unit test of the lastIndexOf() method. Non-duplicates elements.
     */
    @Test
    public void testLastIndexOf4() {
    }

    /**
     * Sanity test of the remove() method.
     */
    @Test
    public void testRemove1() {
        MyArrayList<String> ls = new MyArrayList<String>();

        ls.add("you");

        assertEquals(true, ls.remove("you"));
    }

    /**
     * Unit test of the remove() method. Remove/delete combinations.
     */
    @Test
    public void testRemove2() {
    }

    /**
     * Unit test of the remove() method. Remove when full.
     */
    @Test
    public void testRemove3() {
    }

    /**
     * Unit test of the remove() method. Remove when empty
     * or element doesn't exist.
     */
    @Test
    public void testRemove4() {
    }

    /**
     * Unit test of the remove() method. Remve when duplicates.
     */
    @Test
    public void testRemove5() {
    }

    /**
     * Sanity test of the set() method.
     */
    @Test
    public void testSet1() {
        MyArrayList<String> ls = new MyArrayList<String>();

        ls.add("you");

        assertEquals("you", ls.get(0));

        assertEquals("you", ls.set(0, "me"));

        assertEquals("me", ls.get(0));
    }

    /**
     * Unit test of the set() method. Set when duplicates.
     */
    @Test
    public void testSet2() {
    }

    /**
     * Unit test of the set() method. Set when empty.
     */
    @Test
    public void testSet3() {
    }

    /**
     * Unit test of the set() method. Set when full.
     */
    @Test
    public void testSet4() {
    }

    /**
     * Unit test of the set() method. Set invalid index.
     */
    @Test
    public void testSet5() {
    }

    /**
     * Sanity test of the toArray() method.
     */
    @Test
    public void testToArray1() {
        MyArrayList<String> ls = new MyArrayList<String>();
        String[] list = {"1", "2", "3"};

        ls.addAll(list);

        Object[] arr = ls.toArray();
        for (int i = 0; i < arr.length; i++) {
            assertEquals(list[i], arr[i]);
        }
    }

    /**
     * Unit test of the toArray() method. After add/insert.
     */
    @Test
    public void testToArray2() {
    }

    /**
     * Unit test of the toArray() method. Empty list.
     */
    @Test
    public void testToArray3() {
    }

    /**
     * Unit test of the toArray() method. Full list.
     */
    @Test
    public void testToArray4() {
    }

    /**
     * Sanity test of the trimToSize() method.
     */
    @Test
    public void testTrimToSize1() {
        MyArrayList<String> ls = new MyArrayList<String>(4);

        assertEquals(4, ls.getCapacity());

        ls.add("5");

        assertEquals(3, ls.getCapacity());

        ls.trimToSize();

        assertEquals(1, ls.getCapacity());
    }

    /**
     * Unit test of the trimToSize() method. Empty list.
     */
    @Test
    public void testTrimToSize2() {
    }

    /**
     * Unit test of the trimToSize() method. Full list.
     */
    @Test
    public void testTrimToSize3() {
    }

    // Integration Test
    /**
     * Integration test of all methods working together in a realistic 
     * scenario.
     */
    @Test
    public void groceryList() {
        MyArrayList<String> ls = new MyArrayList<String>(2);

        assertEquals(0, ls.size());
        assertEquals(2, ls.getCapacity());

        assertEquals(false, ls.insert("Vanilla Icecream",7));
        assertEquals(true, ls.insert("1x Mango",0));
        assertEquals(true, ls.insert("1x Bag of Flour",1));
        assertEquals(true, ls.insert("1x Gallon of Milk",2));
        assertEquals(true, ls.insert("5x Bananas",3));
        assertEquals(true, ls.insert("Dozen Organic Eggs",4));
        assertEquals(true, ls.insert("2lbs Chicken Thigh",5));

        assertEquals(6, ls.size());
        assertEquals(2, ls.getCapacity());

        assertEquals(null, ls.get(7));
        assertEquals("1x Mango", ls.get(0));
        assertEquals("1x Bag of Flour", ls.get(01));
        assertEquals("1x Gallon of Milk", ls.get(2));
        assertEquals("5x Bananas", ls.get(3));
        assertEquals("Dozen Organic Eggs", ls.get(4));
        assertEquals("2lbs Chicken Thigh", ls.get(5));

        assertEquals(6, ls.size());
        assertEquals(2, ls.getCapacity());

        assertEquals(false, ls.contains("Vanilla Icecream"));
        assertEquals(true, ls.contains("1x Mango"));
        assertEquals(true, ls.contains("1x Bag of Flour"));
        assertEquals(true, ls.contains("1x Gallon of Milk"));
        assertEquals(true, ls.contains("5x Bananas"));
        assertEquals(true, ls.contains("Dozen Organic Eggs"));
        assertEquals(true, ls.contains("2lbs Chicken Thigh"));

        assertEquals(6, ls.size());
        assertEquals(2, ls.getCapacity());

        assertEquals(null, ls.delete(7));
        assertEquals("1x Mango", ls.delete(0));
        assertEquals("1x Bag of Flour", ls.delete(0));
        assertEquals("1x Gallon of Milk", ls.delete(0));
        assertEquals("5x Bananas", ls.delete(0));
        assertEquals("Dozen Organic Eggs", ls.delete(0));
        assertEquals("2lbs Chicken Thigh", ls.delete(0));

        assertEquals(0, ls.size());
        assertEquals(8, ls.getCapacity());

        assertEquals(false, ls.contains("1x Mango"));
        assertEquals(false, ls.contains("1x Bag of Flour"));
        assertEquals(false, ls.contains("1x Gallon of Milk"));
        assertEquals(false, ls.contains("5x Bananas"));
        assertEquals(false, ls.contains("Dozen Organic Eggs"));
        assertEquals(false, ls.contains("2lbs Chicken Thigh"));
    }

    // Comparison Tests
    /**
     * Test that compares functionality of MyArrayList with java's ArrayList.
     */
    @Test
    public void comparison() {
        ArrayList<String> ls1 = new ArrayList<String>();
        MyArrayList<String> ls2 = new MyArrayList<String>();

        ls1.add(0, "Hi");
        ls2.insert("Hi", 0);

        assertEquals(ls1.contains("Hi"), ls2.contains("Hi"));

        assertEquals(ls1.get(0), ls2.get(0));

        ls1.add(1, "Bye");
        ls2.insert("Bye", 1);

        assertEquals(ls1.contains("Hi"), ls2.contains("Hi"));
        assertEquals(ls1.contains("Bye"), ls2.contains("Bye"));

        assertEquals(ls1.get(0), ls2.get(0));
        assertEquals(ls1.get(1), ls2.get(1));

        ls1.remove(0);
        ls2.delete(0);

        assertEquals(ls1.contains("Hi"), ls2.contains("Hi"));
        assertEquals(ls1.contains("Bye"), ls2.contains("Bye"));

        assertEquals(ls1.get(0), ls2.get(0));

        ls1.add(1, "Hi");
        ls2.insert("Hi", 1);

        assertEquals(ls1.contains("Hi"), ls2.contains("Hi"));
        assertEquals(ls1.contains("Bye"), ls2.contains("Bye"));

        assertEquals(ls1.get(0), ls2.get(0));
        assertEquals(ls1.get(1), ls2.get(1));
    }
}