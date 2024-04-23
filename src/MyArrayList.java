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

/*
 * MY basic ArrayList implementation in Java based on the pseudocode 
 * and method descriptions provided at: 
 * https://cogniterra.org/lesson/36902/step/1?unit=28666 & 
 * https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html.
 * Uses a zero-indexed array as the backend data structure. 
 * 
 * 1) Write sanity tests for basic methods.
 * 2) Implement insert(idx, elem), contains(elem), delete(idx), 
 * get(idx), size() & getCapacity(). 
 * 3) Write advanced tests w/ edge cases.
 * 4) Write sanity tests for advanced methods.
 * 5) Implement trimToSize(), toArray(), sort(), set(idx, elem), 
 * remove(elem), isEmpty(), indexOf(elem), ensureCapacity(sz), 
 * clear(), & add(elem). 
 * 6) Implement the constructor given an array.
 * 7) Write advanced tests w/ edge cases.
 */

 /**
 * (Write a succinct description of this class here. You should avoid
 * wordiness and redundancy.)
 *
 * Bugs: (a list of bugs and other problems)
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
     * 
     * @param (parameter name) (Describe the first parameter here)
     * @return (description of the return value)
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
     * @return (description of the return value)
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
     * @return (description of the return value)
     */
    public boolean insert(Object elem, int idx) {
        if (idx < 0 || idx > this.size) {
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
     * @param (parameter name) (Describe the first parameter here)
     * @return (description of the return value)
     */
    public int size() {
        return this.size;
    }

    /**
     * (Write a succinct description of this method here.)
     * 
     * @param (parameter name) (Describe the first parameter here)
     * @return (description of the return value)
     */
    public int getCapacity() {
        return this.capacity;
    }
}
