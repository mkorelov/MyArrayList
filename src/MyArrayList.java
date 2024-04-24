///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:    Main.java
// File:               MyArrayList.java
//
// Author:             Michael Korelov | korelovmichael@gmail.com
//
///////////////////////////////////////////////////////////////////////////////
//
// Online sources:   https://cogniterra.org/lesson/36902/step/1?unit=28666 &
// https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
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
 * 1) Write sanity tests for basic methods.
 * 2) Implement insert(idx, elem), contains(elem), delete(idx), add(elem), 
 * get(idx), size() & getCapacity(). 
 * 3) Write advanced tests w/ edge cases.
 * 4) Write sanity tests for advanced methods.
 * 5) Implement trimToSize(), toArray(), sort(), set(idx, elem), remove(elem), 
 * isEmpty(), indexOf(elem), ensureCapacity(sz), & clear(). 
 * 6) Implement the constructor given an array.
 * 7) Write advanced tests w/ edge cases.
 *
 * Bugs: N/A
 *
 * @author Michael Korelov
 */
public class MyArrayList {
    private static int DEFAULT = 10;                // default capacity of MyArrayList
    private int size;                               // number of elements in MyArrayList
    private int capacity;                           // open slots in backend array in MyArrayList
    private Object[] array;                         // backend array in MyArrayList

    /**
     * (Write a succinct description of this method here.)
     */
    public MyArrayList() {
        this.array = new Object[DEFAULT];
        this.capacity = DEFAULT;
        this.size = 0;
    }

    /**
     * (Write a succinct description of this method here.)
     * 
     * @param (parameter name) (Describe the first parameter here)
     */
    public MyArrayList(int cap) {
        this.array = new Object[cap];
        this.capacity = cap;
        this.size = 0;
    }

    /**
     * (Write a succinct description of this method here.)
     * 
     * @param (parameter name) (Describe the first parameter here)
     * @param (parameter name) (Describe the second parameter here)
     * @return (description of the return value)
     */
    public boolean add(Object elem) {
        return true;
    }

    /**
     * (Write a succinct description of this method here.)
     * 
     * @param (parameter name) (Describe the first parameter here)
     * @param (parameter name) (Describe the second parameter here)
     * @return (description of the return value)
     */
    public boolean insert(Object elem, int idx) {
        if (idx < 0 || idx >= this.size) {
            return false;
        }

        if (this.size == this.capacity) {
            Object[] arr = new Object[this.capacity * 2];
            for (int i = 0; i < this.size; i++) {
                arr[i] = this.array[i];
            }
            this.array = arr;
        }

        if (idx == this.size) {
            array[idx] = elem;
        } else {
            for (int i = this.size - 1; i < idx + 1; i++) {
                this.array[i + 1] = this.array[i];
            }
            this.array[idx] = elem;
        }
        this.size += 1;
        this.capacity -= 1;
        return true;
    }

    /**
     * (Write a succinct description of this method here.)
     * 
     * @param (parameter name) (Describe the first parameter here)
     * @return (description of the return value)
     */
    public boolean contains(Object elem) {
        for (int i = 0; i < this.size; i++) {
            if (this.array[i] == elem) {
                return true;
            }
        }
        return false;
    }

    /**
     * (Write a succinct description of this method here.)
     * 
     * @param (parameter name) (Describe the first parameter here)
     * @return (description of the return value)
     */
    public Object delete(int idx) {
        if (idx < 0 || idx >= this.size) {
            return null;
        }
        Object val = this.array[idx];
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
     * (Write a succinct description of this method here.)
     * 
     * @param (parameter name) (Describe the first parameter here)
     * @return (description of the return value)
     */
    public Object get(int idx) {
        return this.array[idx];
    }

    /**
     * (Write a succinct description of this method here.)
     * 
     * @return (description of the return value)
     */
    public int size() {
        return this.size;
    }

    /**
     * Getter method that accesses private member vairable to verify
     * constructor in testing file.
     * 
     * @return (description of the return value)
     */
    public int getCapacity() {
        return this.capacity;
    }
}