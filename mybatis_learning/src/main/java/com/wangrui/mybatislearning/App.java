package com.wangrui.mybatislearning;



import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wangrui.mybatislearning.bean.User;
import com.wangrui.mybatislearning.dao.UserDao;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        Reader reader = Resources.getResourceAsReader("config.xml");
        SqlSessionFactory factory = factoryBuilder.build(reader);
        SqlSession session = null;
        session = factory.openSession(false);
        
        // 底层是mybatis通过代理产生了接口的实现类
        UserDao userdao = session.getMapper(UserDao.class); 
        
        System.out.println(userdao.getClass().getName());
        User u = userdao.findByID(1);
        System.out.println(u);
       
        
        session.commit();
        session.close();
        
        
        System.out.println("====================update=====================");
        //===========================
        String name = u.getUserName();
        System.out.println(name);
        
        u.setUserName(name+"a");
        
        session = factory.openSession(false);
        userdao = session.getMapper(UserDao.class);
        userdao.update(u);
        session.commit();
        session.close();
        
        //====================================================
        
        session = factory.openSession(false);
        
        // 底层是mybatis通过代理产生了接口的实现类
        userdao = session.getMapper(UserDao.class); 
        
  
        u = userdao.findByID(1);
        System.out.println(u);
       
        
        session.commit();
        session.close();
       
    }
}
