//Name: Brayden Cheek
//Program Description: A program that uses methods to print
//superior highly composite numbers
//Due: Feb 11, 2021

import java.io.*;
import java.util.*;
public class TicTestToe {

	private static int[] winningPatterns = {
	         0b111000000, 0b000111000, 0b000000111, // rows
	         0b100100100, 0b010010010, 0b001001001, // cols
	         0b100010001, 0b001010100               // diagonals
	   };
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("Test" + test());
//		int[] x = {-1, -1};
//		long startTime = System.nanoTime();
//		for (int i=0; i<10000000; i++) {
//			char[][] board = getRandomBoard();
//			x = rule120(board);
//		}
//		long endTime = System.nanoTime();
//		System.out.println(endTime-startTime);
//		long startTime0 = System.nanoTime();
//		for (int i=0; i<10000000; i++) {
//			char[][] board = getRandomBoard();
//			x = rule12(board);
//		}
//		long endTime0 = System.nanoTime();
//		System.out.println(endTime0-startTime0);
//		System.out.println();
//		System.out.println((endTime-startTime) - (endTime0-startTime0));
		char[][] board = {	{' ', ' ', ' '}, 
							{' ', 'X', ' '}, 
							{'O', 'O', ' '}};
//		int[] move = rule34(board);
//		System.out.println(move[0] + " " + move[1]);
//		long startTime = System.nanoTime();
//		double num = (boardToNum(board));
//		long elapsedTime = System.nanoTime() - startTime;
//		System.out.println(elapsedTime);
//		System.out.println(boardToNum(board));
		int[][] moves = new int[19683][2];
		moves[486] = new int[] {1, 1};
		moves[569] = new int[] {2, 1};
		moves[0] = new int[] {1, 1};
		moves[83] = new int[] {0, 0};
		moves[1458] = new int[] {1, 1};
		moves[14661] = new int[] {0, 1};
		moves[135] = new int[] {0, 0};
		moves[13122] = new int[] {1, 1};
		moves[13689] = new int[] {2, 0};
		moves[567] = new int[] {0, 0};
		moves[18] = new int[] {1, 1};
		moves[585] = new int[] {0, 0};
		moves[4455] = new int[] {0, 0};
		moves[13221] = new int[] {1, 0};
		moves[2] = new int[] {1, 1};
		moves[4457] = new int[] {1, 2};
		moves[99] = new int[] {0, 2};
		moves[13950] = new int[] {1, 0};
		moves[14247] = new int[] {2, 1};
		moves[163] = new int[] {0, 0};
		moves[11098] = new int[] {2, 1};
		moves[11587] = new int[] {1, 2};
		moves[11616] = new int[] {0, 2};
		moves[13203] = new int[] {2, 2};
		moves[4941] = new int[] {0, 0};
		moves[1593] = new int[] {2, 2};
		moves[153] = new int[] {2, 1};
		moves[54] = new int[] {1, 1};
		moves[830] = new int[] {2, 1};
		moves[13209] = new int[] {1, 2};
		moves[13205] = new int[] {1, 2};
		moves[13718] = new int[] {2, 0};
		moves[15185] = new int[] {0, 1};
		moves[17577] = new int[] {0, 2};
		moves[5913] = new int[] {0, 0};
		moves[87] = new int[] {0, 0};
		moves[621] = new int[] {2, 1};
		moves[4374] = new int[] {1, 1};
		moves[4509] = new int[] {2, 2};
		moves[1539] = new int[] {2, 0};
		moves[4473] = new int[] {1, 2};
		moves[89] = new int[] {2, 0};
		moves[1556] = new int[] {1, 2};
		moves[2069] = new int[] {0, 0};
		moves[8102] = new int[] {1, 2};
		moves[6] = new int[] {1, 1};
		moves[105] = new int[] {2, 2};
		moves[6726] = new int[] {0, 2};
		moves[13257] = new int[] {2, 1};
		moves[17634] = new int[] {0, 2};
		moves[4461] = new int[] {1, 2};
		moves[13222] = new int[] {1, 0};
		moves[17632] = new int[] {0, 2};
		moves[6730] = new int[] {0, 1};
		moves[6662] = new int[] {2, 1};
		moves[10375] = new int[] {2, 0};
		moves[10870] = new int[] {1, 2};
		moves[101] = new int[] {2, 1};
		moves[14670] = new int[] {0, 1};
		moves[16863] = new int[] {1, 2};
		moves[573] = new int[] {2, 2};
		moves[2025] = new int[] {2, 1};
		moves[11039] = new int[] {1, 2};
		moves[11552] = new int[] {0, 2};
		moves[1557] = new int[] {1, 2};
		moves[1541] = new int[] {1, 2};
		moves[1545] = new int[] {1, 2};
		moves[137] = new int[] {0, 2};
		moves[14662] = new int[] {0, 1};
		moves[16855] = new int[] {1, 2};
		moves[6778] = new int[] {1, 0};
		moves[7148] = new int[] {2, 1};
		moves[8615] = new int[] {2, 1};
		moves[12992] = new int[] {2, 0};
		moves[6742] = new int[] {0, 2};
		moves[11845] = new int[] {2, 1};
		moves[12334] = new int[] {1, 2};
		moves[2058] = new int[] {0, 0};
		moves[4478] = new int[] {1, 2};
		moves[4991] = new int[] {0, 0};
		moves[4530] = new int[] {0, 0};
		moves[11093] = new int[] {0, 2};
		moves[11155] = new int[] {1, 0};
		moves[7210] = new int[] {1, 2};
		moves[8695] = new int[] {2, 0};
		moves[8710] = new int[] {0, 1};
		moves[11504] = new int[] {2, 0};
		moves[2070] = new int[] {0, 0};
		moves[8633] = new int[] {2, 1};
		moves[5207] = new int[] {1, 2};
		moves[4970] = new int[] {2, 0};
		moves[6437] = new int[] {0, 0};
		moves[13228] = new int[] {1, 0};
		moves[141] = new int[] {2, 2};
		moves[1550] = new int[] {1, 2};
		moves[11103] = new int[] {2, 0};
		moves[12971] = new int[] {1, 2};
		moves[18324] = new int[] {1, 0};
		moves[18621] = new int[] {2, 2};
		moves[15156] = new int[] {0, 1};
		moves[13722] = new int[] {2, 0};
		moves[16854] = new int[] {1, 2};
		moves[17367] = new int[] {2, 0};
		moves[4946] = new int[] {0, 2};
		moves[15189] = new int[] {0, 1};
		moves[11598] = new int[] {1, 2};
		moves[4986] = new int[] {0, 0};
		moves[11611] = new int[] {2, 1};
		moves[13072] = new int[] {2, 0};
		moves[12476] = new int[] {1, 2};
		moves[2054] = new int[] {2, 1};
		moves[6431] = new int[] {0, 0};
		moves[13264] = new int[] {2, 0};
		moves[8182] = new int[] {2, 0};
		moves[18379] = new int[] {1, 0};
		moves[6402] = new int[] {0, 0};
		moves[14716] = new int[] {0, 1};
		moves[16909] = new int[] {2, 0};
		moves[13696] = new int[] {2, 0};
		moves[12989] = new int[] {2, 0};
		moves[13518] = new int[] {2, 1};
		moves[17895] = new int[] {0, 2};
		moves[11829] = new int[] {2, 1};
		moves[12318] = new int[] {1, 2};
		moves[11632] = new int[] {0, 2};
		moves[18381] = new int[] {1, 0};
		moves[13525] = new int[] {0, 2};
		moves[7243] = new int[] {0, 1};
		moves[14731] = new int[] {0, 1};
		moves[11119] = new int[] {0, 2};
		moves[15163] = new int[] {0, 1};
		moves[884] = new int[] {2, 1};
		moves[7039] = new int[] {0, 2};
		moves[17376] = new int[] {2, 2};
		moves[7239] = new int[] {0, 2};
		moves[13519] = new int[] {2, 1};
		moves[17896] = new int[] {0, 2};
		moves[17368] = new int[] {2, 0};
		moves[8677] = new int[] {1, 2};
		moves[5693] = new int[] {0, 0};
		moves[11850] = new int[] {1, 0};
		moves[11416] = new int[] {0, 2};
		moves[17349] = new int[] {2, 2};
		moves[2063] = new int[] {2, 1};
		moves[6440] = new int[] {0, 0};
		moves[8621] = new int[] {2, 0};
		moves[11902] = new int[] {1, 0};
		moves[18624] = new int[] {2, 2};
		moves[5261] = new int[] {0, 0};
		moves[11525] = new int[] {0, 2};
		moves[5720] = new int[] {0, 0};
		moves[12965] = new int[] {1, 2};
		moves[8706] = new int[] {0, 1};
		moves[13078] = new int[] {2, 1};
		moves[11549] = new int[] {2, 1};
		moves[10888] = new int[] {2, 0};
		moves[12342] = new int[] {2, 1};
		moves[12142] = new int[] {2, 1};
		moves[11886] = new int[] {1, 0};
		
		int[] move = moves[boardToNum(board)];
		System.out.println(move[0] + " " + move[1]);
	}
	
	private static int boardToNum(char[][] board) {
		int total = 0;
		switch (board[0][0]) {
		case 'X':
			total += 6561;
			break;
		case 'O':
			total += 13122;
			break;
		}
		switch (board[0][1]) {
		case 'X':
			total += 2187;
			break;
		case 'O':
			total += 4374;
			break;
		}
		switch (board[0][2]) {
		case 'X':
			total += 729;
			break;
		case 'O':
			total += 1458;
			break;
		}
		switch (board[1][0]) {
		case 'X':
			total += 243;
			break;
		case 'O':
			total += 486;
			break;
		}
		switch (board[1][1]) {
		case 'X':
			total += 81;
			break;
		case 'O':
			total += 163;
			break;
		}
		switch (board[1][2]) {
		case 'X':
			total += 27;
			break;
		case 'O':
			total += 54;
			break;
		}
		switch (board[2][0]) {
		case 'X':
			total += 9;
			break;
		case 'O':
			total += 18;
			break;
		}
		switch (board[2][1]) {
		case 'X':
			total += 3;
			break;
		case 'O':
			total += 6;
			break;
		}
		switch (board[2][2]) {
		case 'X':
			total += 1;
			break;
		case 'O':
			total += 2;
			break;
		}
		return total;
	}
	
	private static int[] rule12(char[][] board) {
	  //	rules 1 & 2
		int[] rowTotals = new int[3];
		int[] colTotals = new int[3];
//			rows
		for (int row=0; row<3; row++) {
			for (int col=0; col<3; col++) {
				if (board[row][col]!=' ') rowTotals[row]+= (board[row][col]=='X') ? 1 : -1;
			}
		}
//			cols
		for (int col=0; col<3; col++) {
			for (int row=0; row<3; row++) {
				if (board[row][col]!=' ') colTotals[col]+= (board[row][col]=='X') ? 1 : -1;
			}
		}
		
//		check / diags
		for (int row: rowTotals) if (row==2) for (int col=0; col<3; col++) if (col==' ') return new int[] {row, col};
		for (int col: colTotals) if (col==2) for (int row=0; row<3; row++) if (col==' ') return new int[] {row, col};
		if (board[1][1]=='X') {
			if (board[0][0]=='X' && board[2][2]==' ') return new int[] {2, 2};
			if (board[0][2]=='X' && board[2][0]==' ') return new int[] {2, 0};
			if (board[2][0]=='X' && board[0][2]==' ') return new int[] {0, 2};
			if (board[2][2]=='X' && board[0][2]==' ') return new int[] {0, 0};
		}
		for (int row: rowTotals) if (row==-2) for (int col=0; col<3; col++) if (col==' ') return new int[] {row, col};
		for (int col: colTotals) if (col==-2) for (int row=0; row<3; row++) if (col==' ') return new int[] {row, col};
		if (board[1][1]=='O') {
			if (board[0][0]=='O' && board[2][2]==' ') return new int[] {2, 2};
			if (board[0][2]=='O' && board[2][0]==' ') return new int[] {2, 0};
			if (board[2][0]=='O' && board[0][2]==' ') return new int[] {0, 2};
			if (board[2][2]=='O' && board[0][2]==' ') return new int[] {0, 0};
		}
		
		return new int[] {-1, -1};
	  }
	  
	  private static int[] rule120(char[][] board) {
		  for (int row=0; row<3; row++) for (int col=0; col<3; col++) {
			  if (board[row][col]==' ') {
				  board[row][col] = 'X';
				  if (hasWon('X', board)) return new int[] {row, col};
				  board[row][col] = ' ';
			  }
		  }
		  for (int row=0; row<3; row++) for (int col=0; col<3; col++) {
			  if (board[row][col]==' ') {
				  board[row][col] = 'O';
				  if (hasWon('O', board)) return new int[] {row, col};
				  board[row][col] = ' ';
			  }
		  }
	  return new int[] {-1, -1};
	  }
	  
	  private static int[] rule3(char[][] board) {
		  for (int row=0; row<3; row++) for (int col=0; col<3; col++) {
			  if (board[row][col]==' ') {
				  int winCount = 0;
				  board[row][col] = 'X';
				  for (int deepRow=0; deepRow<3; deepRow++) for (int deepCol=0; deepCol<3; deepCol++) {
					  if (board[deepRow][deepCol]==' ') {
						  board[deepRow][deepCol] = 'X';
						  if (hasWon('X', board)) winCount++;
						  board[deepRow][deepCol] = ' ';
					  }
				  }
				  if (winCount>1) return new int[] {row, col};
				  board[row][col] = ' ';
			  }
		  }
		  return new int[] {-1, -1};
	  }
	  
	  private static int[] rule30(char[][] board) {
		  boolean[] forkRows = new boolean[3];
		  boolean[] forkCols = new boolean[3];
		  boolean[] forkDiags = new boolean[2];
//		  rows
		  for (int row=0; row<3; row++) {
				int rowTotal = 0;
				for (int col=0; col<3; col++) {
					if (board[row][col]!=' ') rowTotal+= (board[row][col]=='X') ? 1 : -2;
				}
				if (rowTotal==1) forkRows[row] = true;
			}
//				cols
		for (int col=0; col<3; col++) {
			int colTotal = 0;
			for (int row=0; row<3; row++) {
				if (board[row][col]!=' ') colTotal+= (board[row][col]=='X') ? 1 : -2;
			}
			if (colTotal==1) forkCols[col] = true;
		}
//				diagonals  
		int[] diagTotals= new int[2];
		for (int diag=0; diag<3; diag++) {
			if (board[diag][diag]!=' ') diagTotals[0]+= (board[diag][diag]=='X') ? 1 : -2;
			if (board[diag][2-diag]!=' ') diagTotals[1]+= (board[diag][2-diag]=='X') ? 1 : -2;
		}
		if (diagTotals[0]==1) forkDiags[0] = true;
		if (diagTotals[1]==1) forkDiags[1] = true;
		
//			forks
		for (int row=0; row<3; row++) {
			for (int col=0; col<3; col++) {
				if (forkRows[row] && forkCols[col] && board[row][col]==' ') return new int[] {row, col};
			}
			if (forkRows[row] && forkDiags[0] && board[row][row]==' ') return new int[] {row, row};
			if (forkRows[row] && forkDiags[1] && board[row][2-row]==' ') return new int[] {row, 2-row};
		}
		for (int col=0; col<3; col++) {
			if (forkCols[col] && forkDiags[0] && board[col][col]==' ') return new int[] {col, col};
			if (forkCols[col] && forkDiags[1] && board[col][2-col]==' ') return new int[] {col, 2-col};
		}
		return new int[] {-1, -1};
	  }
	  
	  public static boolean hasWon(char thePlayer, char[][] board) {
	      int pattern = 0b000000000;  // 9-bit pattern for the 9 cells
	      for (int row = 0; row < 3; ++row) {
	         for (int col = 0; col < 3; ++col) {
	            if (board[row][col] == thePlayer) {
	               pattern |= (1 << (row * 3 + col));
	            }
	         }
	      }
	      for (int winningPattern : winningPatterns) {
	         if ((pattern & winningPattern) == winningPattern) return true;
	      }
	      return false;
	   }
	  
	  private static int[] rule31(char[][] board) {
		  int[] forkRows = new int[3];
		  int[] forkCols = new int[3];
		  int[] forkDiags = new int[2];
		  for (int row=0; row<3; row++) {
				for (int col=0; col<3; col++) {
					if (board[row][col]!=' ') forkRows[row]+= (board[row][col]=='X') ? 1 : -2;
				}
			}
//				cols
			for (int col=0; col<3; col++) {
				for (int row=0; row<3; row++) {
					if (board[row][col]!=' ') forkCols[col]+= (board[row][col]=='X') ? 1 : -2;
				}
			}
//				diagonals  
			for (int diag=0; diag<3; diag++) {
				if (board[diag][diag]!=' ') forkDiags[0]+= (board[diag][diag]=='X') ? 1 : -2;
				if (board[diag][2-diag]!=' ') forkDiags[1]+= (board[diag][2-diag]=='X') ? 1 : -2;
			}
			
//			forks
			for (int row=0; row<3; row++) {
				for (int col=0; col<3; col++) {
					if (forkRows[row] == 1 && forkRows[row] == forkCols[col] && board[row][col]==' ') return new int[] {row, col};
				}
				if (forkRows[row] == 1) {
					if (forkDiags[0] == 1 && board[row][row] == ' ') return new int[] {row, row};
					if (forkDiags[1] == 1 && board[row][2-row] == ' ') return new int[] {row, 2-row};
				}
			}
			for (int col=0; col<3; col++) {
				if (forkCols[col] ==1) {
					if (forkDiags[0] == 1 && board[col][col] == ' ') return new int[] {col, col};
					if (forkDiags[1] == 1 && board[col][2-col] == ' ') return new int[] {col, 2-col};
				}
			}
			return new int[] {-1, -1};
	  }
	  
	  private static int[] rule34(char[][] board) {
		  int[] forkRows = new int[3];
		  int[] forkCols = new int[3];
		  int[] forkDiags = new int[2];
		  boolean[][] oppForkSpots = new boolean[3][3];
		  for (int row=0; row<3; row++) {
				for (int col=0; col<3; col++) {
					if (board[row][col]!=' ') forkRows[row]+= (board[row][col]=='X') ? 1 : -2;
				}
			}
//				cols
			for (int col=0; col<3; col++) {
				for (int row=0; row<3; row++) {
					if (board[row][col]!=' ') forkCols[col]+= (board[row][col]=='X') ? 1 : -2;
				}
			}
//				diagonals  
			for (int diag=0; diag<3; diag++) {
				if (board[diag][diag]!=' ') forkDiags[0]+= (board[diag][diag]=='X') ? 1 : -2;
				if (board[diag][2-diag]!=' ') forkDiags[1]+= (board[diag][2-diag]=='X') ? 1 : -2;
			}
			
//			my forks, find opp forks for later
			for (int row=0; row<3; row++) {
				for (int col=0; col<3; col++) {
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
			for (int col=0; col<3; col++) {
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
			
//			opp forks
			for (boolean[] row: oppForkSpots) {
				for (boolean i: row) System.out.print(i + " ");
				System.out.println();
			}
			for (int i=0; i<3; i++) {
				if (forkRows[i]==1) {
					for (int j=0; j<3; j++) {
						if (board[i][j]!='X' && !oppForkSpots[i][j]) {
							board[i][j] = 'n';
							for (int findEmpty=0; findEmpty<3; findEmpty++) if (board[i][findEmpty]==' ') return new int[] {i, findEmpty};
						}
					}
				}
			}
			for (int i=0; i<3; i++) {
				if (forkCols[i]==1) {
					for (int j=0; j<3; j++) {
						if (board[j][i]!='X' && !oppForkSpots[j][i]) {
							board[j][i] = 'n';
							for (int findEmpty=0; findEmpty<3; findEmpty++) if (board[findEmpty][i]==' ') return new int[] {findEmpty, i};
						}
					}
				}
			}
			if (forkDiags[0]==1) {
				for (int i=0; i<3; i++) {
					if (board[i][i]!='X' && !oppForkSpots[i][i]) {
						board[i][i] = 'n';
						for (int findEmpty = 0; findEmpty<3; findEmpty++) if (board[findEmpty][findEmpty]==' ') return new int[] {findEmpty, findEmpty};
					}
				}
			}
			if (forkDiags[1]==1) {
				for (int i=0; i<3; i++) {
					if (board[i][2-i]!='X' && !oppForkSpots[i][2-i]) {
						board[i][2-i] = 'n';
						for (int findEmpty = 0; findEmpty<3; findEmpty++) if (board[findEmpty][2-findEmpty]==' ') return new int[] {findEmpty, 2-findEmpty};
					}
				}
			}
			return new int[] {-1, -1};
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
}	
	
	