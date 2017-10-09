package pkgCore;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import pkgEnum.eRank;
import pkgEnum.eSuit;
import pkgException.DeckException;

public class DeckTest {

	// TODO: Build a deck, draw until you get a DeckException
	@Test(expected = DeckException.class)
	public void TestEmptyDeck() throws DeckException {
		Deck myDeck = new Deck();

		for (int i = 0; i < 60; i++) {
			myDeck.Draw();
		}
	}

	// TODO: Build a deck, test the Draw(eSuit) method
	@Test
	public void TestDrawSuit() {

		Deck deck1 = new Deck();
		
		assertEquals(deck1.Draw(eSuit.CLUBS).geteSuit(), eSuit.CLUBS);
		assertThat(deck1.Draw(eSuit.HEARTS).geteSuit(), not(eSuit.DIAMONDS));
	}

	// TODO: Build a deck, test the Draw(eRank) method
	@Test
	public void TestDrawRank() {

		Deck deck2 = new Deck();
		
		assertEquals(deck2.Draw(eRank.ACE).geteRank(), eRank.ACE);
		assertThat(deck2.Draw(eRank.EIGHT).geteRank(), not(eRank.QUEEN));
	}

	// TODO: Build a deck, test the DeckRankCount method
	@Test
	public void TestDeckRankCount() {
		Deck deck6 = new Deck();
		Deck deck7 = new Deck();
		deck7.Draw(eRank.KING);  // this deck will have less Kings
		Deck deck8 = new Deck();
		
		assertTrue(deck6.Count(eRank.KING) != deck7.Count(eRank.KING));
		assertTrue(deck6.Count(eRank.EIGHT) == deck8.Count(eRank.EIGHT));
	}

	// TODO: Build a deck, test the DeckSuitCountmethod
	public void TestDeckSuitCount() {
		Deck deck3 = new Deck();
		Deck deck4 = new Deck();
		deck4.Draw(eSuit.CLUBS); // this deck will have less clubs
		Deck deck5 = new Deck();
		
		assertTrue(deck3.Count(eSuit.CLUBS) != deck4.Count(eSuit.CLUBS));
		assertTrue(deck3.Count(eSuit.SPADES) == deck5.Count(eSuit.SPADES));
	}
}
