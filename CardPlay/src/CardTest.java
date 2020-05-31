import static org.junit.Assert.*;
import org.junit.Test;

public class CardTest {

	/**
	 * This is to test the generation of the name of the card.  Each
	 * card consists of a value and suit that is separated by " of ".
	 *  In this case, there are Arrays of Strings to grab value and
	 *  suits when the class is instantiated.
	 */
	
	@Test
	public void toString_test() {
		String[] suited = {"Nine", "Borg"};
		String[] valued = {"Seven", "Locutus"};
		
		// Test1.
		Card test1 = new Card(suited[0], valued[0]);
		assertEquals("Seven of Nine", test1.toString());

		// Test2.
		Card test2 = new Card(suited[1], valued[1]);
		assertEquals("Locutus of Borg", test2.toString());
	
	}

}
