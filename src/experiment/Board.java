package experiment;

public class Board {
    private String[][] board;
    private static Coord middle;
    public record Coord(
            int x,
            int y
    ){}
    public Board(){
        board = new String[15][57];
        for(int i = 0; i < board.length; i++){
            for(int k = 0; k < board[0].length; k++){
                board[i][k] = "~~~";
            }
        }
        middle = findMiddle(board);
        board[middle.x][middle.y] = "MAN";
    }
    public String[][] getBoard(){
        return board;
    }
    private Coord findMiddle(String[][] board){
        int middleX = board.length/2;
        int middleY = board[0].length/2;

        // Check middle
        System.out.println("Middle is: " + middleX + ", " + middleY);

        Coord coord = new Coord(middleX,middleY);
        return coord;
    }
    public static Coord getMiddle(){
        return middle;
    }
}

