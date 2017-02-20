package com.czg.dao;

import java.util.List;
import com.czg.dbc.DBConnection;
import com.czg.hrm.Person;

/**
 * 使用代理模式思想设计,这个类是安排业务,使得工作更加有条理化（　⊙　ｏ　⊙　）
 * 数据库的连接和关闭操作由com.czg.dbc.DBConnection来完成
 * 具体业务的实现由com.czg.dao.IPersonDAOImplement完成
 * */

public class IPersonDAOProxy implements IPersonDAO{
	
	private DBConnection dbc= null; //数据库连接
	private IPersonDAO dao= null;
	
//	构造方法，实现对数据库的连接以及对dao对象的初始化
	public IPersonDAOProxy() {
		// TODO Auto-generated constructor stub
		this.dbc = new DBConnection();
		this.dao = new IPersonDAOImplement(this.dbc.getConnection());		
	}
	@Override
	public boolean doCreate(Person person) throws Exception{
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			flag = this.dao.doCreate(person);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		} finally {
			this.dbc.closeConnection();
		}				
		return flag;
	}

	@Override
	public boolean doUpdate(Person person) throws Exception{
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			flag = this.dao.doUpdate(person);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		} finally {
			this.dbc.closeConnection();
		}
		return flag;
	}

	@Override
	public boolean doDelete(int pid) throws Exception{
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			flag = this.dao.doDelete(pid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		} finally {
			this.dbc.closeConnection();
		}
		return flag;
	}

	@Override
	public Person findByID(int pid) throws Exception {
		// TODO Auto-generated method stub
		Person person = null;
		try {
			person = this.dao.findByID(pid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		} finally{
			this.dbc.closeConnection();
		}
		return person;
	}

	@Override
	public List<Person> findAll(String keyword) throws Exception {
		// TODO Auto-generated method stub
		List<Person> list = null;
		try {
			list = this.dao.findAll(keyword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		} finally{
			this.dbc.closeConnection();
		}
		return list;
	}

}
