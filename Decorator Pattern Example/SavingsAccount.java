/**
 */
public class SavingsAccount extends Account
{
	final int DEMONSTRATION_INTEREST_RATE = 4;
	static int numberOfSavingsAccountsMade = 0;
	
/********************************************************************************
 * Postconditions:
 *  (1) 'accountNum' == 'SavingsAccount.numberOfSavingsAccountsMade'
 *  (2)  'SavingsAccount.numberOfSavingsAccountsMade' has been incremented
 */
public SavingsAccount() 
/********************************************************************************/ 
{	
	super();
	accountNum = SavingsAccount.numberOfSavingsAccountsMade;
	++SavingsAccount.numberOfSavingsAccountsMade;   // for the next new account
}

/********************************************************************************
 */
public int getInterestRate()
/********************************************************************************/
{	return DEMONSTRATION_INTEREST_RATE;   
}

/********************************************************************************
 * Postcondition: the details of 'this' have been output to the console 
 */
public void describe()
/********************************************************************************/
{	System.out.println
	 ( "Savings account number " + accountNum + 
	 " with interest rate " + getInterestRate() + "." );
	super.describe();
}

/********************************************************************************
 */
public Object clone()
/********************************************************************************/
{	return new SavingsAccount();
}

}