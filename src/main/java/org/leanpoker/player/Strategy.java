package org.leanpoker.player;

public class Strategy {

    public static int firstPhase(Card[] cardsArray, Integer buyIn, Integer ourStack) {
        return 0;
    }

    public static int secondPhase(Card[] cardsArray, Integer buyIn, Integer ourStack) {
        if (Combinations.hasPoker(cardsArray))
            return ourStack;
        if (Combinations.hasDrill(cardsArray))
            return ourStack;
        if (Combinations.hasFlush(cardsArray))
            return ourStack;
        if (Combinations.hasStraight(cardsArray))
            return ourStack;
        return 0;
    }

    public static int thirdPhase(Card[] cardsArray, Integer buyIn, Integer ourStack) {
        if (Combinations.hasPoker(cardsArray))
            return ourStack;
        if (Combinations.hasDrill(cardsArray))
            return ourStack;
        if (Combinations.hasFlush(cardsArray))
            return ourStack;
        if (Combinations.hasStraight(cardsArray))
            return ourStack;
        return 0;
    }

    public static int fourthPhase(Card[] cardsArray, Integer buyIn, Integer ourStack) {
        if (Combinations.hasPoker(cardsArray))
            return ourStack;
        if (Combinations.hasDrill(cardsArray))
            return ourStack;
        if (Combinations.hasFlush(cardsArray))
            return ourStack;
        if (Combinations.hasStraight(cardsArray))
            return ourStack;
        return 0;
    }

}
