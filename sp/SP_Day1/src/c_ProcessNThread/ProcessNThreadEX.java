package c_ProcessNThread;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class ProcessNThreadEX {

	// 프로세스 실행 커맨드
	public static String getProcessOutput(List<String> cmdList) throws IOException, InterruptedException{
		ProcessBuilder builder = new ProcessBuilder(cmdList);
		// 프로세스 실행
		Process process = builder.start();
		// 출력가져오기
		InputStream psout = process.getInputStream();
		byte[] buffer = new byte[1024];
		psout.read(buffer);
		return(new String(buffer));
	}
	
	public static void main(String[] args) throws IOException, InterruptedException{
		// asList = 일반 배열을 ArrayList로 변환한다.
		String output = getProcessOutput(Arrays.asList("add_2sec.exe","2","3"));
		System.out.println(output);
		
		
		// 아래에 있는 thread 클래스 실습 방법1
		ThreadClass1 tc1 = new ThreadClass1();
		tc1.start();
		
		try {
			tc1.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		// 아래에 있는 thread 클래스 실습 방법2
		ThreadClass2 tc2 = new ThreadClass2();
		Thread t2 = new Thread(tc2);
		t2.start();
		
		try {
			t2.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}

// thread를 그냥 상속 받아주는 방법 1
class ThreadClass1 extends Thread{
	public void run() {
		System.out.println("Thread is running...");
	}
}

// runnable interface이용하는 방법 2
class ThreadClass2 implements Runnable{
	public void run() {
		System.out.println("Thread is running...");
	}
}