package ru.arg.skillsmart.bonustasks;

import ru.arg.skillsmart.algorithms.Stack;

public class PostfixExpression {

    public static int calculate(Stack<String> _expression) {
        Stack<Integer> buffer = new Stack<>();
        int finalResult = 0;
        int count = _expression.size();

        for (int i = 0; i < count; i++) {
            String param = _expression.pop();

            int tmpResult = 0;
            switch (param) {
                case "*" -> tmpResult = buffer.pop() * buffer.pop();
                case "+" -> tmpResult = buffer.pop() + buffer.pop();
                case "/" -> {
                    int denominator = buffer.pop();
                    int numerator = buffer.pop();
                    tmpResult = numerator / denominator;
                }
                case "=" -> finalResult = buffer.pop();
                default -> tmpResult = Integer.parseInt(param);
            }
            buffer.push(tmpResult);
        }
        return finalResult;
    }
}
