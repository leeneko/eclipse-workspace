// http://tipland.tistory.com/43?category=462550

package socket;


import java.io.*;
import java.net.*;

public class Server {

	public Server() {
		try {
			ServerSocket ss = new ServerSocket(5555);
			Socket s = ss.accept();
			InetAddress userInfo = s.getInetAddress();
			String ip = userInfo.getHostAddress(); // user ip getter
//			System.out.println(ip + "접속");
			
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
			
			String message = br.readLine(); // from Client message
//			System.out.println(message);
			
			bw.write("from Server message");
			bw.flush();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// TODO: handle finally
		}
		
	}

}
