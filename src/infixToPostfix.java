/*
Given a String input containing an infix expression. Return a String output containing the equivalent
postfix expression.
Infix expression: The expression of the form a op b. When an operator is in-between every pair of
operands.
Postfix expression: The expression of the form a b op. When an operator is followed for every pair of
operands.
Note: The order of precedence is: ^ greater than * equals to / greater than + equals to -. Ignore the right
associativity of ^.
Hint:
o If the scanned character is a ( , push it to the stack.
o If the scanned character is a ) , pop the stack and output it until a ( is encountered, and discard both
the parenthesis.
Constraints
• The	input	is	guaranteed	to	be	a	valid	expression.
 */
import java.util.Stack;
public class infixToPostfix {

    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);


            //.isLetterOrDigit from stack overflow
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // Discard '('
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return -1; // Unknown operator
        }
    }

    public static void main(String[] args) {
        String infix = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(infix));
    }

}
