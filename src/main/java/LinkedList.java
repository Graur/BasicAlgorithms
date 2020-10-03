import java.util.*;

public class LinkedList
{
    public Node head;
    public Node tail;
    private int size;

    public LinkedList()
    {
        head = null;
        tail = null;
        size = 0;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
        size++;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
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
            Node prevNode = getPrevious(node);
            unlinkNode(prevNode, node);
            size--;
            return true;
        }
        return false;
    }

    private Node getPrevious(Node _node) {
        Node node = head;

        if (node == _node) {
            return null;
        }

        while (node != null) {
            if (node.next == _node) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    private void unlinkNode(Node _prevNode, Node _removableNode) {
        Node next = _removableNode.next;

        if (_prevNode == null) {
            head = next;
        } else {
            _prevNode.next = next;
        }

        if (next == null) {
            tail = _prevNode;
        }
    }

    public void removeAll(int _value)
    {
        Node node = this.head;
        Node prevNode = null;
        while (node != null) {
            if (node.value == _value) {
                unlinkNode(prevNode, node);
                size--;
            } else {
                prevNode = node;
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
            if (this.tail == null) {
                this.tail = this.head;
            }
            size++;
        } else {
            Node node = find(_nodeAfter.value);
            if (node != null) {
                if (node == tail) {
                    this.tail = _nodeToInsert;
                }
                _nodeToInsert.next = node.next;
                node.next = _nodeToInsert;
                size++;
            }
        }
    }

    public ListIteratorI listIterator() {
        return new ListIteratorI();
    }

    public class ListIteratorI implements Iterator<Integer> {
        private int nextIndex;
        private Node next;
        private Node returned;

        ListIteratorI() {
            returned = null;
            next = null;
            nextIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else if (returned == null) {
                returned = head;
                next = head.next;
                nextIndex++;
                return returned.value;
            }

            returned = next;
            next = next.next;
            nextIndex++;

            return returned.value;
        }
    }
}

class Node
{
    public int value;
    public Node next;
    public Node(int _value)
    {
        value = _value;
        next = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return value == node.value &&
                Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, next);
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
