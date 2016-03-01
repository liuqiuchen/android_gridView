package com.example.android_gridview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

//接口实现监听器
public class MainActivity extends Activity implements OnItemClickListener {
	//创建GridView对象
	private GridView gridView;
	//定义泛型
	private List<Map<String, Object>>dataList;//List集合中的对象是一个Map对象,而这个Map对象的键是String类型,值是Object类型
	//图片资源
	private int[] icon = {	R.drawable.address_book,
							R.drawable.calendar,
							R.drawable.camera,
							R.drawable.clock,
							R.drawable.games_control,
							R.drawable.messenger,
							R.drawable.ringtone,
							R.drawable.settings,
							R.drawable.speech_balloon,
							R.drawable.weather,
							R.drawable.world,
							R.drawable.youtube
						 };
	//图片名称
	private String[] icon_name = {
			"通讯录","日历","照相机","时钟","游戏","短信","铃声","设置","语音","天气","浏览器","视频"
	};
	//声明一个简单适配器
	private SimpleAdapter simpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        gridView = (GridView) findViewById(R.id.gridView);
        
        //1.准备数据源
        //2.新建适配器（SimpleAdapter）
        //3.GridView加载适配器
        //4.GridView配置时间监听器（onItemClickListener）
        
        //新建数据源的集合（实例化泛型）：
        dataList = new ArrayList<Map<String,Object>>();
        
        simpleAdapter = new SimpleAdapter(	this, 
        									getData(), 
							        		R.layout.item, 
							        		new String[]{"image","text"}, 
							        		new int[]{R.id.image,R.id.text}
        				);
        
        //加载适配器
        gridView.setAdapter(simpleAdapter);
        
        //设置GridView点击的监听器
        gridView.setOnItemClickListener(this);
        
    }

	private List<Map<String,Object>> getData() {
		// TODO Auto-generated method stub

		//填充数据
		for (int i = 0; i < icon.length; i++) {
			Map<String, Object>map = new HashMap<String, Object>();
			map.put("image", icon[i]);
			map.put("text", icon_name[i]);
			
			//把填充完数据的map添加到实例化过的泛型里
			dataList.add(map);
		}
		
		
		return dataList;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "我是" + icon_name[position], Toast.LENGTH_SHORT).show();
	}


}


