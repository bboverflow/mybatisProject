package cn.trusteye.mybatis.mapper;

import cn.trusteye.mybatis.po.OrdersCustom;

import java.util.List;

/**
 * Created by Rayman on 2017/2/20.
 */
public interface OrdersMapperCustom {
    public List<OrdersCustom> findOrdersUser();
    public List<OrdersCustom> findOrdersUserResultMap();
}
