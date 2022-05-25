package f_Socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateServer {
	public static void main(String[] args) throws IOException {
		// 서버 소켓 생성
		ServerSocket listener = new ServerSocket(9090);
		try {
			while(true) {
				// 소켓을 생성하는데 리스닝 상태로 만듦, 신호를 받으면 socket에 담음
				Socket socket = listener.accept();
				try {
					// 쓸 준비
					PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
					out.println(new Date().toString());
				} finally {
					socket.close();
				}
			}
		} finally {
			listener.close();
		}
	}
}
