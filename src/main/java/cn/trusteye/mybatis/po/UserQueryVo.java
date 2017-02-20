package cn.trusteye.mybatis.po;

import java.util.List;

/**
 * Created by Rayman on 2017/2/17.
 */
public class UserQueryVo {
    //用户查询条件
    private UserCustom userCustom;

    //多个查询ID
    private List<Integer> ids;


    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }
}
