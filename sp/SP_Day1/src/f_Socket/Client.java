package f_Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws IOException {
		// 3서버에 connect까지 진행된다. 연결시에 소켓이 생성된다. 연결안될 경우에는 예외 발생
		Socket s = new Socket("127.0.0.1", 9090);
		BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
		//5(서버의 test 프린트에서 넘어옴)
		String answer = input.readLine();
		System.out.println(answer);
	}
}
