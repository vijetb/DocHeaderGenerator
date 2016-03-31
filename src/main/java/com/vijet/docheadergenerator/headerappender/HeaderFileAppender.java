package com.vijet.docheadergenerator.headerappender;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import com.vijet.docheadergenerator.fileformat.AcceptedFileFormats;
import com.vijet.docheadergenerator.header.HeaderText;

public class HeaderFileAppender {
	private final HeaderText headerText;
	private final AcceptedFileFormats accptdFileFormats;
	private final File sourceFolder;

	public HeaderFileAppender(String sourceFolderName, HeaderText headerText,AcceptedFileFormats fileFormats) throws IOException {
		this.headerText = headerText;
		this.accptdFileFormats = fileFormats;
		sourceFolder = new File(sourceFolderName);
		updateFiles(sourceFolder);
	}

	private void updateFiles(File sourceFolder) throws IOException{
		if(sourceFolder.isDirectory()){
			File[] fileList = sourceFolder.listFiles();
			if(fileList!=null){
				for (File file : fileList) {
					updateFiles(file);
				}
			}
		}else{
			updateHeaderForFile(sourceFolder);
		}
	}

	private void updateHeaderForFile(File sourceFile) throws IOException{
		if(!accptdFileFormats.isHeaderShouldBeAppeneded(sourceFile.getName())){
			System.out.println(sourceFile.getCanonicalPath()+" is not Modified!!!");
			return;
		}

		StringBuilder originalFileName = new StringBuilder(sourceFile.getName());
		File backUpFile = new File(sourceFile.getParentFile().getPath()+"/temp_"+originalFileName);

		try{
			Files.copy(Paths.get(sourceFile.getPath()), Paths.get(backUpFile.getPath()), StandardCopyOption.COPY_ATTRIBUTES);
		}catch(IOException e){
			if(backUpFile.exists()){
				backUpFile.delete();
			}
			System.out.println(sourceFile.getCanonicalPath()+" is not Modified!!!");
		}

		try{
			StringBuilder fileContents = new StringBuilder();
			fileContents.append(headerText.getHeaderText());
			String tempFileContent = new String();

			BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
			while((tempFileContent = reader.readLine()) != null){
				fileContents.append(tempFileContent);
				fileContents.append(System.lineSeparator());
			}
			reader.close();

			FileWriter writer = new FileWriter(sourceFile);
			writer.append(fileContents.toString());
			writer.flush();
			writer.close();
			backUpFile.delete();
			System.out.println(sourceFile.getCanonicalPath()+" is Modified!!!");
		}catch(IOException e){
			e.printStackTrace();
			backUpFile.renameTo(sourceFile);
			System.out.println(backUpFile.getCanonicalPath()+" is not Modified!!!");
		}
	}

}
