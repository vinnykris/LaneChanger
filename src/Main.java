import java.awt.Color;

import javax.swing.JFrame;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Lane Changer 3.0");
		
		frame.setSize(500, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
//		frame.setAlwaysOnTop(true);
		frame.setLocation(350, 100);
		
//		frame.getContentPane().setBackground(Color.GRAY);
		frame.add(new GameFrame());
		frame.setVisible(true);
	}

}
