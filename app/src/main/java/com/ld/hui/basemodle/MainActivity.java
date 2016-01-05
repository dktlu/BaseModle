package com.ld.hui.basemodle;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import bean.UserBean;
import presenter.UserLoginPresenter;
import view.IUserLoginView;

public class MainActivity extends Activity implements IUserLoginView {

    private EditText etUserName, etPassWord;
    private Button mBtnLogin, mBtnClear;
    private ProgressBar mPbLoading;
    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        etUserName = (EditText) findViewById(R.id.et_user);
        etPassWord = (EditText) findViewById(R.id.et_pass);

        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnClear = (Button) findViewById(R.id.btn_clear);

        mPbLoading = (ProgressBar) findViewById(R.id.pb_loading);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.login();
            }
        });

        mBtnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.clear();
            }
        });
    }

    @Override
    public String getUserName() {
        return etUserName.getText().toString();
    }

    @Override
    public String getPassWord() {
        return etPassWord.getText().toString();
    }

    @Override
    public void clearUserName() {
        etUserName.setText("");
    }

    @Override
    public void clearPassWord() {
        etPassWord.setText("");
    }

    @Override
    public void showLoading() {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(UserBean userBean) {
        Toast.makeText(this, userBean.getUsername() +
                " login success, to MainActivity" , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailError() {
        Toast.makeText(this,
                "login failed" , Toast.LENGTH_SHORT).show();
    }
}
