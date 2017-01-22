package cn.trusteye.mybatis.po;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by Rayman on 2017/1/11.
 */
public class UserTest {

    private SqlSession sqlSession;

    @Before
    public void initial() throws IOException {
        String resource = "sqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void testSelectOne(){
        User user = sqlSession.selectOne("test.findUserById",1);
        Assert.assertEquals("王五",user.getUsername());
    }

    @Test
    public void testSelectList(){
        List<User> users = sqlSession.selectList("test.findUserByName","%小明%");
        for(User user:users){
            System.out.println(user);
        }
    }

    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("王小军");
        user.setBirthday(new Date());
        user.setSex("1");
        user.setAddress("河南郑州");

        sqlSession.insert("test.insertUser",user);
        sqlSession.commit();

        System.out.println(user.getId());
    }

    @Test
    public void testDeleteUser(){
        sqlSession.delete("test.deleteUser",30);
        sqlSession.commit();
    }

    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setId(28);
        user.setUsername("王小军");
        user.setBirthday(new Date());
        user.setSex("2");
        user.setAddress("山西太原");

        sqlSession.update("test.updateUser",user);
        sqlSession.commit();
    }

    @After
    public void destroy(){
        sqlSession.close();
    }
}
