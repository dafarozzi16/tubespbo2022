package game.generators;

import game.creature.Player;

import java.util.Random;

public class QuestGenerator {

    public static String newQuest(Player player) {
        int exp = (int) Math.floor(player.getExp());
        String name;
        if (!player.killedPlainsBoss()) {
            name = EnemyGenerator.plainsEnemyExpRange(exp / 2, exp + 2).getRace();
            player.setWhereQuest("PLAINS");
        } else if (!player.killedForestBoss()) {
            name = EnemyGenerator.forestEnemyExpRange(exp / 2, exp + 2).getRace();
            player.setWhereQuest("FOREST");
        } else {
            name = EnemyGenerator.mountainEnemyExpRange(exp / 2, exp + 2).getRace();
            player.setWhereQuest("MOUNTAINS");
        }
        Random random = new Random();
        int howMany = random.nextInt(11) + 5; // 5-15
        player.setCurrentQuest(name);
        player.resetQuestCount();
        player.setMaxQuestCount(howMany);
        return name;
    }

}
