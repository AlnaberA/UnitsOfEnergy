package com.dteeenrgy.exe;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Canvas;

public class SystemInformation extends JPanel {

	/**
	 * Serializability of a class is enabled by the class implementing the java.io.Serializable interface. 
	 * Classes that do not implement this interface will not have any of their state serialized or deserialized. 
	 * All subtypes of a serializable class are themselves serializable. 
	 * The serialization interface has no methods or fields and serves only to identify the semantics of being serializable.
	 * http://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html
	 * */
	private static final long serialVersionUID = -2292882817957436835L;
	
	
	private int cores = Runtime.getRuntime().availableProcessors();
	private long memory = Runtime.getRuntime().freeMemory();
	private long maxMemory = Runtime.getRuntime().maxMemory();
	private long totalMemory = Runtime.getRuntime().totalMemory();
	private InetAddress IP = null;
	private String nameOS = "os.name";  
	private String versionOS = "os.version";  
	private String architectureOS = "os.arch";
	
	/**
	 * Create the panel.
	 */
	public SystemInformation() {
		setLayout(null);
		
		JLabel lblSystemInfo = new JLabel("System Information");
		lblSystemInfo.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		lblSystemInfo.setBounds(10, 55, 140, 15);
		add(lblSystemInfo);
		
		JLabel lblCores = new JLabel("Available processors (cores):");
		lblCores.setBounds(10, 106, 265, 15);
		add(lblCores);
		
		JLabel lblMemory = new JLabel("Free memory (bytes-JVM):");
		lblMemory.setBounds(10, 132, 265, 15);
		add(lblMemory);
		
		JLabel lblMaxMemory = new JLabel("Maximum memory (bytes-JVM):");
		lblMaxMemory.setBounds(10, 158, 265, 15);
		add(lblMaxMemory);
		
		JLabel lblTotalMemory = new JLabel("Total memory (bytes-JVM):");
		lblTotalMemory.setBounds(10, 184, 265, 15);
		add(lblTotalMemory);
		
		JLabel lblCoresOutput = new JLabel("");
		lblCoresOutput.setBounds(262, 107, 170, 14);
		add(lblCoresOutput);
		
		JLabel lblMemoryOutput = new JLabel("");
		lblMemoryOutput.setBounds(262, 133, 170, 14);
		add(lblMemoryOutput);
		
		JLabel lblMaxMemoryOutput = new JLabel("");
		lblMaxMemoryOutput.setBounds(262, 159, 170, 14);
		add(lblMaxMemoryOutput);
		
		JLabel lblTotalMemoryOutput = new JLabel("");
		lblTotalMemoryOutput.setBounds(262, 185, 170, 14);
		add(lblTotalMemoryOutput);
		
		JLabel lblOperatingSystem = new JLabel("Operating System:");
		lblOperatingSystem.setBounds(10, 210, 265, 15);
		add(lblOperatingSystem);
		
		JLabel lblOperatingSystemVersion = new JLabel("Operating System(Version):");
		lblOperatingSystemVersion.setBounds(10, 236, 265, 15);
		add(lblOperatingSystemVersion);
		
		JLabel lblOperatingSystemArchitecture = new JLabel("Operating System(Architecture):");
		lblOperatingSystemArchitecture.setBounds(10, 262, 265, 15);
		add(lblOperatingSystemArchitecture);
		
		JLabel lblIpAdress = new JLabel("IP Address");
		lblIpAdress.setBounds(10, 288, 265, 14);
		add(lblIpAdress);
		

		JLabel lblOsOutput = new JLabel("");
		lblOsOutput.setBounds(262, 210, 170, 14);
		add(lblOsOutput);
		
		JLabel lblOsVerOutput = new JLabel("");
		lblOsVerOutput.setBounds(262, 236, 170, 14);
		add(lblOsVerOutput);
		
		JLabel lblOsArchOutput = new JLabel("");
		lblOsArchOutput.setBounds(262, 262, 170, 14);
		add(lblOsArchOutput);
		
		JLabel lblIpAdressOutput = new JLabel("");
		lblIpAdressOutput.setBounds(262, 288, 170, 14);
		add(lblIpAdressOutput);
		
		try {
			IP = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lblCoresOutput.setText(Integer.toString(cores));
		lblMemoryOutput.setText(Long.toString(memory));
		lblMaxMemoryOutput.setText(Long.toString(maxMemory));
		lblTotalMemoryOutput.setText(Long.toString(totalMemory));
		
		lblOsOutput.setText(System.getProperty(nameOS));
		lblOsVerOutput.setText(System.getProperty(versionOS));
		lblOsArchOutput.setText(System.getProperty(architectureOS));
		lblIpAdressOutput.setText(IP.toString());
	
		

		
		
		//Program Exits in SystemInformation.java
		Runtime.getRuntime().addShutdownHook(new Thread() {           
			public void run() {        
				System.out.println("Shutdown Hook is running in SystemInformation.java");
				
				lblCoresOutput.setText("");
				lblMemoryOutput.setText("");
				lblMaxMemoryOutput.setText("");
				lblTotalMemoryOutput.setText("");
				
				lblOsOutput.setText("");
				lblOsVerOutput.setText("");
				lblOsArchOutput.setText("");
				lblIpAdressOutput.setText("");
				}
			});
		
		
		
		/**
		 * http://stackoverflow.com/questions/4044726/how-to-set-a-timer-in-java
		 */
		/*		Timer clock = new Timer();
				clock.schedule(new TimerTask() {
					  @Override
					  public void run() {
						//System.out.println("On");
						//System.out.println(Runtime.getRuntime().freeMemory());
						  lblMemoryOutput.setText(Long.toString(Runtime.getRuntime().freeMemory()));
						  
					  }
					}, 1*1*1000, 1*1*1000);// One second intervals
					//2*60*1000, 2*60*1000 = 2 minute intervals
		*/

	}
}
