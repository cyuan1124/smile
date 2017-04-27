package com.chefmic.linkedin.frequency_3;

public class SearchA2DMatrix {

//�ڶ���log(m+n)����
	
	 public boolean searchMatrix2(int[][] matrix, int target) {
		 int rows=matrix.length;
		 int cols=matrix[0].length;
		 int start=0;
		 //�������ά��������1ά  1 2
		 //                     3 4 
		 //��� 1 2 3 4 �� ����sorted��  ���Կ�������binary search
		 int end=rows*cols-1;  //ends����һά�����end��
		 while(start<=end){
			 int mid=start+(end-start)/2;
			 //��1ά�� index����ӳ�䵽2ά��
			 if(matrix[mid/cols][mid%cols]==target){
				 return true;
			 }else if(matrix[mid/cols][mid%cols]>target){ //��һά�����ǰ���
				 end=mid-1;
			 }else{
				 start=mid+1;
			 }
		 }
		 return false;
	 }
	
	
	
	
	// ��һ����ά������������ ccԭ�� ���������ʵ��sorted�� --ÿ��sort ��һ����С����һ�����
	// [
	// [1, 3, 5, 7],
	// [10, 11, 16, 20],
	// [23, 30, 34, 50]
	// ]
	//
	// Given target = 3, return true.
	// ccԭ�� �������Ǳ����һ�� ���target����С��ɨ�豾��

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || (matrix.length == 0 && matrix[0].length == 0)) {
			return false;
		}

		int row = matrix.length;
		int column = matrix[0].length;
		int currentRow = 0;
		int currentColumn = column - 1;

		// ���ѭ��������target��ÿһ�е�����
		// ������ھ���true
		// ���target��row���� ��˵�� �� target��������һ�� ����currentRow++
		// ���target��row���С ��˵��target�����ڱ��� ����currentColumn--
		// ����while�� ���ҵ�����false
		while (currentRow < row - 1 && currentColumn >= 0) {
			if (matrix[currentRow][currentColumn] == target) {
				return true;
			} else if (matrix[currentRow][currentColumn] > target) {
				currentColumn--;
			} else {
				currentRow++;
			}

		}

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
