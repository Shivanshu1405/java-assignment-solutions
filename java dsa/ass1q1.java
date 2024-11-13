import java.util.*;

public class ass1q1 {
    public int arr[];
    public int n;
    public static Scanner sn = new Scanner(System.in);

    public ass1q1() {
        n = 0;
        arr = new int[n];
    }

    public void create() {
        System.out.println("enter the size of the array");
        n = sn.nextInt();
        arr = new int[n + 10];
        for (int i = 0; i < n; i++) {
            System.out.println("enter element " + (i + 1));
            arr[i] = sn.nextInt();
        }
    }

    public void display() {
        System.out.println("Array elements are:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }

    public void insert() {
        int pos, ele;
        System.out.println("enter the position to insert");
        pos = sn.nextInt();
        System.out.println("enter the element to insert");
        ele = sn.nextInt();
        for (int i = n - 1; i >= pos - 1; i--) {
            arr[i + 1] = arr[i];
        }
        arr[pos - 1] = ele;
        n++;
    }

    public void delete() {
        int pos;
        System.out.println("enter the position to delete");
        pos = sn.nextInt();
        for (int i = pos - 1; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        n--;
    }

    public void search() {
        int ele;
        System.out.println("enter the element to search");
        ele = sn.nextInt();
        for (int i = 0; i < n; i++) {
            if (arr[i] == ele) {
                System.out.println("element found at position " + (i + 1));
                return;
            }
        }
        System.out.println("element not found");
    }

    public static void main(String[] args) {
        int choice;
        ass1q1 obj = new ass1q1();
        do {
            System.out.println(
                    "MENU\n1. CREATE\t" + "2. DISPLAY\n" + "3. INSERT\t" + "4. DELETE\n" + "5. SEARCH\t" + "6. EXIT\n");
            System.out.print("enter choice: ");
            choice = sn.nextInt();
            switch (choice) {
                case 1:
                    obj.create();
                    break;
                case 2:
                    obj.display();
                    break;
                case 3:
                    obj.insert();
                    System.out.println("INSERTED");
                    break;
                case 4:
                    obj.delete();
                    System.out.println("DELETED");
                    break;
                case 5:
                    obj.search();
                    break;
                case 6:
                    System.out.println("EXIT");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 6);

    }
}
