import java.util.Scanner;

public class Board {

    private char[][] cells = new char[3][3];

    public Board(){

        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells.length; col++) {
                cells[row][col] = ' ';
            }
        }
        print(cells);

    }

    public char[][] getCells() {
        return cells;
    }

    public static boolean isCellEmpty( int row, int col, char[][] cells){

        boolean empty;

        if(cells[row][col] == ' '){
            empty = true;
        }else {
            empty = false;
        }
        return empty;
    }

    public static void place(int row, int col, char marker, char[][] cells){
    // where the actual placing of x or o happens

        cells[row][col] = marker;

        print(cells);
    }

    public static boolean isFull(int row, int col, char[][] cells){

        if(cells[row][col] == ' '){
            return false;
        }else{


            return true;
        }

        /*for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells.length; col++) {
                if (cells[row][col] == ' ') {
                    return false;
                }
            }
        }*/

    }

    /*public static void clear(){
    }*/

    public static void print(char[][] cells){

        System.out.println();
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells.length; col++) {
                System.out.print("    " + cells[row][col] + "    ");
                System.out.print('|');
            }
            System.out.println();
            System.out.println("   ------+---------+----------");

        }
    }


}
