package com.chefmic.linkedin.design;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HtmlParser {
    /**
     * @param content source code
     * @return a list of links
     */
    public List<String> parseUrls(String content) {
        // Write your code here
        List<String> result = new ArrayList<>();

        int index = 0;

        while ((index = content.indexOf("\"http", index)) != -1) {
            int end = content.indexOf("\"", index + 1) + 1;
            result.add(content.substring(index, end));
            index = end;
        }

        return result;
    }

    @Test
    public void test() {
        String content = "<html>\n" +
                "  <body>\n" +
                "    <div>\n" +
                "      <a href=\"http://www.google.com\" class=\"text-lg\">Google</a>\n" +
                "      <a href=\"http://www.facebook.com\" style=\"display:none\">Facebook</a>\n" +
                "    </div>\n" +
                "    <div>\n" +
                "      <a href=\"https://www.linkedin.com\">Linkedin</a>\n" +
                "      <a href = \"http://github.io\">LintCode</a>\n" +
                "    </div>\n" +
                "  </body>\n" +
                "</html>";
        parseUrls(content).stream().forEach(System.out::println);
    }
}
