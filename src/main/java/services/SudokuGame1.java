package services;

import model.SudokuBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SudokuGame1 {
    SudokuBoard sudokuBoard = new SudokuBoard();

    public boolean isFull(SudokuBoard sudokuBoard) {
        for (int r = 0; r  < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (sudokuBoard.getBoard().get(r).getElements().get(c).getValue() == -1) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<Integer> getPossibleInSquareValue(int row, int column) {
        List<Integer> possibleValues = sudokuBoard.getBoard().get(row).getElements().get(column).getPossibleValue();
        int rowNumber = squareRowNumber(row);
        int columnNumber = squareColumnNumber(column);
        for(int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                int value = sudokuBoard.getBoard().get(rowNumber + r).getElements().get(columnNumber + c).getValue();
                if (value != -1) {
                    possibleValues.remove(new Integer(value));
                }
            }
        }
        return new ArrayList<>(possibleValues);
    }

    public List<Integer> getPossibleRowValues(int row, int column) {
        List<Integer> possibleRowValues = sudokuBoard.getBoard().get(row).getElements().get(column).getPossibleValue();
        for (int c = 0; c < 9; c++) {
            int value = sudokuBoard.getBoard().get(row).getElements().get(c).getValue();
            if (value != -1) {
                possibleRowValues.remove(new Integer(value));
            }
        }
        return new ArrayList<>(possibleRowValues);
    }

    public List<Integer> getPossibleColumnValues(int row, int column) {
        List<Integer> possibleColumnValues = sudokuBoard.getBoard().get(row).getElements().get(column).getPossibleValue();
        for (int r = 0; r < 9; r++) {
            int value = sudokuBoard.getBoard().get(r).getElements().get(column).getValue();
            if (value != -1) {
                possibleColumnValues.remove(new Integer(value));
            }
        }
        return new ArrayList<>(possibleColumnValues);
    }

    public List<Integer> getAllPossibleValues(int row, int column) {
        List<Integer> allPossibleValues = sudokuBoard.getBoard().get(row).getElements().get(column).getPossibleValue();
        allPossibleValues.retainAll(getPossibleInSquareValue(row, column));
        allPossibleValues.retainAll(getPossibleRowValues(row, column));
        allPossibleValues.retainAll(getPossibleColumnValues(row, column));
        return new ArrayList<>(allPossibleValues);
    }

    public int squareRowNumber(int row) {
        if (row >= 0 && row < 3) {
            return row = 0;
        } else if (row >= 3 && row < 6) {
            return row = 3;
        }
        return row = 6;
    }

    public int squareColumnNumber(int column) {
        if (column >= 0 && column < 3) {
            return column = 0;
        } else if (column >= 3 && column < 6) {
            return column = 3;
        }
        return column = 6;
    }

    public void sudokuSolver1(SudokuBoard sudokuBoard) {
        int i = 0;
        int j = 0;
        if ((isFull(sudokuBoard))) {
            System.out.println(sudokuBoard);
        } else {
            for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 9; c++) {
                    if(sudokuBoard.getBoard().get(r).getElements().get(c).getValue() == -1) {
                        i = r;
                        j = c;
                    }
                }
            }
        }

        if(!getAllPossibleValues(i, j).isEmpty()) {
            for (int y = 0; y < getAllPossibleValues(i, j).size(); y++) {
                int value = getAllPossibleValues(i, j).get(y);
                sudokuBoard.getBoard().get(i).getElements().get(j).setValue(value);
                sudokuSolver1(sudokuBoard);
            }
            sudokuBoard.getBoard().get(i).getElements().get(j).setValue(-1);
        }

    }

    public SudokuGame1() {

    }

    public SudokuGame1(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }


}
