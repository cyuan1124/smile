package com.chefmic.linkedin.frequency_5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

//Given a collection of intervals, merge all overlapping intervals.
//
//For example,
//Given [1,3],[2,6],[8,10],[15,18],
//return [1,6],[8,10],[15,18].   
//��ʵֻ�� ��һ�͵ڶ��������ں���

//��Ŀ�����interval����startС end��

//merge ���
public class MergeInterval {

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		 ArrayList<Interval> result=new ArrayList<Interval>();
	        if(intervals==null||intervals.size()<=1){
	            return intervals;
	        }
	        
	        Collections.sort(intervals,new IntervalComparator());
	        //����� ��
	        //Ūһ�� prev=0λ Ȼ�� �ʹ�1������curr�� 
	        //���curr.start>=prev.end ˵���� interval
	        //��ʱ��ֻҪ�ڱȽ�prev.end��curr.end �Ǹ�end ��͸���prev.edm
	        //��� curr.start<prev.end  ˵��û��interval
	        //ֱ��   result.add(prev); prev=curr;
	        //ѭ���������ټ�һ�μ���
	        
	       Interval prev=intervals.get(0);
	        for(int i=1;i<intervals.size();i++){
	            
	            Interval curr=intervals.get(i);
	           if(curr.start<=prev.end){
	               if(prev.end<curr.end){
	               prev.end=curr.end;
	               } 
	           }else{
	               result.add(prev);
	               prev=curr;
	           }
	       }
	        result.add(prev);
	          return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

// Definition for an interval.
class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}

}

// leetcode �������comparator
class IntervalComparator implements Comparator<Interval> {

	public int compare(Interval o1, Interval o2) {
		if (o1.start < o2.start) {
			return -1;
		}
		if (o1.start > o2.start) {
			return 1;
		}
		return 0;
	}

}
