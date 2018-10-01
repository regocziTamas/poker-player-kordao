package org.leanpoker.player;

import java.util.List;

public class Strategy {

    public static int firstPhase(Card[] cards, int currentBuyIn) {

        if(Combinations.hasPairInHand(cards) != 0){
            return currentBuyIn+25;
        }



        return 0;

    }

    public static int secondPhase(Card[] cardsArray, Integer buyIn, Integer ourstack) {
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

    public static int thirdPhase(Card[] cardsArray, Integer buyIn, Integer ourstack) {
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

    public static int fourthPhase(Card[] cardsArray, Integer buyIn, Integer ourstack) {
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
