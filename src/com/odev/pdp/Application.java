package com.odev.pdp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

	public String[] readFromText() throws FileNotFoundException{ //reads lines from the text, stores them in lines array
		
		Scanner input = new Scanner(new File("veriler.txt"));
		String[] lines = new String[10];
		int count = 0;
		
		while(input.hasNext()){					//if there is another line, stores it in the lines array
			lines[count] = input.nextLine();
			count++;
		}
		
		input.close();
		
		return lines;
	}
	
	
	public boolean isProper(String line){
		
		String pattern = "sayilar(([0-9]+\\s)+)([0-9]+#)";	//format is like : sayilar12 24 34#
		
		Pattern pt = Pattern.compile(pattern);				//compiles defined string(your regex) into a pattern
		
		Matcher match = pt.matcher(line);					//scans the line you give
		
		if(match.find())									//if finds any match, returns true
			return true;
		
		else												//if not, returns false
			return false;
	}
	
	
	public String[] parsing(String[] lines){				//splits the proper lines into numbers and
															//stores it in the numbers string
		String[] numbers = new String[30];				
		int countForLines = 0;
		int count = 0;
		
		while(lines[countForLines]!=null){					//if line is not null
		
			if(isProper(lines[countForLines])){				//if line is proper according to you regex design
				Pattern pt = Pattern.compile("[0-9]{2,}+");			//finds the numbers
				Matcher match = pt.matcher(lines[countForLines]);	//scans the line
			
				while(match.find()){						//if finds any number
					System.out.println(match.group());		//stores it in the numbers array
					numbers[count] = match.group();
					count++;
				}
			}
			
			else											//if line is not proper to your regex design :
				System.out.println(lines[countForLines] + " is not proper!...");
			
			countForLines++;
	    }
			
		return numbers;
	}
	
	
	public double harmonicalAverage(String[] array){	//makes harmonical average of founded numbers in the txt
		
		double average = 0;
		double count = 0;		//count is for how many numbers you have
		
		for(int i = 0; i < array.length; i++){
			if(array[i]!=null){
			average += 1 / Double.parseDouble(array[i]); //double.parsedouble is a transforming method
			count++;											//that transforms string to double
			}
		}
		
		average = count / average;
		
		return (int)average;		//clearing the floating part
	}
	
}
