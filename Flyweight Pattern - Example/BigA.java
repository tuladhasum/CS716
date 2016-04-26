/** ====================================================== C L A S S  BigA
 * Flyweight for large type "A" will be made with this singleton
 */
class BigA extends BigChar
{
	private static BigA bigA = new BigA( 'A' );   // Singleton: default letter to construct with

/************************************************** C O N S T R U C T O R
 */
private BigA()
{	super();
}

/************************************************** C O N S T R U C T O R
 */
private BigA( char aConstructionCharacter )
{	super( aConstructionCharacter );	
}

/************************************************** M E T H O D  getMatrixForm
 * Returns: 
 * "matrix" filled in with a big version of "A", made from the letter 'constructionCharacter'
 * Across line 3 is superimposed "-xxxxx" where xxxxx are the first 
 * 'BigChar.MAX_COLOR_CHARACTERS' letters of 'aColor'
 */
public char[][] getMatrixForm( String aColor ) 
{	
	char c = constructionCharacter;   // for brevity

	// Fill in the actual big letter. line by line	
	matrix[0][2] = c; 
	matrix[1][1] = c; matrix[1][3] = c;
	matrix[2][1] = c; matrix[2][3] = c;
	matrix[3][0] = c; matrix[3][4] = c;  
	matrix[4][0] = c; matrix[4][1]=c; matrix[4][2] = c; matrix[4][3] = c; matrix[4][4] = c;  
	matrix[5][0] = c; matrix[5][4] = c;
	matrix[6][0] = c; matrix[6][4] = c;  
	
	// Superimpose the color characters across the middle	
	matrix[3][0] = '-';   // required to precede the color characters
	for( int i = 1; i < BigChar.MATRIX_WIDTH; ++i )   // go all the way across   
		if( i <= aColor.length() )   // there is a color character to pick up	
			matrix[ 3 ][ i ] = aColor.charAt( i -1 );  // fill in the next color character
		else
			matrix[ 3 ][ i ] = ' ';  // pad on right with blanks
	
	return matrix;  
}

/************************************************** M E T H O D  getBigA
 * Accessor of the singleton
 */
public static BigA getBigA()
{	return bigA;	
}

}