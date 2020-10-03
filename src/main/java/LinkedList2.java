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
    }

    public void removeAll(int _value)
    {
        // здесь будет ваш код удаления всех узлов по заданному значению
    }

    public void clear()
    {
        // здесь будет ваш код очистки всего списка
    }

    public int count()
    {
        return size;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        // здесь будет ваш код вставки узла после заданного узла

        // если _nodeAfter = null
        // добавьте новый элемент первым в списке
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