public class Player {

	private String name;
	private Card[] playerDeck;
	private int roundScore;
	private int roundsWon;

	public Player(String name) {
		this.name = name;
		this.playerDeck = new Card[26];
		this.roundScore = 0;
		this.roundsWon = 0;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPlayerDeck(int deckCutPoint, Deck deck) {
		//cut point is starting point for where cards are dealt, ie. player 1 cut point is 0, goes to the 26th card, player 2's cut point is 26, going to the 52nd card
		int k = deckCutPoint;
		//Note that as part of the player constructor, an empty 26 slot deck is created, this method just fills that premade array, make sure player created before 
		//giving them a deck of course
		for(int i = 0; i < 26; i++) {
			this.playerDeck[i] = deck.getDeck()[k];
			k++;
		}
	}

	public void setRoundScore(int roundScore) {
		this.roundScore = roundScore;
	}

	public void setRoundsWon(int roundsWon) {
		this.roundsWon = roundsWon;
	}

	public String getName() {
		return this.name;
	}

	public Card[] getPlayerDeck() {
		//Test code to see player 1 cards to confirm they match first half of shuffled deck
		// for(int i = 0; i < 26; i++) {
		// 	System.out.println(playerDeck[i].getFace() + " of " + playerDeck[i].getSuit());
		// }

		// System.out.println();
		return this.playerDeck;
	}

	public int getRoundScore() {
		return this.roundScore;
	}

	public int getRoundsWon() {
		return this.roundsWon;
	}

}