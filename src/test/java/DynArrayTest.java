import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;

@RunWith(JUnit4.class)
public class DynArrayTest extends TestCase {

    private DynArray<Integer> array;
    @Before
    public void setUp() {
        array = new DynArray<Integer>(Integer.class);
    }

    public void fillArray(int numberOfItems) {
        for (int i = 0; i < numberOfItems; i++) {
            array.append(i);
        }
    }

    //MAKE
    @Test
    public void testMakeArray() {
        setUp();
        fillArray(3);
        assertEquals(16, array.capacity);
        assertEquals(3, array.count);
        setUp();
        fillArray(17);
        assertEquals(32, array.capacity);
        assertEquals(17, array.count);
    }

    //GET
    @Test
    public void testGetItem() {
        setUp();
        fillArray(3);
        assertEquals(0, array.getItem(0).intValue());
        assertEquals(1, array.getItem(1).intValue());
        assertEquals(16, array.capacity);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetItemException() {
        setUp();
        fillArray(3);
        array.getItem(100000);
    }

    //APPEND
    @Test
    public void testAppend() {
        setUp();
        fillArray(3);
        assertEquals(16, array.capacity);
        assertEquals(3, array.count);
        fillArray(14);
        assertEquals(32, array.capacity);
        assertEquals(17, array.count);
    }

    //INSERT
    @Test
    public void testInsertInTail() {
        setUp();
        fillArray(3);
        array.insert(4, 3);
        assertEquals(Integer.valueOf(4), array.getItem(3));
        assertEquals(4, array.count);
        assertEquals(16, array.capacity);
    }

    @Test
    public void testInsertInTail2() {
        setUp();
        fillArray(16);
        array.insert(16, 16);
        assertEquals(Integer.valueOf(16), array.getItem(16));
        assertEquals(17, array.count);
        assertEquals(32, array.capacity);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertInTailExc() {
        setUp();
        fillArray(3);
        array.insert(100000, 4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertInTailExc2() {
        setUp();
        fillArray(3);
        array.insert(-1, -1);
    }

    @Test
    public void testInsertInTheStart() {
        setUp();
        fillArray(3);
        array.insert(999, 0);
        assertEquals(Integer.valueOf(999), array.getItem(0));
        assertEquals(4, array.count);
        assertEquals(16, array.capacity);
    }

    @Test
    public void testInsertInTheStart2() {
        setUp();
        fillArray(16);
        array.insert(999, 0);
        assertEquals(Integer.valueOf(999), array.getItem(0));
        assertEquals(17, array.count);
        assertEquals(32, array.capacity);
    }

    //REMOVE
    @Test
    public void testRemoveFromTail1() {
        setUp();
        fillArray(4);
        assertEquals(16, array.capacity);
        array.remove(3);
        assertEquals(Integer.valueOf(0), array.getItem(0));
        assertEquals(Integer.valueOf(1), array.getItem(1));
        assertEquals(Integer.valueOf(2), array.getItem(2));
        assertEquals(3, array.count);
        assertEquals(16, array.capacity);
    }

    @Test
    public void testRemoveFromTail2() {
        setUp();
        fillArray(16);
        assertEquals(16, array.capacity);
        array.remove(15);
        assertEquals(Integer.valueOf(0), array.getItem(0));
        assertEquals(Integer.valueOf(1), array.getItem(1));
        assertEquals(Integer.valueOf(14), array.getItem(14));
        assertEquals(15, array.count);
        assertEquals(16, array.capacity);
    }

    @Test
    public void testRemoveFromTail3() {
        setUp();
        fillArray(17);
        assertEquals(32, array.capacity);
        array.remove(16);
        assertEquals(Integer.valueOf(0), array.getItem(0));
        assertEquals(Integer.valueOf(15), array.getItem(15));
        assertEquals(Integer.valueOf(14), array.getItem(14));
        assertEquals(16, array.count);
        assertEquals(32, array.capacity);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveFromTailExc() {
        setUp();
        fillArray(3);
        array.remove(4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveFromTailExc2() {
        setUp();
        fillArray(3);
        array.remove(-1);
    }

    @Test
    public void testRemoveFromStart1() {
        setUp();
        fillArray(4);
        assertEquals(16, array.capacity);
        array.remove(0);
        assertEquals(Integer.valueOf(1), array.getItem(0));
        assertEquals(Integer.valueOf(2), array.getItem(1));
        assertEquals(Integer.valueOf(3), array.getItem(2));
        assertEquals(3, array.count);
        assertEquals(16, array.capacity);
    }

    @Test
    public void testRemoveFromStart2() {
        setUp();
        fillArray(16);
        assertEquals(16, array.capacity);
        array.remove(0);
        assertEquals(Integer.valueOf(1), array.getItem(0));
        assertEquals(Integer.valueOf(2), array.getItem(1));
        assertEquals(Integer.valueOf(15), array.getItem(14));
        assertEquals(15, array.count);
        assertEquals(16, array.capacity);
    }

    @Test
    public void testRemoveFromStart3() {
        setUp();
        fillArray(17);
        assertEquals(32, array.capacity);
        array.remove(0);
        assertEquals(Integer.valueOf(1), array.getItem(0));
        assertEquals(Integer.valueOf(2), array.getItem(1));
        assertEquals(Integer.valueOf(16), array.getItem(15));
        assertEquals(16, array.count);
        assertEquals(32, array.capacity);
    }

    @Test
    public void testRemoveFromStart4() {
        setUp();
        fillArray(33);
        assertEquals(64, array.capacity);
        array.remove(0);
        assertEquals(Integer.valueOf(1), array.getItem(0));
        assertEquals(Integer.valueOf(2), array.getItem(1));
        assertEquals(Integer.valueOf(33), array.getItem(32));
        assertEquals(32, array.count);
        assertEquals(64, array.capacity);

        array.remove(0);
        assertEquals(Integer.valueOf(2), array.getItem(0));
        assertEquals(Integer.valueOf(3), array.getItem(1));
        assertEquals(Integer.valueOf(33), array.getItem(31));
        assertEquals(31, array.count);
        assertEquals(42, array.capacity);
    }

    @Test
    public void testRemoveFromStart5() {
        setUp();
        fillArray(47);
        assertEquals(64, array.capacity);
        array.remove(0);
        assertEquals(Integer.valueOf(1), array.getItem(0));
        assertEquals(Integer.valueOf(2), array.getItem(1));
        assertEquals(Integer.valueOf(46), array.getItem(45));
        assertEquals(46, array.count);
        assertEquals(64, array.capacity);
    }
}