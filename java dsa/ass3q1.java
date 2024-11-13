import java.util.*;

class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class CircularLinkedList {
    private Node head;

    public CircularLinkedList() {
        head = null;
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newNode.next = head;
            temp.next = newNode;
            head = newNode;
        }
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    public void insertAfter(int key, int data) {
        if (head == null) {
            return;
        }
        Node temp = head;
        do {
            if (temp.data == key) {
                Node newNode = new Node(data);
                newNode.next = temp.next;
                temp.next = newNode;
                return;
            }
            temp = temp.next;
        } while (temp != head);
    }

    public void insertBefore(int key, int data) {
        if (head == null) {
            return;
        }
        if (head.data == key) {
            insertAtBeginning(data);
            return;
        }
        Node temp = head;
        do {
            if (temp.next.data == key) {
                Node newNode = new Node(data);
                newNode.next = temp.next;
                temp.next = newNode;
                return;
            }
            temp = temp.next;
        } while (temp.next != head);
    }

    public void deleteNode(int key) {
        if (head == null) {
            return;
        }

        if (head.data == key) {
            if (head.next == head) {
                head = null;
            } else {
                Node temp = head;
                while (temp.next != head) {
                    temp = temp.next;
                }
                temp.next = head.next;
                head = head.next;
            }
            return;
        }

        Node current = head;
        while (current.next != head) {
            if (current.next.data == key) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public boolean search(int key) {
        if (head == null) {
            return false;
        }
        Node temp = head;
        do {
            if (temp.data == key) {
                return true;
            }
            temp = temp.next;
        } while (temp != head);
        return false;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println(" (back to head)");
    }
}

class DoublyLinkedList {
    private Node head;

    public DoublyLinkedList() {
        head = null;
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    public void insertAfter(int key, int data) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node current = head;
        while (current != null) {
            if (current.data == key) {
                Node newNode = new Node(data);
                newNode.next = current.next;
                newNode.prev = current;
                if (current.next != null) {
                    current.next.prev = newNode;
                }
                current.next = newNode;
                return;
            }
            current = current.next;
        }
        System.out.println("Node " + key + " not found!");
    }

    public void insertBefore(int key, int data) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        if (head.data == key) {
            insertAtBeginning(data);
            return;
        }

        Node current = head;
        while (current != null) {
            if (current.data == key) {
                Node newNode = new Node(data);
                newNode.next = current;
                newNode.prev = current.prev;
                current.prev.next = newNode;
                current.prev = newNode;
                return;
            }
            current = current.next;
        }
        System.out.println("Node " + key + " not found!");
    }

    public void deleteNode(int key) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        if (head.data == key) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }

        Node current = head;
        while (current != null && current.data != key) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node " + key + " not found!");
            return;
        }

        if (current.next == null) {
            current.prev.next = null;
            return;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;
    }

    public boolean search(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class ass3q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CircularLinkedList clist = new CircularLinkedList();
        DoublyLinkedList dlist = new DoublyLinkedList();

        while (true) {
            System.out.println("\nLinked List Operations Menu:");
            System.out.println("1. Circular Linked List");
            System.out.println("2. Doubly Linked List");
            System.out.println("3. Exit");

            System.out.print("Enter your choice (1-3): ");
            int choice = scanner.nextInt();

            if (choice == 3) {
                break;
            }

            if (choice == 1 || choice == 2) {
                String listType;
                if (choice == 1) {
                    listType = "Circular";
                } else {
                    listType = "Doubly";
                }

                while (true) {
                    System.out.println("\n" + listType + " Linked List Operations:");
                    System.out.println("1. Insert at beginning");
                    System.out.println("2. Insert at end");
                    System.out.println("3. Insert after a node");
                    System.out.println("4. Insert before a node");
                    System.out.println("5. Delete a node");
                    System.out.println("6. Search for a node");
                    System.out.println("7. Display list");
                    System.out.println("8. Back to main menu");

                    System.out.print("Enter your choice (1-8): ");
                    int op = scanner.nextInt();

                    if (op == 8) {
                        break;
                    }

                    switch (op) {
                        case 1:
                            System.out.print("Enter data to insert: ");
                            int data = scanner.nextInt();
                            if (choice == 1) {
                                clist.insertAtBeginning(data);
                            } else {
                                dlist.insertAtBeginning(data);
                            }
                            break;

                        case 2:
                            System.out.print("Enter data to insert: ");
                            data = scanner.nextInt();
                            if (choice == 1) {
                                clist.insertAtEnd(data);
                            } else {
                                dlist.insertAtEnd(data);
                            }
                            break;

                        case 3:
                            System.out.print("Enter the node value after which to insert: ");
                            int key = scanner.nextInt();
                            System.out.print("Enter data to insert: ");
                            data = scanner.nextInt();
                            if (choice == 1) {
                                clist.insertAfter(key, data);
                            } else {
                                dlist.insertAfter(key, data);
                            }
                            break;

                        case 4:
                            System.out.print("Enter the node value before which to insert: ");
                            key = scanner.nextInt();
                            System.out.print("Enter data to insert: ");
                            data = scanner.nextInt();
                            if (choice == 1) {
                                clist.insertBefore(key, data);
                            } else {
                                dlist.insertBefore(key, data);
                            }
                            break;

                        case 5:
                            System.out.print("Enter the node value to delete: ");
                            key = scanner.nextInt();
                            if (choice == 1) {
                                clist.deleteNode(key);
                            } else {
                                dlist.deleteNode(key);
                            }
                            break;

                        case 6:
                            System.out.print("Enter the node value to search: ");
                            key = scanner.nextInt();
                            boolean found = (choice == 1) ? clist.search(key) : dlist.search(key);
                            if (found) {
                                System.out.println("Node " + key + " found in the list");
                            } else {
                                System.out.println("Node " + key + " not found in the list");
                            }
                            break;

                        case 7:
                            if (choice == 1) {
                                clist.display();
                            } else {
                                dlist.display();
                            }
                            break;

                        default:
                            System.out.println("Invalid choice! Please try again.");
                    }
                    System.out.println("\nOperation completed!");
                }
            }
        }
    }
}
