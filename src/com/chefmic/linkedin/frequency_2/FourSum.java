package com.chefmic.linkedin.frequency_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
//Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
//
//Note:
//
//    Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a �� b �� c �� d)
//    The solution set must not contain duplicate quadruplets.
//
//    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
//
//    A solution set is:
//    (-1,  0, 0, 1)
//    (-2, -1, 1, 2)
//    (-2,  0, 0, 2)
//   ��������������4�����Һ���target����� �����Ҫ���ظ����ҵ���
//����ֵ�Ϳ��� �÷����±� 
//ģ�廯�ˣ�Ҫ���� k-sum ���Ӷ�ΪO(N^(k-1)) ����4sum ��0n3
public class FourSum {
	 public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
	        Set<ArrayList<Integer>> result= new HashSet<ArrayList<Integer>>();
	        Arrays.sort(num);
	        for(int i=0; i<num.length;i++){
	        	for(int j=i+1;j<num.length;j++){ // ������num[n]+num[]���������2 sum
	        		int m=j+1;
	        		int n= num.length-1;
	        		while(m<n){  //��ʱ�����Ѿ��ź��� 
	        			if(i!=j&&j!=m&&m!=n){ //m n ��2sumһ�� ����ָ��2ͷɨ ��С����ָ��++ �����ָ��--
	        					if(num[m]+num[n]==target-num[i]-num[j]){
	        					ArrayList<Integer> list= new ArrayList<Integer>();
	        					list.addAll(Arrays.asList(num[i],num[j],num[m],num[n]));
	        					result.add(list);
	        					m++;
	        					n--;
	        				}else if(num[m]+num[n]<target-num[i]-num[j]){
	        				m++;	        					
	        				}else{
	        					n--;
	        				}
	        			}
	        		}
	        	}
	        }
	        
	   return new ArrayList<ArrayList<Integer>>(result);     
	        
	    }
	 public static void main(String[] args) {
			int[] num = {1, 0, -1, 0, -2, 2};
			System.out.println(new FourSum().fourSum(num, 0));
		}	
}
