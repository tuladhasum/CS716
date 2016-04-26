/** ====================================================== C L A S S  TelephoneApp
 * Client of 'TelNums'
 * Design Note: This class is deliberately unaware of whether the needed data is
 *    remote or not.
 */

class TelephoneApp 
{
	
/************************************************** C O N S T R U C T O R
 */
public TelephoneApp()   
{	super();
}

/************************************************** M E T H O D  display
 * Design Note: Written in terms of 'TelNums' in general.  Code doesn't deal with proxies, Internet delays etc.
 * 
 * Precondition: 'aTelNums' != null
 *
 * Postconditions: as for 'getTelNums()' in 'TelNums'
 */
public static void display( TelNums aTelNums )
{	aTelNums.getTelNums();
}

/************************************************** M E T H O D  displayMiddleRecord
 * Design Note: Written in terms of 'TelNums' in general.  Code doesn't deal with proxies, Internet delays etc.
 * 
 * Precondition: 'aTelNums' != null
 *
 * Postconditions: as for 'showMiddleRecord()' in 'TelNums'
 */
public static void displayMiddleRecord( TelNums aTelNums )
{	aTelNums.showMiddleRecord();
}

}   
