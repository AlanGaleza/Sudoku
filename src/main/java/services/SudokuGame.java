package services;

import model.SudokuBoard;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SudokuGame {
    Scanner scanner = new Scanner(System.in);
    DataValidator dataValidator;
    SudokuBoard sudokuBoard;

    public SudokuGame() {
    }

    public void dataSet (int row, int column, int value) {
        if(dataValidator.validateRowData(row, column, value)) {
            dataValidator.sudokuBoard.getBoard().get(row).getElements().get(column).setValue(value);
        }
    }

    public boolean resolveSudoku() {

        return false;
    }


}
