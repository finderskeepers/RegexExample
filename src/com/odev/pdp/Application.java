package com.odev.pdp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

	public String[] readFromText() throws FileNotFoundException{
		
		Scanner input = new Scanner(new File("veriler.txt"));
		String[] lines = new String[10];
		int count = 0;
		
		while(input.hasNext()){
			lines[count] = input.nextLine();
			count++;
		}
		
		input.close();
		
		return lines;
	}
	
	
	public boolean isProper(String line){
		
		String pattern = "sayilar(([0-9]+\\s)+)([0-9]+#)";
		
		Pattern pt = Pattern.compile(pattern);
		
		Matcher match = pt.matcher(line);
		
		if(match.find())
			return true;
		
		
		else
			return false;
	}
	
	
	public String[] parsing(String[] lines){
		
		String[] numbers = new String[30];
		int countForLines = 0;
		int count = 0;
		
		while(lines[countForLines]!=null){
		
			if(isProper(lines[countForLines])){
				Pattern pt = Pattern.compile("[0-9]{2,}+");
				Matcher match = pt.matcher(lines[countForLines]);
			
				while(match.find()){
					System.out.println(match.group());
					numbers[count] = match.group();
					count++;
				}
			}
			else
				System.out.println(lines[countForLines] + " is not proper!...");
			countForLines++;
	    }
			
		return numbers;
	}
	
	
	public double harmonicalAverage(String[] array){
		
		double average = 0;
		double count = 0;
		
		for(int i = 0; i < array.length; i++){
			if(array[i]!=null){
			average += 1 / Double.parseDouble(array[i]);
			count++;
			}
		}
		
		average = count / average;
		
		return (int)average;
	}
	
}
