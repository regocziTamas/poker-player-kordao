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
