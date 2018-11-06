package socket;

import java.io.*;
import java.net.*;

public class TcpClientTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String serverIP = "127.0.0.1"; // localhost
			System.out.println("서버 IP : " + serverIP + " 연결 중");
			
			// 소켓을 생성하여 연결을 요청
			Socket socket = new Socket(serverIP, 5000);
			
			// 소켓의 입력스트림을 얻는다
			InputStream in = socket.getInputStream();
			// 기본형 단위로 처리하는 보조스트림
			DataInputStream dis = new DataInputStream(in);
			
			// 소켓으로부터 받은 데이터 출력
			System.out.println("서버로부터 받은 메세지 : " + dis.readUTF());
			System.out.println("연결 종료");
			
			// 스트림과 소켓을 닫는다
			dis.close();
			socket.close();
		} catch (ConnectException ce) {
			ce.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

//서버 IP : 127.0.0.1 연결 중
//서버로부터 받은 메세지 : 서버로부터의 메시지
//연결 종료
