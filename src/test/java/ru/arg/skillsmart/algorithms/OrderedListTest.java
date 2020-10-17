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
        ascOrderedListStr.add("e");
        ascOrderedListStr.add("f");
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
    public void testAddAsc() {
        ascOrderedListInt = new OrderedList<>(true);
        assertNull(ascOrderedListInt.head);
        assertNull(ascOrderedListInt.tail);
        assertEquals(0, ascOrderedListInt.count());
        ascOrderedListInt.add(0);
        assertEquals(null, ascOrderedListInt.head.prev);
        assertEquals(Integer.valueOf(0), ascOrderedListInt.head.value);
        assertEquals(null, ascOrderedListInt.head.next);
        assertEquals(null, ascOrderedListInt.tail.prev);
        assertEquals(Integer.valueOf(0), ascOrderedListInt.tail.value);
        assertEquals(null, ascOrderedListInt.tail.next);
        assertEquals(1, ascOrderedListInt.count());
        ascOrderedListInt.add(1);
        assertEquals(null, ascOrderedListInt.head.prev);
        assertEquals(Integer.valueOf(0), ascOrderedListInt.head.value);
        assertEquals(Integer.valueOf(1), ascOrderedListInt.head.next.value);
        assertEquals(Integer.valueOf(0), ascOrderedListInt.tail.prev.value);
        assertEquals(Integer.valueOf(1), ascOrderedListInt.tail.value);
        assertEquals(null, ascOrderedListInt.tail.next);
        assertEquals(2, ascOrderedListInt.count());
        ascOrderedListInt.add(5);
        assertEquals(null, ascOrderedListInt.head.prev);
        assertEquals(Integer.valueOf(0), ascOrderedListInt.head.value);
        assertEquals(Integer.valueOf(1), ascOrderedListInt.head.next.value);
        assertEquals(Integer.valueOf(5), ascOrderedListInt.head.next.next.value);
        assertEquals(Integer.valueOf(1), ascOrderedListInt.tail.prev.value);
        assertEquals(Integer.valueOf(5), ascOrderedListInt.tail.value);
        assertEquals(null, ascOrderedListInt.tail.next);
        assertEquals(3, ascOrderedListInt.count());
        ascOrderedListInt.add(-1);
        assertEquals(null, ascOrderedListInt.head.prev);
        assertEquals(Integer.valueOf(-1), ascOrderedListInt.head.value);
        assertEquals(Integer.valueOf(0), ascOrderedListInt.head.next.value);
        assertEquals(Integer.valueOf(1), ascOrderedListInt.head.next.next.value);
        assertEquals(Integer.valueOf(1), ascOrderedListInt.tail.prev.value);
        assertEquals(Integer.valueOf(5), ascOrderedListInt.tail.value);
        assertEquals(null, ascOrderedListInt.tail.next);
        assertEquals(4, ascOrderedListInt.count());
        ascOrderedListInt.add(2);
        assertEquals(null, ascOrderedListInt.head.prev);
        assertEquals(Integer.valueOf(-1), ascOrderedListInt.head.value);
        assertEquals(Integer.valueOf(0), ascOrderedListInt.head.next.value);
        assertEquals(Integer.valueOf(1), ascOrderedListInt.head.next.next.value);
        assertEquals(Integer.valueOf(2), ascOrderedListInt.head.next.next.next.value);
        assertEquals(Integer.valueOf(2), ascOrderedListInt.tail.prev.value);
        assertEquals(Integer.valueOf(5), ascOrderedListInt.tail.value);
        assertEquals(null, ascOrderedListInt.tail.next);
        assertEquals(5, ascOrderedListInt.count());
    }

    @Test
    public void testStrAsc() {
        setUp();
        ascOrderedListStr.add(" c ");
        ascOrderedListStr.getAll().forEach(s -> System.out.println(s.value));
    }

    @Test
    public void testAddDesc() {
        descOrderedListInt = new OrderedList<>(false);
        assertNull(descOrderedListInt.head);
        assertNull(descOrderedListInt.tail);
        assertEquals(0, descOrderedListInt.count());
        descOrderedListInt.add(0);
        assertEquals(null, descOrderedListInt.head.prev);
        assertEquals(Integer.valueOf(0), descOrderedListInt.head.value);
        assertEquals(null, descOrderedListInt.head.next);
        assertEquals(null, descOrderedListInt.tail.prev);
        assertEquals(Integer.valueOf(0), descOrderedListInt.tail.value);
        assertEquals(null, descOrderedListInt.tail.next);
        assertEquals(1, descOrderedListInt.count());
        descOrderedListInt.add(1);
        assertEquals(null, descOrderedListInt.head.prev);
        assertEquals(Integer.valueOf(1), descOrderedListInt.head.value);
        assertEquals(Integer.valueOf(0), descOrderedListInt.head.next.value);
        assertEquals(Integer.valueOf(1), descOrderedListInt.tail.prev.value);
        assertEquals(Integer.valueOf(0), descOrderedListInt.tail.value);
        assertEquals(null, descOrderedListInt.tail.next);
        assertEquals(2, descOrderedListInt.count());
        descOrderedListInt.add(5);
        assertEquals(null, descOrderedListInt.head.prev);
        assertEquals(Integer.valueOf(5), descOrderedListInt.head.value);
        assertEquals(Integer.valueOf(1), descOrderedListInt.head.next.value);
        assertEquals(Integer.valueOf(0), descOrderedListInt.head.next.next.value);
        assertEquals(Integer.valueOf(1), descOrderedListInt.tail.prev.value);
        assertEquals(Integer.valueOf(0), descOrderedListInt.tail.value);
        assertEquals(null, descOrderedListInt.tail.next);
        assertEquals(3, descOrderedListInt.count());
        descOrderedListInt.add(-1);
        assertEquals(null, descOrderedListInt.head.prev);
        assertEquals(Integer.valueOf(5), descOrderedListInt.head.value);
        assertEquals(Integer.valueOf(1), descOrderedListInt.head.next.value);
        assertEquals(Integer.valueOf(0), descOrderedListInt.head.next.next.value);
        assertEquals(Integer.valueOf(0), descOrderedListInt.tail.prev.value);
        assertEquals(Integer.valueOf(-1), descOrderedListInt.tail.value);
        assertEquals(null, descOrderedListInt.tail.next);
        assertEquals(4, descOrderedListInt.count());
        descOrderedListInt.add(2);
        assertEquals(null, descOrderedListInt.head.prev);
        assertEquals(Integer.valueOf(5), descOrderedListInt.head.value);
        assertEquals(Integer.valueOf(2), descOrderedListInt.head.next.value);
        assertEquals(Integer.valueOf(1), descOrderedListInt.head.next.next.value);
        assertEquals(Integer.valueOf(0), descOrderedListInt.head.next.next.next.value);
        assertEquals(Integer.valueOf(0), descOrderedListInt.tail.prev.value);
        assertEquals(Integer.valueOf(-1), descOrderedListInt.tail.value);
        assertEquals(null, descOrderedListInt.tail.next);
        assertEquals(5, descOrderedListInt.count());
        descOrderedListInt.add(10);
        assertEquals(null, descOrderedListInt.head.prev);
        assertEquals(Integer.valueOf(10), descOrderedListInt.head.value);
        assertEquals(Integer.valueOf(5), descOrderedListInt.head.next.value);
        assertEquals(Integer.valueOf(2), descOrderedListInt.head.next.next.value);
        assertEquals(Integer.valueOf(1), descOrderedListInt.head.next.next.next.value);
        assertEquals(Integer.valueOf(0), descOrderedListInt.tail.prev.value);
        assertEquals(Integer.valueOf(-1), descOrderedListInt.tail.value);
        assertEquals(null, descOrderedListInt.tail.next);
        assertEquals(6, descOrderedListInt.count());
    }

    @Test
    public void testFind() {
        setUp();
        assertEquals(Integer.valueOf(0), ascOrderedListInt.find(0).value);
        assertEquals(Integer.valueOf(20), ascOrderedListInt.find(20).value);
        assertEquals(Integer.valueOf(3), ascOrderedListInt.find(3).value);
    }

    @Test
    public void testDelete() {
        setUp();
        ascOrderedListInt.delete(0);
        assertEquals(Integer.valueOf(1), ascOrderedListInt.head.value);
        assertEquals(5, ascOrderedListInt.count());
        ascOrderedListInt.delete(3);
        assertEquals(4, ascOrderedListInt.count());
        ascOrderedListInt.delete(20);
        assertEquals(3, ascOrderedListInt.count());
        assertEquals(Integer.valueOf(10), ascOrderedListInt.tail.value);
    }

    @Test
    public void testClear() {
        setUp();
        ascOrderedListInt.clear(true);
        assertNull(ascOrderedListInt.head);
        assertNull(ascOrderedListInt.tail);
        assertEquals(0, ascOrderedListInt.count());
    }

    @Test
    public void testCount() {
        setUp();
        assertEquals(6, ascOrderedListInt.count());
    }

    @Test
    public void testAscArray() {
        ascOrderedListInt = new OrderedList<>(true);
        ascOrderedListInt.add(0);
        ascOrderedListInt.add(2);
        ascOrderedListInt.add(1);
        ascOrderedListInt.add(1);
        ascOrderedListInt.add(2);
        ascOrderedListInt.add(1);
        ascOrderedListInt.add(0);
        ascOrderedListInt.getAll().forEach(s -> System.out.println(s.value));
    }

    @Test
    public void testDescArray() {
        ascOrderedListInt = new OrderedList<>(false);
        ascOrderedListInt.add(0);
        ascOrderedListInt.add(2);
        ascOrderedListInt.add(1);
        ascOrderedListInt.add(1);
        ascOrderedListInt.add(2);
        ascOrderedListInt.add(1);
        ascOrderedListInt.add(0);
        ascOrderedListInt.getAll().forEach(s -> System.out.println(s.value));
    }

}