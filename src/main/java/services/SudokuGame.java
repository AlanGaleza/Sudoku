package services;

import model.SudokuBoard;

import java.util.Scanner;
import java.util.stream.IntStream;

public class SudokuGame {
    Scanner scanner = new Scanner(System.in);
    private DataValidator dataValidator;
    private SudokuBoard sudokuBoard;

    public SudokuGame(DataValidator dataValidator, SudokuBoard sudokuBoard) {
        this.dataValidator = dataValidator;
        this.sudokuBoard = sudokuBoard;
    }

    public boolean dataSet (int row, int column, int value) {
        if(dataValidator.validateInput(row, column, value, sudokuBoard)) {
            sudokuBoard.getBoard().get(row).getElements().get(column).setValue(value);
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    sudokuBoard.getBoard().get(r + (row / 3) * 3).getElements().get(c + (column / 3) * 3).removeValueFromPossibleValueList(value);
                }
            }
            return true;
        }
        return false;
    }

    public boolean resolveSudoku() {
        //find first empty element
        for (int r = 0; r < 9; r++) {
            for(int c = 0; c < 9; c++) {
                if (sudokuBoard.getBoard().get(r).getElements().get(c).getValue() == -1) {
                    return
                }
            }

        }

        return false;
    }
}
