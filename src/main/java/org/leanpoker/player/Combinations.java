package org.leanpoker.player;

import java.util.HashMap;
import java.util.Map;

public class Combinations {
    public boolean hasPoker(Card[] cards){
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

    public boolean hasFlush(Card[] cards) {
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

    public boolean hasFull(Card[] cards){
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

    public boolean hasStraight(Card[] cards){
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

    private Card[] sortCards(Card[] cards){
        for(int i = cards.length-1; i > 0; i--)
            for(int j = 0; j < i; j++){
                if(cards[j].getRank() > cards[j+1].getRank()) {
                    Card tmp = cards[j];
                    cards[j] = cards[j+1];
                    cards[j+1] = tmp;
                }
            }
        return cards;
    }

    private Integer[] getRanks(Card[] cards){
        Integer[] ranks = new Integer[cards.length];
        int index = 0;
        for (Card card: cards){
            ranks[index] = card.getRank();
            index++;
        }
        return ranks;
    }

    private String[] getSuits(Card[] cards){
        String[] suits = new String[cards.length];
        int index = 0;
        for (Card card: cards){
            suits[index] = card.getSuit();
            index++;
        }
        return suits;
    }
}
