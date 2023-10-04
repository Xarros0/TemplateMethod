import java.util.Random;

class DiceGame extends Game {
    private int[] scores;
    private int winningScore;

    @Override
    void initializeGame() {
        scores = new int[playersCount];
        for (int i = 0; i < playersCount; i++) {
            scores[i] = 0;
        }
        winningScore = 50; // Pelin voittopistemäärä
        System.out.println("Aloita nopanheittopeli!");
    }

    @Override
    void makePlay(int player) {
        Random random = new Random();
        int roll = random.nextInt(6) + 1; // Heitä noppaa (1-6)
        scores[player] += roll;
        System.out.println("Pelaaja " + (player + 1) + " heitti noppaa ja sai " + roll + " pistettä.");
        System.out.println("Pelaajan " + (player + 1) + " pisteet: " + scores[player]);
        if (scores[player] >= winningScore) {
            System.out.println("Pelaaja " + (player + 1) + " voitti!");
        }
    }

    @Override
    boolean endOfGame() {
        for (int score : scores) {
            if (score >= winningScore) {
                return true;
            }
        }
        return false;
    }

    @Override
    void printWinner() {
        int maxScore = scores[0];
        int winner = 0;
        for (int i = 1; i < playersCount; i++) {
            if (scores[i] > maxScore) {
                maxScore = scores[i];
                winner = i;
            }
        }
        System.out.println("Peli päättyi. Pelaaja " + (winner + 1) + " voitti pisteillä " + maxScore);
    }
}
