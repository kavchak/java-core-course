package javaCourse.homework.lesson17.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class MathChallenge {
    public static final char PLUS = '+';
    public static final char MINUS = '-';
    public static final char MULTIPLY = '*';
    public static final char DIVIDE = '/';
    public static final char LEFT_PAREN = '(';
    public static final char RIGHT_PAREN = ')';

    private static final Set<Character> OPERATORS = Set.of(PLUS, MINUS, MULTIPLY, DIVIDE);

    public static final String DIGIT_REGEX = "\\d+";


    public static void main(String[] args) {
        System.out.println(calcString("6*(4/2)+3*1")); // 15
        System.out.println(calcString("6/3-1"));       // 1
        System.out.println(calcString("2+(3-1)*3"));   // 8
        System.out.println(calcString("(2-0)(6/2)"));  // 6
    }

    public static int calcString(String strExpr) {
        strExpr = normalizeStringExpression(strExpr);
        List<String> mathExpr = convertToMathExpr(strExpr);
        return calculate(mathExpr);
    }

    private static String normalizeStringExpression(String strExpr) {
        StringBuilder result = new StringBuilder();
        char prev = 0;
        for (int i = 0; i < strExpr.length(); i++) {
            char current = strExpr.charAt(i);
            if (i > 0 && (
                    (Character.isDigit(prev) && current == LEFT_PAREN) ||
                            (prev == RIGHT_PAREN && Character.isDigit(current)) ||
                            (prev == RIGHT_PAREN && current == LEFT_PAREN)
            )) {
                result.append(MULTIPLY);
            }
            result.append(current);
            prev = current;
        }
        return result.toString();
    }

    private static List<String> convertToMathExpr(String strExpr) {
        List<String> output = new ArrayList<>();
        Stack<Character> operators = new Stack<>();
        StringBuilder number = new StringBuilder();

        for (int i = 0; i < strExpr.length(); i++) {
            char currentChar = strExpr.charAt(i);

            if (Character.isDigit(currentChar)) {
                number.append(currentChar);
            } else {
                if (!number.isEmpty()) {
                    output.add(number.toString());
                    number.setLength(0);
                }

                if (currentChar == LEFT_PAREN) {
                    operators.push(currentChar);
                } else if (currentChar == RIGHT_PAREN) {
                    while (!operators.isEmpty() && operators.peek() != LEFT_PAREN) {
                        output.add(String.valueOf(operators.pop()));
                    }
                    operators.pop();
                } else if (isOperator(currentChar)) {
                    while (!operators.isEmpty() && hasHigherOrEqualPriority(operators.peek(), currentChar)) {
                        output.add(String.valueOf(operators.pop()));
                    }
                    operators.push(currentChar);
                }
            }
        }

        if (!number.isEmpty()) {
            output.add(number.toString());
        }

        while (!operators.isEmpty()) {
            output.add(String.valueOf(operators.pop()));
        }

        return output;
    }

    private static boolean isOperator(char character) {
        return OPERATORS.contains(character);
    }

    private static boolean hasHigherOrEqualPriority(char operator1, char operator2) {
        return getOperatorPriority(operator1) >= getOperatorPriority(operator2);
    }


    private static int getOperatorPriority(char operator) {
        switch (operator) {
            case PLUS: case MINUS: return 1;
            case MULTIPLY: case DIVIDE: return 2;
        }
        return 0;
    }

    private static int calculate(List<String> mathExpr) {
        Stack<Integer> stack = new Stack<>();

        for (String item : mathExpr) {
            if (item.matches(DIGIT_REGEX)) {
                stack.push(Integer.parseInt(item));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                switch (item.charAt(0)) {
                    case PLUS: stack.push(a + b); break;
                    case MINUS: stack.push(a - b); break;
                    case MULTIPLY: stack.push(a * b); break;
                    case DIVIDE: stack.push(a / b); break;
                }
            }
        }

        int result = stack.pop();
        if (!stack.isEmpty()) {
            throw new IllegalStateException("Invalid expression");
        }

        return result;
    }
}
