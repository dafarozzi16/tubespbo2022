package game.combat;

import game.creature.Creature;

import java.util.Random;

public class Combat {

    public static int attack(Creature attacker, Creature attacked){

        // random dmg from normal distribution
        Random random = new Random();
        int attack = attacker.getAttack();
        int potDamage = (int) Math.round(random.nextGaussian() * attack * 0.3 + attack);
        int armor = attacked.getArmor();
        int actDamage = (int) Math.ceil(potDamage * (1 - (((double) armor ) / (armor + 300))));

        if (attacked.getHp() < actDamage){
            int actDamage1 = attacked.getHp();
            attacked.lowerHp(actDamage1);
            return actDamage1;
        }
        attacked.lowerHp(actDamage);
        return actDamage;
    }

}
