/** 
  * Presidents have reports.  This is a singleton class.
  */
class President extends Supervisor 
{
	private static President president = new President();   // singleton

/**************************************************************
 */
private President( String aName )
/**************************************************************/
{ 
	this();
	name = aName; 
}

/**************************************************************
 * Postcondition: 'title' and 'name' of this employee have been output to the console.
 */
public void stateName()  
/**************************************************************/ 
{	
	// Do processing special to presidential naming ...
	super.stateName();
}
	
/**************************************************************
 * Postcondition: 'title' is "President"
 */
private President( )
/**************************************************************/
{ 
	super();
	title = "President";
}

/**************************************************************
 * Postcondition: 'name' is 'aName'
 * Returns: 'president' singleton 
 */
public static President getPresident( String aName )
/**************************************************************/
{
	president.name = aName;	
	return President.president;
}

}