import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BoardPanel extends JPanel {
    public static final int BOARD_SIZE = 8;
    private ArrayList<ArrayList<Square>> squares = new ArrayList<>();
    private boolean redPlayerTurn = false;

    public BoardPanel() {
        GridLayout gridLayout = new GridLayout(BOARD_SIZE, BOARD_SIZE);
        this.setLayout(gridLayout);
        boolean white = false;

        for (int i = 0; i < BOARD_SIZE; i++) {
            ArrayList<Square> currenRow = new ArrayList<>();
            for (int j = 0; j < BOARD_SIZE; j++) {
                Player player = Player.none;
                if (i < 3 || i > 4) {
                    if (!white) {
                        if (i < 3) {
                            player = Player.red;
                        } else {
                            player = Player.blue;
                        }
                    }
                }

                    Square button = new Square(white ? Color.WHITE : Color.BLACK, player);
                currenRow.add(button);
                int finalI = i;
                int finalJ = j;
                if((redPlayerTurn && button.getPlayer() == Player.red ) || (!redPlayerTurn && button.getPlayer() == Player.blue)){
                    button.addActionListener((e -> {
                        Square destination = null;
                        if(button.getPlayer() == Player.blue && !redPlayerTurn) {
                            destination = this.squares.get(finalI - 1).get(finalJ + 1);
                        }else if(button.getPlayer() ==Player.red && redPlayerTurn) {
                            destination = this.squares.get(finalI + 1).get(finalI - 1);
                        }


                        if(destination.isEmptySqaure()) {
                            button.setPlayer(Player.none);
                            button.repaint();
                            destination.setPlayer(Player.blue);
                            destination.repaint();
                        }
                        redPlayerTurn = !redPlayerTurn;

                    }));
                }
                    this.add(button);
                    white = !white;
                }
            this.squares.add(currenRow);
                white = !white;
            }

        private boolean canEat(Square attacker,Square eaten) {

        }


        }
    }
