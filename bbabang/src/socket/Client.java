// http://tipland.tistory.com/44?category=462550

package socket;


import java.io.*;
import java.net.*;

public class Client {
	
	IpDef ipdef = new IpDef();
	private String ip = ipdef.getIP();
	
	public Client() {
		try {
			Socket s = new Socket(ip, 5555);
			
			OutputStream os = s.getOutputStream();
			InputStream is = s.getInputStream();
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			bw.write("from client");
			bw.flush();
			
			String message = br.readLine(); // 서버로부터의 메시지
//			System.out.println(message);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// TODO: handle finally
		}
	}
}
