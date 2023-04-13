import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class ZoneDessin extends Component implements KeyListener, MouseListener{

        ArrayList <Forme2D> listeForme;
        ArrayList <Forme2D> rechercheForme;
        private boolean isKeyPressed = false;
        private Forme2D selectedForme;
        private Color couleurForme;
        private Color couleurSet;
        
        
        
        ActionAjouter actionAjout;
        ActionSupprimer actionSupprimer;
        int cote= (int) (Math.random()*( 150 - 50 )) + 50;
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        Color randomColor = new Color(r, g, b);
    
    public ZoneDessin() {
    	setVisible(true);
    	setFocusable(true);
    	addKeyListener(this);
    	addMouseListener(this);
    	
    	listeForme = new ArrayList <Forme2D>();
    	
    	
    }
    	
        public void paint(Graphics g){
        	g.setColor(Color.WHITE);//Affiche du blanc en fond
        	g.fillRect(0, 0, this.getWidth(), this.getHeight());//Créer une fenetre de taille de l'écran
        	 for(Forme2D elem: listeForme) {
        		 g.setColor(elem.getCouleur());
        		 if(elem instanceof Cercle) {
	                 int x= (int)elem.getX();
	                 int y= (int)elem.getY();
	                 g.fillOval(x, y, (int)((Cercle) elem).getRayon(), (int)((Cercle) elem).getRayon());
	        	 }
        	 
        	 	else if(elem instanceof Carre) {
	                 int x= (int)elem.getX();
	                 int y= (int)elem.getY();
	                 g.fillRect(x, y, (int)((Carre) elem).getCote(), (int)((Carre) elem).getCote());
	        	 
        	 	}
        	 }
        }

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if(isKeyPressed)
			{return;}
			
			int cote= (int) (Math.random()*( 150 - 50 )) + 50;
	        Random rand = new Random();
	        float r = rand.nextFloat();
	        float g = rand.nextFloat();
	        float b = rand.nextFloat();
	        Color randomColor = new Color(r, g, b);
			
			if(e.getKeyChar() =='c')
			{
				
				System.out.println("Cercle dessiné avec le clavier");
                try {
					listeForme.add(new Cercle(randomColor,(int)(getHeight()/4),(int)(getWidth()/4),cote));
				} catch (WrongOriginException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (WrongSizeException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                repaint();
			}
			else if(e.getKeyChar() =='r')
			{
				System.out.println("Carré dessiné avec le clavier");
		                try {
							listeForme.add(new Carre(randomColor,(int)(getHeight()/4),(int)(getWidth()/4),cote));
						} catch (WrongOriginException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (WrongSizeException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		                repaint();
		                
		        
			}
			else if(e.getKeyChar() =='d')
			{
				System.out.println("On supprime avec le clavier");
				if(listeForme.size()>= 1)
				{
				listeForme.remove(listeForme.size()-1);
				repaint();
				System.out.println("Forme supprimée");
				}
				else
				{
					System.out.println("Plus de forme dans la liste");
				}
				
			}
			isKeyPressed = true;
			}
		

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			isKeyPressed = false;
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int buttonDown = e.getButton();
			//Verifier e.button
			double x = e.getX();
			double y = e.getY();
			System.out.println("x="+x+" y="+y);
			
			if(buttonDown == e.BUTTON1 && couleurSet!= Color.RED)
			{

					System.out.println("Clic Gauche");
					selectedForme = listeForme.get(1);
					couleurForme = selectedForme.getCouleur();
					selectedForme.setCouleur(Color.RED);
					couleurSet = selectedForme.getCouleur();
					repaint();
			}
			else if(buttonDown == e.BUTTON3 && couleurSet==Color.RED)
			{
				System.out.println("Clic Droit");
				selectedForme.setCouleur(couleurForme);
				repaint();
				couleurSet = selectedForme.getCouleur();
			}
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
       
}