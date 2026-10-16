
/*
 * Description: Array-based bounded stack (LIFO) with a maximum capacity of 10.
 * Programmed by: Group 8
 * Course: BSIT 2nd Year
 * CN: 48083
 * Subject: Data Structures and Algorithms
 * Last Modified: October 12, 2026
 * Version: 1.0
 */

public class ArrayStack {

    public static final int MAX_CAPACITY = 10;

    private final int[] data;
    private int top;

    public ArrayStack() {
        data = new int[MAX_CAPACITY];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == data.length - 1;
    }

    public int size() {
        return top + 1;
    }

    public int capacity() {
        return data.length;
    }
}
