import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {

	private Card[] deck;

	public Deck() {
		this.deck = new Card[52];
	}

	public Card[] getDeck() {
		return deck;
	}

	public Card[] createAndShuffleDeck() {
		String[] suit = {"Diamonds", "Clubs", "Hearts", "Spades"};
		int[] suitValue = {1, 2, 3, 4};
		String[] face = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
		int[] faceValue = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

		int k = 0; // to keep track of the total array for the deck itself
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 13; j++) {
					this.deck[k] = new Card(suit[i], suitValue[i], face[j], faceValue[j]);
					k++;
			}
		}

		// Shuffle deck of cards after it is created - need to understand lists and collections first in order to
		List<Card> shuffleArray = Arrays.asList(deck);
		Collections.shuffle(shuffleArray);
		shuffleArray.toArray(deck);

		return this.deck;
	}

	public void viewShuffledDeck() {
		for(int i = 0; i < 52; i++) {
			System.out.println(this.deck[i].getFace() + " of " + this.deck[i].getSuit());
		}
	}
}