import java.awt.Color;

public class Cercle extends Forme2D{

	protected double rayon;
	public static int nbCercle;
	
	public Cercle(Color couleur, double x, double y, double rayon) throws WrongOriginException, WrongSizeException {
		super(couleur, x, y);
		nbCercle++;
		if (rayon <= 0 ) {
			throw new WrongSizeException();
		}
		this.rayon = rayon;
		// TODO Auto-generated constructor stub
	}

	@Override
	public double aireForme() {
		// TODO Auto-generated method stub
		return Math.PI*Math.pow(2, rayon);
	}

	@Override
	public void redimForme(double redim) throws WrongSizeException {
		// TODO Auto-generated method stub
		if (rayon>redim) {
			throw new WrongSizeException();
		}
		this.rayon= redim;
	}

	@Override
	public void dessin() {
		// TODO Auto-generated method stub
		toString();
	}

	@Override
	public double appartient(Point2D point) {
		// TODO Auto-generated method stub
		double xA = point.getX();
		double yA = point.getY();
		
		if (Math.pow(xA-this.x,2) + Math.pow(yA-this.y,2) < Math.pow(rayon, 2))
		{
			return 1;
		}
		else
		{return 0;}
	}
	
	public double getRayon() {
		return rayon;
	}

	public String toString()
	{
		return("Cercle:("+getX()+","+getY()+"):"+rayon+":"+getCouleur()+":"+aireForme());
	}
	
	
	public void finalize()
	{
		System.out.println("on efface l'objet cercle");
		nbCercle--;
	}

}