package ru.arg.skillsmart.algorithms;

public class Queue<T>
{

    private Stack<T> stack;
    private Stack<T> buffer;
    private int size;

    public Queue()
    {
        // инициализация внутреннего хранилища очереди
        stack = new Stack<>();
        buffer = new Stack<>();
    }

    public void enqueue(T item)
    {
        // вставка в хвост
        stack.push(item);
        size++;
    }

    public T dequeue()
    {
        // выдача из головы
        if (size == 0) {
            return null; // null если очередь пустая
        } else {
            if (buffer.size() == 0) {
                while (stack.size() != 0) {
                    buffer.push(stack.pop());
                }
            }
            size--;
            return buffer.pop();
        }
    }

    public int size()
    {
        return size;
    }

}