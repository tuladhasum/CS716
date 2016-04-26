/** ====================================================== C L A S S  BigCharFactory
 * Stores the flyweights and provides them on request.
 */

import java.util.*;

abstract class BigCharFactory 
{	
	private static Hashtable flyweights = new Hashtable();
	static   // access by correspnding character
	{	flyweights.put( "A", BigA.getBigA() );   // the singleton is the only instance
		flyweights.put( "B", BigB.getBigB() );
		/* etc. (there would be many more in reality) */
	}
	
/************************************************** C O N S T R U C T O R
 */
public BigCharFactory() 
{	super();
}

/************************************************** M E T H O D  getFlyweight
 * Returns: The 'BigChar' object in 'flyweights' corresponding to 'aChar'.
 */
public static BigChar getFlyweight( char aChar )
{
	// Convert aChar to a String
	char[] aCharAsArray = { aChar };
	String aCharAsString = new String( aCharAsArray );
	
	// Retrieve the flyweight based on this string
	return (BigChar)BigCharFactory.flyweights.get( aCharAsString );
}

/************************************************** M E T H O D  getFlyweights
 * Returns: 'flyweights'
 */
public static Hashtable getFlyweights()
{	return flyweights;
}

}