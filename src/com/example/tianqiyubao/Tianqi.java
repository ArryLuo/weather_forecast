package com.example.tianqiyubao;

import android.view.View;
import android.widget.ImageView;

public class Tianqi {
	private  ImageView img1,img2,img3;
	
	public Tianqi(ImageView img1, ImageView img2, ImageView img3) {
		super();
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
	}

	public  void getZhonglei(String str){
		if(str.equals("��")){
			//����
			img2.setVisibility(View.GONE);
			img3.setVisibility(View.GONE);
			img1.setImageResource(R.drawable.a_0);
		}else if(str.equals("����")){
			img2.setVisibility(View.GONE);
			img3.setVisibility(View.GONE);
			img1.setImageResource(R.drawable.a_1);
		}else if(str.contains("��ת����")){
			img3.setImageResource(R.drawable.a_1);
			img1.setImageResource(R.drawable.a_0);
		}else if(str.contains("��ת��")){
			img3.setImageResource(R.drawable.a_0);
			img1.setImageResource(R.drawable.a_2);
		}
		else if(str.equals("��")){
			img2.setVisibility(View.GONE);
			img3.setVisibility(View.GONE);
			img1.setImageResource(R.drawable.a_2);
		}else if(str.equals("����")){
			img2.setVisibility(View.GONE);
			img3.setVisibility(View.GONE);
			img1.setImageResource(R.drawable.a_3);
		}else if(str.equals("������")){
			img2.setVisibility(View.GONE);
			img3.setVisibility(View.GONE);
			img1.setImageResource(R.drawable.a_4);
		}else if(str.contains("�����겢���б���")){
			img2.setVisibility(View.GONE);
			img3.setVisibility(View.GONE);
			img1.setImageResource(R.drawable.a_5);
		}
		else if(str.contains("���ѩ ")){
			img2.setVisibility(View.GONE);
			img3.setVisibility(View.GONE);
			img1.setImageResource(R.drawable.a_6);
		}else if(str.contains("С�� ")){
			img2.setVisibility(View.GONE);
			img3.setVisibility(View.GONE);
			img1.setImageResource(R.drawable.a_7);
		}else if(str.contains("���� ")){
			img2.setVisibility(View.GONE);
			img3.setVisibility(View.GONE);
			img1.setImageResource(R.drawable.a_8);
		}else if(str.contains(" ���� ")){
			img2.setVisibility(View.GONE);
			img3.setVisibility(View.GONE);
			img1.setImageResource(R.drawable.a_9);
		}else if(str.contains("����")){
			img2.setVisibility(View.GONE);
			img3.setVisibility(View.GONE);
			img1.setImageResource(R.drawable.a_10);
		}else if(str.contains("����")){
			img2.setVisibility(View.GONE);
			img3.setVisibility(View.GONE);
			img1.setImageResource(R.drawable.a_11);
		}else if(str.contains("�ش��� ")){
			img2.setVisibility(View.GONE);
			img3.setVisibility(View.GONE);
			img1.setImageResource(R.drawable.a_12);
		}else if(str.contains("��ѩ ")){
			img2.setVisibility(View.GONE);
			img3.setVisibility(View.GONE);
			img1.setImageResource(R.drawable.a_13);
		}else if(str.contains("Сѩ")){
			img2.setVisibility(View.GONE);
			img3.setVisibility(View.GONE);
			img1.setImageResource(R.drawable.a_14);
		}else if(str.contains("��ѩ")){
			img2.setVisibility(View.GONE);
			img3.setVisibility(View.GONE);
			img1.setImageResource(R.drawable.a_15);
		}else if(str.contains("��ѩ")){
			img2.setVisibility(View.GONE);
			img3.setVisibility(View.GONE);
			img1.setImageResource(R.drawable.a_16);
		}else if(str.contains(" ��ѩ")){
			img2.setVisibility(View.GONE);
			img3.setVisibility(View.GONE);
			img1.setImageResource(R.drawable.a_17);
		}else if(str.contains("��")){
			img2.setVisibility(View.GONE);
			img3.setVisibility(View.GONE);
			img1.setImageResource(R.drawable.a_18);
		}else if(str.contains("����")){
			img2.setVisibility(View.GONE);
			img3.setVisibility(View.GONE);
			img1.setImageResource(R.drawable.a_19);
		}else if(str.contains("ɳ����")){
			img2.setVisibility(View.GONE);
			img3.setVisibility(View.GONE);
			img1.setImageResource(R.drawable.a_20);
		}else if(str.contains("С��ת����")){
			img2.setVisibility(View.GONE);
			img3.setVisibility(View.GONE);
			img1.setImageResource(R.drawable.a_21);
		}else if(str.contains("����ת���� ")){
			img2.setVisibility(View.GONE);
			img3.setVisibility(View.GONE);
			img1.setImageResource(R.drawable.a_22);
		}else if(str.contains("����ת���� ")){
			img2.setVisibility(View.GONE);
			img3.setVisibility(View.GONE);
			img1.setImageResource(R.drawable.a_23);
		}else if(str.contains("����ת����")){
			img2.setVisibility(View.GONE);
			img3.setVisibility(View.GONE);
			img1.setImageResource(R.drawable.a_24);
		}else if(str.contains("����ת�ش���  ")){
			img2.setVisibility(View.GONE);
			img3.setVisibility(View.GONE);
			img1.setImageResource(R.drawable.a_25);
		}else if(str.contains("Сѩת��ѩ   ")){
			img2.setVisibility(View.GONE);
			img3.setVisibility(View.GONE);
			img1.setImageResource(R.drawable.a_26);
		}else if(str.contains("��ѩת��ѩ")){
			img2.setVisibility(View.GONE);
			img3.setVisibility(View.GONE);
			img1.setImageResource(R.drawable.a_27);
		}else if(str.contains("��ѩת��ѩ  ")){
			img2.setVisibility(View.GONE);
			img3.setVisibility(View.GONE);
			img1.setImageResource(R.drawable.a_28);
		}else if(str.contains("����")){
			img2.setVisibility(View.GONE);
			img3.setVisibility(View.GONE);
			img1.setImageResource(R.drawable.a_29);
		}else if(str.contains("��ɳ ")){
			img2.setVisibility(View.GONE);
			img3.setVisibility(View.GONE);
			img1.setImageResource(R.drawable.a_30);
		}else if(str.contains("ǿɳ���� ")){
			img2.setVisibility(View.GONE);
			img3.setVisibility(View.GONE);
			img1.setImageResource(R.drawable.a_31);
		}
	}
}
