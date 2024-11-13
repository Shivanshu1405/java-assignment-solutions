class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class ass3q4 {
    static class DoublyLinkedList {
        Node head;

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
            newNode.prev = current;
        }

        public int getSize() {
            int count = 0;
            Node current = head;

            while (current != null) {
                count++;
                current = current.next;
            }

            return count;
        }
    }

    static class CircularLinkedList {
        Node head;

        public void insert(int data) {
            Node newNode = new Node(data);

            if (head == null) {
                head = newNode;
                newNode.next = head;
                return;
            }

            Node current = head;
            while (current.next != head) {
                current = current.next;
            }

            current.next = newNode;
            newNode.next = head;
        }

        public int getSize() {
            if (head == null) {
                return 0;
            }

            int count = 1;
            Node current = head.next;

            while (current != head) {
                count++;
                current = current.next;
            }

            return count;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insert(1);
        dll.insert(2);
        dll.insert(3);
        dll.insert(4);
        System.out.println("Size of Doubly Linked List: " + dll.getSize());

        CircularLinkedList cll = new CircularLinkedList();
        cll.insert(1);
        cll.insert(2);
        cll.insert(3);
        cll.insert(4);
        System.out.println("Size of Circular Linked List: " + cll.getSize());
    }
}