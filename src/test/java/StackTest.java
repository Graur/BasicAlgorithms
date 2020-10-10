import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.*;

@RunWith(JUnit4.class)
public class StackTest extends TestCase {

    public void setUp() throws Exception {
    }

    @Test
    public void testSize()
    {
        Stack<Object> stack = new Stack<>();
        stack.push(1);
        stack.push("2");
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        assertEquals(String.class, stack.pop().getClass());
//        assertEquals(Integer.class, stack.pop().getClass());
        System.out.println(stack.pop().getClass());
        System.out.println(stack.pop().getClass());
    }

    public void testPop() {
    }

    public void testPush() {
    }

    public void testPeek() {
    }
}