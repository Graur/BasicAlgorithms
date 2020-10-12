package ru.arg.skillsmart.algorithms;
import java.util.*;

public class Deque<T>
{
    public Node<T> head;
    public Node<T> tail;
    private int size;

    public Deque()
    {
        head = null;
        tail = null;
        size = 0;
    }

    public void addFront(T item)
    {
        // добавление в голову
        Node<T> oldHead = this.head;
        Node<T> newHead = new Node<>(null, item,oldHead);
        this.head = newHead;
        if (oldHead == null) {
            this.tail = newHead;
        } else {
            oldHead.prev = newHead;
        }
        size++;
    }

    public void addTail(T item)
    {
        // добавление в хвост
        Node<T> oldTail = this.tail;
        Node<T> newTail = new Node<>(oldTail, item,null);
        this.tail = newTail;
        if (oldTail == null) {
            this.head = newTail;
        } else {
            oldTail.next = newTail;
        }
        size++;
    }

    public T removeFront()
    {
        // удаление из головы
        if (this.head == null) {
            return null;
        }
        Node<T> deletedEl = this.head;
        Node<T> newHead = this.head.next;
        this.head = newHead;
        if (newHead == null) {
            this.tail = null;
        } else {
            newHead.prev = null;
        }
        size--;
        return deletedEl.value;
    }

    public T removeTail()
    {
        // удаление из хвоста
        if (this.tail == null) {
            return null;
        }
        Node<T> deletedEl = this.tail;
        Node<T> newTail = this.tail.prev;
        this.tail = newTail;
        if (newTail == null) {
            this.head = null;
        } else {
            newTail.next = null;
        }
        size--;
        return deletedEl.value;
    }

    public int size()
    {
        return size;
    }
}

class Node<T>
{
    public T value;
    public Node<T> next;
    public Node<T> prev;

    public Node(T _value)
    {
        this.value = _value;
        this.next = null;
        this.prev = null;
    }

    public Node(Node<T> prev, T _value, Node<T> next)
    {
        this.value = _value;
        this.next = next;
        this.prev = prev;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(value, node.value) &&
                Objects.equals(next, node.next) &&
                Objects.equals(prev, node.prev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, next, prev);
    }
}
