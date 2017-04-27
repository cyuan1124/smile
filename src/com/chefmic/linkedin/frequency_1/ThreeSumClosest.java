package com.chefmic.linkedin.frequency_1;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length < 3) {
            return Integer.MAX_VALUE;
        }
        Arrays.sort(num); //�Ӵ�С����  �������㡰��binary search��
        int closet = Integer.MAX_VALUE / 2; // otherwise it will overflow for opeartion (closet-target)
        //eg:��� closetΪ���� (���target��Max_value) ��ôcloset-target ��Ϊ�������
        for (int i = 0; i < num.length - 2; i++) {
            int left = i + 1; //��ָ��
            int right = num.length - 1; //��ָ��
            while (left < right) {
                int sum = num[i] + num[left] + num[right];
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
                closet = Math.abs(sum - target) < Math.abs(closet - target) ? sum : closet;

            }
        }
        return closet;
    }
}
