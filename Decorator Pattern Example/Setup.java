import java.io.*;
import java.util.*;

/**
 * Controls this application.
 */
class Setup 
{	
	// The account types available
	static Hashtable tableOfAccountTypes = new Hashtable();
	static
	{
	tableOfAccountTypes.put( "Savings account", new SavingsAccount() );
	tableOfAccountTypes.put( "Checking account", new CheckAccount() );
	tableOfAccountTypes.put( "CD account", new CDAccount() );
	}
	
/********************************************************************************
 */
public Setup() 
/********************************************************************************/
{	super();
}

/********************************************************************************
 * Postconditions:
 * (1) The application has repeatedly requested desired account types for a standard customer
 * (2) The user has responded until typing "quit"
 * (3) The application has output to the console information on the customer and the accounts selected
 */
public static void main( String[] args )
/********************************************************************************/
{
	// Set up the Decorator application
	
	Customer customer = new Customer();   // this will be the customer the client will deal with
	Account account = null;
	Account tempAccount = null;

	try
	{
		// Get and link in the first account in any case
		System.out.println( "Select an account: Incorrect entries assume checking account." );
		account = getAccountToAdd();
		account.add( customer );   // link from account to customer	
	
		// Get as many additional accounts as desired until "quit" typed

		BufferedReader bufReader;
		bufReader = new BufferedReader( new InputStreamReader( System.in ) );
		System.out.println
		 ( "Type any character if you want to add another account: Otherwise 'quit'." );	
		String response = bufReader.readLine();
		
		while( !response.equals( "quit" ) )
		{
			tempAccount = account;   // keep to link back below
			account = getAccountToAdd();
			account.add( tempAccount );   // account linked to what was there before
			
			System.out.println
			 ( "Type any character if you want to add another account: Otherwise 'quit'." );	
			response = bufReader.readLine();			
		}
	}
	catch( AttemptToAddBadBankingComponentException e )
	{	System.out.println( "Attempt to decorate with bad component" );
	}	
	catch( IOException e )
	{	System.out.println( e ); }

			
	// Create a client and have it point to the last account linked in		
	Client clientOfDecorator = new Client();
	clientOfDecorator.customerWithAccounts = account;	
	
	clientOfDecorator.describeAll();   // now the client uses the application of Decorator 	
}

/********************************************************************************
 * Postcondition: The user has been presented with a list of account types
 *  in 'tableOfAccountTypes'.
 * 
 * Return: If the user has selected one, this returns and object of the class
 *         otherwise it returns a 'CheckAccount' object.
 */
public static Account getAccountToAdd()
/********************************************************************************/
{
	// List available account types for user
	System.out.println( "\nPlease select an account type from the following." );
	for( Enumeration enumeration = tableOfAccountTypes.keys(); enumeration.hasMoreElements() ;)
		System.out.println( enumeration.nextElement() );

	// Get an account type
	
	BufferedReader bufReader;
	String accountType = "Account type not assigned yet";   
	System.out.println( "Please enter account type:" );
	
	try
	{
		bufReader = new BufferedReader( new InputStreamReader( System.in ) );
		accountType = bufReader.readLine();
		System.out.println( "You chose " + accountType + "\n" );
	}
	catch( IOException e )
	{	System.out.println( e ); }

	// Return an Account object
	Account account = (Account)tableOfAccountTypes.get( accountType );
	if( account != null )   // user chose legitimate type
		return (Account)account.clone();
	else   // user mistyped: Default to checking
		return new CheckAccount();
}

}