package com.odev.pdp;

import java.io.FileNotFoundException;

public class ApplicationTest {

	public static void main(String[] args) throws FileNotFoundException {
		
		Application app = new Application();
		
		System.out.println("Harmonical average is " + app.harmonicalAverage(app.parsing(app.readFromText())));
		
		
	}
}
