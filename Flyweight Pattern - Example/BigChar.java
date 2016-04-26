/** ====================================================== C L A S S  BigChar
 * Base class for all large type characters
 */
abstract class BigChar
{
	// Array of characters to show the letter
	public final static int MATRIX_WIDTH = 6;   // number of columns	
	public final static int MATRIX_HEIGHT = 7;	  // number of rows	
	protected char[][] matrix = new char[ MATRIX_HEIGHT ][ MATRIX_WIDTH ];
	{	for( int i = 0; i < MATRIX_HEIGHT; ++i )
			for( int j = 0; j < MATRIX_WIDTH; ++j )
				matrix[ i ][ j ] = ' ';
	}
	 
	protected char constructionCharacter = 'X';   // letter that this big letter is constructed from
	protected String color = "black";   // won't actually color the letter: Superimpose a string only
		
/************************************************** C O N S T R U C T O R
 */
public BigChar()
{	super();
}

/************************************************** C O N S T R U C T O R
 * Postcondition: constructorCharacter == aConstructorCharacter;
 */
public BigChar( char aConstructionCharacter )
{
	super();
	constructionCharacter = aConstructionCharacter;
}

/************************************************** M E T H O D  setColor
 * Postcondition: color == aColor if aColor.length <= 4; otherwise color == first 4 characters of aColor
 */
public void setColor( String aColor )
{	
	if( aColor.length() <= 4 )
		color = aColor;
	else
		try
		{	
			color = aColor.substring( 0, 3 );
			System.out.println( "The color name will be abbreviated because there is not enough space." );
		}
		catch( IndexOutOfBoundsException o )
		{
			System.out.println
			 ( "IndexOutOfBoundsException in BigChar(String aColor) -- should never occur." );
			System.exit( 0 );
		}	
}

/************************************************** M E T H O D  setConstructionCharacter
 */
public void setConstructionCharacter( char aConstructionCharacter )
{	constructionCharacter = aConstructionCharacter;
}

/************************************************** M E T H O D  getMatrixForm
 */
public abstract char[][] getMatrixForm( String aColor );

}