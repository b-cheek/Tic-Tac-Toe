import java.util.*;

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

public class TypeWriterMonkey // **** use your first name
{
    private final String      _name = "Monkey";    // **** change it to your name
    private final char        _symbol;

    public TypeWriterMonkey(char symbol) // **** use your first name
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

	int    myRow = 0, myCol = 0;  // row and column of my move
	char   mySymbol = _symbol;    // my symbol
	char   oppSymbol;             // opponent's symbol    
	if (mySymbol == 'X')          // find the opponent's symbol
	    oppSymbol = 'O';
	else
	    oppSymbol = 'X';

	char[][] board = boardObj.getBoard(); // board in 2D array

	// **** add instructions for my strategy to decide myRow and myCol

	Random randMoveGenerator = new Random();
	
	do {
		myRow = randMoveGenerator.nextInt(Board.SIZE);
		myCol = randMoveGenerator.nextInt(Board.SIZE);
	} while (board[myRow][myCol]!=' ');





	// return my move (myRow, myCol) as the last step
	int[] myMove = new int[] {myRow, myCol};
	return myMove;
    }
}