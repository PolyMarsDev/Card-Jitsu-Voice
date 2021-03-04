package com.polymars.game;

public class Card {

    final String[] elements = {"fire", "water", "snow"};
    final String[] colors = {"red", "orange", "yellow", "green", "blue", "purple"};

    int element;
    int value;
    int color;

    public Card (int element, int value, int color)
    {
        this.element = element;
        this.value = value;
        this.color = color;
    }

    public int getElement()
    {
        return element;
    }

    public int getValue()
    {
        return value;
    }

    public int getColor()
    {
        return color;
    }

    public String getElementAsString()
    {
        return elements[element];
    }

    public String getValueAsString()
    {
        return Integer.toString(value);
    }

    public String getColorAsString()
    {
        return colors[color];
    }

    public String getArticle()
    {
        if (color == Cards.ORANGE)
        {
            return "an";
        }
        return "a";
    }

    public String toString()
    {
        return getColorAsString() + " " + getElementAsString() + " card of value " + getValueAsString();
    }
}
