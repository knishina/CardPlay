import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CardPlay {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Set up the suits and values.
		String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
		String[] cardValues = {"Ace", "King", "Queen", "Jack", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
		
		// set up play.
		Game play = new Game(new Deck(suits, cardValues));
		int deckSize = play.fullDeck.size();
		boolean continued = true;
		int choose;
		int pickNumber;
		
		System.out.println("Let's play.");
		System.out.println("You can shuffle, pick a card, remove the card, or put the cards back.");
		System.out.println("The only rule is that the card can only be removed if you pick it first");
		System.out.println("Enter 1 to shuffle.");
		System.out.println("Enter 2 to pick a card.");
		System.out.println("Enter 3 to remove the card from the deck");
		System.out.println("Enter 4 to put the cards back.");
		System.out.println("Enter 5 to quit.");
		System.out.println();
		
		
		
		do {
			System.out.println("Enter a number.");
			choose = Integer.valueOf(br.readLine());
			if (choose == 1) {
				play.shuffleDeck();
				System.out.println("Shuffled!");
			}
			else if (choose == 2) {
				System.out.println("Choose a number from 1 to " + deckSize + ".");
				pickNumber = Integer.valueOf(br.readLine());
				play.pickCard(pickNumber);
			}
			else if (choose == 3) {
				deckSize -= 1;
				play.removeCard();
				System.out.println("Card removed.");
			}
			else if (choose == 4) {
				play.replaceCards();
				deckSize = play.fullDeck.size();
				System.out.println("Back to " + deckSize + " cards.");
			}
			else if (choose == 5) {
				System.out.println("Ok.  See you!");
				continued = false;
			}
			
			
		} while(continued);
		}

}
