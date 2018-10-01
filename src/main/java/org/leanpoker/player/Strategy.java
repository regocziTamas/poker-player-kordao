package org.leanpoker.player;

import java.util.List;

public class Strategy {

    public static int firstPhase(Card[] cards, Integer currentBuyIn, Integer ourStack) {

        if(Combinations.hasPairInHand(cards) != 0){
            if (currentBuyIn < ourStack*0.1)
                return currentBuyIn+25;
        }

        if(Combinations.checkForAceAndKing(cards)){
            if (currentBuyIn < ourStack*0.20)
            return currentBuyIn + Math.min(ourStack,10);
        }

        if(Combinations.hasQuiteGoodHand(cards)) {
            if (currentBuyIn < 50)
                return currentBuyIn;
        }
        return 0;

    }

    public static int secondPhase(Card[] cardsArray, Integer currentBuyIn, Integer ourStack) {
        if (Combinations.hasPoker(cardsArray))
            return (int) Math.round(ourStack*1.0);
        if (Combinations.hasDrill(cardsArray))
            return (int) Math.round(ourStack*0.2);
        if (Combinations.hasFlush(cardsArray))
            return (int) Math.round(ourStack*1.0);
        if (Combinations.hasStraight(cardsArray))
            return (int) Math.round(ourStack*0.5);
        if (Combinations.hasFull(cardsArray))
            return (int) Math.round(ourStack*1.0);
        if (Combinations.hasTwoPair(cardsArray))
            return (int) Math.round(ourStack*0.3); //0.2
        if (Combinations.hasTopPair(cardsArray))
            return (int) Math.round(ourStack*0.1);

        return 0;
    }

    public static int thirdPhase(Card[] cardsArray, Integer buyIn, Integer ourStack) {
        if (Combinations.hasPoker(cardsArray))
            return (int) Math.round(ourStack*1.0);
        if (Combinations.hasFlush(cardsArray))
            return (int) Math.round(ourStack*0.8); //0.7
        if (Combinations.hasFull(cardsArray))
            return (int) Math.round(ourStack*0.7);
        if (Combinations.hasStraight(cardsArray))
            return (int) Math.round(ourStack*0.5);
        if (Combinations.hasTwoPair(cardsArray))
            return (int) Math.round(ourStack*0.1);
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
