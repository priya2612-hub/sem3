
import java.util.Scanner;

public class Q5_WeeklyRainfallAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] rainfall = new double[7];
        double total = 0;
        int dryDays = 0;
        int wettestDay = 0;

        for (int i = 0; i < 7; i++) {
            rainfall[i] = sc.nextDouble();

            total += rainfall[i];

            if (rainfall[i] == 0) {
                dryDays++;
            }

            if (rainfall[i] > rainfall[wettestDay]) {
                wettestDay = i;
            }
        }

        double average = total / 7;

        System.out.print("Rainfall (mm): ");

        for (int i = 0; i < 7; i++) {
            System.out.printf("%.1f ", rainfall[i]);
        }

        System.out.printf("%nTotal Rainfall: %.1f mm%n", total);
        System.out.printf("Average Rainfall: %.2f mm%n", average);

        System.out.printf("Wettest Day: Day %d (%.1f mm)%n",
                wettestDay + 1, rainfall[wettestDay]);

        System.out.println("Total Dry Days: " + dryDays);

        sc.close();
    }
}
