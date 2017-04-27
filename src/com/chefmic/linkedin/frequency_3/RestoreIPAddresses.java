package com.chefmic.linkedin.frequency_3;

import java.util.ArrayList;

import javax.management.loading.PrivateClassLoader;

import org.omg.CORBA.PUBLIC_MEMBER;

//Given a string containing only digits, restore it by returning all possible valid IP address combinations.
//
//For example:
//Given "25525511135",
//
//return ["255.255.11.135", "255.255.111.35"]. (Order does not matter) 
//��һ��string ���������string����ɵ����еĺϷ�ip

//
//
//��������Ҫ��ȷ��ͳIP ��ַ�Ĺ����Ƿ�4��Part��ÿ��Part�Ǵ�0-255������
//
//0-255�����֣�ת�����ַ�����ÿ��Part ������һ���ַ���ɣ������ַ���ɣ�
//�����������ַ���ɡ������ֳ�Ϊ��������ˣ�dfs���֮����
//ÿһ��֦���������һ��dfs
//��������дһ��Forѭ��ÿһ���1���ַ���ʼȡһֱ��3���ַ���
//�ټ�һ��isValid�ĺ�������֤ȡ���ַ��Ƿ��ǺϷ����֣�����ǺϷ������֣�
//�����ٽ�����һ��ݹ飬��������


public class RestoreIPAddresses {

	
	
	public ArrayList<String> restoreIpAddresses(String s) {
       ArrayList<String> result=new ArrayList<String>();
       //������ɺϷ�ip��ַ
       if (s.length()<4||s.length()>12) {
	return result;}
		dfs(s,"",result,0);
       return result;
	
	}                              //��ʱ�洢δ������IP(֦��)
      private void dfs(String s,String temp, 
    		                             //ip 0��1 �� 2�� 3��
    		  ArrayList<String> result,int count){
      //��������    //count=3 ip4�ζ�������
    	  if(count==3&&isValid(s)){
    		  result.add(temp+s);
    		  return;
    	  }
    	  //dfs
      for(int i=1; i<4&&i<s.length();i++){
    	  String onePartOfIP =s.substring(0,i);//ǰ�պ� 01��02��03
          if(isValid(onePartOfIP)){
        	 //ԭstring��ȥ���õ���  //�ռ����õ���                               //һ���Ķ�
        	  dfs(s.substring(i), temp+onePartOfIP+'.', result, count+1);
               }  
            }
        }
	
	private boolean isValid(String s){
		if(s.charAt(0)=='0'){  //192.0.0.1 ���ԡ� 192.00.00.1 ������
			return s.equals("0");
		}
		Long num=Long.valueOf(s);
		return num<=255&&num>0;
	}
	
	}



