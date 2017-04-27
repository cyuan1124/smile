package com.chefmic.linkedin;

/**
 * Created by cyuan on 4/18/17.
 */
public class Q243ShortestWordDistance {

    public int shortestDistance(String[] words, String word1, String word2) {
        int i1 = -1, i2 = -1;
        int distance = words.length;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                i1 = i;
            } else if (word2.equals(words[i])) {
                i2 = i;
            }

            if (i1 != -1 && i2 != -1) {
                distance = Math.min(distance, Math.abs(i2 - i1));
            }
        }

        return distance;
    }

}
