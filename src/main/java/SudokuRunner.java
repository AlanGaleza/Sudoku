import model.SudokuBoard;
import services.DataValidator;
import services.SudokuGame;

public class SudokuRunner {
    public static void main(String args[]) {
        boolean isGameFinished = false;
        SudokuBoard sudokuBoard = new SudokuBoard();
        DataValidator dataValidator = new DataValidator();

/*        while(!isGameFinished) {
            SudokuGame theGame = new SudokuGame(dataValidator, sudokuBoard);


            //isGameFinished = theGame.resolveSudoku();
        }*/

        while (!isGameFinished) {
            isGameFinished = true;
        }
    }
}
