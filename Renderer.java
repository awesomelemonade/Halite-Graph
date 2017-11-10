import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Renderer extends JPanel {
	//boundaries
	private Point topLeft;
	private Point bottomRight;
	//values
	private Point[] scaled;
	//rendering
	private double width = 5;
	private double height = 5;
	public Renderer(Point[] points) {
		double minX = Double.MAX_VALUE, maxX = -Double.MAX_VALUE, minY = Double.MAX_VALUE, maxY = -Double.MIN_VALUE;
		for(Point point: points) {
			if(point.getX()<minX) {
				minX = point.getX();
			}
			if(point.getX()>maxX) {
				maxX = point.getX();
			}
			if(point.getY()<minY) {
				minY = point.getY();
			}
			if(point.getY()>maxY) {
				maxY = point.getY();
			}
		}
		topLeft = new Point(minX, minY);
		bottomRight = new Point(maxX, maxY);
		scaled = new Point[points.length];
		for(int i=0;i<scaled.length;++i) {
			scaled[i] = new Point((points[i].getX()-topLeft.getX())/(bottomRight.getX()-topLeft.getX()),
					(points[i].getY()-topLeft.getY())/(bottomRight.getY()-topLeft.getY()));
		}
		System.out.println(topLeft+" - "+bottomRight);
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.RED);
		for(Point point: scaled) {
			g.fillOval((int)(point.getX()*this.getWidth()-width/2),
					this.getHeight()-(int)(point.getY()*this.getHeight()-height/2), (int)(width), (int)(height));
		}
	}
}
