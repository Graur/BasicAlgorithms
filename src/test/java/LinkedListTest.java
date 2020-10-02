import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Random;

@RunWith(JUnit4.class)
public class LinkedListTest extends TestCase {

    private static final int TEST_ITERATE_NUMBER = 10000;

    private LinkedList largeList;

    private LinkedList startElemTestInMultiplyList;

    private LinkedList startSeveralElemsTestInMultiplyList;

    private LinkedList middleElemTestInMultiplyList;

    private LinkedList middleSeveralElemsTestInMultiplyList;

    private LinkedList tailElemTestInMultiplyList;

    private LinkedList tailSeveralElemsTestInMultiplyList;

    private LinkedList oneElemListWithTestValue;

    private LinkedList oneElemListWithoutTestValue;

    private LinkedList emptyList;

    private int testedValue = 99999;

    private Node testedNode = new Node(testedValue);

    private LinkedList expectedList;

    @Before
    public void setUpLists() {
        largeList = new LinkedList();

        for (int i = 0; i < TEST_ITERATE_NUMBER; i++) {
            largeList.addInTail(new Node(new Random().nextInt()));
        }

        startElemTestInMultiplyList = new LinkedList();
        startElemTestInMultiplyList.addInTail(new Node(99999));
        startElemTestInMultiplyList.addInTail(new Node(2));
        startElemTestInMultiplyList.addInTail(new Node(3));
        startElemTestInMultiplyList.addInTail(new Node(4));

        startSeveralElemsTestInMultiplyList = new LinkedList();
        startSeveralElemsTestInMultiplyList.addInTail(new Node(99999));
        startSeveralElemsTestInMultiplyList.addInTail(new Node(99999));
        startSeveralElemsTestInMultiplyList.addInTail(new Node(3));
        startSeveralElemsTestInMultiplyList.addInTail(new Node(4));

        middleElemTestInMultiplyList = new LinkedList();
        middleElemTestInMultiplyList.addInTail(new Node(1));
        middleElemTestInMultiplyList.addInTail(new Node(99999));
        middleElemTestInMultiplyList.addInTail(new Node(3));
        middleElemTestInMultiplyList.addInTail(new Node(4));

        middleSeveralElemsTestInMultiplyList = new LinkedList();
        middleSeveralElemsTestInMultiplyList.addInTail(new Node(1));
        middleSeveralElemsTestInMultiplyList.addInTail(new Node(99999));
        middleSeveralElemsTestInMultiplyList.addInTail(new Node(99999));
        middleSeveralElemsTestInMultiplyList.addInTail(new Node(4));

        tailElemTestInMultiplyList = new LinkedList();
        tailElemTestInMultiplyList.addInTail(new Node(1));
        tailElemTestInMultiplyList.addInTail(new Node(2));
        tailElemTestInMultiplyList.addInTail(new Node(3));
        tailElemTestInMultiplyList.addInTail(new Node(99999));

        tailSeveralElemsTestInMultiplyList = new LinkedList();
        tailSeveralElemsTestInMultiplyList.addInTail(new Node(1));
        tailSeveralElemsTestInMultiplyList.addInTail(new Node(2));
        tailSeveralElemsTestInMultiplyList.addInTail(new Node(99999));
        tailSeveralElemsTestInMultiplyList.addInTail(new Node(99999));

        oneElemListWithTestValue = new LinkedList();
        oneElemListWithTestValue.addInTail(new Node(99999));

        oneElemListWithoutTestValue = new LinkedList();
        oneElemListWithoutTestValue.addInTail(new Node(1));

        emptyList = new LinkedList();

        expectedList = new LinkedList();
        expectedList.addInTail(new Node(1));
        expectedList.addInTail(new Node(2));
        expectedList.addInTail(new Node(3));
        expectedList.addInTail(new Node(4));
    }

    /**
     remove
     */
    @Test
    public void testRemoveFromStart() {
        setUpLists();

        emptyList.remove(testedValue);
        assertNull("Empty list with elem. Remove from start: head", emptyList.head);
        assertNull("Empty list with elem. Remove from start: tail", emptyList.tail);
        assertEquals("Empty list with elem. Remove from start: count", 0, emptyList.count());

        oneElemListWithTestValue.remove(testedValue);
        assertNull("Single list with elem. Remove from start: head", oneElemListWithTestValue.head);
        assertNull("Single list with elem. Remove from start: tail", oneElemListWithTestValue.tail);
        assertEquals("Single list with elem. Remove from start: count", 0, oneElemListWithTestValue.count());

        oneElemListWithoutTestValue.remove(testedValue);
        assertEquals("Single list with elem. Remove from start: head", 1, oneElemListWithoutTestValue.head.value);
        assertEquals("Single list with elem. Remove from start: tail", 1, oneElemListWithoutTestValue.tail.value);
        assertEquals("Single list with elem. Remove from start: count", 1, oneElemListWithoutTestValue.count());

        startElemTestInMultiplyList.remove(testedValue);
        assertEquals("Multiply list with single elem. Remove from start: head", 2, startElemTestInMultiplyList.head.value);
        assertEquals("Multiply list with single elem. Remove from start: tail", 4, startElemTestInMultiplyList.tail.value);
        assertEquals("Multiply list with single elem. Remove from start: count", 3, startElemTestInMultiplyList.count());

        startSeveralElemsTestInMultiplyList.remove(testedValue);
        assertEquals("Multiply list with several elem. Remove from start: head", 99999, startSeveralElemsTestInMultiplyList.head.value);
        assertEquals("Multiply list with several elem. Remove from start: tail", 4, startSeveralElemsTestInMultiplyList.tail.value);
        assertEquals("Multiply list with several elem. Remove from start: count", 3, startSeveralElemsTestInMultiplyList.count());
    }

    @Test
    public void testRemoveFromTail() {
        setUpLists();

        emptyList.remove(testedValue);
        assertNull("Empty list with elem. Remove from tail: head", emptyList.head);
        assertNull("Empty list with elem. Remove from tail: tail", emptyList.tail);
        assertEquals("Empty list with elem. Remove from tail: count", 0, emptyList.count());

        oneElemListWithTestValue.remove(testedValue);
        assertNull("Single list with elem. Remove from tail: head", oneElemListWithTestValue.head);
        assertNull("Single list with elem. Remove from tail: tail", oneElemListWithTestValue.tail);
        assertEquals("Single list with elem. Remove from tail: count", 0, oneElemListWithTestValue.count());

        oneElemListWithoutTestValue.remove(testedValue);
        assertEquals("Single list with elem. Remove from tail: head", 1, oneElemListWithoutTestValue.head.value);
        assertEquals("Single list with elem. Remove from tail: tail", 1, oneElemListWithoutTestValue.tail.value);
        assertEquals("Single list with elem. Remove from tail: count", 1, oneElemListWithoutTestValue.count());

        tailElemTestInMultiplyList.remove(testedValue);
        assertEquals("Multiply list with single elem. Remove from tail: head", 1, tailElemTestInMultiplyList.head.value);
        assertEquals("Multiply list with single elem. Remove from tail: tail", 3, tailElemTestInMultiplyList.tail.value);
        assertEquals("Multiply list with single elem. Remove from tail: count", 3, startElemTestInMultiplyList.count());

        startSeveralElemsTestInMultiplyList.remove(testedValue);
        assertEquals("Multiply list with several elem. Remove from tail: head", 1, startSeveralElemsTestInMultiplyList.head.value);
        assertEquals("Multiply list with several elem. Remove from tail: tail", 99999, startSeveralElemsTestInMultiplyList.tail.value);
        assertEquals("Multiply list with several elem. Remove from tail: count", 3, startSeveralElemsTestInMultiplyList.count());
    }

    @Test
    public void testRemoveFromMiddle() {
        setUpLists();

        emptyList.remove(testedValue);
        assertNull("Empty list with elem. Remove from middle: head", emptyList.head);
        assertNull("Empty list with elem. Remove from middle: tail", emptyList.tail);
        assertEquals("Empty list with elem. Remove from middle: count", 0, emptyList.count());

        oneElemListWithTestValue.remove(testedValue);
        assertNull("Single list with elem. Remove from middle: head", oneElemListWithTestValue.head);
        assertNull("Single list with elem. Remove from middle: tail", oneElemListWithTestValue.tail);
        assertEquals("Single list with elem. Remove from middle: count", 0, oneElemListWithTestValue.count());

        oneElemListWithoutTestValue.remove(testedValue);
        assertEquals("Single list with elem. Remove from middle: head", 1, oneElemListWithoutTestValue.head.value);
        assertEquals("Single list with elem. Remove from middle: tail", 1, oneElemListWithoutTestValue.tail.value);
        assertEquals("Single list with elem. Remove from middle: count", 1, oneElemListWithoutTestValue.count());

        middleElemTestInMultiplyList.remove(testedValue);
        assertEquals("Multiply list with single elem. Remove from middle: head", 1, middleElemTestInMultiplyList.head.value);
        assertEquals("Multiply list with single elem. Remove from middle: tail", 4, middleElemTestInMultiplyList.tail.value);
        assertEquals("Multiply list with single elem. Remove from middle: count", 3, startElemTestInMultiplyList.count());

        middleSeveralElemsTestInMultiplyList.remove(testedValue);
        assertEquals("Multiply list with several elem. Remove from middle: head", 1, middleSeveralElemsTestInMultiplyList.head.value);
        assertEquals("Multiply list with several elem. Remove from middle: tail", 4, middleSeveralElemsTestInMultiplyList.tail.value);
        assertEquals("Multiply list with several elem. Remove from middle: count", 3, startSeveralElemsTestInMultiplyList.count());
    }

    /**
        removeAll
     */
    @Test
    public void testRemoveAllFromStart() {
        setUpLists();

        emptyList.removeAll(testedValue);
        assertNull("Empty list with elem. Remove All from start: head", emptyList.head);
        assertNull("Empty list with elem. Remove All from start: tail", emptyList.tail);
        assertEquals("Empty list with elem. Remove All from start: count", 0, emptyList.count());

        oneElemListWithTestValue.removeAll(testedValue);
        assertNull("Single list with elem. Remove All from start: head", oneElemListWithTestValue.head);
        assertNull("Single list with elem. Remove All from start: tail", oneElemListWithTestValue.tail);
        assertEquals("Single list with elem. Remove All from start: count", 0, oneElemListWithTestValue.count());

        oneElemListWithoutTestValue.removeAll(testedValue);
        assertEquals("Single list with elem. Remove All from start: head", 1, oneElemListWithoutTestValue.head.value);
        assertEquals("Single list with elem. Remove All from start: tail", 1, oneElemListWithoutTestValue.tail.value);
        assertEquals("Single list with elem. Remove All from start: count", 1, oneElemListWithoutTestValue.count());

        startElemTestInMultiplyList.removeAll(testedValue);
        assertEquals("Multiply list with single elem. Remove All from start: head", 2, startElemTestInMultiplyList.head.value);
        assertEquals("Multiply list with single elem. Remove All from start: tail", 4, startElemTestInMultiplyList.tail.value);
        assertEquals("Multiply list with single elem. Remove All from start: count", 3, startElemTestInMultiplyList.count());

        startSeveralElemsTestInMultiplyList.removeAll(testedValue);
        assertEquals("Multiply list with several elem. Remove All from start: head", 3, startSeveralElemsTestInMultiplyList.head.value);
        assertEquals("Multiply list with several elem. Remove All from start: tail", 4, startSeveralElemsTestInMultiplyList.tail.value);
        assertEquals("Multiply list with several elem. Remove All from start: count", 2, startSeveralElemsTestInMultiplyList.count());
    }

    @Test
    public void testRemoveAllFromTail() {
        setUpLists();

        emptyList.removeAll(testedValue);
        assertNull("Empty list with elem. Remove All from tail: head", emptyList.head);
        assertNull("Empty list with elem. Remove All from tail: tail", emptyList.tail);
        assertEquals("Empty list with elem. Remove All from tail: count", 0, emptyList.count());

        oneElemListWithTestValue.removeAll(testedValue);
        assertNull("Single list with elem. Remove All from tail: head", oneElemListWithTestValue.head);
        assertNull("Single list with elem. Remove All from tail: tail", oneElemListWithTestValue.tail);
        assertEquals("Single list with elem. Remove All from tail: count", 0, oneElemListWithTestValue.count());

        oneElemListWithoutTestValue.removeAll(testedValue);
        assertEquals("Single list with elem. Remove All from tail: head", 1, oneElemListWithoutTestValue.head.value);
        assertEquals("Single list with elem. Remove All from tail: tail", 1, oneElemListWithoutTestValue.tail.value);
        assertEquals("Single list with elem. Remove All from tail: count", 1, oneElemListWithoutTestValue.count());

        tailElemTestInMultiplyList.removeAll(testedValue);
        assertEquals("Multiply list with single elem. Remove All from tail: head", 1, tailElemTestInMultiplyList.head.value);
        assertEquals("Multiply list with single elem. Remove All from tail: tail", 3, tailElemTestInMultiplyList.tail.value);
        assertEquals("Multiply list with single elem. Remove All from tail: count", 3, startElemTestInMultiplyList.count());

        startSeveralElemsTestInMultiplyList.removeAll(testedValue);
        assertEquals("Multiply list with several elem. Remove All from tail: head", 1, startSeveralElemsTestInMultiplyList.head.value);
        assertEquals("Multiply list with several elem. Remove All from tail: tail", 2, startSeveralElemsTestInMultiplyList.tail.value);
        assertEquals("Multiply list with several elem. Remove All from tail: count", 2, startSeveralElemsTestInMultiplyList.count());
    }

    @Test
    public void testRemoveAllFromMiddle() {
        setUpLists();

        emptyList.removeAll(testedValue);
        assertNull("Empty list with elem. Remove All from middle: head", emptyList.head);
        assertNull("Empty list with elem. Remove All from middle: tail", emptyList.tail);
        assertEquals("Empty list with elem. Remove All from middle: count", 0, emptyList.count());

        oneElemListWithTestValue.removeAll(testedValue);
        assertNull("Single list with elem. Remove All from middle: head", oneElemListWithTestValue.head);
        assertNull("Single list with elem. Remove All from middle: tail", oneElemListWithTestValue.tail);
        assertEquals("Single list with elem. Remove All from middle: count", 0, oneElemListWithTestValue.count());

        oneElemListWithoutTestValue.removeAll(testedValue);
        assertEquals("Single list with elem. Remove All from middle: head", 1, oneElemListWithoutTestValue.head.value);
        assertEquals("Single list with elem. Remove All from middle: tail", 1, oneElemListWithoutTestValue.tail.value);
        assertEquals("Single list with elem. Remove All from middle: count", 1, oneElemListWithoutTestValue.count());

        middleElemTestInMultiplyList.removeAll(testedValue);
        assertEquals("Multiply list with single elem. Remove All from middle: head", 1, middleElemTestInMultiplyList.head.value);
        assertEquals("Multiply list with single elem. Remove All from middle: tail", 4, middleElemTestInMultiplyList.tail.value);
        assertEquals("Multiply list with single elem. Remove All from middle: count", 3, startElemTestInMultiplyList.count());

        middleSeveralElemsTestInMultiplyList.removeAll(testedValue);
        assertEquals("Multiply list with several elem. Remove All from middle: head", 1, middleSeveralElemsTestInMultiplyList.head.value);
        assertEquals("Multiply list with several elem. Remove All from middle: tail", 4, middleSeveralElemsTestInMultiplyList.tail.value);
        assertEquals("Multiply list with several elem. Remove All from middle: count", 2, startSeveralElemsTestInMultiplyList.count());
    }
}