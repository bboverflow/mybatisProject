package cn.trusteye.mybatis.po;

/**
 * Created by Rayman on 2017/2/20.
 * 通过此类能够映射订单-用户的查询结果
 */
public class OrdersCustom extends Orders {
    //添加用户属性信息，resultmap
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    //添加用户属性信息,resulttype
    private String userName;
    private String sex;
    private String address;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "OrdersCustom{" +
                "userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
