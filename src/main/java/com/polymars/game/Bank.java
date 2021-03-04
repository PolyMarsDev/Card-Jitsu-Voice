package com.polymars.game;

import java.util.ArrayList;

public class Bank {

    final String[] elements = {"fire", "water", "snow"};
    final String[] colors = {"red", "orange", "yellow", "green", "blue", "purple"};

    private final ArrayList<Integer>[] bank = new ArrayList[3];
    private int winningElement;
    private ArrayList<Integer> winningColors;

    public Bank()
    {
        winningColors = new ArrayList<>();
        for (int i = 0; i < bank.length; i++)
        {
            bank[i] = new ArrayList<>();
        }
    }

    public void addCard(Card card)
    {
        if (!containsColor(card))
        {
            bank[card.getElement()].add(card.getColor());
        }
    }

    private boolean containsColor(Card card)
    {
        for (int i = 0; i < bank[card.getElement()].size(); i++)
        {
            if (bank[card.getElement()].get(i) == card.getColor())
            {
                return true;
            }
        }
        return false;
    }

    public boolean hasWon()
    {
        //same element, unique colors
        for (int i = 0; i < bank.length; i++)
        {
            if (bank[i].size() >= 3)
            {
                winningElement = i;
                winningColors = bank[i];
                return true;
            }
        }
        //different elements, unique colors
        for (int i = 0; i < bank[0].size(); i++)
        {
            for (int j = 0; j < bank[1].size(); j++)
            {
                for (int k = 0; k < bank[2].size(); k++)
                {
                    if (!bank[0].get(i).equals(bank[1].get(j)) && !bank[1].get(j).equals(bank[2].get(k)) && !bank[2].get(k).equals(bank[0].get(i)))
                    {
                        winningElement = Cards.MIXED;
                        winningColors.add(bank[0].get(i));
                        winningColors.add(bank[1].get(j));
                        winningColors.add(bank[2].get(k));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String getWinningComboAsString()
    {
        StringBuilder result = new StringBuilder();
        if (winningElement < 3)
        {
            for (int i = 0; i < winningColors.size(); i++)
            {
                if (i == winningColors.size() - 1)
                {
                    result.append("and ").append(colors[winningColors.get(i)]).append(" ").append(elements[winningElement]);
                }
                else
                {
                    result.append(colors[winningColors.get(i)]).append(" ").append(elements[winningElement]).append(", ");
                }
            }
            return result.toString();
        }
        return colors[winningColors.get(0)] + " Fire, " + colors[winningColors.get(1)] + " Water, and " + colors[winningColors.get(2)] + " Snow";
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
        int lastElement = bank.length - 1;
        while (lastElement >= 0 && bank[lastElement].isEmpty())
        {
            lastElement--;
        }
        int firstElement = 0;
        while (firstElement < bank.length && bank[firstElement].isEmpty())
        {
            firstElement++;
        }
        for (int i = 0; i < bank.length; i++)
        {
            for (int j = 0; j < bank[i].size(); j++)
            {
                if (i == lastElement && j == bank[i].size() - 1)
                {
                    if (i == firstElement && j == 0)
                    {
                        result.append(colors[bank[i].get(j)]).append(" ").append(elements[i]);
                    }
                    else
                    {
                        result.append("and ").append(colors[bank[i].get(j)]).append(" ").append(elements[i]);
                    }
                }
                else
                {
                    result.append(colors[bank[i].get(j)]).append(" ").append(elements[i]).append(", ");
                }
            }
        }
        return result.toString();
    }
}
