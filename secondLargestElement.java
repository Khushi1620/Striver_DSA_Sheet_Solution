package Arrays;
import java.util.Arrays;
public class secondLargestElement {
    public static void main(String[] args) {
        int [] arr = {1,4,5,7,9,5,3,6,2,9};

        // brute force complexity = O(n*log n);
        Arrays.sort(arr);
        int largest = arr[arr.length-1];
        int secondLarge = 0;
        for (int i = arr.length-2; i >= 0; i--) {
            if (arr[i] != largest) {
                secondLarge = arr[i];
                break;
            }
        }
        System.out.println(secondLarge);

        // better approach complexity = O(n):
        int ans = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > ans) {
                ans = arr[i];
                index = i;
            }
        }
        arr[index] = Integer.MIN_VALUE;
        int second = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > second && arr[i] != ans) {
                second = arr[i];
            }
        }
        System.out.println(second);
    }
}
