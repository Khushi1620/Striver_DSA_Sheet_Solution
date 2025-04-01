package Arrays.Easy;

import java.util.Scanner;

public class numberThatAppearsOnce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0;i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
        }
        System.out.println(xor);
    }
}
