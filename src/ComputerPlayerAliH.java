/**
 * Name: alimh1214@gmail.com: Course: APCSA Assignment:Final Exam Date: 5/24
 * 
 * Template Author: Philip Chan Modify: 1. class/constructor name:
 * ComputerPlayerFirst, eg. ComputerPlayerJohn 2. attribute _name: your name 3.
 * makeAMove() method
 * 
 * Description: My modified version of the computer player to play in the
 * Tic-Tac-Toe tournament.
 * 
 */
import java.util.ArrayList;
//import java.math;
public class ComputerPlayerAliH {
private final String _name = "Jane Doe"; // **** change it to your name
private final char _symbol;

public ComputerPlayerAliH(char symbol) // **** use your first name
    {
	_symbol = symbol;
    }

public char getSymbol() {
	return _symbol;
}

public String getName() {
	return _name;
}

public int[] makeAMove(Board boardObj) {
	
	char startingPlayer = Tournament.getStartingPlayer(); // symbol of starting player
	char mySymbol = _symbol; // my symbol
	char oppSymbol; // opponent's symbol
	if (mySymbol == 'X') // find the opponent's symbol
		oppSymbol = 'O';
	else
		oppSymbol = 'X';
	ArrayList<int []> emptyC = new ArrayList<int[]>();
	char[][] board = boardObj.getBoard(); // board in 2D array // **** add instructions for my strategy to decide myRow and myCol// return my move (myRow, myCol) as the last step
	
	for (int i = 0; i < board.length;i++) {
		for (int n = 0; n < board[1].length;n++) {
			if (board[i][n] == 32){
				int coordinate[] = {i,n,0,0};// iterates through board and gets each empty coordinate
				emptyC.add(coordinate);
			}
		}
	}
	int xRand = (int)(Math.random() * emptyC.size());
	int[] myMove = new int[] {emptyC.get(xRand)[0] , emptyC.get(xRand)[1]};// creates initial random move
	boolean found = false;
	findWin: for(int x[] : emptyC) {// iterates through empty positions
		int row = x[0];
		int col = x[1];
		int numOpp = 0;
		int numMe = 0;
		int numOppCol = 0;
		int numMeCol = 0;
		int numOppRow = 0;
		int numMeRow = 0;
		for (char e: board[row])// iterates through the row of each empty postions
		{	
			if (e == oppSymbol) 
			{
				 numOpp++;
				 numOppRow++;
			 }
			 if (e == mySymbol)  // counts the number of opponents and selfs characters in row
			 {
				 numMe++;
				 numMeRow++;
			 } 
			 if (numMeRow == 2) // leave loop to do win condition if possible
			 {
				 myMove[0] = row;
				 myMove[1] = col;	 
				 found = true;
				 break findWin;
			 }
			 if (numOppRow == 2 || numMeRow == 2) {// saves move that prevents loss
				 myMove[0] = row;
				 myMove[1] = col;
				 found = true;
			 }	 
		}
		for (int i = 0;i < 3;i++)
		{
			 if (board[i][col] == oppSymbol) // does above actions but for colums
			 {
				 numOpp++;
				 numOppCol++;
			 }
			 if (board[i][col] == mySymbol) 
			 {
				 numMe++;
				 numMeCol++;
			 }
			 if (numMeCol == 2) 
			 {
				 myMove[0] = row;
				 myMove[1] = col;
				 found = true;
				 break findWin;
			 }
			 if (numOppCol == 2 || numMeCol == 2) 
			 {
				 myMove[0] = row;
				 myMove[1] = col;
				 found = true;
			 }
		}
		if ((row + col)%2 != 1) // checks each diagonal win and loss possibility and sets move for exits loop to win
		{
			int numOppDia = 0;
			int numMeDia = 0;
			if(row + col == 4) 
			{
				if (board[row-1][col-1] == oppSymbol) {numOppDia++;numOpp++;}
				if (board[row-2][col-2] == oppSymbol) {numOppDia++;numOpp++;}
				if (board[row-1][col-1] == mySymbol) {numMeDia++;numMe++;}
				if (board[row-2][col-2] == mySymbol) {numMeDia++;numMe++;}
				if (numMeDia == 2){myMove[0] = row;myMove[1] = col;found = true;break findWin;} 
				if (numOppDia == 2 || numMeDia == 2) {myMove[0] = row;myMove[1] = col;found = true;} 
			}
			if(row + col == 0) 
			{
				if (board[row+1][col+1] == oppSymbol) {numOppDia++;numOpp++;}
				if (board[row+2][col+2] == oppSymbol) {numOppDia++;numOpp++;}
				if (board[row+1][col+1] == mySymbol) {numMeDia++;numMe++;}
				if (board[row+2][col+2] == mySymbol) {numMeDia++;numMe++;}
				if (numMeDia == 2){myMove[0] = row;myMove[1] = col;found = true;break findWin;} 
				if (numOppDia == 2 || numMeDia == 2) {myMove[0] = row;myMove[1] = col;found = true;} 
			}
			if(row == col && row == 1) 
			{
				if (board[row+1][col+1] == oppSymbol) {numOppDia++;numOpp++;}
				if (board[row-1][col-1] == oppSymbol) {numOppDia++;numOpp++;}
				if (board[row+1][col+1] == mySymbol) {numMeDia++;numMe++;}
				if (board[row-1][col-1] == mySymbol) {numMeDia++;numMe++;}
				if (numMeDia == 2){myMove[0] = row;myMove[1] = col;found = true;break findWin;} 
				if (numOppDia == 2 || numMeDia == 2) {myMove[0] = row;myMove[1] = col;found = true;} 
				numOppDia = 0;
				numMeDia = 0;
				if (board[row-1][col+1] == oppSymbol) {numOppDia++;numOpp++;}
				if (board[row+1][col-1] == oppSymbol) {numOppDia++;numOpp++;}
				if (board[row-1][col+1] == mySymbol) {numMeDia++;numMe++;}
				if (board[row+1][col-1] == mySymbol) {numMeDia++;numMe++;}
				if (numMeDia == 2){myMove[0] = row;myMove[1] = col;found = true;break findWin;} 
				if (numOppDia == 2 || numMeDia == 2) {myMove[0] = row;myMove[1] = col;found = true;} 
			}
			if(row == 0 && col == 2)
			{
				if (board[row+1][col-1] == oppSymbol) {numOppDia++;numOpp++;}
				if (board[row+2][col-2] == oppSymbol) {numOppDia++;numOpp++;}
				if (board[row+1][col-1] == mySymbol) {numMeDia++;numMe++;}
				if (board[row+2][col-2] == mySymbol) {numMeDia++;numMe++;}
				if (numMeDia == 2){myMove[0] = row;myMove[1] = col;found = true;break findWin;} 
				if (numOppDia == 2 || numMeDia == 2) {myMove[0] = row;myMove[1] = col;found = true;} 
			}
			if(row == 2 && col ==0) 
			{
				if (board[row-1][col+1] == oppSymbol) {numOppDia++;numOpp++;}
				if (board[row-2][col+2] == oppSymbol) {numOppDia++;numOpp++;}
				if (board[row-1][col+1] == mySymbol) {numMeDia++;numMe++;}
				if (board[row-2][col+2] == mySymbol) {numMeDia++;numMe++;}
				if (numMeDia == 2){myMove[0] = row;myMove[1] = col;found = true;break findWin;} 
				if (numOppDia == 2 || numMeDia == 2) {myMove[0] = row;myMove[1] = col;found = true;} 
			}		
		}
		x[2] = numOpp;
		x[3] = numMe;// saves that number of in a row opp symbol and my symbol to array with coordinates
	}
	if(!found && emptyC.size()< 9) // only occurs if win or loss condition is not found
	{
		int maxIndex=0;
		for(int i = 0;i < emptyC.size();i++) // finds position that interacts most with self and opp symbols
		{
			if (emptyC.get(i)[2] /*- emptyC.get(i)[3]*/ > emptyC.get(maxIndex)[2] /*- emptyC.get(maxIndex)[3]*/) 
			{
				maxIndex = i;
			}
		}
		myMove[0] = emptyC.get(maxIndex)[0];
		myMove[1] = emptyC.get(maxIndex)[1];// sets move to be that position
	}
	return myMove;// returns move
}

}
