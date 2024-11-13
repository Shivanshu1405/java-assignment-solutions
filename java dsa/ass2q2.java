import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Node head;

    public LinkedList() {
        head = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public int countOccurrences(int key) {
        int count = 0;
        Node current = head;

        while (current != null) {
            if (current.data == key) {
                count++;
            }
            current = current.next;
        }

        return count;
    }

    public void deleteAllOccurrences(int key) {

        if (head == null) {
            return;
        }

        while (head != null && head.data == key) {
            head = head.next;
        }

        Node current = head;
        while (current != null && current.next != null) {
            if (current.next.data == key) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + (current.next != null ? "->" : ""));
            current = current.next;
        }
        System.out.println();
    }
}

public class ass2q2 {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        LinkedList list = new LinkedList();

        System.out.print("Enter the number of elements: ");
        int n = sn.nextInt();

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            list.insert(sn.nextInt());
        }

        System.out.print("Original Linked List: ");
        list.display();

        System.out.print("Enter the key to count and delete: ");
        int key = sn.nextInt();

        int count = list.countOccurrences(key);
        System.out.println("Number of occurrences of " + key + ": " + count);

        list.deleteAllOccurrences(key);

        System.out.print("Linked List after deleting all occurrences of " + key + ": ");
        list.display();
    }
}
