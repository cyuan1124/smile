package com.chefmic.linkedin.frequency_3;

//Divide two integers without using multiplication, division and mod operator. 
//������������� ���� �� �� ���� %
//��˵˵������λ���� ����
//ע�� λ����>>1����������һλ ����2
public class Divide2Integers {
	// ������ //����
	public int divide(int dividend, int divisor) {
      //���ص���int ����ȥ��С��
		if (divisor == 0 || dividend == 0) {
			return 0;
		}
		// 2������/�� false ��һ����true
		boolean nagative = (dividend < 0) ^ (divisor < 0);
		long a = Math.abs(dividend);
		long b = Math.abs(divisor);
		int finalCount = 0;
		int count = 0;
		//ע�����whileѭ�� ���ñ�������1�� 2�� 4�� 8��ȥ�ͳ���ȥ��
		//count���̵�
		while (a >= b) { // ���������ڳ���
			count = 1;
			b = Math.abs(divisor);
			long sum = b;//b�ǳ���
            //logn���㷨��ÿ�ν������������������ӿ������ٶȡ� 
			//ע��������ж� ��sum+sum<=a ����sumС�ڵ���a
			//�����������whileѭ����ʱ����sum>=a/2 
			while (sum + sum <= a) {
				//ÿ�ν������������������ӿ������ٶȡ� 
				sum = sum + sum;
				count = count + count;
			}
			//Ȼ��a-sum ʣ�µ�a������ڵ���b�Ļ�������whileѭ��
			a=a-sum;
			finalCount=finalCount+count;//���ⲿ���̼�������
		}
			if (nagative) {
				return 0 - finalCount;
			} else {
				return finalCount;
			}
		
	}
	
	//ps ������oj�� ��math��abs�͹����� ��������ܹ�
	 private long abs(int num){  
	        if(num < 0){  
	            return -(long)num;  
	        }  
	        return (long)num;  
	    }  


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
