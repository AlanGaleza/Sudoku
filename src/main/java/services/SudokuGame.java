/*
package services;

import model.SudokuBoard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

    public class SudokuGame {
    Scanner scanner = new Scanner(System.in);
    private DataValidator dataValidator;
    SudokuBoard sudokuBoard = new SudokuBoard();


    public SudokuGame() {

    }

    public SudokuGame(DataValidator dataValidator, SudokuBoard sudokuBoard) {
        this.dataValidator = dataValidator;
        this.sudokuBoard = sudokuBoard;
    }

    public boolean dataSet (int row, int column, int value) {
        if(validateInput(row, column, value)) {
            sudokuBoard.getBoard().get(row).getElements().get(column).setValue(value);
            return true;
        }
        return false;
    }

    public boolean resolveSudoku() {
            for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 9; c++) {
                    //int random = ThreadLocalRandom.current().nextInt(sudokuBoard.getBoard().get(r).getElements().get(c).getPossibleValue().size());
                    int value = sudokuBoard.getBoard().get(r).getElements().get(c).getPossibleValue().get(1);
                    if (validateInput(r, c, value)) {
                            sudokuBoard.getBoard().get(r).getElements().get(c).setValue(value);
                        } else {
                        return resolveSudoku();
                    }
                }
            }
        System.out.println(sudokuBoard);
        return true;
    }

    private boolean validateInRowAndColumnData (int row, int column, int value) {
        for (int i = 0; i < 9; i++) {
            if (sudokuBoard.getBoard().get(row).getElements().get(i).getValue() == value || sudokuBoard.getBoard().get(i).getElements().get(column).getValue() == value) {
                return false;
            } else {
                sudokuBoard.getBoard().get(row).getElements().get(i).removeValueFromPossibleValueList(value);
                sudokuBoard.getBoard().get(i).getElements().get(column).removeValueFromPossibleValueList(value);
            }
        }
        return true;
    }

    private boolean validateInSquareData (int row, int column, int value) {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (sudokuBoard.getBoard().get(r + (row / 3) * 3 ).getElements().get(c + (column / 3) * 3).getValue() == value) {
                    return false;
                } else {
                    sudokuBoard.getBoard().get(r + (row / 3) * 3 ).getElements().get(c + (column / 3) * 3).removeValueFromPossibleValueList(value);
                }
            }
        }
        return true;
    }

    public boolean validateInput(int row, int column, int value) {
        return validateInRowAndColumnData(row, column, value) && validateInSquareData(row, column, value);
    }

}
*/
