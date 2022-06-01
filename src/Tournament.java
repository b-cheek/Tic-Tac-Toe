/*
  Author: Philip Chan

  This is the tournament driver:  
  - play two games: player1 starts first then player2 starts first
  - call the makeAMove(Board) method of each player

*/

public class Tournament
{
    // *** to be modified during the tournament
    // *** change class name at two places, player #, and symbol

//    private static final HumanPlayer               player1 = new HumanPlayer('O', "Mickie");
//    private static final HumanPlayer               player2 = new HumanPlayer('X', "Minnie");

    private static final ComputerPlayerSN	   player1 = new ComputerPlayerSN('X');
//    private static final ComputerPlayerBraydenC	   player1 = new ComputerPlayerBraydenC('X');
//    private static final ComputerPlayerAliH	   player1 = new ComputerPlayerAliH('X');
//    private static final ComputerPlayerPrune	   player1 = new ComputerPlayerPrune('X');
//    private static final ComputerPlayerSmartDict	   player1 = new ComputerPlayerSmartDict('X');
//    private static final ComputerPlayerSmartHash1	   player1 = new ComputerPlayerSmartHash1('X');
//    private static final ComputerPlayerArrDict	   player1 = new ComputerPlayerArrDict('X');
//    private static final TypeWriterMonkey	   player1 = new TypeWriterMonkey('X');

    private static final ComputerPlayerSN	   player2 = new ComputerPlayerSN('O');
//    private static final ComputerPlayerBraydenC	   player2 = new ComputerPlayerBraydenC('O');
//    private static final ComputerPlayerAliH	   player2 = new ComputerPlayerAliH('O');
//    private static final ComputerPlayerPrune	   player2 = new ComputerPlayerPrune('O');
//    private static final ComputerPlayerSmartDict	   player2 = new ComputerPlayerSmartDict('O');
//    private static final ComputerPlayerSmartHash	   player2 = new ComputerPlayerSmartHash('O');
//    private static final ComputerPlayerArrDict	   player2 = new ComputerPlayerArrDict('O');
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


    private static char _StartingPlayerSymbol;  // symbol of starting player
   
    public static void main(String[] arg)
    {
	if (player1.getSymbol() != player2.getSymbol())
	    {
		System.out.println("---------- FIRST GAME ----------");
		playGame(1);
		pause();

		System.out.println("\n---------- SECOND GAME ----------");
		playGame(2);
	    }
	else
	    System.out.println("** Error: Both players have the same symbol " + 
			       player1.getSymbol() + " **");
    }


    // play one game, startingPlayer specifies which player to start first
    public static void playGame(int startingPlayer)
    {
	_StartingPlayerSymbol = 
	    startingPlayer == 1 ? player1.getSymbol() : player2.getSymbol();
	
	System.out.println("Player " + player1.getSymbol() + 
			   " (" + player1.getName() + "): ");
	System.out.println("Player " + player2.getSymbol() + 
			   " (" + player2.getName() + "): ");
	System.out.println("Player " + 
			   _StartingPlayerSymbol +
			   " starts\n");

	Board board = new Board();

	char  winner = ' ';           // symbol of winner, blank=no winner
	int   count1 = 0, count2 = 0; // number of moves for player1 and 2
	long  startTime, 
	      elapsed1=0, elapsed2=0; // elapsed time for player1 and 2
	int   turn = startingPlayer;  // whose turn?


	// keep playing if no winner and the board is not full
	int[] move = null;
	Board boardCopy = null;
	while ((winner == ' ') && !board.isFull())
	    {
		boardCopy = new Board(board);
		// alternate turns
		if (turn == 1)
		    {
			System.out.println("Player " + player1.getSymbol() + " (" +
					   player1.getName() + ") is thinking...");
			startTime = System.nanoTime();
			move = player1.makeAMove(boardCopy);
			elapsed1 += System.nanoTime() - startTime;
			if (move != null)
			    board.markCell(move[0], move[1], player1.getSymbol());
			else
			    fatalError(player1.getSymbol() +
				       ": no move was specified (null returned from makeAMove())");
			count1++;
			turn = 2;
		    }
		else
		    {
			System.out.println("Player " + player2.getSymbol() + " (" +
					   player2.getName() + ") is thinking...");
			startTime = System.nanoTime();
			move = player2.makeAMove(boardCopy);
			elapsed2 += System.nanoTime() - startTime;
			if (move != null)
			    board.markCell(move[0], move[1], player2.getSymbol());
			else
			    fatalError(player2.getSymbol() + 
				       ": no move was specified (null returned from makeAMove())");
			count2++;
			turn = 1;
		    }

		// display and check for winner
		System.out.println();
		board.print();
		winner = board.checkWinner();

		pause();
		System.out.println();
	    }


	// print winner
	if (winner != ' ')
	    System.out.println("Player " + winner + " won the game.");
	else
	    System.out.println("The game is a tie.");

	// print average elapsed time
	if ((count1 > 0) && (count2 > 0))
	    {
		System.out.println("Player " + player1.getSymbol() + 
				   " (" + player1.getName() + 
				   ")--average elapsed time per move: " +
				   elapsed1 / 1000 / count1 +
				   " microseconds");
		System.out.println("Player " + player2.getSymbol() + 
				   " (" + player2.getName() + 
				   ")--average elapsed time per move: " +
				   elapsed2 / 1000 / count2 +
				   " microseconds");
	    }
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

}
