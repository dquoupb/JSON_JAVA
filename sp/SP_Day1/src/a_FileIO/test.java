package a_FileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// INPUT폴더 하위에 위치한 파일들의 파일명(상대경로 포함)
// INPUT폴더 하위에 위치한 파일 중 3Kbyte가 넘는 파일들 복사
public class test {
	
	static String rootPath = "./INPUT";
	
	public static void main(String[] args) {
		searchFile(rootPath);
	}

	static void searchFile(String path) {
		File directory = new File(path);
		File[] fList = directory.listFiles();

		for (File file : fList) {
			if (file.isDirectory())
				searchFile(file.getPath());
			else {
				// 앞부분(./INPUT부분 자르고 가져가겠다)
				String partPath = path.substring(rootPath.length());
				System.out.println("."+partPath+"\\"+file.getName());
				// 파일의 크기가 3Kbyte 넘는 파일이면
				if(file.length()>3*1024) {
					copyFile(partPath, file.getName());
				}
			}
		}
	}
	
	static void copyFile(String partPath, String fileName) {
		final int BUFFER_SIZE=512;
		int readLen;
		
		try {
			File destFolder = new File("./OUTPUT"+partPath);
			// output 폴더가 존재하지 않으면 만들어준다.
			if(!destFolder.exists()) {
				destFolder.mkdirs();
			}
			
			// 원본 파일 위치와 복사할 파일의 위치 각각 지정
			InputStream iStream = new FileInputStream("./INPUT"+partPath+"/"+fileName);
			OutputStream oStream = new FileOutputStream("./OUTPUT"+partPath+"/"+fileName);
			
			byte[] buffer = new byte[BUFFER_SIZE];
			
			while((readLen = iStream.read(buffer))!=-1) {
				oStream.write(buffer,0,readLen);
			}
			
			iStream.close();
			oStream.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
