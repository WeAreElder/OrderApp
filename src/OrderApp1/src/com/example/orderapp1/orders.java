package com.example.orderapp1;


import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;



public class orders extends Activity{
	private ImageButton menu,user;
	@TargetApi(Build.VERSION_CODES.HONEYCOMB) protected void onCreate(Bundle savedInstanceState){
		 
		 super.onCreate(savedInstanceState);
	     setContentView(R.layout.order);
	     ActionBar actionBar = getActionBar();//获取ActionBar对象
		 actionBar.setDisplayShowHomeEnabled(true);//显示应用程序图标
		 actionBar.setDisplayHomeAsUpEnabled(true);//将应用程序图标转变为可点击图标，并添加一个返回箭头。
	     menu=(ImageButton)findViewById(R.id.imageButton1);
	     menu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(orders.this,menu.class);
				startActivity(intent);
				finish();
			}
		});
	     user=(ImageButton)findViewById(R.id.imageButton3);
	     user.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(orders.this,user.class);
				startActivity(intent);
				finish();
			}
		});
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case android.R.id.home:
			//创建启动MainActivity的Intent
			Intent intent=new Intent(this,MainActivity.class);
			//添加额外的Flag，将Activity栈中处于MainActivity之上的Activity弹出
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
