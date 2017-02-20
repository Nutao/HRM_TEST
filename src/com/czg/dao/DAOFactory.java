/**
 * 
 */
package com.czg.dao;

/**
 * @author nutao
 * @category 工厂也是设计模式中非常重要的概念。只要使用了代理，就肯定会出现接口。
 *　这时就需要使用工厂来进行耦合的操作。即使用工厂对接口进行实例化。
 */
public class DAOFactory {
	/**
	 * @param null
	 * @return DAO代理实例
	 * @throws
	 */
	public static IPersonDAO getIPersonDAOInstance(){
		return new IPersonDAOProxy();
	}
}
