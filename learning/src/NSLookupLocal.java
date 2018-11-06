import java.net.*;

public class NSLookupLocal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InetAddress inetaddr = null;
		try {
			inetaddr = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		System.out.println(inetaddr.getHostName());
		System.out.println(inetaddr.getHostAddress());
		
		System.out.println("byte [] 형식의 ip 주소 값의 출력");
		byte[] ip = inetaddr.getAddress();
		for(int i = 0; i < ip.length; i++) {
			System.out.println((int) ip[i]);
			if (i != ip.length -1)
				System.out.print(".");
		}
	}

}
