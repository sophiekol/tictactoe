
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class TictactoeTest {

    // start consists only of all the other methods and System.ou Statements

    @Test
    void switchCurrentPlayerWorkingRightWithOverFalse() {
        new Tictactoe();

        Tictactoe.switchCurrentPlayer(false);

        assertEquals(Tictactoe.player2.getMarker(), Tictactoe.currentPlayer.getMarker());
        // current player should be O after that
    }

    @Test
    void switchCurrentPlayerWorkingRightWithOverTrue() {
        new Tictactoe();

        Tictactoe.switchCurrentPlayer(true);

        assertEquals(Tictactoe.player1.getMarker(), Tictactoe.currentPlayer.getMarker());
        //game is over so marker stays the same
    }

    @Test
    void switchCurrentPlayerWorkingWithOAsCurrentPlayer() {

        new Tictactoe();

        Tictactoe.switchCurrentPlayer(false);
        // 0 is current player
        Tictactoe.switchCurrentPlayer(false);

        assertNotEquals(Tictactoe.player2.getMarker(), Tictactoe.currentPlayer.getMarker());
        // current player should be X


    }

    @Test
    void hasWinnerFalseAllCellsEmpty() {

        Player player = new Player('X');

        char[][] cells = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        assertFalse(Tictactoe.hasWinner(cells, player));
    }

    @Test
    void hasWinnerThroughRows() {

        char[][] cells = {
                {'X', 'X', 'X'},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        Player player = new Player('X');

        assertTrue(Tictactoe.hasWinner(cells, player));
    }

    @Test
    void hasWinnerThroughCols() {

        char[][] cells = {
                {' ', 'X', 'O'},
                {' ', 'X', ' '},
                {' ', 'X', 'O'}
        };

        Player player = new Player('X');

        assertTrue(Tictactoe.hasWinner(cells, player));
    }

    @Test
    void hasWinnerThroughDiagonal() {

        char[][] cells = {
                {'O', 'O', 'X'},
                {' ', 'O', 'O'},
                {'X', 'X', 'O'}
        };

        Player player = new Player('O');

        assertTrue(Tictactoe.hasWinner(cells, player));
    }

    @Test
    void hasWinnerThroughOtherDiagonal() {

        char[][] cells = {
                {'X', 'X', 'O'},
                {' ', 'O', ' '},
                {'O', ' ', ' '}
        };

        Player currentPlayer = new Player('O');

        assertTrue(Tictactoe.hasWinner(cells, currentPlayer));
    }

    @Test
    void hasWinnerIsTie() {

        char[][] cells = {
                {'X', 'O', 'O'},
                {'O', 'X', 'X'},
                {'O', 'X', 'O'}
        };

        Player currentPlayer = new Player('O');
        Player other = new Player('X');

        assertFalse(Tictactoe.hasWinner(cells, currentPlayer));
        assertFalse(Tictactoe.hasWinner(cells, other));

    }

    @Test
    void hasWinnerFalse() {

        Player player = new Player('X');

        char[][] cells = {
                {' ', 'X', ' '},
                {'X', 'O', 'O'},
                {'O', ' ', 'X'}
        };

        assertFalse(Tictactoe.hasWinner(cells, player));
    }


}