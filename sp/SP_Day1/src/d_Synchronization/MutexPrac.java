package d_Synchronization;

import java.util.concurrent.locks.ReentrantLock;

class ThreadClass extends Thread { // thread 클래스를 상속받는다.
	// 상호 배제 잠금 기능을 의미한다.
	static ReentrantLock lock = new ReentrantLock();
	
	String thread_name;
	public ThreadClass(String name) {
		this.thread_name = name;
	}
	
	public void run() {
		lock.lock();
		try {
			// 프린트를 하기 전 후로 다른 스레드들을 사용할 수 없도록 lock걸어야 함
			PrintNums(thread_name);
		} finally {
			lock.unlock();
		}
	}
	
	// 실행할 내용 함수
	static void PrintNums(String str) {
		int i;
		System.out.println(str);
		
		for(i=1; i<=30; i++) {
			System.out.println(i+" ");
		}
		System.out.println();
	}
}

public class MutexPrac {
	public static void main(String[] args) throws InterruptedException {
		ThreadClass tc1 = new ThreadClass("[Thread1] ");
		ThreadClass tc2 = new ThreadClass("[Thread2] ");
		tc1.start(); 
        tc2.start();

        ThreadClass.lock.lock();
    	try {        
    		ThreadClass.PrintNums("[Main]");
    	}
    	finally
    	{
    		ThreadClass.lock.unlock();
    	}
        
        tc1.join();
        tc2.join();
	}
}
