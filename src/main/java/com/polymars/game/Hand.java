package com.polymars.game;

import java.util.ArrayList;

public class Hand {
    public static final int FIRE = 0;
    public static final int WATER = 1;
    public static final int SNOW = 2;

    public static final int RED = 0;
    public static final int ORANGE = 1;
    public static final int YELLOW = 2;
    public static final int GREEN = 3;
    public static final int BLUE = 4;
    public static final int PURPLE = 5;

    private final ArrayList<Card> hand;

    public Hand()
    {
        hand = new ArrayList<>();
    }

    public void addCard(Card card)
    {
        hand.add(card);
    }

    public Card getCard(int element, int value)
    {
        for (int i = 0; i < hand.size(); i++)
        {
            if (hand.get(i).getElement() == element && hand.get(i).getValue() == value)
            {
                return hand.get(i);
            }
        }
        return null;
    }

    public Card useCard(int element, int value)
    {
        Card card = getCard(element, value);
        if (card == null)
        {
            return null;
        }
        hand.remove(card);
        return card;
    }

    public Card useCard(int index)
    {
        Card card = hand.get(index);
        hand.remove(index);
        return card;
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < hand.size(); i++)
        {
            if (i == hand.size() - 1)
            {
                result.append("and ").append(hand.get(i).getArticle()).append(" ").append(hand.get(i).toString());
            }
            else
            {
                result.append(hand.get(i).getArticle()).append(" ").append(hand.get(i).toString()).append(", ");
            }
        }
        return result.toString();
    }
}
