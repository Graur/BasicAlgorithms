package ru.arg.skillsmart.algorithms;

import java.util.*;

public class Queue<T>
{

    private LinkedList<T> array;

    public Queue()
    {
        // инициализация внутреннего хранилища очереди
        array = new LinkedList<>();
    }

    public void enqueue(T item)
    {
        // вставка в хвост
        array.add(item);
    }

    public T dequeue()
    {
        // выдача из головы
        if (array.size() == 0) {
            return null; // null если очередь пустая
        } else {
            return array.poll();
        }
    }

    public int size()
    {
        return array.size();
    }

}