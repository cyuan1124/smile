package com.chefmic.linkedin.frequency_1;

//Write a function to find the longest common prefix string amongst an array of strings.
//��һ��string����������Ĺ���ǰ׺��
public class LongestCommonPrefix {
    // 1. Method 1, start from the first one, compare prefix with next string, until end;
    // �ѵ�һ��String ����ǰ׺ Ȼ��ÿ�ζ��ͺ����string�� Ȼ���ҳ���ͬprefix��Ϊ�µ�prefix
    //Ȼ����µ�prefix,�ٺ���һ����
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) { //�����ַ���
            int j = 0;
            //����ǰ��forѭ����i��string��jλ ��prfix�ĵ�jλһ����ʱ�� j++  ����prefix�ܼ��match���׼�λ
            while (j < strs[i].length() && j < prefix.length() && strs[i].charAt(j) == prefix.charAt(j)) {
                j++;
            }
            if (j == 0) {
                return "";
            }

            prefix = prefix.substring(0, j);
        }
        return prefix;

    }

}

