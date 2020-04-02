
public class Demo {
	/**
	 * 测试git的使用
	 * 用于爬虫，爬取小说main方法
	 * TwoDemo爬虫类
	 */
	public static void main(String[] args) {
		TwoDemo demoOne = new TwoDemo();
		try {
			demoOne.Jsoup();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
