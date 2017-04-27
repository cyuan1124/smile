package com.chefmic.linkedin.frequency_4;

//A message containing letters from A-Z is being encoded to numbers using the following mapping:
//
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//
//Given an encoded message containing digits, determine the total number of ways to decode it.
//
//For example,
//Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
//
//The number of ways decoding "12" is 2.

public class DecodeWays {

    public static void main(String[] args) {
        System.out.print((new DecodeWays())
                .numDecodings("12303232434343212121222"));
    }

    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int[] f = new int[n + 1];
        f[0] = 1;
        if (isValidDecoding(s.substring(0, 1))) {
            f[1] = 1;
        } else {
            f[1] = 0;
        }

        for (int i = 2; i <= n; i++) {
            if (isValidDecoding(s.substring(i - 1, i))) {
                f[i] = f[i - 1];
            }
            if (isValidDecoding(s.substring(i - 2, i))) {
                f[i] = f[i] + f[i - 2];
            }
        }

        return f[n];

    }

    private boolean isValidDecoding(String s) {
        if (s.charAt(0) == '0') {
            return false;
        }
        int code = Integer.parseInt(s);
        return (code >= 1 && code <= 26);
    }

}
