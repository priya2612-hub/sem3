import java.util.Scanner;

public class Q2_Palindrome {

    static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) {
            return true;
        }

        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        return isPalindromeRecursive(
            text.substring(1, text.length() - 1)
        );
    }

    static boolean isPalindromeArrayReversal(String text) {
        char[] arr = text.toCharArray();

        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        return text.equals(new String(arr));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.println("Iterative: "
                + isPalindromeIterative(text));

        System.out.println("Recursive: "
                + isPalindromeRecursive(text));

        System.out.println("Array Reversal: "
                + isPalindromeArrayReversal(text));

        sc.close();
    }
}
