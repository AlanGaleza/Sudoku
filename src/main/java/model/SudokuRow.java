package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SudokuRow {

    private List<SudokuElement> elements = new ArrayList<>(9);

    protected SudokuRow() {
        IntStream.range(0, 9)
                .forEach(n -> this.elements.add(n, new SudokuElement()));
    }

    protected SudokuRow(List<SudokuElement> elements) {
        this.elements = elements;
    }

    public List<SudokuElement> getElements() {
        return elements;
    }

    public void setRow(List<SudokuElement> row) {
        this.elements = row;
    }

    @Override
    public String toString(){
        return elements.stream()
                .map(SudokuElement::toString)
                .collect(Collectors.joining());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SudokuRow sudokuRow = (SudokuRow) o;
        return Objects.equals(elements, sudokuRow.elements);
    }

    @Override
    public int hashCode() {

        return Objects.hash(elements);
    }
}
