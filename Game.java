import java.util.Arrays;
import java.util.Scanner;

public class Game {

	private Player[] players;

	public Game() {
		this.players = new Player[2];
	}

	public Player[] getPlayers() {
		System.out.println("Player 1 is " + this.players[0].getName());
		System.out.println("Player 2 is " + this.players[1].getName());
		return players;
	}

	public void startGame(String playerOne, String playerTwo) {
		//Scanner to track when user presses Enter key and continue loop only when done so
		Scanner scanner = new Scanner(System.in);
		
		//Create players and empty hands/decks
		this.players[0] = new Player(playerOne);
		this.players[1] = new Player(playerTwo);


		//Create and shuffle the deck
		Deck deck = new Deck();
		deck.createAndShuffleDeck();
		// deck.viewShuffledDeck();
		// System.out.println();

		//Deal half the shuffled cards to each player and put it in their hand, put as variable to be able to use easier in actual gameplay
		players[0].setPlayerDeck(0, deck);
		players[1].setPlayerDeck(26, deck);
		Card[] playerOneDeck = players[0].getPlayerDeck();
		Card[] playerTwoDeck = players[1].getPlayerDeck();

		//Fill the and for now loop through until all cards in each hand are compared, updating score and finally round won with no user input
		//goal is to have each turn execute only after user presses Enter key
		//Other goal is to make it so that player wins from best of three rounds
		//Note the below blank lines are just to make formatting easier to read on console
		System.out.println();
		System.out.println("Welcome " + players[0].getName() + " and " + players[1].getName());
		System.out.println();
		System.out.println("Press ENTER to Start!");

		//Logic for multiple rounds - first player to 2 rounds won wins the entire game, max number of rounds possible in one game is 3, will break out of outer loop when a player
		// gets to 2 rounds won.
		int totalRounds = 1; //used to keep track of all rounds, to incorporate tie logic, j is used for best of 3 mechanic, refactor this to be more concise in future
		for(int j = 1; j <= 4; j++) {

			//to create a new shuffled deck for each round (since deck already created for first round, only does this round 2 and on)
			// Need to refactor this


			
			if(players[0].getRoundsWon() < 2 && players[1].getRoundsWon() < 2) {
				
				if(totalRounds > 1 && totalRounds <= 4) {
					System.out.println();
					System.out.println("Press Enter to Continue to the Next Round!");
					deck.createAndShuffleDeck();
					players[0].setPlayerDeck(0, deck);
					players[1].setPlayerDeck(26, deck);
					playerOneDeck = players[0].getPlayerDeck();
					playerTwoDeck = players[1].getPlayerDeck();
				}

				for(int i = 0; i < 26; i++) {

					//this nextLine() is to force the loop to only iterate when the user presses the Enter key, to see a step by step version of the handsoff game
					scanner.nextLine();

					System.out.println("Round " + j + " - Turn " + (i + 1));

					if(playerOneDeck[i].getFaceValue() > playerTwoDeck[i].getFaceValue()) {
						players[0].setRoundScore(players[0].getRoundScore() + 1);
					} else if (playerOneDeck[i].getFaceValue() < playerTwoDeck[i].getFaceValue()) {
						players[1].setRoundScore(players[1].getRoundScore() + 1);
					} else {
						if(playerOneDeck[i].getSuitValue() > playerTwoDeck[i].getSuitValue()) {
							players[0].setRoundScore(players[0].getRoundScore() + 1);
						} else {
							players[1].setRoundScore(players[1].getRoundScore() + 1);
						}
					}
					System.out.println(playerOneDeck[i].getFace() + " of " + playerOneDeck[i].getSuit() + " VS. " + playerTwoDeck[i].getFace() + " of " + playerTwoDeck[i].getSuit());
					System.out.println(players[0].getName() + ": " + players[0].getRoundScore() + "    " + players[1].getName() + ": " + players[1].getRoundScore());
				}

				System.out.println();
				System.out.println("Press Enter to see Round Summary!");
				scanner.nextLine();

			} else if(players[0].getRoundsWon() == 2) {
				System.out.println();
				System.out.println(players[0].getName() + " won the game with a total of 2 rounds to " + players[1].getRoundsWon() + "!");
				//break statement to account for the 2-0 case, so a third game isn't played unnecessarily, but if on third round, it would exit loop regardless
				break;
			} else if(players[1].getRoundsWon() == 2) {
				System.out.println();
				System.out.println(players[1].getName() + " won the game with a total of 2 rounds to " + players[0].getRoundsWon() + "!");
				//break statement to account for the 2-0 case, so a third game isn't played unnecessarily, but if on third round, it would exit loop regardless
				break;
			}

			if(players[0].getRoundScore() > players[1].getRoundScore()) {
				System.out.println(players[0].getName() + " is the winner of the round with a total of " + players[0].getRoundScore() + " points!");
				players[0].setRoundsWon(players[0].getRoundsWon() + 1);
			} else if(players[0].getRoundScore() < players[1].getRoundScore()) {
				System.out.println(players[1].getName() + " is the winner of the round with a total of " + players[1].getRoundScore() + " points!");
				players[1].setRoundsWon(players[1].getRoundsWon() + 1);
			} else {
				System.out.println("It was a tie! No-one receives a point for this round.");
				j--;
			}
			players[0].setRoundScore(0);
			players[1].setRoundScore(0);

			System.out.println();
			System.out.println("The current round score is " + players[0].getName() + ": " + players[0].getRoundsWon() + " and " + players[1].getName() + ": " + players[1].getRoundsWon());

			totalRounds++;

		}

	scanner.close();
	}

}