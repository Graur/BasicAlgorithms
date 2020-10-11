package ru.arg.skillsmart.bonustasks;

import ru.arg.skillsmart.algorithms.Stack;

public class Brackets {
    public static boolean isBracketsBalanced(String _brackets) {
        Stack<Character> stack = new Stack<>();
        char[] chars = _brackets.toCharArray();

        if (chars[0] == ')') {
            return false;
        }

        for(char ch : chars ) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.pop() == null) {
                    return false;
                }
            }
        }

        return stack.size() == 0;
    }
}
