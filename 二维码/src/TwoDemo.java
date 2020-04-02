import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import jj.uitl.FileUtil;
/**
 * 此类是爬取小说类
 * @author lenovo
 *
 */

public class TwoDemo {
	private String url = "https://xs.sogou.com/list/7619881134";
	private String urlUtil = "https://xs.sogou.com/";
	public void Jsoup() throws Exception {
		Document doc = org.jsoup.Jsoup.connect(url)
				.userAgent("Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)")
				.get();
		Element ele =doc.select("ul.chapter").first();
		Elements eles = ele.getElementsByTag("a");
		for(int i=0;i<eles.size();i++) {
			
				String title = eles.get(i).text();
				String urlhref = urlUtil+ eles.get(i).attr("href");
				Document connectdoc = Jsoup.connect(urlhref).
				userAgent("Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)")
				.get();
				Element connectele = connectdoc.getElementById("contentWp");
				String te = connectdoc.text();
				Elements allConnectTextDoc = connectele.getElementsByTag("p");
				String textcon = allConnectTextDoc.text().replace(" ", "\n");
//				System.out.println(title);
//				System.out.println(textcon);
				new FileUtil(title,textcon);
		}
	
		
	}

}
