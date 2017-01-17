package cn.trusteye.mybatis.mapper;

import cn.trusteye.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Rayman on 2017/1/12.
 */
public class MapUserTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void Inial() throws Exception {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);
    }

    @Test
    public void TestGetUserByID() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findUserById(1);

        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void TestGetUserByName() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.findUserByName("%小明%");
        for(User user:users){
            System.out.println(user);
        }
        sqlSession.close();
    }
}
