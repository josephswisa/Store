import javax.swing.*;


public class Checkers extends JFrame {
    public static final int WINDOW_WIDTH =600;
    public static final int WINDOW_HEIGHT = 600;


    public static void main(String[] args) {
        new Checkers();

    }

    public Checkers ()
    {
        BoardPanel boardPanel = new BoardPanel();
        this.add(boardPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        this.setResizable(false);
        this.setVisible(true);


    }
}
