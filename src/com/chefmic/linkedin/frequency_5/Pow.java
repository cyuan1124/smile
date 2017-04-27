package com.chefmic.linkedin.frequency_5;
//	2��3�η� pow(2,3)
//ע��n����Ϊ�� eg:10^-2 ��1/100

//ֱ����O(lgn)����  recursive �ɳ˻�/2��ɢ���� 
public class Pow {

    public static void main(String[] args) {
        System.out.println((new Pow()).pow(2, -5));

    }

    public double pow(double x, int n) {
        if (n < 0) {
            //��ôд�ǿ��Ե� ֻҪ�����һ�μ��� �Ͼ�2^-10 =1/2^10
            return 1.0 / pow2(x, -n);
        } else {
            return pow2(x, n);
        }

    }

    public double pow2(double x, int n) {
        if (n == 0) {
            return 1;
        }

        //���ַ�˼�봦�������
        //����ָ��������� ���� 2^3*2^5=2^8
        //ͬ�� 2^8=2^4*2^4;��1��2�� Ȼ����2��4 �������ǲ���1��1����8�� lgn���Ӷȼ���
        double result = pow2(x, n / 2);
        //��Ϊn��int ���Գ�2��ȥβ�� �ȷ�2^9--9/2=4 ����Ҫ�ڳ�һ��x--2*2^4*2^4=2^9
        if (n % 2 == 1) {
            return x * result * result;
        } else {
            return result * result;
        }//else ����ż�� ��ֱ�� /2���� �����x2
    }

}

//�ڶ������� 
class Solution {
    public double pow(double x, int n) {
        if (n < 0) {
            return 1.0 / pow2(x, -n);
        } else {
            return pow2(x, n);
        }
    }

    private double pow2(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double result;
        if (n % 2 == 1) {
            result = x * pow2(x * x, n / 2);
        } else {
            result = pow2(x * x, n / 2);
        }
        return result;
    }
}
 