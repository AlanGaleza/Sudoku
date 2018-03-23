import model.SudokuBoard;
import model.SudokuElement;
import model.SudokuRow;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class SudokuTestSuite {

    @Test
    public void SudokuRowPrintTest () {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        SudokuRow sudokuRow = new SudokuRow();
        SudokuElement sudokuElement1 = new SudokuElement(1);
        SudokuElement sudokuElement2 = new SudokuElement(-1);
        SudokuElement sudokuElement3 = new SudokuElement(3);
        SudokuElement sudokuElement4 = new SudokuElement(4);
        SudokuElement sudokuElement5 = new SudokuElement(5);
        SudokuElement sudokuElement6 = new SudokuElement(6);
        SudokuElement sudokuElement7 = new SudokuElement(7);
        SudokuElement sudokuElement8 = new SudokuElement(8);
        SudokuElement sudokuElement9 = new SudokuElement(9);

        sudokuRow.getRow().add(sudokuElement1);
        sudokuRow.getRow().add(sudokuElement2);
        sudokuRow.getRow().add(sudokuElement3);
        sudokuRow.getRow().add(sudokuElement4);
        sudokuRow.getRow().add(sudokuElement5);
        sudokuRow.getRow().add(sudokuElement6);
        sudokuRow.getRow().add(sudokuElement7);
        sudokuRow.getRow().add(sudokuElement8);
        sudokuRow.getRow().add(sudokuElement9);


        System.out.println(sudokuBoard.getBoard().size());
        //System.out.println(sudokuRow);
        //When

        //Then
        //assertThat(result).isEqualTo(9);
    }


}
