/** ====================================================== C L A S S  TelNumsProxy
 *  Handles the real time-consuming work of retrieval across the Internet
 */

class TelNumsProxy extends TelNums 
{
	RemoteTelNums remoteTelNums = new RemoteTelNums();   // instantiate when needed only
 
/************************************************** C O N S T R U C T O R
 */
public TelNumsProxy()
{	super();
}

/************************************************** M E T H O D  getTelNums
 * Postcondition: 
 * (1) 'value' has the telephone records as specified by 'getTelNums()' of 'RemoteTelNums'
 * (2) If the values have already been retrieved, a message has been displyed to the console 
 *     stating that Internet access is not needed
 * (3) The telephone records have been displayed at the console as for the postconditions 
 *     in 'displayTelNums()' of 'TelNums'
 *
 * Design note: Retrieves the records from the Internet only if they have not already been retrieved.
 */
public void getTelNums()
{
	if( value == null )   // check that retrieval from the Internet is necessary
	{
		remoteTelNums = new RemoteTelNums();
		remoteTelNums.getTelNums();
	}
	else   // get them from 'TelNums.value'
	{		System.out.println( "======== No need to retrieve from the Internet ========" );
	}
	
	super.displayTelNums();
}

/************************************************** M E T H O D  showMiddleRecord
 * Postconditions: 
 * (1) -- as for 'showMiddleRecord()' in 'TelNums'
 * (2) 'TelNums.value' contains the telephone records at the Internet site specified in 'RemoteTelNums'
 * (3) If no Internet retrieval was required, a message to that effect has been displayed at the console.
 *
 * Design note: Retrieves the records from the Internet only if they have not already been retrieved.
 */
public void showMiddleRecord()
{
	if( value != null )
	{	
		System.out.println( "=== No need to retrieve from the Internet ===" );
		super.showMiddleRecord();
	}
	else   // numbers not retrieved yet during this execution
	{
		remoteTelNums.getTelNums();
		super.showMiddleRecord();
	}
}

}   // end class 'TelNumsProxy'
