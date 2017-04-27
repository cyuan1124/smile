package com.chefmic.linkedin.frequency_2;
//You are given an n x n 2D matrix representing an image.
//
//Rotate the image by 90 degrees (clockwise).
//
//Follow up:
//Could you do this in-place?
public class RotateImage {
	
//Ҫ��������ת90�ȣ���򵥵�������һ�����ת����ÿһ��ִ�л�װ��ת
	//�ϱ��Ƶ��ұߣ��ұ��Ƶ��±ߣ��±��Ƶ���ߣ�����Ƶ��ϱ�
	//����԰ѱ߸��Ƶ�һ�������У�Ȼ���Ʊߣ�������ҪO��N�� ���õ������ǰ����������н���
	//eg for i=0 to n
//	  temp=top[i];
//	  top[i]=left[i];
//	  left[i]=bottom[i];
//	  bottom[i]=right[i];
//	  right[i]=temp;
//������Ĳ�������,��ÿһ����ִ����������	
	  public void rotate(int[][] matrix) {
		 //��leetcode��������NxN�ľ���
		  int n= matrix.length;
		 //һ��4x4�ľ���������2�� ��ôһ��NxN�ľ��� layer��������N/2
		  for(int layer=0;layer<n/2;++layer){ //��ѭ�� �������
			  int first=layer;
			  int last=n-1-layer;//�±� -layer
		  for(int i=first;i<last;++i){   //first�ǲ���,i�Ǳ����е�λ��
			  int offset=i-first;//offset��λ�Ƶ���˼
		      //�����ϱ�
			  int top=matrix[first][i];
		      //���� 
			  matrix[first][i]=matrix[last-offset][first];
			  //�µ���
			  matrix[last-offset][first]=matrix[last][last-offset]; 
			  //�ҵ���
			  matrix[last][last-offset]=matrix[i][last];
			  //�ϵ���
			   matrix[i][last]=top;
		  
		  
		  }
		  
		  }
		  
		  
	  }
	  
}
