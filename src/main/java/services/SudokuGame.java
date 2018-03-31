package services;

import model.SudokuBoard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuGame {
    SudokuBoard sudokuBoard = new SudokuBoard();

    public SudokuGame() {

    }

    public SudokuGame(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

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

    public List<Integer> getPossibleInSquareValue(int row, int column, SudokuBoard sudokuBoard) {
        List<Integer> possibleValues = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        for(int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                int value = sudokuBoard.getBoard().get(r + (row / 3) * 3).getElements().get(c + (column / 3) * 3).getValue();
                if (value != -1) {
                    possibleValues.remove(new Integer(value));
                }
            }
        }
        return new ArrayList<>(possibleValues);
    }

    public List<Integer> getPossibleRowValues(int row, SudokuBoard sudokuBoard) {
        List<Integer> possibleRowValues = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        for (int c = 0; c < 9; c++) {
            int value = sudokuBoard.getBoard().get(row).getElements().get(c).getValue();
            if (value != -1) {
                possibleRowValues.remove(new Integer(value));
            }
        }
        return new ArrayList<>(possibleRowValues);
    }

    public List<Integer> getPossibleColumnValues(int column, SudokuBoard sudokuBoard) {
        List<Integer> possibleColumnValues = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        for (int r = 0; r < 9; r++) {
            int value = sudokuBoard.getBoard().get(r).getElements().get(column).getValue();
            if (value != -1) {
                possibleColumnValues.remove(new Integer(value));
            }
        }
        return new ArrayList<>(possibleColumnValues);
    }

    public List<Integer> getAllPossibleValues(int row, int column, SudokuBoard sudokuBoard) {
        List<Integer> allPossibleValues = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        allPossibleValues.retainAll(getPossibleInSquareValue(row, column, sudokuBoard));
        allPossibleValues.retainAll(getPossibleRowValues(row, sudokuBoard));
        allPossibleValues.retainAll(getPossibleColumnValues(column, sudokuBoard));
        return new ArrayList<>(allPossibleValues);
    }

    public void sudokuSolver(SudokuBoard sudokuBoard) {
        int i = 0;
        int j = 0;
        boolean stop = false;
        List<Integer> possibilities;
        if (isFull(sudokuBoard)) {
            System.out.println(sudokuBoard);
            System.out.println("SOLVED");
            return;
        } else {
            for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 9; c++) {
                    if(sudokuBoard.getBoard().get(r).getElements().get(c).getValue() == -1) {
                        i = r;
                        j = c;
                        stop = true;
                        break;
                    }
                }
                if (stop) {
                    break;
                }
            }
        }
        possibilities = getAllPossibleValues(i, j, sudokuBoard);


        for (int x = 1; x <= 9; x++) {
            System.out.println(i + " , " + j); //LOG
            if(possibilities.contains(x)) {
                possibilities.stream().forEach(System.out::print); // LOG
                sudokuBoard.getBoard().get(i).getElements().get(j).setValue(x);
                possibilities.remove(new Integer(x));

                System.out.println(sudokuBoard); //LOG
                System.out.println("______________________"); //LOG
                sudokuSolver(sudokuBoard);
            }
                System.out.println("VALUE REMOVED FROM POSSIBILITIES: " + x); //LOG

            sudokuBoard.getBoard().get(i).getElements().get(j).setValue(-1);
            System.out.println("tak teraz wyglada: " + i +" " + j); //LOG
        }
    }
}