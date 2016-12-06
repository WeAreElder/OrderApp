package com.example.orderapp1;

import android.test.AndroidTestCase;
import android.util.Log;
import com.example.orderapp1.util.User;
import com.example.orderapp1.util.DatabaseHelper;
import com.example.orderapp1.util.UserService;

public class UserTest extends AndroidTestCase {
	public void datatest() throws Throwable{
		DatabaseHelper dbhepler=new DatabaseHelper(this.getContext());
		dbhepler.getReadableDatabase();
	}
	//×¢²á
	public void registerTest() throws Throwable{	
		UserService uService=new UserService(this.getContext());
		User user=new User();
		user.setUsername("renhaili");
		user.setPassword("123");
		uService.register(user);
	}
	public void loginTest() throws Throwable{
		UserService uService=new UserService(this.getContext());
		String username="renhaili";
		String password="123";
		boolean flag=uService.login(username, password);
		if(flag){
			Log.i("TAG","µÇÂ¼³É¹¦");
		}else{
			Log.i("TAG","µÇÂ¼Ê§°Ü");
		}
	}
	
}
