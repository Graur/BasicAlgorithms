import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.arg.skillsmart.algorithms.LinkedList2;
import ru.arg.skillsmart.algorithms.LinkedList2Node;

import java.util.ArrayList;
import java.util.Random;

@RunWith(JUnit4.class)
public class LinkedList2Test extends TestCase {

    private static final int TEST_ITERATE_NUMBER = 10000;

    private LinkedList2 largeList;

    private LinkedList2 startElemTestInMultiplyList;

    private LinkedList2 startSeveralElemsTestInMultiplyList;

    private LinkedList2 middleElemTestInMultiplyList;

    private LinkedList2 middleSeveralElemsTestInMultiplyList;

    private LinkedList2 middleSeveralElemsTestInMultiplyList2;

    private LinkedList2 tailElemTestInMultiplyList;

    private LinkedList2 tailSeveralElemsTestInMultiplyList;

    private LinkedList2 oneElemListWithTestValue;

    private LinkedList2 oneElemListWithoutTestValue;

    private LinkedList2 emptyList;

    private int testedValue;

    private LinkedList2Node testedLinkedList2Node;

    private LinkedList2 expectedList;

    @Before
    public void setUpLists() {
        largeList = new LinkedList2();

        for (int i = 0; i < TEST_ITERATE_NUMBER; i++) {
            largeList.addInTail(new LinkedList2Node(new Random().nextInt()));
        }

        testedValue  = 99999;
        testedLinkedList2Node = new LinkedList2Node(testedValue);

        startElemTestInMultiplyList = new LinkedList2();
        startElemTestInMultiplyList.addInTail(new LinkedList2Node(99999));
        startElemTestInMultiplyList.addInTail(new LinkedList2Node(2));
        startElemTestInMultiplyList.addInTail(new LinkedList2Node(3));
        startElemTestInMultiplyList.addInTail(new LinkedList2Node(4));

        startSeveralElemsTestInMultiplyList = new LinkedList2();
        startSeveralElemsTestInMultiplyList.addInTail(new LinkedList2Node(99999));
        startSeveralElemsTestInMultiplyList.addInTail(new LinkedList2Node(99999));
        startSeveralElemsTestInMultiplyList.addInTail(new LinkedList2Node(3));
        startSeveralElemsTestInMultiplyList.addInTail(new LinkedList2Node(4));

        middleElemTestInMultiplyList = new LinkedList2();
        middleElemTestInMultiplyList.addInTail(new LinkedList2Node(1));
        middleElemTestInMultiplyList.addInTail(new LinkedList2Node(99999));
        middleElemTestInMultiplyList.addInTail(new LinkedList2Node(3));
        middleElemTestInMultiplyList.addInTail(new LinkedList2Node(4));

        middleSeveralElemsTestInMultiplyList = new LinkedList2();
        middleSeveralElemsTestInMultiplyList.addInTail(new LinkedList2Node(1));
        middleSeveralElemsTestInMultiplyList.addInTail(new LinkedList2Node(99999));
        middleSeveralElemsTestInMultiplyList.addInTail(new LinkedList2Node(99999));
        middleSeveralElemsTestInMultiplyList.addInTail(new LinkedList2Node(4));

        middleSeveralElemsTestInMultiplyList2 = new LinkedList2();
        middleSeveralElemsTestInMultiplyList2.addInTail(new LinkedList2Node(1));
        middleSeveralElemsTestInMultiplyList2.addInTail(new LinkedList2Node(99999));
        middleSeveralElemsTestInMultiplyList2.addInTail(new LinkedList2Node(3));
        middleSeveralElemsTestInMultiplyList2.addInTail(new LinkedList2Node(99999));
        middleSeveralElemsTestInMultiplyList2.addInTail(new LinkedList2Node(5));

        tailElemTestInMultiplyList = new LinkedList2();
        tailElemTestInMultiplyList.addInTail(new LinkedList2Node(1));
        tailElemTestInMultiplyList.addInTail(new LinkedList2Node(2));
        tailElemTestInMultiplyList.addInTail(new LinkedList2Node(3));
        tailElemTestInMultiplyList.addInTail(new LinkedList2Node(99999));

        tailSeveralElemsTestInMultiplyList = new LinkedList2();
        tailSeveralElemsTestInMultiplyList.addInTail(new LinkedList2Node(1));
        tailSeveralElemsTestInMultiplyList.addInTail(new LinkedList2Node(2));
        tailSeveralElemsTestInMultiplyList.addInTail(new LinkedList2Node(99999));
        tailSeveralElemsTestInMultiplyList.addInTail(new LinkedList2Node(99999));

        oneElemListWithTestValue = new LinkedList2();
        oneElemListWithTestValue.addInTail(new LinkedList2Node(99999));

        oneElemListWithoutTestValue = new LinkedList2();
        oneElemListWithoutTestValue.addInTail(new LinkedList2Node(1));

        emptyList = new LinkedList2();

        expectedList = new LinkedList2();
        expectedList.addInTail(new LinkedList2Node(1));
        expectedList.addInTail(new LinkedList2Node(2));
        expectedList.addInTail(new LinkedList2Node(3));
        expectedList.addInTail(new LinkedList2Node(4));
    }

    /**
     * find
     */
    @Test
    public void testFind() {
        setUpLists();

        LinkedList2Node fromStartInMultiplyListActualLinkedList2Node = startElemTestInMultiplyList.find(testedValue);
        assertEquals(testedValue, fromStartInMultiplyListActualLinkedList2Node.value);
        assertNull(fromStartInMultiplyListActualLinkedList2Node.prev);
        assertEquals(2, fromStartInMultiplyListActualLinkedList2Node.next.value);

        LinkedList2Node fromStartInMultiplyListWithSeveralElemsActualLinkedList2Node = startSeveralElemsTestInMultiplyList.find(testedValue);
        assertEquals(testedValue, fromStartInMultiplyListWithSeveralElemsActualLinkedList2Node.value);
        assertNull(fromStartInMultiplyListWithSeveralElemsActualLinkedList2Node.prev);
        assertEquals(testedValue, fromStartInMultiplyListWithSeveralElemsActualLinkedList2Node.next.value);

        LinkedList2Node fromMiddleInMultiplyListActualLinkedList2Node = middleElemTestInMultiplyList.find(testedValue);
        assertEquals(testedValue, fromMiddleInMultiplyListActualLinkedList2Node.value);
        assertEquals(1, fromMiddleInMultiplyListActualLinkedList2Node.prev.value);
        assertEquals(3, fromMiddleInMultiplyListActualLinkedList2Node.next.value);

        LinkedList2Node fromMiddleInMultiplyListWithSeveralElemsActualLinkedList2Node = middleSeveralElemsTestInMultiplyList.find(testedValue);
        assertEquals(testedValue, fromMiddleInMultiplyListWithSeveralElemsActualLinkedList2Node.value);
        assertEquals(1, fromMiddleInMultiplyListWithSeveralElemsActualLinkedList2Node.prev.value);
        assertEquals(testedValue, fromMiddleInMultiplyListWithSeveralElemsActualLinkedList2Node.next.value);

        LinkedList2Node fromTailInMultiplyListWithActualLinkedList2Node = tailElemTestInMultiplyList.find(testedValue);
        assertEquals(testedValue, fromTailInMultiplyListWithActualLinkedList2Node.value);
        assertEquals(3, fromTailInMultiplyListWithActualLinkedList2Node.prev.value);
        assertNull(fromTailInMultiplyListWithActualLinkedList2Node.next);

        LinkedList2Node fromTailInMultiplyListWithSeveralElemsActualLinkedList2Node = tailSeveralElemsTestInMultiplyList.find(testedValue);
        assertEquals(testedValue, fromTailInMultiplyListWithSeveralElemsActualLinkedList2Node.value);
        assertEquals(2, fromTailInMultiplyListWithSeveralElemsActualLinkedList2Node.prev.value);
        assertEquals(testedValue, fromTailInMultiplyListWithSeveralElemsActualLinkedList2Node.next.value);

        LinkedList2Node oneElemListWithValueActualLinkedList2Node = oneElemListWithTestValue.find(testedValue);
        assertEquals(testedValue, oneElemListWithValueActualLinkedList2Node.value);

        LinkedList2Node oneElemListWithoutValueActualLinkedList2Node = oneElemListWithoutTestValue.find(testedValue);
        assertNull(oneElemListWithoutValueActualLinkedList2Node);

        LinkedList2Node emptyListActualLinkedList2Node = emptyList.find(testedValue);
        assertNull(emptyListActualLinkedList2Node);
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
        assertNull(oneElemListWithoutTestValue.head.prev);
        assertEquals("Single list with elem. Remove from start: tail", 1, oneElemListWithoutTestValue.tail.value);
        assertNull(oneElemListWithoutTestValue.tail.next);
        assertEquals("Single list with elem. Remove from start: count", 1, oneElemListWithoutTestValue.count());

        startElemTestInMultiplyList.remove(testedValue);
        assertEquals("Multiply list with single elem. Remove from start: head", 2, startElemTestInMultiplyList.head.value);
        assertNull(startElemTestInMultiplyList.head.prev);
        assertNull(startElemTestInMultiplyList.tail.next);
        assertEquals("Multiply list with single elem. Remove from start: tail", 4, startElemTestInMultiplyList.tail.value);
        assertEquals("Multiply list with single elem. Remove from start: count", 3, startElemTestInMultiplyList.count());

        startSeveralElemsTestInMultiplyList.remove(testedValue);
        assertEquals("Multiply list with several elem. Remove from start: head", 99999, startSeveralElemsTestInMultiplyList.head.value);
        assertEquals("Multiply list with several elem. Remove from start: tail", 4, startSeveralElemsTestInMultiplyList.tail.value);
        assertEquals("Multiply list with several elem. Remove from start: count", 3, startSeveralElemsTestInMultiplyList.count());
        assertNull(startSeveralElemsTestInMultiplyList.head.prev);
        assertNull(startSeveralElemsTestInMultiplyList.tail.next);
    }

    @Test
    public void testRemoveFromTail() {
        setUpLists();

        tailElemTestInMultiplyList.remove(testedValue);
        assertEquals("Multiply list with single elem. Remove from tail: head", 1, tailElemTestInMultiplyList.head.value);
        assertEquals("Multiply list with single elem. Remove from tail: tail", 3, tailElemTestInMultiplyList.tail.value);
        assertEquals("Multiply list with single elem. Remove from tail: tail", 2, tailElemTestInMultiplyList.tail.prev.value);
        assertNull(tailElemTestInMultiplyList.head.prev);
        assertNull(tailElemTestInMultiplyList.tail.next);
        assertEquals("Multiply list with single elem. Remove from tail: count", 3, tailElemTestInMultiplyList.count());

        tailSeveralElemsTestInMultiplyList.remove(testedValue);
        assertEquals("Multiply list with several elem. Remove from tail: head", 1, tailSeveralElemsTestInMultiplyList.head.value);
        assertEquals("Multiply list with several elem. Remove from tail: tail", testedValue, tailSeveralElemsTestInMultiplyList.tail.value);
        assertEquals("Multiply list with several elem. Remove from tail: tail", 2, tailSeveralElemsTestInMultiplyList.tail.prev.value);
        assertNull(tailSeveralElemsTestInMultiplyList.head.prev);
        assertNull(tailSeveralElemsTestInMultiplyList.tail.next);
        assertEquals("Multiply list with several elem. Remove from tail: count", 3, tailSeveralElemsTestInMultiplyList.count());
    }

    @Test
    public void testRemoveFromMiddle() {
        setUpLists();

        middleElemTestInMultiplyList.remove(testedValue);
        assertEquals("Multiply list with single elem. Remove from middle: head", 1, middleElemTestInMultiplyList.head.value);
        assertEquals("Multiply list with single elem. Remove from middle: tail", 4, middleElemTestInMultiplyList.tail.value);
        assertEquals(3, middleElemTestInMultiplyList.tail.prev.value);
        assertEquals(3, middleElemTestInMultiplyList.head.next.value);
        assertNull(middleElemTestInMultiplyList.head.prev);
        assertNull(middleElemTestInMultiplyList.tail.next);
        assertEquals("Multiply list with single elem. Remove from middle: count", 3, middleElemTestInMultiplyList.count());

        middleSeveralElemsTestInMultiplyList.remove(testedValue);
        assertEquals("Multiply list with several elem. Remove from middle: head", 1, middleSeveralElemsTestInMultiplyList.head.value);
        assertEquals("Multiply list with several elem. Remove from middle: tail", 4, middleSeveralElemsTestInMultiplyList.tail.value);
        assertEquals(testedValue, middleSeveralElemsTestInMultiplyList.tail.prev.value);
        assertEquals(testedValue, middleSeveralElemsTestInMultiplyList.head.next.value);
        assertNull(middleSeveralElemsTestInMultiplyList.head.prev);
        assertNull(middleSeveralElemsTestInMultiplyList.tail.next);
        assertEquals("Multiply list with several elem. Remove from middle: count", 3, middleSeveralElemsTestInMultiplyList.count());
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
        assertNull(oneElemListWithoutTestValue.head.prev);
        assertNull(oneElemListWithoutTestValue.tail.next);
        assertEquals("Single list with elem. Remove All from start: count", 1, oneElemListWithoutTestValue.count());

        startElemTestInMultiplyList.removeAll(testedValue);
        assertEquals("Multiply list with single elem. Remove All from start: head", 2, startElemTestInMultiplyList.head.value);
        assertEquals("Multiply list with single elem. Remove All from start: tail", 4, startElemTestInMultiplyList.tail.value);
        assertNull(startElemTestInMultiplyList.head.prev);
        assertNull(startElemTestInMultiplyList.tail.next);
        assertEquals("Multiply list with single elem. Remove All from start: count", 3, startElemTestInMultiplyList.count());

        startSeveralElemsTestInMultiplyList.removeAll(testedValue);
        assertEquals("Multiply list with several elem. Remove All from start: head", 3, startSeveralElemsTestInMultiplyList.head.value);
        assertEquals("Multiply list with several elem. Remove All from start: tail", 4, startSeveralElemsTestInMultiplyList.tail.value);
        assertNull(startSeveralElemsTestInMultiplyList.head.prev);
        assertNull(startSeveralElemsTestInMultiplyList.tail.next);
        assertEquals("Multiply list with several elem. Remove All from start: count", 2, startSeveralElemsTestInMultiplyList.count());
    }

    @Test
    public void testRemoveAllFromTail() {
        setUpLists();

        tailElemTestInMultiplyList.removeAll(testedValue);
        assertEquals("Multiply list with single elem. Remove All from tail: head", 1, tailElemTestInMultiplyList.head.value);
        assertEquals("Multiply list with single elem. Remove All from tail: tail", 3, tailElemTestInMultiplyList.tail.value);
        assertEquals(2, tailElemTestInMultiplyList.tail.prev.value);
        assertNull(tailElemTestInMultiplyList.head.prev);
        assertNull(tailElemTestInMultiplyList.tail.next);
        assertEquals("Multiply list with single elem. Remove All from tail: count", 3, tailElemTestInMultiplyList.count());

        tailSeveralElemsTestInMultiplyList.removeAll(testedValue);
        assertEquals("Multiply list with several elem. Remove All from tail: head", 1, tailSeveralElemsTestInMultiplyList.head.value);
        assertEquals("Multiply list with several elem. Remove All from tail: tail", 2, tailSeveralElemsTestInMultiplyList.tail.value);
        assertNull(tailSeveralElemsTestInMultiplyList.head.prev);
        assertNull(tailSeveralElemsTestInMultiplyList.tail.next);
        assertEquals("Multiply list with several elem. Remove All from tail: count", 2, tailSeveralElemsTestInMultiplyList.count());
    }

    @Test
    public void testRemoveAllFromMiddle() {
        setUpLists();

        middleElemTestInMultiplyList.removeAll(testedValue);
        assertEquals("Multiply list with single elem. Remove All from middle: head", 1, middleElemTestInMultiplyList.head.value);
        assertEquals("Multiply list with single elem. Remove All from middle: tail", 4, middleElemTestInMultiplyList.tail.value);
        assertNull(middleElemTestInMultiplyList.head.prev);
        assertNull(middleElemTestInMultiplyList.tail.next);
        assertEquals("Multiply list with single elem. Remove All from middle: count", 3, middleElemTestInMultiplyList.count());

        middleSeveralElemsTestInMultiplyList.removeAll(testedValue);
        assertEquals("Multiply list with several elem. Remove All from middle: head", 1, middleSeveralElemsTestInMultiplyList.head.value);
        assertEquals("Multiply list with several elem. Remove All from middle: head", 4, middleSeveralElemsTestInMultiplyList.head.next.value);
        assertEquals("Multiply list with several elem. Remove All from middle: tail", 4, middleSeveralElemsTestInMultiplyList.tail.value);
        assertEquals("Multiply list with several elem. Remove All from middle: tail", 1, middleSeveralElemsTestInMultiplyList.tail.prev.value);
        assertNull(middleSeveralElemsTestInMultiplyList.head.prev);
        assertNull(middleSeveralElemsTestInMultiplyList.tail.next);
        assertEquals("Multiply list with several elem. Remove All from middle: count", 2, middleSeveralElemsTestInMultiplyList.count());

        middleSeveralElemsTestInMultiplyList2.removeAll(testedValue);
        assertEquals("Multiply list with several elem. Remove All from middle: head", 1, middleSeveralElemsTestInMultiplyList2.head.value);
        assertEquals("Multiply list with several elem. Remove All from middle: head", 3, middleSeveralElemsTestInMultiplyList2.head.next.value);
        assertEquals("Multiply list with several elem. Remove All from middle: tail", 5, middleSeveralElemsTestInMultiplyList2.tail.value);
        assertEquals("Multiply list with several elem. Remove All from middle: tail", 3, middleSeveralElemsTestInMultiplyList2.tail.prev.value);
        assertNull(middleSeveralElemsTestInMultiplyList2.head.prev);
        assertNull(middleSeveralElemsTestInMultiplyList2.tail.next);
        assertEquals("Multiply list with several elem. Remove All from middle: count", 3, middleSeveralElemsTestInMultiplyList2.count());
    }

    /**
     clear
     */
    @Test
    public void testClear() {
        setUpLists();

        startElemTestInMultiplyList.clear();
        startSeveralElemsTestInMultiplyList.clear();
        middleElemTestInMultiplyList.clear();
        middleSeveralElemsTestInMultiplyList.clear();
        tailElemTestInMultiplyList.clear();
        tailSeveralElemsTestInMultiplyList.clear();
        oneElemListWithTestValue.clear();
        oneElemListWithoutTestValue.clear();
        emptyList.clear();

        assertNull(startElemTestInMultiplyList.head);
        assertNull(startElemTestInMultiplyList.tail);
        assertEquals(0, startElemTestInMultiplyList.count());

        assertNull(startSeveralElemsTestInMultiplyList.head);
        assertNull(startSeveralElemsTestInMultiplyList.tail);
        assertEquals(0, startSeveralElemsTestInMultiplyList.count());

        assertNull(middleElemTestInMultiplyList.head);
        assertNull(middleElemTestInMultiplyList.tail);
        assertEquals(0, middleElemTestInMultiplyList.count());

        assertNull(middleSeveralElemsTestInMultiplyList.head);
        assertNull(middleSeveralElemsTestInMultiplyList.tail);
        assertEquals(0, middleSeveralElemsTestInMultiplyList.count());

        assertNull(tailElemTestInMultiplyList.head);
        assertNull(tailElemTestInMultiplyList.tail);
        assertEquals(0, tailElemTestInMultiplyList.count());

        assertNull(tailSeveralElemsTestInMultiplyList.head);
        assertNull(tailSeveralElemsTestInMultiplyList.tail);
        assertEquals(0, tailSeveralElemsTestInMultiplyList.count());

        assertNull(oneElemListWithTestValue.head);
        assertNull(oneElemListWithTestValue.tail);
        assertEquals(0, oneElemListWithTestValue.count());

        assertNull(oneElemListWithoutTestValue.head);
        assertNull(oneElemListWithoutTestValue.tail);
        assertEquals(0, oneElemListWithoutTestValue.count());

        assertNull(emptyList.head);
        assertNull(emptyList.tail);
        assertEquals(0, emptyList.count());
    }

    /**
     find all
     */
    @Test
    public void testFindAll() {
        setUpLists();
        ArrayList<LinkedList2Node> expectedArrayListWithOneResult = new ArrayList<>();
        ArrayList<LinkedList2Node> expectedArrayListWithSeveralResult = new ArrayList<>();
        expectedArrayListWithOneResult.add(new LinkedList2Node(testedValue));
        expectedArrayListWithSeveralResult.add(new LinkedList2Node(testedValue));
        expectedArrayListWithSeveralResult.add(new LinkedList2Node(testedValue));

        ArrayList<LinkedList2Node> actualStartMultiply = startElemTestInMultiplyList.findAll(testedValue);
        expectedArrayListWithOneResult.forEach(expected -> {
            assertEquals(expected.value, actualStartMultiply.get(0).value);
        });

        ArrayList<LinkedList2Node> actualStartSeveralMultiply = startSeveralElemsTestInMultiplyList.findAll(testedValue);
        for (int i = 0; i < expectedArrayListWithSeveralResult.size(); i++) {
            assertEquals(expectedArrayListWithSeveralResult.get(i).value, actualStartSeveralMultiply.get(i).value);
        }

        ArrayList<LinkedList2Node> actualMiddleMultiply = middleElemTestInMultiplyList.findAll(testedValue);
        for (int i = 0; i < expectedArrayListWithOneResult.size(); i++) {
            assertEquals(expectedArrayListWithOneResult.get(i).value, actualMiddleMultiply.get(i).value);
        }

        ArrayList<LinkedList2Node> actualMiddleSeveralMultiply = middleSeveralElemsTestInMultiplyList.findAll(testedValue);
        for (int i = 0; i < expectedArrayListWithSeveralResult.size(); i++) {
            assertEquals(expectedArrayListWithSeveralResult.get(i).value, actualMiddleSeveralMultiply.get(i).value);
        }

        ArrayList<LinkedList2Node> actualTailMultiply = tailElemTestInMultiplyList.findAll(testedValue);
        for (int i = 0; i < expectedArrayListWithOneResult.size(); i++) {
            assertEquals(expectedArrayListWithOneResult.get(i).value, actualTailMultiply.get(i).value);
        }

        ArrayList<LinkedList2Node> actualTailSeveralMultiply = tailSeveralElemsTestInMultiplyList.findAll(testedValue);
        for (int i = 0; i < expectedArrayListWithSeveralResult.size(); i++) {
            assertEquals(expectedArrayListWithSeveralResult.get(i).value, actualTailSeveralMultiply.get(i).value);
        }

        ArrayList<LinkedList2Node> actualOneElemWithValue = oneElemListWithTestValue.findAll(testedValue);
        for (int i = 0; i < expectedArrayListWithOneResult.size(); i++) {
            assertEquals(expectedArrayListWithOneResult.get(i).value, actualOneElemWithValue.get(i).value);
        }

        ArrayList<LinkedList2Node> actualOneElemWithoutValue = oneElemListWithoutTestValue.findAll(testedValue);
        for (int i = 0; i < expectedArrayListWithOneResult.size(); i++) {
            assertEquals(new ArrayList<>(), actualOneElemWithoutValue);
        }

        ArrayList<LinkedList2Node> emptyListValue = emptyList.findAll(testedValue);
        for (int i = 0; i < expectedArrayListWithOneResult.size(); i++) {
            assertEquals(new ArrayList<>(), emptyListValue);
        }
    }

    /**
     count
     */
    @Test
    public void testCount() {
        setUpLists();

        assertEquals(0, emptyList.count());
        assertEquals(1, oneElemListWithTestValue.count());
        assertEquals(4, tailSeveralElemsTestInMultiplyList.count());
    }

    /**
     insert after
     */
    @Test
    public void testInsertAfter() {
        setUpLists();

        tailElemTestInMultiplyList.insertAfter(null, testedLinkedList2Node);
        assertEquals(testedValue, tailElemTestInMultiplyList.head.value);
        assertEquals(1, tailElemTestInMultiplyList.head.next.value);
        assertNull(tailElemTestInMultiplyList.head.prev);
        assertEquals(testedValue, tailElemTestInMultiplyList.head.next.prev.value);
        assertEquals(testedValue, tailElemTestInMultiplyList.tail.value);
        assertEquals(5, tailElemTestInMultiplyList.count());

        setUpLists();

        tailElemTestInMultiplyList.insertAfter(new LinkedList2Node(1), testedLinkedList2Node);
        assertEquals(1, tailElemTestInMultiplyList.head.value);
        assertEquals(testedValue, tailElemTestInMultiplyList.head.next.value);
        assertNull(tailElemTestInMultiplyList.head.prev);
        assertEquals(1, tailElemTestInMultiplyList.head.next.prev.value);
        assertEquals(2, tailElemTestInMultiplyList.head.next.next.value);
        assertEquals(5, tailElemTestInMultiplyList.count());

        setUpLists();

        startElemTestInMultiplyList.insertAfter(new LinkedList2Node(4), testedLinkedList2Node);
        assertEquals(testedValue, startElemTestInMultiplyList.head.value);
        assertEquals(testedValue, startElemTestInMultiplyList.tail.value);
        assertNull(startElemTestInMultiplyList.tail.next);
        assertEquals(4, startElemTestInMultiplyList.head.next.next.next.value);
        assertEquals(4, startElemTestInMultiplyList.tail.prev.value);
        assertEquals(5, startElemTestInMultiplyList.count());

        setUpLists();

        oneElemListWithoutTestValue.insertAfter(new LinkedList2Node(1), testedLinkedList2Node);
        assertEquals(1, oneElemListWithoutTestValue.head.value);
        assertEquals(testedValue, oneElemListWithoutTestValue.head.next.value);
        assertNull(oneElemListWithoutTestValue.tail.next);
        assertNull(oneElemListWithoutTestValue.head.prev);
        assertEquals(testedValue, oneElemListWithoutTestValue.tail.value);
        assertEquals(1, oneElemListWithoutTestValue.tail.prev.value);
        assertEquals(2, oneElemListWithoutTestValue.count());

        setUpLists();

        emptyList.insertAfter(null, testedLinkedList2Node);
        assertEquals(testedValue, emptyList.head.value);
        assertEquals(testedValue, emptyList.tail.value);
        assertNull(emptyList.tail.next);
        assertNull(emptyList.head.prev);
        assertEquals(1, emptyList.count());
    }
}