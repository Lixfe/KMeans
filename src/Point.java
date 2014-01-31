import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Point extends JPanel {
	
	private int x;
	private int y;
	private Color couleur;
	
	public Point(Double coordx, Double coordy, Color couleurPoint){
		this.x=coordx.intValue();
		this.y=coordy.intValue();
		this.couleur = couleurPoint;
	}

	public void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;

    g2d.setColor(this.couleur);

 

      g2d.drawLine(x, y, x, y);
    }
  }