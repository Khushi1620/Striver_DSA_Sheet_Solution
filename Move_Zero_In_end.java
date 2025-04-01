package Arrays;

import java.util.ArrayList;

public class Move_Zero_In_end {
    public static void main(String[] args) {
        int [] arr = {1,0,2,3,0,0,0,0,2,0,0,4,50,0,1};
        int [] arr1 = {1,0,2,3,0,0,0,0,2,0,0,4,50,0,1};
        int[] nums = {1,0,2,3,0,0,0,0,2,0,0,4,50,0,1};
        // brute force approach
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                list.add(nums[i]);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        for (int i = list.size(); i < nums.length; i++) {
            nums[i] = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        // better approach
        int start = 0;
        int end = arr.length-1;
        while (start < end) {
            while (start < end && arr[start] != 0) {
                start ++;
            }
            while (end > start && arr[end] == 0) {
                end --;
            }
            if (arr[start] == 0 && arr[end] != 0) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start ++;
                end --;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        // optimal approach
        int j = -1;
        for (int i = 0; i < arr1.length; i++) {
          if (arr1[i] == 0) {
              j = i;
              break;
          }
        }
        for (int i =  j+1; i < arr1.length; i++) {
            if (arr1[i] != 0) {
                int temp = arr1[j];
                arr1[j] = arr1[i];
                arr1[i] = temp;
                j++;
            }
        }
        System.out.println();
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
    }
}
