package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        int deltaX = dest.getX() - position().getX();
        int deltaY = dest.getY() - position().getY();
        int size = Math.abs(deltaX);
        Cell[] steps = new Cell[size];
        for (int index = 0; index < size; index++) {
            if (deltaX > 0 && deltaY > 0) {
                int x = position().getX() + 1 + index;
                int y = position().getY() + 1 + index;
                steps[index] = Cell.findBy(x, y);
            } else if (deltaX < 0 && deltaY < 0) {
                int x = position().getX() - 1 - index;
                int y = position().getY() - 1 - index;
                steps[index] = Cell.findBy(x, y);
            } else if (deltaX > 0 && deltaY < 0) {
                int x = position().getX() + 1 + index;
                int y = position().getY() - 1 - index;
                steps[index] = Cell.findBy(x, y);
            } else {
                int x = position().getX() - 1 - index;
                int y = position().getY() + 1 + index;
                steps[index] = Cell.findBy(x, y);
            }
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        /* TODO check diagonal */
        int deltaX = dest.getX() - position().getX();
        int deltaY = dest.getY() - position().getY();
        return  (Math.abs(deltaX) == Math.abs(deltaY) && deltaX != 0);
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

    public static void main(String[] args) {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Cell[] array = bishop.way(Cell.C2);
        System.out.println(Arrays.toString(array));
        }

    }

