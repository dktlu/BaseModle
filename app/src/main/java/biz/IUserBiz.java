package biz;

import bean.UserBean;

/**
 * Created by tao on 2016/1/4.
 */
public interface IUserBiz {
    void login(String userName, String passWord, OnLoginListener loginListener);
}
