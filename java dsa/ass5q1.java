import java.util.*;

public class ass5q1 {
    static final int MAX_SIZE = 5;
    static int[] queue = new int[MAX_SIZE];
    static int front = -1;
    static int rear = -1;
    static Scanner sn = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = sn.nextInt();

            switch (choice) {
                case 1:
                    enqueue();
                    break;
                case 2:
                    dequeue();
                    break;
                case 3:
                    peek();
                    break;
                case 4:
                    displayQueue();
                    break;
                case 5:
                    System.out.println("Queue is empty: " + isEmpty());
                    break;
                case 6:
                    System.out.println("Queue is full: " + isFull());
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        } while (choice != 7);

    }

    static void displayMenu() {
        System.out.println("\nQueue Operations Menu:");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Peek");
        System.out.println("4. Display Queue");
        System.out.println("5. Check if Queue is Empty");
        System.out.println("6. Check if Queue is Full");
        System.out.println("7. Exit");
    }

    static void enqueue() {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }

        System.out.print("Enter element to enqueue: ");
        int element = sn.nextInt();

        if (front == -1) {
            front = 0;
        }
        rear = (rear + 1) % MAX_SIZE;
        queue[rear] = element;
        System.out.println("Enqueued element: " + element);
    }

    static void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return;
        }

        int dequeuedElement = queue[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % MAX_SIZE;
        }
        System.out.println("Dequeued element: " + dequeuedElement);
    }

    static void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return;
        }

        System.out.println("Front element: " + queue[front]);
    }

    static void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue elements: ");
        int i = front;
        do {
            System.out.print(queue[i] + " ");
            i = (i + 1) % MAX_SIZE;
        } while (i != (rear + 1) % MAX_SIZE);
        System.out.println();
    }

    static boolean isEmpty() {
        return front == -1;
    }

    static boolean isFull() {
        return (rear + 1) % MAX_SIZE == front;
    }
}
