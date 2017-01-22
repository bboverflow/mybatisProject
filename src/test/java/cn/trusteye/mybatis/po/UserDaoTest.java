package cn.trusteye.mybatis.po;

import cn.trusteye.mybitis.dao.UserDaoImp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * Created by Rayman on 2017/1/13.
 */
public class UserDaoTest {
    SqlSessionFactory sqlSessionFactory;
    UserDaoImp userDaoImp;
    @Before
    public void Inital() throws Exception {
        String resource = "sqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        userDaoImp = new UserDaoImp(sqlSessionFactory);
    }

    @Test
    public void testSelectUserById() throws Exception {
        User user = userDaoImp.getUserByID(1);
        System.out.println(user);
    }
}
