import services.SudokuGame;

public class SudokuRunner {
    public static void main(String args[]) {
        boolean isGameFinished = false;

        while(!isGameFinished) {
            SudokuGame theGame = new SudokuGame();

            isGameFinished = theGame.resolveSudoku();
        }
    }
}
