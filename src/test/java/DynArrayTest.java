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

    @Test
    public void testGetItem() {
        setUp();
        fillArray(3);
        assertEquals(1, array.getItem(0).intValue());
        assertEquals(2, array.getItem(1).intValue());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetItemException() {
        setUp();
        fillArray(3);
        array.getItem(100000);
    }

    @Test
    public void testAppend() {
    }

    @Test
    public void testInsert() {
    }

    @Test
    public void testRemove() {
    }
}