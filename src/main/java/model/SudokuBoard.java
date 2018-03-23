package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SudokuBoard implements Cloneable{
    private List<SudokuRow> board = new ArrayList<>(9);

    public SudokuBoard() {
        IntStream.range(0, 9)
                .forEach(n -> this.board.add(new SudokuRow()));
    }

    public List<SudokuRow> getBoard() {
        return board;
    }

    public void setBoard(List<SudokuRow> board) {
        this.board = board;
    }

    public SudokuBoard shallowCopy() throws CloneNotSupportedException {
        return (SudokuBoard)super.clone();
    }

    public SudokuBoard deepCopy() throws CloneNotSupportedException {
        SudokuBoard clonedBoard = (SudokuBoard)super.clone();
        clonedBoard.board = board.stream()
                .map(row -> new SudokuRow(row.getElements().stream()
                        .map(element -> new SudokuElement())
                        .collect(Collectors.toList())))
                .collect(Collectors.toList());
        return clonedBoard;
    }

    @Override
    public String toString() {
        return board.stream()
                .map(n -> "\n" + n.toString())
                .collect(Collectors.joining());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SudokuBoard that = (SudokuBoard) o;
        return Objects.equals(board, that.board);
    }

    @Override
    public int hashCode() {

        return Objects.hash(board);
    }
}
