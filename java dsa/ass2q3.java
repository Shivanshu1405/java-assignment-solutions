class ass2q3 {
    class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    Node head;
    
    public void add(int data) {
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
    
    public Node findMiddle() {
        if (head == null) {
            return null;
        }
        
        Node slowPtr = head;
        Node fastPtr = head;
        
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        
        return slowPtr;
    }
    
    public static void main(String[] args) {
        ass2q3 list = new ass2q3();
        int var=9;
        
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        
        Node middle = list.findMiddle();
        System.out.println("Middle node value: " + middle.data);
        
        list.add(var);
        middle = list.findMiddle();
        System.out.println("Middle node value after adding "+ var+": " + middle.data);
    }
}