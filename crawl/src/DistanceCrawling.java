import java.io.IOException;

import javax.swing.text.html.parser.Element;
import org.jsoup.*;
import org.jsoup.helper.*;
import org.jsoup.internal.*;
import org.jsoup.nodes.*;
import org.jsoup.parser.*;
import org.jsoup.safety.*;
import org.jsoup.select.*;

public class DistanceCrawling {

	public static void main(String[] args) throws IOException {
		
		// 1. URL connect, 결과 얻기
		Document daumMap1 = Jsoup.connect("http://map.daum.net").get();
		Document daumMap2 = Jsoup.connect("http://map.daum.net").post();
		
		Connection.Response response = Jsoup.connect("http://map.daum.net")
				.method(Connection.Method.GET)
				.execute();
		Document daumMap3 = response.parse();
		
		// 2. HTML Document 확인하기 or system.out.println(doc.toString());
		String daumMap1html = daumMap1.html();
		String daumMap1text = daumMap1.text();
		String daumMap2html = daumMap2.html();
		String daumMap2text = daumMap2.text();
		String daumMap3html = daumMap3.html();
		String daumMap3text = daumMap3.text();
		
//		System.out.println(daumMap3html);
//		System.out.println(daumMap3text);
		
		// 3. 얻어온 결과에서 특정 값 뽑아내기
		org.jsoup.nodes.Element btn = daumMap3.select("input[id=info.route.waypointSuggest.input0]").first();
		System.out.println(btn);
	}

}
