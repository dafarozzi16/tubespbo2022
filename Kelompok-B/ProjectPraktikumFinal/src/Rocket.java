import javax.swing.*;
import java.awt.*;

public class Rocket extends Entity{

    String name;

    public Rocket(int posX, int posY) {
        super(posX, posY);
    }

    void draw(Graphics g) {
        ImageIcon img;
        img = new ImageIcon("assets/images/Rocket.png");
        if (getPosX() > -280 && getPosX() < 280) {
            g.drawImage(img.getImage(), getPosX(), getPosY(), null);
        }
    }
}
