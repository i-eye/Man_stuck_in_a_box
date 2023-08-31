package experiment;

import experiment.Board;
import experiment.Movement;

public class Main {
    public static Board board = new Board();

    public static Board GetBoard(){
        return board;
    }
    public static void main(String[] args) {
        System.out.println("INITIALIZING");
        for(String[] row: board.getBoard()){
            for(String str: row){
                System.out.print(str);
            }
            System.out.println();
        }
        new Movement("Key Listener Tester");

        //"Game Loop"
        while(true){

        }
    }
}
