package GUI;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main_GUI {

	public Main_GUI() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				MainFrame frame = new MainFrame("RD Automation");
				
				frame.setSize(500, 400);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				
			}//run end
			
		});// runnable end
	
	}// Main End

}// Class end
