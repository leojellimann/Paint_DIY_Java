import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class main {

	public static void main(String[] args) throws WrongOriginException, WrongSizeException {
		// TODO Auto-generated method stub

		Point2D point = new Point2D(3,4);
		System.out.println(point.toString());
		Carre carre = new Carre(Color.RED, 7, 8, 3);
		System.out.println(carre.toString());
		Cercle cercle = new Cercle(Color.CYAN, 7, 8, 3);
		System.out.println(cercle.toString());
		
		ArrayList<Forme2D> myList = new ArrayList<Forme2D>();
		Scanner scan = new Scanner(System.in);
		
		//Initialisation des dimensions des formes
		for (int i=0;i<3;i++) {
			System.out.println("Entrer les valeurs pour la "+i+"eme forme");
			double x = scan.nextDouble();
			double y = scan.nextDouble();
			double r = scan.nextDouble();
			myList.add(new Cercle(Color.GREEN,x,y,r));
			myList.add(new Carre(Color.BLUE,x,y,r));
		}
		Collections.sort(myList);//Trie la liste de formes
		/*for (int i=0;i<5;i++) {
			double x = scan.nextInt();
			double y = scan.nextInt();
			double cote = scan.nextInt();
			myList.add(new Carre(Color.BLUE,x,y,cote));
		}*/
		System.out.println("Le nombre de forme est de: "+Forme2D.nbForme);
		System.out.println("Le nombre de cercle est de: "+Cercle.nbCercle);
		System.out.println("Le nombre de carre est de: "+Carre.nbCarre);
		
		for(Forme2D elem: myList)
	       {
	       	 System.out.println(elem);
	       }
		myList.remove(5);
		System.out.println("Le nombre de forme est de: "+Forme2D.nbForme);
		System.out.println("Le nombre de cercle est de: "+Cercle.nbCercle);
		System.out.println("Le nombre de carre est de: "+Carre.nbCarre);
		for(Forme2D elem: myList)
	       {
	       	 System.out.println(elem);
	       }
	}

}