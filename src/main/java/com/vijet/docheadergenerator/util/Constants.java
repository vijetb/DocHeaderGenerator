package com.vijet.docheadergenerator.util;

/**
 * Utility class to display the messages on the console.
 * @author Vijet Badigannvar
 */
public class Constants {
	public static final String INVALID_ARGUMENTS = "Invalid arguments!\nThe path should be of form"
			+ " java -jar docHeaderGenerator.jar <path_to_project_root> <path_to_file> <file_types>";
	public static final String IO_EXCEPTION = "File not found";
	public static final String INVALID_SOURCE_EXCEPTION = "Source folder is not valid";
	public static final String FILE_MODIFIED = " is Modified!!!";
	public static final String FILE_NOT_MODIFIED = " is not Modified!!!";
}
