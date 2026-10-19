/* Description: Array-based bounded stack (LIFO) with a maximum capacity of 10.
   Programmed by: Group 8
   Last Modified: October 19, 2026
   Version: 1.0
   Acknowledgements: <list sites / generative AI used and the prompt>
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
