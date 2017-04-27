package com.chefmic.linkedin.other;

import org.junit.Test;

/**
 * Created by cyuan on 4/16/17.
 */
public class BaseConvert {

    private String binary(int num) {
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(num % 2);
            num /= 2;
        } while (num > 0);

        return sb.reverse().toString();
    }

    @Test
    public void test() {
        System.out.println(binary(6));
    }

}
