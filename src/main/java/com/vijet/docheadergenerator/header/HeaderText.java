package com.vijet.docheadergenerator.header;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public final class HeaderText {
	private final StringBuilder headerText;
	
	public HeaderText(String filePath) throws IOException {
		headerText = new StringBuilder();
		setupHeader(filePath);
	}
	
	private void setupHeader(final String filePath) throws IOException{
		File headerFile = new File(filePath);
		String dataString = new String();
		BufferedReader reader = new BufferedReader(new FileReader(headerFile));
		while((dataString = reader.readLine()) != null){
			headerText.append(dataString);
			headerText.append(System.lineSeparator());
		}
	}
	
	public String getHeaderText(){
		return headerText.toString();
	}
	
}
