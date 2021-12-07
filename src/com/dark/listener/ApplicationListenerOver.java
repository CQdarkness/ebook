package com.dark.listener;

import com.dark.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationListenerOver implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //初始化数据库连接
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        MybatisUtil.closeSqlSession();
        ServletContextListener.super.contextInitialized(sce);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
}
