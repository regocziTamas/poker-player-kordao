package org.leanpoker.player;

import java.util.HashMap;
import java.util.Map;

public class Combinations {
    public boolean hasPoker(Card[] cards){
        Map<String, Integer> rankCounter = new HashMap<>();
        for(String rank: getRanks(cards)){
            if (rankCounter.containsKey(rank))
                rankCounter.put(rank, rankCounter.get(rank) + 1);
            else
                rankCounter.put(rank, 1);
        }
        for(String key: rankCounter.keySet())
            if (rankCounter.get(key) == 4)
                return true;
        return false;
    }

    public boolean hasDrill(Card[] cards){
        Map<String, Integer> rankCounter = new HashMap<>();
        for(String rank: getRanks(cards)){
            if (rankCounter.containsKey(rank))
                rankCounter.put(rank, rankCounter.get(rank) + 1);
            else
                rankCounter.put(rank, 1);
        }
        for(String key: rankCounter.keySet())
            if (rankCounter.get(key) == 3)
                return true;
        return false;
    }

    public int hasPairInHand(Card[] cards) {
        if (cards[0].getRank() == cards[1].getRank())
            return cards[0].getRank();
        else
            return 0;
    }

    public boolean hasPair(Card[] cards){
        try {
            for (int i=2; i<7; i++) {
                if (cards[i].getRank() == cards[0].getRank() || cards[i].getRank() == cards[1].getRank())
                    return true;
            }
        } catch (Exception e) {

        }
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
        Map<String, Integer> rankCounter = new HashMap<>();
        for(String rank: getRanks(cards)){
            if (rankCounter.containsKey(rank))
                rankCounter.put(rank, rankCounter.get(rank) + 1);
            else
                rankCounter.put(rank, 1);
        }
        String firstRank = "";
        for(String key: rankCounter.keySet()){
            if (rankCounter.get(key) >= 3)
                firstRank = key;
            else if (rankCounter.get(key) >= 2 && !key.equals(firstRank))
                return true;

        }
        return false;
    }

    private String[] getRanks(Card[] cards){
        String[] ranks = new String[cards.length];
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
