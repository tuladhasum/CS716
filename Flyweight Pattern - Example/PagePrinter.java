/** ====================================================== C L A S S  PagePrinter
 * Gets strings and prints large character form.
 * Client of the Flyweight design pattern application (Note: no separate setup required.)
 */

import java.io.*;
import java.util.*;

class PagePrinter 
{
	// 2D array for constructing big characters so as to print them
	private final static int PAGE_WIDTH = 70;
	private final static int PAGE_LENGTH = 10;   // enough to allow more than one big line for now
	private static char[][] pageReadyForPrinting = new char[ PAGE_LENGTH ][ PAGE_WIDTH ];
	static   // initialize
	{	for( int i = 0; i < PAGE_LENGTH; ++i )
			for( int j = 0; j < PAGE_WIDTH; ++j )
				pageReadyForPrinting[ i ][ j ] = ' ';
	}		
	
	// Option to give "color" to the large print letters
	static String color	= "black";  // color for the characters between startColorIndex and endColorIndex
	static int startColorIndex = 0;   // first index in input string where "color" will apply
	static int endColorIndex = 0;  // last index in input string where "color" will apply
	
	private static final int SPACING_BETWEEN_BIG_CHARACTERS = 2;

/************************************************** C O N S T R U C T O R
 */
public PagePrinter()
{	super();
}

/************************************************** M E T H O D  formPageReadyForPrinting
 * Postconditions:   
 * 'formPageReadyForPrinting' contains as many large versions of characters as possible of 'anInputString' 
 * with 'currentColor' written across those starting at 'startColorIndex' and ending at 'endColorIndex'
 * -- and "black" otherwise.  The large characters appear starting from the top right.
 */
public static void formPageReadyForPrinting( String anInputString )
{
	String currentColor = "black";    // -- of the current character
	
	// Form the 2D char array ("matrix") for output 
	
	char character = 'x';
	BigChar bigChar;
	int numBigCharsOnALine =   // the number that will fit on the width of the console
	 (int)( PAGE_WIDTH / ( BigChar.MATRIX_WIDTH + SPACING_BETWEEN_BIG_CHARACTERS ) );
	 
	// Try to insert the cahracters of 'anInputString' one at a time 
	for( int stringIndex = 0; 
	 stringIndex < Math.min( anInputString.length(), numBigCharsOnALine );   // whichever occurs first
	 ++stringIndex )  
	{
		// Isolate the current BigChar object
		character = anInputString.charAt( stringIndex );   // get the current character
		bigChar = BigCharFactory.getFlyweight( character );   // get the corresponding large type version
		// Insert into slot for next bigChar
		if( bigChar != null)
		{
			if( ( stringIndex >= startColorIndex ) && ( stringIndex <= endColorIndex ) )
				currentColor = PagePrinter.color;   // the chosen color applies within chosen range
			else
				currentColor = "black";   // default
				
			// Insert each big character into pageReadyForPrinting
			insert( bigChar.getMatrixForm( currentColor ), 0, 
			 stringIndex*( BigChar.MATRIX_WIDTH + SPACING_BETWEEN_BIG_CHARACTERS ) );
		}
		else
			System.out.println( "No big type for character " + character );
	}
}

/************************************************** M E T H O D  getCharacterCompositionForEachBigChar
 * Each big character will be constructed with a letter of the user's choice
 *
 * Postconditions: For each character listed in 'BigCharFactory.flyweights':
 *     (a) The user has been queried for a construction character (used to actually form the big letter)
 *     (b) The user's response has been saved in each 'BigChar' singleton flyweight
 */
private static void getCharacterCompositionForEachBigChar()
{	
	BufferedReader bufReader = new BufferedReader( new InputStreamReader( System.in ) );
	String keyToBigChar = " "; 
	String input = " "; 

	// Go through the list in 'BigCharFactory.flyweights'
	for( Enumeration enumeration = BigCharFactory.getFlyweights().keys(); enumeration.hasMoreElements() ;)
	{
		keyToBigChar =  (String)enumeration.nextElement();   // e.g., "B" for the corresponding BigChar  
		
		System.out.println( "What character do you want to use to build each big " + keyToBigChar + "?" );
		try
		{
			input = bufReader.readLine();
			System.out.println( "You chose " + input + ".  The first character will be used." );
			// Get the singelton flyweight for this choice
			BigChar bigCharSingleton =  (BigChar)BigCharFactory.getFlyweights().get( keyToBigChar );
			bigCharSingleton.setConstructionCharacter( input.charAt( 0 ) );   // set what it will be built with
		}
		catch( IOException e )
		{	System.out.println( e ); }
	}
}

/************************************************** M E T H O D  getColorRequirements
 * Postconditions:
 * (1) The user has been prompted to give start, stop and color information
 * (2) 'startColorIndex' is the index in the input string -- provided by the user -- at which the color applies
 * (3) 'stopIndex' is the index in the input string -- provided by the user -- at which the color no longer applies
 * (4) 'color' is the user's desired color between these two indices
 */
private static void getColorRequirements()
{
	try
	{		
		BufferedReader bufReader = new BufferedReader( new InputStreamReader( System.in ) );
		
		// Select color
		System.out.println( "You may 'color' some of the letters.  Please enter any color:" );
		color = bufReader.readLine();
		System.out.println( "You chose " + color );

		// Select start and end points.  These are set to 0 and 0 respectively as defaults in case the user
		// fails to enter legitimate entries.		
		System.out.println( "In what follows, if you don't type in legal entries, 1 will be assumed:");
		startColorIndex = 0;
		endColorIndex = 0;

		// Select start point, counting from 1
		System.out.println( "When (for first character type '1' etc.) -- do want this color to begin applying? :" );
		String input = bufReader.readLine();
		System.out.println( "You chose " + input );
		startColorIndex = ( new Integer( input ) ).intValue() - 1;   // exception if not an integer

		// Select end point, counting from 1
		System.out.println
		( "When (>= your last input) do want this color to stop applying? :" );
		input = bufReader.readLine();
		System.out.println( "You chose " + input );	
		endColorIndex = ( new Integer( input ) ).intValue() - 1;   // exception if not an integer
		if( endColorIndex < startColorIndex + 1 ) // incorrect
		{
			System.out.println( "Sorry, but both indices will be set to zero." );
			endColorIndex = startColorIndex = 0;
		}
				
	}
	catch( IOException e )
	{	System.out.println( e ); }
	catch( NumberFormatException e ) 
	{	System.out.println( e ); }
}

/************************************************** M E T H O D  getString
 * Note: In reality, the text to be translated into large type would be obtained from a text file.
 * Here we will obtain a single line from the user for demonstration.  
 *
 * Returns: the string typed in by the user if the characters are only those in' BigCharFactory.flyweights'
 *          otherwise the string "ABB"
 */
private static String getString()
{	
	BufferedReader bufReader;
	String returnString = " ";   

	System.out.println( "Please enter string of only the following characters for enlargement:" );
	System.out.println( "If any other characters appear in the input, the string ABB will be assumed." );
	
	for( Enumeration enumeration = BigCharFactory.getFlyweights().keys(); enumeration.hasMoreElements() ;)
		System.out.println( enumeration.nextElement() );
	
	// Get the input string
	try   
	{
		bufReader = new BufferedReader( new InputStreamReader( System.in ) );
		returnString = bufReader.readLine();
		System.out.println( "You chose " + returnString + "\n" );
	}
	catch( IOException e )
	{	System.out.println( e ); }

	// Check that the string input is composed of legitimate characters: otherwise substitute "ABB"
	for( int i = 0; i < returnString.length(); ++i )
		if( BigCharFactory.getFlyweight( returnString.charAt( i ) ) == null )   // not a permissable character
		{
			System.out.println( "Illegal characters were input: The string 'ABB' will be used instead." );
			return "ABB";   // replace by default
		}
	
	return returnString;   // input was legitimate
}

/************************************************** M E T H O D  main
 * Postconditions:  The application has ...
 * (1) ... listed the permissible characters
 * (2) ... requested a string from the user
 * (3) ... used a default string if the user has made a mistake (see 'getString()' for details)
 * (4) ... obtained from the user the color and starting place and ending place for the color
 * (5) ... obtained from the user the characters required to build the large type characters
 * (6) ... output as many characters as will fit in 'pageReadyForPrinting' of the required string   
 *         using the requestedindividual characters, with the requested colors writen across them
 */
public static void main( String[] args )
{
	String inputString = getString();   // get the string to be converted
	
	String currentColor = "black";    // -- of the current character
	getColorRequirements();
	getCharacterCompositionForEachBigChar();   // the letter used to actually consruct large type
	
	// Form the 2D char array ("matrix") for output 
	formPageReadyForPrinting( inputString );

	printPageToConsole();
}   // end main()

/************************************************** M E T H O D
 * Postcondition: The content of 'pageReadyForPrinting' is on the console
 */
public static void printPageToConsole()
{
	for( int i = 0; i < PAGE_LENGTH; ++i )
	{
		System.out.println();
		for( int j = 0; j < PAGE_WIDTH; ++j )
			System.out.print( pageReadyForPrinting[ i ][ j ] );
	}
}

/************************************************** M E T H O D  insert
 * Postcondition: The characters of 'a2DArray' have be inserted into 'pageReadyForPrinting' as follows.
 * They are placed right and down from '[aRowPlace][aColPlace]' for as long as this covers 'pageReadyForPrinting' 
 * -- otherwise each out-of-range character is ignored and a console message is generated.
 */
public static void insert( char[][] a2DArray, int aRowPlace, int aColPlace )
{
	for( int rowIndex = 0; rowIndex < a2DArray.length; ++rowIndex )
		for( int colIndex = 0; colIndex < a2DArray[0].length; ++colIndex )
			// Check that the element is in range of pageReadyForPrinting; insert if so
			if( aRowPlace + rowIndex < PAGE_LENGTH  && aColPlace + colIndex < PAGE_WIDTH )
				pageReadyForPrinting[ aRowPlace + rowIndex ][ aColPlace + colIndex ] =
				a2DArray[ rowIndex ][ colIndex ];
			else
				System.out.println( "Insufficient space for all letters as requested. (PagePrinter.insert())" ); 
}

}