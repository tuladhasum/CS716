/**===========================================================================
  * Manager class has reports
  */
class Manager extends Supervisor  
//*===========================================================================/ 
{	
/**************************************************************
 */
public Manager( String aName )
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
	// do processing special to manager naming ...
	super.stateName();
}

/**************************************************************
 * Postcondition: title set to "Manager"
 */
public Manager()
/**************************************************************/
{ 
	super();
	title = "Manager"; 
}

}