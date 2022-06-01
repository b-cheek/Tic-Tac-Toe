import java.util.Arrays;

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

public class ComputerPlayerSmartDict // **** use your first name
{
    private final String      _name = "Brayden Cheek";    // **** change it to your name
    private final char        _symbol;
    private int 			  turn = 0;
    private char[][][][][][]  moves = {{{{}, {}, {}}, {{}, {
    	{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}}, }, {}}, {{}, {}, {}}}, {{{
    		{{' ', ' ', ' '}, {' ', 'O', ' '}, {' ', ' ', ' '}}, }, {}, {}}, {{}, {
    		{{' ', 'O', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}}, 
    		{{' ', ' ', ' '}, {' ', ' ', ' '}, {'O', ' ', ' '}}, 
    		{{' ', ' ', 'O'}, {' ', ' ', ' '}, {' ', ' ', ' '}}, 
    		{{' ', ' ', ' '}, {' ', ' ', 'O'}, {' ', ' ', ' '}}, 
    		{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', 'O'}}, 
    		{{' ', ' ', ' '}, {'O', ' ', ' '}, {' ', ' ', ' '}}, 
    		{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', 'O', ' '}}, 
    		{{'O', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}}, }, {}}, {{}, {}, {}}}, {{{
    		{{' ', ' ', ' '}, {' ', 'X', ' '}, {' ', 'O', ' '}}, 
    		{{' ', ' ', ' '}, {' ', 'X', 'O'}, {' ', ' ', ' '}}, 
    		{{' ', ' ', ' '}, {' ', 'X', ' '}, {' ', ' ', 'O'}}, 
    		{{' ', ' ', ' '}, {'O', 'X', ' '}, {' ', ' ', ' '}}, 
    		{{' ', 'O', ' '}, {' ', 'X', ' '}, {' ', ' ', ' '}}, }, {}, {
    		{{' ', ' ', ' '}, {' ', 'X', ' '}, {'O', ' ', ' '}}, }}, {{}, {}, {}}, {{
    		{{' ', ' ', 'O'}, {' ', 'X', ' '}, {' ', ' ', ' '}}, }, {}, {
    		{{'O', ' ', ' '}, {' ', 'X', ' '}, {' ', ' ', ' '}}, }}}, {{{
    		{{' ', 'O', 'O'}, {' ', 'X', ' '}, {' ', ' ', ' '}}, 
    		{{' ', ' ', ' '}, {'O', 'X', ' '}, {'O', ' ', ' '}}, 
    		{{' ', 'O', ' '}, {'O', 'X', ' '}, {' ', ' ', ' '}}, }, {
    		{{'O', ' ', 'O'}, {' ', 'X', ' '}, {' ', ' ', ' '}}, 
    		{{'X', ' ', ' '}, {' ', 'O', ' '}, {' ', 'O', ' '}}, }, {
    		{{' ', ' ', ' '}, {' ', 'X', 'O'}, {' ', ' ', 'O'}}, 
    		{{'X', ' ', ' '}, {' ', 'O', ' '}, {'O', ' ', ' '}}, 
    		{{'O', 'O', ' '}, {' ', 'X', ' '}, {' ', ' ', ' '}}, 
    		{{'X', ' ', ' '}, {' ', 'O', ' '}, {' ', ' ', 'O'}}, }}, {{
    		{{'O', ' ', ' '}, {' ', 'X', ' '}, {'O', ' ', ' '}}, 
    		{{'X', ' ', ' '}, {' ', 'O', 'O'}, {' ', ' ', ' '}}, }, {}, {
    		{{' ', 'O', ' '}, {' ', 'X', ' '}, {' ', ' ', 'O'}}, 
    		{{' ', ' ', 'O'}, {' ', 'X', ' '}, {' ', ' ', 'O'}}, 
    		{{'O', ' ', ' '}, {' ', 'X', ' '}, {' ', 'O', ' '}}, 
    		{{' ', 'O', ' '}, {' ', 'X', ' '}, {' ', 'O', ' '}}, 
    		{{'O', ' ', ' '}, {' ', 'X', ' '}, {' ', ' ', 'O'}}, 
    		{{' ', ' ', 'O'}, {' ', 'X', ' '}, {' ', 'O', ' '}}, 
    		{{' ', 'O', ' '}, {' ', 'X', ' '}, {'O', ' ', ' '}}, 
    		{{'X', ' ', ' '}, {'O', 'O', ' '}, {' ', ' ', ' '}}, 
    		{{' ', ' ', 'O'}, {' ', 'X', ' '}, {'O', ' ', ' '}}, }}, {{
    		{{'O', ' ', ' '}, {'O', 'X', ' '}, {' ', ' ', ' '}}, 
    		{{'X', ' ', 'O'}, {' ', 'O', ' '}, {' ', ' ', ' '}}, 
    		{{' ', ' ', ' '}, {' ', 'X', ' '}, {' ', 'O', 'O'}}, }, {
    		{{' ', ' ', ' '}, {' ', 'X', 'O'}, {'O', ' ', ' '}}, 
    		{{'O', ' ', ' '}, {' ', 'X', 'O'}, {' ', ' ', ' '}}, 
    		{{' ', ' ', 'O'}, {'O', 'X', ' '}, {' ', ' ', ' '}}, 
    		{{'X', 'O', ' '}, {' ', 'O', ' '}, {' ', ' ', ' '}}, 
    		{{' ', ' ', ' '}, {' ', 'X', ' '}, {'O', ' ', 'O'}}, 
    		{{' ', ' ', ' '}, {'O', 'X', 'O'}, {' ', ' ', ' '}}, 
    		{{' ', ' ', ' '}, {'O', 'X', ' '}, {' ', ' ', 'O'}}, }, {
    		{{' ', ' ', 'O'}, {' ', 'X', 'O'}, {' ', ' ', ' '}}, 
    		{{' ', ' ', ' '}, {'O', 'X', ' '}, {' ', 'O', ' '}}, 
    		{{' ', 'O', ' '}, {' ', 'X', 'O'}, {' ', ' ', ' '}}, 
    		{{' ', ' ', ' '}, {' ', 'X', 'O'}, {' ', 'O', ' '}}, 
    		{{' ', ' ', ' '}, {' ', 'X', ' '}, {'O', 'O', ' '}}, }}}, {{{
    		{{' ', 'O', 'O'}, {' ', 'X', ' '}, {'X', ' ', ' '}}, 
    		{{' ', ' ', 'X'}, {'O', 'X', ' '}, {'O', ' ', ' '}}, }, {
    		{{'X', ' ', ' '}, {'O', 'X', ' '}, {' ', ' ', 'O'}}, 
    		{{'O', ' ', 'O'}, {' ', 'X', ' '}, {' ', ' ', 'X'}}, 
    		{{' ', ' ', 'X'}, {' ', 'X', 'O'}, {'O', ' ', ' '}}, 
    		{{'O', ' ', 'O'}, {' ', 'X', ' '}, {'X', ' ', ' '}}, }, {
    		{{'X', ' ', ' '}, {' ', 'X', 'O'}, {' ', ' ', 'O'}}, 
    		{{'O', 'O', ' '}, {' ', 'X', ' '}, {' ', ' ', 'X'}}, }}, {{
    		{{'X', 'O', ' '}, {' ', 'X', ' '}, {' ', ' ', 'O'}}, 
    		{{'O', ' ', ' '}, {' ', 'X', ' '}, {'O', ' ', 'X'}}, 
    		{{'O', ' ', 'X'}, {' ', 'X', ' '}, {'O', ' ', ' '}}, 
    		{{' ', ' ', 'O'}, {' ', 'X', ' '}, {'X', 'O', ' '}}, }, {}, {
    		{{' ', ' ', 'O'}, {' ', 'X', ' '}, {'X', ' ', 'O'}}, 
    		{{'O', ' ', ' '}, {' ', 'X', ' '}, {' ', 'O', 'X'}}, 
    		{{'X', ' ', 'O'}, {' ', 'X', ' '}, {' ', ' ', 'O'}}, 
    		{{' ', 'O', 'X'}, {' ', 'X', ' '}, {'O', ' ', ' '}}, }}, {{
    		{{'X', ' ', ' '}, {' ', 'X', ' '}, {' ', 'O', 'O'}}, 
    		{{'O', ' ', ' '}, {'O', 'X', ' '}, {' ', ' ', 'X'}}, }, {
    		{{'O', ' ', ' '}, {' ', 'X', 'O'}, {' ', ' ', 'X'}}, 
    		{{' ', ' ', 'X'}, {' ', 'X', ' '}, {'O', ' ', 'O'}}, 
    		{{'X', ' ', ' '}, {' ', 'X', ' '}, {'O', ' ', 'O'}}, 
    		{{' ', ' ', 'O'}, {'O', 'X', ' '}, {'X', ' ', ' '}}, }, {
    		{{' ', ' ', 'X'}, {' ', 'X', ' '}, {'O', 'O', ' '}}, 
    		{{' ', ' ', 'O'}, {' ', 'X', 'O'}, {'X', ' ', ' '}}, }}}, {{{
    		{{' ', 'O', ' '}, {' ', 'X', 'O'}, {'O', 'X', ' '}}, 
    		{{' ', ' ', 'O'}, {'O', 'X', 'X'}, {'O', ' ', ' '}}, 
    		{{' ', ' ', 'O'}, {'O', 'X', 'X'}, {' ', 'O', ' '}}, 
    		{{' ', 'O', ' '}, {'O', 'X', 'X'}, {'O', ' ', ' '}}, 
    		{{' ', 'O', 'O'}, {'O', 'X', ' '}, {' ', 'X', ' '}}, }, {
    		{{'O', ' ', 'O'}, {' ', 'X', 'O'}, {' ', ' ', 'X'}}, 
    		{{'O', ' ', 'O'}, {'O', 'X', ' '}, {'X', ' ', ' '}}, 
    		{{'X', ' ', ' '}, {'O', 'O', 'X'}, {' ', 'O', ' '}}, }, {
    		{{'X', ' ', ' '}, {'O', 'O', 'X'}, {' ', ' ', 'O'}}, 
    		{{'O', 'O', ' '}, {' ', 'X', 'O'}, {' ', 'X', ' '}}, 
    		{{'O', 'O', ' '}, {' ', 'X', 'O'}, {' ', ' ', 'X'}}, 
    		{{' ', 'O', ' '}, {'O', 'X', ' '}, {' ', 'X', 'O'}}, 
    		{{'X', ' ', ' '}, {'X', 'O', 'O'}, {'O', ' ', ' '}}, 
    		{{'X', ' ', ' '}, {'O', 'O', 'X'}, {'O', ' ', ' '}}, 
    		{{'X', 'O', ' '}, {' ', 'O', ' '}, {'O', 'X', ' '}}, }}, {{
    		{{'X', 'O', ' '}, {' ', 'O', 'O'}, {' ', 'X', ' '}}, 
    		{{'O', ' ', ' '}, {' ', 'X', ' '}, {'O', 'O', 'X'}}, 
    		{{'O', 'O', 'X'}, {' ', 'X', ' '}, {'O', ' ', ' '}}, }, {}, {
    		{{'O', 'X', 'O'}, {' ', 'X', ' '}, {' ', 'O', ' '}}, 
    		{{' ', ' ', 'O'}, {' ', 'X', ' '}, {'X', 'O', 'O'}}, 
    		{{'X', 'O', 'O'}, {' ', 'X', ' '}, {' ', ' ', 'O'}}, 
    		{{' ', 'O', ' '}, {' ', 'X', ' '}, {'O', 'X', 'O'}}, 
    		{{'X', ' ', 'O'}, {'O', 'O', ' '}, {'X', ' ', ' '}}, 
    		{{'X', 'O', ' '}, {'O', 'O', ' '}, {' ', 'X', ' '}}, }}, {{
    		{{'O', ' ', ' '}, {'O', 'X', ' '}, {' ', 'O', 'X'}}, 
    		{{'O', ' ', ' '}, {'O', 'X', 'X'}, {' ', 'O', ' '}}, 
    		{{'O', ' ', ' '}, {'O', 'X', 'X'}, {' ', ' ', 'O'}}, 
    		{{'O', ' ', ' '}, {' ', 'X', 'O'}, {' ', 'O', 'X'}}, 
    		{{'X', 'O', ' '}, {'O', 'X', ' '}, {' ', ' ', 'O'}}, 
    		{{'X', 'O', 'O'}, {' ', 'O', ' '}, {' ', 'X', ' '}}, 
    		{{' ', 'O', ' '}, {'O', 'X', 'X'}, {' ', ' ', 'O'}}, 
    		{{'X', ' ', 'O'}, {'O', 'O', 'X'}, {' ', ' ', ' '}}, 
    		{{'X', 'O', ' '}, {' ', 'O', ' '}, {' ', 'X', 'O'}}, 
    		{{'X', 'X', 'O'}, {' ', 'O', ' '}, {' ', 'O', ' '}}}, {
    		{{'X', ' ', ' '}, {'O', 'X', ' '}, {'O', ' ', 'O'}}, 
    		{{'O', ' ', ' '}, {'X', 'X', 'O'}, {'O', ' ', ' '}}, 
    		{{' ', ' ', 'X'}, {' ', 'X', 'O'}, {'O', ' ', 'O'}}, 
    		{{'X', 'O', ' '}, {'O', 'O', 'X'}, {' ', ' ', ' '}}, 
    		{{' ', ' ', 'O'}, {'O', 'X', 'X'}, {' ', ' ', 'O'}}, 
    		{{'X', 'O', 'X'}, {' ', 'O', ' '}, {' ', ' ', 'O'}}, 
    		{{'X', 'O', 'X'}, {' ', 'O', ' '}, {'O', ' ', ' '}}, }, {
    		{{' ', 'O', ' '}, {'O', 'X', 'X'}, {' ', 'O', ' '}}, 
    		{{' ', 'O', ' '}, {'O', 'X', 'O'}, {' ', 'X', ' '}}, }}}, {{{}, {}, {}}, {{}, {}, {
    		{{' ', 'O', 'X'}, {' ', 'X', ' '}, {'O', 'X', 'O'}}, 
    		{{'X', 'O', ' '}, {' ', 'X', ' '}, {'O', 'X', 'O'}}, 
    		{{'O', 'X', 'O'}, {' ', 'X', ' '}, {'X', 'O', ' '}}, 
    		{{'O', 'X', 'O'}, {' ', 'X', ' '}, {' ', 'O', 'X'}}, }}, {{}, {
    		{{'O', ' ', 'X'}, {'X', 'X', 'O'}, {'O', ' ', ' '}}, 
    		{{'O', ' ', ' '}, {'X', 'X', 'O'}, {'O', ' ', 'X'}}, 
    		{{' ', ' ', 'O'}, {'O', 'X', 'X'}, {'X', ' ', 'O'}}, 
    		{{'X', ' ', 'O'}, {'O', 'X', 'X'}, {' ', ' ', 'O'}}, }, {}}}, {{{
    		{{' ', ' ', 'O'}, {'O', 'X', 'X'}, {'X', 'O', 'O'}}, 
    		{{' ', 'O', 'X'}, {' ', 'X', 'O'}, {'O', 'X', 'O'}}, 
    		{{' ', 'O', ' '}, {'O', 'X', 'X'}, {'O', 'X', 'O'}}, 
    		{{' ', 'O', 'O'}, {'O', 'X', 'X'}, {'X', ' ', 'O'}}, 
    		{{' ', 'O', 'O'}, {'O', 'X', 'X'}, {' ', 'X', 'O'}}, 
    		{{' ', 'O', 'X'}, {'O', 'X', ' '}, {'O', 'X', 'O'}}, }, {
    		{{'X', ' ', 'O'}, {'O', 'O', 'X'}, {'X', 'O', ' '}}, 
    		{{'O', ' ', 'O'}, {'O', 'X', ' '}, {'X', 'O', 'X'}}, 
    		{{'O', ' ', 'O'}, {' ', 'X', 'O'}, {'X', 'O', 'X'}}, 
    		{{'O', ' ', 'O'}, {'O', 'X', 'X'}, {'X', ' ', 'O'}}, 
    		{{'X', ' ', 'O'}, {'O', 'O', 'X'}, {'X', ' ', 'O'}}, 
    		{{'O', ' ', 'O'}, {'O', 'X', 'X'}, {'X', 'O', ' '}}, }, {
    		{{'O', ' ', ' '}, {'X', 'X', 'O'}, {'O', 'O', 'X'}}, 
    		{{'X', 'O', ' '}, {'O', 'O', 'X'}, {' ', 'X', 'O'}}, 
    		{{'X', 'O', ' '}, {'X', 'O', 'O'}, {'O', 'X', ' '}}, 
    		{{'X', 'O', ' '}, {' ', 'X', 'O'}, {'O', 'X', 'O'}}, 
    		{{'O', 'O', ' '}, {'X', 'X', 'O'}, {'O', 'X', ' '}}, 
    		{{'X', 'O', ' '}, {'O', 'X', ' '}, {'O', 'X', 'O'}}, 
    		{{'X', 'O', ' '}, {'O', 'O', 'X'}, {'O', 'X', ' '}}, }}, {{
    		{{'O', 'O', 'X'}, {' ', 'X', 'O'}, {'O', 'X', ' '}}, 
    		{{'O', 'O', 'X'}, {' ', 'X', 'O'}, {'O', ' ', 'X'}}, 
    		{{'X', 'O', 'X'}, {' ', 'O', ' '}, {'O', 'X', 'O'}}, 
    		{{'X', 'O', 'X'}, {' ', 'O', 'O'}, {'O', 'X', ' '}}, 
    		{{'X', 'O', 'X'}, {' ', 'O', 'O'}, {' ', 'X', 'O'}}, }, {}, {
    		{{'X', 'O', 'O'}, {'O', 'X', ' '}, {'X', ' ', 'O'}}, 
    		{{'X', 'O', 'X'}, {'O', 'O', ' '}, {'O', 'X', ' '}}, 
    		{{'X', 'X', 'O'}, {'O', 'O', ' '}, {'X', 'O', ' '}}, 
    		{{'X', 'O', 'O'}, {'O', 'X', ' '}, {' ', 'X', 'O'}}, 
    		{{'X', 'O', ' '}, {'O', 'O', ' '}, {'X', 'X', 'O'}}, 
    		{{'X', 'O', 'X'}, {'O', 'O', ' '}, {' ', 'X', 'O'}}, }}, {{
    		{{'O', 'X', 'O'}, {' ', 'X', 'O'}, {' ', 'O', 'X'}}, 
    		{{'O', 'X', 'O'}, {'O', 'X', 'X'}, {' ', 'O', ' '}}, 
    		{{'X', 'O', 'O'}, {'O', 'X', 'X'}, {' ', ' ', 'O'}}, 
    		{{'X', 'O', 'O'}, {'O', 'O', 'X'}, {' ', 'X', ' '}}, 
    		{{'X', ' ', 'O'}, {'O', 'X', 'X'}, {' ', 'O', 'O'}}, 
    		{{'X', 'X', 'O'}, {'O', 'O', 'X'}, {' ', 'O', ' '}}, }, {
    		{{'X', 'O', 'X'}, {'O', 'O', 'X'}, {' ', ' ', 'O'}}, 
    		{{'X', ' ', 'O'}, {'O', 'X', 'X'}, {'O', ' ', 'O'}}, 
    		{{'X', 'O', 'X'}, {'X', 'O', 'O'}, {'O', ' ', ' '}}, 
    		{{'X', 'O', 'O'}, {'O', 'O', 'X'}, {'X', ' ', ' '}}, 
    		{{'X', 'O', ' '}, {'O', 'X', 'X'}, {'O', ' ', 'O'}}, }, {
    		{{'O', 'O', 'X'}, {'X', 'X', 'O'}, {'O', ' ', ' '}}, 
    		{{'O', 'X', 'O'}, {'O', 'X', ' '}, {'X', 'O', ' '}}, }}}, {{{
    		{{' ', 'O', 'X'}, {'O', 'X', 'X'}, {'O', 'X', 'O'}}, 
    		{{' ', 'O', 'O'}, {'O', 'X', 'X'}, {'X', 'X', 'O'}}, }, {}, {
    		{{'X', 'O', ' '}, {'O', 'X', 'X'}, {'O', 'X', 'O'}}, 
    		{{'O', 'O', ' '}, {'X', 'X', 'O'}, {'O', 'X', 'X'}}, }}, {{}, {}, {}}, {{
    		{{'O', 'X', 'O'}, {'O', 'X', 'X'}, {' ', 'O', 'X'}}, 
    		{{'X', 'O', 'O'}, {'O', 'X', 'X'}, {' ', 'X', 'O'}}, }, {}, {
    		{{'O', 'O', 'X'}, {'X', 'X', 'O'}, {'O', 'X', ' '}}, 
    		{{'O', 'X', 'O'}, {'O', 'X', 'X'}, {'X', 'O', ' '}}, }}}};
    
    public ComputerPlayerSmartDict(char symbol) // **** use your first name
    {
	_symbol = symbol;
	if (_symbol == 'O') moves = new char[][][][][][] {{{{}, {}, {}}, {{}, {
		{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}}, }, {}}, {{}, {}, {}}}, {{{
			{{' ', ' ', ' '}, {' ', 'X', ' '}, {' ', ' ', ' '}}, }, {}, {}}, {{}, {
			{{' ', 'X', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}}, 
			{{' ', ' ', ' '}, {' ', ' ', ' '}, {'X', ' ', ' '}}, 
			{{' ', ' ', 'X'}, {' ', ' ', ' '}, {' ', ' ', ' '}}, 
			{{' ', ' ', ' '}, {' ', ' ', 'X'}, {' ', ' ', ' '}}, 
			{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', 'X'}}, 
			{{' ', ' ', ' '}, {'X', ' ', ' '}, {' ', ' ', ' '}}, 
			{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', 'X', ' '}}, 
			{{'X', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}}, }, {}}, {{}, {}, {}}}, {{{
			{{' ', ' ', ' '}, {' ', 'O', ' '}, {' ', 'X', ' '}}, 
			{{' ', ' ', ' '}, {' ', 'O', 'X'}, {' ', ' ', ' '}}, 
			{{' ', ' ', ' '}, {' ', 'O', ' '}, {' ', ' ', 'X'}}, 
			{{' ', ' ', ' '}, {'X', 'O', ' '}, {' ', ' ', ' '}}, 
			{{' ', 'X', ' '}, {' ', 'O', ' '}, {' ', ' ', ' '}}, }, {}, {
			{{' ', ' ', ' '}, {' ', 'O', ' '}, {'X', ' ', ' '}}, }}, {{}, {}, {}}, {{
			{{' ', ' ', 'X'}, {' ', 'O', ' '}, {' ', ' ', ' '}}, }, {}, {
			{{'X', ' ', ' '}, {' ', 'O', ' '}, {' ', ' ', ' '}}, }}}, {{{
			{{' ', 'X', 'X'}, {' ', 'O', ' '}, {' ', ' ', ' '}}, 
			{{' ', ' ', ' '}, {'X', 'O', ' '}, {'X', ' ', ' '}}, 
			{{' ', 'X', ' '}, {'X', 'O', ' '}, {' ', ' ', ' '}}, }, {
			{{'X', ' ', 'X'}, {' ', 'O', ' '}, {' ', ' ', ' '}}, 
			{{'O', ' ', ' '}, {' ', 'X', ' '}, {' ', 'X', ' '}}, }, {
			{{' ', ' ', ' '}, {' ', 'O', 'X'}, {' ', ' ', 'X'}}, 
			{{'O', ' ', ' '}, {' ', 'X', ' '}, {'X', ' ', ' '}}, 
			{{'X', 'X', ' '}, {' ', 'O', ' '}, {' ', ' ', ' '}}, 
			{{'O', ' ', ' '}, {' ', 'X', ' '}, {' ', ' ', 'X'}}, }}, {{
			{{'X', ' ', ' '}, {' ', 'O', ' '}, {'X', ' ', ' '}}, 
			{{'O', ' ', ' '}, {' ', 'X', 'X'}, {' ', ' ', ' '}}, }, {}, {
			{{' ', 'X', ' '}, {' ', 'O', ' '}, {' ', ' ', 'X'}}, 
			{{' ', ' ', 'X'}, {' ', 'O', ' '}, {' ', ' ', 'X'}}, 
			{{'X', ' ', ' '}, {' ', 'O', ' '}, {' ', 'X', ' '}}, 
			{{' ', 'X', ' '}, {' ', 'O', ' '}, {' ', 'X', ' '}}, 
			{{'X', ' ', ' '}, {' ', 'O', ' '}, {' ', ' ', 'X'}}, 
			{{' ', ' ', 'X'}, {' ', 'O', ' '}, {' ', 'X', ' '}}, 
			{{' ', 'X', ' '}, {' ', 'O', ' '}, {'X', ' ', ' '}}, 
			{{'O', ' ', ' '}, {'X', 'X', ' '}, {' ', ' ', ' '}}, 
			{{' ', ' ', 'X'}, {' ', 'O', ' '}, {'X', ' ', ' '}}, }}, {{
			{{'X', ' ', ' '}, {'X', 'O', ' '}, {' ', ' ', ' '}}, 
			{{'O', ' ', 'X'}, {' ', 'X', ' '}, {' ', ' ', ' '}}, 
			{{' ', ' ', ' '}, {' ', 'O', ' '}, {' ', 'X', 'X'}}, }, {
			{{' ', ' ', ' '}, {' ', 'O', 'X'}, {'X', ' ', ' '}}, 
			{{'X', ' ', ' '}, {' ', 'O', 'X'}, {' ', ' ', ' '}}, 
			{{' ', ' ', 'X'}, {'X', 'O', ' '}, {' ', ' ', ' '}}, 
			{{'O', 'X', ' '}, {' ', 'X', ' '}, {' ', ' ', ' '}}, 
			{{' ', ' ', ' '}, {' ', 'O', ' '}, {'X', ' ', 'X'}}, 
			{{' ', ' ', ' '}, {'X', 'O', 'X'}, {' ', ' ', ' '}}, 
			{{' ', ' ', ' '}, {'X', 'O', ' '}, {' ', ' ', 'X'}}, }, {
			{{' ', ' ', 'X'}, {' ', 'O', 'X'}, {' ', ' ', ' '}}, 
			{{' ', ' ', ' '}, {'X', 'O', ' '}, {' ', 'X', ' '}}, 
			{{' ', 'X', ' '}, {' ', 'O', 'X'}, {' ', ' ', ' '}}, 
			{{' ', ' ', ' '}, {' ', 'O', 'X'}, {' ', 'X', ' '}}, 
			{{' ', ' ', ' '}, {' ', 'O', ' '}, {'X', 'X', ' '}}, }}}, {{{
			{{' ', 'X', 'X'}, {' ', 'O', ' '}, {'O', ' ', ' '}}, 
			{{' ', ' ', 'O'}, {'X', 'O', ' '}, {'X', ' ', ' '}}, }, {
			{{'O', ' ', ' '}, {'X', 'O', ' '}, {' ', ' ', 'X'}}, 
			{{'X', ' ', 'X'}, {' ', 'O', ' '}, {' ', ' ', 'O'}}, 
			{{' ', ' ', 'O'}, {' ', 'O', 'X'}, {'X', ' ', ' '}}, 
			{{'X', ' ', 'X'}, {' ', 'O', ' '}, {'O', ' ', ' '}}, }, {
			{{'O', ' ', ' '}, {' ', 'O', 'X'}, {' ', ' ', 'X'}}, 
			{{'X', 'X', ' '}, {' ', 'O', ' '}, {' ', ' ', 'O'}}, }}, {{
			{{'O', 'X', ' '}, {' ', 'O', ' '}, {' ', ' ', 'X'}}, 
			{{'X', ' ', ' '}, {' ', 'O', ' '}, {'X', ' ', 'O'}}, 
			{{'X', ' ', 'O'}, {' ', 'O', ' '}, {'X', ' ', ' '}}, 
			{{' ', ' ', 'X'}, {' ', 'O', ' '}, {'O', 'X', ' '}}, }, {}, {
			{{' ', ' ', 'X'}, {' ', 'O', ' '}, {'O', ' ', 'X'}}, 
			{{'X', ' ', ' '}, {' ', 'O', ' '}, {' ', 'X', 'O'}}, 
			{{'O', ' ', 'X'}, {' ', 'O', ' '}, {' ', ' ', 'X'}}, 
			{{' ', 'X', 'O'}, {' ', 'O', ' '}, {'X', ' ', ' '}}, }}, {{
			{{'O', ' ', ' '}, {' ', 'O', ' '}, {' ', 'X', 'X'}}, 
			{{'X', ' ', ' '}, {'X', 'O', ' '}, {' ', ' ', 'O'}}, }, {
			{{'X', ' ', ' '}, {' ', 'O', 'X'}, {' ', ' ', 'O'}}, 
			{{' ', ' ', 'O'}, {' ', 'O', ' '}, {'X', ' ', 'X'}}, 
			{{'O', ' ', ' '}, {' ', 'O', ' '}, {'X', ' ', 'X'}}, 
			{{' ', ' ', 'X'}, {'X', 'O', ' '}, {'O', ' ', ' '}}, }, {
			{{' ', ' ', 'O'}, {' ', 'O', ' '}, {'X', 'X', ' '}}, 
			{{' ', ' ', 'X'}, {' ', 'O', 'X'}, {'O', ' ', ' '}}, }}}, {{{
			{{' ', 'X', ' '}, {' ', 'O', 'X'}, {'X', 'O', ' '}}, 
			{{' ', ' ', 'X'}, {'X', 'O', 'O'}, {'X', ' ', ' '}}, 
			{{' ', ' ', 'X'}, {'X', 'O', 'O'}, {' ', 'X', ' '}}, 
			{{' ', 'X', ' '}, {'X', 'O', 'O'}, {'X', ' ', ' '}}, 
			{{' ', 'X', 'X'}, {'X', 'O', ' '}, {' ', 'O', ' '}}, }, {
			{{'X', ' ', 'X'}, {' ', 'O', 'X'}, {' ', ' ', 'O'}}, 
			{{'X', ' ', 'X'}, {'X', 'O', ' '}, {'O', ' ', ' '}}, 
			{{'O', ' ', ' '}, {'X', 'X', 'O'}, {' ', 'X', ' '}}, }, {
			{{'O', ' ', ' '}, {'X', 'X', 'O'}, {' ', ' ', 'X'}}, 
			{{'X', 'X', ' '}, {' ', 'O', 'X'}, {' ', 'O', ' '}}, 
			{{'X', 'X', ' '}, {' ', 'O', 'X'}, {' ', ' ', 'O'}}, 
			{{' ', 'X', ' '}, {'X', 'O', ' '}, {' ', 'O', 'X'}}, 
			{{'O', ' ', ' '}, {'O', 'X', 'X'}, {'X', ' ', ' '}}, 
			{{'O', ' ', ' '}, {'X', 'X', 'O'}, {'X', ' ', ' '}}, 
			{{'O', 'X', ' '}, {' ', 'X', ' '}, {'X', 'O', ' '}}, }}, {{
			{{'O', 'X', ' '}, {' ', 'X', 'X'}, {' ', 'O', ' '}}, 
			{{'X', ' ', ' '}, {' ', 'O', ' '}, {'X', 'X', 'O'}}, 
			{{'X', 'X', 'O'}, {' ', 'O', ' '}, {'X', ' ', ' '}}, }, {}, {
			{{'X', 'O', 'X'}, {' ', 'O', ' '}, {' ', 'X', ' '}}, 
			{{' ', ' ', 'X'}, {' ', 'O', ' '}, {'O', 'X', 'X'}}, 
			{{'O', 'X', 'X'}, {' ', 'O', ' '}, {' ', ' ', 'X'}}, 
			{{' ', 'X', ' '}, {' ', 'O', ' '}, {'X', 'O', 'X'}}, 
			{{'O', ' ', 'X'}, {'X', 'X', ' '}, {'O', ' ', ' '}}, 
			{{'O', 'X', ' '}, {'X', 'X', ' '}, {' ', 'O', ' '}}, }}, {{
			{{'X', ' ', ' '}, {'X', 'O', ' '}, {' ', 'X', 'O'}}, 
			{{'X', ' ', ' '}, {'X', 'O', 'O'}, {' ', 'X', ' '}}, 
			{{'X', ' ', ' '}, {'X', 'O', 'O'}, {' ', ' ', 'X'}}, 
			{{'X', ' ', ' '}, {' ', 'O', 'X'}, {' ', 'X', 'O'}}, 
			{{'O', 'X', ' '}, {'X', 'O', ' '}, {' ', ' ', 'X'}}, 
			{{'O', 'X', 'X'}, {' ', 'X', ' '}, {' ', 'O', ' '}}, 
			{{' ', 'X', ' '}, {'X', 'O', 'O'}, {' ', ' ', 'X'}}, 
			{{'O', ' ', 'X'}, {'X', 'X', 'O'}, {' ', ' ', ' '}}, 
			{{'O', 'X', ' '}, {' ', 'X', ' '}, {' ', 'O', 'X'}}, 
			{{'O', 'O', 'X'}, {' ', 'X', ' '}, {' ', 'X', ' '}}}, {
			{{'O', ' ', ' '}, {'X', 'O', ' '}, {'X', ' ', 'X'}}, 
			{{'X', ' ', ' '}, {'O', 'O', 'X'}, {'X', ' ', ' '}}, 
			{{' ', ' ', 'O'}, {' ', 'O', 'X'}, {'X', ' ', 'X'}}, 
			{{'O', 'X', ' '}, {'X', 'X', 'O'}, {' ', ' ', ' '}}, 
			{{' ', ' ', 'X'}, {'X', 'O', 'O'}, {' ', ' ', 'X'}}, 
			{{'O', 'X', 'O'}, {' ', 'X', ' '}, {' ', ' ', 'X'}}, 
			{{'O', 'X', 'O'}, {' ', 'X', ' '}, {'X', ' ', ' '}}, }, {
			{{' ', 'X', ' '}, {'X', 'O', 'O'}, {' ', 'X', ' '}}, 
			{{' ', 'X', ' '}, {'X', 'O', 'X'}, {' ', 'O', ' '}}, }}}, {{{}, {}, {}}, {{}, {}, {
			{{' ', 'X', 'O'}, {' ', 'O', ' '}, {'X', 'O', 'X'}}, 
			{{'O', 'X', ' '}, {' ', 'O', ' '}, {'X', 'O', 'X'}}, 
			{{'X', 'O', 'X'}, {' ', 'O', ' '}, {'O', 'X', ' '}}, 
			{{'X', 'O', 'X'}, {' ', 'O', ' '}, {' ', 'X', 'O'}}, }}, {{}, {
			{{'X', ' ', 'O'}, {'O', 'O', 'X'}, {'X', ' ', ' '}}, 
			{{'X', ' ', ' '}, {'O', 'O', 'X'}, {'X', ' ', 'O'}}, 
			{{' ', ' ', 'X'}, {'X', 'O', 'O'}, {'O', ' ', 'X'}}, 
			{{'O', ' ', 'X'}, {'X', 'O', 'O'}, {' ', ' ', 'X'}}, }, {}}}, {{{
			{{' ', ' ', 'X'}, {'X', 'O', 'O'}, {'O', 'X', 'X'}}, 
			{{' ', 'X', 'O'}, {' ', 'O', 'X'}, {'X', 'O', 'X'}}, 
			{{' ', 'X', ' '}, {'X', 'O', 'O'}, {'X', 'O', 'X'}}, 
			{{' ', 'X', 'X'}, {'X', 'O', 'O'}, {'O', ' ', 'X'}}, 
			{{' ', 'X', 'X'}, {'X', 'O', 'O'}, {' ', 'O', 'X'}}, 
			{{' ', 'X', 'O'}, {'X', 'O', ' '}, {'X', 'O', 'X'}}, }, {
			{{'O', ' ', 'X'}, {'X', 'X', 'O'}, {'O', 'X', ' '}}, 
			{{'X', ' ', 'X'}, {'X', 'O', ' '}, {'O', 'X', 'O'}}, 
			{{'X', ' ', 'X'}, {' ', 'O', 'X'}, {'O', 'X', 'O'}}, 
			{{'X', ' ', 'X'}, {'X', 'O', 'O'}, {'O', ' ', 'X'}}, 
			{{'O', ' ', 'X'}, {'X', 'X', 'O'}, {'O', ' ', 'X'}}, 
			{{'X', ' ', 'X'}, {'X', 'O', 'O'}, {'O', 'X', ' '}}, }, {
			{{'X', ' ', ' '}, {'O', 'O', 'X'}, {'X', 'X', 'O'}}, 
			{{'O', 'X', ' '}, {'X', 'X', 'O'}, {' ', 'O', 'X'}}, 
			{{'O', 'X', ' '}, {'O', 'X', 'X'}, {'X', 'O', ' '}}, 
			{{'O', 'X', ' '}, {' ', 'O', 'X'}, {'X', 'O', 'X'}}, 
			{{'X', 'X', ' '}, {'O', 'O', 'X'}, {'X', 'O', ' '}}, 
			{{'O', 'X', ' '}, {'X', 'O', ' '}, {'X', 'O', 'X'}}, 
			{{'O', 'X', ' '}, {'X', 'X', 'O'}, {'X', 'O', ' '}}, }}, {{
			{{'X', 'X', 'O'}, {' ', 'O', 'X'}, {'X', 'O', ' '}}, 
			{{'X', 'X', 'O'}, {' ', 'O', 'X'}, {'X', ' ', 'O'}}, 
			{{'O', 'X', 'O'}, {' ', 'X', ' '}, {'X', 'O', 'X'}}, 
			{{'O', 'X', 'O'}, {' ', 'X', 'X'}, {'X', 'O', ' '}}, 
			{{'O', 'X', 'O'}, {' ', 'X', 'X'}, {' ', 'O', 'X'}}, }, {}, {
			{{'O', 'X', 'X'}, {'X', 'O', ' '}, {'O', ' ', 'X'}}, 
			{{'O', 'X', 'O'}, {'X', 'X', ' '}, {'X', 'O', ' '}}, 
			{{'O', 'O', 'X'}, {'X', 'X', ' '}, {'O', 'X', ' '}}, 
			{{'O', 'X', 'X'}, {'X', 'O', ' '}, {' ', 'O', 'X'}}, 
			{{'O', 'X', ' '}, {'X', 'X', ' '}, {'O', 'O', 'X'}}, 
			{{'O', 'X', 'O'}, {'X', 'X', ' '}, {' ', 'O', 'X'}}, }}, {{
			{{'X', 'O', 'X'}, {' ', 'O', 'X'}, {' ', 'X', 'O'}}, 
			{{'X', 'O', 'X'}, {'X', 'O', 'O'}, {' ', 'X', ' '}}, 
			{{'O', 'X', 'X'}, {'X', 'O', 'O'}, {' ', ' ', 'X'}}, 
			{{'O', 'X', 'X'}, {'X', 'X', 'O'}, {' ', 'O', ' '}}, 
			{{'O', ' ', 'X'}, {'X', 'O', 'O'}, {' ', 'X', 'X'}}, 
			{{'O', 'O', 'X'}, {'X', 'X', 'O'}, {' ', 'X', ' '}}, }, {
			{{'O', 'X', 'O'}, {'X', 'X', 'O'}, {' ', ' ', 'X'}}, 
			{{'O', ' ', 'X'}, {'X', 'O', 'O'}, {'X', ' ', 'X'}}, 
			{{'O', 'X', 'O'}, {'O', 'X', 'X'}, {'X', ' ', ' '}}, 
			{{'O', 'X', 'X'}, {'X', 'X', 'O'}, {'O', ' ', ' '}}, 
			{{'O', 'X', ' '}, {'X', 'O', 'O'}, {'X', ' ', 'X'}}, }, {
			{{'X', 'X', 'O'}, {'O', 'O', 'X'}, {'X', ' ', ' '}}, 
			{{'X', 'O', 'X'}, {'X', 'O', ' '}, {'O', 'X', ' '}}, }}}, {{{
			{{' ', 'X', 'O'}, {'X', 'O', 'O'}, {'X', 'O', 'X'}}, 
			{{' ', 'X', 'X'}, {'X', 'O', 'O'}, {'O', 'O', 'X'}}, }, {}, {
			{{'O', 'X', ' '}, {'X', 'O', 'O'}, {'X', 'O', 'X'}}, 
			{{'X', 'X', ' '}, {'O', 'O', 'X'}, {'X', 'O', 'O'}}, }}, {{}, {}, {}}, {{
			{{'X', 'O', 'X'}, {'X', 'O', 'O'}, {' ', 'X', 'O'}}, 
			{{'O', 'X', 'X'}, {'X', 'O', 'O'}, {' ', 'O', 'X'}}, }, {}, {
			{{'X', 'X', 'O'}, {'O', 'O', 'X'}, {'X', 'O', ' '}}, 
			{{'X', 'O', 'X'}, {'X', 'O', 'O'}, {'O', 'X', ' '}}, }}}};
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
	
	turn = getTurn(board);

	// **** add instructions for my strategy to decide myRow and myCol

	for (int b=0; b<3; b++) for (int c=0; c<3; c++) for (char[][] arr: moves[turn][b][c]) {
		if (Arrays.deepEquals(arr, board)) {
			return new int[] {b, c};
		}
	}	
	





	// return my move (myRow, myCol) as the last step
	int[] myMove = new int[] {myRow, myCol};
	return myMove;
    }

    public static int getTurn(char[][] board) {
    	int turn=0;
    	for (char[] row: board) for (char symbol: row) if (symbol=='O' || symbol=='X') turn++;
    	return turn;
    }
}