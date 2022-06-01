import java.util.*;

/*
  Author: Philip Chan

  This is the tournament driver:  
  - play two games: player1 starts first then player2 starts first
  - call the makeAMove(Board) method of each player

*/

public class TourneyTester0
{
	
	private static int[] winningPatterns = {
	         0b111000000, 0b000111000, 0b000000111, // rows
	         0b100100100, 0b010010010, 0b001001001, // cols
	         0b100010001, 0b001010100               // diagonals
	   };
	
    // *** to be modified during the tournament
    // *** change class name at two places, player #, and symbol

//    private static final HumanPlayer               player1 = new HumanPlayer('O', "Mickie");
//    private static final HumanPlayer               player2 = new HumanPlayer('X', "Minnie");

    private static final ComputerPlayerSN	   player1 = new ComputerPlayerSN('X');
    private static final ComputerPlayerPrune	   player2 = new ComputerPlayerPrune('O');
    private static final ComputerPlayerAliH		   player3 = new ComputerPlayerAliH('O');
    private static final ComputerPlayerSN		   player4 = new ComputerPlayerSN('O');
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
    private static char[][][][][][] movesArr = new char[9][3][3][2][3][3];
    
    public static void main(String[] arg)
    {
    for (char[][][][][] a: movesArr) for (char[][][][] b: a) for (char[][][] c: b) for (char[][] d: c) d[0][0] = 'n';
	if (player1.getSymbol() != player2.getSymbol())
	    {
		double n = 100;
		for (int gameNum=1; gameNum<=n; gameNum++) {
			playGame(gameNum%2+1);
			playGame3(gameNum%2+1);
			playGame4(gameNum%2+1);
		}
	    }
	else
	    System.out.println("** Error: Both players have the same symbol " + 
			       player1.getSymbol() + " **");
//	for (int a=0; a<9; a++) for (int b=0; b<Board.SIZE; b++) for (int c=0; c<Board.SIZE; c++) {
//		for (char[][] arr: movesArr[a][b][c]) {
//			System.out.println("board:");
//			for (char[] row: arr) for (char symbol: row) {
//				System.out.print(symbol);
//			}
//			System.out.println("\nTurn: "+ a);
//			System.out.println("Move: ["+ b + "][" + c + "]\n");
//		}
//	}
	
//	for (int i=0; i<999; i++) {
//		System.out.println("New RBoard " + i);
//		Board randBoard = new Board(getRandomBoard());
//		int[] move=player1.makeAMove(randBoard);
//		boolean found = false;
//		for (int j=0; j<100 && !found; j++) {
//			System.out.println(j);
//			if (movesArr[getTurn(randBoard.getBoard())][move[0]][move[1]][j][0][0]=='n' || Arrays.deepEquals(movesArr[getTurn(randBoard.getBoard())][move[0]][move[1]][j], randBoard.getBoard())) {
//				movesArr[getTurn(randBoard.getBoard())][move[0]][move[1]][j]=randBoard.getBoard();
//				found=true;
//				System.out.println("Inserted");
//			}
//		}
//	}
	
	System.out.println(printArr(movesArr));
	String realDict = printArr(movesArr);
	for (int i=0; i<100000; i++) {
		realDict = realDict.replace("{n, ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}", "");
	}
	System.out.println(realDict);
	for (int i=0; i<100000; i++) {
		realDict = realDict.replace("\n{}, ", "");
	}
	System.out.println(realDict);
	for (int i=0; i<100000; i++) {
		realDict = realDict.replace("\n{}", "");
	}
	System.out.println(realDict);
	System.out.println("XXXXXXXXXXXXXXXXXX");
	for (int i=0; i<100000; i++) {
		realDict = realDict.replace("mySymbol", "'X'");
		realDict = realDict.replace("oppSymbol", "'O'");
	}
	System.out.println(realDict);
	
//	for (int i=0; i<99999; i++) {
//		System.out.println();
//		for (char[] row: getRandomBoard()) {
//			System.out.println();
//			for (char symbol: row) System.out.print(symbol + " ");
//		}
//	}
	
    }


    // play one game, startingPlayer specifies which player to start first
    public static void playGame(int startingPlayer)
    {
	_StartingPlayerSymbol = 
	    startingPlayer == 1 ? player1.getSymbol() : player2.getSymbol();
	
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
//				System.out.println("Turn: " + getTurn(board.getBoard()));
//				System.out.print("Board: {");
//				for (char[] row: board.getBoard()) {
//					System.out.print("{");
//					for (char symbol: row) {
//						System.out.printf("%s, ", (symbol==player1.getSymbol()) ? "mySymbol" : (symbol==player2.getSymbol()) ? "oppSymbol" : "' '");
//					}
//					System.out.print("}, ");
//				}
//				System.out.println("}\nMove: [" + move[0] + ", " + move[1] + "]\n");
				boolean found = false;
				for (int i=0; i<2 && !found; i++) {
					if (movesArr[getTurn(board.getBoard())][move[0]][move[1]][i][0][0]=='n' || Arrays.deepEquals(movesArr[getTurn(board.getBoard())][move[0]][move[1]][i], board.getBoard())) {
						movesArr[getTurn(board.getBoard())][move[0]][move[1]][i]=board.getBoard();
						found=true;
					}
				}
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
			if (move != null)
			    board.markCell(move[0], move[1], player2.getSymbol());
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
//				   " microseconds");
//	    }
    }
// play one game, startingPlayer specifies which player to start first
    public static void playGame3(int startingPlayer)
    {
	_StartingPlayerSymbol = 
	    startingPlayer == 1 ? player1.getSymbol() : player3.getSymbol();
	
//	System.out.println("Player " + player1.getSymbol() + 
//			   " (" + player1.getName() + "): ");
//	System.out.println("Player " + player3.getSymbol() + 
//			   " (" + player3.getName() + "): ");
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
//				System.out.println("Turn: " + getTurn(board.getBoard()));
//				System.out.print("Board: {");
//				for (char[] row: board.getBoard()) {
//					System.out.print("{");
//					for (char symbol: row) {
//						System.out.printf("%s, ", (symbol==player1.getSymbol()) ? "mySymbol" : (symbol==player3.getSymbol()) ? "oppSymbol" : "' '");
//					}
//					System.out.print("}, ");
//				}
//				System.out.println("}\nMove: [" + move[0] + ", " + move[1] + "]\n");
				boolean found = false;
				for (int i=0; i<2 && !found; i++) {
					if (movesArr[getTurn(board.getBoard())][move[0]][move[1]][i][0][0]=='n' || Arrays.deepEquals(movesArr[getTurn(board.getBoard())][move[0]][move[1]][i], board.getBoard())) {
						movesArr[getTurn(board.getBoard())][move[0]][move[1]][i]=board.getBoard();
						found=true;
					}
				}
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
//			System.out.println("Player " + player3.getSymbol() + " (" +
//					   player3.getName() + ") is thinking...");
			startTime = System.nanoTime();
			move = player3.makeAMove(boardCopy);
			elapsed2 += System.nanoTime() - startTime;
			if (move != null)
			    board.markCell(move[0], move[1], player3.getSymbol());
			else
			    fatalError(player3.getSymbol() + 
				       ": no move was specified (null returned from makeAMove())");
			count2++;
			turn = 1;
		    }

		// display and check for winner
//		System.out.println();
//		board.print();
		winner = board.checkWinner();

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
//		System.out.println("Player " + player3.getSymbol() + 
//				   " (" + player3.getName() + 
//				   ")--average elapsed time per move: " +
//				   elapsed2 / 1000 / count2 +
//				   " microseconds");
//	    }
    }
    
public static void playGame4(int startingPlayer)
    {
	_StartingPlayerSymbol = 
	    startingPlayer == 1 ? player1.getSymbol() : player4.getSymbol();
	
//	System.out.println("Player " + player1.getSymbol() + 
//			   " (" + player1.getName() + "): ");
//	System.out.println("Player " + player3.getSymbol() + 
//			   " (" + player3.getName() + "): ");
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
//				System.out.println("Turn: " + getTurn(board.getBoard()));
//				System.out.print("Board: {");
//				for (char[] row: board.getBoard()) {
//					System.out.print("{");
//					for (char symbol: row) {
//						System.out.printf("%s, ", (symbol==player1.getSymbol()) ? "mySymbol" : (symbol==player3.getSymbol()) ? "oppSymbol" : "' '");
//					}
//					System.out.print("}, ");
//				}
//				System.out.println("}\nMove: [" + move[0] + ", " + move[1] + "]\n");
				boolean found = false;
				for (int i=0; i<2 && !found; i++) {
					if (movesArr[getTurn(board.getBoard())][move[0]][move[1]][i][0][0]=='n' || Arrays.deepEquals(movesArr[getTurn(board.getBoard())][move[0]][move[1]][i], board.getBoard())) {
						movesArr[getTurn(board.getBoard())][move[0]][move[1]][i]=board.getBoard();
						found=true;
						System.out.println(i);
					}
				}
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
//			System.out.println("Player " + player3.getSymbol() + " (" +
//					   player3.getName() + ") is thinking...");
			startTime = System.nanoTime();
			move = player4.makeAMove(boardCopy);
			elapsed2 += System.nanoTime() - startTime;
			if (move != null)
			    board.markCell(move[0], move[1], player4.getSymbol());
			else
			    fatalError(player4.getSymbol() + 
				       ": no move was specified (null returned from makeAMove())");
			count2++;
			turn = 1;
		    }

		// display and check for winner
//		System.out.println();
//		board.print();
		winner = board.checkWinner();

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
//		System.out.println("Player " + player3.getSymbol() + 
//				   " (" + player3.getName() + 
//				   ")--average elapsed time per move: " +
//				   elapsed2 / 1000 / count2 +
//				   " microseconds");
//	    }
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
    
    public static boolean hasWon(char thePlayer, char[][] board) {
	      int pattern = 0b000000000;  // 9-bit pattern for the 9 cells
	      for (int row = 0; row < Board.SIZE; ++row) {
	         for (int col = 0; col < Board.SIZE; ++col) {
	            if (board[row][col] == thePlayer) {
	               pattern |= (1 << (row * Board.SIZE + col));
	            }
	         }
	      }
	      for (int winningPattern : winningPatterns) {
	         if ((pattern & winningPattern) == winningPattern) return true;
	      }
	      return false;
	   }
    
    public static boolean isValid(char[][] board) {
    	int xCount = 0;
    	int oCount = 0;
    	for (char[] row: board) for (char symbol: row) {
    		if (symbol=='X') xCount++;
    		if (symbol=='O') oCount++;
    	}
    	if (xCount+oCount>8) return false;
    	if (xCount-oCount<-1 || xCount-oCount>0) return false;
    	if (hasWon('X', board) || hasWon('O', board)) return false; 
    	return true;
    }
    
    public static char[][] getRandomBoard() {
    	char[][] board = new char[3][3];
    	Random rand = new Random();
    	do 
    	{
    	for (int row=0; row<3; row++) for (int col=0; col<3; col++) {
    		int symbolSeed = rand.nextInt(3);
    		board[row][col] = (symbolSeed==0) ? 'X' : (symbolSeed==1) ? 'O' : ' ';
    	}
    	} while (!isValid(board));
    	return board;
    }
    
    public static String printArr(char[][][][][][] arr) {
    	String result = "";
    	result += ("{");
    	for (char[][][][][] a: arr) {
    		result += ("{");
    		for (char[][][][] b: a) {
    			result += ("{");
    			for (char[][][] c: b) {
    				result += ("{");
    				for (char[][] d: c) {
    					result += ("\n{");
    					for (char[] e: d) {
    						result += ("{");
    						for (char f: e) {
    							result += (f==player1.getSymbol()) ? "mySymbol, " : (f==player2.getSymbol()) ? "oppSymbol, " : (f=='n') ? f + ", " : "' ', ";
    						}
							result = result.substring(0,result.length()-2);
    						result += ("}, ");
    					}
						result = result.substring(0,result.length()-2);
    					result += ("}, ");
    				}
					result = result.substring(0,result.length()-2);
    				result += ("}, ");
    			}
				result = result.substring(0,result.length()-2);
    			result += ("}, ");
    		}
			result = result.substring(0,result.length()-2);
    		result += ("}, ");
    	}
		result = result.substring(0,result.length()-2);
    	result += ("}");
    	return result;
    }
}