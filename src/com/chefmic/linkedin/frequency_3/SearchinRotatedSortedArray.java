package com.chefmic.linkedin.frequency_3;

//
//                      1  
//                    1  
//                  1
//                1
//                                  1
//                                1 
//                              1
//-------------------->       <------------ÿ��Ҫô����ǰ/���ķ�֮һ���� Ҫô�����бƽ���ָ��start-end���еĺ��ķ�֮������ǰ�ķ�֮����
// ��һ��mid������ڵ�һ�� ��ô A[mid] �϶���start��
// ������ڵڶ��� �϶��� end С
//���ֵ�2�ַ� �þ����㷨ģ������ 
// ���cc 9.3

//�����㷨��BSģ������ --�Ķ� �����޷��ǰ�һ�� �����������г�2�� ǰ��θ� ���������ε� ����Ҳ������
//���ؼ�������mid=start + (end - start) / 2; ���mid���ڵ�һ�λ��ǵڶ��Ρ�
//��������ڵ�һ�β���start<=target<=mid ��˵����ǰ�ķ�֮һֱ��bs���ɡ�Else�����ں��ķ�֮�� start=mid ��
//��֮���mid�ڵڶ��� ���mid<=target<=end �����ں��ķ�֮һֱ��bs else������ǰ�ķ�֮�� Ȼ��||��
//����ǰ���Ǹ��ķ�֮��  mid���ᱻ���¼��� Ȼ�����������бƽ�  �����ģ��һ��2��if��鼴��
//
public class SearchinRotatedSortedArray {

	public int search(int[] A, int target) {
		// ������binary search�����㷨��ģ��
		int start = 0;
		int end = A.length - 1;
		int mid;
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if (A[mid] == target) {
				return mid;
			}
			// ���1 Astart��AmidС ˵��mid��ǰ���
			if (A[start] < A[mid]) {
				// �������һ��ifѭ��˵��target�ڵ�һ������start��mid֮��
				// ��ǰ�ķ�֮һ
				if (A[start] <= target && target <= A[mid]) {
					end = mid;
				} else {// ˵��targetС��start���ߴ���mid  ��֮�ں��ķ�֮��
					start = mid;
				}
			} else {// �����else����� ˵��A[start]����A[mid] A[mid]�ں���
				if (A[mid] <= target && target <= A[end]) { // ˵��A�ں��εĺ���
															// mid��end֮��
					start = mid;// ���ķ�֮һ
				} else {
					end = mid; // ��ǰ�ķ�֮��
				}
			}
		}
		if (A[start] == target) {
			return start;
		}
		if (A[end] == target) {
			return end;
		}

		return -1;

	}

}
