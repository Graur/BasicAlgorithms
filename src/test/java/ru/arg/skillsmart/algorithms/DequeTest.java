package ru.arg.skillsmart.algorithms;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DequeTest extends TestCase {

    private Deque<Integer> deque;

    public void setUp() {
        deque = new Deque<>();
        deque.addTail(1);
        deque.addTail(2);
        deque.addTail(3);
        deque.addTail(4);
        deque.addTail(5);
    }

    @Test
    public void testAddFront() {
        setUp();
        assertEquals(5, deque.size());
        deque.addFront(-1);
        assertNull(deque.head.prev);
        assertEquals(Integer.valueOf(5), deque.tail.value);
        assertEquals(Integer.valueOf(-1), deque.head.value);
        assertEquals(Integer.valueOf(1), deque.head.next.value);
        assertEquals(Integer.valueOf(2), deque.head.next.next.value);
        assertEquals(6, deque.size());
    }

    @Test
    public void testAddTail() {
        setUp();
        assertEquals(5, deque.size());
        deque.addTail(6);
        assertNull(deque.tail.next);
        assertEquals(Integer.valueOf(1), deque.head.value);
        assertEquals(Integer.valueOf(6), deque.tail.value);
        assertEquals(Integer.valueOf(5), deque.tail.prev.value);
        assertEquals(Integer.valueOf(4), deque.tail.prev.prev.value);
        assertEquals(6, deque.size());
    }

    @Test
    public void testRemoveFront() {
        setUp();
        assertEquals(5, deque.size());
        Integer integer = deque.removeFront();
        assertEquals(4, deque.size());
        assertNull(deque.tail.next);
        assertNull(deque.head.prev);
        assertEquals(Integer.valueOf(1), integer);
        assertEquals(Integer.valueOf(2), deque.head.value);
        assertEquals(Integer.valueOf(3), deque.head.next.value);
        deque.removeFront();
        deque.removeFront();
        deque.removeFront();
        deque.removeFront();
        assertNull(deque.head);
        assertNull(deque.tail);
        Integer integer1 = deque.removeFront();
        assertNull(integer1);
    }

    @Test
    public void testRemoveTail() {
        setUp();
        assertEquals(5, deque.size());
        Integer integer = deque.removeTail();
        assertEquals(4, deque.size());
        assertNull(deque.tail.next);
        assertNull(deque.head.prev);
        assertEquals(Integer.valueOf(5), integer);
        assertEquals(Integer.valueOf(4), deque.tail.value);
        assertEquals(Integer.valueOf(3), deque.tail.prev.value);
        deque.removeTail();
        deque.removeTail();
        deque.removeTail();
        deque.removeTail();
        assertNull(deque.head);
        assertNull(deque.tail);
        Integer integer1 = deque.removeTail();
        assertNull(integer1);
    }

    @Test
    public void testSize() {
        setUp();
        assertEquals(5, deque.size());
    }
}