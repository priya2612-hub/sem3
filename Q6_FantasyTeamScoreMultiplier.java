import java.util.Arrays;
import java.util.Scanner;

public class Q6_FantasyTeamScoreMultiplier {

    static void applyMultipliers(double[] playerScores,
                                 int captainIndex,
                                 int viceCaptainIndex) {

        playerScores[captainIndex] = playerScores[captainIndex] * 2.0;

        playerScores[viceCaptainIndex] =

