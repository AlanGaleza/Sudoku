import model.SudokuBoard;
import model.SudokuElement;
import model.SudokuRow;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class SudokuTestSuite {

    public static SudokuBoard sudokuBoard = new SudokuBoard();

    @Before
    public void boardReturn() {
        SudokuRow sudokuRow1 = new SudokuRow();
        SudokuRow sudokuRow2 = new SudokuRow();
        SudokuRow sudokuRow3 = new SudokuRow();
        SudokuRow sudokuRow4 = new SudokuRow();
        SudokuRow sudokuRow5 = new SudokuRow();
        SudokuRow sudokuRow6 = new SudokuRow();
        SudokuRow sudokuRow7 = new SudokuRow();
        SudokuRow sudokuRow8 = new SudokuRow();
        SudokuRow sudokuRow9 = new SudokuRow();

        IntStream.range(0, 9)
                .forEach(n -> sudokuRow1.getElements().get(n).setValue(n+1));

        IntStream.range(0, 9)
                .forEach(n -> sudokuRow2.getElements().get(n).setValue(n+1));

        IntStream.range(0, 9)
                .forEach(n -> sudokuRow3.getElements().get(n).setValue(n+1));

        IntStream.range(0, 9)
                .forEach(n -> sudokuRow4.getElements().get(n).setValue(n+1));

        IntStream.range(0, 9)
                .forEach(n -> sudokuRow5.getElements().get(n).setValue(n+1));

        IntStream.range(0, 9)
                .forEach(n -> sudokuRow6.getElements().get(n).setValue(n+1));

        IntStream.range(0, 9)
                .forEach(n -> sudokuRow7.getElements().get(n).setValue(n+1));

        IntStream.range(0, 9)
                .forEach(n -> sudokuRow8.getElements().get(n).setValue(n+1));

        IntStream.range(0, 9)
                .forEach(n -> sudokuRow9.getElements().get(n).setValue(n+1));

        sudokuBoard.getBoard().set(0, sudokuRow1);
        sudokuBoard.getBoard().set(1, sudokuRow2);
        sudokuBoard.getBoard().set(2, sudokuRow3);
        sudokuBoard.getBoard().set(3, sudokuRow4);
        sudokuBoard.getBoard().set(4, sudokuRow5);
        sudokuBoard.getBoard().set(5, sudokuRow6);
        sudokuBoard.getBoard().set(6, sudokuRow7);
        sudokuBoard.getBoard().set(7, sudokuRow8);
        sudokuBoard.getBoard().set(8, sudokuRow9);
    }

    @Test
    public void SudokuBoardPrintTest () {
        //Given
        SudokuBoard sudokuBrd = sudokuBoard;


        System.out.println(sudokuBoard);
        //When
        int boardSize = sudokuBoard.getBoard().size();

        //Then
        assertThat(boardSize).isEqualTo(9);
    }

    @Test
    public void sudokuShallowCloneTest() throws CloneNotSupportedException {
        //Given
        SudokuBoard brd = sudokuBoard;

        //When
        SudokuBoard shallowCloneSudokuBoard = null;
        System.out.println("Original board\n" + brd);

        try {
            shallowCloneSudokuBoard = brd.shallowCopy();

        } catch (CloneNotSupportedException e) {
            System.out.println("ShallowClone ERROR!");
        }

        System.out.println("ShallowClone board\n" + shallowCloneSudokuBoard);
        System.out.println("Changing board value at Original board 2nd row 2nd line to -1 value");
        sudokuBoard.getBoard().get(1).getElements().get(1).setValue(-1);
        System.out.println("\nShallowClone board after changing Original board\n" + shallowCloneSudokuBoard);

        //Then
        assertThat(shallowCloneSudokuBoard.getBoard().get(1).getElements().get(1).getValue()).isEqualTo(-1);
        assertThat(brd.getBoard().get(1).getElements().get(1).getValue()).isEqualTo(-1);
        assertThat(shallowCloneSudokuBoard.getBoard().get(1).getElements().get(1).getValue()).isEqualTo(brd.getBoard().get(1).getElements().get(1).getValue());
    }

    @Test
    public void sudokuDeepCloneTest() throws CloneNotSupportedException {
        //Given
        SudokuBoard brd = sudokuBoard;

        //When
        SudokuBoard deepCloneSudokuBoard = null;
        System.out.println("Original board\n" + brd);

        try {
            deepCloneSudokuBoard = brd.deepCopy();

        } catch (CloneNotSupportedException e) {
            System.out.println("DeepClone ERROR!");
        }

        System.out.println("DeepClone board\n" + deepCloneSudokuBoard);
        System.out.println("Changing board value at Original board 2nd row 2nd line to -1 value");
        sudokuBoard.getBoard().get(1).getElements().get(1).setValue(-1);
        System.out.println("\nDeepClone board after changing Original board\n" + deepCloneSudokuBoard);
        System.out.println("\nOriginal board after changes\n" + brd);

        //Then
        assertThat(deepCloneSudokuBoard.getBoard().get(1).getElements().get(1).getValue()).isEqualTo(-1);
        assertThat(brd.getBoard().get(1).getElements().get(1).getValue()).isEqualTo(-1);
        assertThat(deepCloneSudokuBoard.getBoard().get(1).getElements().get(1).getValue()).isEqualTo(brd.getBoard().get(1).getElements().get(1).getValue());
    }


}
