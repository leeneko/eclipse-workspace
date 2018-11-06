import java.io.IOException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GoogleSubCrawl {

	public static void main(String[] args) throws IOException {
		// https://docs.google.com/forms/d/1OslmFHGvMYmXNKpuDiUGIAz2cm9XCKlTUd44TFCRlJc/edit#responses
		
		Connection.Response response = Jsoup.connect("https://docs.google.com/forms/d/1OslmFHGvMYmXNKpuDiUGIAz2cm9XCKlTUd44TFCRlJc/edit#responses")
				.method(Connection.Method.GET)
				.execute();
		Document googlesub = response.parse();

		String googlesubhtml = googlesub.html();
//		String googlesubtext = googlesub.text();
		System.out.println(googlesubhtml);
	}

}
