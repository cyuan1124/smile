package com.chefmic.leetcode;

import java.util.*;

/**
 * Created by cyuan on 1/3/17.
 */
public class Q332ReconstructItinerary {

    public static void main(String[] args) {
        String[][] tickers = new String[][]{{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}};
        System.out.println(findItinerary(tickers));
    }

    public static List<String> findItinerary(String[][] tickets) {
        LinkedList<String> res = new LinkedList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] itinerary : tickets) {
            if (!map.containsKey(itinerary[0])) {
                map.put(itinerary[0], new PriorityQueue<>());
            }
            map.get(itinerary[0]).add(itinerary[1]);
        }
        String key = "JFK";
        dfs(key, map, res);
        return res;
    }

    public static void dfs(String departure, Map<String, PriorityQueue<String>> flights, Deque<String> path) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty())
            dfs(arrivals.poll(), flights, path);
        path.addFirst(departure);
    }

}
