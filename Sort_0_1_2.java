package Arrays.Medium;

import java.util.Scanner;

public class Sort_0_1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // brute force approach
        //Arrays.sort(arr);
        // better approach
        int[] ans = new int[n];
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count0++;
            } else if (arr[i] == 1) {
                count1++;
            } else {
                count2++;
            }
        }
        int index = 0;
        while (count0 > 0) {
            ans[index++] = 0;
            count0--;
        }
        while (count1 > 0) {
            ans[index++] = 1;
            count1 --;
        }
        while (count2 > 0) {
            ans[index++] = 2;
            count2 --;
        }
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        // optimal approach
        // DUTCH NATIONAL FLAG ALGORITHM
        // arr[mid] == 0 {swap(arr[mid], arr[low]); mid++ low++}
        // arr[mid] == 1 {mid++}
        // arr[mid] == 2 {swap(arr[mid], arr[high]); high--; if mid == 0 step 1}
        int low = 0;
        int mid = 0;
        int high = arr.length-1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                low ++;
                mid ++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high --;
            }
        }
        System.out.println();
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
