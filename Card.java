public class Card {

	private String suit;
	private int suitValue;
	private String face;
	private int faceValue;

	public Card(String suit, int suitValue, String face, int faceValue) {
		this.suit = suit;
		this.suitValue = suitValue;
		this.face = face;
		this.faceValue = faceValue;
	}

	public String getSuit() {
		return this.suit;
	}

	public int getSuitValue() {
		return this.suitValue;
	}

	public String getFace() {
		return this.face;
	}

	public int getFaceValue() {
		return this.faceValue;
	}
}