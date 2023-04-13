import  javax.swing.*;
import  java.awt.*;
import  java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class ActionAjouter implements ActionListener{
	ZoneDessin feuille;//Liste de la listeForme
	JButton button;
	JRadioButton carre;
	JRadioButton cercle;
	public ActionAjouter(ZoneDessin dessinfeuille, JRadioButton car, JRadioButton cer)
	{
		feuille = dessinfeuille;
		button = new JButton();
		carre=car;
		cercle=cer;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int cote= (int) (Math.random()*( 150 - 50 )) + 50;
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        Color randomColor = new Color(r, g, b);
	        try {
	        	if(carre.isSelected()==true)
	            {
	                feuille.listeForme.add(new Carre(randomColor,(int)(feuille.getHeight()/4),(int)(feuille.getWidth()/4),cote));
	                feuille.repaint();
	                System.out.println("Carré dessiné");
	            }  
	        	else if(cercle.isSelected()==true)
	            {
	            	feuille.listeForme.add(new Cercle(randomColor,(int)(feuille.getHeight()/4),(int)(feuille.getWidth()/4),cote));
	                feuille.repaint();
	                System.out.println("Cercle dessiné");
	            }
	        	else if(cercle.isSelected()==true && carre.isSelected()==true)
	            {
	            	feuille.listeForme.add(new Carre(randomColor,(int)(feuille.getHeight()/4),(int)(feuille.getWidth()/4),cote));
	                feuille.repaint();
	                System.out.println("Carré dessiné");
	            }
	        }
        
        
        catch (WrongSizeException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        catch (WrongOriginException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}


