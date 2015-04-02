/*
7 * Brandon Izor
 * CS350
 * Project3
 * A class to generate a main window and process operations
 * 
 */
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.io.*;

import java.awt.*;
import java.util.ArrayList;

public class MainWindow extends JFrame implements ActionListener {
	JLabel heading1;
	JLabel heading2;
	JLabel heading3;
	JLabel heading4;
	JLabel heading5;
	JLabel heading6;
	
	private DefaultListModel lst = new DefaultListModel();
	JList display = new JList(lst);
	//display.;//(new Font("Monospaced",Font.PLAIN,12));
	
	JButton add;
	JButton edit;
	JButton remove;
	JButton clear;
	JButton open;
	JButton save;

	ArrayList<CDriver> drivers = new ArrayList<CDriver>();
	
	public MainWindow(String fileName) {
		super("Test Drive Requests");
		
		Container c = getContentPane();
		c.setLayout(null);
		
		
		//label column headings
		heading1 = new JLabel("Customer No.");
		heading1.setSize(100,25);
		heading1.setLocation(50,50);
		c.add(heading1);
		
		heading2 = new JLabel("Customer Name");
		heading2.setSize(1025,25);
		heading2.setLocation(150,50);
		c.add(heading2);
		
		heading3 = new JLabel("Driving Years");
		heading3.setSize(100,25);
		heading3.setLocation(275,50);
		c.add(heading3);
		
		heading4 = new JLabel("Jeep Owner");
		heading4.setSize(100,25);
		heading4.setLocation(375,50);
		c.add(heading4);
		
		heading5 = new JLabel("Models");
		heading5.setSize(100,25);
		heading5.setLocation(475,50);
		c.add(heading5);
		
		heading6 = new JLabel("Transmission");
		heading6.setSize(100,25);
		heading6.setLocation(575,50);
		c.add(heading6);
		
		//textField = new JTextArea();
		display.setSize(675,400);
		display.setLocation(45,75);
		c.add(display);
		
		add = new JButton("Add");
		add.setSize(100,50);
		add.setLocation(45, 500);
		add.addActionListener(this);
		c.add(add);
		
		edit = new JButton("Edit");
		edit.setSize(100,50);
		edit.setLocation(160,500);
		edit.addActionListener(this);
		c.add(edit);
		
		remove = new JButton("Remove");
		remove.setSize(100,50);
		remove.setLocation(275,500);
		remove.addActionListener(this);
		c.add(remove);
		
		clear = new JButton("Clear");
		clear.setSize(100,50);
		clear.setLocation(390,500);
		clear.addActionListener(this);
		c.add(clear);
		
		open = new JButton("Open");
		open.setSize(100,50);
		open.setLocation(505,500);
		open.addActionListener(this);
		c.add(open);
		
		save = new JButton("Save");
		save.setSize(100,50);
		save.setLocation(620,500);
		save.addActionListener(this);
		c.add(save);
		
		if (fileName != null) {
			
		}
		
		setSize(770,600);
		setLocation( 100, 100);
		setVisible(true);
		
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add) {
			//launch dialog box
			Dialog d = new Dialog(this, "Add a Test Driver",1);
			if (!d.isCancelled()) {
				CDriver answer = d.getRecord();
				String s = "";
				drivers.add(answer);
				
				
					s += answer.stringify();
					s += "\n";
					lst.addElement(s);
				}
			}
		
		if (e.getSource() == remove) {
			int removedIndex = display.getSelectedIndex();
			drivers.remove(removedIndex);
			lst.remove(removedIndex);
		}
		if (e.getSource() == clear) {
			drivers.clear();
			lst.clear();
		}
		if (e.getSource() == save) { // saves to a file selected by a JFileChooser
			JFileChooser chooser = new JFileChooser();
			chooser.setVisible(true);
			int retrieval = chooser.showSaveDialog(null);
			if (retrieval == JFileChooser.APPROVE_OPTION) {
				try {
					FileWriter fw = new FileWriter(chooser.getSelectedFile());
					fw.write(""); // clears existing file
					for (CDriver driver : this.drivers) {
						fw.write(driver.GenerateSaveOutput() + "\n"); // writes the save output for each driver
					}
					//fw.write()
					fw.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		if (e.getSource() == open) {

			
			JFileChooser chooser = new JFileChooser();
			chooser.setVisible(true);
			int retrieval = chooser.showOpenDialog(null);
			if (retrieval == JFileChooser.APPROVE_OPTION) {
				try {
					FileReader fr = new FileReader(chooser.getSelectedFile());
					BufferedReader br = new BufferedReader(fr);
					String line;
					drivers.clear();
					lst.clear();
					
					while ((line = br.readLine()) != null) { // reads a single line and makes a CDriver instance
						String[] tokens = line.split(":");
						CDriver loadedDriver = new CDriver(); //instantiate and empty CDriver
						//System.out.print(tokens[0]);
						loadedDriver.setCustomerNumber(Integer.parseInt(tokens[0]));
						loadedDriver.setCustomerName(tokens[1]);
						loadedDriver.setDrivingYears(Integer.parseInt(tokens[2]));
						if (Integer.parseInt(tokens[3]) == 1) {
							loadedDriver.setJeepOwner(true);
						} else {
							loadedDriver.setJeepOwner(false);
						}
						String modelString = tokens[4];
						boolean[] loadedModels = new boolean[5];
						for (int i = 0; i < modelString.length(); i++) {
							int c = modelString.charAt(i);
							if (c == 1) {
								loadedModels[i] = true;
							}
							else {
								loadedModels[i] = false;
							}
							System.out.println(loadedModels[0]);
						}
						loadedDriver.setModels(loadedModels);
						loadedDriver.setTransmission(Integer.parseInt(tokens[5]));
						drivers.add(loadedDriver);
						String s = "";
						s += loadedDriver.stringify();
						s += "\n";
						lst.addElement(s);
						
					}
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		
	}
	public static void main(String[] args) {
		String defaultFile = null;
		if (args.length>0) {
			defaultFile = args[0];
		}
		MainWindow mainWnd = new MainWindow(defaultFile);
		mainWnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
