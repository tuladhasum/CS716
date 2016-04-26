/** 
  * Clerks: have no reports
  */ 
class Clerk extends Employee   
{
/**************************************************************
 */
public Clerk( String aName )
/**************************************************************/
{ 
	this();
	name = aName; 
}

/**************************************************************
 * Postcondition: as for 'Employee.stateName()'
 */
public void stateName()  
/**************************************************************/ 
{	
	// do processing special to clerk naming here .... (omitted)
	super.stateName();
}
	
/**************************************************************
 * Postcondition: 'title' string is "Clerk"
 */
public Clerk() 
/**************************************************************/
{ 	title = "Clerk"; 
}

}