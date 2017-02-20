/**
 * 
 */
package com.czg.hrm;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.czg.dao.DAOFactory;
import com.czg.view.InputData;

/**
 * @author nutao
 * @category 对数据进行处理，然后交由工DAOFactory厂加工，进行相应的操作。
 */
public class PersonOperate {
//	数据插入操作
	public static void insert(){
		Person person = new Person();
		InputData in = new InputData();
//		输入
		String name = in.getString("请输入员工的姓名：");
		int age = in.getInt("请输入员工的年龄：", "年龄必须是数字，谢谢！");
		Date date = in.getDate("请输入员工的生日（xxxx-xx-xx）：", "输入格式错误");
		String address = in.getString("请输入人员住址：");
//		将接收到的输入存到Person对象中
		person.setName(name);
		person.setAge(age);
		person.setBirthday(date);
		person.setAddress(address);
//		将该对象存储到数据库中
		try {
			DAOFactory.getIPersonDAOInstance().doCreate(person);
			System.out.println("员工信息添加成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("员工信息添加失败！！！！！");
			e.printStackTrace();
		}		
	}
	
//	数据更新操作
	public static void update(){
//		先将需要更改的记录查询出来，再进行更改
		Person person = null;
		InputData in = new InputData();
//		根据编号查出该记录
		int pid = in.getInt("请输入需要修改的员工的编号：", "请输入正确的编号");
		try {
			person = DAOFactory.getIPersonDAOInstance().findByID(pid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(person != null){
//			更改记录中的信息
			String name = in.getString("请输入新的姓名（原来的姓名是："+person.getName()+"):");
			int age = in.getInt("请输入新的年龄（原来的年龄是："+person.getAge()+"):", "年龄必须是数字，谢谢！");
			Date date = in.getDate("请输入新的生日（原来的生日是："+person.getBirthday()+"):", "输入格式错误");
			String address = in.getString("请输入新的地址（原来的地址是："+person.getAddress()+"):");
			person.setName(name);
			person.setAge(age);
			person.setBirthday(date);
			person.setAddress(address);
			
			try {
				DAOFactory.getIPersonDAOInstance().doUpdate(person);
				System.out.println("员工信息更新成功");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("员工信息更新出错！！！");
				e.printStackTrace();
			}
		}else{
			System.out.println("未查到此人的信息");
		}
	}
	
//	数据删除操作
	public static void delete(){
		InputData in = new InputData();
		int pid = in.getInt("请输入员工的编号：", "编号必须是数字，谢谢！");
		try {
			DAOFactory.getIPersonDAOInstance().doDelete(pid);
			System.out.println("员工信息删除成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("员工信息删除出错！！！");
		}
	}
	
//	打印所有的记录
	public static void findall(){
		List<Person> ls = null;
		try {
			ls = DAOFactory.getIPersonDAOInstance().findAll("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(ls != null){
			Iterator<Person> it = ls.iterator();
			System.out.println("＝＝＝＝＝＝＝＝所有员工信息如下＝＝＝＝＝＝＝");
			System.out.println(" 用户ID" + "\t\t" + "用户名" + "\t\t" + "年龄"+ "\t\t" + "生日"+"\t\t"+"住址");
			while (it.hasNext()) {
				Person person = (Person) it.next();
//			在Person类中重写了toString方法，所以此处可以直接进行打印			
				System.out.println(person);	
			}
			System.out.println("＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");				
		}else{
			System.out.println("数据表是空哒");
			return;
		}
	}
	
//	数据模糊匹配搜索操作
	public static void search(){
		List<Person> ls = null;
		String kw = new InputData().getString("请输入检索的关键字：");
		try {
			ls = DAOFactory.getIPersonDAOInstance().findAll(kw);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(ls != null){
			Iterator<Person> it = ls.iterator();
			System.out.println("＝＝＝＝＝＝＝＝检索信息如下＝＝＝＝＝＝＝");	
			System.out.println(" 用户ID" + "\t\t" + "用户名" + "\t\t" + "年龄"+ "\t\t" + "生日"+"\t\t"+"住址");
			while (it.hasNext()) {
				Person person = (Person) it.next();
//			在Person类中重写了toString方法，所以此处可以直接进行打印			
				System.out.println(person);	
			}
			System.out.println("＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");				
		}else{
			System.out.println("未查询到任何匹配的记录");
			return;
		}
	}
}
