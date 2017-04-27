package com.chefmic.linkedin.frequency_4;

//Given two binary strings, return their sum (also a binary string).
//
//For example,
//a = "11"
//b = "1"
//Return "100". 
public class BinaryAdd {

    public static void main(String[] args) {
        System.out.print((new BinaryAdd()).addBinary("11", "1"));
    }

    public String addBinary(String a, String b) {
        int firstLen = a.length() - 1;
        int secondLen = b.length() - 1;
        StringBuffer result = new StringBuffer();
        int value = 0;
        int carry = 0;
        while (firstLen > -1 && secondLen > -1) {
            value = (((a.charAt(firstLen) - '0') + (b.charAt(secondLen) - '0')) + carry) % 2;
            carry = ((a.charAt(firstLen) - '0') + (b.charAt(secondLen) - '0') + carry) / 2;
            result.append(value);
            firstLen--;
            secondLen--;
        }

        if (firstLen < 0) {
            while (secondLen > -1) {
                value = (((b.charAt(secondLen) - '0')) + carry) % 2;
                carry = (((b.charAt(secondLen) - '0')) + carry) / 2;
                result.append(value);
                secondLen--;
            }
        } else {
            while (firstLen > -1) {
                value = (((a.charAt(firstLen) - '0')) + carry) % 2;
                carry = (((a.charAt(firstLen) - '0')) + carry) / 2;
                result.append(value);
                firstLen--;
            }
        }
        //Ҫע��߼���� ��� ���߶�û�� ���ǻ���һ������Ľ�λcarry��ǰ��
        if (carry != 0) {
            result.append(carry);
        }
        result = result.reverse();
        return result.toString();
    }

}