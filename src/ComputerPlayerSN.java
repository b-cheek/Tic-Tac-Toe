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

public class ComputerPlayerSN // **** use your first name
{
  private final String      _name = "Brayden Cheek SN";    // **** change it to your name
  private final char        mySymbol;
  private final char		oppSymbol;
  private int 		turn = 0;
  private static int[] winningPatterns = {
	         0b111000000, 0b000111000, 0b000000111, // rows
	         0b100100100, 0b010010010, 0b001001001, // cols
	         0b100010001, 0b001010100               // diagonals
	   };

  public ComputerPlayerSN(char symbol) // **** use your first name
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

	char[][] board = boardObj.getBoard(); // board in 2D array

	turn = getTurn(board);
	
	// **** add instructions for my strategy to decide myRow and myCol
	if (turn>2) {
		int[] myMove = rule12(board);
		if (myMove[1]!=-1) return myMove;
		myMove = rule34(board);
		if (myMove[0]!=-1) return myMove;
	}
	
//	rule 5
	if (board[1][1] == ' ') return new int[] {1, 1};
	
//	rule 6
	if (board[0][0] == oppSymbol && board[2][2] == ' ') return new int[] {2, 2};
	if (board[0][2] == oppSymbol && board[2][0] == ' ') return new int[] {2, 0};
	if (board[2][0] == oppSymbol && board[0][2] == ' ') return new int[] {0, 2};
	if (board[2][2] == oppSymbol && board[0][0] == ' ') return new int[] {0, 0};
	
//	rule 7
	if (board[0][0] == ' ') return new int[] {0, 0};
	if (board[0][2] == ' ') return new int[] {0, 2};
	if (board[2][0] == ' ') return new int[] {2, 0};
	if (board[2][2] == ' ') return new int[] {2, 2};
	
//	rule 8
	if (board[0][1] == ' ') return new int[] {0, 1};
	if (board[1][0] == ' ') return new int[] {1, 0};
	if (board[1][2] == ' ') return new int[] {1, 2};
	if (board[2][1] == ' ') return new int[] {2, 1};
	
	return new int[] {-1, -1};
  }
  
  public static int getTurn(char[][] board) {
  	int turn=0;
  	for (char[] row: board) for (char symbol: row) if (symbol=='O' || symbol=='X') turn++;
  	return turn;
  }
  
  private int[] rule12(char[][] board) {
	  //	rules 1 & 2
		int[] rowTotals = new int[Board.SIZE];
		int[] colTotals = new int[Board.SIZE];
//			rows
		for (int row=0; row<Board.SIZE; row++) {
			for (int col=0; col<Board.SIZE; col++) {
				if (board[row][col]!=' ') rowTotals[row]+= (board[row][col]==mySymbol) ? 1 : -1;
			}
		}
//			cols
		for (int col=0; col<Board.SIZE; col++) {
			for (int row=0; row<Board.SIZE; row++) {
				if (board[row][col]!=' ') colTotals[col]+= (board[row][col]==mySymbol) ? 1 : -1;
			}
		}
		
//		check / diags
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
  
  private int[] rule120(char[][] board) {
	  for (int row=0; row<Board.SIZE; row++) for (int col=0; col<Board.SIZE; col++) {
		  if (board[row][col]==' ') {
			  board[row][col] = mySymbol;
			  if (hasWon(mySymbol, board)) return new int[] {row, col};
			  board[row][col] = ' ';
		  }
	  }
	  
	  for (int row=0; row<Board.SIZE; row++) for (int col=0; col<Board.SIZE; col++) {
		  if (board[row][col]==' ') {
			  board[row][col] = oppSymbol;
			  if (hasWon(oppSymbol, board)) return new int[] {row, col};
			  board[row][col] = ' ';
		  }
	  }
	  return new int[] {-1, -1};
  }
  
  private int[] rule3(char[][] board) {
	  for (int row=0; row<Board.SIZE; row++) for (int col=0; col<Board.SIZE; col++) {
		  if (board[row][col]==' ') {
			  int winCount = 0;
			  board[row][col] = mySymbol;
			  for (int deepRow=0; deepRow<Board.SIZE; deepRow++) for (int deepCol=0; deepCol<Board.SIZE; deepCol++) {
				  if (board[deepRow][deepCol]==' ') {
					  board[deepRow][deepCol] = mySymbol;
					  if (hasWon(mySymbol, board)) winCount++;
					  board[deepRow][deepCol] = ' ';
				  }
			  }
			  if (winCount>1) return new int[] {row, col};
			  board[row][col] = ' ';
		  }
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
//			cols
		for (int col=0; col<Board.SIZE; col++) {
			for (int row=0; row<Board.SIZE; row++) {
				if (board[row][col]!=' ') forkCols[col]+= (board[row][col]==mySymbol) ? 1 : -2;
			}
		}
//			diagonals  
		for (int diag=0; diag<Board.SIZE; diag++) {
			if (board[diag][diag]!=' ') forkDiags[0]+= (board[diag][diag]==mySymbol) ? 1 : -2;
			if (board[diag][2-diag]!=' ') forkDiags[1]+= (board[diag][2-diag]==mySymbol) ? 1 : -2;
		}
		
//		my forks, find opp forks for later
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
		
//		opp forks
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

  private int[] rule30(char[][] board) { // faster
	  boolean[] forkRows = new boolean[Board.SIZE];
	  boolean[] forkCols = new boolean[Board.SIZE];
	  boolean[] forkDiags = new boolean[2];
	  for (int row=0; row<Board.SIZE; row++) {
			int rowTotal = 0;
			for (int col=0; col<Board.SIZE; col++) {
				if (board[row][col]!=' ') rowTotal+= (board[row][col]==mySymbol) ? 1 : -2;
			}
			if (rowTotal==1) forkRows[row] = true;
		}
//			cols
		for (int col=0; col<Board.SIZE; col++) {
			int colTotal = 0;
			for (int row=0; row<Board.SIZE; row++) {
				if (board[row][col]!=' ') colTotal+= (board[row][col]==mySymbol) ? 1 : -2;
			}
			if (colTotal==1) forkCols[col] = true;
		}
//			diagonals  
		int[] diagTotals= new int[2];
		for (int diag=0; diag<3; diag++) {
			if (board[diag][diag]!=' ') diagTotals[0]+= (board[diag][diag]==mySymbol) ? 1 : -2;
			if (board[diag][2-diag]!=' ') diagTotals[1]+= (board[diag][2-diag]==mySymbol) ? 1 : -2;
		}
		if (diagTotals[0]==1) forkDiags[0] = true;
		if (diagTotals[1]==1) forkDiags[1] = true;
		
//		forks
		for (int row=0; row<Board.SIZE; row++) {
			for (int col=0; col<Board.SIZE; col++) {
				if (forkRows[row] && forkCols[col] && board[row][col]==' ') return new int[] {row, col};
			}
			if (forkRows[row] && forkDiags[0] && board[row][row]==' ') return new int[] {row, row};
			if (forkRows[row] && forkDiags[1] && board[row][2-row]==' ') return new int[] {row, 2-row};
		}
		for (int col=0; col<Board.SIZE; col++) {
			if (forkCols[col] && forkDiags[0] && board[col][col]==' ') return new int[] {col, col};
			if (forkCols[col] && forkDiags[1] && board[col][2-col]==' ') return new int[] {col, 2-col};
		}
		if (forkDiags[0] && forkDiags[1] && board[1][1]==' ') return new int[] {1, 1}; 
		return new int[] {-1, -1};
  }
  
//  private int[] rule40(char[][] board) {
//	  int forks = 0;
//	  int[] oneForkMove = {-1, -1};
//	  for (int row=0; row<Board.SIZE; row++) for (int col=0; col<Board.SIZE; col++) {
//		  if (board[row][col]==' ') {
//			  int winCount = 0;
//			  board[row][col] = oppSymbol;
////				  if (hasWon(mySymbol, board)) return new int[] {row, col};
//			  for (char[] deepRow: board) for (char symbol: deepRow) if (hasWon(oppSymbol, board)) winCount++;
//			  if (winCount>1) {
//				  forks++;
//				  oneForkMove[0] = row;
//				  oneForkMove[1] = col;
//			  }
//		  }
//	  }
//	  
//  }
  
  private boolean hasWon(char thePlayer, char[][] board) {
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
}