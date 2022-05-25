package a_FileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InputFileTest {
	static String rootPath = ".\\INPUT";
	
	static void FileSearchAll(String path) {
		File directory = new File(path);
		File[] fList = directory.listFiles();
		
		for(File file: fList) {
			if(file.isDirectory()) {
				FileSearchAll(file.getPath());
			} else {
				String partPath = path.substring(rootPath.length());
				System.out.println("."+partPath+"\\"+file.getName());
				if(file.length()>3*1024) {
					System.out.println(file.getName());
				}
			}
		}
	}
	
	static void MyCopyFile(String partPath, String filename) {
		final int BUFFER_SIZE = 512;
		int readLen;
		
		try {
			File destFolder = new File(".\\OUTPUT" + partPath);
			if(!destFolder.exists()) {
				destFolder.mkdir();
			}
			
			InputStream inputStream = new FileInputStream(".\\INPUT"+partPath+"\\"+filename);
			OutputStream outputStream = new FileOutputStream(".\\OUTPUT"+partPath+"\\"+filename);
			
			byte[] buffer = new byte[BUFFER_SIZE];
			
			while((readLen = inputStream.read(buffer))!=-1) {
				outputStream.write(buffer,0,readLen);
			}
			
			inputStream.close();
			outputStream.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
