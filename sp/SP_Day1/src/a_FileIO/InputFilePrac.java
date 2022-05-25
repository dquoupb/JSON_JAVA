package a_FileIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.StringTokenizer;

public class InputFilePrac {

	public static void main(String[] args) {
//		PrintFile("test.txt");
//		CopyFile("test.txt","made.txt");
//		FileDirList();
		FileSearchAll(".");
	}

	// �ؽ�Ʈ ���� read&print
	static void PrintFile(String fileName) {
		String line = null;
		try {
			// �Է� ��Ʈ��
			FileReader fr = new FileReader(fileName);
			// �Է� ��Ʈ�����κ��� ���ڸ� ���� �� ���۸�
			BufferedReader bf = new BufferedReader(fr);
			
			// ���۷� �� �� �� �дµ�, ���� �� ���� �ݺ�
			while((line = bf.readLine()) != null) {
				System.out.println(line);
			}
			// ���� ���� �ݱ�
			bf.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// ���̳ʸ� ���� read&write
	static void CopyFile(String inputFile, String outputFile) {
		final int BUFFER_SIZE = 4096;
		int readLen;
		try {
			// ����Ʈ ���� ����� ��Ʈ��
			// ���� ��θ� �Ķ���ͷ� �Է� �޴´�.
			InputStream iStream = new FileInputStream(inputFile);
			OutputStream oStream = new FileOutputStream(outputFile);
			
			// ����Ʈ �迭 ���� ����
			// ������ ������ ��ŭ �� ���� �д� ���� �õ��ϰڴٴ� ���� �ǹ��Ѵ�
			// ��ġ�� �� ���� while������ ���� ����
			byte[] buffer = new byte[BUFFER_SIZE];
			
			// ���Ϸκ��� �о ���ۿ� ���
			// iStream.read(buffer) �Է½�Ʈ�����κ��� ���� ����Ʈ���� �Ű������� �־��� ����Ʈ �迭 buffer�� ����, ���� ���� ����Ʈ �� ����
			while((readLen = iStream.read(buffer))!=-1) {
				// buffer[0]���� readLen���� ����Ʈ�� ��½�Ʈ������ �����ٴ� ���� �ǹ��Ѵ�.
				oStream.write(buffer,0,readLen);
			}
			iStream.close();
			oStream.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// ����/���丮 ����Ʈ ���
	static void FileDirList() {
		// ���丮 ����
		File directory = new File(".");
		// ������ ���丮 ���� ���ϰ� ���丮�� ����Ʈ�� ����
		File[] fList = directory.listFiles();
		
		for(File file: fList) {
			// ���丮�� ���
			if(file.isDirectory()) {
				// ���丮 �̸� ���
				System.out.println("["+file.getName()+"]");
			} else { // ���丮�� �ƴ� ��� ���� �̸� ���
				System.out.println(file.getName());
			}
		}
	}
	
	// ���ȣ���� �̿��� ���� ���� ���� Ž��
	static void FileSearchAll(String path) {
		File directory = new File(path);
		File[] fList = directory.listFiles();
		
		for(File file: fList) {
			// ������ �ٽ� �Լ� ȣ��
			if(file.isDirectory()) {
				FileSearchAll(file.getPath());
			} else {
				System.out.println(file.getName());
			}
		}
	}
}