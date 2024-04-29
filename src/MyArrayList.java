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
 * method descriptions provided at the online sources above. Each instance can 
 * hold one type. Uses a zero-indexed array as the backend data structure. 
 * Has 3 private member variables: a backend array that holds the data, an int 
 * that holds the number of elements in the ArrayList, and an int that holds 
 * the number of free slots in the ArrayList.
 *
 * Bugs: N/A
 *
 * @author Michael Korelov
 * 
 * @param <T> The type of MyArrayList.
 */
public class MyArrayList<T> {
    private static int DEFAULT = 10;    // default capacity
    private static int DOUBLE = 2;      // doubles array size

    private int size;                   // number of elements
    private int capacity;               // open slots in backend array
    private T[] array;                  // backend array

    /**
     * Default constructor for MyArrayList. Initializes the member variables.
     */
    public MyArrayList() {
        this.array = (T[]) new Object[DEFAULT];
        this.capacity = DEFAULT;
        this.size = 0;
    }

    /**
     * Constructor for MyArrayList that specifies the initial capacity.
     * Initializes the member variables. Use non-negative cap.
     * 
     * @param int cap Specifies the initial capacity of MyArrayList.
     */
    public MyArrayList(int cap) {
        this.array = (T[]) new Object[cap];
        this.capacity = cap;
        this.size = 0;
    }

    /**
     * Constructor for MyArrayList that initializes based on an array.
     * 
     * @param T[] arr The array that is used to create MyArrayList.
     */
    public MyArrayList(T[] arr) {
        int len = arr.length;
        this.array = (T[]) new Object[len];
        for (int i = 0; i < len; i++) {
            this.array[i] = arr[i];
        }
        this.capacity = 0;
        this.size = len;
    }

    /**
     * Inserts the specified element at the specified index. Makes sure
     * that the index is valid. If MyArrayList is empty, can only insert 
     * at position 0. May require the creation of a new array twice the 
     * length if backend array is full. If initial capacity is 0, then 
     * create new array of length 1.
     * 
     * @param T elem Element that will be inserted.
     * @param int idx Position where element will be inserted.
     * @return Returns true if successful, false otherwise.
     */
    public boolean insert(T elem, int idx) {
        if (idx < 0 || idx > this.size) {
            return false;
        }

        if (this.capacity == 0 && this.size == 0) {
            T[] arr = (T[]) new Object[1];
            this.array = arr;
            this.array[idx] = elem;
            this.capacity += 1;
            this.size += 1;
            return true;
        }

        int len = this.array.length;
        if (this.size == len) {
            T[] arr = (T[]) new Object[len * DOUBLE];
            this.capacity += len;
            for (int i = 0; i < this.size; i++) {
                arr[i] = this.array[i];
            }
            this.array = arr;
        }

        if (idx == this.size) {
            this.array[idx] = elem;
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
     * @param T elem Element that is looked for.
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
     * @param int idx The position at which to delete an element.
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
     * @param int idx The postion from which to get the element.
     * @return Returns the element at the specified index.
     */
    public T get(int idx) {
        if (idx >= this.size && idx < array.length) {
            return null;
        }
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

    /**
     * Determines if two MyArrayList instances are equal. Used
     * to test clone() method.
     * 
     * @param MyArrayList<T> ls The instance being compared to.
     * @return Returns true if the instances are equivalent.
     */
    public boolean equals(MyArrayList<T> ls) {
        if (this.size() == ls.size() 
                && this.getCapacity() == ls.getCapacity()) {
                    for (int i = 0; i < this.size; i++) {
                        if (!this.get(i).equals(ls.get(i))) {
                            return false;
                        }
                    }
                    return true;
        }
        return false;
    }

    /**
     * Appends the specified element to the end.
     *
     * @param T elem Element to be appended.
     * @return Returns true is succesful and false otherwise.
     */
    public boolean add(T elem) {
        return insert(elem, this.size);
    }

    /**
     * Appends all of the elements in an array to the end of this list.
     *
     * @param T[] arr Contains the elements to be appended.
     * @return Returns true is succesfully adds all elements and false otherwise.
     */
    public boolean addAll(T[] arr) {
        int flag = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean success = add(arr[i]);
            if (success == false) {
                flag = 1;
            }
        }
        if (flag == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Removes all elements from the list.
     */
    public void clear() {
        for (int i = 0; i < this.size; i++) {
            this.array[i] = null;
        }
        this.size = 0;
        this.capacity = this.array.length;
    }

    /**
     * Creates a copy of this MyArrayList instance.
     *
     * @return Returns a shallow copy of this instance.
     */
    public MyArrayList<T> clone() {
        MyArrayList<T> dup = new MyArrayList<>(this.capacity + this.size);
        for (int i = 0; i < this.size; i++) {
            dup.add(this.array[i]);
        }
        return dup;
    }

    /**
     * Increases the capacity to ensure that MyArrayList can hold a
     * certain number of elements.
     *
     * @param int cap The minimum number of elements that MyArrayList
     * should hold.
     */
    public void ensureCapacity(int cap) {
        if (cap > this.capacity) {
            T[] arr = (T[]) new Object[cap + this.size];
            for (int i = 0; i < this.size; i++) {
                arr[i] = this.array[i];
            }
            this.capacity = cap;
            this.array = arr;
        }
    }

    /**
     * Finds first occurence of a specific element.
     *
     * @param T elem The element that is being searched for.
     * @return Returns index of first occurence of the element or -1
     * if the element is not found.
     */
    public int indexOf(T elem) {
        for (int i = 0; i < this.size; i++) {
            if (elem.equals(this.array[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Checks if list is empty.
     *
     * @return Returns true if empty and false otherwise.
     */
    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Finds the last occurence of a specific element.
     *
     * @param T elem The element that is being searched for.
     * @return Returns index of last occurence of the element or -1
     * if the element is not found.
     */
    public int lastIndexOf(T elem) {
        int idx = -1;
        for (int i = 0; i < this.size; i++) {
            if (elem.equals(this.array[i])) {
                idx = i;
            }
        }
        return idx;
    }

    /**
     * Removes the first occurence of a specific element.
     *
     * @param T elem The element that will be removed.
     * @return Returns true is succesful and false otherwise.
     */
    public boolean remove(T elem) {
        for (int i = 0; i < this.size; i++) {
            if (elem.equals(this.array[i])) {
                delete(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Updates the element stored at a certain position.
     *
     * @param int idx The position at which to update the element.
     * @param T elem The new element that will replace the original 
     * one.
     * @return Returns the previous element.
     */
    public T set(int idx, T elem) {
        T old = this.get(idx);
        if (old != null) {
            this.array[idx] = elem;
        }
        return old;
    }

    /**
     * Converts MyArrayList into an array.
     *
     * @return Returns an array containing all the elements
     * in MyArrayList.
     */
    public Object[] toArray() {
        Object[] arr = new Object[this.size];
        for (int i = 0; i < this.size; i++) {
            arr[i] = this.array[i];
        }
        return arr;
    }
    /**
     * Trims the capacity of this ArrayList to be the list's current 
     * size.
     */
    public void trimToSize() {
        if (this.size > 0 && this.capacity > this.size) {
            T[] arr = (T[]) new Object[this.size];
            for (int i = 0; i < this.size; i++) {
                arr[i] = this.array[i];
            }
            this.capacity = 0;
            this.array = arr;
        }
    }
}