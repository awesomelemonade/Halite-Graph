import java.util.function.UnaryOperator;

public class CustomFunction implements UnaryOperator<Double> {
	private double magnitude = 7;
	private Point start = new Point(0, 0);
	private Point end = new Point(7, 0);
	private Point endVelocity = new Point(-14, 0);
	@Override
	public Double apply(Double theta) {
		double vx = magnitude*Math.cos(theta);
		double vy = magnitude*Math.sin(theta);
		Point velocity = new Point(vx, vy);
		double t = getMinTime(start, end, velocity, endVelocity);
		//t = Math.max(0, Math.min(1, t));
		return Math.sqrt(getDistanceSquared(start, end, velocity, endVelocity, t));
	}
	public static double getMinTime(Point a, Point b, Point velocityA, Point velocityB) {
		double deltaVelocityX = velocityA.getX()-velocityB.getX();
		double deltaVelocityY = velocityA.getY()-velocityB.getY();
		return -(deltaVelocityX*(a.getX()-b.getX())+deltaVelocityY*(a.getY()-b.getY()))/
				(deltaVelocityX*deltaVelocityX+deltaVelocityY*deltaVelocityY);
	}
	public static double getDistanceSquared(Point a, Point b, Point velocityA, Point velocityB, double time) {
		double deltaX = (a.getX()+velocityA.getX()*time)-(b.getX()+velocityB.getX()*time);
		double deltaY = (a.getY()+velocityA.getY()*time)-(b.getY()+velocityB.getY()*time);
		return deltaX*deltaX+deltaY*deltaY;
	}
}
