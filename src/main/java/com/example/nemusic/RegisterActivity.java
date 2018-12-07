package com.example.nemusic;

import android.content.SharedPreferences;
import android.media.Image;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private EditText accountRegister;
    private EditText passwordRegister;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
        Button register=findViewById(R.id.login_btn);
        accountRegister=findViewById(R.id.account_register);
        passwordRegister=findViewById(R.id.password_register);
        ImageButton backBtn=findViewById(R.id.back_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor=getSharedPreferences("login_data",MODE_PRIVATE).edit();
                String account=accountRegister.getText().toString();
                editor.putString("account",account);
                editor.putString("password",passwordRegister.getText().toString());
                editor.apply();
                if(accountRegister.getText().length()==0){
                    Toast.makeText(RegisterActivity.this,"请输入手机号",Toast.LENGTH_SHORT).show();
                }
                else if(accountRegister.getText().length()<11){
                    Toast.makeText(RegisterActivity.this,"手机号不能少于11位",Toast.LENGTH_SHORT).show();
                }
                else if(passwordRegister.getText().length()==0){
                    Toast.makeText(RegisterActivity.this,"请输入密码",Toast.LENGTH_SHORT).show();
                }
                else if(passwordRegister.getText().length()<6){
                    Toast.makeText(RegisterActivity.this,"密码不能少于6位",Toast.LENGTH_SHORT).show();
                }
                else{Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();}
            }
        });


    }
}
