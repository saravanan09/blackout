package deck.of.cards.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Cards {
	public static String[] suits = { "Spades", "Hearts", "Diamonds", "Clubs" };

	public static String[] cards = { "Ace", "2", "3", "4", "5", "6", "7", "8",
			"9", "10", "Jack", "Queen", "King" };

	public static int numberOfCards = suits.length * cards.length;
	String[] deck = new String[numberOfCards];
	String[] shuffledDeck = new String[numberOfCards];
	ArrayList<String>[] al;

	public void createDeck() {
		// create a standard deck of playing cards
		int index = 0;

		for (int i = 0; i < suits.length; i++) {
			for (int j = 0; j < cards.length; j++) {
				deck[index] = cards[j] + " of " + suits[i];
				index++;
			}
		}
	}

	public void shuffleDeck() {
		// shuffle the deck
		for (int i = 0; i < numberOfCards; i++) {
			int shuffle = i + (int) (Math.random() * (numberOfCards - i));
			String temp = deck[shuffle];
			deck[shuffle] = deck[i];
			shuffledDeck[i] = temp;
		}
	}

	public String dealCardToPlayers(String players) {
		if (players.matches("[a-zA-Z._^%$#!~@,-]+")) {
			return "Error!!! Number of players cannot be alphabets or special characters!!!";
		} else {
			int numberOfPlayers = Integer.parseInt(players);
			al = new ArrayList[numberOfPlayers];
			if (numberOfPlayers <= 0) {
				return "Error!!! Number of players cannot be negative!!!";
			} else if (numberOfPlayers > (numberOfCards)) {
				return "Error!!! Number of players exceeds number of cards!!!";
			} else {
				for (int i = 0; i < numberOfPlayers; i++) {
					al[i] = new ArrayList<String>();
				}
				int currentCard = 0;
				int i = 0;
				for (int j = currentCard; j < numberOfCards; j++) {
					if (i == numberOfPlayers) {
						i = 0;
					}
					al[i].add(shuffledDeck[j]);
					i++;
					currentCard++;
				}
				return "Cards dealt successfully to players!!!";
			}
		}
	}

	public int[] cardsDealt() {
		int player_with_extra_cards = 0, player_with_regular_cards = 0;
		int TotalCardswithPlayer = 0;
		for (int i = 0; i < 5; i++) {
			TotalCardswithPlayer = al[i].size() + TotalCardswithPlayer;
			if (al[i].size() == 11) {
				player_with_extra_cards++;
			}
			if (al[i].size() == 10) {
				player_with_regular_cards++;
			}
		}
		return new int[] { TotalCardswithPlayer, player_with_extra_cards,
				player_with_regular_cards };
	}

	public String shufflecheck() {
		if (Arrays.equals(deck, shuffledDeck) == true) {
			return "Both are equal";
		} else {
			return "Both are not equal";
		}
	}

	public void displayCards() {

		System.out.println(Arrays.toString(deck));
		System.out.println(Arrays.toString(shuffledDeck));

	}
}
