package com.vijet.docheadergenerator;

import java.io.IOException;

import com.vijet.docheadergenerator.fileformat.AcceptedFileFormats;
import com.vijet.docheadergenerator.header.HeaderText;
import com.vijet.docheadergenerator.headerappender.HeaderFileAppender;
import com.vijet.docheadergenerator.util.Constants;
import com.vijet.docheadergenerator.util.FolderUtil;

public class DocHeaderGeneratorStartUp {

	public static void main(String[] args) throws IOException {
		if(args.length < 3){
			throw new IllegalArgumentException(Constants.INVALID_ARGUMENTS);
		}		
		//Check if the input is a folder.
		FolderUtil.checkForFolder(args[0]);
		//setup the header
		HeaderText headerText = new HeaderText(args[1]);
		//setup the formats
		AcceptedFileFormats fileFormats = new AcceptedFileFormats(args);
		// Iterate through the source folder and add the header
		new HeaderFileAppender(args[0],headerText,fileFormats);
		System.out.println("DocHeaderGenerator finished updating the files..!!");
	}

}
