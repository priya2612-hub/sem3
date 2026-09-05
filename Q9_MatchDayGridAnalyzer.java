import java.util.Scanner;

public class Q9_MatchDayGridAnalyzer {

    static double rowAverage(int[] row) {

        int sum = 0;

        for (int value : row) {
            sum += value;
        }

        return (double) sum / row.length;
    }

    static String classifyMatches(int[][] grid, int threshold) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < grid.length; i++) {

            double average = rowAverage(grid[i]);

            if (average >= threshold) {
                result.append("Match ")
                      .append(i)
                      .append(": Power Surge");
            } else {
                result.append("Match ")
                      .append(i)
                      .append(": Normal");
            }

            if (i < grid.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of matches: ");
        int matches = sc.nextInt();

        int[][] grid = new int[matches][];

        for (int i = 0; i < matches; i++) {

            System.out.print("Enter number of values for Match "
                    + i + ": ");

            int n = sc.nextInt();

            grid[i] = new int[n];

            System.out.println("Enter values:");

            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter threshold: ");
        int threshold = sc.nextInt();

        System.out.println(classifyMatches(grid, threshold));

        sc.close();
    }
}
