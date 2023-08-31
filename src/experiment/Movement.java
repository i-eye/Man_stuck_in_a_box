package experiment;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Movement extends JFrame implements KeyListener {
    JLabel label;

    public Movement(String s) {
        super(s);
        JPanel p = new JPanel();
        label = new JLabel("Click here to move!");
        p.add(label);
        add(p);
        addKeyListener(this);
        setSize(200, 100);
        setVisible(true);

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            move("right");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            move("left");
        }
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
            move("up");
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
            move("down");
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    private Board.Coord playerPosition = Board.getMiddle();
    public void setPlayerPosition(int x, int y){
        playerPosition = new Board.Coord(x,y);
    }
    private String[][] board = Main.board.getBoard();

    public void move(String direction){
        Board.Coord lastPlayerPosition = playerPosition;

        try {
            // Update playerPos
            switch (direction.toLowerCase()) {
                case "right":
                    setPlayerPosition(playerPosition.x(), playerPosition.y() + 1);
                    //remove these later
                    System.out.println(playerPosition);
                    break;
                case "left":
                    setPlayerPosition(playerPosition.x(), playerPosition.y() - 1);
                    System.out.println(playerPosition);
                    break;
                case "up":
                    setPlayerPosition(playerPosition.x() - 1, playerPosition.y());
                    System.out.println(playerPosition);
                    break;
                case "down":
                    setPlayerPosition(playerPosition.x() + 1, playerPosition.y());
                    System.out.println(playerPosition);
                    break;
                default:
                    System.out.println("DIRECTION ISSUE. CHECK MOVEMENT.");
                    System.exit(-1);

            }
            // Spawn player to new position
            board[playerPosition.x()][playerPosition.y()] = "MAN";
            // Make current playerstate empty
            board[lastPlayerPosition.x()][lastPlayerPosition.y()] = "~~~";
        } catch (Exception e){
            System.out.println("cant go out of bounds");
            playerPosition = lastPlayerPosition;
        }
        //TEST
        for(String[] row: board){
            for(String str: row){
                System.out.print(str);
            }
            System.out.println();
        }
    }
}
