package com.chefmic.linkedin.frequency_2;

import javax.management.loading.PrivateClassLoader;

//Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
//
//The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
//A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated. 
//���һ�������Ƿ�valid ����û������
//������һ��9x9�ľ���������9��С�� Ҫ��ÿ�ж��в��ظ���1~9 �������ȱ���ǲ�������
//ÿ�� Ҳ�ǲ��ظ�1~9  �������ȱ���ǲ�������
//ÿ��С��������Ҳ�� 1~9 ����ȱ������

public class ValidSudoku {
//��������������ô��   ����� ����� ���ÿ��С���������

	public boolean isValidSudoku(char[][] board) {
    return isValidRow(board)&&isValidColumn(board)&&isValidBox(board);     
 	}
	
	//��� ���c�ǲ����Ѿ���flag����� ����ظ����ַ���false
 private boolean markFlag(boolean[] flag,char c){
	 if(c=='.'){
		 return true;
	 }
	 int index= c-'0';
	 if(flag[index]){  //���֮ǰ�Ѿ����ֹ��������
		 return false;
	 }else{
		 flag[index]=true;
		 return true;
	 }
 }
 
   //���ű������� ÿ�μ��ÿ�г䲻�ظ�
	private  boolean  isValidRow(char[][] board) {
	for(int i=0;i<9;i++){
		boolean[] flag= new boolean[10];
		for(int j=0;j<9;j++){
			if(!markFlag(flag,board[i][j])){
				return false;
			}
		}
	}
	return true;
	}
	 //���ű������� ÿ�μ��ÿ���ز��ظ�
	private boolean isValidColumn(char[][] board){
		for(int i=0;i<9;i++){
			boolean[] flag= new boolean[10];
			for(int j=0;j<9;j++){    //�ĳ�j i����
				if(!markFlag(flag,board[j][i])){
					return false;
				}
			}
		}
		return true;
		}
	//�������� �������С�Ź���䲻�ظ�
	private boolean isValidBox(char[][] board){
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				boolean[] flag=new boolean[10];
				for (int m = 0; m<3;m++) {
					for(int n=0;n<3;n++){
						if(!markFlag(flag, board[i*3+m][j*3+n])){
							return false;
						}
					}
					
				}
			}
		}
		return true;}}
