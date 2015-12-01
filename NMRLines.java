import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Stack;

//Thanks to java2s.com for help figuring out how to use the Graphics Module.

public class NMRLines extends JPanel {

	public Stack<Double> xlines;

  public NMRLines(Stack<Double> newstack){

	  xlines = newstack;
	}

public void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;


    g2d.setColor(Color.red);

    	Line2D xaxis = new Line2D.Double(0, 925, 1500, 925);

    	g2d.draw(xaxis);

    	for(int i2=0; i2 <= 14; i2++)
    	{
    		String currentstring = "" + i2;

    		g2d.drawString(currentstring, (14-i2)*100 ,950);
    	}

    	while(!xlines.isEmpty())
    	{
    		System.out.println("Drawing" + xlines.peek());

    		Line2D currentline = new Line2D.Double( (14 - xlines.peek())*100, 925, (14 - xlines.peek())*100, 0);

    		xlines.pop();

    		g2d.draw(currentline);

    }
  }

  public static void main(String[] args) {
	Stack<Double> newstack = new Stack<Double>();
	newstack.add(5.2);
	newstack.add(6.3);

    NMRLines lines = new NMRLines(newstack);
    JFrame frame = new JFrame("NMRLines");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(lines);
    frame.setSize(1500, 1000);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
