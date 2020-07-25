package com.polymars.game;

public class Card {

    public static final int FIRE = 0;
    public static final int WATER = 1;
    public static final int SNOW = 2;

    public static final int RED = 0;
    public static final int ORANGE = 1;
    public static final int YELLOW = 2;
    public static final int GREEN = 3;
    public static final int BLUE = 4;
    public static final int PURPLE = 5;

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
        if (color == ORANGE)
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
