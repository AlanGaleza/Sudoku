package services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataValidator {
    private List<Integer> inputList;
    private SudokuGame sudokuGame;

    public DataValidator(SudokuGame sudokuGame) {
        this.sudokuGame = sudokuGame;
    }

    protected boolean validateUserInput (String userInput) {
        inputList = new ArrayList<>(Arrays.asList(userInput.split(","))).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if (inputList.size() > 3) {
            return false;
        }

        if (inputList.get(0) > 9 || inputList.get(0) < 1) {
            System.out.println("Bad input at row position: " + inputList.get(0));
            return false;

        } else if (inputList.get(1)> 9 || inputList.get(1) < 1) {
            System.out.println("Bad input at column position: " + inputList.get(1));
            return false;

        } else if (inputList.get(2) > 9 || inputList.get(2) < 1) {
            System.out.println("Bad input value position: " + inputList.get(2));
            return false;
        }
        System.out.println("Your input is: row: " + inputList.get(0) + ", column: " + inputList.get(1) + ", value: " + inputList.get(2));
        return true;
    }

    public List<Integer> getInputList() {
        return inputList;
    }

    protected boolean isPossible() {
        List<Integer> possibleValues = sudokuGame.getAllPossibleValues(getInputList().get(0)-1, getInputList().get(1)-1, sudokuGame.sudokuBoard);
        return possibleValues.stream().anyMatch(n -> n.equals(inputList.get(2)));
    }
}

