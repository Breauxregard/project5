/*
 * Brandon Izor
 * CS350
 * Project3
 * A class launched by MainWindow to display a dialog box
 * and create and return a CDriver object
 * or edit an existing CDriver object and return it
 */

import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;


public class Dialog extends JDialog implements ActionListener {

	CDriver record;
	public CDriver getRecord() {return record;}
	
	int customerNumber;
	
	JLabel labelCustomerNo;
	JLabel labelCustomerName;
	JLabel labelYears;
	JLabel labelJeep;
	JLabel labelModels;
	JLabel labelTransmission;
	
	String paddedCustomerNumber;
	JTextField nameField;
	JTextField yearsField;
	
	JRadioButton rbYes;
	JRadioButton rbNo;
	ButtonGroup jeepGroup;
	
	JCheckBox compass;
	JCheckBox grandCherokee;
	JCheckBox patriot;
	JCheckBox renegade;
	JCheckBox others;
	
	JRadioButton rbFiveSpeed;
	JRadioButton rbSixSpeed;
	JRadioButton rbEightSpeed;
	JRadioButton rbDontCare;
	ButtonGroup transmissionGroup;
	
	JButton submitButton;
	JButton cancelButton;
	
	JLabel cusNum;
	JTextField cusName;
	JTextField yearsDriven;
	
	private int tempCustomerNumber;
	private String tempCustomerName;
	private int tempDrivingYears;
	private boolean tempIsJeepOwner;
	private boolean[] tempModels;
	private int tempTransmission;
	
	private boolean cancelled;
	public boolean isCancelled() { return cancelled;}
	
	int nextDriverNumber = 1;
	String strDriveNum = String.valueOf(nextDriverNumber);
	
	public Dialog(CDriver rec) {
		//TODO initialize the dialog box using an existing CDriver object
	}
	
	public Dialog(JFrame owner, String title, int initVal) {
		//TODO initialize the CDriver object
		super(owner,title,true);
		
		Container c = getContentPane();
		c.setLayout(null);
		
		labelCustomerNo = new JLabel("Customer No.");
		labelCustomerNo.setFont(new Font("Serif", Font.BOLD, 12));
		labelCustomerNo.setSize(100,25);
		labelCustomerNo.setLocation(50,50);
		c.add(labelCustomerNo);
		
		cusNum = new JLabel(String.format("%05d", nextDriverNumber));
		cusNum.setSize(100,50);;
		cusNum.setLocation(150,38);
		c.add(cusNum);
		
		labelCustomerName = new JLabel("Customer Name");
		labelCustomerName.setFont(new Font("Serif", Font.BOLD, 12));
		labelCustomerName.setSize(150,25);
		labelCustomerName.setLocation(50,100);
		c.add(labelCustomerName);
		
		cusName = new JTextField();
		cusName.setSize(350,25);
		cusName.setLocation(200,100);
		c.add(cusName);
		
		labelYears = new JLabel("How many years have you been driving?");
		labelYears.setFont(new Font("Serif", Font.BOLD, 12));
		labelYears.setSize(350,25);
		labelYears.setLocation(50, 150);
		c.add(labelYears);
		
		yearsDriven = new JTextField();
		yearsDriven.setSize(40,25);
		yearsDriven.setLocation(400,150);
		c.add(yearsDriven);
		
		labelJeep = new JLabel("Do you have a Jeep?");
		labelJeep.setFont(new Font("Serif", Font.BOLD, 12));
		labelJeep.setSize(350,25);
		labelJeep.setLocation(50,200);
		c.add(labelJeep);
		
		rbYes = new JRadioButton("Yes");
		rbYes.setSize(100,25);
		rbYes.setLocation(65, 225);
		c.add(rbYes);
		
		rbNo = new JRadioButton("No");
		rbNo.setSize(100,25);
		rbNo.setLocation(185, 225);
		c.add(rbNo);
		jeepGroup = new ButtonGroup();
		jeepGroup.add(rbYes);
		jeepGroup.add(rbNo);
		
		labelModels = new JLabel("Which Models are you interested in?");
		labelModels.setFont(new Font("Serif", Font.BOLD, 12));
		labelModels.setSize(350,25);
		labelModels.setLocation(50, 275);
		c.add(labelModels);
		
		compass = new JCheckBox("Compass");
		compass.setSize(100,25);
		compass.setLocation(65,300);
		c.add(compass);
		
		grandCherokee = new JCheckBox("Grand Cherokee");
		grandCherokee.setSize(125,25);
		grandCherokee.setLocation(185,300);
		c.add(grandCherokee);
		
		patriot = new JCheckBox("Patriot");
		patriot.setSize(100,25);
		patriot.setLocation(315,300);
		c.add(patriot);
		
		renegade = new JCheckBox("Renegade");
		renegade.setSize(100,25);
		renegade.setLocation(425,300);
		c.add(renegade);
		
		others = new JCheckBox("Others");
		others.setSize(100,25);
		others.setLocation(545,300);
		c.add(others);
		
		labelTransmission = new JLabel("Transmission:");
		labelTransmission.setFont(new Font("Serif", Font.BOLD, 12));
		labelTransmission.setSize(350,25);
		labelTransmission.setLocation(50,335);
		c.add(labelTransmission);
		
		rbFiveSpeed = new JRadioButton("5-Speed Manual");
		rbFiveSpeed.setSize(125,25);
		rbFiveSpeed.setLocation(65,360);
		c.add(rbFiveSpeed);
		
		rbSixSpeed = new JRadioButton("6-Speed Manual");
		rbSixSpeed.setSize(125,25);
		rbSixSpeed.setLocation(190,360);
		c.add(rbSixSpeed);
		
		rbEightSpeed = new JRadioButton("8-Speed Paddle-Shift Automatic");
		rbEightSpeed.setSize(225,25);
		rbEightSpeed.setLocation(315,360);
		c.add(rbEightSpeed);
		
		rbDontCare = new JRadioButton("Don\'t Care");
		rbDontCare.setSize(100,25);
		rbDontCare.setLocation(550,360);
		c.add(rbDontCare);
		transmissionGroup = new ButtonGroup();
		transmissionGroup.add(rbFiveSpeed);
		transmissionGroup.add(rbSixSpeed);
		transmissionGroup.add(rbEightSpeed);
		transmissionGroup.add(rbDontCare);
		
		
		submitButton = new JButton("Submit");
		submitButton.setSize(100, 50);
		submitButton.setLocation(50, 500);
		submitButton.addActionListener(this);
		c.add(submitButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setSize(100,50);
		cancelButton.setLocation(450,500);
		cancelButton.addActionListener(this);
		c.add(cancelButton);
		
		setSize(800,600);
		setLocationRelativeTo(owner);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==submitButton) {
			//TODO get answer stuff
			tempCustomerNumber = customerNumber;
			tempCustomerName = cusName.getText();
			tempDrivingYears = Integer.parseInt(yearsDriven.getText());
			if (rbYes.isSelected()) tempIsJeepOwner = true;
			if (rbNo.isSelected()) tempIsJeepOwner = false;
			tempModels = new boolean[5];
			if (compass.isSelected()) tempModels[0] = true;
			else {tempModels[0]=false;}
			if (grandCherokee.isSelected()) tempModels[1] = true;
			else {tempModels[1]=false;}
			if (patriot.isSelected()) tempModels[2] = true;
			else {tempModels[2] = false;}
			if (renegade.isSelected()) tempModels[3] = true;
			else {tempModels[3] = true;}
			if (others.isSelected()) tempModels[4] = true;
			else {tempModels[4] = false;}
			if (rbFiveSpeed.isSelected()) tempTransmission = 0;
			if (rbSixSpeed.isSelected()) tempTransmission = 1;
			if (rbEightSpeed.isSelected()) tempTransmission = 2;
			if (rbDontCare.isSelected()) tempTransmission = 3;
			
			record = new CDriver (tempCustomerNumber, tempCustomerName,tempDrivingYears, tempIsJeepOwner, tempModels,tempTransmission);
			
			cancelled = false;
			setVisible(false);
		}
		
		if (e.getSource() == cancelButton) {
			cancelled = true;
			setVisible(false);
		}
		
	}

}
