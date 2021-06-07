package com.polymars.game;

import java.util.ArrayList;

public class Hand {

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
        for (Card card : hand) {
            if (card.getElement() == element && card.getValue() == value) {
                return card;
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
