package game.tests;

import game.item.Item;
import game.generators.ItemGenerator;
import java.util.Random;


public class ItemGeneratorTest {
    public static void main (String[]args) {
        Random rand = new Random();
        Item testitem = ItemGenerator.items().get(rand.nextInt(ItemGenerator.items().size()));
        System.out.println( testitem.toString() );
        ItemGenerator.descriptor(testitem);
        System.out.println(testitem + "\n\n");

        //fin
        Item testItem1 = ItemGenerator.newItem();
        System.out.println( testItem1 );

        //priceRange
        Item testItem2 = ItemGenerator.newItemPriceRange(0, 10);
        System.out.println( testItem2 );

        //priceRange + has sword in its name
        Item testItem3 = ItemGenerator.newItemPriceRangeAndName(5, 10, "sword");
        System.out.println( testItem3 );

        //priceRange Armor
        Item testItem4 = ItemGenerator.newItemPriceRangeWeapon(1000, 10000);
        System.out.println( testItem4 );


    }
}
