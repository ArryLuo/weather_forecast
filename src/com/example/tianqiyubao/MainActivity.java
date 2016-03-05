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
			content.setText("城市名称:"+list.get(1)+"\n"+
					"城市温度:"+list.get(5)+"\n"
					+"天气状况:"+list.get(6)
					+"\n"
					+"穿衣指数:"+list.get(11)
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
						Toast.makeText(MainActivity.this, "城市名不能为空", 0).show();
					}
					else{
						//如果访问时间过长，会阻塞主线程,这样做可以防止
						new Thread(){
							public void run() {
								String path=base_path+URLEncoder.encode(city);
								try {
									URL url=new URL(path);
									HttpURLConnection con=(HttpURLConnection) url.openConnection();
									con.setRequestMethod("GET");
									con.setConnectTimeout(5000);
									//连接成功!
									if(con.getResponseCode()==200){
									InputStream	is=con.getInputStream();
									//解析xml
									XmlPullParser parser=Xml.newPullParser();
									//初始化解析器
									parser.setInput(is, "utf-8");
									//解析文档的类型
									int type=parser.getEventType();
									//集合存储所有的天气信息
									List<String>list=new ArrayList<>();
									//只要没有到文本末尾，就继续解析
									while(type!=XmlPullParser.END_DOCUMENT){
										//这个类型等于开始标签
										if(type==XmlPullParser.START_TAG){
											//判断标签的名称
										if("string".equals(parser.getName())){
											String str=parser.nextText();//吧这个节点的内容取出来
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
