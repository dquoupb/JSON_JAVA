package a_FileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// INPUT���� ������ ��ġ�� ���ϵ��� ���ϸ�(����� ����)
// INPUT���� ������ ��ġ�� ���� �� 3Kbyte�� �Ѵ� ���ϵ� ����
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
				// �պκ�(./INPUT�κ� �ڸ��� �������ڴ�)
				String partPath = path.substring(rootPath.length());
				System.out.println("."+partPath+"\\"+file.getName());
				// ������ ũ�Ⱑ 3Kbyte �Ѵ� �����̸�
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
			// output ������ �������� ������ ������ش�.
			if(!destFolder.exists()) {
				destFolder.mkdirs();
			}
			
			// ���� ���� ��ġ�� ������ ������ ��ġ ���� ����
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