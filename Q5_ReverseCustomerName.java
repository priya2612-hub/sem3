import java.util.Scanner;

public class Q5_ReverseCustomerName {

    static String reverseCustomerName(String customerName) {
        char[] arr = customerName.toCharArray();

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            char temp = arr[left];

