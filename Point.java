
public class Point {
	private double x;
	private double y;
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getRadius() {
		return x;
	}
	public double getTheta() {
		return y;
	}
	@Override
	public String toString() {
		return String.format("[%f, %f]", x, y);
	}
}
