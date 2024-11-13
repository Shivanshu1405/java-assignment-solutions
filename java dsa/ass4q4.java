public class ass4q4 {
    public static String infixToPostfix(String infixExpression) {
        char[] stack = new char[infixExpression.length()];
        int stackSize = 0;
        char[] postfix = new char[infixExpression.length()];
        int postfixIndex = 0;

        for (int i = 0; i < infixExpression.length(); i++) {
            char c = infixExpression.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                postfix[postfixIndex++] = c;
            } else if (c == '(') {
                stack[stackSize++] = c;
            } else if (c == ')') {
                while (stackSize > 0 && stack[stackSize - 1] != '(') {
                    postfix[postfixIndex++] = stack[--stackSize];
                }
                if (stackSize > 0 && stack[stackSize - 1] == '(') {
                    stackSize--;
                }
            } else {
                while (stackSize > 0 && precedence(c) <= precedence(stack[stackSize - 1])) {
                    postfix[postfixIndex++] = stack[--stackSize];
                }
                stack[stackSize++] = c;
            }
        }

        while (stackSize > 0) {
            postfix[postfixIndex++] = stack[--stackSize];
        }

        return new String(postfix);
    }

    private static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        String infixExpression = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Postfix Expression: " + infixToPostfix(infixExpression));
    }
}