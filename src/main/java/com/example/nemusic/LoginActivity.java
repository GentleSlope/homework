package com.example.nemusic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText accountEdit;
    private EditText passWordEdit;
    private SharedPreferences pref;
    private CheckBox rememberPass;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null)
        { actionBar.hide(); }
        accountEdit=findViewById(R.id.account_edit);
        passWordEdit=findViewById(R.id.password_edit);
        ImageButton backBtn=findViewById(R.id.back_btn);
        Button loginbtn=findViewById(R.id.login_btn);
        pref=getSharedPreferences("login_data",MODE_PRIVATE);
        rememberPass=findViewById(R.id.remember_pass);
        boolean isRemember=pref.getBoolean("remember_password",false);
        if(isRemember){
            String account=pref.getString("account","###");
            String password=pref.getString("password","###");
            accountEdit.setText(account);
            passWordEdit.setText(password);
            rememberPass.setChecked(true);
        }
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent=new Intent(LoginActivity.this,MainActivity.class);*/
                /*startActivity(intent);*/
                finish();
            }
        });
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(accountEdit.getText().length()==0) {
                    Toast.makeText(LoginActivity.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                }
                String account=accountEdit.getText().toString();
                String password=passWordEdit.getText().toString();
                String accountRegister=pref.getString("account","###");
                String passwordRegister=pref.getString("password","###");
                if(accountEdit.getText().length()==0){
                    Toast.makeText(LoginActivity.this,"请输入账号",Toast.LENGTH_SHORT).show();
                }
                else if(accountEdit.getText().length()<11){
                    Toast.makeText(LoginActivity.this,"手机号不能少于11位",Toast.LENGTH_SHORT).show();
                }
                else if(passWordEdit.getText().length()==0){
                    Toast.makeText(LoginActivity.this,"请输入密码",Toast.LENGTH_SHORT).show();
                }
                else if(passWordEdit.getText().length()<6){
                    Toast.makeText(LoginActivity.this,"密码不能少于6位",Toast.LENGTH_SHORT).show();
                }
                else if(account.equals(accountRegister)&&password.equals(passwordRegister)){
                    editor=pref.edit();
                    if(rememberPass.isChecked()){
                        editor.putBoolean("remember_password",true);
                        editor.putString("account",account);
                        editor.putString("password",password);
                    }
                    else{
                        editor.clear();
                    }
                    editor.apply();
                    Toast.makeText(LoginActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(LoginActivity.this,"账号或密码错误",Toast.LENGTH_SHORT).show();


            }
        });
    }
}
