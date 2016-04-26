/**
 * Certificate of Deposit
 */
public class CDAccount extends Account
{
	final int DEFAULT_DURATION = 4;   // term of this CD in years 
	static int numberOfCDAccountsMade = 0;   // to generate a unique account number
	
/********************************************************************************
 * Postcondition: 'this.accountNum' has been assigned a number unique for this execution
 */
public CDAccount() 
/********************************************************************************/ 
{	
	super();
	this.accountNum = CDAccount.numberOfCDAccountsMade;
	++CDAccount.numberOfCDAccountsMade;   // for next new CDAccount
}

/********************************************************************************
 */
public Object clone()
/********************************************************************************/
{	return new CDAccount();
}

/********************************************************************************
 */
public int getDuration()
/********************************************************************************/
{	return DEFAULT_DURATION;   
}

/********************************************************************************
 * Postcondition: The details of this CD have been output to the console
 */
public void describe()
/********************************************************************************/
{
	super.describe();	
	System.out.println
	 ( "CD account no. " + accountNum + " with duration " + getDuration() + "." );
}

}