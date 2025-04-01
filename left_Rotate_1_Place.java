package Arrays;

public class left_Rotate_1_Place {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};

        // brute force using extra memory
        int [] ans = new int[arr.length];
        ans[ans.length-1] = arr[0];
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            ans[index] = arr[i];
            index ++;
        }
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();

        // better approach inplace
        int [] nums = {1,2,3,4,5};
        int temp = nums[0];
        for (int i = 0; i < nums.length-1; i++) {
            int tmep = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = tmep;
        }
        nums[nums.length-1] = temp;
        for (int i = 0; i < nums.length;i ++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        // best approach
        int[] num = {1,2,3,4,5};
        int k = 1;
        int start = 0;
        int end = k-1;
        while (start < end) {
            int temp1 = num[start];
            num[start] = num[end];
            num[end] = temp1;
            start ++;
            end --;
        }
        start = k;
        end = num.length-1;
        while (start < end) {
            int temp1 = num[start];
            num[start] = num[end];
            num[end] = temp1;
            start ++;
            end --;
        }
        start = 0;
        end = num.length-1;
        while (start < end) {
            int temp1 = num[start];
            num[start] = num[end];
            num[end] = temp1;
            start ++;
            end --;
        }
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
    }
}
