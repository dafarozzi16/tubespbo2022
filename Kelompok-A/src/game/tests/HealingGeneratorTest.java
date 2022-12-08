package game.tests;

import game.item.Healing;
import game.generators.HealingGenerator;

public class HealingGeneratorTest {
    public static void main(String[] args) {
        //random
        Healing testHealing1 = HealingGenerator.newHealing();
        System.out.println( testHealing1 );

        //potion
        Healing testHealing2 = HealingGenerator.newPotion();
        System.out.println( testHealing2 );

        //PriceRange
        Healing testHealing3 = HealingGenerator.newHealingPriceRange(0,20);
        System.out.println( testHealing3 );

        //PriceRange and Name
        Healing testHealing4 = HealingGenerator.newHealingPriceRangeAndName(0,100, "meat");
        System.out.println( testHealing4 );

    }
}
