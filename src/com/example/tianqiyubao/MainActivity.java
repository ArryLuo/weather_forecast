package com.example.tianqiyubao;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Xml;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private ImageView img1,img2,img3;
	private EditText city_name;
	private TextView content;
	private int success=1;
	private int error=2;
	private Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			List<String>list=(List<String>) msg.obj;
			content.setText("��������:"+list.get(1)+"\n"+
					"�����¶�:"+list.get(5)+"\n"
					+"����״��:"+list.get(6)
					+"\n"
					+"����ָ��:"+list.get(11)
					);
			Tianqi tianqi=new Tianqi(img1, img2, img3);
			tianqi.getZhonglei(list.get(6));
		};
	
	};
	private String base_path="http://www.webxml.com.cn/WebServices/WeatherWebService.asmx/getWeatherbyCityName?theCityName=";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		city_name=(EditText) findViewById(R.id.city_name);
		content=(TextView) findViewById(R.id.content);
		img1=(ImageView) findViewById(R.id.img1);
		img2=(ImageView) findViewById(R.id.img2);
		img3=(ImageView) findViewById(R.id.img3);
		findViewById(R.id.send).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			final	String city=city_name.getText().toString().trim();
					if(TextUtils.isEmpty(city)){
						Toast.makeText(MainActivity.this, "����������Ϊ��", 0).show();
					}
					else{
						//�������ʱ����������������߳�,���������Է�ֹ
						new Thread(){
							public void run() {
								String path=base_path+URLEncoder.encode(city);
								try {
									URL url=new URL(path);
									HttpURLConnection con=(HttpURLConnection) url.openConnection();
									con.setRequestMethod("GET");
									con.setConnectTimeout(5000);
									//���ӳɹ�!
									if(con.getResponseCode()==200){
									InputStream	is=con.getInputStream();
									//����xml
									XmlPullParser parser=Xml.newPullParser();
									//��ʼ��������
									parser.setInput(is, "utf-8");
									//�����ĵ�������
									int type=parser.getEventType();
									//���ϴ洢���е�������Ϣ
									List<String>list=new ArrayList<>();
									//ֻҪû�е��ı�ĩβ���ͼ�������
									while(type!=XmlPullParser.END_DOCUMENT){
										//������͵��ڿ�ʼ��ǩ
										if(type==XmlPullParser.START_TAG){
											//�жϱ�ǩ������
										if("string".equals(parser.getName())){
											String str=parser.nextText();//������ڵ������ȡ����
											list.add(str);
										}
										}
										type=parser.next();
										
									}
									Message message=new Message();
									message.obj=list;
									handler.sendMessage(message);
									}
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								
								}
							};
						}.start();
					}
			}
		});
	}
}
