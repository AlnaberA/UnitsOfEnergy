/*
 * KNOWN BUG
 * ISSUE TYPE MAJOR
 * Negative number causes:
 * Exception in thread "AWT-EventQueue-0" java.lang.NumberFormatException: For input string: "-"
	at sun.misc.FloatingDecimal.readJavaFormatString(Unknown Source)
	at sun.misc.FloatingDecimal.parseDouble(Unknown Source)
	at java.lang.Double.parseDouble(Unknown Source)
	at com.dteeenrgy.exe.conversion$1.eventTextFieldMicroamps(conversion.java:228)
	at com.dteeenrgy.exe.conversion$1.insertUpdate(conversion.java:220)
	at javax.swing.text.AbstractDocument.fireInsertUpdate(Unknown Source)
	at javax.swing.text.AbstractDocument.handleInsertString(Unknown Source)
	at javax.swing.text.AbstractDocument.insertString(Unknown Source)
	at javax.swing.text.PlainDocument.insertString(Unknown Source)
	at javax.swing.text.AbstractDocument.replace(Unknown Source)
	at javax.swing.text.JTextComponent.replaceSelection(Unknown Source)
	at javax.swing.text.DefaultEditorKit$DefaultKeyTypedAction.actionPerformed(Unknown Source)
	at javax.swing.SwingUtilities.notifyAction(Unknown Source)
	at javax.swing.JComponent.processKeyBinding(Unknown Source)
	at javax.swing.JComponent.processKeyBindings(Unknown Source)
	at javax.swing.JComponent.processKeyEvent(Unknown Source)
	at java.awt.Component.processEvent(Unknown Source)
	at java.awt.Container.processEvent(Unknown Source)
	at java.awt.Component.dispatchEventImpl(Unknown Source)
	at java.awt.Container.dispatchEventImpl(Unknown Source)
	at java.awt.Component.dispatchEvent(Unknown Source)
	at java.awt.KeyboardFocusManager.redispatchEvent(Unknown Source)
	at java.awt.DefaultKeyboardFocusManager.dispatchKeyEvent(Unknown Source)
	at java.awt.DefaultKeyboardFocusManager.preDispatchKeyEvent(Unknown Source)
	at java.awt.DefaultKeyboardFocusManager.typeAheadAssertions(Unknown Source)
	at java.awt.DefaultKeyboardFocusManager.dispatchEvent(Unknown Source)
	at java.awt.Component.dispatchEventImpl(Unknown Source)
	at java.awt.Container.dispatchEventImpl(Unknown Source)
	at java.awt.Window.dispatchEventImpl(Unknown Source)
	at java.awt.Component.dispatchEvent(Unknown Source)
	at java.awt.EventQueue.dispatchEventImpl(Unknown Source)
	at java.awt.EventQueue.access$500(Unknown Source)
	at java.awt.EventQueue$3.run(Unknown Source)
	at java.awt.EventQueue$3.run(Unknown Source)
	at java.security.AccessController.doPrivileged(Native Method)
	at java.security.ProtectionDomain$JavaSecurityAccessImpl.doIntersectionPrivilege(Unknown Source)
	at java.security.ProtectionDomain$JavaSecurityAccessImpl.doIntersectionPrivilege(Unknown Source)
	at java.awt.EventQueue$4.run(Unknown Source)
	at java.awt.EventQueue$4.run(Unknown Source)
	at java.security.AccessController.doPrivileged(Native Method)
	at java.security.ProtectionDomain$JavaSecurityAccessImpl.doIntersectionPrivilege(Unknown Source)
	at java.awt.EventQueue.dispatchEvent(Unknown Source)
	at java.awt.EventDispatchThread.pumpOneEventForFilters(Unknown Source)
	at java.awt.EventDispatchThread.pumpEventsForFilter(Unknown Source)
	at java.awt.EventDispatchThread.pumpEventsForHierarchy(Unknown Source)
	at java.awt.EventDispatchThread.pumpEvents(Unknown Source)
	at java.awt.EventDispatchThread.pumpEvents(Unknown Source)
	at java.awt.EventDispatchThread.run(Unknown Source)
 * ERROR SHOULD BE SOLVED 
 * SOLUTION ETA: DAYS
 * */
package com.dteeenrgy.exe;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;



public class conversion extends JPanel {

	/**
	 * Serializability of a class is enabled by the class implementing the java.io.Serializable interface. 
	 * Classes that do not implement this interface will not have any of their state serialized or deserialized. 
	 * All subtypes of a serializable class are themselves serializable. 
	 * The serialization interface has no methods or fields and serves only to identify the semantics of being serializable.
	 * http://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html
	 * */
	private static final long serialVersionUID = -2871454794821033689L;

	private JTextField textFieldFahrenheit;
	private JTextField textFieldCelsius;
	private JTextField textFieldKelvin;
	private JTextField textFieldMicroamps;
	private JTextField textFieldAmps;
	private JTextField textFieldMilliamps;

	private JLabel lblOutput;
	private JLabel lblKelvin;
	private JLabel lblCelsius;
	private JLabel lblFahrenheit;
	private JLabel lblTemperature;
	private JLabel lblOutputElectricCurrent;

	
	public void buttonConvertFunc()	{
		//Format number to, two decimal places0
		NumberFormat formatter = new DecimalFormat("#0.00");
		
		//Creating a new frame object called errorFrame
		JFrame errorFrame = new JFrame();	

		//Condition to check what input is given

		//All inputs given throw error
		if( !(textFieldFahrenheit.getText().isEmpty()) && !(textFieldCelsius.getText().isEmpty()) && !(textFieldKelvin.getText().isEmpty())){
			System.out.println("In the condition");
	
			JOptionPane.showMessageDialog(errorFrame, "Error: Argument 'textFieldFahrenheit' & 'textFieldCelsius' & 'textFieldKelvin' are all filled", "Error", 0);
			throw new IllegalArgumentException("Argument textFieldFahrenheit' & 'textFieldCelsius' & 'textFieldKelvin' are all filled");
		}
		//Fahrenheit is given
		else if(!(textFieldFahrenheit.getText().isEmpty()) && (textFieldCelsius.getText().isEmpty()) && (textFieldKelvin.getText().isEmpty()) ){
			double fahrenheitValue = Double.parseDouble(textFieldFahrenheit.getText());
			System.out.println("Fahrenheit(INPUT) value: " + fahrenheitValue);
			
			//Calculations
			double celsius = 0;
			double kelvin = 0;
			celsius = (fahrenheitValue-32) * 5/9;
			kelvin = (fahrenheitValue - 32) * 5/9 + 273.15;
			
			lblOutput.setText("OUTPUT - Celsius:( " + formatter.format(celsius) +" ) Kelvin:( " + formatter.format(kelvin) + " )");
			System.out.println("Calculated celsius: " + celsius);
			System.out.println("Calculated Kelvin: " + kelvin);
		}
		//Celsius is given
		else if(!(textFieldCelsius.getText().isEmpty()) && (textFieldFahrenheit.getText().isEmpty()) && (textFieldKelvin.getText().isEmpty())){
			double celsiusValue = Double.parseDouble(textFieldCelsius.getText());
			System.out.println("Celsius value: " + celsiusValue);
			
			//Calculations
			double fahrenheit = 0;
			double kelvin = 0;
			fahrenheit = (celsiusValue * 9/5) +32;
			kelvin = celsiusValue + 273.15;
			lblOutput.setText("OUTPUT - Fahrenheit:( " + formatter.format(fahrenheit) +" ) Kelvin:( " + formatter.format(kelvin) + " )");
			System.out.println("Calculated fahrenheit: " + fahrenheit);
			System.out.println("Calculated Kelvin: " + kelvin);
		}
		//Kelvin is given
		else if(!(textFieldKelvin.getText().isEmpty()) && (textFieldCelsius.getText().isEmpty()) && (textFieldFahrenheit.getText().isEmpty())){
			double kelvinValue = Double.parseDouble(textFieldKelvin.getText());
			System.out.println("Kelvin value: " + kelvinValue);
			
			
			//Calculations
			double fahrenheit=0;
			double celsius=0;
			
			fahrenheit=(kelvinValue - 273.15) * 9/5 + 32;
			celsius= kelvinValue - 273.15;
			lblOutput.setText("OUTPUT - Fahrenheit:( " + formatter.format(fahrenheit) +" ) Celsius:( " + formatter.format(celsius) + " )");
			System.out.println("Calculated fahrenheit: " + fahrenheit);
			System.out.println("Calculated celsius: " + celsius);
		}
		//Else throw error
		else{
			JOptionPane.showMessageDialog(errorFrame, "Error: Invalid input", "Error", 0);
			throw new IllegalArgumentException("Invalid input");
		}
	}
	
	
	public conversion() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		//Separators
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.WHITE);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.BLACK);
		separator.setBounds(376, 10, 2, 294);
		add(separator);
		
		//LABELS
		//#Begin Tempature
		lblTemperature = new JLabel("<html>Temperature <br> Enter ONE of the following fields:</html>");
		lblTemperature.setBounds(10, 22, 203, 48);
		add(lblTemperature);
		
		lblFahrenheit = new JLabel("Fahrenheit");
		lblFahrenheit.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFahrenheit.setBounds(20, 70, 76, 14);
		add(lblFahrenheit);
		
		lblCelsius = new JLabel("Celsius");
		lblCelsius.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCelsius.setBounds(20, 126, 76, 14);
		add(lblCelsius);
		
		lblOutput = new JLabel("OUTPUT:");
		lblOutput.setBounds(30, 244, 346, 36);
		add(lblOutput);
		
		lblKelvin = new JLabel("Kelvin");
		lblKelvin.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblKelvin.setBounds(20, 182, 46, 14);
		add(lblKelvin);		
		//#End
		
		//#Begin ElectricCurrent		
		JLabel lblMilliamps = new JLabel("Milliamps");
		lblMilliamps.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMilliamps.setBounds(396, 126, 76, 14);
		add(lblMilliamps);
		
		JLabel lblElectricCurrent = new JLabel("<html>Electric Current <br> Enter ONE of the following fields:</html>");
		lblElectricCurrent.setBounds(386, 22, 203, 48);
		add(lblElectricCurrent);
		
		JLabel lblMicroamps = new JLabel("Microamps");
		lblMicroamps.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMicroamps.setBounds(396, 71, 76, 14);
		add(lblMicroamps);
		
		JLabel lblAmps = new JLabel("Amps");
		lblAmps.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAmps.setBounds(396, 182, 76, 14);
		add(lblAmps);		
		
		lblOutputElectricCurrent = new JLabel("OUTPUT:");
		lblOutputElectricCurrent.setBounds(386, 244, 500, 36);
		add(lblOutputElectricCurrent);
		//#End
		//#END LABELS
		//Text Fields
		textFieldFahrenheit = new JTextField();
		textFieldFahrenheit.setColumns(10);
		textFieldFahrenheit.setBounds(30, 95, 66, 20);
		add(textFieldFahrenheit);

		textFieldCelsius = new JTextField();
		textFieldCelsius.setColumns(10);
		textFieldCelsius.setBounds(30, 151, 66, 20);
		add(textFieldCelsius);
		
		textFieldKelvin = new JTextField();
		textFieldKelvin.setColumns(10);
		textFieldKelvin.setBounds(30, 207, 66, 20);
		add(textFieldKelvin);
		
		
		textFieldMicroamps = new JTextField();
		textFieldMicroamps.setColumns(10);
		textFieldMicroamps.setBounds(406, 95, 100, 20);
		add(textFieldMicroamps);
		
		textFieldAmps = new JTextField();
		textFieldAmps.setColumns(10);
		textFieldAmps.setBounds(406, 207, 100, 20);
		add(textFieldAmps);
		
		textFieldMilliamps = new JTextField();
		textFieldMilliamps.setBounds(406, 151, 100, 20);
		add(textFieldMilliamps);
		textFieldMilliamps.setColumns(10);
		//#END
		
		//#Begin 
		//Listen for changes in the text
		//Event action for textFieldMicroAmps
		textFieldMicroamps.getDocument().addDocumentListener(new DocumentListener() {
		  public void changedUpdate(DocumentEvent e) {
			  System.out.println("textFieldMicroamps - Action:Change-changedUpdate");
			  eventTextFieldMicroamps();
		  }
		  public void removeUpdate(DocumentEvent e) {
			  System.out.println("textFieldMicroamps - Action:Change-removeUpdate");
			  if(textFieldMicroamps.getText().equals("")){
				  //Empty string do not goto the event function
				  System.out.println("Empty String;");
				  lblOutputElectricCurrent.setText("OUTPUT:");
			  }else{
			  eventTextFieldMicroamps();
			  }
		  }		  
		  public void insertUpdate(DocumentEvent e) {
			  System.out.println("textFieldMicroamps - Action:Change-insertUpdate");
			  eventTextFieldMicroamps();
		  }

		  public void eventTextFieldMicroamps() {
				System.out.println("event_Function Microamps");
				System.out.println("textFieldMicroamps - Value - In event function:"+ textFieldMicroamps.getText());
				textFieldMilliamps.setText("");
				textFieldAmps.setText("");
				double microamps = Double.parseDouble((textFieldMicroamps.getText()));
				lblOutputElectricCurrent.setText("OUTPUT: " +"Amps:"+ String.valueOf(microamps/1000000) + " | Milliamps:" + String.valueOf(microamps/1000));
		  }
		});
		//Event action for textFieldAmps
		textFieldAmps.getDocument().addDocumentListener(new DocumentListener() {
		  public void changedUpdate(DocumentEvent e) {
			  System.out.println("textFieldAmps - Action:Change-changedUpdate");
			  eventTextFieldAmps();
		  }
		  public void removeUpdate(DocumentEvent e) {
			  System.out.println("textFieldAmps - Action:Change-removeUpdate");
			  if(textFieldAmps.getText().equals("")){
				  //Empty string do not goto the event function
				  System.out.println("Empty String;");
				  lblOutputElectricCurrent.setText("OUTPUT:");
			  }else{
			  eventTextFieldAmps();
			  }
		  }		  
		  public void insertUpdate(DocumentEvent e) {
			  System.out.println("textFieldAmps - Action:Change-insertUpdate");
			  eventTextFieldAmps();
		  }

		  public void eventTextFieldAmps() {
			  System.out.println("event_Function Amps");
			  System.out.println("textFieldAmps - Value - In event function:"+ textFieldAmps.getText());
			  textFieldMilliamps.setText("");
			  textFieldMicroamps.setText("");
			  double amps = Double.parseDouble((textFieldAmps.getText()));
			  lblOutputElectricCurrent.setText("OUTPUT: "+"Microamps: " + String.valueOf(amps*1000000) + " | Milliamps: " + String.valueOf(amps*1000));
		  }
		});	
		//Event action for textFieldMilliamps
		textFieldMilliamps.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent e) {
				  System.out.println("textFieldMilliamps - Action:Change-changedUpdate");
				  eventTextFieldMilliamps();
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				  System.out.println("textFieldAmps - Action:Change-removeUpdate");
				  if(textFieldMilliamps.getText().equals("")){
					  //Empty string do not goto the event function
					  System.out.println("Empty String;");
					  lblOutputElectricCurrent.setText("OUTPUT:");
				  }else{
					  eventTextFieldMilliamps();
				  }
				
			}			
			@Override
			public void insertUpdate(DocumentEvent e) {
				  System.out.println("textFieldMilliamps - Action:Change-insertUpdate");
				  eventTextFieldMilliamps();
			}
			public void eventTextFieldMilliamps(){
				System.out.println("event_Function Milliamps");
				System.out.println("textFieldMilliamps - Value - In event function:"+ textFieldMilliamps.getText());
				textFieldMicroamps.setText("");
				textFieldAmps.setText("");
				double milliAmps = Double.parseDouble((textFieldMilliamps.getText()));
				lblOutputElectricCurrent.setText("OUTPUT: "+"Microamps: " + String.valueOf(milliAmps*1000) + " | Amps: " + String.valueOf(milliAmps/1000));
			}
			
		});
		//#End

		
		JButton btnConvertTemp = new JButton("Convert");
		btnConvertTemp.setBounds(20, 281, 89, 23);
		add(btnConvertTemp);
		btnConvertTemp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("btnConvert - Action:Clicked");				
				//Goto button convert function
				  buttonConvertFunc();				
			}
		});
		
		//Program Exits from conversion.java
		Runtime.getRuntime().addShutdownHook(new Thread() {           
			public void run() {        
				System.out.println("Shutdown Hook is running in conversion.java");
				}
			});


	}
}
