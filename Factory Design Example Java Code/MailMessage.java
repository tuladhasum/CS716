/**
 * e-mail for customers
 */
class MailMessage 
{
	// Content of the message
	String text = "No text chosen yet";
	
/*****************************************************************************************************
 */
public MailMessage() 
/*****************************************************************************************************/
{	super();
}

/*****************************************************************************************************
 */
public MailMessage( String aText ) 
/*****************************************************************************************************/
{	
	this();
	text = aText;
}

/*****************************************************************************************************
 */
public String getText()
/*****************************************************************************************************/ 
{	return text;
}

/*****************************************************************************************************
 */
public void setText( String aString ) 
/*****************************************************************************************************/
{	text = aString;
}

}