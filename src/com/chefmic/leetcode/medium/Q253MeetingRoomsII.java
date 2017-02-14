package com.chefmic.leetcode.medium;

import com.chefmic.leetcode.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by cyuan on 2/10/17.
 */
public class Q253MeetingRoomsII {

    public static void main(String[] args) {
        Interval[] intervals = new Interval[]{
                new Interval(0, 30),
                new Interval(5, 10),
                new Interval(15, 20)
        };
        Q253MeetingRoomsII tester = new Q253MeetingRoomsII();
        System.out.println(tester.minMeetingRooms(intervals));
    }

    class Event {
        Integer id;
        int time;
        boolean start;

        public Event(int id, int time, boolean start) {
            this.id = id;
            this.time = time;
            this.start = start;
        }
    }

    public int minMeetingRooms(Interval[] intervals) {
        List<Event> events = new ArrayList<>(intervals.length * 2);
        for (int i = 0; i < intervals.length; i++) {
            events.add(new Event(i, intervals[i].start, true));
            events.add(new Event(i, intervals[i].end, false));
        }

        Collections.sort(events, new Comparator<Event>() {
            @Override
            public int compare(Event e1, Event e2) {
                if (e1.time == e2.time) {
                    return e1.start ? 1 : -1;
                }
                return Integer.compare(e1.time, e2.time);
            }
        });

        int rooms = 0;
        List<Integer> ids = new ArrayList<>();
        for (Event event : events) {
            if (event.start) {
                ids.add(event.id);
                if (ids.size() > rooms) {
                    rooms = ids.size();
                }
            } else {
                ids.remove(event.id);
            }
        }
        return rooms;
    }

}
