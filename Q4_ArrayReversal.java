
import java.util.Scanner;
import java.util.Arrays;

public class Q4_ArrayReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[4];

        for (int i = 0; i < 4; i++)
            a[i] = sc.nextInt();

        int left = 0, right = a.length - 1;

        while (left < right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }

        System.out.println(Arrays.toString(a));
        sc.close();
    }
}
