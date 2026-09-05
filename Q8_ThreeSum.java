import java.util.Arrays;
import java.util.Scanner;

public class Q8_ThreeSum {

    static int[][] threeSum(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;
        int[][] temp = new int[n * n][3];
        int count = 0;


