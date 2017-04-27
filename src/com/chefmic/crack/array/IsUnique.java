package com.chefmic.crack.array;

/**
 * Created by cyuan on 4/14/17.
 */
public class IsUnique {

    private boolean isUnique(String str) {
        if (str.length() > 128) {
            return false;
        }
        boolean[] seen = new boolean[128];
        for (char c : str.toCharArray()) {
            if (seen[c]) {
                return false;
            }
            seen[c] = true;
        }
        return true;
    }

}
