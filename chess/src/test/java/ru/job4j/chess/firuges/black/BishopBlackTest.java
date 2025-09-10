package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.*;

class BishopBlackTest {

    @Test
    void testPosition() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Cell expected = Cell.C1;
        assertThat(bishop.position()).isEqualTo(expected);
    }

    @Test
    void testCopy() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Figure copied = bishop.copy(Cell.D2);
        assertThat(copied.position()).isEqualTo(Cell.D2);
    }

    @Test
    void testWay() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(bishop.way(Cell.G5)).isEqualTo(expected);
    }

    @Test
    void testWayNotDiagonal() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        assertThatThrownBy(() -> bishop.way(Cell.C2))
                .isInstanceOf(ImpossibleMoveException.class)
                .hasMessageContaining("Could not move by diagonal");
    }

    @Test
    void testIsDiagonalTrue() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        assertThat(bishop.isDiagonal(Cell.C1, Cell.G5)).isTrue();
    }

    @Test
    void testIsDiagonalFalse() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        assertThat(bishop.isDiagonal(Cell.C1, Cell.C2)).isFalse();
    }
}

