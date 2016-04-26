/** ====================================================== C L A S S  RemoteTelNums
 * Access to the URL containing the telephone information
 */

import java.net.*;
import java.io.*;
import java.util.*;

class RemoteTelNums extends TelNums 
{
	public static final String URL_CONTAINING_THE_TEL_RECORDS = 
	 "http://metcs.bu.edu/~ebraude/SoftwareDesignBook/telephones.txt";   // location of the data

/************************************************** C O N S T R U C T O R
 */
public RemoteTelNums()
{	super();
}

/************************************************** M E T H O D  getTelNums

 * Postcondition: The 'String' objects in 'TelNums.value' consist of the records 
 *  at URL 'URL_CONTAINING_THE_TEL_RECORDS' if a connection to
 * 'URL_CONTAINING_THE_TEL_RECORDS' was established.
 *
 * Design note: Data retrieved from the Internet
 */
public void getTelNums()  
{
 	System.out.println
 	 ( "================== Retrieving from the Internet ==================" );   
	
	BufferedReader urlReader = null;
      
   	try         
   	{   
	    TelNums.value = new Vector();   // from now on not 'null'
	   	
	   	// Prepare to read from the URL
	   	URL url = new URL( URL_CONTAINING_THE_TEL_RECORDS );
      	URLConnection urlConnection = url.openConnection();  
	  	urlReader = new BufferedReader
	   	 ( new InputStreamReader( urlConnection.getInputStream() ) );
     
    	// Read the telephone records
    	String lineFromURL = "";    
		while( lineFromURL != null )   // read until no more lines
   		{
   			lineFromURL = urlReader.readLine();
   			if( lineFromURL != null )   // don't keep the null read
   			{	
	   			TelNums.value.addElement( lineFromURL );   // keep the record
   				// ... Here we would normally save this data to disk ....	
   			}
   		}
   		urlReader.close();
    }
   	catch( IOException e ) 
    {	System.out.println( e ); 
	}
}   // end getTelNums()

}   
