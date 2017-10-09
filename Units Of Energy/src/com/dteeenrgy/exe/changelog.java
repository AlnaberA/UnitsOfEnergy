package com.dteeenrgy.exe;

import java.io.*;

public class changelog {
	
	public changelog(){
		VERSION_NUMBER = "0.0.00";
	}
	
	//Getter for versionNumber
	public String getVERSION_NUMBER() {
		return VERSION_NUMBER;
	}
	//Setter for versionNumber
	public void setVERSION_NUMBER(String version_number) {
		VERSION_NUMBER = version_number;
	}

	public void changelogTxt(){
			try {
				FileReader file = new FileReader("C:/Users/u32785/workspace/Units Of Energy/txt/changelog.txt");
				BufferedReader reader = new BufferedReader(file);
				
				information = "";
				String line = reader.readLine();
				while(line != null){
					information +=line;
					information +="\n";
					line = reader.readLine();
				}
				//Testing what is stored in information variable
				//System.out.println(information);
				reader.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("File not found.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}


	// Version Key(0.0.00) -- First Number "High-profile change","Medium-profile change","Low-Profile change"
	public static String VERSION_NUMBER; 
	
	String information;
}
