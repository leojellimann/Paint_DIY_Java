import java.awt.Color;

public class Carre extends Forme2D{

	protected double cote;
	public static int nbCarre;
	
	public Carre(Color couleur, double x, double y, double cote) throws WrongOriginException, WrongSizeException {
		super(couleur, x, y);
		// TODO Auto-generated constructor stub
		nbCarre++;
		if (cote <= 0) {
			throw new WrongSizeException();
		}
		this.cote = cote;
	}

	@Override
	public double aireForme() {
		// TODO Auto-generated method stub
		return cote*cote;
	}

	@Override
	public void redimForme(double redim) throws WrongSizeException{
		// TODO Auto-generated method stub
		if (redim<cote) {
			throw new WrongSizeException();
		}
		this.cote= redim;
	}

	@Override
	public void dessin() {
		// TODO Auto-generated method stub
		toString();
		
	}

	@Override
	public double appartient(Point2D point) {
		double xA = point.getX();
		double yA = point.getY();
		
		if ((this.x<xA && xA<this.x+cote) && (this.y<yA && yA<this.y+cote))
		{
			return 1;
		}
		else
		{return 0;}
	}
	
	public String toString()
	{
		return("Carre:("+getX()+","+getY()+"):"+cote+":"+getCouleur()+":"+aireForme());
	}
	
	public double getCote()
	{
		return cote;
	}
	
	public void finalize()
	{
		System.out.println("on efface l'objet carre");
		nbCarre--;
	}
}
