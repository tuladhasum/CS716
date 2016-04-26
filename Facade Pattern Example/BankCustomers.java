package bankCustomers;

import framework.*;
import java.util.*;

/**
 * Facade for bankCustomers package.  A Singleton.
 *
 * Hard-codes the customers of this bank for demonstration purposes.
 * Each customer has an account #1 for testing.  The remaining numbers must be known to the user
 * for security: They are not output to the console at any time.
 */
public class BankCustomers   // Note "public" 
{
	private static BankCustomers bankCustomers = new BankCustomers();   // singleton
	
	//------ Begin: Hard-coded customers for demonstration purposes	
	
	private static Hashtable bankCustomerTable = new Hashtable();
	static   // initialize customers
	{	 		
		// Customer Able with all of his accounts
		Vector ableAccounts = new Vector();
		ableAccounts.addElement( new BankAccount( 1 ) );   // for testing, as specified above
		ableAccounts.addElement( new BankAccount( 22 ) );
		ableAccounts.addElement( new BankAccount( 333 ) );
		bankCustomerTable.put( "Able",   // the name as key
		 new BankCustomer( "Able", "Gentleman and long-time customer", ableAccounts ) );
		 
		// Customer Betty with all of her accounts
		Vector bettyAccounts = new Vector();
		bettyAccounts.addElement( new BankAccount( 1 ) );   // for testing, as specified above
		bankCustomerTable.put( "Betty",   // the name as key
		 new BankCustomer( "Betty", "Lady; new customer", bettyAccounts ) );
		 
		// Customer Charles with all of his accounts
		Vector charlesAccounts = new Vector();
		charlesAccounts.addElement( new BankAccount( 1 ) );   // for testing, as specified above
		bankCustomerTable.put( "Charles",   // the name as key
		 new BankCustomer( "Charles", "Has complained about service", charlesAccounts ) );
	}

	//------ End: Hard-code  customers for demonstration purposes
	
/*****************************************************************************************************
 */
private BankCustomers()
/*****************************************************************************************************/
{	super();
}

/*****************************************************************************************************
 * Note: This returns a 'Customer' object: It can't reference any concrete subtype of 'Customer'
 * Returns/Exception: The 'Customer' object in 'customer' with name 'aName' if such a customer exists
 *                                otherwise throws a 'CustomerException'
 */
public static Customer getBankCustomer( String aName ) throws CustomerException
/*****************************************************************************************************/
{	
	Customer returnCustomer = (Customer)bankCustomerTable.get( aName );

	if( returnCustomer != null )   // could not find it
		return returnCustomer;
	else
		throw new CustomerException( "No customer with this name" );
}

/*****************************************************************************************************
 * To access the singleton
 */
public static BankCustomers getBankCustomers()
/*****************************************************************************************************/
{	return bankCustomers;
}

/*****************************************************************************************************
 * Note: This returns an 'Account 'object: It can't reference and concrete subtype of 'Account'
 * Precondition: 'aCustomer' not null
 * Returns: The 'Account' object possessed by 'aCustomer' if such an account exists
 * otherwise throws an 'AccountException'
 */
public Account getBankAccount( Customer aCustomer, int anAccountNum ) throws AccountException
/*****************************************************************************************************/
{
	Account currentAccount;
	String aCustomerName = aCustomer.getCustomerName(); 
	String customerName = " ";

	for ( Enumeration enumeration = bankCustomerTable.keys(); enumeration.hasMoreElements(); )
		// If given customer listed
		customerName = 
		  ( (Customer)bankCustomerTable.get( enumeration.nextElement() ) ).getCustomerName();
		if( aCustomerName.equals( customerName ) ) 
			// Check if this customer has an account numbered 'anAccountNum'
			for( int j = 0; j < aCustomer.getNumAccounts(); ++j )
			{
				currentAccount = aCustomer.getAccount( j );
				if( currentAccount.getAccountNum() == anAccountNum )
					return currentAccount;
			}

	// Could not find it
	throw new AccountException( "No customer with this name" );
}

/*****************************************************************************************************
 * Postcondition: Names of customers in 'bankCustomerTable' have been printed to the console
 */
public void listCustomers()
/*****************************************************************************************************/
{
	System.out.println( "These are the customers to choose from." );
	for ( Enumeration enumeration = bankCustomerTable.keys(); enumeration.hasMoreElements() ;)
	{     System.out.println( enumeration.nextElement() );
	} 	
}

/*****************************************************************************************************
 * Postcondition: As for 'deposit( anAmount )' on 'anAccount'
 */
public void doDeposit( int anAmount, Customer aCustomer, Account anAccount ) 
{
	anAccount.deposit( anAmount );
	System.out.println( "Deposited " + anAmount + " into the account of " + aCustomer.getCustomerName() );
}

/*****************************************************************************************************
 * Call to IntroMessage.display.  Demonstrates usage of class internal to the package.
 */
public static void introduceApplication()
/*****************************************************************************************************/
{	IntroMessage.displayIntroductionToConsole();	
}

}