package com.vijet.docheadergenerator.header;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class that stores the header text. This contains the information from the file that is
 * supplied as the second argument while executing the jar.
 * @author Vijet Badigannavar
 **/
public final class HeaderText {
	private final StringBuilder headerText;
	
	public HeaderText(String filePath) throws IOException {
		headerText = new StringBuilder();
		setupHeader(filePath);
	}
	
	/**
	 * Reads the data from the file and stores it internally.
	 * @param filePath the path to the header file
	 * @throws IOException if file is not present 
	 */
	private void setupHeader(final String filePath) throws IOException{
		File headerFile = new File(filePath);
		String dataString = new String();
		BufferedReader reader = new BufferedReader(new FileReader(headerFile));
		while((dataString = reader.readLine()) != null){
			headerText.append(dataString);
			headerText.append(System.lineSeparator());
		}
		reader.close();
	}
	
	/**
	 * Returns the text that needs to be appended to each of the file.
	 * @return
	 */
	public String getHeaderText(){
		return headerText.toString();
	}
	
}
