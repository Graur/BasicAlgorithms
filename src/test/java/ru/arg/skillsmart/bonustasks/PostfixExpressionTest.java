package ru.arg.skillsmart.bonustasks;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.arg.skillsmart.algorithms.Stack;

import java.util.Arrays;

@RunWith(JUnit4.class)
public class PostfixExpressionTest extends TestCase {

    private String firstTestCase = "1 2 + 3 * =";
    private Stack<String> firstCaseStack;
    private String secondTestCase = "8 2 + 5 * 9 + =";
    private Stack<String> secondCaseStack;
    private String thirdTestCase = "1 7 * 5 + 2 / =";
    private Stack<String> thirdCaseStack;

    @Before
    public void setUp() throws Exception {
        firstCaseStack = mapStringToStack(firstTestCase);
        secondCaseStack = mapStringToStack(secondTestCase);
        thirdCaseStack = mapStringToStack(thirdTestCase);
    }

    private Stack<String> mapStringToStack(String _expr) {
        Stack<String> stack = new Stack<>();
        String reversed = new StringBuilder(_expr).reverse().toString();
        String[] params = reversed.split(" ");
        Arrays.stream(params).forEach(stack::push);
        return stack;
    }

    @Test
    public void testFirstCase() {
        int actualResult = PostfixExpression.calculate(firstCaseStack);
        assertEquals(9, actualResult);
    }

    @Test
    public void testSecondCase() {
        int actualResult = PostfixExpression.calculate(secondCaseStack);
        assertEquals(59, actualResult);
    }

    @Test
    public void testThirdCase() {
        int actualResult = PostfixExpression.calculate(thirdCaseStack);
        assertEquals(6, actualResult);
    }
}