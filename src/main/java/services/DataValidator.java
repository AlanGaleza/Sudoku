package services;

import model.SudokuBoard;
import model.SudokuRow;

import java.util.stream.IntStream;

public class DataValidator {
    SudokuBoard sudokuBoard;

    public DataValidator(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    public boolean validateRowData (int row, int column, int value) {

        if(sudokuBoard.getBoard().get(row).getElements().get(column).getValue() == -1 && value > 0 && value < 10) {
            IntStream.range(0, 9)
                    .forEach(n -> sudokuBoard.getBoard().get(row).getElements().get(n).getPossibleValue().remove(value));
            sudokuBoard.getBoard().get(row).getElements().get(column).setValue(value);

        } else if (sudokuBoard.getBoard().get(row).getElements().get(column).getPossibleValue().contains(value)) {
            IntStream.range(0, 9)
                    .forEach(n -> sudokuBoard.getBoard().get(row).getElements().get(n).getPossibleValue().remove(value));
            sudokuBoard.getBoard().get(row).getElements().get(column).setValue(value);

        } else if (!sudokuBoard.getBoard().get(row).getElements().get(column).getPossibleValue().contains(value)) {
            System.out.println("You can not put this value here");
            return false;
        }
        return true;
    }
}
