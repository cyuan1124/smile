package com.chefmic.linkedin.frequency_3;

import java.util.ArrayList;

public class NQueen2 {


	

public boolean checkPosotion(int[] queenList,int row,int col){
	for(int preRow=0;preRow<row;preRow++){
		int preCol=queenList[preRow];
    //�����preRow��PreCol������ǰ��queen��row��col��λ�� ����loop��� 
	
		//����к���
		if(preRow==row||preCol==col){
    	 return false;
     } 
		//  ���Խ���
		if(row-preRow==col-preCol){
			return false;
		}
		//���Խ���
		if(preRow+preCol==row+col){
		 return false;
		}
	}
	
	return true;
}
	
public int solveNQueens(int n) {
	ArrayList<String[]> result=new ArrayList<String[]>();
	//��һά���潨������
	int[] queenList=new int[n];
	placeQueen(queenList,0,n,result);
	return result.size();
}

public void placeQueen(int[] queenList,int row,int n,ArrayList<String[]> result){
	//��ֹ����,��ʱ�������� ����queen sol ��queenlist�Ĵ�С��һ����
	if(row==n){
		StringBuilder[] sol=new StringBuilder[n];
		for(int i=0;i<n;i++){
			sol[i]= new StringBuilder();
			for(int j=0;j<n;j++){
				sol[i].append('.');
			}
		}
		
		for(int i=0;i<n; i++){
			               //queenList[i]���������ϵ�i row queen��λ�ã��ڵڼ��У�
			                 //sol��ҲҪ�ڵ�i�а���queenList[i]�иĳ�queen
			//i��row number sol[i] ��queenList[i]��ֵ���к�
			sol[i].setCharAt(queenList[i], 'Q');
		}
String[] ss=new String[n];
for(int i=0;i<n;i++)
{              //��StringBuffer���� ����string���飨֮����֮ǰҪbuffer����Ϊ��queen���㣩
	ss[i]=sol[i].toString();
	}
	result.add(ss);
 return;
	}
	
	for (int col = 0; col < n; col++) {// ���for��������column
		if(checkPosotion(queenList, row,col)){
			queenList[row]=col; //��pass�����λ�� ��˵�� ���������row��iλ�ÿ��Է�
		placeQueen(queenList, row+1, n,result);
		}
		}
	}	

    }