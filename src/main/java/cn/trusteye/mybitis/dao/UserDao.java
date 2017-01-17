package cn.trusteye.mybitis.dao;

import cn.trusteye.mybitis.po.User;

/**
 * Created by Rayman on 2017/1/12.
 * 普通DAO实现接口定义
 */
public interface UserDao {
    public User getUserByID(int id) throws Exception;
    public User getUserByName(String name) throws Exception;
    public void InsertUser(User user) throws Exception;
    public void deleteUser(int id) throws Exception;
}
