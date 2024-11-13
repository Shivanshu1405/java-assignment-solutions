import java.util.*;

class Stack {
    private int top;
    private int maxSize;
    private int[] stackArray;

    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push element.");
            return;
        }
        stackArray[++top] = value;
        System.out.println(value + " pushed to stack");
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop element.");
            return;
        }
        int value = stackArray[top--];
        System.out.println(value + " popped from stack");
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No element to peek.");
            return;
        }
        System.out.println("Top element is: " + stackArray[top]);
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Stack elements:");
        for (int i = top; i >= 0; i--) {
            System.out.println(stackArray[i]);
        }
    }
}

class ass4q1 {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);

        System.out.print("Enter the size of stack: ");
        int size = sn.nextInt();

        Stack stack = new Stack(size);

        while (true) {
            System.out.println("\nStack Operations:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Check if Empty");
            System.out.println("5. Check if Full");
            System.out.println("6. Display");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = sn.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int value = sn.nextInt();
                    stack.push(value);
                    break;

                case 2:
                    stack.pop();
                    break;

                case 3:
                    stack.peek();
                    break;

                case 4:
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty");
                    } else {
                        System.out.println("Stack is not empty");
                    }
                    break;

                case 5:
                    if (stack.isFull()) {
                        System.out.println("Stack is full");
                    } else {
                        System.out.println("Stack is not full");
                    }
                    break;

                case 6:
                    stack.display();
                    break;

                case 7:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}