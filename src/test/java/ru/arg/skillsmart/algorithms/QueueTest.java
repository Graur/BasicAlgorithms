package ru.arg.skillsmart.algorithms;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class QueueTest extends TestCase {

    private Queue<Integer> queue;

    public void setUp() {
        queue = new Queue<>();
    }

    @Test
    public void testEnqueue() {
        setUp();
        assertEquals(0, queue.size());
        queue.enqueue(1);
        assertEquals(1, queue.size());
        queue.enqueue(2);
        assertEquals(2, queue.size());
    }

    @Test
    public void testDequeue() {
        setUp();
        queue.enqueue(1);
        queue.enqueue(2);

        Integer dequeue = queue.dequeue();
        assertEquals(Integer.valueOf(1), dequeue);
        assertEquals(1, queue.size());
        Integer dequeue2 = queue.dequeue();
        assertEquals(Integer.valueOf(2), dequeue2);
        assertEquals(0, queue.size());
        Integer dequeue3 = queue.dequeue();
        assertNull(dequeue3);
    }

    @Test
    public void testSize() {
        setUp();
        assertEquals(0, queue.size());
        queue.enqueue(1);
        assertEquals(1, queue.size());
        queue.enqueue(2);
        assertEquals(2, queue.size());
    }
}