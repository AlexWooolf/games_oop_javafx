package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

public class BishopBlackTest extends TestCase {

    public void testPosition() {
        BishopBlack bishop = new BishopBlack(Cell.A1);
        assertEquals(bishop.position(), Cell.A1 );
    }

    public void testCopy() {
        BishopBlack bishop = new BishopBlack(Cell.A1);
        assertEquals((bishop.copy(Cell.B2)).position(), Cell.B2 );
    }

    public void testWay() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Cell[] rsl = bishop.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Assert.assertArrayEquals(expected, rsl);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void testWayNotDiagonal() {
        BishopBlack bishop = new BishopBlack(Cell.D1);
        bishop.way(Cell.D2);
    }
}