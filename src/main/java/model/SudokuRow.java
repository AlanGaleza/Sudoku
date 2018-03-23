package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SudokuRow {

    private List<SudokuElement> row = new ArrayList<>(9);
    private SudokuElement sudokuElement;

    public SudokuRow() {
    }

    public List<SudokuElement> getRow() {
        return row;
    }

    public void setRow(List<SudokuElement> row) {
        this.row = row;
    }

    public SudokuElement getSudokuElement() {
        return sudokuElement;
    }

    public void setSudokuElement(SudokuElement sudokuElement) {
        this.sudokuElement = sudokuElement;
    }

    @Override
    public String toString(){
        return row.stream()
                .map(n -> n.toString())
                .collect(Collectors.joining());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SudokuRow sudokuRow = (SudokuRow) o;
        return Objects.equals(row, sudokuRow.row) &&
                Objects.equals(sudokuElement, sudokuRow.sudokuElement);
    }

    @Override
    public int hashCode() {

        return Objects.hash(row, sudokuElement);
    }
}
