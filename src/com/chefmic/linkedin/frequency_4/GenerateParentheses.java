package com.chefmic.linkedin.frequency_4;

import java.util.ArrayList;

public class GenerateParentheses {

    private static ArrayList<String> printpar(int l, int r, char[] str, int count, ArrayList<String> result) {

        if (l < 0 || r < 0) {
            return null;
        }

        if (l == 0 && r == 0) {
            result.add(new String(str));
        } else {
            if (l > 0) {
                str[count] = '(';
                printpar(l - 1, r, str, count + 1, result);
            }
            if (r > l) {
                str[count] = ')';
                printpar(l, r - 1, str, count + 1, result);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public ArrayList<String> generateParenthesis(int n) {
        char[] str = new char[n * 2];
        ArrayList<String> result = new ArrayList<String>();
        return printpar(n, n, str, 0, result);
    }

}
