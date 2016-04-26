/**
 * Note: This client interfaces with a 'BankingComponent' object within the application
 * of Decorator. 
 */
class Client 
{
	public BankingComponent customerWithAccounts = null;   // -- that this client uses
	
/********************************************************************************
 */
public Client() 
/********************************************************************************/
{	super();
}

/********************************************************************************
 * Postcondition: The particulars of 'this' have been output to the console
 */
public void describeAll() 
/********************************************************************************/
{
	System.out.println( "Calling for a description of one Component: " );	
	this.customerWithAccounts.describe();
}

}