/**
Name: Brayden Cheek 
E-mail address: bwc1024@hotmail.com
Course: AP Computer Science A
Section: 3
Assignment: Tic-Tac-Toe Program
Date: 5/18/21

Template Author: Philip Chan
Modify:
1.  class/constructor name: ComputerPlayerFirst, eg. ComputerPlayerJohn
2.  attribute _name: your name
3.  makeAMove() method

Description: My modified version of the computer player to play in the Tic-Tac-Toe tournament.

*/

public class ComputerPlayerBraydenC // **** use your first name
{
  private final String      _name = "Brayden Cheek";    // **** change it to your name
  private final char        mySymbol;
  private final char		oppSymbol;
  private int[][] 			moves = new int[19683][2];

  public ComputerPlayerBraydenC(char symbol) // **** use your first name
  {
	for (int i=0; i<moves.length; i++) moves[i] = new int[] {-1, -1};
	mySymbol = symbol;
	if (mySymbol=='X') {
		oppSymbol = 'O';
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
	}
	
	else {
		oppSymbol = 'X';
		moves[1] = new int[] {1, 1};
		moves[893] = new int[] {1, 2};
		moves[0] = new int[] {1, 1};
		moves[166] = new int[] {0, 0};
		moves[6561] = new int[] {1, 1};
		moves[6967] = new int[] {2, 0};
		moves[164] = new int[] {0, 0};
		moves[81] = new int[] {0, 0};
		moves[13446] = new int[] {1, 2};
		moves[13503] = new int[] {0, 1};
		moves[892] = new int[] {2, 0};
		moves[3] = new int[] {1, 1};
		moves[2353] = new int[] {1, 2};
		moves[729] = new int[] {1, 1};
		moves[1190] = new int[] {2, 1};
		moves[2187] = new int[] {1, 1};
		moves[2377] = new int[] {2, 2};
		moves[8940] = new int[] {0, 2};
		moves[243] = new int[] {1, 1};
		moves[433] = new int[] {2, 1};
		moves[190] = new int[] {0, 0};
		moves[3079] = new int[] {0, 0};
		moves[6724] = new int[] {2, 2};
		moves[7455] = new int[] {0, 1};
		moves[11832] = new int[] {1, 2};
		moves[12129] = new int[] {2, 0};
		moves[27] = new int[] {1, 1};
		moves[2350] = new int[] {0, 0};
		moves[919] = new int[] {2, 2};
		moves[406] = new int[] {0, 0};
		moves[2351] = new int[] {1, 2};
		moves[8911] = new int[] {0, 2};
		moves[7471] = new int[] {0, 1};
		moves[9] = new int[] {1, 1};
		moves[6733] = new int[] {1, 0};
		moves[7246] = new int[] {2, 1};
		moves[9439] = new int[] {0, 2};
		moves[14229] = new int[] {2, 0};
		moves[16434] = new int[] {2, 1};
		moves[13204] = new int[] {0, 2};
		moves[2593] = new int[] {0, 0};
		moves[901] = new int[] {1, 2};
		moves[172] = new int[] {0, 2};
		moves[175] = new int[] {2, 2};
		moves[13212] = new int[] {0, 2};
		moves[1135] = new int[] {2, 1};
		moves[415] = new int[] {0, 0};
		moves[409] = new int[] {2, 2};
		moves[6972] = new int[] {2, 0};
		moves[7719] = new int[] {0, 1};
		moves[895] = new int[] {1, 2};
		moves[193] = new int[] {2, 2};
		moves[8191] = new int[] {1, 0};
		moves[7453] = new int[] {0, 1};
		moves[13230] = new int[] {1, 0};
		moves[6751] = new int[] {2, 1};
		moves[15716] = new int[] {2, 0};
		moves[16463] = new int[] {1, 2};
		moves[13206] = new int[] {0, 1};
		moves[191] = new int[] {0, 2};
		moves[1658] = new int[] {2, 1};
		moves[167] = new int[] {2, 0};
		moves[13295] = new int[] {2, 1};
		moves[6725] = new int[] {1, 2};
		moves[7714] = new int[] {0, 1};
		moves[13538] = new int[] {2, 1};
		moves[8944] = new int[] {0, 2};
		moves[407] = new int[] {2, 1};
		moves[6735] = new int[] {1, 0};
		moves[7248] = new int[] {2, 1};
		moves[9441] = new int[] {0, 2};
		moves[8704] = new int[] {2, 1};
		moves[10897] = new int[] {2, 2};
		moves[10378] = new int[] {1, 0};
		moves[6727] = new int[] {1, 2};
		moves[6738] = new int[] {1, 0};
		moves[1631] = new int[] {2, 1};
		moves[12091] = new int[] {2, 2};
		moves[16202] = new int[] {1, 2};
		moves[3824] = new int[] {1, 2};
		moves[4121] = new int[] {0, 0};
		moves[10411] = new int[] {1, 0};
		moves[14015] = new int[] {1, 2};
		moves[2648] = new int[] {2, 0};
		moves[2600] = new int[] {0, 2};
		moves[2359] = new int[] {1, 2};
		moves[914] = new int[] {1, 2};
		moves[15687] = new int[] {2, 1};
		moves[16422] = new int[] {2, 0};
		moves[13932] = new int[] {2, 0};
		moves[11830] = new int[] {1, 2};
		moves[12127] = new int[] {2, 0};
		moves[199] = new int[] {2, 1};
		moves[3328] = new int[] {0, 0};
		moves[16451] = new int[] {1, 2};
		moves[15488] = new int[] {1, 2};
		moves[15785] = new int[] {0, 2};
		moves[13501] = new int[] {0, 2};
		moves[17146] = new int[] {2, 1};
		moves[1198] = new int[] {0, 0};
		moves[911] = new int[] {1, 2};
		moves[7022] = new int[] {2, 0};
		moves[7024] = new int[] {2, 0};
		moves[7771] = new int[] {0, 1};
		moves[173] = new int[] {2, 1};
		moves[10891] = new int[] {2, 2};
		moves[2656] = new int[] {0, 0};
		moves[15390] = new int[] {2, 1};
		moves[15405] = new int[] {0, 2};
		moves[17106] = new int[] {1, 2};
		moves[1208] = new int[] {2, 1};
		moves[6756] = new int[] {2, 0};
		moves[14193] = new int[] {1, 2};
		moves[14248] = new int[] {0, 1};
		moves[7482] = new int[] {0, 1};
		moves[14312] = new int[] {2, 1};
		moves[16505] = new int[] {2, 0};
		moves[13725] = new int[] {0, 2};
		moves[17370] = new int[] {2, 1};
		moves[15731] = new int[] {0, 2};
		moves[1192] = new int[] {0, 0};
		moves[2366] = new int[] {1, 2};
		moves[2663] = new int[] {0, 0};
		moves[16857] = new int[] {2, 1};
		moves[16864] = new int[] {1, 0};
		moves[16499] = new int[] {2, 0};
		moves[7769] = new int[] {0, 1};
		moves[2392] = new int[] {0, 0};
		moves[11848] = new int[] {1, 2};
		moves[12145] = new int[] {2, 2};
		moves[3401] = new int[] {0, 0};
		moves[15702] = new int[] {0, 2};
		moves[18606] = new int[] {2, 0};
		moves[4067] = new int[] {0, 0};
		moves[15779] = new int[] {2, 1};
		moves[15423] = new int[] {1, 0};
		moves[14315] = new int[] {2, 0};
		moves[16849] = new int[] {2, 1};
		moves[16882] = new int[] {1, 0};
		moves[3395] = new int[] {0, 0};
		moves[10407] = new int[] {1, 0};
		moves[15639] = new int[] {1, 2};
		moves[15694] = new int[] {0, 2};
		moves[14250] = new int[] {0, 1};
		moves[16890] = new int[] {1, 0};
		moves[3851] = new int[] {0, 0};
		moves[7251] = new int[] {0, 2};
		moves[18309] = new int[] {2, 0};
		moves[18570] = new int[] {1, 2};
		moves[15515] = new int[] {0, 2};
		moves[7503] = new int[] {0, 1};
		moves[3383] = new int[] {0, 0};
		moves[15397] = new int[] {2, 0};
		moves[15658] = new int[] {1, 2};
		moves[1211] = new int[] {0, 0};
		moves[15918] = new int[] {0, 2};
		moves[14321] = new int[] {2, 1};
		moves[11859] = new int[] {2, 0};
		moves[17098] = new int[] {1, 2};
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
	char[][] board = boardObj.getBoard(); // board in 2D array
	int[] move = moves[boardToNum(board)];
	if (move[0]!=-1) return move;
	int[] myMove = rule12(board);
	if (myMove[0]!=-1) return myMove;
	myMove = rule34(board);
	if (myMove[0]!=-1) return myMove;
	return new int[] {-1, -1};
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