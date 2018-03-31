package model;

import java.util.*;

public class SudokuElement {
    private static int EMPTY = -1;
    private int value;

    public SudokuElement(int value) {
        this.value = value;
    }

    public SudokuElement() {
        this.value = EMPTY;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
        return value == that.value;
    }

    @Override
    public int hashCode() {

        return Objects.hash(value);
    }
}
