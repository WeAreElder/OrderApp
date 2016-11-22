package com.example.orderapp1;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class signup extends Activity{
	private Button ensure;
	protected void onCreate(Bundle savedInstanceState){
		 super.onCreate(savedInstanceState);
	     setContentView(R.layout.signup);
	     ensure=(Button)findViewById(R.id.button1);
	     ensure.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(signup.this,MainActivity.class);
				startActivity(intent);
			}
		});
	}
}
