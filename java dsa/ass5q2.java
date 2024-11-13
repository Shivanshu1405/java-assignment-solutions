import java.util.*;

public class ass5q2 {
    static final int MAX_SIZE = 5;
    static int[] circularQueue = new int[MAX_SIZE];
    static int front = -1;
    static int rear = -1;
    static Scanner sn = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice (1-7): ");
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
                    display();
                    break;
                case 5:
                    System.out.println("Is Queue Empty? " + isEmpty());
                    break;
                case 6:
                    System.out.println("Is Queue Full? " + isFull());
                    break;
                case 7:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 7);

    }

    static void displayMenu() {
        System.out.println("\nCircular Queue Operations Menu:");
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
            System.out.println("Error: Queue is full! Cannot enqueue element.");
            return;
        }

        System.out.print("Enter the element to enqueue: ");
        int element = sn.nextInt();

        if (isEmpty()) {
            front = 0;
        }

        rear = (rear + 1) % MAX_SIZE;
        circularQueue[rear] = element;
        System.out.println("Successfully enqueued element: " + element);

        System.out.println("Current Queue State:");
        display();
    }

    static void dequeue() {
        if (isEmpty()) {
            System.out.println("Error: Queue is empty! Cannot dequeue element.");
            return;
        }

        int dequeuedElement = circularQueue[front];

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % MAX_SIZE;
        }

        System.out.println("Successfully dequeued element: " + dequeuedElement);

        System.out.println("Current Queue State:");
        display();
    }

    static void peek() {
        if (isEmpty()) {
            System.out.println("Error: Queue is empty! Nothing to peek.");
            return;
        }
        System.out.println("Front element is: " + circularQueue[front]);
    }

    static void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.print("Queue elements: ");

        if (rear >= front) {
            for (int i = front; i <= rear; i++) {
                System.out.print(circularQueue[i] + " ");
            }
        } else {
            for (int i = front; i < MAX_SIZE; i++) {
                System.out.print(circularQueue[i] + " ");
            }
            for (int i = 0; i <= rear; i++) {
                System.out.print(circularQueue[i] + " ");
            }
        }
        System.out.println("\nFront index: " + front + ", Rear index: " + rear);
    }

    static boolean isEmpty() {
        return front == -1;
    }

    static boolean isFull() {
        return (front == 0 && rear == MAX_SIZE - 1) || (front == rear + 1);
    }
}