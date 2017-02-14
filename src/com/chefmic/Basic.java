package com.chefmic;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by cyuan on 2/10/17.
 */
public class Basic {

    public static void main(String[] args) {
        testStream();
    }

    private static void testStream() {
        List<Integer> vals = Arrays.asList(1, 2, 3, null, 4, 5);
        vals.stream().filter(Objects::nonNull).forEach(System.out::println);
    }


}
