package com.chefmic.linkedin.other;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by cyuan on 4/3/17.
 */
public class OnlyAppearOnce {

    public List<Integer> onlyAppearOnce(int[] nums) {
        Map<Integer, Long> counts = Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return counts.keySet().stream().filter(key -> counts.get(key) == 1).collect(Collectors.toList());
    }

    @Test
    public void test() {
        onlyAppearOnce(new int[]{1, 2, 3, 5, 2, 2, 3, 4}).stream().forEach(System.out::println);
    }
}
