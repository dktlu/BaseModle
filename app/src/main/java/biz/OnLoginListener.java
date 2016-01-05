package biz;

import bean.UserBean;

/**
 * Created by tao on 2016/1/4.
 */
public interface OnLoginListener {
    void loginSuccess(UserBean userBean);

    void loginFailed();
}
