package pers.qing.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import pers.qing.pojo.Customer;

/**
 * Class name:HibernateDemo1
 * Class describe:��һ���ͻ����浽���ݿ���
 * @author heguoqing
 * Ceation time:2019��10��12������2:06:01
 * @Version:1.0
 */
public class HibernateDemo1 {
	/*
	 * ���������
	 * 	1.�����������ļ�
	 * 	2.�����������ļ�����SessionFactory
	 * 	3.ʹ��SessionFactory����Session
	 * 	4.ʹ��Session��������
	 * 	5.ִ�б���ͻ�����
	 * 	6.�ύ����
	 * 	7.�ͷ���Դ
	 * */
	@Test
	public void test1(){
		Customer c = new Customer();
		c.setCust_name("ͬ������");
		//1.�����������ļ�
		Configuration cfg = new Configuration();
		cfg.configure();
		//2.�����������ļ�����SessionFactory
		SessionFactory factory = cfg.buildSessionFactory();
		//3.ʹ��SessionFactory����Session
		Session session = factory.openSession();
		//4.ʹ��Session��������
		Transaction ts = session.beginTransaction();
		//5.ִ�б���ͻ�����
		session.save(c);
		//6.�ύ����
		ts.commit();
		//7.�ͷ���Դ
		session.close();
		factory.close();
	}
}
