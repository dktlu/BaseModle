package view;

import bean.UserBean;

/**
 * Created by tao on 2016/1/4.
 */
public interface IUserLoginView {

    String getUserName();

    String getPassWord();

    void clearUserName();

    void clearPassWord();

    void showLoading();

    void hideLoading();

    void toMainActivity(UserBean userBean);

    void showFailError();
}
