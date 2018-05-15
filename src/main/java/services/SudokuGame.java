package services;

import model.SudokuBoard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuGame {
    SudokuBoard sudokuBoard = new SudokuBoard();

    public SudokuGame() {

    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }

    public SudokuGame(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    private List<Integer> getPossibleInSquareValue(int row, int column, SudokuBoard sudokuBoard) {
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

    private List<Integer> getPossibleRowValues(int row, SudokuBoard sudokuBoard) {
        List<Integer> possibleRowValues = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        for (int c = 0; c < 9; c++) {
            int value = sudokuBoard.getBoard().get(row).getElements().get(c).getValue();
            if (value != -1) {
                possibleRowValues.remove(new Integer(value));
            }
        }
        return new ArrayList<>(possibleRowValues);
    }

    private List<Integer> getPossibleColumnValues(int column, SudokuBoard sudokuBoard) {
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

    public boolean sudokuSolver(SudokuBoard sudokuBoard, int r, int c) {
        if (r == 9) {
            r = 0;
            if (++c == 9) {
                //System.out.println(sudokuBoard);
                return true;
            }
        }

       // for (int r = x; r < 9; r++) {
         //   for (int c = y; c < 9; c++) {
                if(sudokuBoard.getBoard().get(r).getElements().get(c).getValue() == -1) {
                    //List<Integer> possibilities = getAllPossibleValues(r, c, sudokuBoard);
                    for (int a: getAllPossibleValues(r, c, sudokuBoard)) {
                        //System.out.println(r + " , " + c); //LOG
                        //if(possibilities.contains(x)) {
                            //possibilities.stream().forEach(System.out::print); // LOG
                            sudokuBoard.getBoard().get(r).getElements().get(c).setValue(a);

                            //System.out.println(sudokuBoard); //LOG
                            //System.out.println("______________________"); //LOG
                            if(sudokuSolver(sudokuBoard, r + 1, c)) {
                                return true;
                            }
                        //}
                    }
                    //System.out.println("VALUE REMOVED FROM POSSIBILITIES: "); //LOG

                } else {
                    return sudokuSolver(sudokuBoard,r + 1, c);
                }
        sudokuBoard.getBoard().get(r).getElements().get(c).setValue(-1);
        //System.out.println(sudokuBoard);
        return false;
 /*           }
        }*/

    }
}