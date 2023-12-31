import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getMarkerWorkingRight() {

        Player player = new Player('X');

        char actualMarker = player.getMarker();

        assertEquals('X', actualMarker);
    }

    @Test
    void getMarkerWorkingForWrong() {

        Player player = new Player('X');

        char actualMarker = player.getMarker();

        assertNotEquals('O', actualMarker);
    }

    @Test
     void testConstructor() {

        char expectedMarker = 'X';

        Player player = new Player(expectedMarker);

        assertEquals(expectedMarker, player.getMarker());
    }


}