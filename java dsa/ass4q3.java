public class ass4q3 {
    static class Stack {
        private char[] array;
        private int top;
        private int capacity;

        public Stack(int size) {
            array = new char[size];
            capacity = size;
            top = -1;
        }

        public void push(char x) {
            if (isFull()) {
                System.out.println("Stack Overflow");
                return;
            }
            array[++top] = x;
        }

        public char pop() {
            if (isEmpty()) {
                return '\0';
            }
            return array[top--];
        }

        public char peek() {
            if (isEmpty()) {
                return '\0';
            }
            return array[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == capacity - 1;
        }
    }

    public static boolean isBalanced(String expr) {
        Stack stack = new Stack(expr.length());

        for (int i = 0; i < expr.length(); i++) {
            char current = expr.charAt(i);

            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
                continue;
            }

            if (current == ')' || current == ']' || current == '}') {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.peek();
                if ((current == ')' && top == '(') ||
                        (current == ']' && top == '[') ||
                        (current == '}' && top == '{')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String[] expressions = {
                "()",
                "()[]{}",
                "({[]})",
                "(()",
                ")(",
                "{[})",
                "((()))",
                "{{}[][[]]}"
        };

        for (int i = 0; i < expressions.length; i++) {
            System.out.println("Expression: " + expressions[i]);
            if (isBalanced(expressions[i])) {
                System.out.println("Balanced");
            } else {
                System.out.println("Not Balanced");
            }
            System.out.println();
        }
    }
}