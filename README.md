# War-Card-Game-OOP-Practice
2 Player Card Game (War) - Best of 3 Rounds, Turn By Turn

Made as practice for object oriented programming principles:
  - Several classes linked together through composition
  
Only basic functionality in that there are only 2 players and 52 cards. 
The deck is created from 52 Card objects, using a double nested loop to create the deck
Collections used to shuffle the deck after all 52 Card objects are inside
Each player gets half of the shuffled deck (simply just index 0-25 for player one and index 26-51 for player two)
Rounds and Turns kept track of through a double nested for loop
Each round has 26 turns (number of cards in each player's hand)
Comparisons between players cards are made at the same index of their respective hands going from 0 - 25
Score is incremented for each player if face value of their card is greater than face value of opponents card (Ace - K, valued at 1 - 13 respectively)
In event that face value is the same for both players, the suit value is taken into consideration, in this case if players had 9 of diamonds, and 9 of spades, 9 of spades would win
A round is won by whoever has the highest score by the end of the round
If there is a tie by the end of the round, neither player gets their round score iterated, and the round number is decremented accordingly
Game is won in a best of 3 rounds scenario - outer loop terminated early if either player gets 2 wins before the other player any, results in not unnecessarily playing the third round
