package org.leanpoker.player;

import java.util.List;

public class Strategy {

    public static int firstPhase(Card[] cards, int currentBuyIn) {

        if(Combinations.hasPairInHand(cards) != 0){
            return currentBuyIn+25;
        }

        if(Combinations.checkForAceAndKing(cards)){
            return currentBuyIn;
        }



        return 0;

    }

    public static int secondPhase(Card[] cardsArray, Integer buyIn, Integer ourStack) {
        if (Combinations.hasPoker(cardsArray))
            return 10000;
        if (Combinations.hasDrill(cardsArray))
            return (int) Math.round(ourStack*0.2);
        if (Combinations.hasFlush(cardsArray))
            return 10000;
        if (Combinations.hasStraight(cardsArray))
            return (int) Math.round(ourStack*0.5);
        if (Combinations.hasFull(cardsArray))
            return (int) Math.round(ourStack*1);


        return 0;
    }

    public static int thirdPhase(Card[] cardsArray, Integer buyIn, Integer ourStack) {
        if (Combinations.hasPoker(cardsArray))

            return (int) Math.round(ourStack*1);
        if (Combinations.hasFlush(cardsArray))
            return (int) Math.round(ourStack*0.7);
        if (Combinations.hasFull(cardsArray))
            return (int) Math.round(ourStack*0.7);
        if (Combinations.hasStraight(cardsArray))
            return (int) Math.round(ourStack*0.5);

        return 0;
    }

    public static int fourthPhase(Card[] cardsArray, Integer buyIn, Integer ourStack) {
        if (Combinations.hasPoker(cardsArray))
            return (int) Math.round(ourStack*1);
        if (Combinations.hasFlush(cardsArray))
            return (int) Math.round(ourStack*0.5);
        if (Combinations.hasFull(cardsArray))
            return (int) Math.round(ourStack*0.5);
        if (Combinations.hasStraight(cardsArray))
            return (int) Math.round(ourStack*0.5);

        return 0;
    }

}
