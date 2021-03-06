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

	// 텍스트 파일 read&print
	static void PrintFile(String fileName) {
		String line = null;
		try {
			// 입력 스트림
			FileReader fr = new FileReader(fileName);
			// 입력 스트림으로부터 문자를 읽을 때 버퍼링
			BufferedReader bf = new BufferedReader(fr);
			
			// 버퍼로 한 줄 씩 읽는데, 끝날 때 까지 반복
			while((line = bf.readLine()) != null) {
				System.out.println(line);
			}
			// 버퍼 리더 닫기
			bf.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// 바이너리 파일 read&write
	static void CopyFile(String inputFile, String outputFile) {
		final int BUFFER_SIZE = 4096;
		int readLen;
		try {
			// 바이트 단위 입출력 스트림
			// 파일 경로를 파라미터로 입력 받는다.
			InputStream iStream = new FileInputStream(inputFile);
			OutputStream oStream = new FileOutputStream(outputFile);
			
			// 바이트 배열 버퍼 생성
			// 지정한 사이즈 만큼 한 번에 읽는 것을 시도하겠다는 것을 의미한다
			// 넘치면 그 다음 while문에서 읽을 것임
			byte[] buffer = new byte[BUFFER_SIZE];
			
			// 파일로부터 읽어서 버퍼에 담기
			// iStream.read(buffer) 입력스트림으로부터 읽은 바이트들을 매개값으로 주어진 바이트 배열 buffer에 저장, 실제 읽은 바이트 수 리턴
			while((readLen = iStream.read(buffer))!=-1) {
				// buffer[0]부터 readLen개의 바이트를 출력스트림으로 보낸다는 것을 의미한다.
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
	
	// 파일/디렉토리 리스트 출력
	static void FileDirList() {
		// 디렉토리 설정
		File directory = new File(".");
		// 설정한 디렉토리 내의 파일과 디렉토리를 리스트에 저장
		File[] fList = directory.listFiles();
		
		for(File file: fList) {
			// 디렉토리인 경우
			if(file.isDirectory()) {
				// 디렉토리 이름 출력
				System.out.println("["+file.getName()+"]");
			} else { // 디렉토리가 아닌 경우 파일 이름 출력
				System.out.println(file.getName());
			}
		}
	}
	
	// 재귀호출을 이용한 하위 폴더 파일 탐색
	static void FileSearchAll(String path) {
		File directory = new File(path);
		File[] fList = directory.listFiles();
		
		for(File file: fList) {
			// 폴더면 다시 함수 호출
			if(file.isDirectory()) {
				FileSearchAll(file.getPath());
			} else {
				System.out.println(file.getName());
			}
		}
	}
}
