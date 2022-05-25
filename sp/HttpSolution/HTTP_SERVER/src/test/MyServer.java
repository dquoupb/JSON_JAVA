package test;

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.servlet.ServletHandler;

public class MyServer {

	public static void main(String[] args) throws Exception {
		new MyServer().start();
	}

	public void start() throws Exception {
		// 서버 객체와 커넥터(http)객체 만들어준다.
		Server server = new Server();
		ServerConnector http = new ServerConnector(server);
		
		// 포트번호와 호스트 지정해준다.
		http.setHost("127.0.0.1");
		http.setPort(8080);
		// 서버 객체와 지정해준 http객체를 합쳐준다(?)
		server.addConnector(http);
		
		// 메소드를 실행하기 위해 필요한 참저정보를 담고있는 객체이다.
		ServletHandler servletHandler = new ServletHandler();
		servletHandler.addServletWithMapping(MyServlet.class, "/mypath");
		server.setHandler(servletHandler);
		
		server.start();
		server.join();
	}
}
