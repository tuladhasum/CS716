/** 
  * Tellers have no reports
  */
class  Teller extends Employee  
{

/**************************************************************
 */
public Teller( String aName )
/**************************************************************/
{ 
	this();
	name = aName; 
}

/**************************************************************
 * Postcondition: the title and name of this employee appear on the console.
 */
public void stateName()   
/**************************************************************/ 
{	
	// do processing special to teller naming ...
	super.stateName();
}

/**************************************************************
 * Postcondition: title set to "Teller"
 */
public Teller()
/**************************************************************/
{	title = "Teller"; 
}

}