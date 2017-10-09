package pkgCore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import pkgEnum.eRank;
import pkgEnum.eSuit;
import pkgException.DeckException;

public class Deck {

	private ArrayList<Card> cardsInDeck = new ArrayList<Card>();

	public Deck() {
		int iCardNbr = 1;
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				cardsInDeck.add(new Card(eSuit, eRank, iCardNbr++));
			}
		}
		Collections.shuffle(cardsInDeck);
	}

	// TODO: Fix the Draw method so it throws an exception if the deck is empty

	public Card Draw() throws DeckException {
		if (this.cardsInDeck.size() == 0) {
			throw new DeckException(this);
		} else
			return cardsInDeck.remove(0);
	}

	// TODO: Write an overloaded Draw method to Draw a card of a given eSuit

	public Card Draw(eSuit eSuit) {
		for (Card c : this.cardsInDeck) {
			if (c.geteSuit() == eSuit) {
				cardsInDeck.remove(c);
				return c;
			}
		}
		return null;
	}

	// TODO: Write an overloaded Draw method to Draw a card of a given eRank

	public Card Draw(eRank eRank) {
		for (Card c : this.cardsInDeck) {
			if (c.geteRank() == eRank) {
				cardsInDeck.remove(c);
				return c;
			}
		}
		return null;
	}

	// TODO: Write a method that will return the number of a given eSuit left in the
	// deck.

	public int Count(eSuit eSuit) {
		ArrayList<Card> eSuitLeft = cardsInDeck.stream().filter(c -> c.geteSuit() == eSuit)
				.collect(Collectors.toCollection(ArrayList::new));
		return eSuitLeft.size();
	}

	// TODO: Write a method that will return the number of a given eRank left in the
	// deck.

	public int Count(eRank eRank) {
		ArrayList<Card> eRankLeft = cardsInDeck.stream().filter(c -> c.geteRank() == eRank)
				.collect(Collectors.toCollection(ArrayList::new));
		return eRankLeft.size();
	}

	// TODO: Write a method that will return 0 or 1 if a given card is left in the
	// deck.

	public int Count(Card c) {
		for (Card crds : cardsInDeck) {
			if (crds == c)
				return 1;
		}
		return 0;
	}
}
