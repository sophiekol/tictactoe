import java.util.Scanner;

public class Tictactoe {


    static private Player player1;
    static private Player player2;
    static private Player currentPlayer;
    private Board board;

    public Tictactoe() {
        this.player1 = new Player('X');
        this.player2 = new Player('O');
        this.currentPlayer = player1;
        System.out.println("    Current Player " + currentPlayer.getMarker());
    }



    public static void main(String[] args) {
        Tictactoe game = new Tictactoe();
        game.start();

    }


    public void start(){

<<<<<<< Updated upstream
        Board board1 = new Board();
=======
        this.board1 = new Board();

        while(!hasWinner(board1.getCells(), currentPlayer)) {

            Scanner scan = new Scanner(System.in);
            System.out.println(("Enter in which row you want to place ur marker(0-2)"));
            int row = scan.nextInt();

            System.out.println(("Enter in which colum you want to place ur marker(0-2)"));
            int col = scan.nextInt();


            if((row >= 0 && row <= 2) && (col >= 0 && col <= 2) && board1.getCells()[row][col] == ' '){
                Board.place(row, col, currentPlayer.getMarker(), board1.getCells());
                switchCurrentPlayer();
                hasWinner(board1.getCells(), currentPlayer);

            }else{
                System.out.println("Wrong move try again");
            }
>>>>>>> Stashed changes

        Scanner scan = new Scanner(System.in);
        System.out.println(("Enter in which row you want to place ur marker(0-2)"));
        int row = scan.nextInt();
        if(row > 2){
            System.out.println("Error row");
        }

        System.out.println(("Enter in which colum you want to place ur marker(0-2)"));
        int col = scan.nextInt();
        if(col > 2){
            System.out.println("Error col");
        }

        Board.place(row,col, currentPlayer.getMarker(), board1.getCells());
        switchCurrentPlayer();


    }


    private void switchCurrentPlayer(){
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
        System.out.println("    Current Player " + currentPlayer.getMarker());
    }

    private boolean hasWinner(char[][]cells, Player player){

        // check if player won through rows

        for(int row = 0; row < cells.length; row++ ){
            if(cells[row][0] == player.getMarker() && cells[row][1] == player.getMarker() && cells[row][2] == player.getMarker()){
                System.out.println("CONGRATS WINNER IS PLAYER:  " + currentPlayer.getMarker());
                return true;

            }
        }

        // same with colums
        for(int col = 0; col < cells.length; col++ ){
            if(cells[0][col] == player.getMarker() && cells[1][col] == player.getMarker() && cells[2][col] == player.getMarker()){
                System.out.println("CONGRATS WINNER IS PLAYER:  " + currentPlayer.getMarker());
                return true;
            }
        }

        if(cells[0][0] == player.getMarker() && cells[1][1] == player.getMarker() && cells[2][2] == player.getMarker()){
            System.out.println("CONGRATS WINNER IS PLAYER:  " + currentPlayer.getMarker());
            return true;
        }
        if ( cells[2][0] == player.getMarker() && cells[1][1] == player.getMarker() && cells[0][2] == player.getMarker()){
            System.out.println("CONGRATS WINNER IS PLAYER:  " + currentPlayer.getMarker());
            return true;
        }

        return false;

    }

}
