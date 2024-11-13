import java.util.Scanner;
public class ass1q2 {
    public static void duplicate(int arr[], int n, int pos){
        for (int i = pos; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }
    public static void main(String[] args) {
        int n;
        Scanner sn = new Scanner(System.in);
        System.out.println("enter the size of the array");
        n = sn.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("enter element " + (i + 1));
            arr[i] = sn.nextInt();
        }
        System.out.println("Deleting duplicates...");

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    duplicate(arr, n, j);
                    n--;
                    j--;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
