package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import testCases.Setup;

public class MainFrame extends JFrame {

	public MainFrame(String title) {
		super(title);
		
		//set layout manager
		setLayout(new BorderLayout());
		
		// Create component
		Container c = getContentPane();
		
		// Create components
		JButton run = new JButton("Run Test");
		Setup t = new Setup();
		/*
		JLabel[] label = new JLabel[t.getPropertiesCount()];
		JTextField[] tf = new JTextField[t.getPropertiesCount()];
        for (int i = 0; i < t.getPropertiesCount(); i++){
        	label[i] = new JLabel(t.getProperties()[i].getName());
        	tf[i] = new JTextField();
        	c.add(label[i], BorderLayout.LINE_START);
        	c.add(tf[i], BorderLayout.LINE_START);
        }
		//c.add(run, BorderLayout.CENTER);
        */
		/*
      //Create and populate the panel.
        JPanel p = new JPanel(new SpringLayout());
        p.setPreferredSize(new Dimension(300, 100));// hardCoded sizing
        p.setMaximumSize(new Dimension(300, 100));  // hardCoded sizing
        p.setMinimumSize(new Dimension(300, 100));  // hardCoded sizing
        for (int i = 0; i <  t.getPropertiesCount(); i++) {
            JLabel l = new JLabel(t.getProperties()[i].getName(), JLabel.TRAILING);
            p.add(l);
            JTextField textField = new JTextField(50);
            l.setLabelFor(textField);
            p.add(textField);
        }

        //Lay out the panel.
        SpringUtilities.makeCompactGrid(p,
        								t.getPropertiesCount(), 2, //rows, cols
                                        6, 6,        //initX, initY
                                        6, 6);       //xPad, yPad
        c.add(p, BorderLayout.LINE_START);
		*/
		JPanel p = new JPanel(new GridLayout(0, 2));
		p.setPreferredSize(new Dimension(300, 100));// hardCoded sizing
        p.setMaximumSize(new Dimension(300, 100));  // hardCoded sizing
        p.setMinimumSize(new Dimension(300, 100));  // hardCoded sizing
		for (int i = 0; i <  t.getPropertiesCount(); i++) {
            JLabel l = new JLabel(t.getProperties()[i].getName(), JLabel.TRAILING);
            p.add(l);
            JTextField textField = new JTextField(50);
            l.setLabelFor(textField);
            p.add(textField);
        }
		
		c.add(p, BorderLayout.LINE_START);
	}
}
