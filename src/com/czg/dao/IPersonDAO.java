/**
 * 
 */
package com.czg.dao;
import com.czg.hrm.Person;
import java.util.List;

/**
 * @author nutao
 * @category Person接口，对数据库的CRUD操作
 * DAO, DataAccessObject。一个dao就是一个数据对象(Person)
 */
public interface IPersonDAO {
	/**
	 * 数据库的增加操作
	 * @ｐaram person
	 * @return
	 * @throws Exception
	 */
	public boolean doCreate(Person person) throws Exception;
	
	/**
	 * 数据库的修改操作
	 * @ｐaram person
	 * @return
	 * @throws Exception
	 */
	public boolean doUpdate(Person person) throws Exception;
	
	/**
	 * 数据库的删除操作
	 * @ｐaram pid
	 * @return
	 * @throws Exception
	 */
	public boolean doDelete(int pid) throws Exception;
	
	/**
	 * 根据ID查询操作
	 * @ｐaram pid
	 * @return
	 * @throws Exception
	 */
	public Person findByID(int pid) throws Exception;
	
	/**
	 * 查询所有记录
	 * @ｐaram keyword
	 * @return
	 * @throws Exception
	 */
	public List<Person> findAll(String keyword) throws Exception;
}
