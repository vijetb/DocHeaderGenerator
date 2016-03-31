package com.vijet.docheadergenerator.fileformat;

import java.util.ArrayList;
import java.util.List;

public class AcceptedFileFormats {
	private List<String> validFormat;
	private boolean isFileShouldBeAddedWithHeader = false;
	
	public AcceptedFileFormats(String[] args){
		if(args.length == 2){
			isFileShouldBeAddedWithHeader = true;
		}else{
			validFormat = new ArrayList<String>();
			for(int i = 2 ; i < args.length; i++){
				validFormat.add(args[i].split("\\.")[1]);
			}
			if(validFormat.contains("*")){
				isFileShouldBeAddedWithHeader = true;
				validFormat.clear();
			}
			((ArrayList<String>)validFormat).trimToSize();
		}
	}
	
	public boolean isHeaderShouldBeAppeneded(final String fileName){
		return isFileShouldBeAddedWithHeader || validFormat.contains(fileName.split("\\.")[1]);
	}
	
}
