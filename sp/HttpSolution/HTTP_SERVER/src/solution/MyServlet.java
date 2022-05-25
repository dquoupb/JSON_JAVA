package solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.*;

public class MyServlet extends HttpServlet {

	// 1번 답
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Request : "+ req.getRequestURL());
		
		res.setStatus(200);
		res.getWriter().write(new Date().toString());
	}
	
	// 2번 답
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Request : "+ req.getRequestURL());
		////////////////////////////////////////////////
		File destFolder = new File("./OUTPUT");
		if(!destFolder.exists()) {
		    destFolder.mkdirs(); 
		}
		
		LocalTime currentTime = LocalTime.now();
		String fname = String.format("./OUTPUT/%02d%02d%02d.json", currentTime.getHour(), currentTime.getMinute(), currentTime.getSecond());
	    // 파일에 json을 작성한다.
		PrintWriter printWriter = new PrintWriter(new FileWriter(new File(fname)));
	    
		// 버퍼로 읽어오는 것
        BufferedReader input = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String buffer;
        while ((buffer = input.readLine()) != null) {
        	printWriter.print(buffer);
        }        
		input.close();		
		printWriter.close();
		/////////////////////////////////////////////////
		
		res.setStatus(200);
		res.getWriter().write(fname + " saved!");
	}
}