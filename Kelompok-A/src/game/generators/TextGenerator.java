package game.generators;

import java.util.Random;

public class TextGenerator {
    Random rand = new Random();

    public static String weather(){
        Random rand = new Random();
        String[] weather = {"SUNNY", "A LITTLE WINDY", "A LITTLE RAINY", "A LITTLE CLOUDY", "A BIT CHILLY",
        "PRETTY WARM", "REALLY SUNNY", "CLOUDY", "WINDY", "FOGGY", "RAINY"};
        return weather[rand.nextInt(weather.length)];
    }

    public static String emotionHappy(){
        Random rand = new Random();
        String[] emotion = {"HAPPY", "CAREFREE", "UPBEAT", "CHEERFUL", "CALM",
                "PEACEFUL", "LIVELY", "AMICABLE", "SHIFTY", "ANIMATED", "AMIABLE"};
        return emotion[rand.nextInt(emotion.length)];
    }

    public static String emotionAfterPlainsBoss(){
        Random rand = new Random();
        String[] emotion = {"QUIET", "CONFUSED", "SHIFTY", "SUSPICIOUS", "RUFFLED",
                "AGITATED", "LIVELY", "AMICABLE", "AMIABLE"};
        return emotion[rand.nextInt(emotion.length)];
    }

    public static String emotionAfterForestBoss(){
        Random rand = new Random();
        String[] emotion = {"HUSHED", "SCARED", "RUFFLED", "AFRAID", "ANXIOUS",
                "STARTLED", "SHAKEN", "QUIET", "HARRIED", "MUTED"};
        return emotion[rand.nextInt(emotion.length)];
    }

    public static String emotion(boolean boss1, boolean boss2){
        String emotion = emotionHappy();
        if (boss1) emotion = emotionAfterPlainsBoss();
        if (boss2) emotion = emotionAfterForestBoss();
        return emotion;
    }

    public static String randomPersonSlashGroup(){
        Random rand = new Random();
        String[] person = { "A DRUNK MIDGET", "A GAGGLE OF DRUNK STUDENTS", "A PRETTY LADY IN A RED DRESS",
                "A SUSPICIOUS-LOOKING MAN IN A BLACK COAT", "A DUDE WITH SOME COOL SHADES", "A GROUP OF PRETTY LADIES",
                "A SHORT LADY", "AN ENORMOUS MAN", "A BURLY DUDE", "A GROUP OF BURLY DUDES", "A GROUP OF BURLY LADIES"};
        return person[rand.nextInt(person.length)];
    }

    public static String taste(){
        Random rand = new Random();
        String[] taste = {"GREAT", "ALRIGHT", "DECENT", "SO-SO", "LIKE SHIT",
                "ACCEPTABLE", "FINE", "EXCEPTIONAL", "AMAZING", "INCREDIBLE", "HORRIBLE"};
        return taste[rand.nextInt(taste.length)];
    }

    public static String bedOrPillowDescription(){
        Random rand = new Random();
        String[] desc = {"SOFT", "COMFORTABLE", "LUMPY", "FLUFFY", "TOO SOFT",
                "TOO HARD", "WEIRDLY MOIST", "COZY", "CUSHY", "SOMEWHAT DAMP"};
        return desc[rand.nextInt(desc.length)];

    }

    public static String sound(){
        Random rand = new Random();
        String[] sound = {"WIND HOWLING", "CRICKETS SINGING", "BIRDS SINGING", "SOMEBODY WHISTLING",
                "FAINT PITTER-PATTER OF THE RAIN", "DOGS BARKING", "A MYSTERIOUS TUNE"};
        return sound[rand.nextInt(sound.length)];

    }

    public static String trait(){
        Random rand = new Random();
        String[] desc = {"ARTSY", "MELODRAMATIC", "HAPPY-GO-LUCKY", "AIRHEADED", "COURAGEOUS",
                "ADVENTUROUS", "SHY", "CAREFREE", "CHEERFUL", "NAIVE"};
        return desc[rand.nextInt(desc.length)];

    }

    public static String traitTwo(){
        Random rand = new Random();
        String[] desc = {"DEPENDABLE", "DECISIVE", "CONSIDERATE", "YOUTHFUL",
                "SPONTANEOUS", "BOLD", "ECCENTRIC", "RESTLESS", "INDEPENDENT"};
        return desc[rand.nextInt(desc.length)];

    }

    public static String hobby(){
        Random rand = new Random();
        String[] desc = {"COOKING", "KAYAKING", "WRITING",
                "DRAWING", "RUNNING", "DANCING", "FIGHTING", "PAINTING",
                "SINGING", "BAKING", "MAKING PIES"};
        return desc[rand.nextInt(desc.length)];
    }

    public static String hobbyTwo(){
        Random rand = new Random();
        String[] desc = {"ORIGAMI", "POETRY", "FLOWER ARRANGING", "PLAY WRITING",
                "PALM READING", "PUPPETRY", "JUGGLING", "BIRDWATCHING", "COLLECTING STUFF",
                "ACROBATICS", "SAILING", "FISHING"};
        return desc[rand.nextInt(desc.length)];

    }

    public static String job(){
        Random rand = new Random();
        String[] desc = {"ARTIST", "SLAM POET", "DANCER", "RAPPER",
                "MAGICIAN", "ORNITHOLOGIST", "ASTRONOMER", "FORTUNE TELLER", "COSMONAUT",
                "FASHION DESIGNER", "COMEDIAN", "ACTOR"};
        return desc[rand.nextInt(desc.length)];

    }

    public static String age(){
        Random rand = new Random();
        String[] desc = {"YOUNG", "OLD", "JUVENILE", "ADULT",
                "MIDDLE AGED", "TEENAGED", "ADOLESCENT"};
        return desc[rand.nextInt(desc.length)];

    }

    public static String gender(){
        Random rand = new Random();
        String[] desc = {"FEMALE", "MALE", "BEING OF UNDISCLOSED GENDER"};
        return desc[rand.nextInt(desc.length)];

    }

    public static String drink(){
        Random rand = new Random();
        String[] drink = {"BEER", "BLOODY MARY", "TONIC AND GIN", "WHISKEY ON ROCKS", "MALIBU",
                        "WHITE RUSSIAN", "GLASS OF WINE", "MEAD", "CIDER", "SHOT OF VODKA", "CUP OF SAKE",
                    "MOHITO", "BOTTLE OF RUM", "MARTINI", "COSMOPOLITAN", "LONG ISLAND ICED TEA"};
        return drink[rand.nextInt(drink.length)];

    }


}
