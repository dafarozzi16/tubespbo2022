import javax.swing.*;
import java.awt.*;

public class Asteroid extends Entity{
    public Asteroid(int posX, int posY) {
        super(posX, posY);
    }
    void draw(Graphics g) {
        ImageIcon img = new ImageIcon("assets/images/Asteroid.png");
        if (getPosX() > -280 && getPosX() < 280) {
            g.drawImage(img.getImage(), getPosX(), getPosY(), null);
        }
    }
}
