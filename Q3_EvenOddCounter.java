
import java.util.Scanner;

public class Q3_EvenOddCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int even = 0, odd = 0;

        System.out.print("Enter 6 numbers: ");
        for (int i = 0; i < 6; i++) {
            int n = sc.nextInt();

            if (n % 2 == 0)
                even++;
            else
                odd++;
        }

        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
        sc.close();
    }
}
