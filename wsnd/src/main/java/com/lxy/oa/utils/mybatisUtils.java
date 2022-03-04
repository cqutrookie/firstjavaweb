package com.lxy.oa.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.function.Function;

public class mybatisUtils {
    private static SqlSessionFactory sqlSessionFactory = null;

    static {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Object executeQuery(Function<SqlSession, Object> function) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            Object obj = function.apply(sqlSession);
            return obj;
        } finally {
            sqlSession.close();
        }
    }

    public static Object executeQueryUpdate(Function<SqlSession, Object> function) {
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        try {
            Object obj = function.apply(sqlSession);
            sqlSession.commit();
            return obj;
        }
        catch (RuntimeException e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return null;
    }
}
