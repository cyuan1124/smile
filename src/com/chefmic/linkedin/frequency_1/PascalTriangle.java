package com.chefmic.linkedin.frequency_1;

import java.util.ArrayList;
//Given numRows, generate the first numRows of Pascal's triangle.
//
//For example, given numRows = 5,
//Return
//
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//]
//��������ε�n�㣨����Ƶ�0�㣬��1�У���n�㼴��n+1�У��˴�nΪ����0���ڵ���Ȼ����
//���ö�Ӧ�ڶ���ʽ\left(a+b\right)^{n}չ����ϵ����
//����ڶ���1 2 1����ָ��Ϊ2�Ķ���ʽ(a+b)^2չ����ʽa^2+2ab+b^2��ϵ����

//dp˼��,base case�� ÿ���е�һ�ж���1 ���һ�ж���1
//���� ������Ǳ�̾� ƽʱ������Ƕ�����������Ļ������е���Щֵ
//���� ���ϼ����ϣ� ��ô����ô�Ӿͺ��� ��res.get(i-1).get(j)����+res.get(i-1).get(j+1)����
//* [
//* [1],
//* [1,1],
//* [1,2,1],
//* [1,3,3,1],
//* [1,4,6,4,1]
//* ]
//*    matrix

public class PascalTriangle {

public ArrayList<ArrayList<Integer>> generate(int numRows) {
     ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
     for(int i=0;i<numRows;i++){
    	 ArrayList<Integer> currentLevel=new ArrayList<Integer>();
    	 currentLevel.add(1);
    	 if(i>0){//��һ��ʱ��i=0 ֻ��+1���� ���ý�if��  
    		 //������һ��Ŀ����ѭ�� �����ϲ��Ǳȱ�����1�� ������-1 ��Ϊÿ������߶��Ѿ���������1��
    		 for(int j=0;j<result.get(i-1).size()-1;j++){
    			 currentLevel.add(result.get(i-1).get(j)+result.get(i-1).get(j+1));
    		 }
    		 currentLevel.add(1);
    	 }
     result.add(currentLevel);
     }
     return result;
    }

}
