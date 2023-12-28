public class Board {


    public static void main(String[] args){

        char[][] cells = new char[3][3];
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells.length; col++) {
                cells[row][col] = '1';
            }
        }
        print(cells);
    }

    public static boolean isCellEmpty( int row, int col, char[][] cell){

        boolean empty;

        if(cell[row][col] == ' '){
            empty = true;
        }else {
            empty = false;
        }
        return empty;
    }

    public static void place(int row, int col, char marker, char[][] cell){
    // where the actual placing of x or o happens

        cell[row][col] = marker;
    }

    public static boolean isFull(char[][] cells){

        boolean isFull = true;
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells.length; col++) {
                if (cells[row][col] == ' ') {
                    isFull = false;
                    break;
                }
            }
        }
        return isFull;
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
