package com.chefmic.linkedin.frequency_2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

//Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//
//For example,
//[1,1,2] have the following unique permutations:
//[1,1,2], [1,2,1], and [2,1,1]. 
//������һ�������ظ�������  ��Ҫ�������в��ظ���premutation
//����ʮ������ combination sum ֻ�������ø�������target�� 
public class Permutations2 {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
	        ArrayList<ArrayList<Integer>> result= new ArrayList<ArrayList<Integer>>();
	 if(num==null||num.length==0){
		 return result;
	 }   
	 ArrayList<Integer> list=new ArrayList<Integer>();
	 int[] visited=new int[num.length];
	 Arrays.sort(num);//�����������ͬ�Ķ�����
	 helper(result,list,visited,num);  //visited ��һ��ȥ�ص��ֶ� ��ֹ�����ظ�����
	 return result;
	 }
	// �ܹ�Ҳ��ֻ��list��Ϊ dfsһ����Ѻ�Ļ��档Ȼ����������ˣ�֦�⵽���� ��
	// 
 public void helper(ArrayList<ArrayList<Integer>> result,ArrayList<Integer> list, int[] visited, int[] num){
	 if(list.size()==num.length){
		 result.add(new ArrayList<Integer>(list));
		 return;
	 }
	 
	 for(int i=0;i<num.length;i++){
		 //�ظ������ ���õݹ���ȥ�� ������combination sum��
		//ΪʲôҪ i!=0&&num[i]==num[i-1]&&visited[i-1]==0
		 //�ȷ�˵ �� 112222  ��һ��dfs֦���ֻ�ᴥ��visited[i]==1
		 //���ǵ�һ��֦������ �����ϰ�ȫ����Ū�Ĳ����
		 //�����ڶ������Ժ��permutation��֦�� �ȷ�˵visited[i-1]==0 ����num[i]==num[i-1]��ô num[i-1]�Ѿ����ж�Ϊ����Ҫ����
		 //��ô������ͬ��num[i]Ҳ����Ҫ���� �����ظ� 
		 if(visited[i]==1||(i!=0&&num[i]==num[i-1]&&visited[i-1]==0)){
		 continue;
		 }
		 visited[i]=1; //�����combination sumһ��  
		 list.add(num[i]);
		 helper(result,list,visited,num);//����ݹ�� �ִ�ͷ��ʼ ���� ����Ҫ���visited 
		 list.remove(list.size()-1);
		 visited[i]=0;
	 }
	 
 }
	
	public static void main(String[] args) {
     		int[] num={1,1,1,2,2,2,3};
     		new Permutations2().permuteUnique(num);
	}

}
