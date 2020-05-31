import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class DeckTest {

	// Set up the Deck.
	String[] suits = {"Nine", "Borg", "Five"};
	String[] values = {"Seven", "Locutus", "Third"};
	Deck deck = new Deck(suits, values);
	
	
	/**
	 * This is to test the generation of the deck of cards.
	 * Each card should have the proper position in the 
	 * array and associated suit/value.  The deck should 
	 * also have the appropriate length given the number
	 * of suits and values used to set up the deck.
	 */
	
	@Test
	public void getCardDeck_test() {
		ArrayList<Card> cardDeck = new ArrayList<>();
		
		cardDeck = deck.getCardDeck();
		String test1 = String.valueOf(cardDeck.get(0));
		String test2 = String.valueOf(cardDeck.get(4)); 
		int test3 = cardDeck.size();
		
		assertEquals("Seven of Nine", test1);
		assertEquals("Locutus of Borg", test2);
		assertEquals(9, test3);
	}
	
	
	/**
	 * This is to test that the indices of the cards are 
	 * made correctly and that size of the array holding
	 * the indices are correct.
	 */
	@Test
	public void setIndices_test() {
		int test1 = deck.deckIndices.size();
		int test2 = deck.deckIndices.get(4);
		
		assertEquals(9, test1);
		assertEquals(4, test2);
	}

}
