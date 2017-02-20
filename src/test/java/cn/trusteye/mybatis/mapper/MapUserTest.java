package cn.trusteye.mybatis.mapper;

import cn.trusteye.mybatis.po.User;
import cn.trusteye.mybatis.po.UserCustom;
import cn.trusteye.mybatis.po.UserQueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
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

    @Test
    public void TestfindUserResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserByIdResultMap(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void TestFindUserList() throws Exception{
        UserCustom userCustom = new UserCustom();
        userCustom.setUsername("小军");
        userCustom.setSex("1");
        UserQueryVo userQueryVo = new UserQueryVo();
        userQueryVo.setUserCustom(userCustom);

        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(16);
        ids.add(32);
        userQueryVo.setIds(ids);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<UserCustom> userList = userMapper.findUserList(userQueryVo);

        for(UserCustom user:userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

}
