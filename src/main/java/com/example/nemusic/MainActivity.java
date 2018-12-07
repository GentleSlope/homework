package com.example.nemusic;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null)
        { actionBar.hide(); }
        setContentView(R.layout.activity_main);
        final Button loginbtn=findViewById(R.id.btn_login);
        Button registor=findViewById(R.id.btn_register);
        ImageButton weixiBtn=findViewById(R.id.ibtn_weixin);
        ImageButton wbBtn=findViewById(R.id.ibtn_weibo);
        ImageButton qqBtn=findViewById(R.id.ibtn_qq);
        ImageButton wyBtn=findViewById(R.id.ibtn_wyyx);

        registor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        weixiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "微信登陆", Toast.LENGTH_SHORT).show();
            }
        });
        qqBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "QQ登陆", Toast.LENGTH_SHORT).show();
            }
        });
        wbBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "微博登陆", Toast.LENGTH_SHORT).show();
            }
        });
        wyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "网易登陆", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
