import java.net.*;
public class NSLookup {

	public static void main(String[] args) {
		// InetAddress 객체를 이용한 NSLookup 애플리케이션 작성
		// NSLookup 애플리케이션 컴파일한다
		// 도메인 주소를 인자로 지정해서 실행한다
		// IP 주소를 인자로 지정해서 실행한다
		
		if (args.length != 1) {
			System.out.println("IP 주소나 도메인 주소를 인자로 정하세요");
			System.exit(0);
		}
		
		InetAddress inetaddr[] = null;
		try {
			inetaddr = InetAddress.getAllByName(args[0]);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < inetaddr.length; i++) {
			System.out.println(inetaddr[i].getHostName());
			System.out.println(inetaddr[i].getHostAddress());
			System.out.println(inetaddr[i].toString());
			System.out.println("--------------------");
		}
	}

}
