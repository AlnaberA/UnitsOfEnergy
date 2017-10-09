package com.dteeenrgy.exe;
/********************************************
 * AUTHOR: Alaa Al Naber
 * Created For: DTE ENERGY
 *
Update Log:

*@author 
UPADTED BY: User--u32785
UPADTED ON: Date--Nov 18, 2016
UPADTED AT: Time--8:47:31 AM
*@author 
UPADTED BY: User--u32785
UPADTED ON: Date--Dec 27, 2016
UPADTED AT: Time--2:39:42 PM
@author 
UPADTED BY: User--u32785
UPADTED ON: Date--Jan 3, 2017
UPADTED AT: Time--10:38:22 AM
 @author 
UPADTED BY: User--u32785
UPADTED ON: Date--Jan 4, 2017
UPADTED AT: Time--10:44:45 AM
@author 
UPADTED BY: User--u32785
UPADTED ON: Date--Mar 13, 2017
UPADTED AT: Time--1:08:49 PM
@author 
UPADTED BY: User--u32785
UPADTED ON: Date--Mar 17, 2017
UPADTED AT: Time--3:27:35 PM
@author 
UPADTED BY: User--u32785
UPADTED ON: Date--Apr 18, 2017
UPADTED AT: Time--8:34:09 AM
@author 
UPADTED BY: User--u32785
UPADTED ON: Date--Apr 20, 2017
UPADTED AT: Time--12:01:34 PM
@author 
UPADTED BY: User--u32785
UPADTED ON: Date--Apr 27, 2017
UPADTED AT: Time--10:50:25 AM
 *
 ********************************************/

//Imported Libraries

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.EventQueue;
import java.awt.Image;


public class driver implements ActionListener {

	
	private JFrame mainframe;
	private JPanel mainPanel;
	private JTextField textFieldCurrent;
	private JTextField textFieldResistance;
	private JTextField textFieldVoltage;
	private JTextField textFieldWattage;
	
	private JMenuBar menuBar;
	private JMenu mnNewMenuHelp;
	private JMenuItem mntmNewMenuItemAbout;
	private JMenuItem mntmExit;
	private JMenu mnFile;
	
	private JLabel ohmWheelIMG;

	//Created objects
	private static changelog log;
	private static String info;
	
	
	/**
	 * Launch the application.(Main Class)
	 */
	public static void main(String[] args) {
		log = new changelog();
		log.changelogTxt();
		info = log.information;
		log.setVERSION_NUMBER("v00.00.22");
		System.out.println(log.getVERSION_NUMBER());
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					driver window = new driver();
					window.mainframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		//Program Exits
		Runtime.getRuntime().addShutdownHook(new Thread() {           
			public void run() {        
				System.out.println("Shutdown Hook is running in main.");
				}
			});
	}

	
	/*
	 * Button Methods
	 */
	//Calculate Button
	public void buttonCalulateOhmsLaw() {

		//Given Current and Resistance to calculate Voltage and watts
		if( !(textFieldCurrent.getText().isEmpty()) && !(textFieldResistance.getText().isEmpty()) )
		{
			//Initializing as strings
			String currentText = textFieldCurrent.getText();
			String resistanceText = textFieldResistance.getText();
			
			//Parsing to double, global values to the conditions
			double currentValue = Double.parseDouble(currentText);
			double resistanceValue = Double.parseDouble(resistanceText);
			
			double voltage = 0.0;
			double wattage=0.0;
			voltage = currentValue*resistanceValue;					//Calculating Voltage
			wattage = (currentValue*currentValue)*resistanceValue;	//Calculating watts(Power)
			
			textFieldVoltage.setText(Double.toString(voltage));
			textFieldWattage.setText(Double.toString(wattage));
			
			System.out.println("Input Current: " + currentValue);
			System.out.println("Input Resistance: " + resistanceValue);
			System.out.println("Calculated Volatege: "+ voltage);
			System.out.println("Calculated Wattage: "+ wattage);
		}

		//Given Current and Voltage to calculate resistance and watts
		else if( !(textFieldCurrent.getText().isEmpty()) && !(textFieldVoltage.getText().isEmpty()) )
		{
			//Initializing as strings
			String currentText = textFieldCurrent.getText();
			String voltageText = textFieldVoltage.getText();
			
			
			//Parsing to double, global values to the conditions
			double currentValue = Double.parseDouble(currentText);
			double voltageValue = Double.parseDouble(voltageText);
			
			
			
			double resistance = 0.0;
			double wattage = 0.0;
					
			//Calculate wattage
			wattage = currentValue*voltageValue;
			textFieldWattage.setText(Double.toString(wattage));
			
			
			//Check if current is zero
			if(currentValue != 0)
			{
				resistance = voltageValue/currentValue;
				textFieldResistance.setText(Double.toString(resistance));
				System.out.println("Input Current: " + currentValue);
				System.out.println("Input Voltage: " + voltageValue);
				System.out.println("Calculated Resistance: "+ resistance);
				System.out.println("Calculated Wattage: "+ wattage);
			}
			else{
				JOptionPane.showMessageDialog(mainframe, "Error: Argument 'divisor' is 0", "Error", 0);
				throw new IllegalArgumentException("Argument 'divisor' is 0");	//Placeholder code DON'T STOP EXECUTION
			}	
						
		}

		//resistance and voltage given to calculate current and wattage
		else if( !(textFieldResistance.getText().isEmpty()) && !(textFieldVoltage.getText().isEmpty()) )
		{
			//Initializing as strings
			String resistanceText = textFieldResistance.getText();
			String voltageText = textFieldVoltage.getText();
			
			
			//Parsing to double, global values to the conditions
			double resistanceValue = Double.parseDouble(resistanceText);
			double voltageValue = Double.parseDouble(voltageText);
			
			
			double current = 0.0;
			double wattage = 0.0;
			
			//Check if resistance is zero
			if(resistanceValue > 0)
			{
				current = voltageValue/resistanceValue;
				wattage = (voltageValue*voltageValue)/resistanceValue;
				textFieldCurrent.setText(Double.toString(current));
				textFieldWattage.setText(Double.toString(wattage));
				System.out.println("Input Resistance: " + resistanceValue);
				System.out.println("Input Voltage: " + voltageValue);
				System.out.println("Calculated Current: "+ current);
				System.out.println("Calculated Wattage: " + wattage);
			}
			else{
				JOptionPane.showMessageDialog(mainframe, "Error: Argument 'divisor' is 0 OR Resistance is negative", "Error", 0);
				throw new IllegalArgumentException("Argument 'divisor' is 0");
			}
			
		}

		//Current and wattage given to calculate voltage and resistance
		else if( !(textFieldCurrent.getText().isEmpty()) && !(textFieldWattage.getText().isEmpty()) )
		{
			//Initializing as strings
			String currentText = textFieldCurrent.getText();
			String wattageText = textFieldWattage.getText();
			
			//Parsing to double, global values to the conditions
			double currentValue = Double.parseDouble(currentText);
			double wattageValue = Double.parseDouble(wattageText);
			
			double voltage = 0.0;
			double resistance = 0.0;
			
			if(currentValue != 0){
				voltage = wattageValue/currentValue;
				resistance=wattageValue/(currentValue*currentValue);
				textFieldVoltage.setText(Double.toString(voltage));
				textFieldResistance.setText(Double.toString(resistance));
				System.out.println("Input Current: " + currentValue);
				System.out.println("Input Wattage: " + wattageValue);
				System.out.println("Calculated Voltage: " + voltage);
				System.out.println("Calculated Resistance: " + resistance);
			}
			else{
				JOptionPane.showMessageDialog(mainframe, "Error: Argument 'divisor' is 0", "Error", 0);
				throw new IllegalArgumentException("Argument 'divisor' is 0");
			}
			
		}
		
		//resistance and wattage given to calculate current and voltage
		else if( !(textFieldResistance.getText().isEmpty()) && !(textFieldWattage.getText().isEmpty()) ){
			//Initializing as strings
			String resistanceText = textFieldResistance.getText();
			String wattageText = textFieldWattage.getText();
			
			
			//Parsing to double, global values to the conditions
			double resistanceValue = Double.parseDouble(resistanceText);
			double wattageValue = Double.parseDouble(wattageText);
			
			
			double current = 0.0;
			double voltage = 0.0;
			
			if(resistanceValue <= 0){
				JOptionPane.showMessageDialog(mainframe, "Argument 'divisor' is 0 OR Argument 'Resistance' is negative", "Error", 0);
				throw new IllegalArgumentException("Argument 'divisor' is 0 OR Argument 'Resistance' is negative");
			}
			else{
				if(wattageValue<0){
					wattageValue = Math.abs(wattageValue);
				}
				current = Math.sqrt(wattageValue/resistanceValue);
				voltage= Math.sqrt(wattageValue*resistanceValue);
				textFieldCurrent.setText(Double.toString(current));
				textFieldVoltage.setText(Double.toString(voltage));
				System.out.println("Input Resistance: " + resistanceValue);
				System.out.println("Input Wattage: " + wattageValue);
				System.out.println("Calculated Voltage: " + voltage);
				System.out.println("Calculated current: " + current);	
			}
		}
		
		//voltage and wattage given to calculate current and resistance
		else if( !(textFieldVoltage.getText().isEmpty()) && !(textFieldWattage.getText().isEmpty()) ){
			//Initializing as strings
			String voltageText = textFieldVoltage.getText();
			String wattageText = textFieldWattage.getText();
			
			//Parsing to double, global values to the conditions
			double voltageValue = Double.parseDouble(voltageText);
			double wattageValue = Double.parseDouble(wattageText);
			
			double current = 0.0;
			double resistance = 0.0;
			if(!(voltageValue == 0 || wattageValue == 0)){
				current = wattageValue/voltageValue;
				resistance = (voltageValue*voltageValue)/wattageValue;
				textFieldCurrent.setText(Double.toString(current));
				textFieldResistance.setText(Double.toString(resistance));
				System.out.println("Input Voltage: " + voltageValue);
				System.out.println("Input Wattage: " + wattageValue);
				System.out.println("Calculated resistance: " + resistance);
				System.out.println("Calculated current: " + current);	
			}
			else{
				JOptionPane.showMessageDialog(mainframe, "Error: Argument 'divisor' is 0", "Error", 0);
				throw new IllegalArgumentException("Argument 'divisor' is 0");
			}
		}
    }
	
	public void buttonClearFields(){
		textFieldCurrent.setText("");
		textFieldResistance.setText("");
		textFieldVoltage.setText("");
		textFieldWattage.setText("");
	}
	/*
	 * End button methods
	 */
	
	
	/**
	 * Create the application.
	 */
	public driver() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainframe = new JFrame("Units of Energy");
		mainframe.setAutoRequestFocus(false);
		mainframe.getContentPane().setBackground(Color.WHITE);
		mainframe.setBackground(Color.WHITE);
		mainframe.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\u32785\\workspace\\Units Of Energy\\img\\main_icon.png"));
		mainframe.setResizable(false);
		mainframe.setBounds(100, 100, 1000, 1000);
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainframe.getContentPane().setLayout(null);
		mainframe.setLocation(0, 0);//Sets the location of the JFrame
		
		
		/*
		 * Menu Bar Creation
		 * */
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 994, 20);
		mainframe.getContentPane().add(menuBar);
		
		mnFile = new JMenu("File");
		mnFile.setBackground(SystemColor.menu);
		mnFile.addMenuListener(new menuListener());
		menuBar.add(mnFile);
		
		//Create the exit menu item on the menu bar
		mntmExit = new JMenuItem("Exit");
		mntmExit.setBackground(Color.WHITE);
		mntmExit.setIcon(new ImageIcon(driver.class.getResource("/javax/swing/plaf/metal/icons/ocean/paletteClose.gif")));
		mntmExit.addActionListener(this);
		mnFile.add(mntmExit);
		
		mnNewMenuHelp = new JMenu("Help");
		mnNewMenuHelp.setBackground(SystemColor.menu);
		mnNewMenuHelp.addMenuListener(new menuListener());
		menuBar.add(mnNewMenuHelp);
		
		mntmNewMenuItemAbout = new JMenuItem(" About Units of Energy ");
		mntmNewMenuItemAbout.setIcon(new ImageIcon(driver.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		mntmNewMenuItemAbout.setBackground(Color.WHITE);
		mntmNewMenuItemAbout.addActionListener(this);
		mnNewMenuHelp.add(mntmNewMenuItemAbout);	
		/*
		 * End Menu Bar
		 * */
		
		//Main Panel creation
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 21, 994, 951);
		mainframe.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		

		//Text Fields Creation
		textFieldCurrent = new JTextField();
		textFieldCurrent.setBounds(20, 60, 155, 20);
		mainPanel.add(textFieldCurrent);
		textFieldCurrent.setColumns(10);
		
		textFieldResistance = new JTextField();
		textFieldResistance.setBounds(20, 125, 155, 20);
		mainPanel.add(textFieldResistance);
		textFieldResistance.setColumns(10);
		
		textFieldVoltage = new JTextField();
		textFieldVoltage.setBounds(20, 190, 155, 20);
		mainPanel.add(textFieldVoltage);
		textFieldVoltage.setColumns(10);
		
		textFieldWattage = new JTextField();
		textFieldWattage.setBounds(20, 260, 155, 20);
		mainPanel.add(textFieldWattage);
		textFieldWattage.setColumns(10);
		
				
		  
		//Labels Creation
		JLabel lblVoltageLabel = new JLabel("Current");
		lblVoltageLabel.setBounds(20, 38, 126, 28);
		mainPanel.add(lblVoltageLabel);
		
		JLabel lblResistance = new JLabel("Resistance");
		lblResistance.setBounds(20, 91, 126, 37);
		mainPanel.add(lblResistance);
		
		JLabel lblVoltage = new JLabel("Voltage");
		lblVoltage.setBounds(20, 156, 126, 37);
		mainPanel.add(lblVoltage);
		
		JLabel lblWattage = new JLabel("Wattage");
		lblWattage.setBounds(20, 221, 126, 37);
		mainPanel.add(lblWattage);
		
		JLabel lblAmpsUnit = new JLabel("Amps");
		lblAmpsUnit.setBounds(190, 63, 46, 14);
		mainPanel.add(lblAmpsUnit);
		
		JLabel lblOhmsUnit = new JLabel("\u03A9");
		lblOhmsUnit.setBounds(190, 128, 46, 14);
		mainPanel.add(lblOhmsUnit);
		
		JLabel lblVoltsUnit = new JLabel("Volts");
		lblVoltsUnit.setBounds(190, 193, 46, 14);
		mainPanel.add(lblVoltsUnit);
		
		JLabel lvlWattsUnit = new JLabel("Watts");
		lvlWattsUnit.setBounds(190, 263, 46, 14);
		mainPanel.add(lvlWattsUnit);
		
		JLabel lblComingSoon = new JLabel("<html>\r\nComing soon:\r\n<br>\r\nmore calculations including- \r\n<br>\r\nNuclear Calculations, \r\n<br>\r\nPhysics Calculations, \r\n<br>\r\nComputer science Calculations,\r\n<br> \r\nMore Electrical Engineering calculation</html>");
		lblComingSoon.setBounds(717, 774, 267, 166);
		mainPanel.add(lblComingSoon);
		
		Label labelOhmsLaw = new Label("Ohm's Law");
		labelOhmsLaw.setBounds(0, 10, 76, 22);
		mainPanel.add(labelOhmsLaw);
		
		Image ohmLawFormulaWheel = new ImageIcon(this.getClass().getResource("/Ohms-Law-Formula-Wheel.png")).getImage();
		ohmWheelIMG = new JLabel("");
		ohmWheelIMG.setBounds(479, 11, 443, 344);
		mainPanel.add(ohmWheelIMG);
		ohmWheelIMG.setIcon(new ImageIcon(ohmLawFormulaWheel));
				
				
		//Buttons
		//Button Calculate Ohms law
		JButton btnCalculateButton = new JButton("Calulate Ohm's Law");
		btnCalculateButton.setBounds(20, 303, 155, 20);
		mainPanel.add(btnCalculateButton);
		btnCalculateButton.addActionListener(new ActionListener() {			//Button Action for Calculate Ohms Law
			public void actionPerformed(ActionEvent e) {
					System.out.println("btnCalculateButton - Action:Clicked");
					buttonCalulateOhmsLaw();
			}
		});
		//Button Clear Fields
		JButton btnClear = new JButton("Clear Fields Above");
		btnClear.setBounds(20, 334, 155, 20);
		mainPanel.add(btnClear);
		btnClear.addActionListener(new ActionListener() {					//Button Action for Clear Field
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("btnClear - Action:Clicked");
				buttonClearFields();
			}
		});
		
		
		
		/*
		 * #BEGIN
		 * THIS PART OF THE CODE IS FOR THE MAIN MENU BUTTON THAT WILL BE DISPLAYED FOR EACH 
		 * PANEL AT THE SAME LOCATION(10,917,89,23)
		 * */
		/*
		 * Button for going back to the main screen
		 * EACH NEW PANEL OBJECT MUST GO HERE AND setVisble() MUST BE SET FALSE 
		 */
		//Objects go here
		conversion convPanel = new conversion();				//Creating a new conversion Object, to goto the conversions panel
		SystemInformation sysInfoPanel = new SystemInformation(); 	//Creating a new SystemInformation Object, to goto the SystemInformation panel
		geolocation geoLocPanel = new geolocation();
		
		JButton mainMenuFromConversionPanel = new JButton("Main Menu");
		mainMenuFromConversionPanel.setBounds(10, 915, 125, 25);
		convPanel.add(mainMenuFromConversionPanel);
	
		mainMenuFromConversionPanel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				System.out.println("mainMenuFromConversionPanel - Action:Clicked");
				mainframe.getContentPane().remove(convPanel);			
				mainPanel.setVisible(true);
			}
		});
		
		JButton mainMenuFromSysInfoPanel = new JButton("Main Menu");
		mainMenuFromSysInfoPanel.setBounds(10, 915, 125, 25);
		sysInfoPanel.add(mainMenuFromSysInfoPanel);
	
		mainMenuFromSysInfoPanel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				System.out.println("mainMenuFromSysInfoPanel - Action:Clicked");
				mainframe.getContentPane().remove(sysInfoPanel);			
				mainPanel.setVisible(true);
			}
		});
		
		
		JButton mainMenuFrom_geoLocPanel = new JButton("Main Menu");
		mainMenuFrom_geoLocPanel.setBounds(10, 915, 125, 25);
		geoLocPanel .add(mainMenuFrom_geoLocPanel);
	
		mainMenuFrom_geoLocPanel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				System.out.println("mainMenuFrom_geoLocPanel - Action:Clicked");
				mainframe.getContentPane().remove(geoLocPanel);			
				mainPanel.setVisible(true);
			}
		});
		

		/*
		 * CREATE NEW BUTTONS WHICH TAKE YOU TO NEW PANELS HERE 
		 * EACH PANEL IS IN ITS OWN CLASS
		 */
		JButton btnConversions = new JButton("Conversions");
		btnConversions.setBounds(20, 385, 126, 23);
		mainPanel.add(btnConversions);
		
		JButton btnSystemInfo = new JButton("System Information");
		btnSystemInfo.setBounds(20, 906, 155, 23);
		mainPanel.add(btnSystemInfo);
		
		JButton btnGeoLocation = new JButton("Geo-Location");
		btnGeoLocation.setBounds(190, 385, 126, 23);
		mainPanel.add(btnGeoLocation);
		
		btnConversions.addActionListener(new ActionListener() {					//Button Action for Conversions Field
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("btnConversions - Action:Clicked");
				
				mainframe.getContentPane().add(convPanel);
				convPanel.setSize(1000, 1000);
				convPanel.setVisible(true);
				mainPanel.setVisible(false);
			}
		});
		
		btnSystemInfo.addActionListener(new ActionListener() {					//Button Action for Conversions Field
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("btnSystemInfo - Action:Clicked");
				
				mainframe.getContentPane().add(sysInfoPanel);
				sysInfoPanel.setSize(1000, 1000);
				sysInfoPanel.setVisible(true);
				mainPanel.setVisible(false);
			}
		});
		
		btnGeoLocation.addActionListener(new ActionListener() {					//Button Action for Conversions Field
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("btnGeoLocation - Action:Clicked");
	
				mainframe.getContentPane().add(geoLocPanel);
				geoLocPanel.setSize(1000, 1000);
				geoLocPanel.setVisible(true);
				mainPanel.setVisible(false);
			}
		});
		
		/*
		 * #END 
		 */
	}
	
	
	 //Action performed on menuBar
	public void actionPerformed(ActionEvent e) {

			if(e.getSource().equals(mntmNewMenuItemAbout))
			{	
				System.out.println("mntmNewMenuItemAbout - ActionPreformed");
			    JPanel changeLogPanel = new JPanel ();
			    changeLogPanel.setBorder ( new TitledBorder ( new EtchedBorder (), "Change Log" ) );

			    // create the middle panel components
			    JTextArea changeLogDisplay = new JTextArea ( 20, 60 );
			    changeLogDisplay.setText(info);
			    changeLogDisplay.setEditable ( false ); // set textArea non-editable
			    JScrollPane changeLogScrollBar = new JScrollPane ( changeLogDisplay );
			    changeLogScrollBar.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );

			    //Add Textarea in to changeLogPanel
			    changeLogPanel.add ( changeLogScrollBar );

			    // Adding panel to the changeLogframe
			    //Giving settings to changeLogFrame
			    JFrame changeLogFrame = new JFrame ("About Units of Energy");
			    changeLogFrame.getContentPane().add ( changeLogPanel );
			    changeLogFrame.pack ();
			    changeLogFrame.setLocationRelativeTo ( null );
			    changeLogFrame.setVisible ( true );
			    changeLogFrame.setAlwaysOnTop(true);
			    changeLogFrame.setResizable(false);
			    changeLogFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\u32785\\workspace\\Units Of Energy\\img\\main_icon.png"));
			    
			}
			if(e.getSource().equals(mntmExit))
			{
				System.exit(0);
			}
		}
	}
