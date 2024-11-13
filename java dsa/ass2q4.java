public class ass2q4 {
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }

    }
    Node head;
    ass2q4(){
        this.head=null;
    }
    public void append(int data){
        Node newNode = new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node current = head;
        while(current.next!=null){
            current=current.next;
        }
        current.next=newNode;
    }
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ass2q4 list = new ass2q4();
        
        list.append(80);
        list.append(81);
        list.append(82);
        list.append(83);
        list.append(84);
        
        System.out.print("Original List: ");
        list.display();
        
        list.reverse();
        
        System.out.print("Reversed List: ");
        list.display();
    }
}
