/**
 * 
 */
package activity_tracker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author Liz
 *
 */
public class TextFileRead {
	
	File file;
	String type;
	
	public TextFileRead(File file){
		//this.file=file;
		//this.type=type;
		this.file=file;
	}
	
	/*
	 * This method reads a file and converts 
	 * it to a string
	 * 
	 * @param file of type File
	 * @return String - concatenated string
	 * 
	 */
	
	public String textToString() {
		StringBuilder s= new StringBuilder();
		try{
			Scanner sc=new Scanner(file);
			sc.nextLine();		
		while (sc.hasNextLine()) {
			s.append(sc.nextLine());
		   
		}
		sc.close();
		}
		catch(IOException e){
			
		}
		return s.toString();
	}
	/*
	 * This method takes a string and appends
	 * it to a specified text file
	 * 
	 * @param file of type file
	 * @param s of type String
	 * @return boolean : true if successfully written else false
	 * 
	 */
	
	public boolean addToText(String s){
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			out.newLine();
			out.append(s);
			
			out.close();
			return true;
	
	    } catch (IOException e) {
	    	//System.out.print("you fail");
	    	return false;
	    }
	}


}
