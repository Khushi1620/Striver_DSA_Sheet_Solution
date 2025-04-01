package Arrays;

import java.util.HashSet;

public class remove_Duplicate_From_Sorted_Array {
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,3,4,5,6,8,8,8,9,10};
        int[] nums = {0,0,1,1,1,2,2,3,3,3,4,5,6,8,8,8,9,10};
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        // brute force more memory usage complexity = O(3*n);
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int index = 0;
        for(var el: set) {
            arr[index] = el;
            index ++;
        }
        for (int i = index; i < arr.length; i++) {
            arr[i] = 0;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // better approach complexity = O(n) inplace algorithm constant space
        int start = 0;
        int end = start + 1;
        while (end < nums.length) {
            while(end < nums.length && nums[end] == nums[start]) {
                end ++;
            }
            if (nums[end] != nums[start]) {
                start ++;
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                end ++;
            }
        }
        for (int i = start+1; i < nums.length; i++) {
            nums[i] = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
