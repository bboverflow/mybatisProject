package cn.trusteye.mybatis.mapper;

import cn.trusteye.mybatis.po.OrdersCustom;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Rayman on 2017/2/20.
 */
public class MapOrdersCustomTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void Inial() throws Exception {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);
    }
    @Test
    public void testFindOrdersUser() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
        List<OrdersCustom> ordersCustomList = ordersMapperCustom.findOrdersUser();

        for(OrdersCustom ordersCustom : ordersCustomList){
            System.out.println(ordersCustom);
        }

        sqlSession.close();
    }

    @Test
    public void testfindOrdersUserResultMap() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
        List<OrdersCustom> ordersCustomList = ordersMapperCustom.findOrdersUserResultMap();

        for(OrdersCustom ordersCustom : ordersCustomList){
            System.out.println(ordersCustom);
        }

        sqlSession.close();
    }

}
