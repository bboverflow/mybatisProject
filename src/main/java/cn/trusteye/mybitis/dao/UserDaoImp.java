package cn.trusteye.mybitis.dao;

import cn.trusteye.mybatis.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created by Rayman on 2017/1/12.
 * 普通DAO接口实现
 */
public class UserDaoImp implements UserDao {
    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImp(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User getUserByID(int id) throws Exception {
        SqlSession sqlSession= sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("test.findUserById",1);
        sqlSession.close();
        return user;
    }

    @Override
    public User getUserByName(String name) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("findUserByName",name);
        sqlSession.close();
        return user;
    }

    @Override
    public void InsertUser(User user) throws Exception {

    }

    @Override
    public void deleteUser(int id) throws Exception {

    }
}
