import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.*;

public class Fenetre extends JFrame{

	ZoneDessin dessin;
	
	public Fenetre(){
		super("TP4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Paint DIY");
		setLayout(new BorderLayout());
		
		JPanel monpanel = new JPanel();
		
		monpanel.setLayout(new BorderLayout());
		setContentPane(monpanel);
		//monpanel.setBackground(Color.LIGHT_GRAY);
        //monpanel.add(new JLabel("TP4"), BorderLayout.NORTH);
        dessin = new ZoneDessin();
        add(dessin, BorderLayout.CENTER);
        monpanel.add(creeBoutons(), BorderLayout.SOUTH);
        setSize(600,600);
		setVisible(true);
	}
	
	
	public static void main(String[] args) throws WrongOriginException, WrongSizeException {
		// TODO Auto-generated method stub
		Fenetre mafenetre = new Fenetre();
	}

	private JPanel creeBoutons() {
		
		//Créé un panel avec des éléments alignés à gauche
		final JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20,0));
		panel.setBackground(Color.BLUE);
		
		//Création des boutons du panel
		final JButton ajouter = new JButton("+");
		final JButton supprimer = new JButton("-");
		final JButton trier = new JButton("Sort");
		final ButtonGroup group = new ButtonGroup();
		final JRadioButton carre = new JRadioButton("Square");
		carre.setSelected(true);
		final JRadioButton cercle = new JRadioButton("Circle");
		//Pour éviter de pouvoir appuyer sur les deux boutons en même temps
		group.add(carre);
		group.add(cercle);
		
		//Création d'une action pour ajouter dans la liste
		ActionAjouter actionAjout = new ActionAjouter(dessin, carre, cercle);//dessin, carre, cercle
		ActionSupprimer actionSupprimer = new ActionSupprimer(dessin);
		ActionTrier actionTrier = new ActionTrier(dessin);
		
		//affectation de cette action au bouton
		ajouter.addActionListener(actionAjout);
		supprimer.addActionListener(actionSupprimer);
		trier.addActionListener(actionTrier);
		
		carre.addKeyListener(dessin);
		cercle.addKeyListener(dessin);
		trier.addKeyListener(dessin);
		supprimer.addKeyListener(dessin);
		
		carre.addMouseListener(dessin);
		
		//ajout des boutons dans la fenetre 
		panel.add(ajouter);
		panel.add(supprimer);
		panel.add(trier);
		panel.add(carre);
		panel.add(cercle);

		return panel;
	}
	
}