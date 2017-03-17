package com.chefmic.linkedin;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by cyuan on 3/16/17.
 */
public class Q244ShortestWordDistanceII {

    public Q244ShortestWordDistanceII() {

    }

    @Test
    public void test() {
        WordDistance tester = new WordDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"});
        assertEquals(3, tester.shortest("coding", "practice"));
    }

    class WordDistance {

        Map<String, List<Integer>> indexMap;

        public WordDistance(String[] words) {
            indexMap = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                List<Integer> index = indexMap.getOrDefault(words[i], new ArrayList<>());
                index.add(i);
                indexMap.put(words[i], index);
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> index1 = indexMap.get(word1);
            List<Integer> index2 = indexMap.get(word2);

            return index1.stream()
                    .flatMapToInt(i1 -> index2.stream().map(i2 -> Math.abs(i2 - i1)).mapToInt(Integer::valueOf))
                    .min().getAsInt();

        }

    }

}
