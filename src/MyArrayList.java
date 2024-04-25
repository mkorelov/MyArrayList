///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:    Main.java
// File:               MyArrayList.java
// Author:             Michael Korelov | korelovmichael@gmail.com
//
///////////////////////////////////////////////////////////////////////////////
//
// Online sources:   https://cogniterra.org/lesson/36902/step/1?unit=28666, 
// https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html, &
// https://docs.oracle.com/javase/tutorial/java/generics/types.html.
//
///////////////////////////////////////////////////////////////////////////////

/**
 * My basic ArrayList implementation in Java based on the pseudocode and 
 * method descriptions provided at the online sources above. Works with any 
 * subtype of Object. Uses a zero-indexed array as the backend data structure. 
 * Has 3 private member variables: a backend array that holds the data, an int 
 * that holds the number of elements in the ArrayList, and an int that holds 
 * the number of free slots in the ArrayList.
 * 
 * @param <T> The type of MyArrayList.
 * 
 * 1) Write sanity tests for basic methods. (Done)
 * 2) Implement insert(idx, elem), contains(elem), delete(idx), get(idx), 
 * size() & getCapacity(). (Done)
 * 3) Write advanced tests w/ edge cases.
 * 4) Write sanity tests for advanced methods.
 * 5) Implement trimToSize(), toArray(), sort(), set(idx, elem), remove(elem), 
 * isEmpty(), indexOf(elem), ensureCapacity(sz), clear(), & add(elem).
 * 6) Implement the constructor given an array.
 * 7) Write advanced tests w/ edge cases.
 *
 * Bugs: N/A
 *
 * @author Michael Korelov
 */
public class MyArrayList<T> {
    private static int DEFAULT = 10;    // default capacity
    private static int DOUBLE = 2;      // doubles array size

    private int size;                   // number of elements
    private int capacity;               // open slots in backend array
    private T[] array;                  // backend array

    /**
     * Default constructor for MyArrayList. Initializes the member variables.
     * Use valid type.
     * 
     * @param (String type) Specifies datatype of MyArrayList.
     */
    public MyArrayList() {
        this.array = (T[]) new Object[DEFAULT];
        this.capacity = DEFAULT;
        this.size = 0;
    }

    /**
     * Constructor for MyArrayList that specifies the initial capacity.
     * Initializes the member variables. Use non-negative cap and valid 
     * type.
     * 
     * @param (String type) Specifies datatype of MyArrayList.
     * @param (int cap) Specifies the initial capacity of MyArrayList.
     */
    public MyArrayList(int cap) {
        this.array = (T[]) new Object[cap];
        this.capacity = cap;
        this.size = 0;
    }

    /**
     * Inserts the specified element at the specified index. Makes sure
     * that the index is valid. If MyArrayList is empty, can only insert 
     * at position 0. May require the creation of a new array twice the 
     * size if backend array is full.
     * 
     * @param (T elem) Element that will be inserted.
     * @param (int idx) Position where element will be inserted.
     * @return Returns true if successful, false otherwise.
     */
    public boolean insert(T elem, int idx) {
        if (idx < 0 || idx > this.size) {
            return false;
        }

        int len = this.array.length;
        if (this.size == len) {
            T[] arr = (T[]) new Object[len * DOUBLE];
            for (int i = 0; i < this.size; i++) {
                arr[i] = this.array[i];
            }
            this.array = arr;
        }

        if (idx == this.size) {
            array[idx] = elem;
        } else {
            for (int i = this.size - 1; i >= idx; i--) {
                this.array[i + 1] = this.array[i];
            }
            this.array[idx] = elem;
        }
        this.size += 1;
        this.capacity -= 1;
        return true;
    }

    /**
     * Checks if MyArrayList contains a specific element. First
     * verifies type matches the type of MyArrayList.
     * 
     * @param (T elem) Element that is looked for.
     * @return Returns true if element exists, false otherwise.
     */
    public boolean contains(T elem) {
        for (int i = 0; i < this.size; i++) {
            if (this.array[i].equals(elem)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Removes the element at the specified index. Checks if 
     * index is valid first and shifts remaining elements over
     * if not removed from the end.
     * 
     * @param (int idx) The position at which to delete an element.
     * @return Returns the element that is deleted.
     */
    public T delete(int idx) {
        if (idx < 0 || idx >= this.size) {
            return null;
        }
        T val = this.array[idx];
        this.array[idx] = null;

        if (idx < this.size - 1) {
            for (int i = idx; i < this.size - 1; i++) {
                this.array[i] = this.array[i + 1];
            }
            this.array[this.size - 1] = null;
        }
        this.size -= 1;
        this.capacity += 1;
        return val;
    }

    /**
     * Gets the element at a specified index in MyArrayList.
     * 
     * @param (int idx) The postion from which to get the element.
     * @return Returns the element at the specified index.
     */
    public T get(int idx) {
        return this.array[idx];
    }

    /**
     * Getter method that accesses private member vairable.
     * 
     * @return Returns the number of elements in MyArrayList.
     */
    public int size() {
        return this.size;
    }

    /**
     * Getter method that accesses private member vairable to
     * check the constructor works in the testing file.
     * 
     * @return Returns the number of empty slots in MyArrayList.
     */
    public int getCapacity() {
        return this.capacity;
    }
}