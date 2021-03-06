package cn.trusteye.mybatis.mapper;

import cn.trusteye.mybatis.po.User;
import cn.trusteye.mybatis.po.UserCustom;
import cn.trusteye.mybatis.po.UserQueryVo;

import java.util.List;

/**
 *
 * Created by Rayman on 2017/1/12.
 * MAP DAO接口定义
*/
public interface UserMapper {
    public User findUserById(int id) throws Exception;
    public List<User> findUserByName(String name) throws Exception;
    public User findUserByIdResultMap(int id) throws Exception;
    public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;

/*
    public User findUserByName(String name) throws Exception;
    public void insertUser(User user) throws Exception;
    public User deleteUser(int id) throws Exception;
    public void updateUser(User user) throws Exception;
*/
}
