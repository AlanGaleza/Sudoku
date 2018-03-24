import model.SudokuBoard;
import services.SudokuGame;

public class SudokuRunner {
    public static void main(String args[]) {
        boolean isGameFinished = false;
        SudokuBoard sudokuBoard = new SudokuBoard();

        while(!isGameFinished) {
            SudokuGame theGame = new SudokuGame();


            isGameFinished = theGame.resolveSudoku();
        }
    }
}
