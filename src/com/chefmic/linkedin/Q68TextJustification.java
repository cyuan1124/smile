package com.chefmic.linkedin;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                        for (int p = 0; p < extraWhite / whiteNum; p++) {
                            line += " ";
                        }
                        if (k - i <= extraWhite % whiteNum) {
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

    public List<String> fullJustify3(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        List<String> ongoing = new ArrayList<>();
        int i = 0, length = 0;
        while (i < words.length) {
            builder.setLength(0);
            length = 0;
            ongoing.clear();
            while (i < words.length && length + words[i].length() + ongoing.size() <= maxWidth) {
                length += words[i].length();
                ongoing.add(words[i]);
                i++;
            }

            if (i == words.length) {
                // Last line
                for (String str : ongoing) {
                    builder.append(' ').append(str);
                }
                builder.deleteCharAt(0);
                int totalSpaces = maxWidth - length - (ongoing.size() - 1);
                while (totalSpaces-- > 0) {
                    builder.append(' ');
                }
                res.add(builder.toString());
            } else if (ongoing.size() == 1) {
                builder.append(ongoing.get(0));
                while (length++ < maxWidth) {
                    builder.append(' ');
                }
                res.add(builder.toString());
            } else {
                int spacesCount = maxWidth - length;
                char[] spaces = new char[spacesCount / (ongoing.size() - 1) + 1];
                Arrays.fill(spaces, ' ');
                for (int j = 0; j < spacesCount % (ongoing.size() - 1); j++) {
                    builder.append(ongoing.get(j));
                    builder.append(spaces);
                }
                for (int j = spacesCount % (ongoing.size() - 1); j < ongoing.size() - 1; j++) {
                    builder.append(ongoing.get(j));
                    builder.append(spaces, 0, spaces.length - 1);
                }
                builder.append(ongoing.get(ongoing.size() - 1));
                res.add(builder.toString());
            }
        }

        return res;
    }

    @Test
    public void test() {
        fullJustify3(new String[]{"a", "b", "c", "d", "e"}, 3)
                .forEach(System.out::println);
    }

}
