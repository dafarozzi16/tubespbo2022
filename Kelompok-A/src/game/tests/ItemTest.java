package game.tests;

import game.creature.Player;
import game.item.Weapon;
import game.item.armor.Arms;

public class ItemTest {
    public static Player player = new Player();

    public static void main(String[] args) {
        System.out.println("attack " + player.getAttack());
        System.out.println("armor " + player.getArmor());
        Weapon stick = new Weapon("Stick",10,0);
        Arms kek = new Arms("Kek", 15,1000);
        player.take(stick);
        player.take(kek);
        player.useItem(stick);
        player.useItem(kek);
        System.out.println("newattack " + player.getAttack());
        System.out.println("newarmor " + player.getArmor());
        System.out.println("weapon " + player.getWeapon());
        System.out.println("amrs " + player.getArms());


    }
}
