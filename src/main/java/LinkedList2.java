import java.util.*;

public class LinkedList2
{
    public Node head;
    public Node tail;
    private int size;

    public LinkedList2()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item)
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

    public Node find(int _value)
    {
        Node node = this.head;
        while (node != null) {
            if (node.value == _value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value)
    {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;
        while (node != null) {
            if (node.value == _value)
                nodes.add(node);
            node = node.next;
        }

        return nodes;
    }

    public boolean remove(int _value)
    {
        Node node = find(_value);
        if (node != null) {
            unlinkNode(node.prev, node);
            size--;
            return true;
        }
        return false;
    }

    private void unlinkNode(Node _prevNode, Node _removableNode) {
        Node next = _removableNode.next;

        if (_prevNode == null) {
            this.head = next;
            if (this.head != null) {
                this.head.prev = null;
            } else {
                this.tail = this.head;
            }
        } else {
            _prevNode.next = next;
            if (next == null) {
                this.tail = _prevNode;
            } else {
                _prevNode.next.prev = _prevNode;
            }
        }
        _removableNode = null;
    }

    public void removeAll(int _value)
    {
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                unlinkNode(node.prev, node);
                size--;
            }
            node = node.next;
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

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        if (_nodeAfter == null) {
            _nodeToInsert.next = this.head;
            this.head = _nodeToInsert;
            if (this.head.next != null) {
                this.head.next.prev = _nodeToInsert;
            }
            if (this.tail == null) {
                this.tail = this.head;
            }
            size++;
        } else {
            Node node = find(_nodeAfter.value);
            if (node != null) {
                _nodeToInsert.next = node.next;
                node.next = _nodeToInsert;
                if (node == tail) {
                    this.tail = _nodeToInsert;
                    this.tail.prev = node;
                } else {
                    node.next.next.prev = _nodeToInsert;
                    _nodeToInsert.prev = node;
                }
                size++;
            }
        }
    }
}

class Node
{
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}