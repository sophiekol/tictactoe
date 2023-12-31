import java.util.Scanner;

public class Tictactoe {

    static protected Player player1;
    static protected Player player2;
    static protected Player currentPlayer;
    static protected Board board1;

    public Tictactoe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        System.out.println("    Current Player " + currentPlayer.getMarker());

        board1 = new Board();
    }



    public static void main(String[] args) {

        Tictactoe game = new Tictactoe();
        game.start();

    }


    public void start(){

        boolean over = false;

        while(!over){
            Scanner scan = new Scanner(System.in);
            System.out.println(("Enter in which row you want to place ur marker(0-2)"));
            int row = scan.nextInt();

            System.out.println(("Enter in which colum you want to place ur marker(0-2)"));
            int col = scan.nextInt();

            if ((row >= 0 && row <= 2) && (col >= 0 && col <= 2) && Board.isCellEmpty(row, col, board1.getCells())) {
                Board.place(row, col, currentPlayer.getMarker(), board1.getCells());
                over = hasWinner(board1.getCells(), currentPlayer);
                switchCurrentPlayer(over);

            } else {
                System.out.println("Wrong move try again");
            }

            if(Board.isFull(board1.getCells()) && !over){
                System.out.println();
                System.out.println("  The Game ended in a tie!");
            }
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("Do you want to restart game? y/n");
        char decision = scan.next().charAt(0);

        if(decision == 'Y' || decision == 'y'){
            Board.clear(board1.getCells());
            Tictactoe game = new Tictactoe();
            game.start();
        }else {
            System.out.println("  Thank you for playing!");

        }

    }

    protected static void switchCurrentPlayer(boolean over){
        if(!over) {
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
            System.out.println("    Current Player " + currentPlayer.getMarker());
        }
    }

    protected static boolean hasWinner(char[][] cells, Player currentPlayer){

        // check if player won through rows
        for(int row = 0; row < cells.length; row++ ){
            if(cells[row][0] == currentPlayer.getMarker() && cells[row][1] == currentPlayer.getMarker() && cells[row][2] == currentPlayer.getMarker()){
                System.out.println("  CONGRATS WINNER IS PLAYER:  " + currentPlayer.getMarker());
                return true;
            }
        }

        // same with cols
        for(int col = 0; col < cells.length; col++ ){
            if(cells[0][col] == currentPlayer.getMarker() && cells[1][col] == currentPlayer.getMarker() && cells[2][col] == currentPlayer.getMarker()){
                System.out.println("  CONGRATS WINNER IS PLAYER:  " + currentPlayer.getMarker());
                return true;
            }
        }

        if(cells[0][0] == currentPlayer.getMarker() && cells[1][1] == currentPlayer.getMarker() && cells[2][2] == currentPlayer.getMarker()){
            System.out.println("  CONGRATS WINNER IS PLAYER:  " + currentPlayer.getMarker());
            return true;
        }
        if ( cells[2][0] == currentPlayer.getMarker() && cells[1][1] == currentPlayer.getMarker() && cells[0][2] == currentPlayer.getMarker()){
            System.out.println("  CONGRATS WINNER IS PLAYER:  " + currentPlayer.getMarker());
            return true;
        }

        return false;

    }

}
