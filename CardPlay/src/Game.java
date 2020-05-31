import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;


public class Game {
	
	// Set up of variables.
	private Deck deck;
	int numberPicked;
	int indexed;
	String cardValue;
	Card cardValueObject;
	ArrayList<Card> fullDeck = new ArrayList<>();
	HashMap<Integer, Card> holdy = new HashMap<>();
	
	
	/**
	 * Constructor.  Set up the deck of cards.
	 * @param deck
	 */
	Game(Deck deck) {
		this.deck = deck;
		fullDeck = deck.getCardDeck();
	}
	
	
	/**
	 * This method takes the ArrayList of indices and shuffles
	 * the values in that ArrayList.
	 * @return deck.deckIndices (ArrayList of int)
	 */
	public ArrayList<Integer> shuffleDeck() {
		Random random = new Random();
		
		for (int posIter = 0; posIter < deck.cardNumber; posIter++) {
			int currentValue = deck.deckIndices.get(posIter);
			int randomValue = posIter + random.nextInt(deck.cardNumber - posIter);
			deck.deckIndices.set(posIter,  deck.deckIndices.get(randomValue));
			deck.deckIndices.set(randomValue,  currentValue);
		}
		return deck.deckIndices;
	}
	
	
	/**
	 * This method takes in the card number.  It reduces the 
	 * card number by 1 (think indices of the deck.deckIndices).
	 * The value associated with that card number is assigned
	 * to the variable indexed.  Indexed is then used to get the
	 * card value.  An output string will be printed to console
	 * log, telling what card was picked.
	 * @param number (card number from 1 to total number 
	 * of cards).
	 * @return cardValue (String)
	 */
	public String pickCard(int number) {
		numberPicked = number -1;
		indexed = deck.deckIndices.get(numberPicked);
		cardValueObject = fullDeck.get(indexed);
		
		cardValue = String.valueOf(fullDeck.get(indexed));
		System.out.println("You picked: " + cardValue);
		return cardValue;
	}
	
	
	/**
	 * This method can only be run after the pickCard method
	 * is run.  It takes the indexed value and the cardValue
	 * and shoves it into a HashMap.  The indexed value in 
	 * the fullDeck will be changed to null.  Also, the 
	 * cardNumber is reduced by one and the numberPicked will
	 * be removed from deckIndices.
	 * @return holdy (HashMap of index and cardvalue)
	 */
	public HashMap<Integer, Card> removeCard() {
		holdy.put(indexed, cardValueObject);
		deck.cardNumber -= 1;
		deck.deckIndices.remove(numberPicked);
		fullDeck.set(indexed, null);
		return holdy;
		
	}
	
	
	/**
	 * This method takes the key values from holdy, finds the 
	 * same index in the fullDeck, and replaces the null value
	 * holder with the card value (stored in holdy).  Holdy is
	 * then emptied, the cardnumber is restored to the original
	 * number of cards (52), and the indices will be restored
	 * in its unshuffled state.
	 */
	public void replaceCards() {
		for (int key: holdy.keySet()) {
			fullDeck.set(key,  holdy.get(key));
		}
		deck.cardNumber = fullDeck.size();
		deck.setIndices();
		holdy.clear();
	}
	
}
//  please look at deck.cardNumber and use length.
