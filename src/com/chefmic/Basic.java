package com.chefmic;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Test
    public void filterLog() {
        File localProperties = new File("log.txt");
        try (Stream<String> stream = Files.lines(localProperties.toPath())) {
            List<String> processedLines = stream
                    .filter(line -> !line.contains("Dash.Driver"))
                    .collect(Collectors.toList());
            Files.write(localProperties.toPath(), processedLines);
        } catch (IOException e) {
        }
    }

    @Test
    public void testLoop() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        for (int i = 0; i < list.size(); i++) {
            list.remove(0);
        }
    }

    @Test
    public void calculate() {
        File localProperties = new File("nano.txt");
        try (Stream<String> stream = Files.lines(localProperties.toPath())) {
            List<Long> times = stream.map(Long::parseLong).collect(Collectors.toList());
            for (int i = 1; i < times.size(); i++) {
                System.out.println(times.get(i) - times.get(i - 1) > 0 ? "" : "------");
            }
        } catch (IOException e) {
        }
    }

}
