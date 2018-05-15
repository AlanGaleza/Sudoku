package services;

import model.SudokuBoard;

import java.util.Scanner;

public class UserService {
    private SudokuBoard sudokuBoard;
    private SudokuGame sudokuGame;
    private DataValidator dataValidator;
    private boolean isInput = true;

    public boolean introducer() {
        sudokuBoard = new SudokuBoard();
        sudokuGame = new SudokuGame(sudokuBoard);
        dataValidator = new DataValidator(sudokuGame);
        System.out.println("Hello, plz input values;");
        System.out.println("F.e. 1,2,3 means put number 3 into position row 1 and column 2");
        System.out.println("Choose what You want to do: New game|Quit. N/Q");
        Scanner reader = new Scanner(System.in);
        String userInput = reader.nextLine();
        switch (userInput.toLowerCase()) {
            case ("n"): insertionHandler(); break;
            case ("q"):
                System.out.println("GooD Day");
                return false;
            default:
                System.out.println("Bad pick, quit");
                System.out.println("GooD Day");
                return false;
        }
        return true;
    }

    private void insertionHandler() {
        while (isInput) {
            Scanner reader = new Scanner(System.in);
            System.out.println("Input values: ");
            String userInput = reader.nextLine();
            dataValidator.validateUserInput(userInput);
            if (dataValidator.isPossible()) {
                sudokuBoard.getBoard().get(dataValidator.getInputList().get(0) - 1).getElements().get(dataValidator.getInputList().get(1) - 1).setValue(dataValidator.getInputList().get(2));
                System.out.println(sudokuBoard);
                System.out.flush();
            } else {
                System.out.println("U cant put this value here");
                System.out.println(sudokuBoard);
                System.out.println("Try Again");
            }
            System.out.println("Would you like to put another value? Y/N");
            Scanner readerInsert = new Scanner(System.in);
            String userInput1 = readerInsert.nextLine();
            switch (userInput1.toLowerCase()) {
                case ("n"):
                    System.out.println("Done.");
                    mainCommunicator();
                    isInput = false;
                    break;
                case ("y"):
                    isInput = true;
                    break;
                default:
                    System.out.println("Done.");
                    isInput = false;
                    break;
            }
        }
     }

    private void mainCommunicator() {
        Scanner reader = new Scanner(System.in);
        System.out.println("What you want to do? New game|Solve Sudoku|Quit|. N/S/Q");
        String userInput = reader.nextLine();
        switch (userInput.toLowerCase()) {
            case ("s"):
                if(sudokuGame.sudokuSolver(sudokuBoard, 0, 0)) {
                System.out.println(sudokuGame.getSudokuBoard());
                break;
            } else {
                System.out.println("Sudoku is unsolvable");
                break;
            }
            case ("q"):
                System.out.println("GooD Day");
                break;
            case ("n"): introducer(); break;
            default:
                System.out.println("Bad pick, quit");
                System.out.println("GooD Day");
                break;
        }
    }
}
