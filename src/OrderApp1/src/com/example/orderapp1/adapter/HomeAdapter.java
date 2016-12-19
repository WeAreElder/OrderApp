package com.example.orderapp1.adapter;

import java.util.List;

import com.example.orderapp1.R;
import com.example.orderapp1.entity.FoodData;
import com.example.orderapp1.util.food;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * 鍙充晶涓荤晫闈istView鐨勯?傞厤鍣?
 * 
 * @author Administrator
 * 
 */
public class HomeAdapter extends BaseAdapter {
	private Context context;
	private List<food> foodDatas;
	private View.OnClickListener onAddNum;  //加商品数量接口
    private View.OnClickListener onSubNum;  //减商品数量接口
	
	public HomeAdapter(Context context, List<food> foodDatas) {
		this.context = context;
		this.foodDatas = foodDatas;
	}

	public void setOnAddNum(View.OnClickListener onAddNum){ 
       this.onAddNum = onAddNum;
    }

    public void setOnSubNum(View.OnClickListener onSubNum){
        this.onSubNum = onSubNum;
    }
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if(foodDatas!=null){
			return foodDatas.size();
		}else {		
			return 10;
		}		
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		ViewHold holder = null;
		if(arg1 == null){
			arg1 = View.inflate(context, R.layout.item_home, null);
			holder = new ViewHold();
			holder.tv_title = (TextView)arg1.findViewById(R.id.item_home_title);
			holder.tv_name = (TextView)arg1.findViewById(R.id.item_home_name);
			holder.item_product_num = (TextView) arg1.findViewById(R.id.item_product_num);
			holder.item_product_price = (TextView) arg1.findViewById(R.id.item_product_price);
			holder.item_btn_add=(ImageButton)arg1.findViewById(R.id.item_btn_add);
			holder.item_btn_add.setOnClickListener(onAddNum);
			holder.item_btn_sub = (ImageButton) arg1.findViewById(R.id.item_btn_sub);
			holder.item_btn_sub.setOnClickListener(onSubNum);
			holder.tv_name.setText(foodDatas.get(arg0).getfoodname());
			holder.item_product_num.setText(foodDatas.get(arg0).getId()+"");
			holder.item_product_price.setText(foodDatas.get(arg0).getprice() + "");
			arg1.setTag(holder);
		}else {
			holder = (ViewHold)arg1.getTag();
		}
		holder.tv_name.setText(foodDatas.get(arg0).getfoodname());
		holder.tv_title.setText(foodDatas.get(arg0).getTitle());
		
		if(arg0 == 0){
			holder.tv_title.setVisibility(View.VISIBLE);
		}else if (!TextUtils.equals(foodDatas.get(arg0).getTitle(), foodDatas.get(arg0 -1).getTitle())) {
			holder.tv_title.setVisibility(View.VISIBLE);
		}else {
			holder.tv_title.setVisibility(View.GONE);
		}
		return arg1;
	}
	private static class ViewHold{
		public TextView item_product_price;
		public TextView item_product_num;
		private TextView tv_title;
		private TextView tv_name;
		
		//商品名称，数量，总价
		
		//增减商品数量按钮
		private ImageButton item_btn_add;
		private ImageButton item_btn_sub;
	}
}
