package com.czg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import com.czg.hrm.Person;

/**
 * 这个类负责接受来自com.czg.dao.IPersonDAOProxy的代理任务,并予以实现该业务.
 * 此类是本系统的核心业务代码。
 */
public class IPersonDAOImplement implements IPersonDAO {
	
	private Connection conn = null;

	public IPersonDAOImplement(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}

//	实现数据库表中dao的增加
	@Override
	public boolean doCreate(Person person) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		PreparedStatement ps = null;
//		在PreparedStatment中使用?来表示将要赋值的变量的值。
		String sql = "INSERT into person(name,age,birthday,address) VALUES(?,?,?,?)";
		try {
			ps = this.conn.prepareStatement(sql);
			ps.setString(1, person.getName());
			ps.setInt(2, person.getAge());
			ps.setDate(3,new Date(person.getBirthday().getTime()));
			ps.setString(4, person.getAddress());
			int len = ps.executeUpdate();
			if (len > 0)
				flag = true;
		} catch(Exception e){
			throw e;
		}finally {
			// TODO: handle finally clause
			ps.close();
		}
		return flag;
	}

//	实现数据表中ｄａｏ的修改
	@Override
	public boolean doUpdate(Person person) throws Exception {
		boolean flag = false;
		PreparedStatement ps = null;
		String sql = "UPDATE person SET name=?, age=?, birthday=?, address=? Where pid=?";
		try {
			ps = this.conn.prepareStatement(sql);
			ps.setString(1, person.getName());
			ps.setInt(2, person.getAge());
			ps.setDate(3, new Date(person.getBirthday().getTime()));
			ps.setString(4, person.getAddress());
			ps.setInt(5, person.getPid());
			int len = ps.executeUpdate();
			if (len > 0)
				flag = true;
		} catch (Exception e) {
			throw e;
		} finally {
			ps.close();
		}
		return flag ;
	}

//	实现数据表中ｄａｏ的删除
	@Override
	public boolean doDelete(int pid) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		PreparedStatement ps = null;
		String sql = "DELETE FROM person WHERE pid=?";
		try {
			ps = this.conn.prepareStatement(sql);
			ps.setInt(1, pid);
			int len = ps.executeUpdate();
			if (len > 0)
				flag = true;
		} catch (Exception e) {
			throw e;
		} finally {
			ps.close();
		}
		
		return flag;
	}

//	实现数据表中通过用户的id查询并取出该用户的所有信息
	@Override
	public Person findByID(int pid) throws Exception {
		Person person = null;
		PreparedStatement ps = null;
		String sql = "SELECT * from person WHERE pid=?";
		
		try {
			ps = this.conn.prepareStatement(sql);
			ps.setInt(1, pid);
			ResultSet rs = ps.executeQuery(); //执行查询，将返回的结果存到ResultSet中
//			此处用if做一次的判定，因为查询的结果只有一个
			if(rs.next()){
				person = new Person();  //将查询到的dao存储到对应的Person对象之中
				person.setPid(rs.getInt(1));
				person.setName(rs.getString(2));
				person.setAge(rs.getInt(3));
				person.setBirthday(rs.getDate(4));
				person.setAddress(rs.getString(5));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			ps.close();
		}
		return person;
	}

//	通过关键字查询所有匹配关键字的用户的讯息
	@Override
	public List<Person> findAll(String keyword) throws Exception {
		List<Person> ls =new ArrayList<Person>(); //创建一个存储对象的容器
		PreparedStatement ps = null;
		String sql = "SELECT * FROM person WHERE name LIKE ? OR age LIKE ? OR birthday LIKE ? OR address LIKE ?";
		
		try {
			ps = this.conn.prepareStatement(sql);
//		模糊查询
			ps.setString(1, "%" + keyword + "%");
			ps.setString(2, "%" + keyword + "%");
			ps.setString(3, "%" + keyword + "%");
			ps.setString(4, "%" + keyword + "%");
			
			ResultSet rs = ps.executeQuery();
			Person person = null;
//		注意此处用的while循环，因为查询的结果有多个
			while (rs.next()) {
				person = new Person();
				person.setPid(rs.getInt(1));
				person.setName(rs.getString(2));
				person.setAge(rs.getInt(3));
				person.setBirthday(rs.getDate(4));
				person.setAddress(rs.getString(5));
				ls.add(person);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			ps.close();
		}
		
		return ls;
	}

}
