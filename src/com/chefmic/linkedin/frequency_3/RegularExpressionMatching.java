package com.chefmic.linkedin.frequency_3;
//Implement regular expression matching with support for '.' and '*'.
//
//'.' Matches any single character.
//'*' Matches zero or more of the preceding element.
//
//The matching should cover the entire input string (not partial).
//
//The function prototype should be:       
//bool isMatch(const char *s, const char *p)
//
//Some examples:
//isMatch("aa","a") �� false
//isMatch("aa","aa") �� true
//isMatch("aaa","aa") �� false
//isMatch("aa", "a*") �� true
//isMatch("aa", ".*") �� true
//isMatch("ab", ".*") �� true
//isMatch("aab", "c*a*b") �� true

// ����һ��Ҫ������,x*��һ����һ���bundle��a* ����˼ �� ��a*�� ���� ���Դ���0~n�� a
// �ȷ�˵ //isMatch("aab", "c*a*b") ��  c*���Դ��� 0��c a*���� 2��a ���� aab ����ȫƥ������
//�����Ǹ�stringֻҪ����ǰ���Ǹ��Ϳ���
//Ҫp (pattern)�������� s ���ܷ����ΰ���
public class RegularExpressionMatching {

	 public boolean isMatch(String s, String p) {
	    return isM(s, p,0,0);
		 }
	                                       //i j ��ʾ Ŀǰ��鵽s��iλ��p��jλ
	 private boolean isM(String s,String p,int i,int j){
		 if(j>=p.length()){  //j>p.length() p�Ѿ�����
			 return i>=s.length(); //���s��û���� �ǿ϶�false
			 }
		 if(j==p.length()-1){ //��p��鵽���һ��charʱ��
			       //sҲҪ�����һ��char����ƥ����p
			 return (i==s.length()-1)&&(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.');
		 }
		 //���pattern��һ���ַ�j+1����*
		 if (j+1<p.length()&&p.charAt(j+1)!='*') {
			if(i==s.length()){  //������Ѿ�����,��˵����ƥ�䡣
				return false;
			}
		if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.'){  //��һ��ƥ������
			return isM(s, p, i+1, j+1);  //������һ���ַ��ж�
		}else{ //��ǰs�� ��ƥ�� 
			return false;
		}
	 }
	//�����if(&p.charAt(j+1)!='*') �Ѿ���p ����j+1��*��ʱ����˵���  
    // ��ʱ pattern����һ���ַ�j+1��*
  while(i<s.length()&&j<p.length()&&(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.')){
	  //��Ϊ ��ʱjƥ������ j+1��* ���� ֱ��iλ�� j+2 λ����ı� 
	  //Ȼ�� whileֱ��i+1λ�� j+2 λ����ı� i+2   i+3.... �� һ��match�Ͼ�return true
	  //Ϊʲô����ֱ����i+1λ����iλ�أ�
	  //�ȷ�˵ aabc ȥmatch a*aabc ��ô�� aa��a* match�ϵ�ʱ��  ���ֱ����abcȥmatch aabc �ǲ�����ȫƥ��� ����Ҫ��ÿһ�ֿ�����
	  //����Ҫ̽��ÿһ�ֿ����� ��i��ʼ ������i+1
	  if(isM(s, p, i, j+2)){
		return true;
	  }
	  i++;
  }
  // �����һ���ַ�(j+1)��* �� ��ǰ�ַ���ƥ�䣬�Ͳ���while�� ��pattern�����������ͺñ� c*a*b ����c*���������Ƚ� ����  
  // ����һ���������������������һ�γ��ԣ�i==s.length()��  
  return isM(s, p, i, j+2);
			
  }
	 }
		 
 
	    	
	
	
//	public static void main(String[] args) {
//		  System.out.println(isMatch("aa", "a*"));        // true  
//	        System.out.println(isMatch("aa", "a"));     // false  
//	        System.out.println(isMatch("aa", "aa"));    // true  
//	        System.out.println(isMatch("aaa", "aa"));   // false  
//	        System.out.println(isMatch("aa", "a*"));    //true  
//	        System.out.println(isMatch("aa", ".*"));    // true  
//	        System.out.println(isMatch("ab", ".*"));    // true  
//	        System.out.println(isMatch("aab", "c*a*b"));        // true  
//	          
//	        System.out.println(isMatch("", "bab"));         // false  
//	        System.out.println(isMatch("ab", ".*c"));       // false  
//	        System.out.println(isMatch("aaa", "a.a"));      // true  
//	        System.out.println(isMatch("a", "."));          // true  
//	        System.out.println(isMatch("a", "ab*"));        // true  
//	        System.out.println(isMatch("bb", ".bab"));      // false  
//	        System.out.println(isMatch("bb", "*"));         // false           

	



//
//
//public boolean isMatch(String s, String p) {
//    if(p==null){return false;}  
//    //�ݹ�Ľ�������  ��p�Ѿ���substring���� s��û����
//	 if(p.length()==0){
//   	   return s.length()==0;
//      }
//	 //���pattern�Ѿ��ߵ����һ���ַ�������p�ڶ�����ĸ����*(��Ϊ*����ƥ��0�ַ�)��
//	 //�����ƥ�䣬��s��iҲ���������һ���������  
//	 if(p.length()==1||p.charAt(1)!='*'){
//		  if(s.length()<1||(p.charAt(0)!='.'&&p.charAt(0)!=s.charAt(0))){
//			  return false;
//		  } 
//		  //��Ϊ�Ѿ�ȷ����һλ����'*'�� ����substring���p��һλҲ������*
//		  return isMatch(s.substring(1), p.substring(1));
//	 }else{
//		 int i=-1;
//		 while(i<s.length()&&(i<0||p.charAt(0)=='.'||p.charAt(0)==s.charAt(i))){
//			 if(isMatch(s.substring(i+1), p.substring(2))){
//				 return true;}
//				 i++;
//			 }
//		 return false;
//		 }
//	 }
//
