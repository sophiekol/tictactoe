import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void theCellIsActuallyEmpty() {

        char[][] cells = {
                {' ', 'X', 'O'},
                {'O', ' ', 'X'},
                {'X', 'O', ' '}
        };

        assertTrue(Board.isCellEmpty(1,1, cells));
    }

    @Test
    void theCellIsNotEmpty(){

        char[][] cells = {
                {' ', 'X', 'O'},
                {'O', ' ', 'X'},
                {'X', 'O', ' '}
        };

        assertFalse(Board.isCellEmpty(0, 1, cells));

    }

    @Test
    void theCellIsOutOfBound(){

        char[][] cells = {
                {' ', 'X', 'O'},
                {'O', ' ', 'X'},
                {'X', 'O', ' '}
        };

        try {
            // Attempting to place a marker at an invalid index

            assertFalse(Board.isCellEmpty(0, 3, cells));
            // If no exception is thrown, fail test
            fail("Expected ArrayIndexOutOfBoundsException, but no exception was thrown.");
        } catch (ArrayIndexOutOfBoundsException e) {
            // The exception is expected, do nothing
        }

    }


    @Test
    void placingCorrectlyOnBoarder() {

        int row = 0;
        int col = 0;

        char marker = 'X';

        char[][] cells = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        Board.place(row, col, marker, cells);

        char[][] expected_cells = {
                {'X', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        assertArrayEquals(expected_cells, cells);

    }

    @Test
    void placingCorrectlyInTheMiddle() {

        int row = 1;
        int col = 1;

        char marker = 'O';

        char[][] cells = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        Board.place(row, col, marker, cells);

        char[][] expected_cells = {
                {' ', ' ', ' '},
                {' ', 'O', ' '},
                {' ', ' ', ' '}
        };

        assertArrayEquals(expected_cells, cells);

    }

    @Test
    void placingOutOfBound() {

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
            Board.place(row,col, marker, cells);

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

        char[][] cells = {
                {' ', 'X', 'O'},
                {'O', ' ', 'X'},
                {'X', 'O', ' '}
        };

        assertFalse(Board.isFull(cells));

    }

    @Test
    void BoardIsFull() {

        char[][] cells = {
                {'X', 'X', 'O'},
                {'O', 'O', 'X'},
                {'X', 'O', 'O'}
        };

        assertTrue(Board.isFull(cells));

    }

    @Test
    void clearBoardOfFullCells() {

        char[][] cells = {
                {'X', 'X', 'O'},
                {'O', 'O', 'X'},
                {'X', 'O', 'O'}
        };

        char[][] expected_cells = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        Board.clear(cells);

        assertArrayEquals(expected_cells, cells);

    }


}