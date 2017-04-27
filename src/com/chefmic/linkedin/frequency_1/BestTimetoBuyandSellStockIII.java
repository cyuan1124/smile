package com.chefmic.linkedin.frequency_1;

//Say you have an array for which the ith element is the price of a given stock on day i.
//
//Design an algorithm to find the maximum profit. You may complete at most two transactions.
//
//Note:
//You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
//����0��2��
//��2������ forward[i]��[0,i]������������(�͵�һ��һ������min price Ȼ�� prices[i]-min price ׬����)
//backword[i]��[i,n]�����������(��n--���� ����max price ������� Ȼ�� max price- prices[i]׬����)
//for(int i=0;i<prices.length;i++){ //max=Math.max(max,forward[i]+backward[i]);}
// //��������i������ ���� 0~i ����һ�� i~n ����һ�� �����ظ���
public class BestTimetoBuyandSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices == null) {
            return 0;
        }
        int max = 0;
        //dp���鱣����ߺ��ұߵ����ֵ
        int[] forward = new int[prices.length]; //���� forward[i]��[0,i]������������
        int[] backward = new int[prices.length];//���� backward[i] ��[i]��n��������������
        findLocalMaxP(prices, forward, backward);
        for (int i = 0; i < prices.length; i++) {  //��������i������ ���� 0~i ����һ�� i~n ����һ�� �����ظ���
            max = Math.max(max, forward[i] + backward[i]);
        }
        return max;
    }


    private void findLocalMaxP(int[] prices, int[] forward, int[] backward) {
        forward[0] = 0;
        int min = prices[0];  //��С�����
        //����Ҽ�¼ �������
        for (int i = 1; i < forward.length; i++) {
            //ǰһ������������������

            forward[i] = Math.max(forward[i - 1], prices[i] - min);
            // i���������Ϊ��i-1�����󣩺ͣ���ǰ�����ۺ�֮ǰ�����֮��Ľϴ��Ǹ�}
            min = Math.min(min, prices[i]); //������С�����
        }
        backward[backward.length - 1] = 0;
        int max = prices[backward.length - 1]; //���������
        for (int i = backward.length - 2; i >= 0; i--) {
            //ǰһ������������������
            backward[i] = Math.max(backward[i + 1], max - prices[i]);
            max = Math.max(max, prices[i]);
        }
    }

}
