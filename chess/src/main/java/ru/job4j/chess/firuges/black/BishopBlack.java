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
        int deltaX = -1;
        int deltaY = -1;
        if ((dest.getX() - position().getX()) > 0) {
            deltaX = 1;
        }
        if ((dest.getY() - position().getY()) > 0) {
            deltaY = 1;
        }
        int size = Math.abs(dest.getX() - position().getX());
        Cell[] steps = new Cell[size];
        int x = position().getX();
        int y = position().getY();
        for (int index = 0; index < size; index++) {
            x = x += deltaX;
            y = y += deltaY;
                steps[index] = Cell.findBy(x, y);
            }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return  ((Math.abs(dest.getX() - source.getX())
                == Math.abs(dest.getY() - source.getY()) && (dest.getX() - source.getX() != 0)));
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}

