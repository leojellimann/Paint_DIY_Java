import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class ActionSupprimer implements ActionListener{
	ZoneDessin feuille;
	JButton button;
	public ActionSupprimer(ZoneDessin dessinfeuille)
	{
		feuille = dessinfeuille;
		button = new JButton();
	}

	public void actionPerformed(ActionEvent e) {
		actionPerformedMethod();
				
    }
	
	void actionPerformedMethod() {
		if(feuille.listeForme.size()>= 1)
		{
		feuille.listeForme.remove(feuille.listeForme.size()-1);
		feuille.repaint();
		System.out.println("Forme supprimée");
		}
		else
		{
			System.out.println("Plus de forme dans la liste");
		}
	}
}

