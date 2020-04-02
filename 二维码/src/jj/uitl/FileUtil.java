package jj.uitl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 此类是文本存储类
 * 创建文件夹存储文本，标题。text
 * @author lenovo
 *
 */
public class FileUtil {
	private String text;

	public FileUtil(String title,String text) {
		super();
		this.text = text;
		// TODO Auto-generated constructor stub
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
