package com.vijet.docheadergenerator;

import java.io.IOException;

import com.vijet.docheadergenerator.fileformat.AcceptedFileFormats;
import com.vijet.docheadergenerator.header.HeaderText;
import com.vijet.docheadergenerator.headerappender.HeaderFileAppender;
import com.vijet.docheadergenerator.util.Constants;
import com.vijet.docheadergenerator.util.FolderUtil;
/**
 * Main class that is initiated by the Library. 
 * It checks for valid number of arguments. The general format for executing the library
 * is:
 * java -jar docHeaderGenerator.jar <path_to_project_root> <path_to_file> <file_format> [file_format]
 * @author Vijet Badigannavar
 * @Date 03-30-2016
 */
public class DocHeaderGeneratorStartUp {
	/**
	 * Entry point for the library. Checks for the minimum number of arguments.
	 * Checks if the project_root is a folder and setup the headerText.
	 * It also setup all the file formats that needs to be modified and iterates
	 * through each of the files in the project_root and modifies it accordingly.
	 * @param args
	 * @throws IOException if all the arguments are not specified.
	 */
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
