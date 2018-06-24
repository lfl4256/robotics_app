package com.example.lewis.jqr;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by lewis on 2018/6/18.
 */

public class LoginAct extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_head;
    private EditText et_phone;
    private EditText et_passowrd;
    private Button bt_login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_login);
        initView();
    }

    private void initView() {
        tv_head = (TextView) findViewById(R.id.tv_head);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_passowrd = (EditText) findViewById(R.id.et_passowrd);
        bt_login = (Button) findViewById(R.id.bt_login);
        tv_head.setText("登录");
        bt_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_login:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        String phone = et_phone.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "请输入账号", Toast.LENGTH_SHORT).show();
            return;
        }

        String passowrd = et_passowrd.getText().toString().trim();
        if (TextUtils.isEmpty(passowrd)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);


    }
}
