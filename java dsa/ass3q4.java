class Node {
    char data;
    Node prev;
    Node next;
    
    public Node(char data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;
    
    public void insert(char data) {
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
    
    public boolean isPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        
        Node start = head;
        Node end = head;
        
        while (end.next != null) {
            end = end.next;
        }
        
        while (start != end && start.prev != end) {
            if (start.data != end.data) {
                return false;
            }
            start = start.next;
            end = end.prev;
        }
        return true;
    }
    
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class ass3q4 {
    public static void main(String[] args) {
        DoublyLinkedList list1 = new DoublyLinkedList();
        String str1 = "racecar";
        for(char c : str1.toCharArray()) {
            list1.insert(c);
        }
        
        System.out.print("List 1: ");
        list1.display();
        System.out.println("Is Palindrome: " + list1.isPalindrome());
        
        DoublyLinkedList list2 = new DoublyLinkedList();
        String str2 = "hello";
        for(char c : str2.toCharArray()) {
            list2.insert(c);
        }
        
        System.out.print("List 2: ");
        list2.display();
        System.out.println("Is Palindrome: " + list2.isPalindrome());
    }
}