import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class KyungMin {

	public static void main(String[] args) throws Exception {
		while (true) {
			String target = "http://map.daum.net/?nil_profile=title&nil_src=local";
			HttpURLConnection con = (HttpURLConnection) new URL(target).openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			String temp;

			while ((temp = br.readLine()) != null) {
				if (temp.contains("출발지입력하세요")) {

					temp = temp.split("출발지입력하세요")[1].split("\";")[0];
					/*
					 * int year = Integer.parseInt(temp.substring(0, 4)); int month =
					 * Integer.parseInt(temp.substring(4, 6)); int day =
					 * Integer.parseInt(temp.substring(6, 8)); int hour =
					 * Integer.parseInt(temp.substring(8, 10)); int minute =
					 * Integer.parseInt(temp.substring(10, 12)); int second =
					 * Integer.parseInt(temp.substring(12, 14)); System.out.println(year + "년" +
					 * month + "월" + day + "일" + hour + "시" + minute + "분" + second + "초");
					 */
					// \System.out.println(temp);
					System.out.println(temp);

				}
			}
			con.disconnect();
			br.close();
			Thread.sleep(1000000);
		}
	}
}