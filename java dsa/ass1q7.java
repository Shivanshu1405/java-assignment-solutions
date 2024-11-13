import java.util.Scanner;
public class ass1q7 {
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
        System.out.println("enter element to search");
        int num = sn.nextInt();
        for(int i=0;i<n;i++){
            if(arr[i]==num){
                System.out.println("number found at position " + (i + 1));
                break;
            }
            else
                System.out.println("number not found");
        }
    }
}
