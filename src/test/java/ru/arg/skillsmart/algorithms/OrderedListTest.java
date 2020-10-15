package ru.arg.skillsmart.algorithms;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class OrderedListTest extends TestCase {

    private OrderedList<Integer> ascOrderedListInt;
    private OrderedList<Integer> descOrderedListInt;
    private OrderedList<String> ascOrderedListStr;
    private OrderedList<String> descOrderedListStr;

    public void setUp() {
        ascOrderedListInt = new OrderedList<>(true);
        ascOrderedListInt.add(0);
        ascOrderedListInt.add(1);
        ascOrderedListInt.add(2);
        ascOrderedListInt.add(3);
        ascOrderedListInt.add(10);
        ascOrderedListInt.add(20);

        descOrderedListInt = new OrderedList<>(false);
        descOrderedListInt.add(20);
        descOrderedListInt.add(10);
        descOrderedListInt.add(3);
        descOrderedListInt.add(2);
        descOrderedListInt.add(1);
        descOrderedListInt.add(0);

        ascOrderedListStr = new OrderedList<>(true);
        ascOrderedListStr.add("a");
        ascOrderedListStr.add("b");
        ascOrderedListStr.add("c");
        ascOrderedListStr.add("d");
        ascOrderedListStr.add("x");
        ascOrderedListStr.add("z");

        descOrderedListStr = new OrderedList<>(false);
        descOrderedListStr.add("z");
        descOrderedListStr.add("x");
        descOrderedListStr.add("d");
        descOrderedListStr.add("c");
        descOrderedListStr.add("b");
        descOrderedListStr.add("a");
    }

    @Test
    public void testCompare() {
        setUp();
        assertEquals(0, ascOrderedListInt.compare(3, 3));
        assertEquals(-1, ascOrderedListInt.compare(1, 31));
        assertEquals(1, ascOrderedListInt.compare(31, 1));
        assertEquals(0, descOrderedListStr.compare("a", "a"));
        assertEquals(-1, descOrderedListStr.compare("a", "c"));
        assertEquals(1, descOrderedListStr.compare("c", "a"));
    }

    @Test
    public void testAdd() {
        ascOrderedListInt = new OrderedList<>(true);
        assertNull(ascOrderedListInt.head);
        assertNull(ascOrderedListInt.tail);
        assertEquals(0, ascOrderedListInt.size);
        ascOrderedListInt.add(0);
        assertEquals(null, ascOrderedListInt.head.prev);
        assertEquals(Integer.valueOf(0), ascOrderedListInt.head.value);
        assertEquals(null, ascOrderedListInt.head.next);
        assertEquals(null, ascOrderedListInt.tail.prev);
        assertEquals(Integer.valueOf(0), ascOrderedListInt.tail.value);
        assertEquals(null, ascOrderedListInt.tail.next);
        assertEquals(1, ascOrderedListInt.size);
        ascOrderedListInt.add(1);
        assertEquals(null, ascOrderedListInt.head.prev);
        assertEquals(Integer.valueOf(0), ascOrderedListInt.head.value);
        assertEquals(Integer.valueOf(1), ascOrderedListInt.head.next.value);
        assertEquals(Integer.valueOf(0), ascOrderedListInt.tail.prev.value);
        assertEquals(Integer.valueOf(1), ascOrderedListInt.tail.value);
        assertEquals(null, ascOrderedListInt.tail.next);
        assertEquals(2, ascOrderedListInt.size);
    }

    public void testFind() {
    }

    public void testDelete() {
    }

    public void testClear() {
    }

    public void testCount() {
    }
}