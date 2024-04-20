/*
 * Basic ArrayList implementation in Java based on the pseudocode and 
 * method descriptions provided at: 
 * https://cogniterra.org/lesson/36902/step/1?unit=28666 & 
 * https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html.
 * Uses array as the backend data structure. 
 * 
 * 1) Write sanity tests for basic methods.
 * 2) Implement add(idx, elem), contains(elem), remove(idx), & 
 * getCapacity(). 
 * 3) Write advanced tests w/ edge cases.
 * 4) Write sanity tests for advanced methods.
 * 5) Implement trimToSize(), toArray(), sort(), size(), set(idx, elem), 
 * remove(elem), isEmpty(), indexOf(elem), get(idx), ensureCapacity(sz), 
 * clear(), & add(elem). 
 * 6) Implement the constructor given an array, implement getCapacity(),
 * and update the access modifiers of member variable to private.
 * 7) Write advanced tests w/ edge cases.
 */
public class MyArrayList {
    private static int DEFAULT = 10;                // default capacity of MyArrayList
    public int size;                               // number of elements in MyArrayList
    public int capacity;                           // size of backend array in MyArrayList
    public Object[] array;                         // backend array in MyArrayList

    /*
     * TODO
     */
    public MyArrayList() {
        this.array = new Object[DEFAULT];
        this.capacity = DEFAULT;
        this.size = 0;
    }

    /*
     * TODO
     */
    public MyArrayList(int cap) {
        this.array = new Object[cap];
        this.capacity = cap;
        this.size = 0;
    }

    /*
     * TODO
     */
    public boolean add(Object elem, int idx) {
        return true;
    }

    /*
     * TODO
     */
    public boolean contains(Object elem) {
        return true;
    }

    /*
     * TODO
     */
    public Object remove(int idx) {
        return "";
    }
}
