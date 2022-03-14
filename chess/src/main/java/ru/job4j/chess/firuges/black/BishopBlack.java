package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

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
        int size = 0;
        Cell[] steps = new Cell[size];
        int deltaX = dest.getX() - position().getX();
        int deltaY = dest.getY() - position().getY();
        if (Math.abs(deltaX) > Math.abs(deltaY)) {
            size = Math.abs(deltaX);
        } else {
            size = Math.abs(deltaY);
            }
        for (int index = 0; index < size; index++) {
            steps[index] = ...
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        /* TODO check diagonal */
        return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
