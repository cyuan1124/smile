package com.chefmic.linkedin.frequency_1;
//Given a 2D binary matrix filled with 0's and 1's, 
//find the largest rectangle containing all ones and return its area. ��� 

import java.util.Stack;

public class MaximalRectangle {
//����ĿҪ��ϵ Largest Rectangle in Histogram һ��
//	char[][] matrix = {{'0', '0', '1', '0'},
//	                   {'0', '1', '1', '0'},
//	                   {'0', '1', '1', '1'},
//	                   {'1', '0', '1', '0'},
//	                   {'0', '1', '1', '1'},};
//��ԭ����1010������ֱ��ͼ����
//�ȷ�˵���������5�� ���ǵ�һ�е�ʱ�� ���ľ������  Largest Rectangle in Histogram����0010;  
//Ȼ��ڶ��в����ʱ��ͱ����  Largest Rectangle in Histogram0120; �����б�� 0231; 
//�������в����ʱ�� matrix[3][1]��[3][3]��0  ���� ��ʱhistogram �����³� 1040 
//���һ�и��³�0151  ÿ�½���һ�ж����Ե��� Largest Rectangle in Histogram�����㵱ǰ���������
//Ȼ��̬����

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length;//����
        int columns = matrix[0].length;//����
        int max = 0;
        int[][] histogram = new int[rows][columns];
//��һ�� --�൱�ڳ�ʼdp
        for (int j = 0; j < columns; j++) {
            if (matrix[0][j] == '1') {
                histogram[0][j] = 1;
            }
        }
        max = Math.max(max, largestRectangleArea(histogram[0]));
//dp���� ��ʵ�����2��forѭ���ܼ򵥾��ǰ�1010����ɸ߶� eg 0120--0231
//��ԭ����1010������ֱ��ͼ����
        for (int i = 1; i < rows; i++) { //�ӵڶ��п�ʼ
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '0') {
                    histogram[i][j] = 0;
                } else {
                    histogram[i][j] = histogram[i - 1][j] + 1;
                }
            }
            max = Math.max(max, largestRectangleArea(histogram[i]));
        }
        return max;

    }


    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;

        for (int i = 0; i <= height.length; i++) {

            int currentHeight = (i == height.length) ? -1 : height[i];

            while (!stack.isEmpty() && currentHeight <= height[stack.peek()]) {

                int h = height[stack.pop()];

                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);

        }

        return max;
    }
}
