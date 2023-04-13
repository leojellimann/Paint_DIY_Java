public class WrongOriginException extends Exception {

	public WrongOriginException()
	{
		super();
	}
	
	public WrongOriginException(String name)
	{
		super("Cannot find name"+name);
	}
	
}