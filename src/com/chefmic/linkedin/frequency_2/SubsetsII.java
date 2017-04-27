package com.chefmic.linkedin.frequency_2;

import java.util.ArrayList;
import java.util.Arrays;
//Given a collection of integers that might contain duplicates, S, return all possible subsets.
//
//Note:
//
//   Elements in a subset must be in non-descending order. //����Ҫsort
//   The solution set must not contain duplicate subsets.
//
//For example,
//If S = [1,2,2], a solution is:
//
//[
// [2],
// [1],
// [1,2,2],
// [2,2],
// [1,2],
// []
//]
//�����㷨ģ�� ��premutation 2���� ���ǲ���ȫ������ ÿ�㵥���������result����
public class SubsetsII {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
 ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
ArrayList<Integer> list=new ArrayList<Integer>();
if(num==null||num.length==0){
	return result;
}
Arrays.sort(num);            //���0��ʾ��ǰ��position
subsetsHelper(result,list,num,0);
return result;
}


private void subsetsHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list,int[] num, int pos){
 //��Ϊ����permutation ȫ���� ���� ���õ�pos==num.length ���ӽ�� ÿ��Ӧ��ֱ����
	result.add(new ArrayList<Integer>(list));
	//ȥ��
	 for (int i = pos; i < num.length; i++) {
	if(i!=pos&&num[i]==num[i-1]){
		continue;}
	list.add(num[i]);
	subsetsHelper(result, list, num, i+1);
	list.remove(list.size()-1);
	 
	 
	 }
	
}


}