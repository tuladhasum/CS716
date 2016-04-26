/**
 * Base class for various types of accounts
 */
public abstract class Account implements BankingComponent
{
	int accountNum = 0;
	BankingComponent nextComponent = null;  // link to next component
	
/********************************************************************************
 */
public Account()
/********************************************************************************/
{	super();
}

/********************************************************************************
 */
public void describe()
/********************************************************************************/
{	
	// First call the local describe (to be filled in for subclasses), then ...	
	nextComponent.describe();
}

/********************************************************************************
 * Make a link from this to 'aComponentToAdd'
 * Precondition: 'aComponentToAdd.nextComponent == null' 
 *   (i.e., 'aComponentToAdd' not linked to a 'Component' object
 */
public void add( BankingComponent aComponentToAdd ) 
 throws AttemptToAddBadBankingComponentException   // we don't use this here
/********************************************************************************/
{
	if( this.nextComponent == null )   // 'this' links to nothing
		this.nextComponent = aComponentToAdd;   // point initially to 'aComponentToAdd'
	else   // This is linked to a component.  Insert 'aComponentToAdd'
	{
		BankingComponent originalNextComponent = 
		 this.nextComponent;   // save component 'this' currently point to
		this.nextComponent = aComponentToAdd;   // point this to 'aComponentToAdd'
		aComponentToAdd.add( originalNextComponent );   // link 'aComponentToAdd' to the previous first component
	}
}

/********************************************************************************
 * For use in cloning objects in Hashtable
 */
public abstract Object clone();
/********************************************************************************/

}