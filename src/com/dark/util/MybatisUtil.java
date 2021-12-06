package com.dark.util;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public final class MybatisUtil {
    //SqlSessionFactoryBuilder 线程安全
    //SqlSessionFactory 线程安全
    //SqlSession 线程不安全
    private static SqlSessionFactory sqlSessionFactory = null;

    //ThreadLocal中存储的对象只在当前线程中有效，在其它线程失效。才能保存SqlSession对象是线程安全的。
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();

    static {
        try {
            //利用资源IO获取Mybatis配置信息和映射信息
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * 获取SqlSessionFactory对象，同一个应用中得到的该对象是同一个对象
     * @return
     */
    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }

    /**
     * 获取SqlSession对象，确保该对象是线程安全的
     * @return
     */
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = null;
        //从本地线程中获取该对象
        sqlSession = threadLocal.get();
        if(sqlSession==null){
            //本地线程中没有该对象，从SqlSessionFactory对象中获取
            sqlSession = getSqlSessionFactory().openSession();
            //将sqlSession对象放入本地线程中
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }

    /**
     * 关闭SqlSession对象
     */
    public static void closeSqlSession(){
        //从本地线程中获取该对象
        SqlSession sqlSession = threadLocal.get();
        if(sqlSession!=null){
            //关闭sqlSession对象
            sqlSession.close();
            //从本地线程中移除该对象
            threadLocal.remove();
        }
    }
}
