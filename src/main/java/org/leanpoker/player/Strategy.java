package org.leanpoker.player;

public class Strategy {

    public static int firstPhase(Card[] cardsArray, Integer buyIn) {
        return 0;
    }

    public static int secondPhase(Card[] cardsArray, Integer buyIn) {
        if (Combinations.hasPoker(cardsArray))
            return 10000;
        if (Combinations.hasDrill(cardsArray))
            return 10000;
        if (Combinations.hasFlush(cardsArray))
            return 10000;
        if (Combinations.hasStraight(cardsArray))
            return 10000;
        return 0;
    }

    public static int thirdPhase(Card[] cardsArray, Integer buyIn) {
        if (Combinations.hasPoker(cardsArray))
            return 10000;
        if (Combinations.hasDrill(cardsArray))
            return 10000;
        if (Combinations.hasFlush(cardsArray))
            return 10000;
        if (Combinations.hasStraight(cardsArray))
            return 10000;
        return 0;
    }

    public static int fourthPhase(Card[] cardsArray, Integer buyIn) {
        if (Combinations.hasPoker(cardsArray))
            return 10000;
        if (Combinations.hasDrill(cardsArray))
            return 10000;
        if (Combinations.hasFlush(cardsArray))
            return 10000;
        if (Combinations.hasStraight(cardsArray))
            return 10000;
        return 0;
    }

}
