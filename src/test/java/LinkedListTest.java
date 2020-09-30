import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;

@RunWith(JUnit4.class)
public class LinkedListTest extends TestCase {

    private LinkedList largeList;

    private LinkedList oneElementList;

    private LinkedList emptyList;

    @Before
    public void setUpLargeList() {
        largeList = new LinkedList();
        largeList.addInTail(new Node(1));
        largeList.addInTail(new Node(3));
        largeList.addInTail(new Node(7));
        largeList.addInTail(new Node(9));
        largeList.addInTail(new Node(6));
        largeList.addInTail(new Node(1));
    }

    @Before
    public void setUpOneElementList() {
        oneElementList = new LinkedList();
        oneElementList.addInTail(new Node(111));
    }
    @Before
    public void setUpEmptyList() {
        emptyList = new LinkedList();
    }

    public void setUpAllMockLists() {
        setUpEmptyList();
        setUpLargeList();
        setUpOneElementList();
    }

    @Test
    public void testAddInTail() {
        setUpAllMockLists();
        int value = 3;
        Node node = new Node(value);
        System.out.println();
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("========Try to add in tail this element: " + value + "========");
        System.out.println("Lists before: ");
        viewAllListsInTerminal();

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        emptyList.addInTail(node);
        largeList.addInTail(node);
        oneElementList.addInTail(node);

        System.out.println("Lists after: ");
        viewAllListsInTerminal();
    }

    @Test
    public void testFind() {
        setUpAllMockLists();
        int value = 3;
        Node node = new Node(value);
        System.out.println();
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("========Try to find this element: " + value + "========");
        System.out.println("Lists before: ");
        viewAllListsInTerminal();

        System.out.println("+++++++++++++++++++++FINDING++++++++++++++++++++++++");
        Node node1 = emptyList.find(value);
        Node node2 = largeList.find(value);
        Node node3 = oneElementList.find(value);

        System.out.println("Finding elements: " + node1 + " " +  node2 + " " +  node3);
    }

    @Test
    public void testFindAll() {
        setUpAllMockLists();
        int value = 1;
        Node node = new Node(value);
        System.out.println();
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("========Try to find ALL this elements: " + value + "========");
        System.out.println("Lists before: ");
        viewAllListsInTerminal();

        System.out.println("+++++++++++++++++++++FINDING ALL++++++++++++++++++++++++");
        ArrayList<Node> nodes1 = emptyList.findAll(value);
        ArrayList<Node> nodes2 = largeList.findAll(value);
        ArrayList<Node> nodes3 = oneElementList.findAll(value);

        System.out.println("Finding elements: " + nodes1 + " " +  nodes2 + " " +  nodes3);
    }

    @Test
    public void testRemove() {
        setUpAllMockLists();
        int value = 1;
        Node node = new Node(value);
        System.out.println();
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("========Try to delete first finding element: " + value + "========");
        System.out.println("Lists before: ");
        viewAllListsInTerminal();

        System.out.println("-------------------------------------------------------------------");
        boolean isRemoved1 = emptyList.remove(value);
        boolean isRemoved2 = largeList.remove(value);
        boolean isRemoved3 = oneElementList.remove(value);

        System.out.println("Deleting statuses: " + isRemoved1 + " " +  isRemoved2 + " " +  isRemoved3);
        System.out.println("Lists after: ");
        viewAllListsInTerminal();
    }

    @Test
    public void testRemoveAll() {
        setUpAllMockLists();
        int value = 1;
        Node node = new Node(value);
        System.out.println();
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("========Try to delete ALL finding elements: " + value + "========");
        System.out.println("Lists before: ");
        viewAllListsInTerminal();

        System.out.println("---------------------REMOVING ALL -------------------------------");
        emptyList.removeAll(value);
        largeList.removeAll(value);
        oneElementList.removeAll(value);

        System.out.println("List after: ");
        viewAllListsInTerminal();
    }

    @Test
    public void testClear() {
        setUpAllMockLists();
        System.out.println();
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("========Try to clear ALL elements========");
        System.out.println("Lists before: ");
        viewAllListsInTerminal();

        System.out.println("---------------------CLEARING ALL -------------------------------");
        emptyList.clear();
        largeList.clear();
        oneElementList.clear();

        System.out.println("List after: ");
        viewAllListsInTerminal();
    }

    @Test
    public void testCount() {
        setUpAllMockLists();
        System.out.println();
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("========Try to count ALL elements========");
        System.out.println("Lists before: ");
        viewAllListsInTerminal();
    }

    @Test
    public void testInsertAfter() {
        setUpAllMockLists();
        int value = 9999999;
        Node node = new Node(value);
        Node nodeAfter = new Node(1);
        System.out.println();
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("========Try to add after + " + nodeAfter.value + " this element: " + value + "========");
        System.out.println("Lists before: ");
        viewAllListsInTerminal();

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        emptyList.insertAfter(nodeAfter, node);
        largeList.insertAfter(nodeAfter, node);
        oneElementList.insertAfter(nodeAfter, node);

        System.out.println("Lists after: ");
        viewAllListsInTerminal();
    }

    public void viewListOnTerminal(LinkedList list) {
        System.out.println("======== Collection ========");
        iterateList(list);
        if (list == null) {
            System.out.println("[]");
        } else {
            System.out.println("Size: " + list.count());
        }
        System.out.println("=====================================");
    }

    public void viewAllListsInTerminal() {
        viewListOnTerminal(emptyList);
        viewListOnTerminal(largeList);
        viewListOnTerminal(oneElementList);
    }

    private static void iterateList(LinkedList list) {

        if (list == null) {
            System.out.println("[]");
        } else {
            LinkedList.ListIteratorI li = list.listIterator();
            while (li.hasNext()) {
                System.out.print(li.next() + " ");
            }
            System.out.println();
        }
    }
}