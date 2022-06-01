/**
  Board stores the tic tac toe board and
  provides methods for accessing and checking the board

  @author Philip Chan
  @version 1.0
  @since 1.0
*/

public class Board
{
    /**
       number of cells in each row/column is 3
     */
    public static final int   SIZE = 3; //number of cells in each row/column

    private final char[][]    _board;   //stores the symbols on the board
    private int[]             _lastMove;//last move from a player, [0] is row [1] is col
                                        //-1 if no previous move

    /**
       Unoccupied cells have space characters
    */
    public Board()
    {
	_board = new char[SIZE][SIZE];
	for (int row = 0; row < SIZE; row++)
	    for (int col = 0; col < SIZE; col++)
		{
		    _board[row][col] = ' '; 
		}
	_lastMove = new int[] {-1,-1};  // no previous move
    }
    
//    My Method
    public Board(char[][] board) {
		_board = new char[SIZE][SIZE];
    	for (int row=0; row<3; row++) for (int col=0; col<3; col++) {
    		_board[row][col] = board[row][col];
    	}
		_lastMove = new int[] {-1,-1};  // no previous move
    }

    public Board(Board board)
    {
	_board = new char[SIZE][SIZE];
	for (int row = 0; row < SIZE; row++)
	    for (int col = 0; col < SIZE; col++)
		{
		    _board[row][col] = board._board[row][col]; 
		}
	_lastMove = new int[] {board._lastMove[0], board._lastMove[1]};
    }

    /**
       If there is a winner, return symbol of the winner
       else return space character
       @return symbol of the winner or ' ' if no winner
    */
    public char checkWinner()
    {
	char winner = ' ';  // space means no winner

	// check rows
	int row = 0, col = 0;
	while ((winner == ' ') && (row < SIZE))
	    {
		if (!isEmpty(row, 0) &&
		    getCell(row, 0) == getCell(row, 1) &&
		    getCell(row, 1) == getCell(row, 2))
		    {
			winner = getCell(row, 0);
		    }
		row++;
	    }
	    

	// check columns
	col = 0;
	while ((winner == ' ') && (col < SIZE))
	    {
		if (!isEmpty(0, col) &&
		    getCell(0, col) == getCell(1, col) &&
		    getCell(1, col) == getCell(2, col))
		    {
			winner = getCell(0, col);
		    }
		col++;
	    }
	    

	// check diagonals
	if (winner == ' ')
	    {
		if (!isEmpty(0, 0) &&
		    getCell(0, 0) == getCell(1, 1) &&
		    getCell(1, 1) == getCell(2, 2))
		    {
			winner = getCell(0, 0);
		    }
	    }

	    
	if (winner == ' ')
	    {
		if (!isEmpty(0, 2) &&
		    getCell(0, 2) == getCell(1, 1) &&
		    getCell(1, 1) == getCell(2, 0))
		    {
			winner = getCell(0, 2);
		    }
	    }

	return winner;
    }


    /**
       Get a copy of the board
       @return a COPY of the board
       (so that the user can't change the board)
    */
    public char[][] getBoard()
    {
	char[][] copy = new char[SIZE][SIZE];

	for (int row = 0; row < SIZE; row++)
	    for (int col = 0; col < SIZE; col++)
		{
		    copy[row][col] = _board[row][col]; 
		}

	return copy;
    }


    /**
       Get the content of a cell
       @param row row
       @param col column
       @return content of a cell
    */
    public char getCell(int row, int col)
    {
	char cell = ' ';

	if (isValid(row, col))
	    cell =  _board[row][col];
	else
	    {
		System.out.println("\n** Board.getCell(): Invalid row " + 
				   row + " or column " + col);
		System.out.println("\n** Disqualified **\n");
		System.exit(-1);
	    }

	return cell;
    }


    /**
       Get the last move by a player
       @return [0] is row and [1] is column in int[2], null if no previous move
    */
    public int[] getLastMove()
    {
	if (_lastMove[0] != -1)
	    return new int[] {_lastMove[0], _lastMove[1]};
	else
	    return null;
    }


    /**
       Check if the cell is empty
       @param row row
       @param col column
       @return true if the cell is empty
    */
    public boolean isEmpty(int row, int col)
    {
	return (getCell(row, col) == ' ');
    }


    /**
       Check if the board is full
       @return true is the board is full
    */
    public boolean isFull()
    {
	boolean full = true;
	int     row = 0, col = 0;

	while (full && row < SIZE)
	    {
		if (isEmpty(row, col))
		    full = false;
		col++;
		if (col >= SIZE)
		    {
			row++;
			col = 0;
		    }
	    }

	return full;
    }



    /**
       Check if row and column are within bounds
       @param row row 
       @param col column
       @return true if row and column are within bounds
    */
    public boolean isValid(int row, int col)
    {
	return ((row >= 0) && (row < SIZE) && (col >= 0) && (col < SIZE));
    }



    /**
       Mark a cell with a player symbol
       @param row row
       @param col column
       @param symbol player symbol
    */
    public void markCell(int row, int col, char symbol)
    {
	if (isEmpty(row, col)) // isEmpty calls getCell, which calls isValid
	    {
		_board[row][col] = symbol;
		_lastMove[0] = row;
		_lastMove[1] = col;
	    }
	else
	    {
		System.out.println("\nBoard.markCell(): Invalid row " + 
				   row + " or column " + col
				   + "; occupied by " + getCell(row,col));
		System.out.println("\n** Disqualified **\n");
		System.exit(-1);
		
	    }

    }


    /**
       Print the board
    */
    public void print()
    {
	System.out.print(' ');
	for (int col = 0; col < SIZE; col++)
	    System.out.print(" " + col);
	System.out.println();
	for (int row = 0; row < SIZE; row++)
	    {
		System.out.print(row + " ");
		for (int col = 0; col < SIZE; col++)
		    {
			System.out.print(getCell(row, col));
			if (col < (SIZE - 1))
			    System.out.print('|');
		    }
		System.out.println();
		if (row < (SIZE - 1))
		    System.out.println("  -----");
	    }
    }



    // ignore, testing the Board class
    private static void main(String[] arg)
    {
	Board board = new Board();

	board.markCell(0,0,'X');
	board.markCell(0,1,'O');
	board.markCell(0,2,'O');
	board.markCell(1,0,'O');
	board.markCell(1,1,'X');
	board.markCell(1,2,'X');
	board.markCell(2,0,'X');
	board.markCell(2,1,'O');
	board.markCell(2,2,'O');

	char winner = board.checkWinner();
	if (winner != ' ')
	    System.out.println("Winner is :" + winner);
	else
	    System.out.println("The game is a tie.");
    }

}
