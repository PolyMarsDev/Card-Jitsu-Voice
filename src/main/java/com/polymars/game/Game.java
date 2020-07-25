package com.polymars.game;

import com.polymars.game.Bank;
import com.polymars.game.Deck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static java.lang.Float.NaN;

public class Game {

    public static final int FIRE = 0;
    public static final int WATER = 1;
    public static final int SNOW = 2;

    public static final int WIN = 0;
    public static final int LOSE = 1;
    public static final int TIE = 2;

    static final int MAX_HAND = 5;
    static final ArrayList<String> elements = new ArrayList<String>(Arrays.asList("fire", "water", "snow"));

    static boolean newGame = true;
    static boolean startMatch = false;
    static Deck deck;

    static Hand playerHand;
    static Bank playerBank;

    static Hand opponentHand;
    static Bank opponentBank;

    static Card currentPlayerCard = null;
    static Card currentOpponentCard = null;

    static Random rand = new Random();

    public static String game(String input)
    {
        if (newGame)
        {
            newGame = false;
            deck = new Deck();
            deck.createCards();

            playerHand = new Hand();
            createHand(playerHand);
            playerBank = new Bank();

            opponentHand = new Hand();
            createHand(opponentHand);
            opponentBank = new Bank();

            return "Welcome to Card Jitsu Voice. Would you like to start a match against an AI opponent?";
        }
        if (!startMatch)
        {
            if (input.equals("yes"))
            {
                startMatch = true;
                return "Choose a card from your hand to play first. Your hand is made up of " + playerHand.toString() + ".";
            }
            else if (input.equals("no"))
            {
                newGame = true;
                return "Alright. Feel free to start a match at any time!";
            }
            else {
                return "I didn't get that. Answer yes or no.";
            }
        }
        if (input.equals("stop"))
        {
            newGame = true;
            startMatch = false;
            return "Thanks for playing!";
        }
        if (input.equals("playerbank"))
        {
            if (playerBank.toString().equals(""))
            {
                return "Your bank currently is empty.";
            }
            return "Your bank currently has " + playerBank.toString() + ".";
        }
        if (input.equals("opponentbank"))
        {
            if (opponentBank.toString().equals(""))
            {
                return "Your opponent's bank currently is empty.";
            }
            return "Your opponent's bank currently has " + opponentBank.toString() + ".";
        }
        if (input.equals("hand"))
        {
            return "You currently have " + playerHand.toString() + " in your hand.";
        }
        String args[] = input.split("\\s+");
        if (args.length == 2 && elements.contains(args[0].toLowerCase()) && Integer.parseInt(args[1]) != NaN && Integer.parseInt(args[1]) > 1 && Integer.parseInt(args[1]) < 13)
        {
            currentPlayerCard = playerHand.useCard(elements.indexOf(args[0].toLowerCase()), Integer.parseInt(args[1]));
            if (currentPlayerCard == null)
            {
                return "You don't have that card! Try picking a new one. You currently have " + playerHand.toString() + ".";
            }
            playerHand.addCard(deck.deal());
            currentOpponentCard = opponentHand.useCard(rand.nextInt(MAX_HAND));
            opponentHand.addCard(deck.deal());
            String response = "";
            switch (wonRound(currentPlayerCard, currentOpponentCard))
            {
                case WIN:
                    playerBank.addCard(currentPlayerCard);
                    response = ("Your " + currentPlayerCard + " beat your opponent's " + currentOpponentCard + ".");
                    break;
                case LOSE:
                    opponentBank.addCard(currentOpponentCard);
                    response = ("Your " + currentPlayerCard + " lost against your opponent's " + currentOpponentCard + ".");
                    break;
                case TIE:
                    response = ("Your " + currentPlayerCard + " tied with your opponent's " + currentOpponentCard + ".");
                    break;
            }
            if (playerBank.hasWon())
            {
                newGame = true;
                startMatch = false;
                return response + " You won, with " + playerBank.getWinningComboAsString() + "! Feel free to play again at any time.";
            }
            if (opponentBank.hasWon())
            {
                newGame = true;
                startMatch = false;
                return response + " You lost. Your opponent had " + opponentBank.getWinningComboAsString() + ". Feel free to play again at any time.";
            }
            return response + " Now pick a new card from your hand. You currently have " + playerHand.toString() + ".";
        }
        else
        {
            return "Sorry, I didn't get that. Try picking a card again. You currently have " + playerHand.toString() + ".";
        }


    }

    static void createHand(Hand hand)
    {
        for (int i = 0; i < MAX_HAND; i++)
        {
            hand.addCard(deck.deal());
        }
    }

    static int wonRound(Card playerCard, Card opponentCard)
    {
        if (isTypeAdvantage(playerCard.getElement(), opponentCard.getElement()))
        {
            return WIN;
        }
        if (isTypeAdvantage(opponentCard.getElement(), playerCard.getElement()))
        {
            return LOSE;
        }
        //elements must be the same (i hope)
        if (playerCard.getValue() == opponentCard.getValue())
        {
            return TIE;
        }
        if (playerCard.getValue() > opponentCard.getValue())
        {
            return WIN;
        }
        return LOSE;
    }

    static boolean isTypeAdvantage(int elementX, int elementY)
    {
        return (elementX == FIRE && elementY == SNOW) || (elementX == WATER && elementY == FIRE) || (elementX == SNOW && elementY == WATER);
    }
}
