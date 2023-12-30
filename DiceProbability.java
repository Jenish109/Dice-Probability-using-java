import java.util.Random;
import java.util.Scanner;

class Dice {
    public int rollAndSumDice() {
        Random random = new Random();
        return random.nextInt(6) + 1 + random.nextInt(6) + 1; // Roll two six-sided dice and sum the results
    }

    public int getRandomInRange(int low, int high) {
        Random random = new Random();
        return random.nextInt(high - low + 1) + low; // Generate a random number within the specified range
    }
}

class DiceProbability {
    public static void main(String[] args) {
        int roundNumber = 1;
        char userChoice;
        Dice dice = new Dice();
        Scanner scanner = new Scanner(System.in);

        System.out.println(
                           "*******************Dice Statistics********************\n"+
                           "This program simulates dice rolls and calculates the percentages\n" +
                           "of each possible outcome. You input how many dice throws you'd like in\n" +
                           "each round. You can repeat and do another round, or quit when done.");

        do {
            System.out.print("\nHow many dice throws do you want for Round #" + roundNumber + ": ");
            int totalThrows = scanner.nextInt();

            System.out.printf("Statistics for Round #%d:\n%3s%11s%10s\n%3s%11s%10s\n", roundNumber, "Roll", "Count", "Pct", "----", "-----", "---");

            int[] frequencies = new int[11];
            for (int i = 0; i < totalThrows; i++) {
                frequencies[dice.rollAndSumDice() - 2]++;
            }

            for (int diceTotal = 0; diceTotal < frequencies.length; diceTotal++) {
                double percentage = (double) frequencies[diceTotal] / totalThrows * 100;
                System.out.printf("%3d%12d%11.2f%%\n", diceTotal + 2, frequencies[diceTotal], percentage);
            }

            System.out.print("Would you like to run another simulation? Y|N: ");
            userChoice = scanner.next().charAt(0);

            if (userChoice == 'Y') {
                roundNumber++;
            } else if (userChoice == 'N') {
                System.out.println("Program Ending. Have a fantastic day.");
            } else {
                System.out.println("Enter a valid choice (Y|N).");
            }

        } while (userChoice == 'Y');
        scanner.close();
    }
}
