package services;

import model.SudokuBoard;

import java.util.Arrays;

public class DataValidator {
    SudokuBoard sudokuBoard =  new SudokuBoard();


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

