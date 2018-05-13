import model.SudokuBoard;
import org.junit.Test;
import services.SudokuGame;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class SudokuTestSuite {

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
        System.out.println("Changing board value at Original board 2nd row 2nd line to 8 value");
        sudokuBoard.getBoard().get(1).getElements().get(1).setValue(8);
        System.out.println("\nDeepClone board after changing Original board\n" + deepCloneSudokuBoard);
        System.out.println("\nOriginal board after changes\n" + sudokuBoard);

        try {
            deepCloneSudokuBoard = sudokuBoard.deepCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println("DeepClone ERROR!");
        }

        System.out.println("new DeepCloneBoard " + deepCloneSudokuBoard);

        //Then
        assertThat(deepCloneSudokuBoard.getBoard().get(1).getElements().get(1).getValue()).isEqualTo(8);
        assertThat(sudokuBoard.getBoard().get(1).getElements().get(1).getValue()).isEqualTo(8);
        assertThat(deepCloneSudokuBoard.getBoard().get(1).getElements().get(1).getValue()).isEqualTo(sudokuBoard.getBoard().get(1).getElements().get(1).getValue());
    }

    @Test
    public void getAllPossibleValuesTest() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        SudokuGame sudokuGame = new SudokuGame(sudokuBoard);
        System.out.println(sudokuBoard);

        //When
/*        sudokuBoard.getBoard().get(1).getElements().get(1).setValue(1);
        sudokuBoard.getBoard().get(1).getElements().get(4).setValue(5);
        sudokuBoard.getBoard().get(4).getElements().get(1).setValue(6);
        sudokuBoard.getBoard().get(2).getElements().get(0).setValue(7);*/

        sudokuBoard.getBoard().get(1).getElements().get(0).setValue(1);
        sudokuBoard.getBoard().get(1).getElements().get(1).setValue(2);
        sudokuBoard.getBoard().get(1).getElements().get(2).setValue(3);
        sudokuBoard.getBoard().get(2).getElements().get(0).setValue(4);
        sudokuBoard.getBoard().get(2).getElements().get(1).setValue(5);
        sudokuBoard.getBoard().get(2).getElements().get(2).setValue(6);
        sudokuBoard.getBoard().get(3).getElements().get(1).setValue(7);
        sudokuBoard.getBoard().get(3).getElements().get(2).setValue(8);
        sudokuBoard.getBoard().get(4).getElements().get(0).setValue(9);

        System.out.println(sudokuBoard);

        List<Integer> result = sudokuGame.getAllPossibleValues(3, 0, sudokuBoard);
//        List<Integer> result1 = sudokuGame.getAllPossibleValues(1, 4, sudokuBoard);
  //      List<Integer> result2 = sudokuGame.getAllPossibleValues(4, 1, sudokuBoard);
        //List<Integer> result2 = sudokuGame.getAllPossibleValues(4, 1);
        System.out.println(".........");
        result.stream().forEach(System.out::print);
/*
        System.out.println(".........");
        result1.stream().forEach(System.out::print);
        System.out.println(".........");
        result2.stream().forEach(System.out::print);
*/

        //Then
/*
        assertThat(6).isEqualTo(result.size());
        assertThat(2).isEqualTo(result.get(0));
*/

    }

    @Test
    public void sudokuSolverTest() {
    //Given
    SudokuBoard sudokuBoard = new SudokuBoard();
    SudokuGame sudokuGame = new SudokuGame();

    //When
    sudokuBoard.getBoard().get(0).getElements().get(1).setValue(2);
    sudokuBoard.getBoard().get(0).getElements().get(3).setValue(5);
    sudokuBoard.getBoard().get(0).getElements().get(5).setValue(1);
    sudokuBoard.getBoard().get(0).getElements().get(7).setValue(9);

    sudokuBoard.getBoard().get(1).getElements().get(0).setValue(8);
    sudokuBoard.getBoard().get(1).getElements().get(3).setValue(2);
    sudokuBoard.getBoard().get(1).getElements().get(5).setValue(3);
    sudokuBoard.getBoard().get(1).getElements().get(8).setValue(6);

    sudokuBoard.getBoard().get(2).getElements().get(1).setValue(3);
    sudokuBoard.getBoard().get(2).getElements().get(4).setValue(6);
    sudokuBoard.getBoard().get(2).getElements().get(7).setValue(7);

    sudokuBoard.getBoard().get(3).getElements().get(2).setValue(1);
    sudokuBoard.getBoard().get(3).getElements().get(6).setValue(6);

    sudokuBoard.getBoard().get(4).getElements().get(0).setValue(5);
    sudokuBoard.getBoard().get(4).getElements().get(1).setValue(4);
    sudokuBoard.getBoard().get(4).getElements().get(7).setValue(1);
    sudokuBoard.getBoard().get(4).getElements().get(8).setValue(9);

    sudokuBoard.getBoard().get(5).getElements().get(2).setValue(2);
    sudokuBoard.getBoard().get(5).getElements().get(6).setValue(7);

    sudokuBoard.getBoard().get(6).getElements().get(1).setValue(9);
    sudokuBoard.getBoard().get(6).getElements().get(4).setValue(3);
    sudokuBoard.getBoard().get(6).getElements().get(7).setValue(8);

    sudokuBoard.getBoard().get(7).getElements().get(0).setValue(2);
    sudokuBoard.getBoard().get(7).getElements().get(3).setValue(8);
    sudokuBoard.getBoard().get(7).getElements().get(5).setValue(4);
    sudokuBoard.getBoard().get(7).getElements().get(8).setValue(7);

    sudokuBoard.getBoard().get(8).getElements().get(1).setValue(1);
    sudokuBoard.getBoard().get(8).getElements().get(3).setValue(9);
    sudokuBoard.getBoard().get(8).getElements().get(5).setValue(7);
    sudokuBoard.getBoard().get(8).getElements().get(7).setValue(6);

    System.out.println(sudokuBoard);

    boolean result = sudokuGame.sudokuSolver(sudokuBoard, 0, 0);

    //Then
        assertThat(result).isTrue();

    }
}

