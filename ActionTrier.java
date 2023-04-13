import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class ActionTrier implements ActionListener {
	ZoneDessin feuille;
	JButton button;
	
	public ActionTrier(ZoneDessin dessinfeuille)
	{
		feuille = dessinfeuille;
		button = new JButton();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(feuille.listeForme.size()>= 1)
		{
			Collections.sort(feuille.listeForme, Collections.reverseOrder());
			feuille.repaint();
			System.out.println("Formes triées");
		}
		else
		{
			System.out.println("Il n'y a rien à trier");
		}
	}
}
