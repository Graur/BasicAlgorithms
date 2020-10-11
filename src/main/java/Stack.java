import java.util.*;

public class Stack<T>
{
    private LinkedList<Object> data;

    private int size;

    public Stack()
    {
        data = new LinkedList<>();
        size = 0;
    }

    public int size()
    {
        return size;
    }

    public T pop()
    {
        if (size == 0) {
            return null;  // если стек пустой
        } else {
            size--;
            return (T) data.pollFirst();
        }
    }

    public void push(T val)
    {
        data.addFirst(val);
        size++;
    }

    public T peek()
    {
        if (size == 0) {
            return null; // если стек пустой
        } else {
            return (T) data.peekFirst();
        }
    }
}