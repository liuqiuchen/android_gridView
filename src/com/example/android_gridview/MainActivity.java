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

//�ӿ�ʵ�ּ�����
public class MainActivity extends Activity implements OnItemClickListener {
	//����GridView����
	private GridView gridView;
	//���巺��
	private List<Map<String, Object>>dataList;//List�����еĶ�����һ��Map����,�����Map����ļ���String����,ֵ��Object����
	//ͼƬ��Դ
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
	//ͼƬ����
	private String[] icon_name = {
			"ͨѶ¼","����","�����","ʱ��","��Ϸ","����","����","����","����","����","�����","��Ƶ"
	};
	//����һ����������
	private SimpleAdapter simpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        gridView = (GridView) findViewById(R.id.gridView);
        
        //1.׼������Դ
        //2.�½���������SimpleAdapter��
        //3.GridView����������
        //4.GridView����ʱ���������onItemClickListener��
        
        //�½�����Դ�ļ��ϣ�ʵ�������ͣ���
        dataList = new ArrayList<Map<String,Object>>();
        
        simpleAdapter = new SimpleAdapter(	this, 
        									getData(), 
							        		R.layout.item, 
							        		new String[]{"image","text"}, 
							        		new int[]{R.id.image,R.id.text}
        				);
        
        //����������
        gridView.setAdapter(simpleAdapter);
        
        //����GridView����ļ�����
        gridView.setOnItemClickListener(this);
        
    }

	private List<Map<String,Object>> getData() {
		// TODO Auto-generated method stub

		//�������
		for (int i = 0; i < icon.length; i++) {
			Map<String, Object>map = new HashMap<String, Object>();
			map.put("image", icon[i]);
			map.put("text", icon_name[i]);
			
			//����������ݵ�map��ӵ�ʵ�������ķ�����
			dataList.add(map);
		}
		
		
		return dataList;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "����" + icon_name[position], Toast.LENGTH_SHORT).show();
	}


}


