package com.vijet.docheadergenerator.util;

import java.io.File;

import com.vijet.docheadergenerator.exception.InvalidSourceFolderException;

/**
 * Utility class to check for Folder
 * @author Vijet Badigannavar
 */
public class FolderUtil {
	/**
	 * Checks if the given file is a Folder.
	 * @param folderPath
	 * @throws InvalidSourceFolderException
	 */
	public static final void checkForFolder(final String folderPath) throws InvalidSourceFolderException{
		File folder = new File(folderPath);
		if(!folder.isDirectory()){
			throw new InvalidSourceFolderException(Constants.INVALID_SOURCE_EXCEPTION);
		}
	}
}
