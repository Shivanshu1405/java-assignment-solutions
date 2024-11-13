public class ass4q5 {
    public static int postfix(String expression) {
        int[] stack = new int[expression.length()];
        int stackSize = 0;

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                stack[stackSize++] = c - '0';
            } else {
                int operand2 = stack[--stackSize];
                int operand1 = stack[--stackSize];
                int result = operation(c, operand1, operand2);
                stack[stackSize++] = result;
            }
        }

        return stack[--stackSize];
    }

    private static int operation(char operator, int operand1, int operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            default:
                System.out.println("Invalid operator");
                return 0;
        }
    }

    public static void main(String[] args) {
        String expression = "231*+9-";
        System.out.println("Postfix Expression: " + expression);
        System.out.println("Result: " + postfix(expression));
    }
}