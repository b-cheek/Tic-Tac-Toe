/**
  Name: Philip Chan

  Description: user can enter moves via the keyboard.

*/


import java.util.*;
import java.io.*;


public class HumanPlayer 
{
    private final String      _name;
    private final char        _symbol;

    public HumanPlayer(char symbol)
    {
	_symbol = symbol;
	_name = "A mere mortal";
    }

    public HumanPlayer(char symbol, String name)
    {
	_symbol = symbol;
	_name = name;
    }

    public char getSymbol()
    {
	return _symbol;
    }

    public String getName()
    {
	return _name;
    }

    public int[] makeAMove(Board board)
    {
	Scanner keyboard = new Scanner(System.in);
 	int     row=0, col=0;
	boolean inputError=false;

	do
	    {
		inputError = false;
		System.out.print("Please enter the row (0-2): ");
		row = keyboard.nextInt();
		System.out.print("Please enter the column (0-2): ");
		col = keyboard.nextInt();
		if (board.isValid(row, col))
		    {
			if (!board.isEmpty(row, col))
			    {
				inputError = true;
				System.out.println("*** The cell is not empty ***");
			    }
		    }
		else
		    {
			inputError = true;
			System.out.println("*** Invalid row and/or column ***");
		    }
		
	    }	
	while (inputError);

	int[] myMove = new int[] {row, col};
	return myMove;
    }
}
