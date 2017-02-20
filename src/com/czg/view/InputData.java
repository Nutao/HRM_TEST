/**
 * 
 */
package com.czg.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author nutao
 *　用于接受输入的数据并进行处理
 */
public class InputData {
//	输入对象
	private Scanner scan = null;
	
	public InputData() {
		super();
		this.scan = new Scanner(System.in);  //，接受从命令行的输入
	}

	public int getInt(String info, String Msg){
		int temp = 0;
		System.out.println(info);//打印提示信息
		if(this.scan.hasNext()){
			temp = this.scan.nextInt(); //接受数字并存到temp中
		}else{
			System.out.println(Msg);  //
		}		
		return temp;
	}
	
	public String getString(String info){
		String str = null;
		System.out.println(info); //打印提示信息
		if(this.scan.hasNext()){
			str = this.scan.next();  //将从命令行接受的数据放入到字符串中
		}
		return str;		
	}
	
	public Date getDate(String info, String Msg){
		Date date = null;
		System.out.println(info);
		if(this.scan.hasNext("\\d{4}-\\d{2}-\\d{2}")){
			String str = this.scan.next("\\d{4}-\\d{2}-\\d{2}"); //使用正则表达式匹配输入的数据的格式
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println(Msg);
		}
		return date;
		
	}
}
