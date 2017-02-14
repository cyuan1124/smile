package com.chefmic.leetcode.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Created by cyuan on 2/12/17.
 */
public class Q179LargestNumber {

    @Test
    public void test() {
        String number = largestNumber(new int[]{824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247});
        assertEquals(number, "9609938824824769735703560743981399");

        assertEquals("543210", largestNumber(new int[]{1, 2, 3, 4, 5, 0}));
        assertEquals("12121", largestNumber(new int[]{12, 121}));
    }

    public String largestNumber(int[] nums) {
        List<String> numbers = Arrays.stream(nums).boxed().map(String::valueOf).collect(Collectors.toList());
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String num1, String num2) {
                return (num2 + num1).compareTo(num1 + num2);
            }
        };
        numbers.sort(comparator);

        return numbers.stream().reduce("", (s1, s2) ->
                s2.equals("0") && s1.equals("0") ? "0" : s1 + s2);
    }

}
