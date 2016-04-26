import java.io.*;

/**
  * Sets up the org chart and intiates execution.
  */ 
class Setup
{  

/**************************************************************
 * Postcondition: The 'title' and 'name' of the employees have been output to the console
 *     beginning with the president, then each of his or her sub-organizations recursively.
 *     The specification for this particualr organiation chart are in the notes,
 *
 * Note: This is performed by a client object whose  interface with the organization structure 
 * is an 'Employee' object.
 */
public static void main( String args[] )  
/**************************************************************/ 
{	
	// Make manager Able's organization
	Teller lonny = new Teller( "Lonny" );
	Clerk cal = new Clerk( "Cal" );
	Manager able = new Manager( "Able" );
	able.add( lonny);
	able.add( cal);
	
	// Make manager Becky's organization
	Teller juanita = new Teller( "Juanita" );
	Teller tina = new Teller( "Tina" );
	Teller thelma = new Teller( "Thelma" );
	Manager becky = new Manager( "Becky" );
	becky.add( juanita);
	becky.add( tina );
	becky.add( thelma);
	
	// Create the president's direct reports
	President pete = President.getPresident( "Pete" );
	pete.add( able );
	pete.add( becky );
	
	// Initiate client
	Client.employee = pete;
	Client.doClientTasks();
}
 
}