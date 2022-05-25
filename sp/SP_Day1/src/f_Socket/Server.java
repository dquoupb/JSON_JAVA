package f_Socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		// 1 ���� ������ ���� ���ε��ϰ� �������� ���־���.
		ServerSocket listener = new ServerSocket(9090);
		try {
			//2 ���ο� ������ ���� Ŭ���̾�Ʈ�� ������ ��, �������� �� ����Ǵ� ����
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
