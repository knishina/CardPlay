import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;

public class GameTest {
	
	// Set up game with deck.
	String[] suits = {"Nine", "Borg", "Five"};
	String[] values = {"Seven", "Locutus", "Third"};
	int[] noShuffleIndices = {0, 1, 2, 3, 4, 5, 6, 7, 8};
	Game play = new Game(new Deck(suits, values));
	HashMap<Integer, Card> holder = new HashMap<>();
	
	
	/**
	 * This is to test the shuffle method.  The method is
	 * supposed to shuffle an ArrayList of numbers.  The test
	 * evaluates if the numbers are all in the shuffled array,
	 * that the length of the shuffled array is the same as
	 * the starting array, and if the first value of the starting
	 * array is not the same as the shuffled array.  This can 
	 * fail sometimes because it is a random function.  If it 
	 * fails, run it again.
	 */
	
	@Test
	public void ShuffleDeck_test() {
		boolean test1 = false;

		ArrayList<Integer> tempIndices = new ArrayList<>();
		tempIndices = play.shuffleDeck();
		
		for (int i = 0; i < noShuffleIndices.length; i++) {
			if (tempIndices.contains(noShuffleIndices[i])) {
				test1 = true;
			}
			else {
				test1 = false;
			}
		}
		
		boolean test2 = (tempIndices.get(0) == noShuffleIndices[0]);
		
		assertEquals(true, test1);
		assertEquals(false, test2);
		assertEquals(9, tempIndices.size());		
	}
	
	
	/**
	 * This is to test if the pickCard method works.  This method
	 * takes in a value from 1 to the total number of cards in the
	 * deck.  It is to subtract 1 to find the index of an
	 * unshuffled deck of cards.  So if the number is 1, the index
	 * applied to the unshuffled array of indices is 0.  So whatever 
	 * number 0 points to in the in array of indices, that number is 
	 * then used to find the value in the ordered deck of cards. 
	 */
	
	@Test
	public void pickCard_test() {
		String test1 = play.pickCard(1);
		String test2 = play.pickCard(5);
		
		assertEquals("Seven of Nine", test1);
		assertEquals("Locutus of Borg", test2);
	}
	
	
	/**
	 * This is to test if the removeCard method works.  The pickCard
	 * method must be run first.  Want to ensure that the hashmap is
	 * returned correctly and that the index and cardvalue is in the
	 * hashmap.  Also checks to see that at the index in the array
	 * of Cards, that null has been entered in place of the card value.
	 */
	
	@Test
	public void removeCard_test() {
		play.pickCard(1);
		holder = play.removeCard();
		String test1 = String.valueOf(holder.get(play.indexed));
		String test2 = String.valueOf(play.fullDeck.get(play.indexed));
		
		assertEquals("Seven of Nine", test1);
		assertEquals("null", test2);
		assertEquals(0, play.indexed);
		assertEquals(0, play.numberPicked);
	}
	
	
	/**
	 * This is to test that all the cards are put back after removal.
	 * The cards were removed and tested before and after card 
	 * replacement.  Before the replacement, the value in the array 
	 * of Cards should be null, and after, should be a card value.  
	 * Also, checking that there are values in holdy before replacement
	 * and that it is empty after replacement.  Also, that the array
	 * of indices has been returned to 9.
	 */
	
	@Test
	public void replaceCards_test() {
		play.pickCard(1);
		play.removeCard();
		play.pickCard(4);
		play.removeCard();
		
		// before replacement
		int test1 = play.indexed;
		String test2 = String.valueOf(play.holdy.get(play.indexed));
		String test3 = String.valueOf(play.fullDeck.get(play.indexed));
		
		play.replaceCards();
		
		// after replacement
		String test4 = String.valueOf(play.fullDeck.get(play.indexed));
	
		assertEquals(4, test1);
		assertEquals("Locutus of Borg", test2);
		assertEquals("null", test3);
		assertEquals(0, play.holdy.size());
		assertEquals(9, play.fullDeck.size());
		assertEquals("Locutus of Borg", test4);
	}

}
