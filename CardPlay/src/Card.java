
public class Card {
	String suit;
	String value;
	
	// constructor.
	Card(String suit, String value) {
		this.suit = suit;
		this.value = value;
	}
	
	
	/**
	 * Converts the Card to a string.  The card and suit
	 * are separated with " of ".  The output should be
	 * "Ace of Hearts", for example.
	 */
	public String toString() {
		return value + " of " + suit;
	}
}

