import ru.arg.skillsmart.algorithms.Stack;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StackTest extends TestCase {

    private Stack<Integer> stack;

    public void setUp() {
        stack = new Stack<>();
    }

    @Test
    public void testSize()
    {
        setUp();
        stack.push(1);
        assertEquals(1, stack.size());
        stack.push(2);
        stack.push(3);
        stack.push(4);
        assertEquals(4, stack.size());
        stack.pop();
        assertEquals(3, stack.size());
        stack.peek();
        assertEquals(3, stack.size());
    }

    @Test
    public void testPop() {
        setUp();
        assertNull(stack.pop());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.size());
        assertEquals(Integer.valueOf(3), stack.pop());
        assertEquals(2, stack.size());
        assertEquals(Integer.valueOf(2), stack.pop());
        assertEquals(1, stack.size());
        assertEquals(Integer.valueOf(1), stack.pop());
        assertNull(stack.peek());
        assertNull(stack.pop());
        assertEquals(0, stack.size());
    }

    @Test
    public void testPush() {
        setUp();
        assertEquals(0, stack.size());
        stack.push(1);
        assertEquals(1, stack.size());
        stack.push(2);
        assertEquals(2, stack.size());
        stack.push(3);
        assertEquals(3, stack.size());
    }

    @Test
    public void testPeek() {
        setUp();
        assertNull(stack.peek());
        stack.push(1);
        assertEquals(Integer.valueOf(1), stack.peek());
        assertEquals(1, stack.size());
        stack.push(2);
        assertEquals(Integer.valueOf(2), stack.peek());
        assertEquals(2, stack.size());
        stack.push(3);
        assertEquals(Integer.valueOf(3), stack.peek());
        assertEquals(3, stack.size());
        stack.pop();
        assertEquals(Integer.valueOf(2), stack.peek());
        assertEquals(2, stack.size());
    }
}