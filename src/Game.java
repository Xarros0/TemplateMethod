abstract class Game {

    protected int playersCount;

    abstract void initializeGame();

    abstract void makePlay(int player);

    abstract boolean endOfGame();

    abstract void printWinner();

    public final void playOneGame(int playersCount) {
        this.playersCount = playersCount;
        initializeGame();
        int currentPlayer = 0;
        while (!endOfGame()) {
            makePlay(currentPlayer);
            currentPlayer = (currentPlayer + 1) % playersCount;
        }
        printWinner();
    }
}
