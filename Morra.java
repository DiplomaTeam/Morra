/**
NCIRL Diploma in Computing: CA4
Elmarie Fryer, Filip Minarik, Raymond Oconnor & Heino Vakkilainen
*/

// Import Java utilities for use in this program
import java.util.Scanner;				// for input/output via the command line - used to test the program
import javax.swing.JOptionPane;			// for input/output via the java pane - used for the final program
import java.util.Random;				// to generate random numbers for use by the player's opponent (the computer)

public class Morra {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

// declare a variable to store the user's input and computer imput
		int choiceNumberPlayer = 11; // Player chooses number to play. Default 11 to force loop
		int choiceNumberComputer = 11; // Number computer plays for round. Random Each round
		int playerChoiceOdds = 3; // Chooses 1 for Odds and 0 for Evens. 3 to ensure loop at start
		String playerChoiceOddsText = "NA"; // Text "Odd" or "Even" .
		int playerPoints = 0; // How many points player has won
		int computerPoints = 0; // How many points computer has won each Game
		int playerPointsBonus = 0; //bonus point counter for Player. Not storing computer bonus point as not needed at end
		Random rand = new Random(); // Random variable used to randomize computer chose


//declare a variable for history
	String[] historyOddorEven; historyOddorEven = new String [100]; //history if odd or Even won
	String[] historyGameWinner; historyGameWinner = new String [100]; //history of game winners
	int[] HistoryOfChoisesComputer; HistoryOfChoisesComputer = new int [100]; ////history of what choises computer made
	int[] historyOfChoisesPlayer; historyOfChoisesPlayer = new int [100]; //history of what choises user made
	int[] historyOfBonusPoint; historyOfBonusPoint = new int [100]; //history of what choises user made
	int[] historyPointsPerRound; historyPointsPerRound = new int [100]; //history of points per round
	int[] historyWinsPlayer; historyWinsPlayer = new int [100]; //store history of round winners

// declare a variable to Game related
		int resultChoisesCombined; //combine Player and Computer number choice
		int gamePointsTotal = 0; // store round winner points, to make sure game ends when 6 is reached
		String Continue = "y"; // To allow Player to choose to Y to continue game
		String gameWinner = "Na"; // Name of winner (Player or Computer)
		String oddOrEven = "Na"; // text. Replace as Odd if combined is Odd. Even if result is Even

		int sumRound = 0; // sum of round winners. Used at end for totals
		int sumTotal = 0; //sum of total points.  Used at end for totals
		int sumBonus = 0; //sum of bonus points.  Used at end for totals

		int r = 0; // used to count rounds
		int g = 0; // used to count games
		int len = 0; //used to store length of round

	// Game input - start with a welcome message
		JOptionPane.showMessageDialog(null, "WELCOME to Morra v1.1\nGame created by: Elmarie Fryer, Filip Minarik, Raymond Oconnor & Heino Vakkilainen\n\nIn this variation of the game, one player is going to be the “Odds” player and the other player is the “Evens” player.\nIn each round of the game, the players will simultaneously hold out between 1 and 10 ﬁngers.\nThe winner of the round is decided based on the sum of ﬁngers shown by both players,\nnamely if the sum is an even number then the “Evens” player wins,\notherwise if the sum is an odd number then the “Odds” player wins\nThe winner of the round receives two points.\nIn addition, the player whose number of fingers is closer to the sum, receives one extra point.");


//while loop while player chooses Odd or Even
while (playerChoiceOdds > 1) {
		System.out.println("Enter 1 (Odd) or 0 (Even) ");
		System.out.print("Choice can not be changed after this point without restarting the game: ");
		playerChoiceOdds = sc.nextInt();}

			if (playerChoiceOdds == 1){playerChoiceOddsText = "Odd";} //text so can be used later.
			if (playerChoiceOdds == 0){playerChoiceOddsText = "Even";} //text so can be used later.
			System.out.println(" ");

while (Continue.equals("y")) {  //while loop until Player chooses not to press Y at end of Game
while (gamePointsTotal < 6)		{  // while loop while Player or Computer have under 6 points.

while (choiceNumberPlayer > 10) //while loop until player chooses 0 to 10
					{	System.out.print("Choose number to play (0 to 10): ");
						choiceNumberPlayer = sc.nextInt();}

// ACTUAL GAME STARTS
	choiceNumberComputer = rand.nextInt(10) + 1; //Computer chooses random number
	rand = new Random();
	r = r + 1; //adding 1 to round counter.

	historyOfChoisesPlayer[r] = choiceNumberPlayer;	//store computer and player choises - storing user choise
	HistoryOfChoisesComputer[r] = choiceNumberComputer; 	//store computer and player choises storing - computer choise
	resultChoisesCombined = choiceNumberPlayer + choiceNumberComputer;		// to make choice odd or Evens

	JOptionPane.showMessageDialog(null,"Your choice was: " + choiceNumberPlayer+"\nComputer choice was: " + choiceNumberComputer+"\nCombined this is: " + resultChoisesCombined);


// if clause for if Player was closer. Give player 1 bonus point
		if (choiceNumberPlayer > choiceNumberComputer) {
			playerPoints = playerPoints + 1; //if player was closer give 1 point
			playerPointsBonus = 1; } 	// store 1 bonus point to counter.

// if clause for if Player and computer equally far from Result. Give both 1 point
					if (choiceNumberPlayer == choiceNumberComputer) {
						playerPoints = playerPoints + 1; computerPoints = computerPoints + 1;  //give both 1 point.
						playerPointsBonus = 1;} // store 1 bonus point to counter.


// Else clause for if Computer was closer. give computer 1 point
if (choiceNumberPlayer < choiceNumberComputer) {
	playerPoints = playerPoints + 0; 	computerPoints = computerPoints + 1; // if computer closer give computer 1 point
	playerPointsBonus = 0;}

// Storing into history
	historyOfBonusPoint[r] = playerPointsBonus; //storing bonus point into history
	historyPointsPerRound[r] = historyOfBonusPoint[r]; //storing points into round history

// Math to understand if Odd or Even
	resultChoisesCombined = resultChoisesCombined % 2; //dividing to find out if odd or Even
	if (resultChoisesCombined == 0){ oddOrEven = "Even";} //
	if (resultChoisesCombined == 1){ oddOrEven = "Odd ";} //
	historyOddorEven[r] = oddOrEven; //storing odd or Even

	JOptionPane.showMessageDialog(null,"This is: " + oddOrEven + "-number. You are playing as " + playerChoiceOddsText);

// Player gets 2 points if same choise
if (resultChoisesCombined == playerChoiceOdds)
	{	playerPoints = playerPoints + 2; //adding one to player wins
		gamePointsTotal = playerPoints; //to make sure game ends when Computer reaches 6 wins
		gameWinner = "Player"; // name winner each round
  		historyPointsPerRound[r] = historyPointsPerRound[r] + 2; //adding 2 if won
		historyWinsPlayer[r] = 1; //adding 1 if player won round
		JOptionPane.showMessageDialog(null,"You WIN!");	}

// Computer gets 2 points if Player did not get
else {
			computerPoints = computerPoints + 2; //adding one to computer wins
			gamePointsTotal = computerPoints; //to make sure game ends when Computer reaches 6 wins
			gameWinner = "Computer"; // name winner each round
			historyWinsPlayer[r] = 0; //adding 0 as player lost round
			JOptionPane.showMessageDialog(null,"You LOSE!");	}

// Show results of Round.
	JOptionPane.showMessageDialog(null,"Player who is closes receives a bonus point.\nYou received "+ playerPointsBonus + " bonus points.\n\nPoints this game are:\nYou have Received: " + playerPoints + " points\nComputer has Received: " + computerPoints + " points");

choiceNumberPlayer = 11 ; //setting to 11 to force loop again.

//adding to ensure game ends if one player wins round, but other gets 6 points via Bonus point.
if (computerPoints == 6 && playerPoints < 6){gamePointsTotal = computerPoints; gameWinner = "Computer";}
if (playerPoints == 6 && computerPoints < 6){gamePointsTotal = playerPoints; gameWinner = "Player";}

			} // While (gamePointsTotal < 6)

	// AFTER PLAYER HAS 6 points.
		JOptionPane.showMessageDialog(null,"Game ends\nThank you for playing.\nWinner is "+gameWinner);


g = g + 1; // Add one to G (game counter)
historyGameWinner[g] = gameWinner; //Store Game winner into String

// Section to print numbers chosen by user.
System.out.println("***   ***   ***   ***   ***   ***");
System.out.print("Do you want to continue (Press Y to continue. Press Any Other key to exit): ");
Continue = sc.next();
gamePointsTotal = 0; // Resetting before next game
playerPoints = 0; // Resetting  before next game
computerPoints = 0; // Resetting before nect game

} //while (Continue.equals("y"))

// AFTER USER ENDS GAME
	JOptionPane.showMessageDialog(null,"HISTORY: \nYou were playing as "+ playerChoiceOddsText);

	len = r; r = 0; // Store round counter (r) into length (len). Zero out r

	while (r < len) {
		r = r + 1; //adding 1 to round counter.
 		JOptionPane.showMessageDialog(null,"Round: " + r + " - " + historyOddorEven[r] + " - \nYour choice: " + historyOfChoisesPlayer[r]+"\n - Computer choice: " + HistoryOfChoisesComputer[r]);
 
  		}

// Print totals

			r = 0; 	//zeroing r (round) as used counter above.
			while (r < len)
					{r = r + 1;
					sumRound = sumRound + historyWinsPlayer[r]; //loop to sum player wins
					sumTotal = sumTotal + historyPointsPerRound[r]; //loop to sum all
					sumBonus = sumBonus + historyOfBonusPoint[r]; } 	//loop to sum all
					JOptionPane.showMessageDialog(null,"Total rounds won was: " + sumRound + " out of " + r + " rounds\nTotal points you received are: " + sumTotal+"\nTotal Extra Points you received are: " + sumBonus);

	// print game winners
	JOptionPane.showMessageDialog(null,"Game results were: ");
		len = g; g = 0; //moving length to len, and then zero game counter.
		while (g < len){g = g + 1;
			JOptionPane.showMessageDialog(null,"Game winner: " + g + " - " + historyGameWinner[g]);}

	// Game ends
		JOptionPane.showMessageDialog(null,"Thank you for playing.\nMorra v.1.1\nGame created by: Elmarie Fryer, Filip Minarik, Raymond Oconnor & Heino Vakkilainen");							

} //	end of public static void main(String args[])
} //  end of public class Morra
