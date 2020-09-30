import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

@RunWith(JUnit4.class)
public class SumOfListsTest extends TestCase {

    private static final int TEST_ITERATE_NUMBER = 100;

    private SumOfLists sumOfLists;

    private LinkedList largeList1;

    private LinkedList largeList2;

    private LinkedList oneElementList1;

    private LinkedList oneElementList2;

    private LinkedList emptyList1;

    private LinkedList emptyList2;

    @Before
    public void setUp() throws Exception {
        sumOfLists = new SumOfLists();
        largeList1 = new LinkedList();

        for (int i = 0; i < TEST_ITERATE_NUMBER; i++) {
            largeList1.addInTail(new Node(new Random().nextInt()));
        }

        largeList2 = new LinkedList();

        for (int i = 0; i < TEST_ITERATE_NUMBER; i++) {
            largeList2.addInTail(new Node(new Random().nextInt()));
        }

        oneElementList1 = new LinkedList();
        oneElementList1.addInTail(new Node(1111111));
        oneElementList2 = new LinkedList();
        oneElementList2.addInTail(new Node(1111111));

        emptyList1 = new LinkedList();
        emptyList2 = new LinkedList();
    }

    @Test
    public void testSumOfNonEqualsLists() {
        System.out.println("========Amount of non equals lists========");
        largeList1.addInTail(new Node(9999999));
        ArrayList<Integer> arrayList = sumOfLists.sumOfEqualsLists(largeList1, largeList2);
        System.out.println(Collections.singletonList(arrayList));
        System.out.println("================================================");

        System.out.println("========Amount of non equals lists========");
        emptyList1.addInTail(new Node(9999999));
        ArrayList<Integer> arrayList2 = sumOfLists.sumOfEqualsLists(emptyList1, emptyList2);
        System.out.println(Collections.singletonList(arrayList2));
        System.out.println("================================================");

        System.out.println("========Amount of non equals lists========");
        oneElementList1.addInTail(new Node(9999999));
        ArrayList<Integer> arrayList3 = sumOfLists.sumOfEqualsLists(oneElementList1, oneElementList2);
        System.out.println(Collections.singletonList(arrayList3));
        System.out.println("================================================");
    }

    @Test
    public void testSumOfEqualsLists() {
        System.out.println("========Amount of equals lists========");
        ArrayList<Integer> arrayList = sumOfLists.sumOfEqualsLists(largeList1, largeList2);
        System.out.println(Collections.singletonList(arrayList));
        System.out.println("================================================");

        System.out.println("========Amount of equals lists========");
        ArrayList<Integer> arrayList2 = sumOfLists.sumOfEqualsLists(emptyList1, emptyList2);
        System.out.println(Collections.singletonList(arrayList2));
        System.out.println("================================================");

        System.out.println("========Amount of equals lists========");
        ArrayList<Integer> arrayList3 = sumOfLists.sumOfEqualsLists(oneElementList1, oneElementList2);
        System.out.println(Collections.singletonList(arrayList3));
        System.out.println("================================================");
    }
}