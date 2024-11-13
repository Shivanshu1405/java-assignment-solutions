import java.util.*;
public class ass1q5 {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        System.out.println("enter the size of the array");
        int n = sn.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("enter numbers sorted " + (i + 1));
            arr[i] = sn.nextInt();
        }
        System.out.println("enter the number to search");
        int num = sn.nextInt();
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(high+low)/2;
            if(arr[mid]==num){
                System.out.println("number found at position " + (mid + 1));
                break;
            }
            else if(arr[mid]>num){
                high=mid-1;
            }
            else if(arr[mid]<num)
                low=mid+1;
            else
            System.out.println("number not found");
        }
    }
}
