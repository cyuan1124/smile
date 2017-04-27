package com.chefmic.linkedin.frequency_1;
//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
//
//P   A   H   N
//A P L S I I G
//Y   I   R
//
//And then read line by line: "PAHNAPLSIIGYIR"
//
//Write the code that will take a string and make this conversion given a number of rows:
//
//string convert(string text, int nRows);
//
//convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR". 
/*������  123456789 3��
 * 1   5   9
 * 2 4 6 8 10
 * 3   7   11 
 * 
 * ��� 1592468103711
 *  
 */
public class ZigZagConversion {
/*һ����ѧ�� ���Բ�̫�ῼ 
 * ֱ�۵��㷨��дһ�²�ͬ�����µ����Ӿ����ҵ������ˡ�

 nRows = 2
0 2 4 6 ...    һ��zig������Ϊ��0 1  or  2 3
1 3 5 7

 nRows = 3
0   4   8  ...   һ��zig��������Ϊ 0123
1 3 5 7 9
2   6   10

 nRows = 4
0     6       12 ...  һ��zig������Ϊ��012345
1   5 7    11
2 4   8 10  
3     9
 * 
 * �۲��֪ zigSize = nRows + nRows �C 2
 * Ȼ����Ϊһ����1��n�� 
 * ��һ�о�ֻ��ÿ��zig�ĵ�һ���ַ� ���һ��Ҳֻ��ÿ��zag��
 * ���е���Щ�� (����Ϊi��) ��ô��һ���ַ����� ÿ��zig�ĵ�i���ַ�
 * �ڶ�����ir�е��ַ� ��ÿ��zig��һ���ַ���String��λ�� +zigSize �C 2*ir
 * 
 * 
 */
	
	
	
public String convert(String s, int nRows) {
   int length=s.length();
   if(length<=nRows||nRows==1){
	   return s;
   }
char[] chars=new char[length];
int step=2*nRows-2;
int count=0;
for(int i=0;i<nRows;i++){
	int interval=step-2*i;//���intervalָ���� ��һ��zig�� ��1��n-1���� ͬһ��ͬһ��zig��2����ĸ��string���λ�� 
//	 nRows = 3   eg  1��3�Ĳ�� ����step-2��i
//			 0   4   8  ...   һ��zig��������Ϊ 0123
//			 1 3 5 7 9
//			 2   6   10
	                        //ÿ��ѭ����һ�ζ����ǵ���һ��zip����
	                        //һ��forѭ����һ��zip
	for(int j=i;j<length;j=j+step){
		chars[count]=s.charAt(j);  //eg �����������1
		count++; //ÿ�β���֮�� count��++��
		//�������step�Ͳ��ڱ�zig����                      //���붼�ںϷ�λ��
		if(interval<step&&interval>0&&j+interval<length&&count<length){
			//count�Ѿ��Ƶ���һλ 
			chars[count]=s.charAt(j+interval);//eg�������������3
			count++;
		}
	}
}
return new String(chars);







}
}
