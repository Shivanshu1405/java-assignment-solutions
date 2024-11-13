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
        this.head = null;
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        System.out.println("\nInserted " + data + " at the beginning");
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            System.out.println("\nInserted " + data + " at the end");
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        System.out.println("\nInserted " + data + " at the end");
    }

    public void insertBeforeValue(int target, int data) {
        if (head == null) {
            System.out.println("\nList is empty");
            return;
        }

        if (head.data == target) {
            insertAtBeginning(data);
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != target) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("\nTarget value " + target + " not found");
            return;
        }

        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;
        System.out.println("\nInserted " + data + " before " + target);
    }

    public void insertAfterValue(int target, int data) {
        if (head == null) {
            System.out.println("\nList is empty");
            return;
        }

        Node current = head;
        while (current != null && current.data != target) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("\nTarget value " + target + " not found");
            return;
        }

        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;
        System.out.println("\nInserted " + data + " after " + target);
    }

    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("\nList is empty");
            return;
        }

        int deletedValue = head.data;
        head = head.next;
        System.out.println("\nDeleted " + deletedValue + " from beginning");
    }

    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("\nList is empty");
            return;
        }

        if (head.next == null) {
            int deletedValue = head.data;
            head = null;
            System.out.println("\nDeleted " + deletedValue + " from end");
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        int deletedValue = current.next.data;
        current.next = null;
        System.out.println("\nDeleted " + deletedValue + " from end");
    }

    public void deleteSpecificNode(int target) {
        if (head == null) {
            System.out.println("\nList is empty");
            return;
        }

        if (head.data == target) {
            deleteFromBeginning();
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != target) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("\nTarget value " + target + " not found");
            return;
        }

        current.next = current.next.next;
        System.out.println("\nDeleted node with value " + target);
    }

    public void searchNode(int target) {
        if (head == null) {
            System.out.println("\nList is empty");
            return;
        }

        int position = 1;
        Node current = head;
        while (current != null) {
            if (current.data == target) {
                System.out.println("\nNode " + target + " found at position " + position + " from head");
                return;
            }
            current = current.next;
            position++;
        }

        System.out.println("\nNode " + target + " not found in the list");
    }

    public void displayList() {
        if (head == null) {
            System.out.println("\nList is empty");
            return;
        }

        System.out.print("\nLinked List: ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data + (current.next != null ? " -> " : ""));
            current = current.next;
        }
        System.out.println();
    }
}

public class ass2q1 {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        LinkedList list = new LinkedList();
        boolean flag = true;
        while (flag) {
            System.out.println("1 Insert at beginning");
            System.out.println("2 Insert at end");
            System.out.println("3 Insert before a value");
            System.out.println("4 Insert after a value");
            System.out.println("5 Delete from beginning");
            System.out.println("6 Delete from end");
            System.out.println("7 Delete specific node");
            System.out.println("8 Search node");
            System.out.println("9 Display list");
            System.out.println("0 Exit");

            System.out.print("\nEnter choice: ");
            int choice = sn.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("\nExiting");
                    flag = false;
                    break;

                case 1:
                    System.out.print("Enter value to insert: ");
                    list.insertAtBeginning(sn.nextInt());
                    break;

                case 2:
                    System.out.print("Enter value to insert: ");
                    list.insertAtEnd(sn.nextInt());
                    break;

                case 3:
                    System.out.print("Enter target value: ");
                    int target = sn.nextInt();
                    System.out.print("Enter value to insert: ");
                    list.insertBeforeValue(target, sn.nextInt());
                    break;

                case 4:
                    System.out.print("Enter target value: ");
                    target = sn.nextInt();
                    System.out.print("Enter value to insert: ");
                    list.insertAfterValue(target, sn.nextInt());
                    break;

                case 5:
                    list.deleteFromBeginning();
                    break;

                case 6:
                    list.deleteFromEnd();
                    break;

                case 7:
                    System.out.print("Enter value to delete: ");
                    list.deleteSpecificNode(sn.nextInt());
                    break;

                case 8:
                    System.out.print("Enter value to search: ");
                    list.searchNode(sn.nextInt());
                    break;

                case 9:
                    list.displayList();
                    break;

                default:
                    System.out.println("\nInvalid choice");
            }
        }
    }
}