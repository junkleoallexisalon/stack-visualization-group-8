
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
    
    public void push(int value) {
    if (isFull()) {
        throw new IllegalStateException("STACK OVERFLOW: Cannot push, stack is full");
    }
    top++;
    data[top] = value;
}

public int pop() {
    if (isEmpty()) {
        throw new IllegalStateException("STACK UNDERFLOW: Cannot pop, stack is empty");
    }
    int value = data[top];
    top--;
    return value;
}


    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException(
                "STACK EMPTY: Nothing to peek, stack is empty"
            );
        }
        return data[top];
    }

    public void clear() {
        top = -1;
    }

    public int[] toArray() {
        int[] copy = new int[size()];

        for (int i = 0; i < copy.length; i++) {
            copy[i] = data[i];
        }

        return copy;
    }
}
