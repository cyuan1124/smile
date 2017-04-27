package com.chefmic.linkedin.frequency_2;

import javax.swing.text.StyledEditorKit.ForegroundAction;
//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//Each element in the array represents your maximum jump length at that position.
//
//Your goal is to reach the last index in the minimum number of jumps.
//
//For example:
//Given array A = [2,3,1,1,4]
//
//The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.) 

//�����ٵ���Ծ�����ߵ��� ���ټ�����
//�����㷨DPģ��
//һά����Ԥ���� steps[0]=0; �ߵ�i��������Ҫ �� steps[i]��
//��ʼ 	steps[0]=0;
//Ȼ��2��forѰ�� �ⲿ �Ǳ���steps i~N
//��ѭ�� �Ǵ�0��j Ȼ��   ��0--j--n--A.length��
//���steps[j]!=integer.max(��ʾA��Jλ�����ߵĵ���) Ȼ�� ���j+A[j]>=i 
///��ʾ A[j] ��һ�ξ��ߵĵ�A[i] ���� steps[i]=steps[j]+1;
////��Ϊj�Ǵ�С����ı��� ���Ժ�������϶���Խ��Խ���� ����break
//��������ѭ������steps[A.length-1]���ɡ�

public class JumpGame2 {
	public int jump(int[] A) {
	int[] steps= new int [A.length];
  //base case  �ߵ���0��ʽ�� 
	steps[0]=0;

for(int i=1;i<A.length;i++){
	steps[i]=Integer.MAX_VALUE;
	//�ǵ���ѭ���Ǵ�0��ʼ
	for(int j=0;j<i;j++){
		//���steps [i]=Integer.Max ˵��  û�а취�ߵ�A[i]
		//i ��j�����±�   0----j----i-----A.length
		// A[j]���� ��jλ   ���������,��� j+A[j]>=i ��ʾ jλ����һ��(����A[j]) �ܵ�i
				if(steps[j]!=Integer.MAX_VALUE&&j+A[j]>=i){
			//���� steps[j]+����1��  �����ٵ�iλ���� ����	steps[i]=steps[j]+1;
			steps[i]=steps[j]+1;
			break; //��Ϊj�Ǵ�С����ı��� ���Ժ�������϶���Խ��Խ���� ����break
		}
	}
}
return steps[A.length-1];
}
	}
