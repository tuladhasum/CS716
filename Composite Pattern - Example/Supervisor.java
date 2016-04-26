import java.util.*;

/** 
  * Base class for employees with reports.
  */ 
abstract class Supervisor extends Employee  
{
	protected Vector directReports = new Vector();   // employees reporting to this 'Supervisor'

/************************************************************** 
 * Postcondition: the title and name of all of the reports of this employee (if any) 
 * have been resursively output to new lines on the console.
 */
public void stateName()
/**************************************************************/
{
	super.stateName();    // print name of this employee first
	if( directReports.size() > 0 )   // be sure there are elements
		for( int i = 0; i < directReports.size(); ++i )
			 ( (Employee)directReports.elementAt( i ) ).stateName();
}

/**************************************************************
 * Postcondition: 'anEmployee' has been added to the employees reporting 
 *        to this employee ('this.directReports'). 
 */
public void add( Employee anEmployee )
/**************************************************************/
{	this.directReports.addElement( anEmployee );
}

}