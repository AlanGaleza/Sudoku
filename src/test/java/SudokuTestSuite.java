import model.SudokuBoard;
import org.junit.Test;
import services.DataValidator;
import services.SudokuGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class SudokuTestSuite {

    static int counter = 0;
    @Test
    public void SudokuBoardSizeTest () {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();

        //When
        double boardSize = IntStream.range(0, 9)
                .mapToDouble(n -> sudokuBoard.getBoard().size())
                .sum();

        double rowSize = sudokuBoard.getBoard().get(0).getElements().size();

        //Then
        assertThat(boardSize).isEqualTo(81);
        assertThat(rowSize).isEqualTo(9);
    }

    @Test
    public void sudokuShallowCloneTest() throws CloneNotSupportedException {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();

        //When
        SudokuBoard shallowCloneSudokuBoard = null;
        System.out.println("Original board\n" + sudokuBoard);

        try {
            shallowCloneSudokuBoard = sudokuBoard.shallowCopy();

        } catch (CloneNotSupportedException e) {
            System.out.println("ShallowClone ERROR!");
        }

        System.out.println("ShallowClone board\n" + shallowCloneSudokuBoard);
        System.out.println("Changing board value at Original board 2nd row 2nd line to -1 value");
        sudokuBoard.getBoard().get(1).getElements().get(1).setValue(-1);
        System.out.println("\nShallowClone board after changing Original board\n" + shallowCloneSudokuBoard);

        //Then
        assertThat(shallowCloneSudokuBoard.getBoard().get(1).getElements().get(1).getValue()).isEqualTo(-1);
        assertThat(sudokuBoard.getBoard().get(1).getElements().get(1).getValue()).isEqualTo(-1);
        assertThat(shallowCloneSudokuBoard.getBoard().get(1).getElements().get(1).getValue()).isEqualTo(sudokuBoard.getBoard().get(1).getElements().get(1).getValue());
    }

    @Test
    public void sudokuDeepCloneTest() throws CloneNotSupportedException {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();

        //When
        SudokuBoard deepCloneSudokuBoard = null;
        System.out.println("Original board\n" + sudokuBoard);

        try {
            deepCloneSudokuBoard = sudokuBoard.deepCopy();

        } catch (CloneNotSupportedException e) {
            System.out.println("DeepClone ERROR!");
        }

        System.out.println("DeepClone board\n" + deepCloneSudokuBoard);
        System.out.println("Changing board value at Original board 2nd row 2nd line to -1 value");
        sudokuBoard.getBoard().get(1).getElements().get(1).setValue(-1);
        System.out.println("\nDeepClone board after changing Original board\n" + deepCloneSudokuBoard);
        System.out.println("\nOriginal board after changes\n" + sudokuBoard);

        //Then
        assertThat(deepCloneSudokuBoard.getBoard().get(1).getElements().get(1).getValue()).isEqualTo(-1);
        assertThat(sudokuBoard.getBoard().get(1).getElements().get(1).getValue()).isEqualTo(-1);
        assertThat(deepCloneSudokuBoard.getBoard().get(1).getElements().get(1).getValue()).isEqualTo(sudokuBoard.getBoard().get(1).getElements().get(1).getValue());
    }

    @Test
    public void dataSetTest() {
        //Given
        boolean squareValueTest = true;
        String userInput = "1,1,1";

        SudokuBoard sudokuBoard = new SudokuBoard();
        SudokuGame sudokuGame = new SudokuGame(new DataValidator(), sudokuBoard);

        int[] inputList = Arrays.stream(userInput.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        //System.out.println(sudokuGame.getSudokuBoard().toString());

        //When
        sudokuGame.dataSet(inputList[0], inputList[1], inputList[2]);
        int result =  sudokuBoard.getBoard().get(inputList[0]).getElements().get(inputList[1]).getValue();

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                squareValueTest = sudokuGame.dataSet(r, c, inputList[2]);
            }
        }

        //Then
        assertThat(1).isEqualTo(result);
        assertThat(squareValueTest).isFalse();
    }

    @Test
    public void validateInputTest() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        DataValidator dataValidator = new DataValidator();

        //When
        boolean trueResult = dataValidator.validateInput(1,1,2, sudokuBoard);
        boolean falseResult = dataValidator.validateInput(1,1,-1, sudokuBoard);

        //Then
        assertThat(trueResult).isTrue();
        assertThat(falseResult).isFalse();
    }

    @Test
    public void validateUserInputTest() {
        //Given
        DataValidator dataValidator = new DataValidator();
        String userCorrectValuesInput = "1,2,3";
        String userIncorrectValueInput = "0,0,0";

        //When
        boolean correctValueResult = dataValidator.validateUserInput(userCorrectValuesInput);
        boolean incorrectValueResult = dataValidator.validateUserInput(userIncorrectValueInput);

        //Then
        assertThat(correctValueResult).isTrue();
        assertThat(incorrectValueResult).isFalse();
    }

    @Test
    public void resolveSudokuTest(){
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        DataValidator dataValidator = new DataValidator();
        SudokuGame sudokuGame = new SudokuGame(dataValidator, sudokuBoard);
        int counter = 0;

        while(!sudokuGame.resolveSudoku()) {
            counter++;
        }
        System.out.println(counter);
    }
}

