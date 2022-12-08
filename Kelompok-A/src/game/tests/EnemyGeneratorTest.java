package game.tests;

import game.creature.Enemy;
import game.generators.EnemyGenerator;

import java.util.ArrayList;
import java.util.Random;


public class EnemyGeneratorTest {
    public static void main (String[]args) {
        Random rand = new Random();
        ArrayList<Enemy> testEnemies = EnemyGenerator.plains();
        Enemy testenemy = EnemyGenerator.plains().get(rand.nextInt(EnemyGenerator.plains().size()));
        System.out.println( testenemy.toString() );
        EnemyGenerator.descriptor(testenemy);
        System.out.println(testenemy );

        //fin plains
        Enemy testEnemy1 = EnemyGenerator.plainsEnemy();
        System.out.println( testEnemy1 );

        //forest
        Enemy testEnemy2 = EnemyGenerator.forestEnemy();
        System.out.println( testEnemy2 );

        //ExpRange and names
        Enemy testEnemy3 = EnemyGenerator.forestEnemyName("soldier");
        System.out.println( testEnemy3 );

        //mountain
        Enemy testEnemy4 = EnemyGenerator.mountainEnemyName("titanic");
        System.out.println( testEnemy4 );
    }
}
