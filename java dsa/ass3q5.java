class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        next = null;
    }
}

class LinkedList {
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
    }
    
    public void makeCircular() {
        if (head == null) {
            return;
        }
        
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = head;
    }
    
    public boolean isCircular() {
        if (head == null) {
            return false;
        }
        
        Node slow = head;
        Node fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    
    public void display() {
        if (head == null) {
            return;
        }
        
        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != null && current != head);
        System.out.println();
    }
}

class ass3q5 {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.insert(1);
        list1.insert(2);
        list1.insert(3);
        list1.insert(4);
        
        System.out.print("List 1 (Linear): ");
        list1.display();
        System.out.println("Is Circular: " + list1.isCircular());
        
        LinkedList list2 = new LinkedList();
        list2.insert(1);
        list2.insert(2);
        list2.insert(3);
        list2.insert(4);
        list2.makeCircular();
        
        System.out.print("List 2 (Circular): ");
        list2.display();
        System.out.println("Is Circular: " + list2.isCircular());
    }
}
