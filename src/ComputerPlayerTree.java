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

public class ComputerPlayerTree // **** use your first name
{
    private final String      _name = "Brayden Cheek Tree";    // **** change it to your name
    private final char        _symbol;
    private int 			  turn=0;
//    private int[][][][] 	moves = {{{{1, 1}}, {}, {}}, {{}, {{0,0}, {0,1}, {0,2}, {1,0}, {1,2}, {2,0}, {2,1}, {2,2}}, {}}, {{}, {}, {}}};
    private String			game = "";

    public ComputerPlayerTree(char symbol) // **** use your first name
    {
	_symbol = symbol;
    }

    public char getSymbol()
    {
	return _symbol;
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

//	int    myRow = 0, myCol = 0;  // row and column of my move
	char   mySymbol = _symbol;    // my symbol
	char   oppSymbol;             // opponent's symbol    
	if (mySymbol == 'X')          // find the opponent's symbol
	    oppSymbol = 'O';
	else
	    oppSymbol = 'X';

	char[][] board = boardObj.getBoard(); // board in 2D array
	
	turn = getTurn(board);

	// **** add instructions for my strategy to decide myRow and myCol
	game += Integer.toString(oppLastMove[0]) + Integer.toString(oppLastMove[1]);
	
	switch (turn) {
	case 0:
		return new int[] {0, 0};
	case 1:
		if (game=="11") return new int[] {0, 0};
		else return new int[] {1, 1};
	case 2:
		if (game=="11" || game=="10" || game=="20") return new int[] {0, 1};
		if (game=="01" || game=="02") return new int[] {1, 0};
		if (game=="12") return new int[] {1, 1};
		else return new int[] {0, 2};
	case 3:
		break;
	case 4:
		break;
	case 5:
		break;
	case 6:
		break;
	case 7:
		break;
	case 8:
		break;
	}
	
	
	
//	for (int myRow=0; myRow<Board.SIZE; myRow++) for (int myCol=0; myCol<Board.SIZE; myCol++) {
//		for (int[] oppMove: moves[myRow][myCol]) if (oppMove == oppLastMove) return new int[] {myRow, myCol};
//	}





	// return my move (myRow, myCol) as the last step
	return new int[] {-1, -1};
    }

  public static int getTurn(char[][] board) {
  	int turn=0;
  	for (char[] row: board) for (char symbol: row) if (symbol=='O' || symbol=='X') turn++;
  	return turn;
  }
  
 /**
0 + even turns: i start
odd turns: opp starts


Turn 0:
null

Turn 1:
00-22

Turn 2:
01-22

Turn 3:
00-10 00-22 except 11
11 00-22 except 00
12-22 00-22 except 11

Turn 4:
10 00-22 except 01
11 00-22 except 01
20 00-22 except 01
01-02 00-22 except 10
21-22 00-22 except 02
12 00-22 except 11

turn 5: 
00 01
00 02
00 10
00 12
00 20
00 21
00 22
01 00
01 02
01 10
01 12
01 20
01 21
01 22
02 01
02 00
02 10
02 12
02 20
02 21
02 22
10 01
10 02
10 00
10 12
10 20
10 21
10 22


  **/
}