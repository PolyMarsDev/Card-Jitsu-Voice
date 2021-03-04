package com.polymars.game;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

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
            for (int element = Cards.FIRE; element <= Cards.SNOW; element++)
            {
                int color = rand.nextInt(Cards.PURPLE + 1);
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
