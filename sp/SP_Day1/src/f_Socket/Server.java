package f_Socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		// 1 서버 소켓을 열고 바인딩하고 리슨까지 해주었다.
		ServerSocket listener = new ServerSocket(9090);
		try {
			//2 새로운 소켓을 생성 클라이언트가 들어왔을 때, 접속했을 때 실행되는 구문
			Socket socket = listener.accept();
			try {
				//4
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				out.println("test");
			} finally {
				socket.close();
			}
		} finally {
			listener.close();
		}
	}
}
