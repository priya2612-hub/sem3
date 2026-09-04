import java.util.Random;
import java.util.Scanner;

public class Q1_RockPaperScissors {

    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove))
            return "Draw";

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper")))
            return "Win";

        return "Loss";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};

        int wins = 0, losses = 0, draws = 0;

        System.out.print("Enter number of rounds: ");
        int n = sc.nextInt();

        System.out.println("\nRound\tPlayer\t\tComputer\tResult");

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter Rock/Paper/Scissors: ");
            String player = sc.next();

            player = player.substring(0, 1).toUpperCase() +
                     player.substring(1).toLowerCase();

            String computer = moves[random.nextInt(3)];

            String result = playRound(player, computer);

            if (result.equals("Win"))
                wins++;
            else if (result.equals("Loss"))
                losses++;
            else
                draws++;

            System.out.println(i + "\t" + player + "\t\t" +
                               computer + "\t\t" + result);
        }

        double percentage = (wins * 100.0) / n;

        System.out.println("\nWins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win Percentage: " + percentage + "%");

        sc.close();
    }
}
