/** ====================================================== C L A S S  TelephoneApp
 * Base class for the telephone information
 */
 
import java.util.*;

abstract class TelNums 
{
	public static Vector value = null;   // records kept here; 'null' indicates not retrieved yet

/************************************************** C O N S T R U C T O R
 */
public TelNums()
{	super();
}

/************************************************** M E T H O D  displayTelNums
 * Precondition: 'value' != null
 *
 * Postcondition: the records in 'value' have been displayed to the console
 */
public void displayTelNums()
{
	for( int i = 0; i < TelNums.value.size(); ++i )
	{	System.out.println( (String)TelNums.value.elementAt( i ) );
	}
}

/************************************************** M E T H O D  getTelNums
 */
public abstract void getTelNums();

/************************************************** M E T H O D  showMiddleRecord
 * Precondition: 'value' != null
 *
 * Postcondition: The middle element of 'TelNums.value' has beed displayed on the console if there is
 *  an odd number of elements in 'value': Otherwise the two middle element have been displayed.
 *
 * Education Note: A demonstration capability to show an example of a reason why we need all of
 *     the records.
 */
public void showMiddleRecord()
{
	if( value == null )
	{		System.out.println( "showMiddleRecord() called with null 'value'" );
	}	
	else
	{
		int halfValue = (int)( value.size() / 2 );   // rounds up if 'value.size()' odd
		if( 2*halfValue != value.size() )   // length of 'value' is odd
		{	System.out.println( value.elementAt( halfValue ) );
		}
		else   // length is even
		{	// Show the pair on either side of the middle
			System.out.println( value.elementAt( halfValue - 1) );
			System.out.println( value.elementAt( halfValue ) );
		}
	}
}

} 
