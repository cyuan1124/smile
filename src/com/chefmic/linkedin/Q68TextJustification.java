package com.chefmic.linkedin;

import org.junit.Test;

import java.util.*;

/**
 * Created by cyuan on 3/29/17.
 */
public class Q68TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<String>();

        int n = words.length;
        int i = 0;
        while (i < n) {
            int len = words[i].length();
            int j = i + 1;
            while (j < n && len + 1 + words[j].length() <= maxWidth) {
                len += 1 + words[j].length();
                j++;
            }

            String line = words[i];
            if (j == n) { // if this is the last line
                for (int k = i + 1; k < n; k++) {
                    line += " " + words[k];
                }
                while (line.length() < maxWidth) {
                    line += " ";
                }
            } else {
                int extraWhite = maxWidth - len;
                int whiteNum = j - i - 1;

                if (whiteNum == 0) { // if this line has only one word
                    while (line.length() < maxWidth) {
                        line += " ";
                    }
                } else {
                    for (int k = i + 1; k < j; k++) {
                        line += " ";
                        for (int p = 0; p < extraWhite/whiteNum; p++) {
                            line += " ";
                        }
                        if (k - i <= extraWhite%whiteNum) {
                            line += " ";
                        }
                        line += words[k];
                    }
                }
            }
            ans.add(line);

            i = j;
        }

        return ans;
    }

    @Test
    public void test() {
        fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
    }

}
