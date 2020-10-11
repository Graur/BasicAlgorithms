package ru.arg.skillsmart.algorithms;

import java.util.*;

public class LinkedList2
{
    public LinkedList2Node head;
    public LinkedList2Node tail;
    private int size;

    public LinkedList2()
    {
        head = null;
        tail = null;
    }

    public void addInTail(LinkedList2Node _item)
    {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
        size++;
    }

    public LinkedList2Node find(int _value)
    {
        LinkedList2Node LinkedList2Node = this.head;
        while (LinkedList2Node != null) {
            if (LinkedList2Node.value == _value)
                return LinkedList2Node;
            LinkedList2Node = LinkedList2Node.next;
        }
        return null;
    }

    public ArrayList<LinkedList2Node> findAll(int _value)
    {
        ArrayList<LinkedList2Node> LinkedList2Nodes = new ArrayList<LinkedList2Node>();
        LinkedList2Node LinkedList2Node = this.head;
        while (LinkedList2Node != null) {
            if (LinkedList2Node.value == _value)
                LinkedList2Nodes.add(LinkedList2Node);
            LinkedList2Node = LinkedList2Node.next;
        }

        return LinkedList2Nodes;
    }

    public boolean remove(int _value)
    {
        LinkedList2Node LinkedList2Node = find(_value);
        if (LinkedList2Node != null) {
            unlinkLinkedList2Node(LinkedList2Node.prev, LinkedList2Node);
            size--;
            return true;
        }
        return false;
    }

    private void unlinkLinkedList2Node(LinkedList2Node _prevLinkedList2Node, LinkedList2Node _removableLinkedList2Node) {
        LinkedList2Node next = _removableLinkedList2Node.next;

        if (_prevLinkedList2Node == null) {
            this.head = next;
            if (this.head != null) {
                this.head.prev = null;
            } else {
                this.tail = this.head;
            }
        } else {
            _prevLinkedList2Node.next = next;
            if (next == null) {
                this.tail = _prevLinkedList2Node;
            } else {
                _prevLinkedList2Node.next.prev = _prevLinkedList2Node;
            }
        }
        _removableLinkedList2Node = null;
    }

    public void removeAll(int _value)
    {
        LinkedList2Node LinkedList2Node = this.head;
        while (LinkedList2Node != null) {
            if (LinkedList2Node.value == _value) {
                unlinkLinkedList2Node(LinkedList2Node.prev, LinkedList2Node);
                size--;
            }
            LinkedList2Node = LinkedList2Node.next;
        }
    }

    public void clear()
    {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int count()
    {
        return size;
    }

    public void insertAfter(LinkedList2Node _LinkedList2NodeAfter, LinkedList2Node _LinkedList2NodeToInsert)
    {
        if (_LinkedList2NodeAfter == null) {
            _LinkedList2NodeToInsert.next = this.head;
            this.head = _LinkedList2NodeToInsert;
            if (this.head.next != null) {
                this.head.next.prev = _LinkedList2NodeToInsert;
            }
            if (this.tail == null) {
                this.tail = this.head;
            }
            size++;
        } else {
            LinkedList2Node LinkedList2Node = find(_LinkedList2NodeAfter.value);
            if (LinkedList2Node != null) {
                _LinkedList2NodeToInsert.next = LinkedList2Node.next;
                LinkedList2Node.next = _LinkedList2NodeToInsert;
                if (LinkedList2Node == tail) {
                    this.tail = _LinkedList2NodeToInsert;
                    this.tail.prev = LinkedList2Node;
                } else {
                    LinkedList2Node.next.next.prev = _LinkedList2NodeToInsert;
                    _LinkedList2NodeToInsert.prev = LinkedList2Node;
                }
                size++;
            }
        }
    }
}