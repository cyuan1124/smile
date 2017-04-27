package com.chefmic.linkedin.frequency_2;

import java.util.ArrayList;

//Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
//
//For example,
//Given the following matrix:
//
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//
//You should return [1,2,3,6,9,8,7,4,5]. 

//��������˳���ӡһ������  ˼·�� Spiral Matrix2 ����

public class SpiralMatrix {
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (matrix == null || matrix.length <= 0 ) {
			return result;
		}
		// ��Ϊ��,mxn�ľ��� ����
		int rows = matrix.length;
		int cols = matrix[0].length;
		int count = 0; 
		while (count * 2 < rows && count * 2 < cols) {
			// ���Ŷ�ȡ��һ�У�������ϱߣ�
			for (int i = count; i < cols - count; i++) {
				result.add(matrix[count][i]);
			} 
			for (int i = count + 1; i < rows - count; i++) {
				result.add(matrix[i][cols - count - 1]);// �ӵڶ��п�ʼ��������ұ�
			}
			// ���ֻ��һ��col/row��
			if (rows - 2 * count == 1 || cols - 2 * count == 1) {
				break;
			}
			// ������±ߴ���(�����ڶ���)���� ����
			for (int i = cols - count - 2; i >= count; i--) {
				result.add(matrix[rows - count - 1][i]);
			}
              //������������µ�������(�ӵ����ڶ������뵽�����ڶ��� )
			for (int i = rows - count - 2; i >= count + 1; i--) {
				result.add(matrix[i][count]);
			}
			count++; // ����һ��
		}
		return result;
	}

}
