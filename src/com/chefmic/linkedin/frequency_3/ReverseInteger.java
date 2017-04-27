package com.chefmic.linkedin.frequency_3;

//Example1: x = 123, return 321
//Example2: x = -123, return -321 
//��תint 

//��ʵ���ùܷ���ʲô�� ���
//һ��ʼres��0       ÿ�ζ����ϴεĽ����10+ x�����һλ Ȼ��x�ٳ�10
public class ReverseInteger {
	public int reverse(int x) {

		int res = 0;
		//eg x=123
		//res=0��10+123%3=3
	     // x=12
		//res=30+2=32
		//res=320+1=321
		
		while (x != 0) {
			res = res * 10 + x % 10;
			x = x / 10;
		}
		return res;
	}

}
