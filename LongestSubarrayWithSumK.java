package Arrays.Easy;

import java.util.HashMap;
import java.util.Scanner;

public class LongestSubarrayWithSumK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements in the array: ");
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter value of k: ");
        int k = sc.nextInt();

        // brute force approach O(n*n*n)
        int max1=Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                int sum1 = 0;
                for (int l=i; l<=j; l++) {
                    sum1 += arr[l];
                    if (sum1 > k) {
                        break;
                    }
                }
                if (sum1 == k) {
                    max1 = Math.max(max1, j-i+1);
                }
            }
        }
        System.out.println("Brute force approach: ");
        System.out.println(max1);
        // better approach
        int max2=Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            int sum2 = 0;
            for (int j=i; j<n; j++) {
                sum2 += arr[j];
                if (sum2 > k) {
                    break;
                }
                if (sum2 == k) {
                    max2 = Math.max(max2, j-i+1);
                }
            }
        }
        System.out.println("Better approach: ");
        System.out.println(max2);
        // optimal approach O(n)
        int l = 0;
        int r = 0;
        int max3 = 0;
        int sum3 = 0;
        while(r < arr.length) {
            sum3 += arr[r];
            while (sum3 > k) {
                sum3 -= arr[l];
                l++;
            }
            if (sum3 == k) {
                max3 = Math.max(max3, r-l+1);
            }
            r++;
        }
        System.out.println("Optimal approach: ");
        System.out.println(max3);
        // optimized version 2
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1]+arr[i];
        }
        int max4 = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        for (int i = 0; i < prefix.length; i++) {
            if (! map.containsKey(prefix[i]))
            map.put(prefix[i], i);
            if (map.containsKey(prefix[i]-k)) {
                max4 = Math.max(max4, i-map.get(prefix[i]-k));
            }
        }
        System.out.println("Optimized approach2: ");
        System.out.println(max4);
    }
}
