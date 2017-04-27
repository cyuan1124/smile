package com.chefmic.linkedin.frequency_3;

//There are two sorted arrays A and B of size m and n respectively. 
//Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
//median����������и�������������ô������ֵ��������ʱ�����м������������������ż���ģ���ô��������ʱ�м���������ƽ��ֵ��
//Ҫ��2���������λ��  ���� �ҵ�����Ԫ�ص���λ��
//��ô ��mergesort�� һ�����鱶 sort����m+n��/2��ʱ�������λ��
public class MedianofTwoSortedArrays {

	 public double findMedianSortedArrays(int a[], int b[]) {
	       if (a == null || b == null || (a.length + b.length) == 0) {return 0;}
			int pa = 0;
			int pb = 0;
			double median = 0;
		 
	 
		//���whileѭ�� д�ĺ�����
		//��Ϊ������median ����ֻҪ���ࡱmerge sort���������λ����
		//Ȼ������дwhileҲ���ÿ����Ǹ��������˲�����
		//ֻҪpa+pb=(A.length+B.length+1)/2 ������ �����������Ԫ���������Ļ�����median
			while (pa + pb != (a.length + b.length + 1) / 2) {
				int Ai = (pa == a.length) ? Integer.MAX_VALUE : a[pa];  
		        int Bj = (pb == b.length) ? Integer.MAX_VALUE : b[pb]; 
		        
		        if (Ai < Bj) {
		        	median = a[pa];
		        	pa++;
		        } else {
		        	median = b[pb];
		        	pb++;
		        }
			}
			if ((a.length + b.length) % 2 == 1) {
				return median;	
			} else {
				int Ai = (pa == a.length) ? Integer.MAX_VALUE : a[pa];  //paû�����Ai=a[pa]
		        int Bj = (pb == b.length) ? Integer.MAX_VALUE : b[pb]; //pbû�����Bj=b[pb]
			double median2 = (Ai < Bj) ? Ai : Bj;			
				return (median + median2) / 2;
			}
				
			}
			 
		
	

	public static void main(String[] args) {

	}

}

//
//
//if(A.length==0){
//	if ((B.length) % 2 == 1){
//		return B[(B.length) % 2+1];
//	}else{
//		return (B[(B.length) % 2]+B[(B.length) % 2+1])/2;
//	}
//}else if (B.length==0){
//	if ((A.length) % 2 == 1){
//		return A[(A.length) % 2+1];
//	}else{
//		return (A[(A.length) % 2]+A[(A.length) % 2+1])/2;
//	}
//	
//	
//}
//int lengtha = A.length;
//int lengthb = B.length;
//boolean oneTarget = false;
//
//int target = 0;
//if ((lengtha + lengthb) % 2 == 1) {
//	target = (lengtha + lengthb) / 2 + 1;
//	oneTarget = true;
//} else if ((lengtha + lengthb) % 2 == 0) {
//	target = (lengtha + lengthb) / 2; // ��������ż��������� target�� /2�� /2+1
//										// ��ƽ��ֵ
//	oneTarget = false;
//}
//int pointA = 0;
//int pointB = 0;
//int sum = 0;
//int[] merge = new int[lengtha + lengthb];
//while (pointA < lengtha && pointB < lengthb) {
//	if (A[pointA] <= B[pointB]) {
//		merge[sum] = A[pointA];
//		pointA++;
//		sum++;
//	} else {
//		merge[sum] = B[pointB];
//		pointB++;
//		sum++;
//	}
//	if (oneTarget) {
//		if (sum == target) {
//			return (double) merge[--sum];
//		} else {
//			if (sum == target) {
//				return (double) ((merge[sum] + merge[--sum]) / 2);
//			}
//		}
//	}
//}
//if (pointA >= lengtha) {// pointA�ù�
//	while (pointB < lengthb) {
//		merge[sum] = B[pointB];
//		pointB++;
//		sum++;
//		if (oneTarget) {
//			if (sum == target) {
//				return (double) merge[--sum];
//			} else {
//				if (sum == target) {
//					return (double) ((merge[sum] + merge[--sum]) / 2);
//				}
//			}
//		}
//	}
//
//} else {
//	while (pointA < lengtha) {
//		merge[sum] = A[pointA];
//		pointA++;
//		sum++;
//		if (oneTarget) {
//			if (sum == target) {
//				return (double) merge[--sum];
//			} else {
//				if (sum == target) {
//					return (double) ((merge[sum] + merge[--sum]) / 2);
//				}
//			}
//		}
//	}
//}
//return 0;
