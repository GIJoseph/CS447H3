package Question1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.geom.Line2D;

import javax.sound.sampled.Line;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphPanel extends JPanel {
	double[][] apples;
	double[][] oranges;
	int height, width;
	int num = 10;
	Graphics2D gr;
	Line2D line;
	double w1;
	double w2;
	int theta;
	
	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponents(g);
		
		gr = (Graphics2D) g;
		height = getHeight();
		width = getWidth();
		drawBox(gr);
		drawApples();
		drawOranges();
		drawPerceptronLine();
	}
	public void drawBox(Graphics2D gr)
	{
		
		gr.drawLine(50, height - 50, 50, 0);
		gr.drawLine(50, height - 50, width , height - 50);
		for(int i = 0; i < num; i++)
		{
			gr.drawLine(50 + i * ((width - 50)/num), height - 50, 50 + i * ((width - 50)/num), height - 60);
			gr.drawChars((i * .5 + "").toCharArray(), 0, (i * .5 + "").length(), 50 + i * ((width - 50)/num), height - 40);
			gr.drawLine(50, height - (50 + i * ((height - 50)/num)), 60, height - (50 + i * ((height - 50)/num)));
			gr.drawChars((i * .5 + "").toCharArray(), 0, (i * .5 + "").length(), 30, height - (50 + i * ((height - 50)/num)));
		}
	}
	public void drawPerceptronLine()
	{
		double x1 = 0;
		double y1 = 3.62427; //(-1 * theta/w1);
		double x2 = 3.12763; //( theta/w2);
		double y2 = 0;
		gr.drawLine((int) (50 + (((width - 50)/(num /2)) * x1)), (int) (height - (50 + (((height - 50)/(num /2)) * y1))) ,(int) (50 + (((width - 50)/(num /2)) * x2)) , (int) (height - (50 + (((height - 50)/(num /2)) * y2))));
		System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
	}
	public void drawApples()
	{
		gr.setColor(Color.BLUE);
		for(int i = 0; i < apples[0].length; i++)
		{
			gr.drawChars(new char[] {'+'}, 0, 1, (int) (50 + (((width - 50)/(num /2)) * apples[0][i])) - 5, (int) (height - (50 + (((height - 50)/(num /2)) * apples[1][i]) - 5)));
		}
	}
	public void drawOranges()
	{
		gr.setColor(Color.RED);
		for(int i = 0; i < apples[0].length; i++)
		{
			gr.drawChars(new char[] {'o'}, 0, 1, (int) (50 + (((width - 50)/(num /2)) * oranges[0][i])) - 5, (int) (height - (50 + (((height - 50)/(num /2)) * oranges[1][i]) - 5)));
		}
	}
	
}
