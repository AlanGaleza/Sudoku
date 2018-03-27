package services;

import model.SudokuBoard;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

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
            return true;
        }
        //System.out.println("Something went wrong at row: " + row + " column: " + column + " value: " + value);
        return false;
    }

    public boolean resolveSudoku() {
        int sudokuElementsLeft = 0;
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (!sudokuBoard.getBoard().get(r).getElements().get(c).getPossibleValue().isEmpty()) {
                    int random = ThreadLocalRandom.current().nextInt(sudokuBoard.getBoard().get(r).getElements().get(c).getPossibleValue().size());
                    int value = sudokuBoard.getBoard().get(r).getElements().get(c).getPossibleValue().get(random);
                    dataSet(r, c, value);
                    sudokuElementsLeft += sudokuBoard.getBoard().get(r).getElements().get(c).getPossibleValue().size();
                    System.out.println(sudokuElementsLeft);
                }
            }
            System.out.println(sudokuBoard);
        }
        return sudokuElementsLeft == 0;
    }
}
