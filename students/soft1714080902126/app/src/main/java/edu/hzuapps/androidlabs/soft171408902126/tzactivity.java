package edu.hzuapps.androidlabs.soft171408902126;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class tzactivity extends AppCompatActivity {


    private Button button1, button2, button3, button4, button5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tzactivity);

        /*Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar !=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }*/
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 给bnt1添加点击响应事件
                Intent intent = new Intent(tzactivity.this, Button1activity.class);
                //启动
                startActivity(intent);
            }
        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 给bnt1添加点击响应事件
                Intent intent = new Intent(tzactivity.this, Button2activity.class);
                //启动
                startActivity(intent);
            }
        });
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tzactivity.this, Button3activity.class);
                //启动
                startActivity(intent);
            }
        });

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tzactivity.this, Button4activity.class);
                //启动
                startActivity(intent);
            }
        });
        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tzactivity.this, Button5activity.class);
                //启动
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            /*case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;*/
            case R.id.info:
                /* 新建一个Intent对象 */
                Intent intent = new Intent();
                /* 指定intent要启动的类 */
                intent.setClass(tzactivity.this, Info.class);
                /* 启动一个新的Activity */
                startActivity(intent);
                break;
            case R.id.advice:
                Toast.makeText(this, "感谢您为饭店提出的建议", Toast.LENGTH_SHORT).show();
                break;
            case R.id.location:
                /* 新建一个Intent对象 */
                Intent intent1 = new Intent();
                /* 指定intent要启动的类 */
                intent1.setClass(tzactivity.this, Location.class);
                /* 启动一个新的Activity */
                startActivity(intent1);
                break;
            default:
        }
        return true;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void save(String inputText) {
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            out = openFileOutput("data", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(inputText);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public String load(){
        FileInputStream in=null;
        BufferedReader reader=null;
        StringBuilder content = new StringBuilder();
        try{
            in = openFileInput("data");
            reader=new BufferedReader(new InputStreamReader(in));
            String line="";
            while((line = reader.readLine())!=null){
                content.append(line);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (reader!=null){
                try{
                    reader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return content.toString();
    }
}
