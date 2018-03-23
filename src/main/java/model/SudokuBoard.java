package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SudokuBoard {
    private SudokuRow sudokuRow;
    private List<SudokuRow> board = new ArrayList<>(9);

    public SudokuBoard() {
            List<Boolean> b = IntStream.range(1, 10)
                    .map(n -> board.add(new SudokuRow()))
                    .collect(Collectors.toList());
    }
/*
this.registers = IntStream.range(0, this.numberOfSuppliers)
            .map(i -> {
        Supplier supplier = new Supplier();
        supplier.setSupplierNumber(i);
        supplier.setMaterials(new ArrayList<Warehouse>());
        return supplier;
    })

            .collect(Collectors.toList());
*/

    public List<SudokuRow> getBoard() {
        return board;
    }

    /*    public Board deepCopy1() throws CloneNotSupportedException {
        Board clonedBoard = super.clone();
        clonedBoard.lists = lists.stream().map(tasksList -> new TasksList(tasksList.getName(), tasksList.getTasks().stream().map(task -> new Task(task.getName())).collect(Collectors.toList()))).collect(Collectors.toSet());
        return clonedBoard;
    }*/
}
