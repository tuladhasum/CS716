/**===========================================================================
  * Base class for org chart
  */ 
abstract class Employee  
//*===========================================================================/
{
	String name = "not assigned yet";
	String title = "not assigned yet";
	
/**************************************************************
 * Postcondition: 'title' and 'name' of this employee have been output to the console.
 */
public void stateName()
/**************************************************************/
{	System.out.println( title + " " + name );
}

}