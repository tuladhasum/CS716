/**
 * Base for the substance and its decorations
 */
interface BankingComponent
/********************************************************************************/
{

/********************************************************************************
 * Make a link from this to 'aBankingComponentToAdd'
 */
void add( BankingComponent aBankingComponentToAdd ) 
 throws AttemptToAddBadBankingComponentException;   

/********************************************************************************
 * Postcondition: A description of this has been shown on the console.
 */
void describe();

}