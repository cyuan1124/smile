package com.chefmic.linkedin.frequency_1;

import java.util.ArrayList;

//Given an absolute path for a file (Unix-style), simplify it.
//
//For example,
//path = "/home/", => "/home"
//path = "/a/./b/../../c/", => "/c"
//
//click to show corner cases.
//Corner Cases:
//
//    Did you consider the case where path = "/../"?
//    In this case, you should return "/".
//    Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
//    In this case, you should ignore redundant slashes and return "/home/foo".

//��unix �µ�·����  ʵ���� 
//��unix�� . ��ʾ ��ǰ�ļ��� ..��ʾparent�ļ���  ��һ��/ ��ʾroot
//���� /a/./b/../../c/ --> 
//  a/����a/b/����һ���a �ٻ���һ���root/c ���Լ򻯳� /c
//֪������� ����������  "/+" ��ֺ�(���Ѿ�û�� )  �½�һ�� paths String[]
// Ȼ��ɨ��ԭ���� �����. ���߿� �Ͳ����� �����.. ��remove path���һ��
// �������������ĸ�ʹ���arraylist
//���ÿ��paths������/ ����
public class SimplifyPath {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        String[] stubs = path.split("/+"); //���� �������ܼ���/���ָ�һ��
        ArrayList<String> paths = new ArrayList<String>();
        for (String s : stubs) {
            if (s.equals("..")) {
                if (paths.size() > 0) {
                    paths.remove(paths.size() - 1);
                }
            } else if (!s.equals(".") && !s.equals("")) {
                paths.add(s);
            }
        }  //forѭ������ path ���

        for (String string : paths) {
            sb.append(string).append("/");
        }
        if (sb.length() > 1) {   //�����appendһ�� "/"
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
