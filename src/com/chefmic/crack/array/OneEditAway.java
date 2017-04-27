package com.chefmic.crack.array;

/**
 * Created by cyuan on 4/14/17.
 */
public class OneEditAway {

    private boolean oneEditAway(String first, String second) {
        if (first.length() == second.length()) {
            return replace(first, second);
        } else if (first.length() - second.length() == -1) {
            return remove(second, first);
        } else if (first.length() - second.length() == 1) {
            return remove(first, second);
        } else {
            return false;
        }
    }

    private boolean replace(String first, String second) {
        boolean replace = false;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (replace) {
                    return false;
                }
                replace = true;
            }
        }
        return replace;
    }

    private boolean remove(String first, String second) {
        int index = 0;
        while (index < second.length() && first.charAt(index) == second.charAt(index)) {
            index++;
        }

        return first.substring(index + 1).equals(second.substring(index));
    }

}
