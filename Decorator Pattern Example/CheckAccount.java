/**
 */
public class CheckAccount extends Account
{
	private int lastCheckNumPrinted = 12345;   // dummy for demonstration
	static int numberOfCheckAccountsMade = 0;   // to generate a unique checking account number
	
/********************************************************************************
 * Postconditions:
 * (1) 'accountNum' == 'CheckAccount.numberOfCheckAccountsMadC'
 * (2) 'CheckAccount.numberOfCheckAccountsMade' has been incremented
 */
public CheckAccount() 
/********************************************************************************/ 
{	
	super();
	accountNum = CheckAccount.numberOfCheckAccountsMade;
	++CheckAccount.numberOfCheckAccountsMade;   // for the next new CheckAccount
}

/********************************************************************************
 * Postcondition: The details of this account have been output to the console
 */
public void describe()
/********************************************************************************/
{	System.out.println
	 ( "Check account number " + accountNum + 
	 " with last check printed " + lastCheckNumPrinted + "." );
	super.describe();
}

/********************************************************************************
 */
public CheckAccount( int aLastCheckNumPrinted ) 
/********************************************************************************/ 
{	
	super();
	lastCheckNumPrinted = aLastCheckNumPrinted;
}

/********************************************************************************
 */
public Object clone()
/********************************************************************************/ 
{	return new CheckAccount();
}

}