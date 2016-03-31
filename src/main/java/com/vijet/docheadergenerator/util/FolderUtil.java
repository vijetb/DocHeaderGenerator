package com.vijet.docheadergenerator.util;

import java.io.File;

import com.vijet.docheadergenerator.exception.InvalidSourceFolderException;

public class FolderUtil {
	public static final void checkForFolder(final String folderPath) throws InvalidSourceFolderException{
		File folder = new File(folderPath);
		if(!folder.isDirectory()){
			throw new InvalidSourceFolderException(Constants.INVALID_SOURCE_EXCEPTION);
		}
	}
}
