package Arrays.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MajorityElements {
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
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<arr.length; i++) {
            int count=0;
            for (int j=0; j<arr.length; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }
            if (count > n/2 && ! list.contains(arr[i])) {
                list.add(arr[i]);
            }
        }
        System.out.println("1st method: ");
        System.out.println(list);
        // better approach
        ArrayList<Integer> ans = new ArrayList<>();
        int max=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            if (! map.containsKey(arr[i])) {
                map.put(arr[i],1);
            } else {
                map.put(arr[i], map.get(arr[i])+1);
                max = map.get(arr[i]);
                if (max > n/2) {
                    ans.add(arr[i]);
                }
            }
        }
        System.out.println();
        System.out.println("Second method: ");
        System.out.println(ans);
        // optimal approach
        // Moore's Algorithm
         int count = 0;
         int el = Integer.MIN_VALUE;
         for (int i = 0; i < arr.length; i++) {
             if (count == 0) {
                 count ++;
                 el = arr[i];
             } else if (arr[i] == el) {
                 count ++;
             } else {
                 count --;
             }
         }
         int actual = 0;
         for (int i = 0; i < arr.length; i++) {
             if(el == arr[i]) {
                 actual ++;
             }
         }
         if (actual >= n/2) {
             System.out.println("Element is: " + el);
         } else {
             System.out.println("Element not present.");
         }
    }
}
