import java.util.Arrays;
import java.util.Scanner;

public class Q5_PlacementDriveShortlistingRankingEngine {

    static class Candidate implements Comparable<Candidate> {

        private String name;
        private double cgpa;
        private int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        double getCompositeScore() {
            return (cgpa * 10) + (codingScore * 0.5);
        }

        String getName() {
            return name;
        }

        static boolean isEligible(double cgpa) {
            return cgpa >= 7.5;
        }

        static boolean isEligible(double cgpa, int codingScore) {
            return cgpa >= 6.5 && codingScore >= 60;
        }

        @Override
        public int compareTo(Candidate other) {
            return Double.compare(other.getCompositeScore(), this.getCompositeScore());
        }
    }

    static String shortlistAndRank(Candidate[] candidates) {

        Candidate[] shortlisted = new Candidate[candidates.length];
        int count = 0;

        for (int i = 0; i < candidates.length; i++) {

            if (Candidate.isEligible(candidates[i].cgpa)
                    || Candidate.isEligible(candidates[i].cgpa,
                    candidates[i].codingScore)) {

                shortlisted[count] = candidates[i];
                count++;
            }
        }

        Candidate[] finalList = Arrays.copyOf(shortlisted, count);

        Arrays.sort(finalList);

        String result = "";

        for (int i = 0; i < finalList.length; i++) {

            result = result
                    + (i + 1)
                    + ". "
                    + finalList[i].getName()
                    + " ("
                    + finalList[i].getCompositeScore()
                    + ")";

            if (i < finalList.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();
        sc.nextLine();

        Candidate[] candidates = new Candidate[n];

        for (int i = 0; i < n; i++) {

            System.out.println("Enter details for candidate " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("CGPA: ");
            double cgpa = sc.nextDouble();

            System.out.print("Coding Score: ");
            int codingScore = sc.nextInt();
            sc.nextLine();

            candidates[i] = new Candidate(name, cgpa, codingScore);
        }

        String result = shortlistAndRank(candidates);

        System.out.println("Shortlisted and Ranked Candidates:");
        System.out.println(result);

        sc.close();
    }
}
