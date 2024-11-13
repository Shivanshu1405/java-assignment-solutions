import java.util.*;

public class ass5q3 {
     static final int MAX_SIZE = 20;
     static int[] queue = new int[MAX_SIZE];
     static int front = -1;
     static int rear = -1;
     static Scanner sn = new Scanner(System.in);
    
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nQueue Interleaving Menu:");
            System.out.println("1. Add element to queue");
            System.out.println("2. Display queue");
            System.out.println("3. Interleave queue");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            choice = sn.nextInt();
            
            switch (choice) {
                case 1:
                    enqueue();
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    interleaveQueue();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);
        

    }
    
     static void enqueue() {
        if (rear == MAX_SIZE - 1) {
            System.out.println("Queue is full!");
            return;
        }
        
        System.out.print("Enter element: ");
        int element = sn.nextInt();
        
        if (front == -1) {
            front = 0;
        }
        
        rear++;
        queue[rear] = element;
        System.out.println("Element added successfully");
        display();
    }
    
     static void display() {
        if (front == -1) {
            System.out.println("Queue is empty!");
            return;
        }
        
        System.out.print("Queue elements: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
    
     static void interleaveQueue() {
        if (front == -1 || rear - front + 1 <= 1) {
            System.out.println("Queue needs at least 2 elements to interleave!");
            return;
        }
        
        int size = rear - front + 1;
        if (size % 2 != 0) {
            System.out.println("Queue should have even number of elements for interleaving!");
            return;
        }
        
        int halfSize = size / 2;
        int[] temp = new int[halfSize];
        
        // Store first half in temporary array
        for (int i = 0; i < halfSize; i++) {
            temp[i] = queue[front + i];
        }
        
        // Move second half elements to first half
        for (int i = 0; i < halfSize; i++) {
            queue[front + i] = queue[front + halfSize + i];
        }
        
        // Interleave elements from temp array
        for (int i = 0; i < halfSize; i++) {
            // Shift elements to make space
            for (int j = rear; j > front + 2 * i + 1; j--) {
                queue[j] = queue[j - 1];
            }
            // Insert element from temp array
            queue[front + 2 * i + 1] = temp[i];
        }
        
        System.out.println("Queue interleaved successfully!");
        display();
    }
}