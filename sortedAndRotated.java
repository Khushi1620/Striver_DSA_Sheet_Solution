package Arrays;

public class sortedAndRotated {
    public static void main(String[] args) {
        int [] arr = {2,3,4,5,1,2,2};
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > arr[(i+1)%arr.length]) {
                count ++;
            }
        }
        if (count > 1) {
            System.out.println("False");
        } else {
            System.out.println("True");
        }
    }
}
