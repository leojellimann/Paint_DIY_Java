public class Point2D {
	
	protected double x;
	protected double y;
	
	public Point2D(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Point2D()
	{
		x = 0;
		y = 0;
	}
	
	
	
	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}
	
	public double setX(double x)
	{
		return this.x = x;
	}

	public double setY(double y)
	{
		return this.y = y;
	}
	
	@Override
	public String toString()
	{
		return ("("+x+","+y+")");
	}
	
}