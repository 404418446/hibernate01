package pers.qing.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import pers.qing.pojo.Customer;

/**
 * Class name:HibernateDemo1
 * Class describe:把一个客户保存到数据库中
 * @author heguoqing
 * Ceation time:2019年10月12日下午2:06:01
 * @Version:1.0
 */
public class HibernateDemo1 {
	/*
	 * 步骤分析：
	 * 	1.加载主配置文件
	 * 	2.根据主配置文件构建SessionFactory
	 * 	3.使用SessionFactory生产Session
	 * 	4.使用Session开启事务
	 * 	5.执行保存客户操作
	 * 	6.提交事务
	 * 	7.释放资源
	 * */
	@Test
	public void test1(){
		Customer c = new Customer();
		c.setCust_name("同方软银");
		//1.加载主配置文件
		Configuration cfg = new Configuration();
		cfg.configure();
		//2.根据主配置文件构建SessionFactory
		SessionFactory factory = cfg.buildSessionFactory();
		//3.使用SessionFactory生产Session
		Session session = factory.openSession();
		//4.使用Session开启事务
		Transaction ts = session.beginTransaction();
		//5.执行保存客户操作
		session.save(c);
		//6.提交事务
		ts.commit();
		//7.释放资源
		session.close();
		factory.close();
	}
}
