/** ====================================================== C L A S S  Setup
 * Sets up the client to run with the proxy
 */

import java.util.*;
import java.io.*;

class Setup 
{

/************************************************** C O N S T R U C T O R
 */
public Setup() 
{	super();
}

/************************************************** M E T H O D  getCommandFromUser
 * Postcondition: User has been prompted to enter 'all', 'middle', or 'quit'
 *
 * Returns: "a" or "m" or "q" if user enters 'all', 'middle', or 'quit' respectively, 
 *     otherwise returns "a"
 */
public static String getCommandFromUser() 
{	
	String command = "a";   // default
	Hashtable commandTable = new Hashtable();   // keys to user input

	// Key user input to the corresponding output
	commandTable.put( "all", "a" );
	commandTable.put( "middle", "m");
	commandTable.put( "quit", "q" );
	
	// Tell user what to pick from	
	System.out.println( "\nPlease pick a command from one of the following:" );
	for ( Enumeration enumeration = commandTable.keys(); enumeration.hasMoreElements() ;)
	{     System.out.println( enumeration.nextElement() );
	}
 
	// Get command type from user  
	try   // pick up user's input
	{	
		BufferedReader bufReader = 
		 new BufferedReader( new InputStreamReader( System.in ) );
		command = bufReader.readLine();
		System.out.println();   // blank line to separate input from processing results
	}
	catch( IOException e )
	{	System.out.println( e ); 
	}

	// Return if legitimate -- otherwise default
	String returnCommand = (String)commandTable.get( command );
	if( returnCommand == null )   // user mistyped
	{	return "a";
	}
	else
	{	return returnCommand;
	}
}

/************************************************** M E T H O D  main
 * Postconditions:
 * (1) The user has been repeatedly prompted as in 'getCommandFromUser()' until "q" is entered
 * (2) Each time the user responded with "a", all of the telephone records have been displayed at the console
 * (3) Each time the user responded with "m", the "middle" telephone records have been displayed at the 
 *     console as specified in 'displayMiddleRecords()'.  Education note: This demonstrates another need for all of the records. 
 *
 * Design Notes: Using Proxy design pattern.  The telephone numbers are retrieved from the Internet only when necessary 
 *    (taken care of in 'telephoneApp.display()' and 'telephoneApp.displayMiddleRecord()').
 */
public static void main( String[] args )
{
	TelephoneApp telephoneApp = new TelephoneApp();
	TelNumsProxy telNumsProxy = new TelNumsProxy();   // client calls to 'TelNums' will be called with this

	String userRequest = "Not assigned yet";

	while( !"q".equals( userRequest ) )   // no desire to quit
	{		
		userRequest = getCommandFromUser();   // get next command
		
		if( "a".equals( userRequest ) )   // show all
		{	telephoneApp.display( telNumsProxy );   
		}
		if( "m".equals( userRequest ) )   // show middle record(s)
		{	telephoneApp.displayMiddleRecord( telNumsProxy );
		}
		// Room here for more commands ....
	}
}   // end main()

}  
