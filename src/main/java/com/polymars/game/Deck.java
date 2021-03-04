package com.polymars.game;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    public static final int FIRE = 0;
    public static final int WATER = 1;
    public static final int SNOW = 2;

    public static final int RED = 0;
    public static final int ORANGE = 1;
    public static final int YELLOW = 2;
    public static final int GREEN = 3;
    public static final int BLUE = 4;
    public static final int PURPLE = 5;

    private final ArrayList<Card> deck;
    Random rand = new Random();

    public Deck()
    {
        deck = new ArrayList<>();
    }

    public void createCards()
    {
        for (int value = 2; value <= 12; value++)
        {
            for (int element = FIRE; element <= SNOW; element++)
            {
                int color = rand.nextInt(PURPLE + 1);
                Card card = new Card(element, value, color);
                deck.add(card);
            }
        }
        shuffle();
    }

    public ArrayList<Card> getCards()
    {
        return deck;
    }

    public Card deal()
    {
        Card card = deck.remove(0);
        if (deck.isEmpty())
        {
            createCards();
        }
        return card;
    }

    public void shuffle()
    {
        for (int i = 0; i < deck.size(); i++)
        {
            int index = rand.nextInt(deck.size());
            Card x = deck.get(i);
            Card y = deck.get(index);
            deck.set(i, y);
            deck.set(index, x);
        }
    }
}
