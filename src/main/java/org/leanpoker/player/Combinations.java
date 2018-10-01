package org.leanpoker.player;

import java.util.HashMap;
import java.util.Map;

public class Combinations {
    public static boolean hasPoker(Card[] cards){
        Map<Integer, Integer> rankCounter = new HashMap<>();
        for(Integer rank: getRanks(cards)){
            if (rankCounter.containsKey(rank))
                rankCounter.put(rank, rankCounter.get(rank) + 1);
            else
                rankCounter.put(rank, 1);
        }
        for(Integer rank: rankCounter.keySet())
            if (rankCounter.get(rank) == 4)
                return true;
        return false;
    }

    public static boolean hasDrill(Card[] cards){
        Map<Integer, Integer> rankCounter = new HashMap<>();
        for(int rank: getRanks(cards)){
            if (rankCounter.containsKey(rank))
                rankCounter.put(rank, rankCounter.get(rank) + 1);
            else
                rankCounter.put(rank, 1);
        }
        for(int key: rankCounter.keySet())
            if (rankCounter.get(key) == 3)
                return true;
        return false;
    }

    public static int hasPairInHand(Card[] cards) {
        if (cards[0].getRank() == cards[1].getRank())
            return cards[0].getRank();
        else
            return 0;
    }

    public static boolean hasPair(Card[] cards){
        try {
            for (int i=2; i<7; i++) {
                if (cards[i].getRank() == cards[0].getRank() || cards[i].getRank() == cards[1].getRank())
                    return true;
            }
        } catch (Exception e) {

        }
        return false;
    }

    public static boolean hasTwoPair(Card[] cards){
        boolean firstpair = false;
        boolean secondpair = false;
        for (int i = 2; i < cards.length; i++) {
            if (cards[i].getRank() == cards[0].getRank())
                firstpair = true;
            if (cards[i].getRank() == cards[1].getRank())
                secondpair = true;
        }
        return firstpair && secondpair;
    }

    public static boolean hasFlush(Card[] cards) {
        Map<String, Integer> suitCounter = new HashMap<>();
        for (String suit: getSuits(cards)) {
            if (suitCounter.containsKey(suit))
                    suitCounter.put(suit, suitCounter.get(suit) + 1);
            else
                suitCounter.put(suit, 1);
        }
        for(String key: suitCounter.keySet())
            if (suitCounter.get(key) == 5)
                return true;
        return false;
    }



    public static boolean hasFull(Card[] cards){
        Map<Integer, Integer> rankCounter = new HashMap<>();
        for(Integer rank: getRanks(cards)){
            if (rankCounter.containsKey(rank))
                rankCounter.put(rank, rankCounter.get(rank) + 1);
            else
                rankCounter.put(rank, 1);
        }
        Integer firstRank = 0;
        for(Integer key: rankCounter.keySet()){
            if (rankCounter.get(key) >= 3)
                if (firstRank.equals(1))
                    firstRank = key;
                else
                    return true;
            else if (rankCounter.get(key) >= 2)
                if (firstRank.equals(1))
                    firstRank = key;
                else
                    return true;

        }
        return false;
    }

    public static boolean isStraightPossible(Card[] cards){
        cards = sortCards(cards);
        boolean hasAce = false;
        if (cards[cards.length - 1].getRank() == 14)
            hasAce = true;
        int counter = 0;
        int gap = 0;
        if (cards[0].getRank() == 2 && hasAce)
            counter++;
        for (int i = 0; i < cards.length; i++){
            if (cards[i].getRank() == cards[i+1].getRank() - 1)
                counter++;
            else
                if (gap == 0)
                    gap = 1;
                else {
                    counter = 0;
                    gap = 0;
                }
        }
        if (counter >= 5)
            return true;
        return false;
    }

    public static boolean hasStraight(Card[] cards){
        cards = sortCards(cards);
        boolean hasAce = false;
        if (cards[cards.length - 1].getRank() == 14)
            hasAce = true;
        int counter = 0;
        if (cards[0].getRank() == 2 && hasAce)
            counter++;
        for (int i = 0; i < cards.length; i++){
            if (cards[i].getRank() == cards[i+1].getRank() - 1)
                counter++;
            else
                counter = 0;
        }
        if (counter >= 5)
            return true;
        return false;
    }

    public static boolean hasStraightFlush(Card[] cards) {
        return hasStraight(cards) && hasFlush(cards);
    }

    private static Card[] sortCards(Card[] cards){
        Card[] sortedCards = new Card[cards.length];
        int index = 0;
        for (Card card: cards){
            sortedCards[index] = card;
            index++;
        }
        for(int i = sortedCards.length-1; i > 0; i--)
            for(int j = 0; j < i; j++){
                if(sortedCards[j].getRank() > sortedCards[j+1].getRank()) {
                    Card tmp = sortedCards[j];
                    sortedCards[j] = sortedCards[j+1];
                    sortedCards[j+1] = tmp;
                }
            }
        return cards;
    }

    public static boolean checkForAceAndKing(Card[] cards){
        boolean acefound = false;
        boolean kingfound = false;

        for(int i = 0; i < cards.length; i++){
            if(cards[i].getRank() == 14){
                acefound = true;
            }
            if(cards[i].getRank() == 13){
                kingfound = true;
            }

        }

        return acefound && kingfound;


    }

    private static Integer[] getRanks(Card[] cards){
        Integer[] ranks = new Integer[cards.length];
        int index = 0;
        for (Card card: cards){
            ranks[index] = card.getRank();
            index++;
        }
        return ranks;
    }

    private static String[] getSuits(Card[] cards){
        String[] suits = new String[cards.length];
        int index = 0;
        for (Card card: cards){
            suits[index] = card.getSuit();
            index++;
        }
        return suits;
    }

    public static boolean hasTopPair(Card[] cards){
        boolean hasPair = hasPair(cards);

        Card highestCardinHand = cards[0].getRank() > cards[1].getRank() ? cards[0] : cards[1];
        if(hasPair){
            for(int i = 2; i<cards.length;i++){
                if(cards[i].getRank() == highestCardinHand.getRank()){
                    return true;
                }
            }
            return false;


        }else{return false;}


    }
}
