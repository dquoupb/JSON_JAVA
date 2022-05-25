package f_Socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateServer {
	public static void main(String[] args) throws IOException {
		// ���� ���� ����
		ServerSocket listener = new ServerSocket(9090);
		try {
			while(true) {
				// ������ �����ϴµ� ������ ���·� ����, ��ȣ�� ������ socket�� ����
				Socket socket = listener.accept();
				try {
					// �� �غ�
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
