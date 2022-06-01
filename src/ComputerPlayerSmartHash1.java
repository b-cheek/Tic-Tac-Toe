import java.util.Arrays;
import java.util.HashMap;

/**
  Name: 
  E-mail address: 
  Course: 
  Section: 
  Assignment: 
  Date: 

  Template Author: Philip Chan
  Modify:
  1.  class/constructor name: ComputerPlayerFirst, eg. ComputerPlayerJohn
  2.  attribute _name: your name
  3.  makeAMove() method

  Description: My modified version of the computer player to play in the Tic-Tac-Toe tournament.

*/

public class ComputerPlayerSmartHash1 // **** use your first name
{
    private final String      _name = "Brayden Cheek H0";    // **** change it to your name
    private final char        mySymbol;
    private final char        oppSymbol;
    private int 			  turn = 0;
    private HashMap<String, int[]> moves0 = new HashMap<String, int[]>();
    private HashMap<String, int[]> moves1 = new HashMap<String, int[]>();
    private HashMap<String, int[]> moves2 = new HashMap<String, int[]>();
    private HashMap<String, int[]> moves3 = new HashMap<String, int[]>();
    private HashMap<String, int[]> moves4 = new HashMap<String, int[]>();
    private HashMap<String, int[]> moves5 = new HashMap<String, int[]>();
    private HashMap<String, int[]> moves6 = new HashMap<String, int[]>();
    private HashMap<String, int[]> moves7 = new HashMap<String, int[]>();
    private HashMap<String, int[]> moves8 = new HashMap<String, int[]>();
	private static int[] winningPatterns = {
	         0b111000000, 0b000111000, 0b000000111, // rows
	         0b100100100, 0b010010010, 0b001001001, // cols
	         0b100010001, 0b001010100               // diagonals
	   };
    
    
    public ComputerPlayerSmartHash1(char symbol) // **** use your first name
    {
	mySymbol = symbol;
	if (mySymbol=='X') {
		oppSymbol = 'O';
		moves1.put("   O     ", new int[] {1, 1});
		moves3.put("   OX   O", new int[] {2, 1});
		moves5.put(" O OX  XO", new int[] {0, 2});
		moves0.put("         ", new int[] {1, 1});
		moves2.put("    X   O", new int[] {0, 0});
		moves1.put("     O   ", new int[] {1, 1});
		moves3.put("    XOO  ", new int[] {2, 1});
		moves2.put("  O X    ", new int[] {2, 0});
		moves1.put("      O  ", new int[] {1, 1});
		moves3.put("  O X O  ", new int[] {1, 2});
		moves2.put("    X O  ", new int[] {0, 2});
		moves1.put("    O    ", new int[] {0, 0});
		moves3.put("X  OO    ", new int[] {1, 2});
		moves5.put("X  OOX O ", new int[] {0, 1});
		moves2.put("O   X    ", new int[] {2, 2});
		moves4.put("O O X   X", new int[] {0, 1});
		moves3.put(" O  XO   ", new int[] {2, 2});
		moves2.put("    XO   ", new int[] {0, 0});
		moves1.put(" O       ", new int[] {1, 1});
		moves3.put(" O  X  O ", new int[] {1, 2});
		moves2.put(" O  X    ", new int[] {0, 0});
		moves3.put("XO  O    ", new int[] {2, 1});
		moves5.put("XO  O  XO", new int[] {2, 0});
		moves7.put("XO OO XXO", new int[] {1, 2});
		moves2.put("    X  O ", new int[] {0, 0});
		moves3.put("    X OO ", new int[] {2, 2});
		moves1.put("       O ", new int[] {1, 1});
		moves3.put("    X  OO", new int[] {2, 0});
		moves5.put("  O X XOO", new int[] {1, 2});
		moves7.put("  OOXXXOO", new int[] {0, 0});
		moves2.put("   OX    ", new int[] {0, 0});
		moves3.put(" O  X O  ", new int[] {1, 2});
		moves5.put(" O OXXO  ", new int[] {0, 0});
		moves4.put("X O X   O", new int[] {1, 2});
		moves6.put("X OOXX  O", new int[] {2, 1});
		moves8.put("XOOOXX XO", new int[] {2, 0});
		moves3.put("  O XO   ", new int[] {2, 2});
		moves3.put("   OX O  ", new int[] {0, 0});
		moves1.put("  O      ", new int[] {1, 1});
		moves3.put(" OO X    ", new int[] {0, 0});
		moves5.put("XOO X   O", new int[] {1, 2});
		moves7.put("XOOOXX  O", new int[] {2, 0});
		moves3.put("OO  X    ", new int[] {0, 2});
		moves5.put("OOX X O  ", new int[] {1, 0});
		moves7.put("OOXXXOO  ", new int[] {2, 2});
		moves1.put("O        ", new int[] {1, 1});
		moves3.put("O   X O  ", new int[] {1, 0});
		moves4.put("O X X O  ", new int[] {1, 0});
		moves6.put("O XXXOO  ", new int[] {2, 1});
		moves8.put("OOXXXOOX ", new int[] {2, 2});
		moves3.put("  O X  O ", new int[] {1, 2});
		moves4.put("  X X O O", new int[] {2, 1});
		moves5.put(" O  XOOX ", new int[] {0, 0});
		moves3.put("  OOX    ", new int[] {2, 1});
		moves3.put("X O O    ", new int[] {2, 0});
		moves3.put("    X O O", new int[] {2, 1});
		moves5.put(" O  X OXO", new int[] {1, 2});
		moves7.put(" O OXXOXO", new int[] {0, 0});
		moves3.put("X   O  O ", new int[] {0, 1});
		moves3.put("O  OX    ", new int[] {2, 0});
		moves4.put("  O X X O", new int[] {1, 2});
		moves3.put("X   OO   ", new int[] {1, 0});
		moves3.put("O   XO   ", new int[] {2, 1});
		moves6.put("OXO X  OX", new int[] {1, 2});
		moves8.put("OXOOXX OX", new int[] {2, 0});
		moves3.put("O   X   O", new int[] {1, 2});
		moves5.put("O  OXX  O", new int[] {2, 0});
		moves5.put("X  OX O O", new int[] {2, 1});
		moves3.put("   OXO   ", new int[] {2, 1});
		moves1.put("        O", new int[] {1, 1});
		moves3.put(" O  X   O", new int[] {1, 2});
		moves4.put("O   X O X", new int[] {1, 0});
		moves3.put("O O X    ", new int[] {0, 1});
		moves5.put("X OOO X  ", new int[] {1, 2});
		moves7.put("X OOOXXO ", new int[] {0, 1});
		moves3.put(" O OX    ", new int[] {0, 0});
		moves5.put(" OOOX  X ", new int[] {0, 0});
		moves5.put("OO  XO X ", new int[] {0, 2});
		moves5.put("X OOOX   ", new int[] {2, 0});
		moves5.put("XO OX   O", new int[] {2, 0});
		moves3.put("    XO  O", new int[] {0, 2});
		moves5.put("  X XOO O", new int[] {2, 1});
		moves7.put(" OX XOOXO", new int[] {0, 0});
		moves3.put("O   X  O ", new int[] {1, 2});
		moves5.put(" O OXX  O", new int[] {2, 0});
		moves4.put("O O X X  ", new int[] {0, 1});
		moves5.put("XO OOX   ", new int[] {2, 1});
		moves7.put("XO OOXOX ", new int[] {0, 2});
		moves3.put("   OX  O ", new int[] {2, 2});
		moves3.put("    XO O ", new int[] {2, 2});
		moves5.put("O   XO OX", new int[] {2, 0});
		moves5.put("O OOX X  ", new int[] {0, 1});
		moves5.put("  OOXX O ", new int[] {0, 0});
		moves5.put("XO  O OX ", new int[] {0, 2});
		moves7.put("XOXOO OX ", new int[] {1, 2});
		moves5.put("OXO X  O ", new int[] {1, 2});
		moves5.put("OO  XO  X", new int[] {0, 2});
		moves5.put("O  OXX O ", new int[] {2, 0});
		moves7.put("O OOXXXO ", new int[] {0, 1});
		moves7.put("X OOXX OO", new int[] {2, 0});
		moves5.put("O  XXOO  ", new int[] {2, 1});
		moves5.put("X  XOOO  ", new int[] {0, 2});
		moves7.put("XOOOOXX  ", new int[] {2, 1});
		moves6.put("O  XXOO X", new int[] {2, 1});
		moves8.put("OO XXOOXX", new int[] {0, 2});
		moves4.put("X   X O O", new int[] {2, 1});
		moves7.put("XO OX OXO", new int[] {0, 2});
		moves3.put("  O X   O", new int[] {1, 2});
		moves7.put("XOOOOX X ", new int[] {2, 0});
		moves3.put("X   O O  ", new int[] {0, 2});
		moves5.put("XOX O O  ", new int[] {2, 1});
		moves7.put("XOX O OXO", new int[] {1, 0});
		moves5.put("XO OO  X ", new int[] {1, 2});
		moves6.put("XO  X OXO", new int[] {1, 2});
		moves8.put("XO OXXOXO", new int[] {0, 2});
		moves5.put("  OOXXO  ", new int[] {0, 0});
		moves7.put("X OOXXO O", new int[] {2, 1});
		moves3.put("X   O   O", new int[] {0, 2});
		moves5.put("O   X OOX", new int[] {1, 0});
		moves5.put("O  OX  OX", new int[] {2, 0});
		moves7.put("O OOX XOX", new int[] {0, 1});
		moves7.put("OOX XOOX ", new int[] {1, 0});
		moves7.put("XXOOOX O ", new int[] {2, 0});
		moves7.put(" OXOX OXO", new int[] {0, 0});
		moves5.put("X  OOX  O", new int[] {0, 2});
		moves7.put("XOXOOX  O", new int[] {2, 1});
		moves6.put("  OOXXX O", new int[] {2, 1});
		moves8.put(" OOOXXXXO", new int[] {0, 0});
		moves7.put("O  XXOOOX", new int[] {0, 2});
		moves7.put("OXOOXX O ", new int[] {2, 0});
		moves7.put(" OOOXXX O", new int[] {0, 0});
		moves7.put("XO OXXO O", new int[] {2, 1});
		moves5.put("O O XO  X", new int[] {0, 1});
		moves7.put("XO  XOOXO", new int[] {0, 2});
		moves6.put(" OX X OXO", new int[] {1, 2});
		moves7.put("XO OOX XO", new int[] {0, 2});
		moves7.put("XOOOX  XO", new int[] {1, 2});
		moves5.put("XO  OO X ", new int[] {1, 0});
		moves6.put("OXO X XO ", new int[] {1, 2});
		moves7.put("OOX XOO X", new int[] {1, 0});
		moves5.put("  OOXX  O", new int[] {2, 1});
		moves8.put(" OXOXXOXO", new int[] {0, 0});
		moves7.put("OXO XO OX", new int[] {2, 0});
		moves8.put("OXOOXXXO ", new int[] {2, 2});
		moves5.put("XOX O   O", new int[] {2, 1});
		moves5.put("XXO O  O ", new int[] {2, 0});
		moves7.put("OXOOX XO ", new int[] {2, 2});
		moves7.put("XOX OOOX ", new int[] {1, 0});
		moves7.put("X OOOXX O", new int[] {0, 1});
		moves7.put("XOXXOOO  ", new int[] {2, 1});
		moves7.put("O O XOXOX", new int[] {0, 1});
		moves7.put("O OOXXX O", new int[] {0, 1});
		moves7.put("XOOOX X O", new int[] {1, 2});
		moves7.put("XXOOO XO ", new int[] {1, 2});
		moves7.put(" OOOXX XO", new int[] {0, 0});
		moves7.put("XO XOOOX ", new int[] {0, 2});
		moves7.put("XOX OO XO", new int[] {1, 0});
		moves7.put("XOXOO  XO", new int[] {1, 2});
		moves7.put("OO XXOOX ", new int[] {0, 2});
	}
	else { // my symbol is O
		oppSymbol = 'X';
		moves1.put("   X     ", new int[] {1, 1});
		moves3.put("   XO   X", new int[] {2, 1});
		moves5.put(" X XO  OX", new int[] {0, 2});
		moves0.put("         ", new int[] {1, 1});
		moves2.put("    O   X", new int[] {0, 0});
		moves1.put("     X   ", new int[] {1, 1});
		moves3.put("    OXX  ", new int[] {2, 1});
		moves2.put("  X O    ", new int[] {2, 0});
		moves1.put("      X  ", new int[] {1, 1});
		moves3.put("  X O X  ", new int[] {1, 2});
		moves2.put("    O X  ", new int[] {0, 2});
		moves1.put("    X    ", new int[] {0, 0});
		moves3.put("O  XX    ", new int[] {1, 2});
		moves5.put("O  XXO X ", new int[] {0, 1});
		moves2.put("X   O    ", new int[] {2, 2});
		moves4.put("X X O   O", new int[] {0, 1});
		moves3.put(" X  OX   ", new int[] {2, 2});
		moves2.put("    OX   ", new int[] {0, 0});
		moves1.put(" X       ", new int[] {1, 1});
		moves3.put(" X  O  X ", new int[] {1, 2});
		moves2.put(" X  O    ", new int[] {0, 0});
		moves3.put("OX  X    ", new int[] {2, 1});
		moves5.put("OX  X  OX", new int[] {2, 0});
		moves7.put("OX XX OOX", new int[] {1, 2});
		moves2.put("    O  X ", new int[] {0, 0});
		moves3.put("    O XX ", new int[] {2, 2});
		moves1.put("       X ", new int[] {1, 1});
		moves3.put("    O  XX", new int[] {2, 0});
		moves5.put("  X O OXX", new int[] {1, 2});
		moves7.put("  XXOOOXX", new int[] {0, 0});
		moves2.put("   XO    ", new int[] {0, 0});
		moves3.put(" X  O X  ", new int[] {1, 2});
		moves5.put(" X XOOX  ", new int[] {0, 0});
		moves4.put("O X O   X", new int[] {1, 2});
		moves6.put("O XXOO  X", new int[] {2, 1});
		moves8.put("OXXXOO OX", new int[] {2, 0});
		moves3.put("  X OX   ", new int[] {2, 2});
		moves3.put("   XO X  ", new int[] {0, 0});
		moves1.put("  X      ", new int[] {1, 1});
		moves3.put(" XX O    ", new int[] {0, 0});
		moves5.put("OXX O   X", new int[] {1, 2});
		moves7.put("OXXXOO  X", new int[] {2, 0});
		moves3.put("XX  O    ", new int[] {0, 2});
		moves5.put("XXO O X  ", new int[] {1, 0});
		moves7.put("XXOOOXX  ", new int[] {2, 2});
		moves1.put("X        ", new int[] {1, 1});
		moves3.put("X   O X  ", new int[] {1, 0});
		moves4.put("X O O X  ", new int[] {1, 0});
		moves6.put("X OOOXX  ", new int[] {2, 1});
		moves8.put("XXOOOXXO ", new int[] {2, 2});
		moves3.put("  X O  X ", new int[] {1, 2});
		moves4.put("  O O X X", new int[] {2, 1});
		moves5.put(" X  OXXO ", new int[] {0, 0});
		moves3.put("  XXO    ", new int[] {2, 1});
		moves3.put("O X X    ", new int[] {2, 0});
		moves3.put("    O X X", new int[] {2, 1});
		moves5.put(" X  O XOX", new int[] {1, 2});
		moves7.put(" X XOOXOX", new int[] {0, 0});
		moves3.put("O   X  X ", new int[] {0, 1});
		moves3.put("X  XO    ", new int[] {2, 0});
		moves4.put("  X O O X", new int[] {1, 2});
		moves3.put("O   XX   ", new int[] {1, 0});
		moves3.put("X   OX   ", new int[] {2, 1});
		moves6.put("XOX O  XO", new int[] {1, 2});
		moves8.put("XOXXOO XO", new int[] {2, 0});
		moves3.put("X   O   X", new int[] {1, 2});
		moves5.put("X  XOO  X", new int[] {2, 0});
		moves5.put("O  XO X X", new int[] {2, 1});
		moves3.put("   XOX   ", new int[] {2, 1});
		moves1.put("        X", new int[] {1, 1});
		moves3.put(" X  O   X", new int[] {1, 2});
		moves4.put("X   O X O", new int[] {1, 0});
		moves3.put("X X O    ", new int[] {0, 1});
		moves5.put("O XXX O  ", new int[] {1, 2});
		moves7.put("O XXXOOX ", new int[] {0, 1});
		moves3.put(" X XO    ", new int[] {0, 0});
		moves5.put(" XXXO  O ", new int[] {0, 0});
		moves5.put("XX  OX O ", new int[] {0, 2});
		moves5.put("O XXXO   ", new int[] {2, 0});
		moves5.put("OX XO   X", new int[] {2, 0});
		moves3.put("    OX  X", new int[] {0, 2});
		moves5.put("  O OXX X", new int[] {2, 1});
		moves7.put(" XO OXXOX", new int[] {0, 0});
		moves3.put("X   O  X ", new int[] {1, 2});
		moves5.put(" X XOO  X", new int[] {2, 0});
		moves4.put("X X O O  ", new int[] {0, 1});
		moves5.put("OX XXO   ", new int[] {2, 1});
		moves7.put("OX XXOXO ", new int[] {0, 2});
		moves3.put("   XO  X ", new int[] {2, 2});
		moves3.put("    OX X ", new int[] {2, 2});
		moves5.put("X   OX XO", new int[] {2, 0});
		moves5.put("X XXO O  ", new int[] {0, 1});
		moves5.put("  XXOO X ", new int[] {0, 0});
		moves5.put("OX  X XO ", new int[] {0, 2});
		moves7.put("OXOXX XO ", new int[] {1, 2});
		moves5.put("XOX O  X ", new int[] {1, 2});
		moves5.put("XX  OX  O", new int[] {0, 2});
		moves5.put("X  XOO X ", new int[] {2, 0});
		moves7.put("X XXOOOX ", new int[] {0, 1});
		moves7.put("O XXOO XX", new int[] {2, 0});
		moves5.put("X  OOXX  ", new int[] {2, 1});
		moves5.put("O  OXXX  ", new int[] {0, 2});
		moves7.put("OXXXXOO  ", new int[] {2, 1});
		moves6.put("X  OOXX O", new int[] {2, 1});
		moves8.put("XX OOXXOO", new int[] {0, 2});
		moves4.put("O   O X X", new int[] {2, 1});
		moves7.put("OX XO XOX", new int[] {0, 2});
		moves3.put("  X O   X", new int[] {1, 2});
		moves7.put("OXXXXO O ", new int[] {2, 0});
		moves3.put("O   X X  ", new int[] {0, 2});
		moves5.put("OXO X X  ", new int[] {2, 1});
		moves7.put("OXO X XOX", new int[] {1, 0});
		moves5.put("OX XX  O ", new int[] {1, 2});
		moves6.put("OX  O XOX", new int[] {1, 2});
		moves8.put("OX XOOXOX", new int[] {0, 2});
		moves5.put("  XXOOX  ", new int[] {0, 0});
		moves7.put("O XXOOX X", new int[] {2, 1});
		moves3.put("O   X   X", new int[] {0, 2});
		moves5.put("X   O XXO", new int[] {1, 0});
		moves5.put("X  XO  XO", new int[] {2, 0});
		moves7.put("X XXO OXO", new int[] {0, 1});
		moves7.put("XXO OXXO ", new int[] {1, 0});
		moves7.put("OOXXXO X ", new int[] {2, 0});
		moves7.put(" XOXO XOX", new int[] {0, 0});
		moves5.put("O  XXO  X", new int[] {0, 2});
		moves7.put("OXOXXO  X", new int[] {2, 1});
		moves6.put("  XXOOO X", new int[] {2, 1});
		moves8.put(" XXXOOOOX", new int[] {0, 0});
		moves7.put("X  OOXXXO", new int[] {0, 2});
		moves7.put("XOXXOO X ", new int[] {2, 0});
		moves7.put(" XXXOOO X", new int[] {0, 0});
		moves7.put("OX XOOX X", new int[] {2, 1});
		moves5.put("X X OX  O", new int[] {0, 1});
		moves7.put("OX  OXXOX", new int[] {0, 2});
		moves6.put(" XO O XOX", new int[] {1, 2});
		moves7.put("OX XXO OX", new int[] {0, 2});
		moves7.put("OXXXO  OX", new int[] {1, 2});
		moves5.put("OX  XX O ", new int[] {1, 0});
		moves6.put("XOX O OX ", new int[] {1, 2});
		moves7.put("XXO OXX O", new int[] {1, 0});
		moves5.put("  XXOO  X", new int[] {2, 1});
		moves8.put(" XOXOOXOX", new int[] {0, 0});
		moves7.put("XOX OX XO", new int[] {2, 0});
		moves8.put("XOXXOOOX ", new int[] {2, 2});
		moves5.put("OXO X   X", new int[] {2, 1});
		moves5.put("OOX X  X ", new int[] {2, 0});
		moves7.put("XOXXO OX ", new int[] {2, 2});
		moves7.put("OXO XXXO ", new int[] {1, 0});
		moves7.put("O XXXOO X", new int[] {0, 1});
		moves7.put("OXOOXXX  ", new int[] {2, 1});
		moves7.put("X X OXOXO", new int[] {0, 1});
		moves7.put("X XXOOO X", new int[] {0, 1});
		moves7.put("OXXXO O X", new int[] {1, 2});
		moves7.put("OOXXX OX ", new int[] {1, 2});
		moves7.put(" XXXOO OX", new int[] {0, 0});
		moves7.put("OX OXXXO ", new int[] {0, 2});
		moves7.put("OXO XX OX", new int[] {1, 0});
		moves7.put("OXOXX  OX", new int[] {1, 2});
		moves7.put("XX OOXXO ", new int[] {0, 2});
	}
    }

    public char getSymbol()
    {
	return mySymbol;
    }

    public String getName()
    {
	return _name;
    }

    public int[] makeAMove(Board boardObj)
    {
	char   startingPlayer = Tournament.getStartingPlayer(); // symbol of starting player
	int[]  oppLastMove = boardObj.getLastMove(); // where the opponent moved to last
	int    oppLastRow = -1, oppLastCol = -1; // row and column of opponent's last move

	if (oppLastMove != null)  // there is a last move from the opponent
	    {
		oppLastRow = oppLastMove[0];
		oppLastCol = oppLastMove[1]; 
	    } // else I'm making the first move, the opponent couldn't have made a move

	//----------------------------
	// accessing the board obj
	// boardObj.isEmpty(row, col)   returns whether the cell is empty
	// boardObj.getCell(row, col)   returns the content of the cell
	//----------------------------

	int    myRow = 0, myCol = 0;  // row and column of my move

	char[][] board = boardObj.getBoard(); // board in 2D array
//	long startTime = System.nanoTime();
	turn = getTurn(board);
//	long elapsedTime = System.nanoTime() - startTime;
//	System.out.println("elapsed" + elapsedTime);

	// **** add instructions for my strategy to decide myRow and myCol

	long startTime = System.nanoTime();
	int[] move = null;
	
	switch (turn) {
	case 0:
		move = moves0.get(boardToString(board));
		break;
	case 1:
		move = moves1.get(boardToString(board));
		break;
	case 2:
		move = moves2.get(boardToString(board));
		break;
	case 3:
		move = moves3.get(boardToString(board));
		break;
	case 4:
		move = moves4.get(boardToString(board));
		break;
	case 5:
		move = moves5.get(boardToString(board));
		break;
	case 6:
		move = moves6.get(boardToString(board));
		break;
	case 7:
		move = moves7.get(boardToString(board));
		break;
	case 8:
		move = moves8.get(boardToString(board));
		break;
	}
	long elapsedTime = System.nanoTime() - startTime;
	System.out.println("elapsed" + elapsedTime);
	if (move!=null) return move;
	
//	for (int row=0; row<Board.SIZE; row++) for (int col=0; col<Board.SIZE; col++) {
//		if (board[row][col] == ' ') {
//			board[row][col] = _symbol;
//			if (hasWon(_symbol, board)) return new int[] {row, col};
//			board[row][col] = ' ';
//		}
//	}
//	
//	for (int row=0; row<Board.SIZE; row++) for (int col=0; col<Board.SIZE; col++) {
//		if (board[row][col] == ' ') {
//			int winCount = 0;
//			board[row][col] = _symbol;
//			for (int deepRow=0; deepRow<Board.SIZE; deepRow++) for (int deepCol = 0; deepCol < Board.SIZE; deepCol ++) {
//				if (board[deepRow][deepCol] == ' ') {
//					board[deepRow][deepCol] = _symbol;
//					if (hasWon(_symbol, board)) winCount++;
//					board[deepRow][deepCol] = ' ';
//				}
//			}
//			if (winCount>1) return new int[] {row, col};
//		}
//	}

	int[] myMove = rule12(board);
	if (myMove[0]!=-1) return myMove;
	myMove = rule34(board);
	if (myMove[0]!=-1) return myMove;


	// return my move (myRow, myCol) as the last step
//	int[] myMove = new int[] {myRow, myCol};
//	return myMove;
	return new int[] {-1, -1};
    }

    public static String boardToString(char[][] board) {
    	String result = "";
    	for (char[] row: board) for (char symbol: row) result+=symbol;
    	return result;
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
    
    private int[] rule12(char[][] board) {
  	  //	rules 1 & 2
  		int[] rowTotals = new int[Board.SIZE];
  		int[] colTotals = new int[Board.SIZE];
//  			rows
  		for (int row=0; row<Board.SIZE; row++) {
  			for (int col=0; col<Board.SIZE; col++) {
  				if (board[row][col]!=' ') rowTotals[row]+= (board[row][col]==mySymbol) ? 1 : -1;
  			}
  		}
//  			cols
  		for (int col=0; col<Board.SIZE; col++) {
  			for (int row=0; row<Board.SIZE; row++) {
  				if (board[row][col]!=' ') colTotals[col]+= (board[row][col]==mySymbol) ? 1 : -1;
  			}
  		}
  		
//  		check / diags
  		for (int row=0; row<Board.SIZE; row++) if (rowTotals[row]==2) for (int col=0; col<Board.SIZE; col++) if (board[row][col]==' ') return new int[] {row, col};
  		for (int col=0; col<Board.SIZE; col++) if (colTotals[col]==2) for (int row=0; row<Board.SIZE; row++) if (board[row][col]==' ') return new int[] {row, col};
  		if (board[1][1]==mySymbol) {
  			if (board[0][0]==mySymbol && board[2][2]==' ') return new int[] {2, 2};
  			if (board[0][2]==mySymbol && board[2][0]==' ') return new int[] {2, 0};
  			if (board[2][0]==mySymbol && board[0][2]==' ') return new int[] {0, 2};
  			if (board[2][2]==mySymbol && board[0][0]==' ') return new int[] {0, 0};
  		}
  		for (int row=0; row<Board.SIZE; row++) if (rowTotals[row]==-2) for (int col=0; col<Board.SIZE; col++) if (board[row][col]==' ') return new int[] {row, col};
  		for (int col=0; col<Board.SIZE; col++) if (colTotals[col]==-2) for (int row=0; row<Board.SIZE; row++) if (board[row][col]==' ') return new int[] {row, col};
  		if (board[1][1]==oppSymbol) {
  			if (board[0][0]==oppSymbol && board[2][2]==' ') return new int[] {2, 2};
  			if (board[0][2]==oppSymbol && board[2][0]==' ') return new int[] {2, 0};
  			if (board[2][0]==oppSymbol && board[0][2]==' ') return new int[] {0, 2};
  			if (board[2][2]==oppSymbol && board[0][0]==' ') return new int[] {0, 0};
  		}
  		
  		return new int[] {-1, -1};
  	  }
    
    private int[] rule34(char[][] board) {
  	  int[] forkRows = new int[Board.SIZE];
  	  int[] forkCols = new int[Board.SIZE];
  	  int[] forkDiags = new int[2];
  	  boolean[][] oppForkSpots = new boolean[Board.SIZE][Board.SIZE];
  	  for (int row=0; row<Board.SIZE; row++) {
  			for (int col=0; col<Board.SIZE; col++) {
  				if (board[row][col]!=' ') forkRows[row]+= (board[row][col]==mySymbol) ? 1 : -2;
  			}
  		}
//  			cols
  		for (int col=0; col<Board.SIZE; col++) {
  			for (int row=0; row<Board.SIZE; row++) {
  				if (board[row][col]!=' ') forkCols[col]+= (board[row][col]==mySymbol) ? 1 : -2;
  			}
  		}
//  			diagonals  
  		for (int diag=0; diag<Board.SIZE; diag++) {
  			if (board[diag][diag]!=' ') forkDiags[0]+= (board[diag][diag]==mySymbol) ? 1 : -2;
  			if (board[diag][2-diag]!=' ') forkDiags[1]+= (board[diag][2-diag]==mySymbol) ? 1 : -2;
  		}
  		
//  		my forks, find opp forks for later
  		for (int row=0; row<Board.SIZE; row++) {
  			for (int col=0; col<Board.SIZE; col++) {
  				if (board[row][col]==' ') {
  					if (forkRows[row] == forkCols[col]) {
  						if (forkRows[row] == 1) return new int[] {row, col};
  						if (forkRows[row] == -2) oppForkSpots[row][col] = true;
  					}
  				}
  			}
  			if (forkRows[row] == 1) {
  				if (forkDiags[0] == 1 && board[row][row] == ' ') return new int[] {row, row};
  				if (forkDiags[1] == 1 && board[row][2-row] == ' ') return new int[] {row, 2-row};
  			}
  			if (forkRows[row] == -2) {
  				if (forkDiags[0] == -2 && board[row][row] == ' ') oppForkSpots[row][row] = true;
  				if (forkDiags[1] == -2 && board[row][2-row] == ' ') oppForkSpots[row][2-row] = true;
  			}
  		}
  		for (int col=0; col<Board.SIZE; col++) {
  			if (forkCols[col] == 1) {
  				if (forkDiags[0] == 1 && board[col][col] == ' ') return new int[] {col, col};
  				if (forkDiags[1] == 1 && board[2-col][col] == ' ') return new int[] {2-col, col};
  			}
  			if (forkCols[col] == -2) {
  				if (forkDiags[0] == -2 && board[col][col] == ' ') oppForkSpots[col][col] = true;
  				if (forkDiags[1] == -2 && board[2-col][col] == ' ') oppForkSpots[2-col][col] = true;
  			}
  		}
  		if (board[1][1]==' ') {
  			if (forkDiags[0] == forkDiags[1])  {
  				if (forkDiags[0] == 1) return new int[] {1, 1};
  				if (forkDiags[0] == -2) oppForkSpots[1][1] = true;
  			}
  		}
  		
//  		opp forks
  		for (int i=0; i<Board.SIZE; i++) {
  			if (forkRows[i]==1) {
  				for (int j=0; j<Board.SIZE; j++) {
  					if (board[i][j]!=mySymbol && !oppForkSpots[i][j]) {
  						board[i][j] = 'n';
  						for (int findEmpty=0; findEmpty<Board.SIZE; findEmpty++) if (board[i][findEmpty]==' ') return new int[] {i, findEmpty};
  					}
  				}
  			}
  		}
  		for (int i=0; i<Board.SIZE; i++) {
  			if (forkCols[i]==1) {
  				for (int j=0; j<Board.SIZE; j++) {
  					if (board[j][i]!=mySymbol && !oppForkSpots[j][i]) {
  						board[j][i] = 'n';
  						for (int findEmpty=0; findEmpty<Board.SIZE; findEmpty++) if (board[findEmpty][i]==' ') return new int[] {findEmpty, i};
  					}
  				}
  			}
  		}
  		if (forkDiags[0]==1) {
  			for (int i=0; i<Board.SIZE; i++) {
  				if (board[i][i]!=mySymbol && !oppForkSpots[i][i]) {
  					board[i][i] = 'n';
  					for (int findEmpty = 0; findEmpty<Board.SIZE; findEmpty++) if (board[findEmpty][findEmpty]==' ') return new int[] {findEmpty, findEmpty};
  				}
  			}
  		}
  		if (forkDiags[1]==1) {
  			for (int i=0; i<Board.SIZE; i++) {
  				if (board[i][2-i]!=mySymbol && !oppForkSpots[i][2-i]) {
  					board[i][2-i] = 'n';
  					for (int findEmpty = 0; findEmpty<Board.SIZE; findEmpty++) if (board[findEmpty][2-findEmpty]==' ') return new int[] {findEmpty, 2-findEmpty};
  				}
  			}
  		}
  		return new int[] {-1, -1};
    }
    
}