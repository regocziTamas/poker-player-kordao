package org.leanpoker.player;

public class Card {
    private int rank;
    private String suit;

    public Card(String rank, String suit) {
        if (rank.equals("J"))
            this.rank = 11;
        else if(rank.equals("Q"))
            this.rank = 12;
        else if (rank.equals("K"))
            this.rank = 13;
        else if (rank.equals("A"))
            this.rank = 14;
        else
            this.rank = Integer.parseInt(rank);
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return "Rank " + rank + ", Suit_ " + suit;
    }
}
