package game.engine;

public class Helper {
    public static boolean startsWithVowel(String string) {
        boolean flag = false;
        string = string.toLowerCase();
        string = string.substring(0,1);
        if(string.equals("a") || string.equals("e") || string.equals("i") ||
                string.equals("o") || string.equals("u") || string.equals("y")) flag = true;
        return flag;
    }
}
