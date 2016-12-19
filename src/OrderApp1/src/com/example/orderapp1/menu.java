package com.example.orderapp1;



import java.util.ArrayList;
import java.util.List;

import com.example.orderapp1.R;
import com.example.orderapp1.adapter.HomeAdapter;
import com.example.orderapp1.adapter.MenuAdapter;
import com.example.orderapp1.entity.FoodData;
import com.example.orderapp1.util.food;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;


import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;




public class menu extends Activity{
	/**左侧菜单*/
    private ListView lv_menu;
    /**右侧主菜*/
    private ListView lv_home;
    private TextView tv_title,tv_name,item_product_price,item_product_num;
    private TextView num;
    private ImageButton plus;
    private ImageButton minus;
    private MenuAdapter menuAdapter;
    private HomeAdapter homeAdapter;
    private int currentItem,a=0,b=15;
    /**
     * 数据源
     */
    private List<food> foodDatas;
    private HomeAdapter adapter; //自定义适配器
    private ListView listView;   //ListView控件
    private String data[] = {"热销榜","新品套餐","便当套餐","单点菜品","饮料类","水果罐头","米饭"};
    /**
     * 里面存放右边ListView需要显示标题的条目position
     */
    private ArrayList<Integer> showTitle;
	private ImageButton order,user;
	@TargetApi(Build.VERSION_CODES.HONEYCOMB) protected void onCreate(Bundle savedInstanceState){
		 super.onCreate(savedInstanceState);
	     setContentView(R.layout.menu);
	     
	     setView();
	     setData();
	     ActionBar actionBar = getActionBar();//获取ActionBar对象
		 actionBar.setDisplayShowHomeEnabled(true);//显示应用程序图标
		 actionBar.setDisplayHomeAsUpEnabled(true);//将应用程序图标转变为可点击图标，并添加一个返回箭头。
		
	     order=(ImageButton)findViewById(R.id.imageButton2);
	     order.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(menu.this,orders.class);
				startActivity(intent);
				finish();
			}
		});
	     user=(ImageButton)findViewById(R.id.imageButton3);
	     user.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(menu.this,user.class);
				startActivity(intent);
				finish();
			}
		});
	}
	
	     private void setView() {
	         // TODO Auto-generated method stub
	         lv_menu = (ListView)findViewById(R.id.lv_menu);
	         //tv_title = (TextView)findViewById(R.id.tv_titile);
	         lv_home = (ListView)findViewById(R.id.lv_home);
	         tv_name = (TextView)findViewById(R.id.item_home_name);
	         item_product_num = (TextView)findViewById(R.id.item_product_num);
	         item_product_price = (TextView)findViewById(R.id.item_product_price);
	         
	         
	         
	         foodDatas = new ArrayList<food>();
	         for(int i =0;i < data.length; i++){
	             foodDatas.add(new food(i, data[0] + i, data[0],a,b));
	             
	         }
	         for(int i =0;i < data.length -1; i++){
	             foodDatas.add(new food(i, data[1] + i, data[1],a,b));
	         }
	         for(int i =0;i < data.length-2; i++){
	             foodDatas.add(new food(i, data[2] + i, data[2],a,b));
	         }
	         for(int i =0;i < data.length-3; i++){
	             foodDatas.add(new food(i, data[3] + i, data[3],a,b));
	         }
	         for(int i =0;i < data.length-4; i++){
	             foodDatas.add(new food(i, data[4] + i, data[4],a,b));
	         }
	         for(int i =0;i < data.length-3; i++){
	             foodDatas.add(new food(i, data[5] + i, data[5],a,b));
	         }
	         for(int i =0;i < 6; i++){
	             foodDatas.add(new food(i, data[6] + i, data[6],a,b));
	         }
	         showTitle = new ArrayList<Integer>();
	         for(int i = 0; i < foodDatas.size(); i++){
	             if( i ==0){
	                 showTitle.add(i );
	                 System.out.println(i + "dd");
	             }else if (!TextUtils.equals(foodDatas.get(i).getTitle(), foodDatas.get(i - 1).getTitle())) {
	                 showTitle.add(i );
	                 System.out.println(i + "dd");
	             }
	         }
	     }

	     private void setData() {
	         // TODO Auto-generated method stub
	         tv_title.setText(foodDatas.get(0).getTitle());
	         menuAdapter = new MenuAdapter(this);
	         homeAdapter = new HomeAdapter(this, foodDatas);
	         lv_menu.setAdapter(menuAdapter);
	         lv_home.setAdapter(homeAdapter);
	         lv_menu.setOnItemClickListener(new OnItemClickListener() {

	             @Override
	             public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
	                     long arg3) {
	                 // TODO Auto-generated method stub
	                 menuAdapter.setSelectItem(arg2);
	                 menuAdapter.notifyDataSetInvalidated();
	                 lv_home.setSelection(showTitle.get(arg2));
	                                 
	                 tv_title.setText(data[arg2]);
	                 
	             }
	         });
	         lv_home.setOnScrollListener(new OnScrollListener() {
	             private int scrollState;
	             
	             @Override
	             public void onScrollStateChanged(AbsListView view, int scrollState) {
	                 // TODO Auto-generated method stub
	                 //System.out.println("onScrollStateChanged" + "   scrollState" + scrollState);
	                 this.scrollState = scrollState;
	             }
	             
	             @Override
	             public void onScroll(AbsListView view, int firstVisibleItem,
	                     int visibleItemCount, int totalItemCount) {
	                 // TODO Auto-generated method stub
	                 if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {  
	                     return;  
	                 } 
	                 Log.d("jiejie", "onScroll" + "  firstVisibleItem" + firstVisibleItem
	                         +"  visibleItemCount" + visibleItemCount + "  totalItemCount" + totalItemCount);
	                 int current =showTitle.indexOf(firstVisibleItem );
	                 System.out.println(current + "dd"  +  firstVisibleItem);
//	                 lv_home.setSelection(current);
	                 if(currentItem != current && current >=0){
	                     currentItem = current;
	                     tv_title.setText(data[current]);
	                     menuAdapter.setSelectItem(currentItem);
	                     menuAdapter.notifyDataSetInvalidated();
	                 }
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
