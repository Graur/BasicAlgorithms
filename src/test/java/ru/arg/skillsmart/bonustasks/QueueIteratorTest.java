package ru.arg.skillsmart.bonustasks;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.arg.skillsmart.algorithms.Queue;

@RunWith(JUnit4.class)
public class QueueIteratorTest extends TestCase {

    private Queue<Integer> queue;

    public void setUp() {
        queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
    }

    @Test
    public void testIterate1() {
        setUp();
        QueueIterator<Integer> iterator = new QueueIterator<>();
        Integer actualResult = iterator.iterate(queue, 7);
        assertEquals(Integer.valueOf(2), actualResult);
    }

    @Test
    public void testIterate2() {
        setUp();
        QueueIterator<Integer> iterator = new QueueIterator<>();
        Integer actualResult = iterator.iterate(queue, 10);
        assertEquals(Integer.valueOf(5), actualResult);
    }

    @Test
    public void testIterate3() {
        setUp();
        QueueIterator<Integer> iterator = new QueueIterator<>();
        Integer actualResult = iterator.iterate(queue, 23);
        assertEquals(Integer.valueOf(3), actualResult);
    }
}