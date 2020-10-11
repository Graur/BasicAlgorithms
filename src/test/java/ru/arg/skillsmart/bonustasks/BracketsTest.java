package ru.arg.skillsmart.bonustasks;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BracketsTest extends TestCase {

    private String firstRightCase = "(()((())()))";
    private String secondWrongCase = "(()()(()";
    private String thirdWrongCase = "())(";
    private String fourthWrongCase = "))((";
    private String fifthWrongCase = "((())";
    private String sixRightCase = "(())";
    private String seventhWrongCase = "(())))))";

    @Test
    public void testsAllRightCases() {
        assertTrue(Brackets.isBracketsBalanced(firstRightCase));
        assertTrue(Brackets.isBracketsBalanced(sixRightCase));
    }

    @Test
    public void testsAllWrongCases() {
        assertFalse(Brackets.isBracketsBalanced(secondWrongCase));
        assertFalse(Brackets.isBracketsBalanced(thirdWrongCase));
        assertFalse(Brackets.isBracketsBalanced(fourthWrongCase));
        assertFalse(Brackets.isBracketsBalanced(fifthWrongCase));
        assertFalse(Brackets.isBracketsBalanced(seventhWrongCase));
    }
}