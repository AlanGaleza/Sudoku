package model;

import java.util.*;
import java.util.stream.IntStream;

public class SudokuElement {
    private static int EMPTY = -1;
    private int value;
    private List<Integer> possibleValue = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

    public SudokuElement(int value) {
        this.value = value;
    }

    public SudokuElement() {
        this.value = EMPTY;
    }

    public void removeValueFromPossibleValueList(int value) {
        if (possibleValue.stream().anyMatch(n -> n == value)) {
            IntStream.range(0, possibleValue.size()-1)
                    .filter(n -> possibleValue.get(n) == value)
                    .map(possibleValue::remove)
                    .count();
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Integer> getPossibleValue() {
        return possibleValue;
    }

    @Override
    public String toString() {
        return value == EMPTY ? EMPTY + "|" : " " + value + "|";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SudokuElement that = (SudokuElement) o;
        return value == that.value &&
                Objects.equals(possibleValue, that.possibleValue);
    }

    @Override
    public int hashCode() {

        return Objects.hash(value, possibleValue);
    }
}
