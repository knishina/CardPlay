import java.util.ArrayList;

public class Deck{
	// set up some variables.
	public int cardNumber;
	public int numValues;
	public int numSuits;

	private ArrayList<Card> cardDeck = new ArrayList<>();
	public ArrayList<Integer> deckIndices = new ArrayList<>();
 	
	
	/**
	 * Constructor.  
	 * Set up the number of Suits (4), the number of Values (13),
	 * the number of cards (52), generates the deck and the array
	 * of indices.
	 * @param Suits
	 * @param Values
	 */
	Deck(String[] Suits, String[] Values) {
		numSuits = Suits.length;
		numValues = Values.length;
		cardNumber = (int) (numSuits * numValues);
		generateDeck(Suits, Values);
		deckIndices = setIndices();
	}
	
	
	/**
	 * This is a private function that generates the deck of
	 * cards.  It iterates through suits and values and adds
	 * the resulting string as a Card object to the array of
	 * Cards.  The array of Cards should have values like
	 * "Ace of Hearts", etc.
	 * @param suit
	 * @param value
	 */
	private void generateDeck(String[] suit, String[] value) {
		for (int suitIter = 0; suitIter < numSuits; suitIter++) {
			for (int valIter = 0; valIter < numValues; valIter++) {
				cardDeck.add(new Card(suit[suitIter], value[valIter]));
			}
		}
	}
	
	
	/**
	 * This is a public function that sets up the list of numbers.
	 * To get this list, 0 through the number of cards (52) are
	 * iterated through and added, in order, to the ArrayList.
	 * @return deckIndices (ArrayList of int)
	 */
	public ArrayList<Integer> setIndices() {
		deckIndices.clear();
		for (int posIter = 0; posIter < cardNumber; posIter++) {
			deckIndices.add(posIter);
		}
		return deckIndices;
	}
	
	
	/**
	 * This is a getter for the deck of Cards.
	 * @return cardDeck(ArrayList of Cards)
	 */
	public ArrayList<Card> getCardDeck() {
		return cardDeck;
	}
}
