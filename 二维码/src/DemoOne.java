import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DemoOne {
	
	public void Jsoup(){
		
		Document doc=null;
		try {
			doc = org.jsoup.Jsoup.connect("https://xs.sogou.com/chapter/7619881134_249687923766147/").get();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Element ele = doc.getElementById("contentWp");
		String text = ele.text();
		text = text.replace(" ", "\n");
		Elements eles = doc.getElementsByTag("h1");
		String title = eles.get(0).text();
		File f=null;
		f = new File("F://小说//凡人修仙传仙界篇/"+title+".txt");
		FileWriter fw=null;
		try {
			fw = new FileWriter(f);
		} catch (IOException e) {
			File ff= new File("F://小说//凡人修仙传仙界篇/");
			/**
			 * mkdirs() 创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。可以创建多级目录
			 * mkdir() 创建此抽象路径名指定的目录。只能在已经存在的目录中创建文件夹
			 */
			if(ff.mkdirs()){
				try {
					fw = new FileWriter(f);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}else {
				
				System.out.println("文件没有创建成功！！");
			}
		}
		try {
			fw.write(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		System.out.println(title);
		
		
		
	}
	

}

	

