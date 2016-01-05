package biz;

import bean.UserBean;

/**
 * Created by tao on 2016/1/4.
 */
public class UserBiz implements IUserBiz {
    @Override
    public void login(final String userName, final String passWord,
                      final OnLoginListener loginListener) {
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ("dkt".equals(userName) && "123".equals(passWord)) {
                    UserBean userBean = new UserBean();
                    userBean.setUsername(userName);
                    userBean.setPassword(passWord);
                    loginListener.loginSuccess(userBean);
                } else {
                    loginListener.loginFailed();
                }
            }
        }.start();
    }
}
