package services;

import model.SudokuBoard;

import java.util.Arrays;

public class DataValidator {

    private boolean validateInRowData (int row, int column, int value, SudokuBoard sudokuBoard) {
        for (int i = 0; i < 9; i++) {
            if (sudokuBoard.getBoard().get(row).getElements().get(i).getValue() == value || sudokuBoard.getBoard().get(i).getElements().get(column).getValue() == value) {
                return false;
            }
        }
        return true;
    }

    private boolean validateInSquareData (int row, int column, int value, SudokuBoard sudokuBoard) {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (sudokuBoard.getBoard().get(r + (row / 3) * 3 ).getElements().get(c + (column / 3) * 3).getValue() == value) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean validateInput(int row, int column, int value, SudokuBoard sudokuBoard) {
        return validateInRowData(row, column, value, sudokuBoard) && validateInSquareData(row, column, value, sudokuBoard);
    }

    public boolean validateUserInput (String userInput) throws NumberFormatException{
        int[] inputList;
        try {
            inputList = Arrays.stream(userInput.split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        } catch (NumberFormatException e){
            System.out.println("Bad input, check inputted values and separator");
            return false;
        }

        if (inputList.length > 5) {
            return false;
        }

        if (inputList[0] > 9 || inputList[0] < 1) {
            System.out.println("Bad input at row position: " + inputList[0]);
            return false;

        } else if (inputList[1] > 9 || inputList[1] < 1) {
            System.out.println("Bad input at column position: " + inputList[1]);
            return false;

        } else if (inputList[2] > 9 || inputList[2] < 1) {
            System.out.println("Bad input at column position: " + inputList[2]);
            return false;
        }
        return true;
    }

}

