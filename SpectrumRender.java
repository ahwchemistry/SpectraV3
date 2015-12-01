import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.geom.*;
import java.util.Stack;

public class SpectrumRender extends JFrame {
	
	public Stack<Double> mylines;
	
	public SpectrumRender(Stack<Double> xlines)
	{
		
		mylines = xlines;
		
		JPanel SpectrumPanel = new JPanel();
		
		getContentPane().add(SpectrumPanel);
		
		setSize(1000,1000);
		
	}
	
	public SpectrumRender() {
		// TODO Auto-generated constructor stub
		
		
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		
		Graphics2D Spectrum2D = (Graphics2D) g;
		
		Spectrum2D.setColor(Color.black);
		
		System.out.println("I am about to add the new line");
		
		Line2D.Double testline = new Line2D.Double(0, 0, 1000, 1000);
		
		Spectrum2D.draw(testline);
	}
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SpectrumRender TestNMR = new SpectrumRender();
		TestNMR.setVisible(true);

	}

}
