package com.example.orderapp1;

import java.lang.reflect.Method;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.orderapp1.util.UserService;

public class MainActivity extends Activity {
	EditText username;
	EditText password;
	private Button login,signin,finish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }
    private void findViews(){
        username = (EditText)findViewById(R.id.username) ;
        password = (EditText)findViewById(R.id.password) ;
        signin=(Button)findViewById(R.id.button1);
        login=(Button)findViewById(R.id.button2);
        finish=(Button)findViewById(R.id.button3);
        
			login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
					String name=username.getText().toString();
					String pass=password.getText().toString();
					Log.i("TAG",name+"_"+pass);
					UserService uService=new UserService(MainActivity.this);
					boolean flag=uService.login(name, pass);
					if(flag){
						Log.i("TAG","登录成功");
						Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_LONG).show();
						Intent intent=new Intent(MainActivity.this,menu.class);
						startActivity(intent);
					}else{
						Log.i("TAG","登录失败");
						Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_LONG).show();
					
				}
				
			}
		});
		
        
        signin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this,signup.class);
				startActivity(intent);
			}
		});
        finish.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			finish();
			}
		});
    }
    private void setIconVisible(Menu menu) {

		try {

			Class<?> clazz = Class
					.forName("com.android.internal.view.menu.MenuBuilder");
			// 未知的类
			Method m = clazz.getDeclaredMethod("setOptionalIconsVisible",

			boolean.class);

			m.setAccessible(true);

			m.invoke(menu, true);
			// MenuBuilder实现Menu接口，创建菜单时，传进来的menu其实就是MenuBuilder对象(java的多态特征)
		} catch (Exception e) {

			e.printStackTrace();

		}

	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        setIconVisible(menu);
        return true;
    }
    
}