package ru.arg.skillsmart.algorithms;

import java.util.Objects;

public class LinkedList2Node
{
    public int value;
    public LinkedList2Node next;
    public LinkedList2Node prev;

    public LinkedList2Node(int _value)
    {
        value = _value;
        next = null;
        prev = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedList2Node LinkedList2Node = (LinkedList2Node) o;
        return value == LinkedList2Node.value &&
                Objects.equals(next, LinkedList2Node.next) &&
                Objects.equals(prev, LinkedList2Node.prev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, next, prev);
    }
}
