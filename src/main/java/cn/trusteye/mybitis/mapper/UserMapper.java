package cn.trusteye.mybitis.mapper;

import cn.trusteye.mybitis.po.User;

import java.util.List;

/**
 *
 * Created by Rayman on 2017/1/12.
 * MAP DAO接口定义
*/
public interface UserMapper {
    public User findUserById(int id) throws Exception;
    public List<User> findUserByName(String name) throws Exception;

/*
    public User findUserByName(String name) throws Exception;
    public void insertUser(User user) throws Exception;
    public User deleteUser(int id) throws Exception;
    public void updateUser(User user) throws Exception;
*/
}
