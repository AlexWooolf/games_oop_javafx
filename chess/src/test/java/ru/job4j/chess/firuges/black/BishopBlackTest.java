package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import ru.job4j.chess.firuges.Cell;

public class BishopBlackTest extends TestCase {

    public void testPosition() {
        BishopBlack bishop = new BishopBlack(Cell.A1);
        assertEquals(bishop.position(), Cell.A1 );
    }

    public void testCopy() {
        BishopBlack bishop = new BishopBlack(Cell.A1);
        bishop.copy(Cell.B2);

        assertEquals((bishop.copy(Cell.B2)).position(), Cell.B2 );
    }

    public void testWay() {

    }
}