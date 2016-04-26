import bankCustomers.*;
import java.io.*;
import framework.*;

/**
 * User of the 'bankCustomers' package via the facade.  Note that it does not (and cannot) 
 * reference to any other classes in the 'bankCustomers' package. 
 */
class Client 
{
	
/*****************************************************************************************************
 */
public Client() 
/*****************************************************************************************************/
{	super();
}

/*****************************************************************************************************
 * Postconditions:
 * (1) The application has asked repeatedly for a customer name from a complete list and 
 *     an account number.
 * (2) The application has acknowledged each response and provided the account balance if 
 *     the name and account number exist.   
 * (3) The user has entered "-quit" on being asked for a customer name, and the application 
 *     has terminated.
 */
public static void main( String[] args )
/*****************************************************************************************************/
{
	BankCustomers.introduceApplication();   // use of facade with static method
	
	BankCustomers bankCustomers = BankCustomers.getBankCustomers();   // the singleton

	String name = getCustomerDataFromUser();
	
	Customer customer = null;   // note: part of the framework, made completely accessible
	while( !name.equals( "-quit" ) )   // signal to stop this process
	{	
		try
		{	
			customer = bankCustomers.getBankCustomer( name );   // 'CustomerException' if no account
			
			// An account was found, so continue
			System.out.println( customer.getPersonalNotes() );
			int accountNumRequested = getAccountRequestFromUser();   // 'NumberFormatException' if not integer
			Account account = customer.getAccount( accountNumRequested );   // 'AccountException' if not such account
			System.out.println( "The balance in this account is " + account.getBalance() );
			askAboutDoingDeposit( customer, account );
			System.out.println( "The balance in this account is " + account.getBalance() );
		}
		catch( IOException e )
		{	System.out.println( "Sorry, could not read your input properly: Please retry." );
		}
		catch( CustomerException e )
		{	System.out.println( "Sorry, no such customer known: Please retry." );
		}
		catch( AccountException e )
		{	System.out.println( "Sorry, no such account known: Please retry." );
		}
		catch( NumberFormatException e )
		{	System.out.println( "Please enter an actual number: Please retry." );
		}
		
		System.out.println( "\nTo end this application, enter '-quit' instead of a customer name." );
		name = getCustomerDataFromUser();
	}
}

/*****************************************************************************************************
 * Postconditions: 
 * (1) The application has solicited a name from the user as a single string
 * (2) The application has acknowledged the input
 *
 * Return: the name as a single string
 */
public static String getCustomerDataFromUser() 
/*****************************************************************************************************/
{	
	BankCustomers.getBankCustomers().listCustomers();   // (Note: gets the singleton again)
	
	BufferedReader bufReader;
	String customerName = "Unknown";   // default

	System.out.println( "Please enter customer name:" );
	
	try   // read the name into customerName
	{
		bufReader = new BufferedReader( new InputStreamReader( System.in ) );
		customerName = bufReader.readLine();
		System.out.println( "You chose " + customerName );
	}
	catch( IOException e )
	{	System.out.println( e ); }

	return customerName;
}

/*****************************************************************************************************
 * Postconditions:  The application has ...
 * (1) ... requested an account number and mentioned 1 as a test account number
 * (2) ... obtained an acccount number -- an integer -- from the user
 * (3) ... acknowledged the input
 *
 * Return/Exception: 
 * (1) The account number integer if an integer was entered
 * (2) A 'NumberFormatException' thrown if other than an integer was entered
 * (3) An 'IOException' if there was a problem with the input. 
 */
public static int getAccountRequestFromUser() throws IOException, NumberFormatException
/*****************************************************************************************************/
{
	BufferedReader bufReader;
	int accountNum = 0;   // default

	System.out.println
	 ( "Please enter account number (for security, a list is not given ...1 is for testing:" );	
	bufReader = new BufferedReader( new InputStreamReader( System.in ) );
	String accNum = bufReader.readLine();
	Integer integer = new Integer( accNum );
	System.out.println( "You chose account number " + integer.intValue() );
	
	return integer.intValue();
}

/*****************************************************************************************************
 * Precondition: 'anAccount' is an account of 'aCustomer'
 *
 * Postconditions: 
 * (1) The user has been promted for a deposit amount
 * (2) The entered amount has been added to the balance in 'anAccount' of 'aCustomer' OR
 *     The user has not supplied and integer and a 'NumberFormatException' has been thrown OR
 *     The system could not read the input and a 'IOException' was thrown
 */
public static void askAboutDoingDeposit( Customer aCustomer, Account anAccount) 
 throws IOException, NumberFormatException
/*****************************************************************************************************/
{
	BufferedReader bufReader;

	System.out.println( "Enter a positive integer if you wish to make a deposit -- 0 otherwise:" );
	bufReader = new BufferedReader( new InputStreamReader( System.in ) );
	String amt = bufReader.readLine();
	Integer amount = new Integer( amt );
	System.out.println( "You chose amount " + amount.intValue() );

	// Make the deposit (use the singleton)
	( BankCustomers.getBankCustomers() ).doDeposit( amount.intValue(), aCustomer, anAccount ); 
}

}