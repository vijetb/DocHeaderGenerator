package com.vijet.docheadergenerator.fileformat;

import java.util.ArrayList;
import java.util.List;
/**
 * Class that contains the valid FileFormat
 * @author Vijet Badigannavar
 * @Date 03-30-2016 
 */
public class AcceptedFileFormats {
	private List<String> validFormat;
	private boolean isFileShouldBeAddedWithHeader = false;

	/**
	 * Slice the file formats and store it. If the input format is *.* then
	 * the {isFileShouldBeAddedWithHeader} is set to true and the list is cleared.
	 * @param args
	 */
	public AcceptedFileFormats(String[] args){

		validFormat = new ArrayList<String>();
		for(int i = 2 ; i < args.length; i++){
			validFormat.add(args[i].split("\\.")[1]);
		}
		((ArrayList<String>)validFormat).trimToSize();
		if(validFormat.contains("*")){
			isFileShouldBeAddedWithHeader = true;
			validFormat.clear();
			validFormat = null;
		}
	}

	/**
	 * Returns true if the supplied file has to be modified. False otherwise.
	 * This method extracts the extension of the file and checks if it needs to be modified.
	 * @param fileName the name of the file.
	 * @return true if the file has to be modified. False otherwise.
	 */
	public boolean isHeaderShouldBeAppeneded(final String fileName){
		return isFileShouldBeAddedWithHeader || (fileName.contains("\\.") && validFormat.contains(fileName.split("\\.")[1]));
	}

}
