//class for exceptions
class UnsortedException extends Exception 
{
	private static final long serialVersionUID = 1L;
  
	//throw super message from exception 
	public UnsortedException(String msg) 
	{
		super(msg);
	}
}//end of exception