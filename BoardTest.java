import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void theCellIsActuallyEmpty() {

        var board = new Board();

        char[][] cells = {
                {' ', 'X', 'O'},
                {'O', ' ', 'X'},
                {'X', 'O', ' '}
        };

        assertTrue(board.isCellEmpty(1,1, cells));
    }

    @Test
    void theCellIsNotEmpty(){
        var board = new Board();

        char[][] cells = {
                {' ', 'X', 'O'},
                {'O', ' ', 'X'},
                {'X', 'O', ' '}
        };

        assertFalse(board.isCellEmpty(0, 1, cells));

    }

    @Test
    void theCellIsOutOfBound(){
        var board = new Board();

        char[][] cells = {
                {' ', 'X', 'O'},
                {'O', ' ', 'X'},
                {'X', 'O', ' '}
        };

        try {
            // Attempting to place a marker at an invalid index

            assertFalse(board.isCellEmpty(0, 3, cells));
            // If no exception is thrown, fail test
            fail("Expected ArrayIndexOutOfBoundsException, but no exception was thrown.");
        } catch (ArrayIndexOutOfBoundsException e) {
            // The exception is expected, do nothing
        }

    }


    @Test
    void placingCorrectlyOnBoarder() {
        var board = new Board();

        int row = 0;
        int col = 0;

        char marker = 'X';

        char[][] cells = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        board.place(row, col, marker, cells);

        char[][] expected_cells = {
                {'X', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        assertArrayEquals(expected_cells, cells);

    }

    @Test
    void placingCorrectlyInTheMiddle() {
        var board = new Board();

        int row = 1;
        int col = 1;

        char marker = 'O';

        char[][] cells = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        board.place(row, col, marker, cells);

        char[][] expected_cells = {
                {' ', ' ', ' '},
                {' ', 'O', ' '},
                {' ', ' ', ' '}
        };

        assertArrayEquals(expected_cells, cells);

    }

    @Test
    void placingOutOfBound() {
        var board = new Board();

        int row = 3;
        int col = 1;

        char marker = 'X';

        char[][] cells = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };


        try {
            // Attempting to place a marker at an invalid index
            board.place(3, 0, marker, cells);

            // If no exception is thrown, fail test
            fail("Expected ArrayIndexOutOfBoundsException, but no exception was thrown.");
        } catch (ArrayIndexOutOfBoundsException e) {
            // The exception is expected, do nothing
        }

        char[][] expected_cells = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        assertArrayEquals(expected_cells, cells);

    }

    @Test
    void BoardIsNotFull() {
        var board = new Board();

        char[][] cells = {
                {' ', 'X', 'O'},
                {'O', ' ', 'X'},
                {'X', 'O', ' '}
        };

        assertFalse(board.isFull(cells));

    }

    @Test
    void BoardIsFull() {
        var board = new Board();

        char[][] cells = {
                {'X', 'X', 'O'},
                {'O', 'O', 'X'},
                {'X', 'O', 'O'}
        };

        assertTrue(board.isFull(cells));

    }

}