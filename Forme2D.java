import java.awt.*;

public abstract class Forme2D extends Point2D implements Comparable<Forme2D> {
//Forme 2D est abstraite car elle contient des méthodes abstraites. On ne sait pas encore ce qu'elles vont réaliser
	
	private Color couleur;
	public static int nbForme;
	private Forme2D p;
	
	public Forme2D() throws WrongOriginException 
	{
		super();
		couleur = Color.BLUE;
		nbForme++;
		if((x<0) || (y<0))
		{
			throw new WrongOriginException();
		}
	}
	
	public Forme2D(Color couleur, double x, double y) throws WrongOriginException
	{
		super(x,y);
		this.couleur = couleur;
		nbForme++;
	
		if((x<0) || (y<0))
		{
			throw new WrongOriginException();
		}
	}
	
	public abstract double aireForme();
	public abstract void redimForme(double redim) throws WrongSizeException;
	public abstract void dessin();
	
	public void translation(double deltaX, double deltaY) throws WrongOriginException
	{
		setX(this.getX()+deltaX);			
		setY(this.getY()+deltaY);			
		if((x<0) || (y<0))
		{
			throw new WrongOriginException();
		}
		
	}	
		
	public Color getCouleur()
	{
		return couleur;
	}
	
	public void setCouleur(Color couleur)
	{
		this.couleur = couleur;
	}
	
	public String toString()
	{
		return("("+x+","+y+"):"+couleur);
	}
	
	public abstract double appartient(Point2D point);//Methode qui regarde si le point est dans la forme ou non
	
	@Override
	public int compareTo(Forme2D forme) {
		
		if (this.aireForme() < forme.aireForme())
		{
			return -1;
		}
		
		if (this.aireForme() == forme.aireForme())
		{
			return 0;
		}
		
		if (this.aireForme() > forme.aireForme())
		{
			return 1;
		}
		
		return 2;
	}

	public void finalize()
	{
		System.out.println("on efface l'objet");
		nbForme--;
		
	}
}