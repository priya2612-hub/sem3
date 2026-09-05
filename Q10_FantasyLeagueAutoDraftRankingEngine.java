import java.util.Arrays;
import java.util.Scanner;

public class Q10_FantasyLeagueAutoDraftRankingEngine {

    static class Player implements Comparable<Player> {

        String name;
        int matchesPlayed;
        double battingAverage;
        boolean injured;

        Player(String name, int matchesPlayed,
               double battingAverage, boolean injured) {

            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        boolean isDraftable(int minimumMatches) {
            return matchesPlayed >= minimumMatches;
        }

        boolean isDraftable(int minimumMatches,
                            boolean allowInjured) {

            return matchesPlayed >= minimumMatches
                    && (allowInjured || !injured);
        }

        double fantasyPoints() {
            return matchesPlayed * battingAverage;
        }

        @Override
        public int compareTo(Player other) {
            return Double.compare(
                    other.fantasyPoints(),
                    this.fantasyPoints()
            );
        }
    }

    static Player[] draftAndRank(Player[] players) {

        int count = 0;

        for (Player player : players) {

            if (player.isDraftable(10)
                    || player.isDraftable(5, true)) {
                count++;
            }
        }

        Player[] draftablePlayers = new Player[count];

        int index = 0;

        for (Player player : players) {

            if (player.isDraftable(10)
                    || player.isDraftable(5, true)) {

                draftablePlayers[index++] = player;
            }
        }

        Arrays.sort(draftablePlayers);

        return draftablePlayers;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();
        sc.nextLine();

        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter details for Player " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Matches Played: ");
            int matchesPlayed = sc.nextInt();

            System.out.print("Batting Average: ");
            double battingAverage = sc.nextDouble();

            System.out.print("Injured (true/false): ");
            boolean injured = sc.nextBoolean();
            sc.nextLine();

            players[i] = new Player(
                    name,
                    matchesPlayed,
                    battingAverage,
                    injured
            );
        }

        Player[] result = draftAndRank(players);

        System.out.println("\nDraft Ranking:");

        for (int i = 0; i < result.length; i++) {
            System.out.println(
                    (i + 1) + ". " + result[i].name
            );
        }

        sc.close();
    }
}
