package bankCustomers;

import framework.*;
import java.util.*;

/**
 */
class BankCustomer implements Customer   // Note: not public
{
	private String name = "Not assigend yet";
	private String notes = "Nothing special known yet.";   // personalization string
	private Vector accounts = new Vector();   // the 'Account's for this object
	
/***************************************************************************************************** 
 */
public BankCustomer()
/*****************************************************************************************************/
{	super();	
}

/*****************************************************************************************************
 */
public BankCustomer( String aName, String aNote, Vector someAccounts )
/*****************************************************************************************************/
{	
	this();
	name = aName;
	notes = aNote;
	accounts = someAccounts;
}

/*****************************************************************************************************
 */
public String getCustomerName()
/*****************************************************************************************************/
{	return name;
}

/*****************************************************************************************************
 */
public String getPersonalNotes()
/*****************************************************************************************************/
{	return notes;
}

/*****************************************************************************************************
 * Returns/Exception: The 'Account' object is returned with number 'anAccountNum' if it is in 'accounts', 
 * otherwise throws 'AccountException'.
 */
public Account getAccount( int anAccountNum ) throws AccountException
/*****************************************************************************************************/
{	
	BankAccount account = null;

	// Look for an account i 'accoutns' with number 'anAccountNum'
	for( int accIndex = 0; accIndex < accounts.size(); ++accIndex )
	{
		account = (BankAccount)accounts.get( accIndex );
		if( account.getAccountNum() == anAccountNum )
			return account;
	}
	throw new AccountException( "Account not found" );   // -- if the loop terminates without return
}

/*****************************************************************************************************
 */
public int getNumAccounts()
/*****************************************************************************************************/
{	return accounts.size();
}

}