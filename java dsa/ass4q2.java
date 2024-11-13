public class ass4q2 {
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
                System.out.println("Stack Underflow");
                return '\0';
            }
            return array[top--];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == capacity - 1;
        }
    }

    public static String reverseString(String input) {

        Stack stack = new Stack(input.length());

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        char[] reversed = new char[input.length()];

        for (int i = 0; i < input.length(); i++) {
            reversed[i] = stack.pop();
        }

        // Convert char array to string and return
        return new String(reversed);
    }

    public static void main(String[] args) {
        String input = "data structure";
        System.out.println("Original string: " + input);
        System.out.println("Reversed string: " + reverseString(input));
    }
}