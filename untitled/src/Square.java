import com.sun.org.apache.xpath.internal.objects.XBoolean;

import javax.swing.*;
import java.awt.*;

public class Square extends JButton {
    private Color color;
    private Player player;

    public Square (Color color, Player player){
        this.color = color;
        this.player = player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(this.color);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        switch (this.player) {
            case red:
                g.setColor(Color.RED);
                g.fillOval(10, 10, this.getWidth() - 20, this.getHeight() - 20);
                break;
            case blue:
                g.setColor(Color.BLUE);
                g.fillOval(10, 10, this.getWidth() - 20, this.getHeight() - 20);
                break;
            case none:
                break;
        }
    }

        public boolean isEmptySqaure() {
            return this.player == player.none;
        }
    }

