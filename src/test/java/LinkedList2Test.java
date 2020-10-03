import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

@RunWith(JUnit4.class)
public class LinkedList2Test extends TestCase {

    private static final int TEST_ITERATE_NUMBER = 10000;

    private LinkedList2 largeList;

    private LinkedList2 startElemTestInMultiplyList;

    private LinkedList2 startSeveralElemsTestInMultiplyList;

    private LinkedList2 middleElemTestInMultiplyList;

    private LinkedList2 middleSeveralElemsTestInMultiplyList;

    private LinkedList2 tailElemTestInMultiplyList;

    private LinkedList2 tailSeveralElemsTestInMultiplyList;

    private LinkedList2 oneElemListWithTestValue;

    private LinkedList2 oneElemListWithoutTestValue;

    private LinkedList2 emptyList;

    private int testedValue = 99999;

    private Node testedNode = new Node(testedValue);

    private LinkedList2 expectedList;

    @Before
    public void setUpLists() {
        largeList = new LinkedList2();

        for (int i = 0; i < TEST_ITERATE_NUMBER; i++) {
            largeList.addInTail(new Node(new Random().nextInt()));
        }

        startElemTestInMultiplyList = new LinkedList2();
        startElemTestInMultiplyList.addInTail(new Node(99999));
        startElemTestInMultiplyList.addInTail(new Node(2));
        startElemTestInMultiplyList.addInTail(new Node(3));
        startElemTestInMultiplyList.addInTail(new Node(4));

        startSeveralElemsTestInMultiplyList = new LinkedList2();
        startSeveralElemsTestInMultiplyList.addInTail(new Node(99999));
        startSeveralElemsTestInMultiplyList.addInTail(new Node(99999));
        startSeveralElemsTestInMultiplyList.addInTail(new Node(3));
        startSeveralElemsTestInMultiplyList.addInTail(new Node(4));

        middleElemTestInMultiplyList = new LinkedList2();
        middleElemTestInMultiplyList.addInTail(new Node(1));
        middleElemTestInMultiplyList.addInTail(new Node(99999));
        middleElemTestInMultiplyList.addInTail(new Node(3));
        middleElemTestInMultiplyList.addInTail(new Node(4));

        middleSeveralElemsTestInMultiplyList = new LinkedList2();
        middleSeveralElemsTestInMultiplyList.addInTail(new Node(1));
        middleSeveralElemsTestInMultiplyList.addInTail(new Node(99999));
        middleSeveralElemsTestInMultiplyList.addInTail(new Node(99999));
        middleSeveralElemsTestInMultiplyList.addInTail(new Node(4));

        tailElemTestInMultiplyList = new LinkedList2();
        tailElemTestInMultiplyList.addInTail(new Node(1));
        tailElemTestInMultiplyList.addInTail(new Node(2));
        tailElemTestInMultiplyList.addInTail(new Node(3));
        tailElemTestInMultiplyList.addInTail(new Node(99999));

        tailSeveralElemsTestInMultiplyList = new LinkedList2();
        tailSeveralElemsTestInMultiplyList.addInTail(new Node(1));
        tailSeveralElemsTestInMultiplyList.addInTail(new Node(2));
        tailSeveralElemsTestInMultiplyList.addInTail(new Node(99999));
        tailSeveralElemsTestInMultiplyList.addInTail(new Node(99999));

        oneElemListWithTestValue = new LinkedList2();
        oneElemListWithTestValue.addInTail(new Node(99999));

        oneElemListWithoutTestValue = new LinkedList2();
        oneElemListWithoutTestValue.addInTail(new Node(1));

        emptyList = new LinkedList2();

        expectedList = new LinkedList2();
        expectedList.addInTail(new Node(1));
        expectedList.addInTail(new Node(2));
        expectedList.addInTail(new Node(3));
        expectedList.addInTail(new Node(4));
    }

    /**
     * find
     */
    @Test
    public void testFind() {
        setUpLists();

        Node fromStartInMultiplyListActualNode = startElemTestInMultiplyList.find(testedValue);
        assertEquals(testedValue, fromStartInMultiplyListActualNode.value);
        assertNull(fromStartInMultiplyListActualNode.prev);
        assertEquals(2, fromStartInMultiplyListActualNode.next.value);

        Node fromStartInMultiplyListWithSeveralElemsActualNode = startSeveralElemsTestInMultiplyList.find(testedValue);
        assertEquals(testedValue, fromStartInMultiplyListWithSeveralElemsActualNode.value);
        assertNull(fromStartInMultiplyListWithSeveralElemsActualNode.prev);
        assertEquals(testedValue, fromStartInMultiplyListWithSeveralElemsActualNode.next.value);

        Node fromMiddleInMultiplyListActualNode = middleElemTestInMultiplyList.find(testedValue);
        assertEquals(testedValue, fromMiddleInMultiplyListActualNode.value);
        assertEquals(1, fromMiddleInMultiplyListActualNode.prev.value);
        assertEquals(3, fromMiddleInMultiplyListActualNode.next.value);

        Node fromMiddleInMultiplyListWithSeveralElemsActualNode = middleSeveralElemsTestInMultiplyList.find(testedValue);
        assertEquals(testedValue, fromMiddleInMultiplyListWithSeveralElemsActualNode.value);
        assertEquals(1, fromMiddleInMultiplyListWithSeveralElemsActualNode.prev.value);
        assertEquals(testedValue, fromMiddleInMultiplyListWithSeveralElemsActualNode.next.value);

        Node fromTailInMultiplyListWithActualNode = tailElemTestInMultiplyList.find(testedValue);
        assertEquals(testedValue, fromTailInMultiplyListWithActualNode.value);
        assertEquals(3, fromTailInMultiplyListWithActualNode.prev.value);
        assertNull(fromTailInMultiplyListWithActualNode.next);

        Node fromTailInMultiplyListWithSeveralElemsActualNode = tailSeveralElemsTestInMultiplyList.find(testedValue);
        assertEquals(testedValue, fromTailInMultiplyListWithSeveralElemsActualNode.value);
        assertEquals(2, fromTailInMultiplyListWithSeveralElemsActualNode.prev.value);
        assertEquals(testedValue, fromTailInMultiplyListWithSeveralElemsActualNode.next.value);

        Node oneElemListWithValueActualNode = oneElemListWithTestValue.find(testedValue);
        assertEquals(testedValue, oneElemListWithValueActualNode.value);

        Node oneElemListWithoutValueActualNode = oneElemListWithoutTestValue.find(testedValue);
        assertNull(oneElemListWithoutValueActualNode);

        Node emptyListActualNode = emptyList.find(testedValue);
        assertNull(emptyListActualNode);
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
        assertEquals("Multiply list with single elem. Remove from tail: count", 3, tailElemTestInMultiplyList.count());

        startSeveralElemsTestInMultiplyList.remove(testedValue);
        assertEquals("Multiply list with several elem. Remove from tail: head", 99999, startSeveralElemsTestInMultiplyList.head.value);
        assertEquals("Multiply list with several elem. Remove from tail: tail", 4, startSeveralElemsTestInMultiplyList.tail.value);
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
        assertEquals("Multiply list with single elem. Remove from middle: count", 3, middleElemTestInMultiplyList.count());

        middleSeveralElemsTestInMultiplyList.remove(testedValue);
        assertEquals("Multiply list with several elem. Remove from middle: head", 1, middleSeveralElemsTestInMultiplyList.head.value);
        assertEquals("Multiply list with several elem. Remove from middle: tail", 4, middleSeveralElemsTestInMultiplyList.tail.value);
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
        assertEquals("Multiply list with single elem. Remove All from tail: count", 3, tailElemTestInMultiplyList.count());

        startSeveralElemsTestInMultiplyList.removeAll(testedValue);
        assertEquals("Multiply list with several elem. Remove All from tail: head", 3, startSeveralElemsTestInMultiplyList.head.value);
        assertEquals("Multiply list with several elem. Remove All from tail: tail", 4, startSeveralElemsTestInMultiplyList.tail.value);
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
        assertEquals("Multiply list with single elem. Remove All from middle: count", 3, middleElemTestInMultiplyList.count());

        middleSeveralElemsTestInMultiplyList.removeAll(testedValue);
        assertEquals("Multiply list with several elem. Remove All from middle: head", 1, middleSeveralElemsTestInMultiplyList.head.value);
        assertEquals("Multiply list with several elem. Remove All from middle: tail", 4, middleSeveralElemsTestInMultiplyList.tail.value);
        assertEquals("Multiply list with several elem. Remove All from middle: count", 2, middleSeveralElemsTestInMultiplyList.count());
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
        ArrayList<Node> expectedArrayListWithOneResult = new ArrayList<>();
        ArrayList<Node> expectedArrayListWithSeveralResult = new ArrayList<>();
        expectedArrayListWithOneResult.add(new Node(testedValue));
        expectedArrayListWithSeveralResult.add(new Node(testedValue));
        expectedArrayListWithSeveralResult.add(new Node(testedValue));

        ArrayList<Node> actualStartMultiply = startElemTestInMultiplyList.findAll(testedValue);
        expectedArrayListWithOneResult.forEach(expected -> {
            assertEquals(expected.value, actualStartMultiply.get(0).value);
        });

        ArrayList<Node> actualStartSeveralMultiply = startSeveralElemsTestInMultiplyList.findAll(testedValue);
        for (int i = 0; i < expectedArrayListWithSeveralResult.size(); i++) {
            assertEquals(expectedArrayListWithSeveralResult.get(i).value, actualStartSeveralMultiply.get(i).value);
        }

        ArrayList<Node> actualMiddleMultiply = middleElemTestInMultiplyList.findAll(testedValue);
        for (int i = 0; i < expectedArrayListWithOneResult.size(); i++) {
            assertEquals(expectedArrayListWithOneResult.get(i).value, actualMiddleMultiply.get(i).value);
        }

        ArrayList<Node> actualMiddleSeveralMultiply = middleSeveralElemsTestInMultiplyList.findAll(testedValue);
        for (int i = 0; i < expectedArrayListWithSeveralResult.size(); i++) {
            assertEquals(expectedArrayListWithSeveralResult.get(i).value, actualMiddleSeveralMultiply.get(i).value);
        }

        ArrayList<Node> actualTailMultiply = tailElemTestInMultiplyList.findAll(testedValue);
        for (int i = 0; i < expectedArrayListWithOneResult.size(); i++) {
            assertEquals(expectedArrayListWithOneResult.get(i).value, actualTailMultiply.get(i).value);
        }

        ArrayList<Node> actualTailSeveralMultiply = tailSeveralElemsTestInMultiplyList.findAll(testedValue);
        for (int i = 0; i < expectedArrayListWithSeveralResult.size(); i++) {
            assertEquals(expectedArrayListWithSeveralResult.get(i).value, actualTailSeveralMultiply.get(i).value);
        }

        ArrayList<Node> actualOneElemWithValue = oneElemListWithTestValue.findAll(testedValue);
        for (int i = 0; i < expectedArrayListWithOneResult.size(); i++) {
            assertEquals(expectedArrayListWithOneResult.get(i).value, actualOneElemWithValue.get(i).value);
        }

        ArrayList<Node> actualOneElemWithoutValue = oneElemListWithoutTestValue.findAll(testedValue);
        for (int i = 0; i < expectedArrayListWithOneResult.size(); i++) {
            assertEquals(new ArrayList<>(), actualOneElemWithoutValue);
        }

        ArrayList<Node> emptyListValue = emptyList.findAll(testedValue);
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

        tailElemTestInMultiplyList.insertAfter(null, testedNode);
        assertEquals(testedValue, tailElemTestInMultiplyList.head.value);
        assertEquals(1, tailElemTestInMultiplyList.head.next.value);
        assertEquals(testedValue, tailElemTestInMultiplyList.tail.value);
        assertEquals(5, tailElemTestInMultiplyList.count());

        setUpLists();

        tailElemTestInMultiplyList.insertAfter(new Node(1), testedNode);
        assertEquals(1, tailElemTestInMultiplyList.head.value);
        assertEquals(testedValue, tailElemTestInMultiplyList.head.next.value);
        assertEquals(2, tailElemTestInMultiplyList.head.next.next.value);
        assertEquals(5, tailElemTestInMultiplyList.count());

        startElemTestInMultiplyList.insertAfter(new Node(4), testedNode);
        assertEquals(testedValue, startElemTestInMultiplyList.head.value);
        assertEquals(testedValue, startElemTestInMultiplyList.tail.value);
        assertNull(startElemTestInMultiplyList.tail.next);
        assertEquals(4, startElemTestInMultiplyList.head.next.next.next.value);
        assertEquals(5, startElemTestInMultiplyList.count());

        oneElemListWithoutTestValue.insertAfter(new Node(1), testedNode);
        assertEquals(1, oneElemListWithoutTestValue.head.value);
        assertEquals(testedValue, oneElemListWithoutTestValue.head.next.value);
        assertNull(oneElemListWithoutTestValue.tail.next);
        assertEquals(testedValue, oneElemListWithoutTestValue.tail.value);
        assertEquals(2, oneElemListWithoutTestValue.count());

        emptyList.insertAfter(null, testedNode);
        assertEquals(testedValue, emptyList.head.value);
        assertEquals(testedValue, emptyList.tail.value);
        assertNull(emptyList.tail.next);
        assertEquals(1, emptyList.count());
    }
}