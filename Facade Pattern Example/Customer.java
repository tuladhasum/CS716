package framework;

/**
 */
public interface Customer 
{
	
/*****************************************************************************************************
 */
String getCustomerName();

/*****************************************************************************************************
 * Comment about the customer to personalize the bank's service.
 */
String getPersonalNotes();

/*****************************************************************************************************
 */
Account getAccount( int anAccountIndex ) throws AccountException;	

/*****************************************************************************************************
 */
int getNumAccounts();

}