package com.example.orderapp1;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.orderapp1.util.User;
import com.example.orderapp1.util.UserService;


public class signup extends Activity{
	Button ensure;
	EditText username;
	EditText password;
	protected void onCreate(Bundle savedInstanceState){
		 super.onCreate(savedInstanceState);
	     setContentView(R.layout.signup);
	     findViews();
	     ensure.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String name=username.getText().toString().trim();
				String pass=password.getText().toString().trim();
				Log.i("TAG",name+"_"+pass+"_");
				UserService uService=new UserService(signup.this);
				User user=new User();
				user.setUsername(name);
				user.setPassword(pass);
				uService.register(user);
				Toast.makeText(signup.this, "×¢²á³É¹¦", Toast.LENGTH_LONG).show();
				Intent intent=new Intent(signup.this,MainActivity.class);
				startActivity(intent);
			}
		});	 
	}
	private void findViews() {
		username=(EditText) findViewById(R.id.username1);
		password=(EditText) findViewById(R.id.passwoed2);
		ensure=(Button)findViewById(R.id.queren);

	}
}
