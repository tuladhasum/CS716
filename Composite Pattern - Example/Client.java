import java.io.*;

/** 
  * Class that uses the organization chart.  Aggregates an 'Employee' object , which is its interface
  * to structores of emplyees.
  */
class Client   
{	
	// This class relates to a specific 'Employee'  
	public static Employee employee;

	/**************************************************************
	 * Note: This is where the client does its work with the Employee object
	 */
	public static void doClientTasks()    
	/**************************************************************/ 
	{	
		// Do work with this.employee ... (omitted)
		employee.stateName();
	}
}
