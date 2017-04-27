package com.chefmic.linkedin.frequency_2;
//Determine whether an integer is a palindrome. Do this without extra space.
//�ж�ע��һ�������ǲ��ǻ���
//�������ж���ռ� �����ǲ��Ǹ��� (���⸺������ ��������ʱ����Ӧ��ȥ�����Թ�)
//������� ��������߼�,����ǻ��ĵĻ� ��ô���int Ӧ��== reverse(int)
public class PalindromeNumber {
	  public boolean isPalindrome(int x) {
	        if(x<0){
	        	return false;
	        }
	        return x==reverse(x);
	    }

	  //eg: x=321
	  // result=0*10+ 1  x=32
	  // =1*10+2=12      x=3
	  //= 12*10+3 =123
	  
private int reverse(int x){
	int result=0;
	while(x!=0){
		result=result*10+ x%10;
		x=x/10;	}
return result;
}

}
