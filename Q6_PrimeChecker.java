
import java.util.Scanner;

public class Q6_PrimeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean prime = true;

        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                prime = false;
                break;
            }
        }

        if (n > 1 && prime)
            System.out.println(n + " is prime");
        else
            System.out.println(n + " is not prime");

        sc.close();
    }
}
