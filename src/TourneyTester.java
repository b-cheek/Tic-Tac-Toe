import java.util.ArrayList;

/*
  Author: Philip Chan

  This is the tournament driver:  
  - play two games: player1 starts first then player2 starts first
  - call the makeAMove(Board) method of each player

*/

public class TourneyTester
{
    // *** to be modified during the tournament
    // *** change class name at two places, player #, and symbol

//    private static final HumanPlayer               player1 = new HumanPlayer('O', "Mickie");
//    private static final HumanPlayer               player2 = new HumanPlayer('X', "Minnie");

    private static final ComputerPlayerSN	   	   player1 = new ComputerPlayerSN('X');
//    private static final ComputerPlayerAliH	   player2 = new ComputerPlayerAliH('O');
    private static final ComputerPlayerSN	   player2 = new ComputerPlayerSN('O');
//    private static final ComputerPlayerPrune	   player2 = new ComputerPlayerPrune('O');
    
//    private static final TypeWriterMonkey		player2 = new TypeWriterMonkey('O');
//    private static final ComputerPlayerDong    player2 = new ComputerPlayerDong('X');


    //private static final ComputerPlayerAdam      player1 = new ComputerPlayerAdam('X');
    //private static final ComputerPlayerAlex      player1 = new ComputerPlayerAlex('X');
    //private static final ComputerPlayerAvi       player2 = new ComputerPlayerAvi('O');
    //private static final ComputerPlayerCharlene  player2 = new ComputerPlayerCharlene('O');
    //private static final ComputerPlayerHannah    player2 = new ComputerPlayerHannah('O');
    //private static final ComputerPlayerJosh      player1 = new ComputerPlayerJosh('X');
    //private static final ComputerPlayerMadison   player1 = new ComputerPlayerMadison('X');
    //private static final ComputerPlayerMatt      player2 = new ComputerPlayerMatt('O');
    //private static final ComputerPlayerMekhi     player2 = new ComputerPlayerMekhi('O');
    //private static final ComputerPlayerMorgan    player1 = new ComputerPlayerMorgan('X');
    //private static final ComputerPlayerNicole    player2 = new ComputerPlayerNicole('O'); 
    //private static final ComputerPlayerPeter     player2 = new ComputerPlayerPeter('O'); 
    //private static final ComputerPlayerRohan     player2 = new ComputerPlayerRohan('O'); 
    //private static final ComputerPlayerZyekeel   player1 = new ComputerPlayerZyekeel('X'); 

    // ********************* 

    private static char _StartingPlayerSymbol;
   
    public static void main(String[] arg)
    {
	if (player1.getSymbol() != player2.getSymbol())
	{
		int player1Wins = 0;
		double n = 10000000.0;
		long avgTime1 = 0;
		long avgTime2 = 0;
		int oppWins = 0;
		System.out.println("Completion%");
		for (int i=1; i<=n; i++) {
//			System.out.printf("---------- GAME %d ----------%n", i);
			long[] times = playGame(i%2+1);
			avgTime1+=times[0];
			avgTime2+=times[1];
//			System.out.println(player1.getName() + " " + times[0]);
//			System.out.println(player2.getName() + " " + times[1]);
			if (times[0]<times[1]) player1Wins++;
			if (i%(n/100)==0) System.out.println(i/(n/100));
			if (times[2]==2) oppWins++;
		}
		
		System.out.println(oppWins);
		System.out.println("Player 2 won " + (oppWins/n)*100.0 + "% of games");
		System.out.println("\n\nplayer 1 avg: " + avgTime1/n + "\nplayer 2 avg: " + avgTime2/n);
		System.out.println("\nPlayer 1 was faster " + player1Wins + " times");
		System.out.println("Player 2 was faster " + (int)(n-player1Wins) + " times");
	}
	else
	    System.out.println("** Error: Both players have the same symbol " + 
			       player1.getSymbol() + " **");
    }


    // play one game, startingPlayer specifies which player to start first
    public static long[] playGame(int startingPlayer)
    {
	_StartingPlayerSymbol = 
	    (startingPlayer == 1) ? player1.getSymbol() : player2.getSymbol();
	
//	System.out.println("Player " + player1.getSymbol() + 
//			   " (" + player1.getName() + "): ");
//	System.out.println("Player " + player2.getSymbol() + 
//			   " (" + player2.getName() + "): ");
//	System.out.println("Player " + 
//			   _StartingPlayerSymbol +
//			   " starts\n");
	
	Board board = new Board();

	char  winner = ' ';           // symbol of winner, blank=no winner
	int   count1 = 0, count2 = 0; // number of moves for player1 and 2
	long  startTime, 
	      elapsed1=0, elapsed2=0; // elapsed time for player1 and 2
	int   turn = startingPlayer;  // whose turn?


	// keep playing if no winner and the board is not full
	int[] move = null;
	Board boardCopy = null;
	long winnerReturn = 0;
	while ((winner == ' ') && !board.isFull())
	    {
		boardCopy = new Board(board);
		// alternate turns
		if (turn == 1)
		    {
//			System.out.println("Player " + player1.getSymbol() + " (" +
//					   player1.getName() + ") is thinking...");
			startTime = System.nanoTime();
			move = player1.makeAMove(boardCopy);
			elapsed1 += System.nanoTime() - startTime;
			if (move != null) {
			    board.markCell(move[0], move[1], player1.getSymbol());
			}
			else
			    fatalError(player1.getSymbol() +
				       ": no move was specified (null returned from makeAMove())");
			count1++;
			turn = 2;
		    }
		else
		    {
//			System.out.println("Player " + player2.getSymbol() + " (" +
//					   player2.getName() + ") is thinking...");
			startTime = System.nanoTime();
			move = player2.makeAMove(boardCopy);
			elapsed2 += System.nanoTime() - startTime;
			if (move != null) {
			    board.markCell(move[0], move[1], player2.getSymbol());
			}
			else
			    fatalError(player2.getSymbol() + 
				       ": no move was specified (null returned from makeAMove())");
			count2++;
			turn = 1;
		    }

		// display and check for winner
//		System.out.println();
//		board.print();
		winner = board.checkWinner();
		
		winnerReturn = (winner==player1.getSymbol() ? 1 : (winner==player2.getSymbol()) ? 2 : 0);
//		pause();
//		System.out.println();
	    }


	// print winner
//	if (winner != ' ')
//	    System.out.println("Player " + winner + " won the game.");
//	else
//	    System.out.println("The game is a tie.");

	// print average elapsed time
//	if ((count1 > 0) && (count2 > 0))
//	    {
//		System.out.println("Player " + player1.getSymbol() + 
//				   " (" + player1.getName() + 
//				   ")--average elapsed time per move: " +
//				   elapsed1 / 1000 / count1 +
//				   " microseconds");
//		System.out.println("Player " + player2.getSymbol() + 
//				   " (" + player2.getName() + 
//				   ")--average elapsed time per move: " +
//				   elapsed2 / 1000 / count2 +
//				   " microseconds\n");
//	    }

	if (winnerReturn==2) board.print();
	
	return new long[] {elapsed1 / 1000 / count1, elapsed2 / 1000 / count2, winnerReturn};
    }


    // print msg and exit
    private static void fatalError(String msg)
    {
	System.out.println("*** " + msg + " ***");
	System.exit(-1);
    }

    // pause to output until the user types a return
    private static void pause()
    {
	int response;

	System.out.print("Type return to continue...");
	try
	    {
		response = System.in.read();
	    }
	catch (Exception e)
	    {
		System.err.println(e.getMessage());
		System.exit(-1);
	    }
    }

    public static char getStartingPlayer()
    {
	return _StartingPlayerSymbol;
    }
    
    public static int getTurn(char[][] board) {
    	int turn=0;
    	for (char[] row: board) for (char symbol: row) if (symbol=='O' || symbol=='X') turn++;
    	return turn;
    }

}