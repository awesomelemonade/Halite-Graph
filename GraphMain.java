import javax.swing.JFrame;

public class GraphMain {
	public static void main(String[] args) {
		CustomFunction function = new CustomFunction();
		double[] domain = new double[360];
		double[] values = new double[domain.length];
		Point[] points = new Point[domain.length];
		for(int i=0;i<domain.length;++i) {
			domain[i] = Math.toRadians(i);
			values[i] = function.apply(domain[i]);
			points[i] = new Point(domain[i], values[i]);
		}
		JFrame frame = new JFrame("Graph");
		frame.add(new Renderer(points));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setVisible(true);
	}
}
