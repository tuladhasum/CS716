/**
 */
class Customer implements BankingComponent 
{	
/********************************************************************************
 */
public Customer() 
/********************************************************************************/
{	super();
}

/********************************************************************************
 * Postcondition: The details of 'this' have been output to the console
 */
public void describe()
/********************************************************************************/
{	System.out.println( "Customer decription: Jonas Smith" );   // dummy for demo
}

/********************************************************************************
 * Note: Should not be called because 'Customer 'objects can't add a 'Component'
 */
public void add( BankingComponent aComponentToAdd ) 
 throws AttemptToAddBadBankingComponentException
/********************************************************************************/
{	throw new AttemptToAddBadBankingComponentException();
}

}