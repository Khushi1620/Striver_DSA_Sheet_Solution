package Arrays.Easy;

import java.util.Scanner;

public class maxConsecutiveOnes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int count = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                count = 0;
            } else {
                count++;
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }
}
