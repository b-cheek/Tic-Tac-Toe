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

import java.util.*;
public class ComputerPlayerPrune // **** use your first name
{
    private final String      _name = "Brayden Cheek's Pruner";    // **** change it to your name
    private final char        mySymbol;
    private final char		  oppSymbol;
    private char[][]		  cells;

    public ComputerPlayerPrune(char symbol) // **** use your first name
    {
	mySymbol = symbol;
	oppSymbol = (mySymbol=='X') ? 'O' : 'X';
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

	cells = boardObj.getBoard(); // board in 2D array

	// **** add instructions for my strategy to decide myRow and myCol

	int[] result = minimax(2, mySymbol, Integer.MIN_VALUE, Integer.MAX_VALUE);

	// return my move (myRow, myCol) as the last step
	int[] myMove = new int[] {result[1], result[2]};
	return myMove;
    }
    
    /** Minimax (recursive) at level of depth for maximizing or minimizing player
    with alpha-beta cut-off. Return int[3] of {score, row, col}  */
	private int[] minimax(int depth, char player, int alpha, int beta) {
	   // Generate possible next moves in a list of int[2] of {row, col}.
	   List<int[]> nextMoves = generateMoves();

	   // mySymbol is maximizing; while oppSymbol is minimizing
	   int score;
	   int bestRow = -1;
	   int bestCol = -1;

	   if (nextMoves.isEmpty() || depth == 0) {
		  // Gameover or depth reached, evaluate score
		  score = evaluate();
		  return new int[] {score, bestRow, bestCol};
	   } else {
		  for (int[] move : nextMoves) {
			 // try this move for the current "player"
			 cells[move[0]][move[1]] = player;
			 if (player == mySymbol) {  // mySymbol (computer) is maximizing player
				score = minimax(depth - 1, oppSymbol, alpha, beta)[0];
				if (score > alpha) {
				   alpha = score;
				   bestRow = move[0];
				   bestCol = move[1];
				}
			 } else {  // oppSymbol is minimizing player
				score = minimax(depth - 1, mySymbol, alpha, beta)[0];
				if (score < beta) {
				   beta = score;
				   bestRow = move[0];
				   bestCol = move[1];
				}
			 }
			 // undo move
			 cells[move[0]][move[1]] = ' ';
			 // cut-off
			 if (alpha >= beta) break;
		  }
		  return new int[] {(player == mySymbol) ? alpha : beta, bestRow, bestCol};
	   }
	}
	
	private int[] winningPatterns = {
	         0b111000000, 0b000111000, 0b000000111, // rows
	         0b100100100, 0b010010010, 0b001001001, // cols
	         0b100010001, 0b001010100               // diagonals
	   };
	 
	   /** Returns true if thePlayer wins */
	   private boolean hasWon(char thePlayer) {
	      int pattern = 0b000000000;  // 9-bit pattern for the 9 cells
	      for (int row = 0; row < Board.SIZE; ++row) {
	         for (int col = 0; col < Board.SIZE; ++col) {
	            if (cells[row][col] == thePlayer) {
	               pattern |= (1 << (row * Board.SIZE + col));
	            }
	         }
	      }
	      for (int winningPattern : winningPatterns) {
	         if ((pattern & winningPattern) == winningPattern) return true;
	      }
	      return false;
	   }
	
	private List<int[]> generateMoves() {
	      List<int[]> nextMoves = new ArrayList<int[]>(); // allocate List
	 
	      // If gameover, i.e., no next move
	      if (hasWon(mySymbol) || hasWon(oppSymbol)) {
	         return nextMoves;   // return empty list
	      }
	 
	      // Search for empty cells and add to the List
	      for (int row = 0; row < Board.SIZE; ++row) {
	         for (int col = 0; col < Board.SIZE; ++col) {
	            if (cells[row][col] == ' ') {
	               nextMoves.add(new int[] {row, col});
	            }
	         }
	      }
	      return nextMoves;
	   }
	 
	   /** The heuristic evaluation function for the current board
	       @Return +100, +10, +1 for EACH 3-, 2-, 1-in-a-line for computer.
	               -100, -10, -1 for EACH 3-, 2-, 1-in-a-line for opponent.
	               0 otherwise   */
	   private int evaluate() {
	      int score = 0;
	      // Evaluate score for each of the 8 lines (3 rows, 3 columns, 2 diagonals)
	      score += evaluateLine(0, 0, 0, 1, 0, 2);  // row 0
	      score += evaluateLine(1, 0, 1, 1, 1, 2);  // row 1
	      score += evaluateLine(2, 0, 2, 1, 2, 2);  // row 2
	      score += evaluateLine(0, 0, 1, 0, 2, 0);  // col 0
	      score += evaluateLine(0, 1, 1, 1, 2, 1);  // col 1
	      score += evaluateLine(0, 2, 1, 2, 2, 2);  // col 2
	      score += evaluateLine(0, 0, 1, 1, 2, 2);  // diagonal
	      score += evaluateLine(0, 2, 1, 1, 2, 0);  // alternate diagonal
	      return score;
	   }
	 
	   /** The heuristic evaluation function for the given line of 3 cells
	       @Return +100, +10, +1 for 3-, 2-, 1-in-a-line for computer.
	               -100, -10, -1 for 3-, 2-, 1-in-a-line for opponent.
	               0 otherwise */
	   private int evaluateLine(int row1, int col1, int row2, int col2, int row3, int col3) {
	      int score = 0;
	 
	      // First cell
	      if (cells[row1][col1] == mySymbol) {
	         score = 1;
	      } else if (cells[row1][col1] == oppSymbol) {
	         score = -1;
	      }
	 
	      // Second cell
	      if (cells[row2][col2] == mySymbol) {
	         if (score == 1) {   // cell1 is mySymbol
	            score = 10;
	         } else if (score == -1) {  // cell1 is oppSymbol
	            return 0;
	         } else {  // cell1 is empty
	            score = 1;
	         }
	      } else if (cells[row2][col2] == oppSymbol) {
	         if (score == -1) { // cell1 is oppSymbol
	            score = -10;
	         } else if (score == 1) { // cell1 is mySymbol
	            return 0;
	         } else {  // cell1 is empty
	            score = -1;
	         }
	      }
	 
	      // Third cell
	      if (cells[row3][col3] == mySymbol) {
	         if (score > 0) {  // cell1 and/or cell2 is mySymbol
	            score *= 10;
	         } else if (score < 0) {  // cell1 and/or cell2 is oppSymbol
	            return 0;
	         } else {  // cell1 and cell2 are empty
	            score = 1;
	         }
	      } else if (cells[row3][col3] == oppSymbol) {
	         if (score < 0) {  // cell1 and/or cell2 is oppSymbol
	            score *= 10;
	         } else if (score > 1) {  // cell1 and/or cell2 is mySymbol
	            return 0;
	         } else {  // cell1 and cell2 are empty
	            score = -1;
	         }
	      }
	      return score;
	   }
	
}
